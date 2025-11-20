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

# Resolve commit author/email from environment; fall back to GITHUB_ACTOR and sensible defaults.
# For contributions to count for your account, set GIT_COMMIT_NAME and GIT_COMMIT_EMAIL in the workflow
# to match your GitHub account name and a verified email on your account.
GIT_AUTHOR_NAME="${GIT_COMMIT_NAME:-${GITHUB_ACTOR:-github-actions[bot]}}"
GIT_AUTHOR_EMAIL="${GIT_COMMIT_EMAIL:-${GITHUB_ACTOR:-github-actions[bot]}@users.noreply.github.com}"

# Ensure git has a committer identity (prevents "Please tell me who you are" failures)
# Configure locally (no --global) so we don't affect the runner environment.
git config user.name "$GIT_AUTHOR_NAME"
git config user.email "$GIT_AUTHOR_EMAIL"

# Export author/committer env vars so git uses them non-interactively
export GIT_AUTHOR_NAME
export GIT_AUTHOR_EMAIL
export GIT_COMMITTER_NAME="$GIT_AUTHOR_NAME"
export GIT_COMMITTER_EMAIL="$GIT_AUTHOR_EMAIL"

# Use perl to perform an in-place (safe) replacement of the map.put("name", "..."); line.
# This avoids awk regexp escape warnings and is robust against different whitespace.
perl -0777 -pe 's/map\.put\(\s*"name"\s*,\s*"[^"]*"\s*\);/map.put("name","'"$RANDOM_NAME"'"\);/gs' "$FILE" > "$FILE.tmp" && mv "$FILE.tmp" "$FILE"

cd "$REPO_ROOT"

# Only proceed if there are changes
if [ -n "$(git status --porcelain)" ]; then
  # Determine default branch name of the remote (origin)
  DEFAULT_BRANCH=$(git remote show origin | sed -n 's/.*HEAD branch: //p')
  DEFAULT_BRANCH=${DEFAULT_BRANCH:-main}

  # Commit message in the format: Commit on YYYY-MM-DD (UTC)
  COMMIT_MSG="Commit on $(date -u +%Y-%m-%d)"

  # Use UTC timestamps for author and committer dates so contributions line up correctly
  GIT_AUTHOR_DATE="$(date -u +%Y-%m-%dT%H:%M:%SZ)"
  GIT_COMMITTER_DATE="$(date -u +%Y-%m-%dT%H:%M:%SZ)"
  export GIT_AUTHOR_DATE
  export GIT_COMMITTER_DATE

  # Stage, commit with explicit author, and push to the default branch
  git add -A
  git commit -m "$COMMIT_MSG" --author="$GIT_AUTHOR_NAME <$GIT_AUTHOR_EMAIL>"

  # Push to the detected default branch
  git push origin HEAD:"$DEFAULT_BRANCH"
else
  echo "No changes to commit"
fi
