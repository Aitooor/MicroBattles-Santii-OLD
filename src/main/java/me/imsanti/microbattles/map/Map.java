package me.imsanti.microbattles.map;

import me.imsanti.microbattles.game.team.Team;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private int minPlayers;
    private int maxPlayers;
    private String serverName;
    private List<Team> createdTeams = new ArrayList<>();

    public Map(final int minPlayers, final int maxPlayers, final String serverName, final List<Team> createdTeams) {
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.serverName = serverName;
        this.createdTeams = createdTeams;
    }

    public void reset() {

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
            if(team.toString().equalsIgnoreCase(teamName)) {
                return team;
            }
        }

        return null;
    }

    public void updateDataToMySQL() {
        
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
