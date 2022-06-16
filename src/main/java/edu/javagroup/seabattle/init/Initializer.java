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

        Map<String, Integer> examp = new HashMap<>();
        examp.put("1deck", 0);
        examp.put("2deck", 0);
        examp.put("3deck", 0);
        examp.put("4deck", 0);
        ShipStorageSingleton.instance(examp);

        List<HorizontalLine> horizontCollectMine = new ArrayList<>(10);
        for (int i = 0; i < Constants.VERTICAL_COORDINATE.length(); i++) {
            horizontCollectMine.add(new HorizontalLine(Constants.VERTICAL_COORDINATE.charAt(i)));
        }

        MinePanelSingleton.instance(horizontCollectMine);


        List<HorizontalLine> horizontCollectEnemy = new ArrayList<>(10);
        for (int i = 0; i < Constants.VERTICAL_COORDINATE.length(); i++) {
            horizontCollectEnemy.add(new HorizontalLine(Constants.VERTICAL_COORDINATE.charAt(i)));
        }
        EnemyPanelSingleton.instance(horizontCollectEnemy);
    }
}
