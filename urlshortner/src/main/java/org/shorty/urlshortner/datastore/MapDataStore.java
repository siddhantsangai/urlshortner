package org.shorty.urlshortner.datastore;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MapDataStore {
    private Map<Long, String> dataStore;

    public MapDataStore() {
        dataStore = new HashMap<>();
    }

    public Map<Long, String> getDataStore() {
        return dataStore;
    }
}
