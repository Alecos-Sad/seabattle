package edu.javagroup.seabattle.model;

import edu.javagroup.seabattle.model.parent.ModelValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointElement extends ModelValue implements Comparable<PointElement> {
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
