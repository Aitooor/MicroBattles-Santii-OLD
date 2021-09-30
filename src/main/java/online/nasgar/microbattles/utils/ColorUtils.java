package online.nasgar.microbattles.utils;

import org.bukkit.ChatColor;

public class ColorUtils {

    public static String color(final String color) {
        return ChatColor.translateAlternateColorCodes('&', color);
    }
}
