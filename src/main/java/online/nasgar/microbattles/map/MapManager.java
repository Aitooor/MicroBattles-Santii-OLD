package online.nasgar.microbattles.map;

import java.util.ArrayList;
import java.util.HashMap;

public class MapManager {

    private final HashMap<String, Map> loadedMaps = new HashMap<>();

    public void loadMap(final String name, final int minPlayers, final int maxPlayers, final boolean isEnabled) {
        final Map map = new Map(minPlayers, maxPlayers, name, new ArrayList<>(), isEnabled);
        loadedMaps.put(name, map);
    }

    public Map getMap(final String mapName) {
        return loadedMaps.get(mapName);
    }


}
