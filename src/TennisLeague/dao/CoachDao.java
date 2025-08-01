package TennisLeague.dao;

import TennisLeague.model.Coach;
import java.util.List;

public interface CoachDao {
    List<Coach> findAll();
    Coach findById(int id);

    void addCoach(Coach coach);
    void updateCoach(Coach coach);
    void deleteCoach(int id);
}