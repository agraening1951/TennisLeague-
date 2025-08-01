package TennisLeague.setup;

import TennisLeague.DB.DBConnection;
import java.sql.Connection;
import java.sql.Statement;

public class CreatePlayersTable {
    public static void main(String[] args) {
        try (Connection connection = DBConnection.getConnection();
                Statement stmt = connection.createStatement()) {

            System.out.println("Creating players table...");

            // Create players table
            String createTableSQL = """
                    CREATE TABLE IF NOT EXISTS players (
                        player_id INT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(100) NOT NULL,
                        position VARCHAR(50),
                        age INT CHECK (age >= 16 AND age <= 50),
                        team_id INT,
                        phone_number VARCHAR(20),
                        FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE SET NULL
                    )
                    """;

            stmt.executeUpdate(createTableSQL);
            System.out.println("Players table created successfully!");

            // Insert sample data
            String insertSQL = """
                    INSERT INTO players (name, position, age, team_id, phone_number) VALUES
                    ('Marcus Rashford', 'Forward', 26, 1, '555-1001'),
                    ('Bruno Fernandes', 'Midfielder', 29, 1, '555-1002'),
                    ('Harry Maguire', 'Defender', 30, 1, '555-1003'),
                    ('Mason Mount', 'Midfielder', 25, 2, '555-2001'),
                    ('Reece James', 'Defender', 24, 2, '555-2002'),
                    ('Timo Werner', 'Forward', 27, 2, '555-2003'),
                    ('Pedri', 'Midfielder', 21, 3, '555-3001'),
                    ('Gavi', 'Midfielder', 19, 3, '555-3002'),
                    ('Ronald Araujo', 'Defender', 24, 3, '555-3003'),
                    ('Joshua Kimmich', 'Midfielder', 28, 4, '555-4001'),
                    ('Jamal Musiala', 'Midfielder', 21, 4, '555-4002'),
                    ('Alphonso Davies', 'Defender', 23, 4, '555-4003'),
                    ('Mohamed Salah', 'Forward', 31, 5, '555-5001'),
                    ('Sadio Mane', 'Forward', 31, 5, '555-5002'),
                    ('Virgil van Dijk', 'Defender', 32, 5, '555-5003')
                    """;

            stmt.executeUpdate(insertSQL);
            System.out.println("Sample player data inserted successfully!");

            // Verify
            var rs = stmt.executeQuery("SELECT COUNT(*) as count FROM players");
            if (rs.next()) {
                System.out.println("Total players in database: " + rs.getInt("count"));
            }

            System.out.println("Setup complete! You can now use the player management features.");

        } catch (Exception e) {
            System.err.println("Error creating players table: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
