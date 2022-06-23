package edu.javagroup.seabattle.util;

import edu.javagroup.seabattle.exeption.SideNotFoundException;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.singleton.EnemyPanelSingleton;
import edu.javagroup.seabattle.singleton.MinePanelSingleton;

import java.util.List;

import static edu.javagroup.seabattle.constants.Constants.ENEMY;
import static edu.javagroup.seabattle.constants.Constants.MINE;

public final class HorizontalLinesUtils {

    public static List<HorizontalLine> getHorizontalLines(String side) {
        List<HorizontalLine> panel;
        if (side.equalsIgnoreCase(MINE)) {
            panel = MinePanelSingleton.instance(null).getPanel();
        } else if (side.equalsIgnoreCase(ENEMY)) {
            panel = EnemyPanelSingleton.instance(null).getPanel();
        } else {
            throw new SideNotFoundException();
        }
        return panel;
    }
}
