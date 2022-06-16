package edu.javagroup.seabattle.model;

import edu.javagroup.seabattle.model.parent.ModelValue;
import lombok.Getter;

/**
 * класс является наследником ModelValue
 * любая коллекция на основе этого класса должна быть всегда отсортирована по полю point
 * класс должен содержать поле point (и геттер для него), представленное целочисленным типом данных
 * запретить менять состояние поля point
 * создать конструктор принимающий поля point и value (см. ModelValue), порядок параметров конструктора важен
 */

public class ShipPoint extends ModelValue implements Comparable<ShipPoint> {
    @Getter
    private final Integer point;

    public ShipPoint(int point, int value) {
        super(value);
        this.point = point;
    }

    @Override
    public int compareTo(ShipPoint shipPoint) {

        return getPoint().compareTo(shipPoint.getPoint());
    }
}
