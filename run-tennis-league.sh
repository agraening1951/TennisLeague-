#!/bin/bash
# Tennis League Application Runner

cd "$(dirname "$0")"

echo "Starting Tennis League Management System..."
echo "Make sure MySQL is running and the TennisLeague database exists."
echo ""

java -cp "target/classes:target/dependency/*" TennisLeague.main.Main
