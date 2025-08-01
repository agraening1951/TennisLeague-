package TennisLeague.dao;

import TennisLeague.model.Player;
import java.util.List;

public interface PlayerDao {
    List<Player> getAllPlayers();

    Player getPlayerById(int playerId);

    List<Player> getPlayersByTeamId(int teamId);

    void addPlayer(Player player);

    void updatePlayer(Player player);

    void deletePlayer(int playerId);
}
