package me.imsanti.microbattles.map;

import java.util.HashMap;

public class MapManager {

    private final HashMap<String, Map> loadedMaps = new HashMap<>();


    public void loadMap(final String name) {
        final Map map = new Map(name);
        loadedMaps.put(name, map);
    }
}
