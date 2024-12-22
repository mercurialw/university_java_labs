package org.solution;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Класс, представляющий сущность "Человек".
 * Хранит информацию о человеке, такую как ID, имя, пол, подразделение, зарплата и дата рождения.
 */
public class Human {
    private int id;
    private String name;
    private boolean isMale;
    private Subdivision subdivision;
    private int salary;
    private Date birthday;

    /**
     * Парсит данные из строки CSV и заполняет поля объекта Human.
     *
     * @param data массив строк, содержащий данные из одной строки CSV.
     * @throws RuntimeException если произошла ошибка парсинга данных.
     */
    public void parse(String[] data) {
        try {
            this.id = Integer.parseInt(data[0]);
            this.name = data[1];
            this.isMale = "Male".equals(data[2]);
            this.birthday = new SimpleDateFormat("dd.MM.yyyy").parse(data[3]);
            this.subdivision = new Subdivision(data[4].charAt(0));
            this.salary = Integer.parseInt(data[5]);
        } catch (ParseException e) {
            throw new RuntimeException("Ошибка парсинга данных: " + Arrays.toString(data), e);
        }
    }

    // Геттеры с описанием

    /**
     * @return ID человека.
     */
    public int getId() {
        return id;
    }

    /**
     * @return Имя человека.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Пол человека: true, если мужчина; false, если женщина.
     */
    public boolean isMale() {
        return isMale;
    }

    /**
     * @return Подразделение, в котором работает человек.
     */
    public Subdivision getSubdivision() {
        return subdivision;
    }

    /**
     * @return Зарплата человека.
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @return Дата рождения человека.
     */
    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return new StringBuilder("[")
                .append(id).append(" ")
                .append(name).append(" ")
                .append(isMale ? "Male" : "Female").append(" ")
                .append(subdivision.getName()).append(" ")
                .append(salary).append(" ")
                .append(new SimpleDateFormat("dd.MM.yyyy").format(birthday))
                .append("]").toString();
    }
}
