package org.LinkedListTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс PerformanceTesterTest отвечает за тестирование производительности ArrayListTester и LinkedListTester.
 */
class PerformanceTesterTest {

    // Поля для объектов тестирования ArrayList и LinkedList
    private PerformanceTester arrayListTester;
    private PerformanceTester linkedListTester;
    private final int iterations = 1000;  // Количество итераций для тестирования производительности

    /**
     * Метод setUp() выполняется перед каждым тестом.
     * Он создает новые экземпляры ArrayListTester и LinkedListTester.
     */
    @BeforeEach
    void setUp() {
        arrayListTester = new ArrayListTester();  // Инициализация тестировщика ArrayList
        linkedListTester = new LinkedListTester(); // Инициализация тестировщика LinkedList
    }

    /**
     * Тест для проверки метода add() у ArrayList.
     * Проверяет, что метод выполняется без выброса исключений.
     */
    @Test
    void testArrayListAdd() {
        assertDoesNotThrow(() -> arrayListTester.testAdd(iterations)); // Проверка на отсутствие исключений
    }

    /**
     * Тест для проверки метода get() у ArrayList.
     * Сначала добавляются элементы, затем проверяется, что метод get() не вызывает исключений.
     */
    @Test
    void testArrayListGet() {
        arrayListTester.testAdd(iterations);  // Добавление элементов перед вызовом get()
        assertDoesNotThrow(() -> arrayListTester.testGet(iterations)); // Проверка выполнения get()
    }

    /**
     * Тест для проверки метода remove() у ArrayList.
     * Сначала добавляются элементы, затем проверяется, что метод remove() работает корректно.
     */
    @Test
    void testArrayListRemove() {
        arrayListTester.testAdd(iterations);  // Добавление элементов перед удалением
        assertDoesNotThrow(() -> arrayListTester.testRemove(iterations)); // Проверка remove()
    }

    /**
     * Тест для проверки метода add() у LinkedList.
     * Проверяет, что метод выполняется без выброса исключений.
     */
    @Test
    void testLinkedListAdd() {
        assertDoesNotThrow(() -> linkedListTester.testAdd(iterations)); // Проверка на отсутствие исключений
    }

    /**
     * Тест для проверки метода get() у LinkedList.
     * Сначала добавляются элементы, затем проверяется, что метод get() не вызывает исключений.
     */
    @Test
    void testLinkedListGet() {
        linkedListTester.testAdd(iterations);  // Добавление элементов перед вызовом get()
        assertDoesNotThrow(() -> linkedListTester.testGet(iterations)); // Проверка выполнения get()
    }

    /**
     * Тест для проверки метода remove() у LinkedList.
     * Сначала добавляются элементы, затем проверяется, что метод remove() работает корректно.
     */
    @Test
    void testLinkedListRemove() {
        linkedListTester.testAdd(iterations);  // Добавление элементов перед удалением
        assertDoesNotThrow(() -> linkedListTester.testRemove(iterations)); // Проверка remove()
    }
}