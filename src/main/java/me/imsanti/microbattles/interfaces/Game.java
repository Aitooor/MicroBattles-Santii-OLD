package me.imsanti.microbattles.interfaces;

import me.imsanti.microbattles.game.GamePlayer;
import me.imsanti.microbattles.enums.GameType;
import me.imsanti.microbattles.utils.ColorUtils;
import org.bukkit.entity.Player;

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
gi
}
