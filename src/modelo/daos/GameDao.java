package modelo.daos;

import java.util.List;
import java.util.Map;

import modelo.beans.Game;

public interface GameDao {
	int insert(Game game);
    Game findById(int gameId);
    List<Game> query(Map<String,Object> parameters);
    List<Game> findAll();
    int update(Game game);
    int delete(Game game);
}
