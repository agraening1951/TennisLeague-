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
        String sql = "INSERT INTO coaches (coach_id, name, telephone_number, team_number) VALUES (?, ?, ?, ?)";
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
        String sql = "SELECT * FROM coaches WHERE coach_id = ?";
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
        List<Coach> coaches = new ArrayList<>();
        String sql = "SELECT coach_id, name, telephone_number, team_number FROM coaches";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Coach coach = new Coach();
                coach.setCoachId(rs.getInt("coach_id"));
                coach.setName(rs.getString("name"));
                coach.setTelephoneNumber(rs.getString("telephone_number"));
                coach.setTeamNumber(rs.getInt("team_number"));
                coaches.add(coach);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving coaches", e);
        }
        
        return coaches;
    }

    @Override
    public void updateCoach(Coach coach) {
        String sql = "UPDATE coaches SET name = ?, telephone_number = ?, team_number = ? WHERE coach_id = ?";
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
    public void deleteCoach(int coachId) {
        String sql = "DELETE FROM coaches WHERE coach_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, coachId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting coach", e);
        }
    }

    private Coach mapRow(ResultSet rs) throws SQLException {
        return new Coach(
                rs.getInt("coach_id"),
                rs.getString("name"),
                rs.getString("telephone_number"),
                rs.getInt("team_number")
        );
    }
}