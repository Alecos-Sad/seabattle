package edu.javagroup.seabattle.model.parent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * в классе ModelValue необходимо создать поле типа int и с именем value
 * для этого поля должен быть создан конструктор и сеттер и геттер
 */

@AllArgsConstructor
public abstract class ModelValue {
    @Getter
    @Setter
    private int value;

}
