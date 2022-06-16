package edu.javagroup.seabattle.init;

import edu.javagroup.seabattle.constants.Constants;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.singleton.*;

import java.util.*;

public class Initializer {
    /**
     * входные параметры: нет
     * возвращает: void
     * реализация:
     * вложить в SettingsSingleton карту нулевой размерности
     * вызвать метод initPanels
     */
    public void init() {
        SettingsSingleton.instance(new HashMap<>(0));
        initPanels();
    }

    /**
     * входные параметры: нет
     * возвращает: void
     * реализация:
     * 1. MyStepSingleton должен получить true
     * 2. ImReadySingleton должен получить false
     * 3. EnemyReadySingleton должен получить false
     * 4. ForbiddenCellsSingleton должен получить карту нулевой размерности
     * 5. Создать карту (String и Integer) нужной размерности, в которую вложить
     *     "1deck", 0
     *     "2deck", 0
     *     "3deck", 0
     *     "4deck", 0
     * вложить карту в ShipStorageSingleton
     * 6. Создать коллекцию HorizontalLine нужной размерности
     * в которую вложить 10 элементов HorizontalLine, где поле row устанавливается последовательно символами
     * от 'A' до 'J'
     * вложить коллекцию в MinePanelSingleton
     * 7. Создать коллекцию HorizontalLine нужной размерности
     * в которую вложить 10 элементов HorizontalLine, где поле row устанавливается последовательно символами
     * от 'A' до 'J'
     * вложить коллекцию в EnemyPanelSingleton
     * Примечание: смотреть Constants
     */
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
