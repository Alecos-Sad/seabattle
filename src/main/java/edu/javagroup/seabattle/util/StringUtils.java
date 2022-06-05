package edu.javagroup.seabattle.util;

/**
 * Subtask #1
 * создать пакет util в корневом пакете edu.javagroup.seabattle
 * создать в нем утилитный класс StringUtils
 */
public class StringUtils {
    /**
     * Subtask #2
     * метод: isEmpty
     * входные параметры: CharSequence*
     * возвращает: boolean
     * реализация:
     * выясняет, является ли пришедшая строка null или ее длина равна нулю
     */
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }
    /**
     * Subtask #3
     * метод: isNotEmpty
     * входные параметры: CharSequence*
     * возвращает: boolean
     * реализация:
     * возвращает инвертированный ответ метода isEmpty
     */
    public static boolean isNotEmpty(CharSequence str){
        return !isEmpty(str);
    }
    /**
     * Subtask #4
     * метод: letterBefore
     * входные параметры: char
     * возвращает: char
     * реализация:
     * нужно получить предыдущий символ от пришедшего
     * пояснение: если в метод пришел символ 'B', вернуть 'A'
     */
    public static char letterBefore(char ch){
        return (char) (ch - 1);
    }
    /**
     * Subtask #5
     * метод: letterAfter
     * входные параметры: char
     * возвращает: char
     * реализация:
     * нужно получить следующий символ от пришедшего
     * пояснение: если в метод пришел символ 'B', вернуть 'C'
     */
    public static char letterAfter(char ch){
        return (char) (ch + 1);
    }


}
