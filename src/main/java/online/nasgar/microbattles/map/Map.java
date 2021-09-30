package online.nasgar.microbattles.map;

import online.nasgar.microbattles.MicroBattles;
import online.nasgar.microbattles.game.team.Team;
import online.nasgar.microbattles.game.team.TeamColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map {

    private int minPlayers;
    private int maxPlayers;
    private boolean isEnabled;
    private String serverName;
    private List<Team> createdTeams = new ArrayList<>();

    public Map(final int minPlayers, final int maxPlayers, final String serverName, final List<Team> createdTeams, final boolean isEnabled) {
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.serverName = serverName;
        this.createdTeams = createdTeams;
        this.isEnabled = isEnabled;

        if(isEnabled) {
            final FileConfiguration config = MicroBattles.getInstance().getStorageManager().getFile("arenas.yml").getConfiguration();

            for(final String string : config.getConfigurationSection("teams").getKeys(false)) {
                final ConfigurationSection teamSection = config.getConfigurationSection("teams." + string.toUpperCase());

                final Team foundTeam = new Team(TeamColor.valueOf(string.toUpperCase()), new Location(Bukkit.getWorld(teamSection.getString("world-name")), teamSection.getDouble("x"), teamSection.getDouble("y"), teamSection.getDouble("z")));
                createdTeams.add(foundTeam);
                Bukkit.getConsoleSender().sendMessage("Loaded team " + string + " successfully into loaded teams list.");
            }
        }

        MicroBattles.getInstance().setSelectedMap(this);
    }

    public void reset() {

    }

    public void updateMapToConfig() {
        final FileConfiguration config = MicroBattles.getInstance().getStorageManager().getFile("arenas.yml").getConfiguration();

        config.set("min-players", minPlayers);
        config.set("max-players", maxPlayers);
        config.set("server-name", serverName);
        config.set("enabled", isEnabled);
        createdTeams.forEach(team -> {
            config.createSection("teams." + team.getTeamColor().name().toUpperCase());
            if(!(team.getLocation() == null)) {
                final ConfigurationSection section = config.getConfigurationSection("teams." + team.getTeamColor().name().toUpperCase());
                section.set("x", team.getLocation().getX());
                section.set("y", team.getLocation().getY());
                section.set("z", team.getLocation().getZ());
                section.set("world-name", team.getLocation().getWorld().getName());

            }
        });

        try {
            config.save(MicroBattles.getInstance().getStorageManager().getFile("arenas.yml").getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }


    public Team getTeamByName(final String teamName) {
        for(final Team team : createdTeams) {
            if(team.getTeamColor().getColor().name().equalsIgnoreCase(teamName)) {
                return team;
            }
        }

        return null;
    }

    public void updateDataToMySQL() {
        
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public List<Team> getCreatedTeams() {
        return createdTeams;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public String getServerName() {
        return serverName;
    }
}
