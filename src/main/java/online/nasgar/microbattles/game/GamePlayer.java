package online.nasgar.microbattles.game;

import online.nasgar.microbattles.interfaces.Game;
import org.bukkit.entity.Player;

public class GamePlayer {

    private Game currentGame;
    private final Player player;

    public GamePlayer(final Player player) {
        this.currentGame = null;
        this.player = player;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    private boolean isInGame() {
        return currentGame != null;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public Player getPlayer() {
        return player;
    }
}
