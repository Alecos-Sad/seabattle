package edu.javagroup.seabattle.util;

public class NumberUtils {
    /**
     * метод: isNumber
     * входные параметры: String
     * возвращает: boolean
     * реализация:
     * принимает строку, проверяет, содержит ли строка целочисленное, положительное значение (включая нуль)
     * необходимо использовать StringUtils для того, чтобы избежать NPE
     * не использовать исключения
     * не использовать StreamApi
     */
    public static boolean isNumber(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }

        if (str.contains(".") || str.contains("-")) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * входные параметры: int
     * возвращает: String
     * реализация:
     * принимает число, возвращает это же число в строковом представлении
     * если оно меньше 10, то с лидирующим нулем (5 = "05")
     * если оно больше 10, то в том виде, в котором пришло
     */
    public static String currentNumber(int number) {
        return number < 10 ? "0" + number : String.valueOf(number);
    }

    /**
     * входные параметры: int
     * возвращает: String
     * реализация:
     * принимает число, возвращает предыдущее число в строковом представлении
     * если оно меньше 10, то с лидирующим нулем (5 = "04", 10 = "09")
     * если оно больше 10, то в том виде, в котором пришло
     */
    public static String numberBefore(int value) {
        StringBuilder sb = new StringBuilder();
        return value <= 10 && value >= 0 ? "0" + --value : String.valueOf(--value);
    }

    /**
     *входные параметры: int
     * возвращает: String
     * реализация:
     * принимает число, возвращает следующее число в строковом представлении
     * если оно меньше 10, то с лидирующим нулем (5 = "06", 9 = "10")
     * если оно больше 10, то в том виде, в котором пришло
     */
    public static String numberAfter(int value) {
        return value <= 8 && value >= 0 ? "0" + ++value : String.valueOf(++value);
    }
}

