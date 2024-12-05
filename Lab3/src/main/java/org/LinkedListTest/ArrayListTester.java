package org.LinkedListTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс ArrayListTester реализует интерфейс PerformanceTester.
 * Он предназначен для тестирования производительности операций
 * добавления, получения и удаления элементов в ArrayList.
 */
public class ArrayListTester implements PerformanceTester {

    // Создание списка на основе ArrayList для тестирования
    private List<Integer> list = new ArrayList<>();

    /**
     * Тестирует производительность операции добавления элементов в ArrayList.
     *
     * @param iterations количество итераций добавления элементов
     */
    @Override
    public void testAdd(int iterations) {
        long startTime = System.nanoTime(); // Засекаем начальное время
        for (int i = 0; i < iterations; i++) {
            list.add(i); // Добавляем элемент в конец списка
        }
        long endTime = System.nanoTime(); // Засекаем конечное время
        System.out.println("ArrayList Add: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    /**
     * Тестирует производительность операции получения элементов по индексу из ArrayList.
     *
     * @param iterations количество итераций получения элементов
     */
    @Override
    public void testGet(int iterations) {
        long startTime = System.nanoTime(); // Засекаем начальное время
        for (int i = 0; i < iterations; i++) {
            list.get(i); // Получаем элемент по индексу
        }
        long endTime = System.nanoTime(); // Засекаем конечное время
        System.out.println("ArrayList Get: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    /**
     * Тестирует производительность операции удаления элементов из ArrayList.
     * Удаление выполняется начиная с последнего элемента, чтобы избежать сдвига всех элементов.
     *
     * @param iterations количество итераций удаления элементов
     */
    @Override
    public void testRemove(int iterations) {
        long startTime = System.nanoTime(); // Засекаем начальное время
        for (int i = iterations - 1; i >= 0; i--) {
            list.remove(i); // Удаляем элемент по индексу
        }
        long endTime = System.nanoTime(); // Засекаем конечное время
        System.out.println("ArrayList Remove: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}