#!/bin/bash
# Script to create the players table

echo "Creating players table in TennisLeague database..."
echo "Please enter your MySQL root password when prompted."

# Try different possible MySQL client locations
if command -v mysql &> /dev/null; then
    mysql -u root -p TennisLeague < create_players_table.sql
elif command -v /usr/local/mysql/bin/mysql &> /dev/null; then
    /usr/local/mysql/bin/mysql -u root -p TennisLeague < create_players_table.sql
elif command -v /opt/homebrew/bin/mysql &> /dev/null; then
    /opt/homebrew/bin/mysql -u root -p TennisLeague < create_players_table.sql
else
    echo "MySQL client not found. Please use MySQL Workbench instead."
    echo "1. Open MySQL Workbench"
    echo "2. Connect to localhost:3306 with username 'root' and password 'mukaminega'"
    echo "3. Run the script in create_players_table.sql"
fi
