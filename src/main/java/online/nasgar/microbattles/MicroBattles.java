package online.nasgar.microbattles;

import online.nasgar.microbattles.commands.MicroBattlesCommand;
import online.nasgar.microbattles.game.types.SquadGame;
import online.nasgar.microbattles.interfaces.Game;
import online.nasgar.microbattles.listeners.SetupListener;
import online.nasgar.microbattles.managers.GameManager;
import online.nasgar.microbattles.map.Map;
import online.nasgar.microbattles.map.MapManager;
import online.nasgar.microbattles.setup.SetupManager;
import online.nasgar.microbattles.storage.StorageManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public final class MicroBattles extends JavaPlugin implements PluginMessageListener {

    private static MicroBattles instance;
    private boolean isSetupModeEnabled;
    private boolean isLobby;
    private Map selectedMap;
    private Game currentGame;
    private final GameManager gameManager = new GameManager();
    private final SetupManager setupManager = new SetupManager();
    private final StorageManager storageManager = new StorageManager();
    private final MapManager mapManager = new MapManager();
//    private final MySQLFile mySQLFile = new MySQLFile();

    @Override
    public void onEnable() {
        instance = this;
        storageManager.loadConfigs();

        if(!isSetupModeEnabled && !isLobby && storageManager.getFile("arenas.yml").getConfiguration().getBoolean("enabled")) {
            final FileConfiguration config = storageManager.getFile("arenas.yml").getConfiguration();
            mapManager.loadMap(config.getString("server-name"), config.getInt("min-players"), config.getInt("max-players"), true);
            Bukkit.getConsoleSender().sendMessage("The server is in PLAY-MODE. Map " + config.getString("server-name" + " selected to play."));

            this.currentGame = new SquadGame(selectedMap);
        }
//        mySQLFile.connect();
//        if(mySQLFile.isConnected()) mySQLFile.setupSQL();

        registerCommands();
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
        this.isSetupModeEnabled = storageManager.getFile("config.yml").getConfiguration().getBoolean("bungeemode.setup-mode-enabled");
        this.isLobby = storageManager.getFile("config.yml").getConfiguration().getBoolean("bungeemode.is-lobby");

        registerEvents();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll();
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);
//        mySQLFile.disconnect();
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

//    public MySQLFile getMySQLFile() {
//        return mySQLFile;
//    }

    public boolean isLobby() {
        return isLobby;
    }

    public void setSelectedMap(Map selectedMap) {
        this.selectedMap = selectedMap;
    }

    public Map getSelectedMap() {
        return selectedMap;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public StorageManager getStorageManager() {
        return storageManager;
    }
}
