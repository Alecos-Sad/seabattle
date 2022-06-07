package edu.javagroup.seabattle.util;

import edu.javagroup.seabattle.Constants.Constans;

public class IpAddressUtils {

    public static boolean isIpAddress(String ip) {
        if (StringUtils.isEmpty(ip)) {
            return false;
        }

        if (ip.endsWith(".") || ip.startsWith(".")) {
            return false;
        }

        if(ip.contains("127.0.0.1") || ip.contains("localhost") || ip.contains("127.000.000.001")){
            return false;
        }

        if (ip.contains(" ")){
            return false;
        }

        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false;
        }
        if (parts[0].startsWith("0")){
            return false;
        }

        for (String s : parts) {
            int i = Integer.parseInt(s);
            if (i < 0 || i > 255) {
                return false;
            }
        }
        return true;
    }
}

















