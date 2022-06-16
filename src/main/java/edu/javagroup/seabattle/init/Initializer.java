package edu.javagroup.seabattle.init;

import edu.javagroup.seabattle.constants.Constants;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.singleton.*;
import java.util.*;

public class Initializer {

    public void init() {
        SettingsSingleton.instance(new HashMap<>(0));
        initPanels();
    }

    public void initPanels() {
        MyStepSingleton.instance(true);
        ImReadySingleton.instance(false);
        EnemyReadySingleton.instance(false);
        ForbiddenCellsSingleton.instance(new HashMap<>(0));

        Map<String, Integer> example = new HashMap<>();
        example.put("1deck", 0);
        example.put("2deck", 0);
        example.put("3deck", 0);
        example.put("4deck", 0);
        ShipStorageSingleton.instance(example);

        List<HorizontalLine> horizontalCollectMine = new ArrayList<>(10);
        for (int i = 0; i < Constants.VERTICAL_COORDINATE.length(); i++) {
            horizontalCollectMine.add(new HorizontalLine(Constants.VERTICAL_COORDINATE.charAt(i)));
        }

        MinePanelSingleton.instance(horizontalCollectMine);
        List<HorizontalLine> horizontalCollectEnemy = new ArrayList<>(10);
        for (int i = 0; i < Constants.VERTICAL_COORDINATE.length(); i++) {
            horizontalCollectEnemy.add(new HorizontalLine(Constants.VERTICAL_COORDINATE.charAt(i)));
        }
        EnemyPanelSingleton.instance(horizontalCollectEnemy);
    }
}
