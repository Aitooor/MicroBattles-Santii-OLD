package me.imsanti.microbattles.listeners;

import me.imsanti.microbattles.MicroBattles;
import me.imsanti.microbattles.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SetupListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    private void handleJoin(final PlayerJoinEvent event) {
        if(event.getPlayer().isOp() && MicroBattles.getInstance().isSetupModeEnabled() && !MicroBattles.getInstance().isLobby()) {
            MicroBattles.getInstance().getSetupManager().enableMode(event.getPlayer());
        }else {
            if(!MicroBattles.getInstance().isSetupModeEnabled() && !MicroBattles.getInstance().isLobby() ) {
                event.getPlayer().sendMessage(ColorUtils.color("&eEstas jugando en el mapa " + MicroBattles.getInstance().getSelectedMap().getServerName() + " disfruta."));
            }
        }
    }
}
