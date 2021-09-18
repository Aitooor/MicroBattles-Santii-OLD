package me.imsanti.microbattles.setup;

import me.imsanti.microbattles.utils.ColorUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SetupManager {

    private final List<UUID> modePlayers = new ArrayList<>();

    public void enableMode(final Player player) {
        modePlayers.add(player.getUniqueId());
        giveItems(player);

        player.sendMessage(ColorUtils.color("&cAhora estas en el Modo Setup."));
    }

    private void giveItems(final Player player) {
        final ItemStack itemStack = new ItemStack(Material.DIAMOND);
        player.getInventory().setItem(1, itemStack);
    }
}
