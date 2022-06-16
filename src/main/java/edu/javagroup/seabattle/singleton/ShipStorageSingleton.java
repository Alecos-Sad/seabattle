package edu.javagroup.seabattle.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * ShipStorageSingleton
 * у него должно быть поле представленное набором пар "строка и число"
 * и это поле должно возвращаться методом getShipMap
 */
public class ShipStorageSingleton {
    private static ShipStorageSingleton instance;
    private final Map<String, Integer> shipStorageCellsMap;

    private ShipStorageSingleton(Map<String, Integer> shipStorageCellsMap) {
        this.shipStorageCellsMap = shipStorageCellsMap;
    }

    public static ShipStorageSingleton instance(Map<String, Integer> shipStorageCellsMap) {
        if (instance == null) {
            instance = new ShipStorageSingleton(new HashMap<>(0));
        }
        if (shipStorageCellsMap != null) {
            instance = new ShipStorageSingleton(shipStorageCellsMap);
        }
        return instance;
    }

    public Map<String, Integer> getShipMap() {
        return shipStorageCellsMap;
    }
}
