package me.imsanti.microbattles.storage;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class CoreFile {

    private final String fileName;
    private final DataType dataType;

    public CoreFile(final String fileName, final DataType dataType) {
        this.fileName = fileName;
        this.dataType = dataType;
    }
    protected abstract FileConfiguration create();
    public abstract boolean exists();
    public abstract FileConfiguration getConfiguration();
    public abstract File getFile();
    public abstract void save();
    public abstract FileConfiguration load();
    public void writeToConfig(final ConfigurationSection section, final String path, final String value) {
        section.set(path, value);
    }

    public void addValueStringList(final ConfigurationSection section, final String listName, final String valueToAdd) {

        try {
            if(section.getStringList(listName).size() == 0) {
                //no existe la lista?
                final List<String> newList = new ArrayList<>();
                newList.add(valueToAdd);
                section.set(listName, newList);
                return;
            }

            //existe?
            final List<String> values = section.getStringList(listName);
            values.add(valueToAdd);
            section.set(listName, values);
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public ConfigurationSection getSection(final String sectionName) {
        return getConfiguration().getConfigurationSection(sectionName);
    }

    public List<String> getStringList(final String listName, final ConfigurationSection section) {
        return section.getStringList(listName);
    }

    public boolean listExists(final String listName, final ConfigurationSection section) {
        try {
            section.getStringList(listName);
            return true;
        }catch (Exception exception) {
            return false;
        }
    }

    public DataType getDataType() {
        return dataType;
    }

    public String getFileName() {
        return fileName;
    }
}
