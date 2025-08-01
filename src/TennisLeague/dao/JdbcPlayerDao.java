package TennisLeague.dao;

import TennisLeague.model.Player;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcPlayerDao implements PlayerDao {
    private Connection connection;

    public JdbcPlayerDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM players";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Player player = new Player();
                player.setPlayerId(rs.getInt("player_id"));
                player.setName(rs.getString("name"));
                player.setPosition(rs.getString("position"));
                player.setAge(rs.getInt("age"));
                player.setTeamId(rs.getInt("team_id"));
                player.setPhoneNumber(rs.getString("phone_number"));
                players.add(player);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving players: " + e.getMessage());
        }

        return players;
    }

    @Override
    public Player getPlayerById(int playerId) {
        String sql = "SELECT * FROM players WHERE player_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, playerId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Player player = new Player();
                player.setPlayerId(rs.getInt("player_id"));
                player.setName(rs.getString("name"));
                player.setPosition(rs.getString("position"));
                player.setAge(rs.getInt("age"));
                player.setTeamId(rs.getInt("team_id"));
                player.setPhoneNumber(rs.getString("phone_number"));
                return player;
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving player: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Player> getPlayersByTeamId(int teamId) {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM players WHERE team_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, teamId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Player player = new Player();
                player.setPlayerId(rs.getInt("player_id"));
                player.setName(rs.getString("name"));
                player.setPosition(rs.getString("position"));
                player.setAge(rs.getInt("age"));
                player.setTeamId(rs.getInt("team_id"));
                player.setPhoneNumber(rs.getString("phone_number"));
                players.add(player);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving players by team: " + e.getMessage());
        }

        return players;
    }

    @Override
    public void addPlayer(Player player) {
        String sql = "INSERT INTO players (name, position, age, team_id, phone_number) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, player.getName());
            stmt.setString(2, player.getPosition());
            stmt.setInt(3, player.getAge());
            stmt.setInt(4, player.getTeamId());
            stmt.setString(5, player.getPhoneNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding player: " + e.getMessage());
        }
    }

    @Override
    public void updatePlayer(Player player) {
        String sql = "UPDATE players SET name = ?, position = ?, age = ?, team_id = ?, phone_number = ? WHERE player_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, player.getName());
            stmt.setString(2, player.getPosition());
            stmt.setInt(3, player.getAge());
            stmt.setInt(4, player.getTeamId());
            stmt.setString(5, player.getPhoneNumber());
            stmt.setInt(6, player.getPlayerId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating player: " + e.getMessage());
        }
    }

    @Override
    public void deletePlayer(int playerId) {
        String sql = "DELETE FROM players WHERE player_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, playerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting player: " + e.getMessage());
        }
    }
}
