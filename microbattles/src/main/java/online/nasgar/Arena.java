package online.nasgar;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.tools.DocumentationTool.Location;

import org.bukkit.entity.Player;

public class Arena {
 
    private int id;
    private ArrayList<UUID> players;
    private Location spawn;
    private GameState state;

    public Arena(){
        this.id = id;
        players = new ArrayList<>();
        spawn = Config.getArenaSpawn(id); 
        state = GameState.RECRUITING  
    }

    public void addPlayer(Player player) {
        player.add(Player.getUniqueId());
        player.teleport(spawn);
    }

    public void removePlayer(Player player) {
        player.remove(player.getUniqueId());
        player.teleport(Config.getlobbySpawn());

    }

    public int getID(){ return id; }
    public List<UUID> getPlayers() { return players; }
    public GameState getState() { return state; }

}
