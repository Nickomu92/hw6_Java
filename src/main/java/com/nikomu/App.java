/************************************************************************************************************
 Создать класс Конфета (подготовить CRUD операций).
 Все выводят на консоль муляжное сообщение.
 Для каждого метода, кроме DELETE подготовить сквозную логику, которая будет фиксировать работу этого метода
 в файл (название метода и время, когда он пытался выполниться).
*************************************************************************************************************/

package com.nikomu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.Scanner;

public class App
{
    // Основной метод
    public static void main( String[] args ) {
        mainMenu();
    }

    // Метод с логикой главного меню
    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        String symbol;

        Candy currentCandy = null;

        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FileConfig.class)) {
            do {
                System.out.print(makeMenu(currentCandy));
                symbol = scanner.next();

                switch(symbol) {
                    case "c": case "C": case "с": case "С":
                        currentCandy = (Candy) context.getBean("candy");
                        String candyName;
                        Message.headerMsg("\n\tУкажите название \"Конфеты\" для создания: ");
                        candyName = scanner.next();
                        currentCandy.create(candyName);
                        break;

                    case "r": case "R": case "к": case "К":
                        if(currentCandy != null) {
                            currentCandy.read();
                        } else {
                            Message.errorMsg("\n\t[Сообщение] - Нет такого пункта меню.\n");
                        }
                        break;

                    case "u": case "U": case "г": case "Г":
                        if(currentCandy != null) {
                            Message.headerMsg("\n\tУкажите новое название \"Конфеты\": ");
                            candyName = scanner.next();
                            currentCandy.update(candyName);
                        } else {
                            Message.errorMsg("\n\t[Сообщение] - Нет такого пункта меню.\n");
                        }
                        break;

                    case "d": case "D": case "в": case "В":
                        if(currentCandy != null) {
                            currentCandy.delete();
                            currentCandy = null;
                            System.gc();
                        } else {
                            Message.errorMsg("\n\t[Сообщение] - Нет такого пункта меню.\n");
                        }
                        break;

                    case "q": case "Q": case "й": case "Й":
                        Message.warningMsg("\n\t[Сообщение] - Выходим из приложения...\n");
                        break;

                    default:
                        Message.errorMsg("\n\t[Сообщение] - Нет такого пункта меню.\n");
                }
            } while(!symbol.equals("q") && !symbol.equals("Q") && !symbol.equals("й") && !symbol.equals("Й"));
        } catch(Exception e) {
            Message.errorMsg("\n\t[Сообщение]" + " - " + e.getMessage());
        }

    }

    // Метод для создания текстового представления вариантов меню
    public static String makeMenu(Candy currentCandy) {
        String newMenu = Message.returnHeaderMsg("\n\tДомашнее задание №6\n") +
                Message.returnErrorMsg("\tМулина Николая\n") +
                Message.returnWarningMsg("[c]") + " - Создать новую \"Конфету\";\n";

        if(currentCandy != null) {
            newMenu += Message.returnWarningMsg("[r]") + " - Прочитать \"Конфету\";\n" +
                    Message.returnWarningMsg("[u]") + " - Изменить \"Конфету\";\n" +
                    Message.returnWarningMsg("[d]") + " - Удалить \"Конфету\";\n";
        }
        newMenu += Message.returnWarningMsg("[q]") + " - Выйти из приложения.\n" +
                Message.returnPrimaryMsg("Ваш выбор: ");

        return newMenu;
    }

    // Метод для получения объекта "Конфета" из списка по названию или идентификатору (номеру)
    public static Candy getCandy(List<Candy> candyList, String findCandy) {
        try {
            int candyNumber = Integer.parseInt(findCandy);
            for(Candy item: candyList) {
                if(item.getId() == candyNumber) {
                    return item;
                }
            }
        } catch (Exception e) {
            for(Candy item: candyList) {
                if(item.getCandyName().equals(findCandy)) {
                    return item;
                }
            }
        }
        return null;
    }
}