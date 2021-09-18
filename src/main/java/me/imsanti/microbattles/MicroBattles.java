package me.imsanti.microbattles;

import me.imsanti.microbattles.commands.MicroBattlesCommand;
import me.imsanti.microbattles.listeners.SetupListener;
import me.imsanti.microbattles.managers.GameManager;
import me.imsanti.microbattles.map.MapManager;
import me.imsanti.microbattles.setup.SetupManager;
import me.imsanti.microbattles.storage.StorageManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public final class MicroBattles extends JavaPlugin implements PluginMessageListener {

    private static MicroBattles instance;
    private boolean isSetupModeEnabled;

    private final GameManager gameManager = new GameManager();
    private final SetupManager setupManager = new SetupManager();
    private final StorageManager storageManager = new StorageManager();
    private final MapManager mapManager = new MapManager();

    @Override
    public void onEnable() {
        instance = this;
        registerCommands();
        storageManager.loadConfigs();
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
        this.isSetupModeEnabled = storageManager.getFile("config.yml").getConfiguration().getBoolean("bungeemode.setup-mode-enabled");
        registerEvents();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);
        // Plugin shutdown logic
    }

    public static MicroBattles getInstance() {
        return instance;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    private void registerCommands() {
        getCommand("microbattles").setExecutor(new MicroBattlesCommand());
        Bukkit.getConsoleSender().sendMessage("[Command-Manager] Registering /microbattles command.");
    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new SetupListener(), this);
        Bukkit.getConsoleSender().sendMessage("[Event-Manager] Registering SetupListener event");

    }
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {

    }

    public boolean isSetupModeEnabled() {
        return isSetupModeEnabled;
    }

    public SetupManager getSetupManager() {
        return setupManager;
    }

    public MapManager getMapManager() {
        return mapManager;
    }

    public StorageManager getStorageManager() {
        return storageManager;
    }
}
