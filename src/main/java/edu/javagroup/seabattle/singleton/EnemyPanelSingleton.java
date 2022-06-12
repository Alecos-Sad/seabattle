package edu.javagroup.seabattle.singleton;

import edu.javagroup.seabattle.model.HorizontalLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * EnemyPanelSingleton
 * должно быть поле представленное коллекцией объектов HorizontalLine
 * при записи коллекции в синглтон, необходимо её отсортировать (см. реализацию HorizontalLine)
 * должен быть метод getPanel который возвращает эту коллекцию
 */
public class EnemyPanelSingleton {
    private static volatile EnemyPanelSingleton instance;
    private final List<HorizontalLine> panel;

    private EnemyPanelSingleton(List<HorizontalLine> panel) {
        this.panel = panel;
    }

    public static EnemyPanelSingleton instance(List<HorizontalLine> panel) {
        EnemyPanelSingleton singleton = instance;
        if (singleton == null) {
            instance = new EnemyPanelSingleton(new ArrayList<>(0));
        }
        if (panel != null) {
            Collections.sort(panel);
            instance = new EnemyPanelSingleton(panel);
        }
        return instance;
    }
}
