package online.nasgar.microbattles.storage;

import online.nasgar.microbattles.storage.list.ArenaFile;
import online.nasgar.microbattles.storage.list.ConfigFile;

import java.util.ArrayList;
import java.util.List;

public class StorageManager {

    private final List<CoreFile> loadedFiles = new ArrayList<>();

    public void loadConfigs() {
        final ConfigFile configFile = new ConfigFile();
        configFile.create();
        loadedFiles.add(configFile);

        final ArenaFile arenaFile = new ArenaFile();
        arenaFile.create();
        loadedFiles.add(arenaFile);
    }

    public boolean fileExists(final String fileName) {
        for(final CoreFile coreFile : loadedFiles) {
            if(coreFile.getFileName().equalsIgnoreCase(fileName)) {
                return true;
            }
        }
        return false;
    }

    public CoreFile getFile(final String fileName) {
        for(final CoreFile coreFile : loadedFiles) {
            if(coreFile.getFileName().equalsIgnoreCase(fileName)) {
                return coreFile;
            }
        }

        return null;
    }
}
