package org.solution;

/**
 * Класс, представляющий подразделение.
 * Хранит информацию о названии и ID подразделения.
 */
public class Subdivision {
    private int id;
    private String name;

    /**
     * Создает новое подразделение на основе его названия.
     * ID подразделения генерируется автоматически.
     *
     * @param subdivisionName символ, представляющий название подразделения.
     */
    public Subdivision(char subdivisionName) {
        this.id = subdivisionName - 'A';
        this.name = String.valueOf(subdivisionName);
    }

    /**
     * @return ID подразделения.
     */
    public int getId() {
        return id;
    }

    /**
     * @return Название подразделения.
     */
    public String getName() {
        return name;
    }
}
