package com.senla.povargo.hotel.tools;

import java.util.Date;

public class Logger {

    public static void error(String message) {
        Date date = new Date();
        String str = date +
                " " +
                "[Error]" +
                " " +
                message +
                "\n";
        System.out.println(str);
    }

    public static void info(String message) {
        Date date = new Date();
        String str = date +
                " " +
                "[Info]" +
                " " +
                message +
                "\n";
        System.out.println(str);
    }
}
