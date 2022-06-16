package edu.javagroup.seabattle.service.impl;

import edu.javagroup.seabattle.init.Initializer;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.model.PointElement;
import edu.javagroup.seabattle.service.PanelService;
import edu.javagroup.seabattle.singleton.MinePanelSingleton;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
     * @return
     */
    @Override
    public boolean isPanelEmpty() {
        List<HorizontalLine> pane = MinePanelSingleton.getPanel();
        List<PointElement> pp = pane.get(0).getPointElementList();

        return false;
    }

    @Override
    public boolean isFullMinePanel() {
        return false;
    }

    @Override
    public int howMuchIsLeft(String side) {
        return 0;
    }

    @Override
    public boolean checkEndGame(String side) {
        return false;
    }
}
