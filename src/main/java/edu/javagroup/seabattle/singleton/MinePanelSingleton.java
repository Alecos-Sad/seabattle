package edu.javagroup.seabattle.singleton;

import edu.javagroup.seabattle.model.HorizontalLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * MinePanelSingleton
 * должно быть поле представленное коллекцией объектов HorizontalLine
 * при записи коллекции в синглтон, необходимо её отсортировать (см. реализацию HorizontalLine)
 * должен быть метод getPanel который возвращает эту коллекцию
 */
public class MinePanelSingleton {
    private static MinePanelSingleton instance;
    private final List<HorizontalLine> panel;

    private MinePanelSingleton(List<HorizontalLine> panel) {
        this.panel = panel;
    }

    public static MinePanelSingleton instance(List<HorizontalLine> panel) {
        if (instance == null) {
            instance = new MinePanelSingleton(new ArrayList<>(0));
        }
        if (panel != null) {
            Collections.sort(panel);
            instance = new MinePanelSingleton(panel);
        }
        return instance;
    }

    public static List<HorizontalLine> getPanel() {
        return MinePanelSingleton.instance.panel;
    }
}
