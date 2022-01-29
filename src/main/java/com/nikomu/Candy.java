/**************************************************************************************************
 C         R       U         D      - методы
 Create    Read    Update    Delete
 **************************************************************************************************/

package com.nikomu;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Класс "Конфета"
@Component
@Scope("prototype")
public class Candy {
    // Поле (свойство) идентификатор (номер) конфеты
    private final int id;
    // Поле (свойство) название конфеты
    private String candyName;
    // Статическое поле (свойство) счётчик
    private static int count;

    // Конструктор
    public Candy() {
        this.id = ++count;
    }

    // Метод для получения идентификатора (номера) конфеты
    public int getId() {
        return this.id;
    }

    // Метод для получения названия конфеты
    public String getCandyName() {
        return this.candyName;
    }

    // CRUD-метод "создания" конфеты
    public Candy create(String candyName) {
        this.candyName = candyName;
        Message.successMsg(String.format("\n\t[Бизнес логика, метод create()] - Конфета №%d \"%s\" создана.\n", this.id, this.candyName));
        return this;
    }

    // CRUD-метод "прочтения" конфеты
    public Candy read() {
        Message.successMsg(String.format("\n\t[Бизнес логика, метод read()] - Конфета №%d \"%s\" прочитана.\n", this.id, this.candyName));
        return this;
    }

    // CRUD-метод "обновления" конфеты
    public Candy update(String candyName) {
        this.candyName = candyName;
        Message.successMsg(String.format("\n\t[Бизнес логика, метод update()] - Конфета №%d \"%s\" обновлена.\n", this.id, this.candyName));
        return this;
    }

    // CRUD-метод "удаления" конфеты
    public void delete() {
        Message.successMsg(String.format("\n\t[Бизнес логика, метод delete()] - Конфета №%d \"%s\" удалена.\n", this.id, this.candyName));
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        String tempString = "Candy {";
        tempString +=  "id = " + id;

        if(candyName != null) {
            tempString += ", candyName = '" + candyName + "\'";
        }

        tempString += "}";
        return tempString;
    }
}
