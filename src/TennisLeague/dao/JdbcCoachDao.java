package TennisLeague.dao;

import TennisLeague.model.Coach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcCoachDao implements CoachDao {
    private final Connection connection;

    public JdbcCoachDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addCoach(Coach coach) {
        String sql = "INSERT INTO Coach (CoachID, Name, TelephoneNumber, TeamNumber) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, coach.getCoachId());
            ps.setString(2, coach.getName());
            ps.setString(3, coach.getTelephoneNumber());
            ps.setInt(4, coach.getTeamNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding coach", e);
        }
    }

    @Override
    public Coach findById(int id) {
        String sql = "SELECT * FROM Coach WHERE CoachID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? mapRow(rs) : null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding coach", e);
        }
    }

    @Override
    public List<Coach> findAll() {
        String sql = "SELECT * FROM Coach";
        List<Coach> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving coaches", e);
        }
        return list;
    }

    @Override
    public void updateCoach(Coach coach) {
        String sql = "UPDATE Coach SET Name = ?, TelephoneNumber = ?, TeamNumber = ? WHERE CoachID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, coach.getName());
            ps.setString(2, coach.getTelephoneNumber());
            ps.setInt(3, coach.getTeamNumber());
            ps.setInt(4, coach.getCoachId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating coach", e);
        }
    }

    @Override
    public void deleteCoach(int id) {
        String sql = "DELETE FROM Coach WHERE CoachID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting coach", e);
        }
    }

    private Coach mapRow(ResultSet rs) throws SQLException {
        return new Coach(
                rs.getInt("CoachID"),
                rs.getString("Name"),
                rs.getString("TelephoneNumber"),
                rs.getInt("TeamNumber")
        );
    }
}