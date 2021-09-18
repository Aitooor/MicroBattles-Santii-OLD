package me.imsanti.microbattles.listeners;

import me.imsanti.microbattles.MicroBattles;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SetupListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    private void handleJoin(final PlayerJoinEvent event) {
        if(event.getPlayer().isOp() && MicroBattles.getInstance().isSetupModeEnabled()) {
            MicroBattles.getInstance().getSetupManager().enableMode(event.getPlayer());
        }
    }
}
