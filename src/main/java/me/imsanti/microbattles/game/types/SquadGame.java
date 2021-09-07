package me.imsanti.microbattles.game.types;

import me.imsanti.microbattles.MicroBattles;
import me.imsanti.microbattles.enums.GameType;
import me.imsanti.microbattles.game.GamePlayer;
import me.imsanti.microbattles.game.team.Team;
import me.imsanti.microbattles.interfaces.Game;
import org.bukkit.entity.Player;

import java.util.*;

public class SquadGame extends Game {

    private final Map<UUID, GamePlayer> players = new HashMap<>();
    private final List<Team> teams = new ArrayList<>();

    @Override
    public void addPlayer(final GamePlayer gamePlayer) {
        gamePlayer.setCurrentGame(this);
        players.put(gamePlayer.getPlayer().getUniqueId(), gamePlayer);

        //todo: teleport player to waiting lobby.
    }

    @Override
    public GameType getType() {
        return GameType.SQUAD;
    }

    @Override
    public void startGame() {
        MicroBattles.getInstance().getGameManager().loadGame(this);
    }

    @Override
    public void endGame() {

    }

    @Override
    public Map<UUID, GamePlayer> getPlayers() {
        return null;
    }

    @Override
    public void broadcast(String message) {
        super.broadcast(message);
    }
}
