package TennisLeague.dao;

import TennisLeague.model.Team;
import java.sql.SQLException;
import java.util.List;

public interface TeamDao {
    List<Team> getAllTeams();
    void addTeam(Team team);
    void updateTeam(Team team);
    void deleteTeam(int id);
}