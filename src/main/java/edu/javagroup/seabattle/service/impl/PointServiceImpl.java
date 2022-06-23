package edu.javagroup.seabattle.service.impl;

import edu.javagroup.seabattle.constants.Constants;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.model.PointElement;
import edu.javagroup.seabattle.service.PanelService;
import edu.javagroup.seabattle.service.PointService;
import edu.javagroup.seabattle.util.HorizontalLinesUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

import static edu.javagroup.seabattle.constants.Constants.ENEMY;
import static edu.javagroup.seabattle.constants.Constants.MINE;

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

    @Override
    public boolean setSidePoint(String side, char row, int col, int value) {
        List<HorizontalLine> panel;
        panel = HorizontalLinesUtils.getHorizontalLines(side);




        return false;
    }

    @Override
    public boolean isClearPoint(char row, int col) {
        return false;
    }

    @Override
    public boolean getBomb(char row, int col) {
        return false;
    }

    public void addShipPoint(char row, int col) {

    }

    public void clearShipPoint(char row, int col) {

    }

    public boolean isOccupiedCell(char row, int col) {
        return false;
    }

    public void setForbiddenCells() {

    }
}