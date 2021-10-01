package online.nasgar.microbattles.listeners;

import online.nasgar.microbattles.MicroBattles;
import online.nasgar.microbattles.enums.GameType;
import online.nasgar.microbattles.game.status.GameState;
import online.nasgar.microbattles.game.status.list.WaitingStatus;
import online.nasgar.microbattles.game.types.SquadGame;
import online.nasgar.microbattles.interfaces.Game;
import online.nasgar.microbattles.map.Map;
import online.nasgar.microbattles.utils.ColorUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SetupListener implements Listener {

    private boolean debug = true;

    @EventHandler(priority = EventPriority.MONITOR)
    private void handleJoin(final PlayerJoinEvent event) {
        if(event.getPlayer().isOp() && MicroBattles.getInstance().isSetupModeEnabled() && !MicroBattles.getInstance().isLobby()) {
            MicroBattles.getInstance().getSetupManager().enableMode(event.getPlayer());
        }else {
            if(!MicroBattles.getInstance().isSetupModeEnabled() && !MicroBattles.getInstance().isLobby()){
                final GameType gameType = MicroBattles.getInstance().getCurrentGame().getType();

                if(!(gameType == GameType.SQUAD)) return;

                final SquadGame squadGame = (SquadGame)  MicroBattles.getInstance().getCurrentGame();
                if(!(squadGame.getGameStatus().getGameState() == GameState.WAITING)) {
                  if(!debug) {
                      event.getPlayer().kickPlayer("No te puedes unir a este juego actualmente.");
                      return;
                  }

                  final WaitingStatus waitingStatus = (WaitingStatus) squadGame.getGameStatus();
                  waitingStatus.tpPlayerToWaitingLobby(event.getPlayer(), MicroBattles.getInstance().getSelectedMap());
                }
            }
        }
    }
}
