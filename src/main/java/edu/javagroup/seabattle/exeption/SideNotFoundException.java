package edu.javagroup.seabattle.exeption;

/**
 * Класс исключения
 * при использовании от конструктора по умолчанию, должен выдавать message:
 * "Уточните сторону (MINE or ENEMY)"
 */
public class SideNotFoundException extends RuntimeException {

    public SideNotFoundException() {
        this("Уточните сторону (MINE or ENEMY");
    }

    public SideNotFoundException(String message){
        super(message);
    }
}
