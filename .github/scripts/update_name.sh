#!/usr/bin/env bash
# This script replaces the name value assignment in wiremock.java with a random name,
# commits the change and pushes it back to the repository using the default origin.

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "$0")/../.." && pwd)"
FILE="$REPO_ROOT/src/test/java/Interview/API_Testing/wiremock.java"

if [ ! -f "$FILE" ]; then
  echo "file not found: $FILE"
  exit 1
fi

# Generate a pseudo-random name (FirstName LastName)
FIRST=(John Jane Alex Sam Riley Casey Taylor Morgan Jordan Peyton)
LAST=(Smith Johnson Brown Lee Wilson Clark Lewis Walker Hall Allen)
FN=${FIRST[$RANDOM % ${#FIRST[@]}]}
LN=${LAST[$RANDOM % ${#LAST[@]}]}
RANDOM_NAME="$FN $LN"

# Use awk to replace the line that sets the name in the map (line containing map.put("name", ... ); )
awk -v name="$RANDOM_NAME" '{
  if ($0 ~ /map\.put\("name"/) {
    # replace the entire map.put("name","<anything>"); expression with the new name
    sub(/map\.put\(\"name\",\"[^\"]*\"\);/, "map.put(\"name\",\"" name "\");")
  }
  print
}' "$FILE" > "$FILE.tmp" && mv "$FILE.tmp" "$FILE"

cd "$REPO_ROOT"

# Ensure we have commit author info from environment (set these in the workflow as secrets)
# GIT_COMMIT_NAME and GIT_COMMIT_EMAIL should be provided by the workflow; fall back to github-actions[bot] if not set.
GIT_AUTHOR_NAME="${GIT_COMMIT_NAME:-github-actions[bot]}"
GIT_AUTHOR_EMAIL="${GIT_COMMIT_EMAIL:-github-actions[bot]@users.noreply.github.com}"

# Only proceed if there are changes
if [ -n "$(git status --porcelain)" ]; then
  # Determine default branch name of the remote (origin)
  DEFAULT_BRANCH=$(git remote show origin | sed -n 's/.*HEAD branch: //p')
  DEFAULT_BRANCH=${DEFAULT_BRANCH:-main}

  # Commit message in the format: Commit on YYYY-MM-DD (UTC)
  COMMIT_MSG="Commit on $(date -u +%Y-%m-%d)"

  # Use UTC timestamps for author and committer dates so contributions line up correctly
  export GIT_AUTHOR_DATE="$(date -u +%Y-%m-%dT%H:%M:%SZ)"
  export GIT_COMMITTER_DATE="$(date -u +%Y-%m-%dT%H:%M:%SZ)"

  # Stage, commit with explicit author, and push to the default branch
  git add -A
  git commit -m "$COMMIT_MSG" --author="$GIT_AUTHOR_NAME <$GIT_AUTHOR_EMAIL>"

  # Push to the detected default branch
  git push origin HEAD:"$DEFAULT_BRANCH"
else
  echo "No changes to commit"
fi
