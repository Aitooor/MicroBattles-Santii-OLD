package me.imsanti.microbattles;

import me.imsanti.microbattles.managers.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MicroBattles extends JavaPlugin {

    private static MicroBattles instance;

    private final GameManager gameManager = new GameManager();

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MicroBattles getInstance() {
        return instance;
    }

    public GameManager getGameManager() {
        return gameManager;
    }
}
