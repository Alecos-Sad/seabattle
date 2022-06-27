package edu.javagroup.seabattle.service.impl;

import edu.javagroup.seabattle.constants.Constants;
import edu.javagroup.seabattle.constants.Constants.*;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.service.PanelService;
import edu.javagroup.seabattle.service.PointService;
import edu.javagroup.seabattle.singleton.EnemyPanelSingleton;
import edu.javagroup.seabattle.singleton.MinePanelSingleton;
import edu.javagroup.seabattle.util.HorizontalLinesUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * создать имплементацию этого класса в подпакете impl
 * пометить ее аннотацией @Component
 * в имплементации необходимо создать поле
 * private final PanelService panelService
 * инициализировать поле в конструкторе за счет входного параметра
 */
@AllArgsConstructor
@Component
public class PointServiceImpl implements PointService {

    private final PanelService panelService;

    /**
     * метод: setShipPoint
     * входные параметры: char, int
     * возвращает: void
     * реализация:
     * если метод isClearPoint вернул true
     * вызвать метод addShipPoint
     * иначе clearShipPoint
     */
    @Override
    public void setShipPoint(char row, int col) {
        if (isClearPoint(row, col)) {
            addShipPoint(row, col);
        } else {
            clearShipPoint(row, col);
        }
    }

    /**
     * метод: setSidePoint
     * входные параметры: String, char, int, int
     * возвращает: boolean
     * реализация:
     * в зависимости от side выбрать нужный singleton
     * MinePanelSingleton или EnemyPanelSingleton
     * из него получить коллекцию и установить в нужную ячейку указанное value
     * затем, в зависимости от side, сохранить эту коллекцию в нужный singleton (необязательно)
     * вернуть true
     * отдельно в конце всего кода вернуть false
     */
    @Override
    public boolean setSidePoint(String side, char row, int col, int value) {
        List<HorizontalLine> panel;
        panel = HorizontalLinesUtils.getHorizontalLines(side);
        panel.get(Constants.VERTICAL_COORDINATE.indexOf(row)).getPointElementList().get(col - 1).setValue(value);
        if (side.equals(Constants.MINE)) {
            MinePanelSingleton.instance(panel);
            return true;
        } else if (side.equals(Constants.ENEMY)) {
            EnemyPanelSingleton.instance(panel);
            return true;
        }
        return false;
    }

    /**
     * метод: isClearPoint
     * входные параметры: char, int
     * возвращает: boolean
     * реализация:
     * вызвать метод isOccupiedCell c value 0
     */
    @Override
    public boolean isClearPoint(char row, int col) {
        return isOccupiedCell(row, col, 0);
    }

    @Override
    public boolean getBomb(char row, int col) {
        return false;
    }

    public void addShipPoint(char row, int col) {

    }

    public void clearShipPoint(char row, int col) {

    }

    /**
     * метод: isOccupiedCell
     * входные параметры: char, int, int
     * возвращает: boolean
     * реализация:
     * выяснить, занята ли указанная ячейка, указанным значением
     */
    public boolean isOccupiedCell(char row, int col, int value) {
        List<HorizontalLine> panel;
        panel = MinePanelSingleton.instance(null).getPanel();
        return panel.get(Constants.VERTICAL_COORDINATE.indexOf(row)).getPointElementList().get(col - 1).getValue() == value;
    }

    public void setForbiddenCells() {

    }
}
