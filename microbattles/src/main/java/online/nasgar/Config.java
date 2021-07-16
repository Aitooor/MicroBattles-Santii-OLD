package online.nasgar;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Config {
    
    private static MicroBattles main;

    public Config(MicroBattles main) {
        Config.main = main;

        main.getConfig().options().copyDefaults();
        main.saveDefaultConfig();
    }

    public static int getRequiredPlayers() { return main.getConfig().getInt("required-players"); }

    public static int getCountdownSeconds() { return main.getConfig().getInt("countdown-seconds"); }

    public static Location getlobbySpawn() {
        return new Location(
            Bukkit.getWorld(main.getConfig().getString("lobby-spawn.world")),
            main.getConfig().getDouble("lobby-spawn.x"),
            main.getConfig().getDouble("lobby-spawn.y"),
            main.getConfig().getDouble("lobby-spawn.z"),
            main.getConfig().getInt("yaw"),
            main.getConfig().getInt("pitch"));
    }

    public static Location getAreaSpawn(int id) {
        return new Location (
            Bukkit.getWorld(main.getConfig().getString("arenas." + id + "world")),
            main.getConfig().getDouble("arenas." + id + ".x"),
            main.getConfig().getDouble("arenas." + id + ".y"),
            main.getConfig().getDouble("arenas." + id + ".z"),
            main.getConfig().getInt("arenas." + id + ".yaw"),
            main.getConfig().getInt("arenas." + id + ".world"));
            
    }

    public static int getArenaAmount() { return main.getConfig().getConfigurationSection("arenas.").getKeys(false).size(); }

    public static javax.tools.DocumentationTool.Location getArenaSpawn(int id) {
        return null;
    }
}
