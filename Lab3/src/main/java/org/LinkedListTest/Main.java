package org.LinkedListTest;

/**
 * Класс Main является точкой входа в программу.
 * Он создает экземпляры тестеров для ArrayList и LinkedList и выполняет тесты производительности.
 */
public class Main {

    public static void main(String[] args) {
        // Количество итераций, которое будет использоваться для тестирования
        int iterations = 50000;

        // Вывод заголовка для тестирования ArrayList
        System.out.println("ArrayList Performance:");

        // Создание экземпляра тестера для ArrayList
        PerformanceTester arrayListTester = new ArrayListTester();

        // Тестирование операции добавления для ArrayList
        arrayListTester.testAdd(iterations);

        // Тестирование операции получения для ArrayList
        arrayListTester.testGet(iterations);

        // Тестирование операции удаления для ArrayList
        arrayListTester.testRemove(iterations);

        // Разделитель для улучшения читаемости
        System.out.println("\nLinkedList Performance:");

        // Создание экземпляра тестера для LinkedList
        PerformanceTester linkedListTester = new LinkedListTester();

        // Тестирование операции добавления для LinkedList
        linkedListTester.testAdd(iterations);

        // Тестирование операции получения для LinkedList
        linkedListTester.testGet(iterations);

        // Тестирование операции удаления для LinkedList
        linkedListTester.testRemove(iterations);
    }
}