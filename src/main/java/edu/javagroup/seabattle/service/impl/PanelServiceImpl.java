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

    @Override
    public boolean isFullMinePanel() {
        return countPointElements(1, 1) == 20;
    }

    @Override
    public int howMuchIsLeft(String side) {
        int value = 0;
        if (side.equals(Constants.MINE)) {
            value = countPointElements(2, 1);
        }
        if (side.equals(Constants.ENEMY)) {
            value = countPointElements(2, 2);
        }
        return ImReadySingleton.imReady() ? 20 - value : 0;
    }

    @Override
    public boolean checkEndGame(String side) {
        return false;
    }

    private int countPointElements(int value, int singleton) {
        int count = 0;
        List<HorizontalLine> panel;
        switch (singleton) {
            case 1:
                panel = MinePanelSingleton.getPanel();
                break;
            case 2:
                panel = EnemyPanelSingleton.getPanel();
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
