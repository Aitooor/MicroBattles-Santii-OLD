package online.nasgar.microbattles.game.types;

import online.nasgar.microbattles.MicroBattles;
import online.nasgar.microbattles.enums.GameType;
import online.nasgar.microbattles.game.GamePlayer;
import online.nasgar.microbattles.game.team.Team;
import online.nasgar.microbattles.interfaces.Game;

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
