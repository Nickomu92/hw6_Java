package com.nikomu;

// Класс "Сообщение"
public class Message {
    public static void warningMsg(String message) {
        System.out.printf("%s%s%s", Color.ANSI_YELLOW.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static void errorMsg(String message) {
        System.out.printf("%s%s%s", Color.ANSI_RED.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static void primaryMsg(String message) {
        System.out.printf("%s%s%s", Color.ANSI_CYAN.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static void successMsg(String message) {
        System.out.printf("%s%s%s", Color.ANSI_GREEN.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static void infoMsg(String message) {
        System.out.printf("%s%s%s", Color.ANSI_BLUE.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static void headerMsg(String message) {
        System.out.printf("%s%s%s", Color.ANSI_PURPLE.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static void whiteMsg(String message) {
        System.out.printf("%s%s%s", Color.ANSI_WHITE.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static String returnWarningMsg(String message) {
        return String.format("%s%s%s", Color.ANSI_YELLOW.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static String returnErrorMsg(String message) {
        return String.format("%s%s%s", Color.ANSI_RED.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static String returnPrimaryMsg(String message) {
        return String.format("%s%s%s", Color.ANSI_CYAN.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static String returnSuccessMsg(String message) {
        return String.format("%s%s%s", Color.ANSI_GREEN.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static String returnInfoMsg(String message) {
        return String.format("%s%s%s", Color.ANSI_BLUE.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static String returnHeaderMsg(String message) {
        return String.format("%s%s%s", Color.ANSI_PURPLE.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static String returnWhiteMsg(String message) {
        return String.format("%s%s%s", Color.ANSI_WHITE.getCode(), message, Color.ANSI_RESET.getCode());
    }
}
