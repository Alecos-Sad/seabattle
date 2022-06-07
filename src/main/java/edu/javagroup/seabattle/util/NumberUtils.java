package edu.javagroup.seabattle.util;

public class NumberUtils {

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

    public static String currentNumber(int number) {
        return number < 10 ? "0" + number : String.valueOf(number);
    }


    public static String numberBefore(int value) {
        StringBuilder sb = new StringBuilder();
        return value <= 10 && value >= 0 ? "0" + --value : String.valueOf(--value);
    }

    public static String numberAfter(int value) {
        return value <= 8 && value >= 0 ? "0" + ++value : String.valueOf(++value);
    }
}

