-- Tennis League Database Schema
-- Create this database and tables in MySQL before running the application

-- Create the database
CREATE DATABASE IF NOT EXISTS TennisLeague;
USE TennisLeague;

-- Create Teams table
CREATE TABLE IF NOT EXISTS teams (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    manager_name VARCHAR(100) NOT NULL
);

-- Create Coaches table  
CREATE TABLE IF NOT EXISTS coaches (
    coach_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    telephone_number VARCHAR(20),
    team_number INT,
    FOREIGN KEY (team_number) REFERENCES teams(id) ON DELETE SET NULL
);

-- Create Players table
CREATE TABLE IF NOT EXISTS players (
    player_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    position VARCHAR(50),
    age INT CHECK (age >= 16 AND age <= 50),
    team_id INT,
    phone_number VARCHAR(20),
    FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE SET NULL
);

-- Insert sample data for Teams
INSERT INTO teams (id, name, city, manager_name) VALUES
(1, 'Manchester United', 'Manchester', 'Ole Gunnar Solskjær'),
(2, 'Chelsea FC', 'London', 'Thomas Tuchel'),
(3, 'FC Barcelona', 'Barcelona', 'Ronald Koeman'),
(4, 'Bayern Munich', 'Munich', 'Hansi Flick'),
(5, 'Liverpool FC', 'Liverpool', 'Jürgen Klopp'),
(6, 'Paris Saint-Germain', 'Paris', 'Mauricio Pochettino'),
(7, 'Juventus', 'Turin', 'Andrea Pirlo'),
(8, 'Real Madrid', 'Madrid', 'Carlo Ancelotti'),
(9, 'Manchester City', 'Manchester', 'Pep Guardiola'),
(10, 'AC Milan', 'Milan', 'Stefano Pioli');

-- Insert sample data for Coaches
INSERT INTO coaches (coach_id, name, telephone_number, team_number) VALUES
(1, 'John Smith', '555-0101', 1),
(2, 'Maria Garcia', '555-0102', 2),
(3, 'Carlos Rodriguez', '555-0103', 3),
(4, 'Hans Mueller', '555-0104', 4),
(5, 'James Wilson', '555-0105', 5),
(6, 'Pierre Dubois', '555-0106', 6),
(7, 'Giuseppe Rossi', '555-0107', 7),
(8, 'Antonio Lopez', '555-0108', 8),
(9, 'David Brown', '555-0109', 9),
(10, 'Marco Bianchi', '555-0110', 10);

-- Insert sample data for Players
INSERT INTO players (name, position, age, team_id, phone_number) VALUES
-- Manchester United players
('Marcus Rashford', 'Forward', 26, 1, '555-1001'),
('Bruno Fernandes', 'Midfielder', 29, 1, '555-1002'),
('Harry Maguire', 'Defender', 30, 1, '555-1003'),

-- Chelsea FC players  
('Mason Mount', 'Midfielder', 25, 2, '555-2001'),
('Reece James', 'Defender', 24, 2, '555-2002'),
('Timo Werner', 'Forward', 27, 2, '555-2003'),

-- FC Barcelona players
('Pedri', 'Midfielder', 21, 3, '555-3001'),
('Gavi', 'Midfielder', 19, 3, '555-3002'),
('Ronald Araujo', 'Defender', 24, 3, '555-3003'),

-- Bayern Munich players
('Joshua Kimmich', 'Midfielder', 28, 4, '555-4001'),
('Jamal Musiala', 'Midfielder', 21, 4, '555-4002'),
('Alphonso Davies', 'Defender', 23, 4, '555-4003'),

-- Liverpool FC players
('Mohamed Salah', 'Forward', 31, 5, '555-5001'),
('Sadio Mane', 'Forward', 31, 5, '555-5002'),
('Virgil van Dijk', 'Defender', 32, 5, '555-5003'),

-- Paris Saint-Germain players
('Kylian Mbappe', 'Forward', 25, 6, '555-6001'),
('Neymar Jr', 'Forward', 32, 6, '555-6002'),
('Marco Verratti', 'Midfielder', 30, 6, '555-6003'),

-- Juventus players
('Federico Chiesa', 'Forward', 26, 7, '555-7001'),
('Manuel Locatelli', 'Midfielder', 25, 7, '555-7002'),
('Matthijs de Ligt', 'Defender', 24, 7, '555-7003'),

-- Real Madrid players
('Vinicius Jr', 'Forward', 23, 8, '555-8001'),
('Luka Modric', 'Midfielder', 38, 8, '555-8002'),
('Eder Militao', 'Defender', 25, 8, '555-8003'),

-- Manchester City players
('Erling Haaland', 'Forward', 23, 9, '555-9001'),
('Kevin De Bruyne', 'Midfielder', 32, 9, '555-9002'),
('Ruben Dias', 'Defender', 26, 9, '555-9003'),

-- AC Milan players
('Rafael Leao', 'Forward', 24, 10, '555-1001'),
('Sandro Tonali', 'Midfielder', 23, 10, '555-1002'),
('Theo Hernandez', 'Defender', 26, 10, '555-1003');
