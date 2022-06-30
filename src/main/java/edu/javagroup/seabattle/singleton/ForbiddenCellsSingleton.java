package edu.javagroup.seabattle.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * ForbiddenCellsSingleton
 * у него должно быть поле представленное набором пар "строка и булево"
 * и это поле должно возвращаться методом getForbiddenCellsMap
 */
public class ForbiddenCellsSingleton {

    private static ForbiddenCellsSingleton instance;
    private final Map<String, Boolean> forbiddenCellsMap;

    private ForbiddenCellsSingleton(Map<String, Boolean> forbiddenCellsMap) {
        this.forbiddenCellsMap = forbiddenCellsMap;
    }

    public static ForbiddenCellsSingleton instance(Map<String, Boolean> forbiddenCellsMap) {
        if (instance == null) {
            instance = new ForbiddenCellsSingleton(new HashMap<>(0));
        }
        if (forbiddenCellsMap != null && forbiddenCellsMap.size() > 0) {
            instance = new ForbiddenCellsSingleton(forbiddenCellsMap);
        }
        return instance;
    }

    public Map<String, Boolean> getForbiddenCellsMap() {
        return forbiddenCellsMap;
    }
}
