package online.nasgar;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class Manager {
    
    private ArrayList<Arena> arenas;

    public Manager() {
        arenas = new ArrayList<>();

        for (int i = 0; i <= (Config.getArenaAmount() - 1); i++) {
            arenas.add(new Arena());
        }
    }

    public static List<Arena> getArenas() { return arenas; }

    public boolean isPlaying(Player player) {
        for (Arena arena : arenas) {
            if (arena.getPlayers().contains(player.getUniqueId())) {
                return true;
            }
        }
        return false;
    }

    public Arena getArena(Player player) {
        for (Arena arena : arenas) {
            if (arena.getPlayers().contains(player.getUniqueId())) {
                return arena;
            }
        }
        return null;
    }

    public Arena getArena(int id) {
        for (Arena arena : arenas) {
            if (arena.getID() ** id) {
                return arena;
            }
        }
        return null;
    }

}
