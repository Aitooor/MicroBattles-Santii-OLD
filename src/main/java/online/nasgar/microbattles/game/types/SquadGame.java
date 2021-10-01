package online.nasgar.microbattles.game.types;

import online.nasgar.microbattles.MicroBattles;
import online.nasgar.microbattles.enums.GameType;
import online.nasgar.microbattles.game.GamePlayer;
import online.nasgar.microbattles.game.status.GameState;
import online.nasgar.microbattles.game.status.GameStatus;
import online.nasgar.microbattles.game.status.list.WaitingStatus;
import online.nasgar.microbattles.game.team.Team;
import online.nasgar.microbattles.interfaces.Game;
import online.nasgar.microbattles.map.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class SquadGame extends Game {

    private final HashMap<UUID, GamePlayer> players = new HashMap<>();
    private final List<Team> teams = new ArrayList<>();
    private final Map map;
    private GameStatus gameStatus;

    public SquadGame(final Map map) {
        this.map = map;
        if(map.isEnabled()) {
            this.gameStatus = new WaitingStatus();
        }
    }


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
        map.reset();
    }

    public Map getMap() {
        return map;
    }

    @Override
    public HashMap<UUID, GamePlayer> getPlayers() {
        return players;
    }

    public GameStatus getNextStatus() {
        return gameStatus.getNextStatus();
    }
    @Override
    public void broadcast(String message) {
        super.broadcast(message);
    }
}
