package edu.javagroup.seabattle.service.impl;

import edu.javagroup.seabattle.constants.Constants;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.model.PointElement;
import edu.javagroup.seabattle.service.PanelService;
import edu.javagroup.seabattle.singleton.EnemyPanelSingleton;
import edu.javagroup.seabattle.singleton.ImReadySingleton;
import edu.javagroup.seabattle.singleton.MinePanelSingleton;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * создать имплементацию этого класса в подпакете impl
 * пометить ее аннотацией @Component
 */
@Component
public class PanelServiceImpl implements PanelService {

    /**
     * имплементация интерфейса
     * метод: isPanelEmpty
     * входные параметры: нет
     * возвращает: boolean
     * реализация:
     * получить коллекцию из MinePanelSingleton и посчитать в нем количество PointElement с value == 0
     * если это количество == 100, вернуть true
     * в идеале, реализация должна быть в одну строку кода
     * можно выразить в дополнительных методах имплементации
     */
    @Override
    public boolean isPanelEmpty() {
        return countPointElements(0, 1) == 100;
    }

    /**
     * метод: isFullMinePanel
     * входные параметры: нет
     * возвращает: boolean
     * реализация:
     * получить коллекцию из MinePanelSingleton и посчитать в нем количество PointElement с value == 1
     * если это количество == 20, вернуть true
     * в идеале, реализация должна быть в одну строку кода
     * можно выразить в дополнительных методах имплементации
     */
    @Override
    public boolean isFullMinePanel() {
        return countPointElements(1, 1) == 20;
    }

    /**
     * метод: howMuchIsLeft
     * входные параметры: String
     * возвращает: int
     * реализация:
     * в зависимости от того, какую сторону мы получили - MINE or ENEMY
     * получить коллекцию из MinePanelSingleton или EnemyPanelSingleton соответственно
     * и посчитать в нем количество PointElement с value == 2
     * результат записать в переменную
     * далее:
     * если ImReadySingleton возвращает true, то вернуть положительный результат разности чисел 20 и переменной (смотри выше)
     * если ImReadySingleton возвращает false, то вернуть 0
     * в идеале, реализация должна быть в одну строку кода
     * можно выразить в дополнительных методах имплементации
     */
    @Override
    public int howMuchIsLeft(String side) {
        if (side.equals(Constants.MINE)) {
            return ImReadySingleton.instance(null).imReady() ? 20 - countPointElements(2, 1) : 0;
        }
        if (side.equals(Constants.ENEMY)) {
            return ImReadySingleton.instance(null).imReady() ? 20 - countPointElements(2, 2) : 0;
        }
        return 0;
    }

    @Override
    public boolean checkEndGame(String side) {
        if (side.equals(Constants.MINE)) {
            return countPointElements(2, 1) == 20;
        }
        if (side.equals(Constants.ENEMY)) {
            return countPointElements(2, 2) == 20;
        }
        return false;
    }

    private int countPointElements(int value, int singleton) {
        int count = 0;
        List<HorizontalLine> panel;
        switch (singleton) {
            case 1:
                panel = MinePanelSingleton.instance(null).getPanel();
                break;
            case 2:
                panel = EnemyPanelSingleton.instance(null).getPanel();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + singleton);
        }
        for (HorizontalLine horizontalLine : panel) {
            for (PointElement pointElement : horizontalLine.getPointElementList()) {
                if (pointElement.getValue() == value) {
                    count++;
                }
            }
        }
        return count;
    }
}
