# Tennis League Management System

## Project Status ✅

Your Tennis League Management System now **FULLY MEETS** all the specified requirements:

### ✅ Database Setup - COMPLETE
- **Teams Table**: ✅ Implemented with proper relationships
- **Players Table**: ✅ Implemented with team associations  
- **Coaches Table**: ✅ Implemented with team associations
- **Relationships & Constraints**: ✅ Foreign keys and proper constraints set

### ✅ Team Management - COMPLETE
- **Add a Team**: ✅ Users can add new team records
- **Edit a Team**: ✅ Users can update team details
- **Delete a Team**: ✅ Users can remove teams
- **View Teams**: ✅ Users can view all teams with details

### ✅ Player Management - COMPLETE
- **Add a Player**: ✅ Users can add players with team associations
- **Edit a Player**: ✅ Users can update player details
- **Delete a Player**: ✅ Users can remove players
- **View Players**: ✅ Users can view all players and filter by team

### ✅ Coach Management - COMPLETE  
- **Add a Coach**: ✅ Users can add coaches with team specifications
- **Edit a Coach**: ✅ Users can update coach details
- **Delete a Coach**: ✅ Users can remove coaches
- **View Coaches**: ✅ Users can view all coaches with details

## How to Run

### 1. Database Setup
First, set up your MySQL database:

```bash
# Connect to MySQL
mysql -u root -p

# Run the setup script
source /Users/johnhashim/Desktop/NU/TennisLeague-/database_setup.sql
```

### 2. Run the Application
```bash
cd /Users/johnhashim/Desktop/NU/TennisLeague-
java -cp "target/classes:target/dependency/*" TennisLeague.main.Main
```

Or use the convenience script:
```bash
./run-tennis-league.sh
```

## Application Features

### Main Menu Options:
1. **View all teams** - Display all team records
2. **Add a team** - Create new team with manager
3. **Update a team** - Modify existing team details
4. **Delete a team** - Remove team from database
5. **View all coaches** - Display all coach records
6. **Add a coach** - Create new coach with team assignment
7. **Update a coach** - Modify existing coach details
8. **Delete a coach** - Remove coach from database
9. **View all players** - Display all player records
10. **Add a player** - Create new player with team assignment
11. **Update a player** - Modify existing player details
12. **Delete a player** - Remove player from database
13. **View players by team** - Filter players by specific team
0. **Exit** - Close the application

## Database Schema

### Teams Table
- `id` (Primary Key, Auto Increment)
- `name` (Team Name)
- `city` (Team City)
- `manager_name` (Team Manager)

### Players Table
- `player_id` (Primary Key, Auto Increment)
- `name` (Player Name)
- `position` (Playing Position)
- `age` (Player Age, 16-50)
- `team_id` (Foreign Key to Teams)
- `phone_number` (Contact Number)

### Coaches Table
- `coach_id` (Primary Key, Auto Increment)
- `name` (Coach Name)
- `telephone_number` (Contact Number)
- `team_number` (Foreign Key to Teams)
