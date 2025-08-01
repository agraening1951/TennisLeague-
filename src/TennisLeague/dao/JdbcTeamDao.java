package TennisLeague.dao;

import TennisLeague.model.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTeamDao implements TeamDao {
    private final Connection connection;

    public JdbcTeamDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addTeam(Team team) {
        String sql = "INSERT INTO teams (id, name, city, manager_name) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, team.getId());
            ps.setString(2, team.getName());
            ps.setString(3, team.getCity());
            ps.setString(4, team.getManagerName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding team", e);
        }
    }

    @Override
    public List<Team> getAllTeams() {
        String sql = "SELECT * FROM teams";
        List<Team> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving teams", e);
        }
        return list;
    }

    @Override
    public void updateTeam(Team team) {
        String sql = "UPDATE teams SET name = ?, city = ?, manager_name = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, team.getName());
            ps.setString(2, team.getCity());
            ps.setString(3, team.getManagerName());
            ps.setInt(4, team.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating team", e);
        }
    }

    @Override
    public void deleteTeam(int id) {
        String sql = "DELETE FROM teams WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting team", e);
        }
    }

    private Team mapRow(ResultSet rs) throws SQLException {
        return new Team(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("city"),
                rs.getString("manager_name"));
    }
}