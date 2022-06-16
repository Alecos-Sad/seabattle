package edu.javagroup.seabattle.model;

import edu.javagroup.seabattle.model.parent.ModelValue;
import lombok.Getter;
import lombok.Setter;

/**
 * класс является наследником ModelValue
 * любая коллекция на основе этого класса должна быть всегда отсортирована по полю col
 * запретить менять состояние поля col
 * создать конструктор принимающий поля col и value (см. ModelValue), порядок параметров конструктора важен
 * создать геттер и сеттер при необходимости
 */
public class PointElement extends ModelValue implements Comparable<PointElement> {
    @Getter
    private final Integer col;

    public PointElement(int col, int value) {
        super(value);
        this.col = col;
    }


    @Override
    public int compareTo(PointElement pointElement) {
        return getCol().compareTo(pointElement.getCol());
    }
}
