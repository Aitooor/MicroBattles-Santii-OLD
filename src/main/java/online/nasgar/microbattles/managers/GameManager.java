package online.nasgar.microbattles.managers;

import online.nasgar.microbattles.interfaces.Game;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private final List<Game> loadedGames = new ArrayList<>();

    public void loadGame(final Game game) {
        loadedGames.add(game);
    }
}

