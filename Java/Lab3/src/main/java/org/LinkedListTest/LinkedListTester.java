package org.LinkedListTest;

import java.util.LinkedList;
import java.util.List;

/**
 * Класс LinkedListTester реализует интерфейс PerformanceTester.
 * Он предназначен для тестирования производительности операций
 * добавления, получения и удаления элементов в LinkedList.
 */
public class LinkedListTester implements PerformanceTester {

    // Создание списка на основе LinkedList для тестирования
    private List<Integer> list = new LinkedList<>();

    /**
     * Тестирует производительность операции добавления элементов в LinkedList.
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
        System.out.println("LinkedList Add: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    /**
     * Тестирует производительность операции получения элементов по индексу из LinkedList.
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
        System.out.println("LinkedList Get: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    /**
     * Тестирует производительность операции удаления элементов из LinkedList.
     * Удаление производится с начала списка.
     *
     * @param iterations количество итераций удаления элементов (не используется, удаляем все элементы)
     */
    @Override
    public void testRemove(int iterations) {
        long startTime = System.nanoTime(); // Засекаем начальное время
        while (!list.isEmpty()) {
            list.remove(0); // Удаляем первый элемент списка
        }
        long endTime = System.nanoTime(); // Засекаем конечное время
        System.out.println("LinkedList Remove: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}