package edu.javagroup.seabattle.util;

import edu.javagroup.seabattle.constants.Constants;

import java.util.Arrays;

public class IpAddressUtils {
    /**
     * входные параметры: String
     * возвращает: boolean
     * реализация:
     * необходимо выяснить валидность ip-адреса содержащегося во входящей строке
     * необходимо использовать методы классов StringUtils и NumberUtils
     * адрес не может содержать нуль в первой триаде ("0.")
     * запретить использование адреса 127.0.0.1 и localhost (при необходимости можно использовать константы)
     * адрес не может заканчиваться на "."
     * при необходимости можно добавить свои методы
     */
    public static boolean isIpAddress(String ip) {
        if (StringUtils.isEmpty(ip)) {
            return false;
        }

        for (int i = 0; i < ip.length(); i++) {
            if (Character.isLetter(ip.charAt(i))) {
                return false;
            }
        }

        if (ip.endsWith(".") || ip.startsWith(".") || ip.contains(" ") || ip.contains(",") || ip.startsWith(" ")
                || ip.contains(Constants.LOCAL)) {
            return false;
        }

        for (String s : ip.split("\\.")) {
            if (s.equals("") || s.length() > 3) {
                return false;
            }
        }

        int[] numArr = Arrays.stream(ip.split("\\.")).mapToInt(Integer::parseInt).toArray();
        if (numArr.length != 4) {
            return false;
        }

        for (int part : numArr) {
            if (part < 0 || part > 255) {
                return false;
            }
        }

        if (Arrays.equals(numArr, Constants.LOCALHOST) || numArr[0] == 0) {
            return false;
        }
        return true;
    }
}

















