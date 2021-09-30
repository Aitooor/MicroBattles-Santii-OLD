package online.nasgar.microbattles.interfaces;

import online.nasgar.microbattles.game.GamePlayer;
import online.nasgar.microbattles.enums.GameType;
import online.nasgar.microbattles.utils.ColorUtils;

import java.util.Map;
import java.util.UUID;

public abstract class Game {

    public abstract void addPlayer(final GamePlayer gamePlayer);
    public abstract GameType getType();
    public abstract void startGame();
    public abstract void endGame();
    public abstract Map<UUID, GamePlayer> getPlayers();
    public void broadcast(final String message) {
        getPlayers().keySet().forEach(player -> {
            getPlayers().get(player).getPlayer().sendMessage(ColorUtils.color(message));
        });
    }
}
