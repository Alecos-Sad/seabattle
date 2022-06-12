package edu.javagroup.seabattle.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * SettingsSingleton
 * у него должно быть поле представленное набором пар "строка и строка"
 * и это поле должно возвращаться методом getSettingsMap
 * также, из этого набора пар, мы должны иметь возможность измлекать значение по ключу
 * методом getSettingsByKey(String key)
 */
public class SettingsSingleton {

    private static SettingsSingleton instance;
    private final Map<String, String> settingCellsMap;

    private SettingsSingleton(Map<String, String> settingCellsMap) {
        this.settingCellsMap = settingCellsMap;
    }

    public static SettingsSingleton instance(Map<String, String> settingCellsMap) {
        if (instance == null) {
            instance = new SettingsSingleton(new HashMap<>(0));
        }
        if (settingCellsMap != null) {
            instance = new SettingsSingleton(settingCellsMap);
        }
        return instance;
    }

    public Map<String, String> getSettingsMap() {
        return settingCellsMap;
    }

    public String getSettingsByKey(String key) {
        return settingCellsMap.get(key);
    }
}
