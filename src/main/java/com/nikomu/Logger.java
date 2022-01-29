package com.nikomu;

import java.util.Date;

// Класс "Регистратор"
public class Logger {
    // Поле (свойство) представляющее дату и время записи
    private Date dateTime;
    // Поле (свойство) представляющее сообщение
    private String message;

    // Конструктор по умолчанию
    public Logger() {}

    // Конструктор №2
    public Logger(Date dateTime, String message) {
        this.dateTime = dateTime;
        this.message = message;
    }

    // Метод для получения даты и времени
    public Date getDateTime() {
        return dateTime;
    }

    // Метод для установки (изменения) даты и времени
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    // Метод для получения сообщения
    public String getMessage() {
        return message;
    }

    // Метод для установки (изменения) сообщения
    public void setMessage(String message) {
        this.message = message;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        String tempStr = "Logger {";
        if(dateTime != null) {
            tempStr += "dateTime = " + dateTime;
        }
        if(message != null) {
            tempStr += ", message='" + message + "\'";
        }
        tempStr += "}";

        return  tempStr;
    }
}
