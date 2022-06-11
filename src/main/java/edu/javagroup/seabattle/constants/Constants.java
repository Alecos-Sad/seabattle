package edu.javagroup.seabattle.constants;

/**
 * Класс констант
 * создать в классе видимые для всего проекта константы
 * LOCALHOST - массив чисел 127, 0, 0, 1
 * ENEMY_PROTOCOL - содержит строку "http"
 * ENEMY_IP_ADDRESS - содержит строку "enemyIpAddress"
 * ENEMY_PORT - содержит строку "8080"
 * VERTICAL_COORDINATE - содержит строку с последовательным перечислением букв английского алфавита от A до J в верхнем регистре
 * DECK - содержит строку "deck"
 * BUTTON_PREFIX - содержит строку "jButton"
 * MINE - содержит строку "M"
 * ENEMY - содержит строку "E"
 * M_BUTTON_PREFIX - содержит строку представляющую из себя результат конкатенации BUTTON_PREFIX и MINE
 * E_BUTTON_PREFIX - содержит строку представляющую из себя результат конкатенации BUTTON_PREFIX и ENEMY
 * BUTTON_POSTFIX - содержит строку "ActionPerformed"
 */
public class Constants {
    public static final int[] LOCALHOST = {127, 0, 0, 1};
    public static String ENEMY_PROTOCOL = "http";
    public static String ENEMY_IP_ADDRESS = "enemyIpAddress";
    public static String ENEMY_PORT = "8080";
    public static String VERTICAL_COORDINATE = "ABCDEFGHIJ";
    public static String DECK = "deck";
    public static String BUTTON_PREFIX = "jButton";
    public static String MINE = "M";
    public static String ENEMY = "E";
    public static String M_BUTTON_PREFIX = BUTTON_PREFIX.concat(MINE);
    public static String E_BUTTON_PREFIX = BUTTON_PREFIX.concat(ENEMY);
    public static String BUTTON_POSTFIX = "ActionPerformed";
    public static String IP = "127.0.0.1";
    public static String LOCAL = "localhost";
}
