package edu.javagroup.seabattle.model;

import edu.javagroup.seabattle.model.parent.ModelRow;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * класс является наследником ModelRow
 * любая коллекция на основе этого класса должна быть всегда отсортирована по полю row (см. ModelRow)
 * создать поле pointElementList (коллекция) на основе класса PointElement
 * создать для поля геттеры и сеттеры
 * инициализация для поля не нужна
 * в конструкторе нужно создать коллекцию на основе класса PointElement,
 * заполнить ее десятью элементами, в которых поле col конструктора PointElement постоянно прирастает от 1 до 10,
 * а value всегда 0 эту полученную коллекцию необходимо записать в поле текущего класса
 */
@Setter
public class HorizontalLine extends ModelRow implements Comparable<HorizontalLine> {
    private List<PointElement> pointElementList;

    public HorizontalLine(char row) {
        super(row);
        List<PointElement> tempList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tempList.add(i, new PointElement(i + 1, 0));
        }
        this.pointElementList = tempList;
    }

    public List<PointElement> getPointElementList() {
        return pointElementList;
    }

    @Override
    public int compareTo(HorizontalLine horizontalLine) {
        return Character.toString(getRow()).compareToIgnoreCase(Character.toString(horizontalLine.getRow()));
    }
}
