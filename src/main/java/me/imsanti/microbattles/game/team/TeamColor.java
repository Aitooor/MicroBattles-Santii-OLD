package me.imsanti.microbattles.game.team;

import org.bukkit.ChatColor;

public enum TeamColor {

    BLUE,
    RED,
    GREEN,
    YELLOW;

    public ChatColor getColor() {
        return ChatColor.valueOf(this.toString());
    }
}
