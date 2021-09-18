package me.imsanti.microbattles.game.team;


import org.bukkit.Location;

import javax.annotation.Nullable;

public class Team {

    private final TeamColor teamColor;
    private @Nullable Location location;

    public Team(final TeamColor teamColor, final Location location) {
        this.teamColor = teamColor;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
