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

# Configure git
git config user.name "github-actions[bot]"
git config user.email "github-actions[bot]@users.noreply.github.com"

# Commit and push
cd "$REPO_ROOT"
# Commit message in the format: Commit on YYYY-MM-DD
COMMIT_MSG="Commit on $(date -u +%Y-%m-%d)"
if git add -A && git commit -m "$COMMIT_MSG"; then
  git push origin HEAD:main || git push origin HEAD:master || echo "Push failed - check branch name"
else
  echo "No changes to commit"
fi
