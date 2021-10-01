package online.nasgar.microbattles.game.status.list;

import online.nasgar.microbattles.game.status.GameState;
import online.nasgar.microbattles.game.status.GameStatus;
import online.nasgar.microbattles.map.Map;
import online.nasgar.microbattles.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class WaitingStatus extends GameStatus {
    public WaitingStatus() {
        super(GameState.PLAYING);
    }

    @Override
    public void execute() {

    }

    public void tpPlayerToWaitingLobby(final Player player, final Map map) {
        player.teleport(map.getWaitingLobbyLocation());
        player.sendMessage(ColorUtils.color("&aHas sido tpeado al waiting lobby."));
    }

    public void startCountdown() {
        //todo: countdown
    }
    @Override
    public GameStatus getNextStatus() {
        return new PlayingStatus();
    }
}
