package edu.javagroup.seabattle.model.parent;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * в классе ModelRow необходимо создать поле типа char и с именем row
 * запретить менять состояние поля row
 * для этого поля должен быть создан конструктор и геттер
 */
@AllArgsConstructor
@Getter
public abstract class ModelRow {
    private final char row;
}
