package me.imsanti.microbattles.game.team;

import org.bukkit.ChatColor;

import java.awt.*;

public enum TeamColor {

    BLUE(),
    RED,
    GREEN,
    YELLOW;

    public ChatColor getColor() {
        return ChatColor.valueOf(this.toString());
    }
}
