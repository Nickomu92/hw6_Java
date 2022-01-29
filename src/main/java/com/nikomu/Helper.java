package com.nikomu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Класс "Помощник"
public class Helper {
    // Список логов
    static List<Logger> logger = new ArrayList<>();
    static String allMessages = "";
    private static final String filePathJson = "resources/candy_log.json";
    private static final String filePathTxt = "resources/candy_log.txt";

    // Метод для получения фарматированной текущей даты и времени
    public static String getCurrentFormatDate() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("EEEE HH:mm:ss.S dd.MM.yyyy");
        return formatForDateNow.format(dateNow);
    }

    // Метод для получения текущей даты и времениг
    public static Date getCurrentDate() {
        return new Date();
    }

    // Метод для создания JSON-объекта в строковом представлении
    public static String makeJsonString(List<Logger> listLogger) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(listLogger);
    }

    // Метод для записи логов (сообщений и даты) в файл
    public static void writeFile(String message, String filePath) {
        try (PrintStream printStream = new PrintStream(filePath)) {
            printStream.print(message);
            Message.successMsg("\n\t[Сообщение] - Запись в файл произведена успешно!\n");
        } catch (IOException e) {
            Message.errorMsg("\n\t[Сообщение] - Ошибка записи в файл!\n");
        }
    }

    // Метод для открытия файла программой по-умолчанию
    public static void show(String filePath) {
        File imageFile = new File(filePath);
        Desktop desktop = Desktop.getDesktop();

        try {
            desktop.open(imageFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String makeFileMessage(Candy currentCandy) throws NoSuchFieldException, IllegalAccessException {
        Field candyNameField = currentCandy.getClass().getDeclaredField("candyName");
        Field idField = currentCandy.getClass().getDeclaredField("id");
        candyNameField.setAccessible(true);
        idField.setAccessible(true);

        String candyName = candyNameField.get(currentCandy).toString();
        int id = (int) idField.get(currentCandy);

        return String.format("конфеты №%d \"%s\" выполнено успешно", id, candyName);
    }

    public static void makeFileLog(Candy currentCandy, String operationType) {
        try {
            String message = String.format("[%s] - %s %s;", getCurrentDate(), operationType, makeFileMessage(currentCandy));
            allMessages += message + "\n";
            Helper.logger.add(new Logger(Helper.getCurrentDate(), message));
            selectShowFile();
        } catch (NoSuchFieldException e) {
            Message.errorMsg("\n\t" + e.getMessage() + "\n");
        } catch (IllegalAccessException e) {
            Message.errorMsg("\n\t" + e.getMessage() + "\n");
        }
    }

    // Метод для выбора типа файла
    public static String selectFileType() {
        Scanner scanner = new Scanner(System.in);
        String symbol;
        String result = null;
        String fileType = Message.returnHeaderMsg("\n\tВыберите тип файла\n") +
                Message.returnWarningMsg("[t]") + " - file.txt;\n" +
                Message.returnWarningMsg("[j]") + " - file.json;\n" +
                Message.returnPrimaryMsg("Ваш выбор: ");

        do {
            System.out.print(fileType);
            symbol = scanner.next();

            switch(symbol) {
                case "t": case "T": case "е": case "Е":
                    result = "txt";
                    break;

                case "j": case "J": case "о": case "О":
                    result = "json";
                    break;

                default:
                    Message.errorMsg("\n\t[Сообщение] - нет такого типа файла\n");
            }

        } while(!symbol.equals("t") && !symbol.equals("T") && !symbol.equals("е") && !symbol.equals("Е") &&
                !symbol.equals("j") && !symbol.equals("J") && !symbol.equals("о") && !symbol.equals("О"));

        return result;
    }

    // Метод для создания конфеты
    public static void createCandy(Candy currentCandy) {
        makeFileLog(currentCandy, "Создание");
    }

    // Метод для создания конфеты
    public static void readCandy(Candy currentCandy) {
        makeFileLog(currentCandy, "Чтение");
    }

    // Метод для создания конфеты
    public static void updateCandy(Candy currentCandy) {
        makeFileLog(currentCandy, "Изменение");
    }

    // Метод для выбора типа файла и отображания его содержимого
    public static void selectShowFile() {
        String fileType = selectFileType();
        Helper.writeFile(allMessages, filePathTxt);
        Helper.writeFile(Helper.makeJsonString(logger), filePathJson);

        if(fileType.equals("txt")) {
            Helper.show(filePathTxt);
        } else if(fileType.equals("json")) {
            Helper.show(filePathJson);
        }
    }
}
