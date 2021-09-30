package online.nasgar.microbattles.storage.list;

import online.nasgar.microbattles.MicroBattles;
import online.nasgar.microbattles.storage.CoreFile;
import online.nasgar.microbattles.storage.DataType;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigFile extends CoreFile {

    private final MicroBattles microBattles = MicroBattles.getInstance();

    final File file = new File(Bukkit.getPluginManager().getPlugin("MicroBattles").getDataFolder(), "config.yml");
    FileConfiguration configFile = null;

    public ConfigFile() {
        super("config.yml", DataType.FILE);
    }

    @Override
    public FileConfiguration create() {
        if(!exists()) {
            try {
                microBattles.saveResource(getFileName(), false);
                Bukkit.getConsoleSender().sendMessage("File " + getFile() + " created successfully.");
            }catch(Exception exception) {
                Bukkit.getConsoleSender().sendMessage("File " + getFile() + " detected an exception while creating.");
                Bukkit.getConsoleSender().sendMessage("Printing exception to debug...");
                exception.printStackTrace();
                return null;
            }
        }

        configFile = new YamlConfiguration();
        try {
            configFile.load(file);
            Bukkit.getConsoleSender().sendMessage("Loaded file.");
        }catch (Exception exception) {
            exception.printStackTrace();
            return configFile;
        }
        return null;
    }

    @Override
    public boolean exists() {
        return file.exists();
    }

    @Override
    public FileConfiguration getConfiguration() {
        return configFile;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public void save() {
        try {
            configFile.save(file);
        }catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public void writeToConfig(ConfigurationSection section, String path, String value) {
        super.writeToConfig(section, path, value);
    }

    @Override
    public void addValueStringList(ConfigurationSection section, String listName, String valueToAdd) {
        super.addValueStringList(section, listName, valueToAdd);
    }

    @Override
    public ConfigurationSection getSection(String sectionName) {
        return super.getSection(sectionName);
    }


    @Override
    public FileConfiguration load() {
        return create();
    }
}