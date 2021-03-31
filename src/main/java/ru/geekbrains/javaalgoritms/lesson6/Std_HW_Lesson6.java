package ru.geekbrains.javaalgoritms.lesson6;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

/**
 * Сourse: java algorithms
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 6
 * Created 01.03.2021
 * v 1.0
 */
public class Std_HW_Lesson6 {
    //6.1. Приведите пример использования древовидной структуры.
    // Ответ: Древовидная структура, являясь одним из способов представления иерархической структуры, широко используется
    // в теории управления, в статистике, в связи, в информатике, да много где еще.
    // пример в связи - структура локальных вычислительных сетей (од на из топологий);
    // в статистике  - древовидная структура электронных мониторинговых систем;
    // в управлении  - организационная структура структурного подразделения;
    // в информатике (программирование) частный случай иерархической структуры данных  - двоичное дерево, пирамида (куча).

    public static void main(String[] args) {
        Random random = new Random();
        MyTree tree = new MyTree();
        // добавляем некоторое количество уникальных узлов в дерево (замеряем время операции):
        long timeStart = System.nanoTime();
        System.out.println("Добавляем узел с ключом 4 ..." + tree.insertNode(4));
        System.out.println("Добавляем узел с ключом 9 ..." + tree.insertNode(9));
        System.out.println("Добавляем узел с ключом 12 ..." + tree.insertNode(12));
        System.out.println("Добавляем узел с ключом 5 ..." + tree.insertNode(5));
        System.out.println("Добавляем узел с ключом 8 ..." + tree.insertNode(8));
        System.out.println("Добавляем узел с ключом 2 ..." + tree.insertNode(2));
        System.out.println("Добавляем узел с ключом 1 ..." + tree.insertNode(1));
        System.out.println("Добавляем узел с ключом 7 ..." + tree.insertNode(7));
        System.out.println("Добавляем узел с ключом 3 ..." + tree.insertNode(3));
        System.out.println("Добавляем узел с ключом 6 ..." + tree.insertNode(6));
        long timeStop = System.nanoTime();
        System.out.println("Вставка 10 элементов в дерево заняла: " + (timeStop - timeStart) + " ns");
        System.out.println("В среднем, время добавления одного элемента: " + (timeStop - timeStart) / 10 + " ns");
        System.out.println("Пытаемся добавить несколько значений с ключами уже существующими в дереве");
        timeStart = System.nanoTime();
        System.out.println("Добавляем узел с ключом 7 ..." + tree.insertNode(7));
        System.out.println("Добавляем узел с ключом 3 ..." + tree.insertNode(3));
        System.out.println("Добавляем узел с ключом 6 ..." + tree.insertNode(6));
        timeStop = System.nanoTime();
        System.out.println("Попытка добавить 3 элемента с неуникальными ключами в дерево заняла: " + (timeStop - timeStart) + " ns");
        System.out.println("В среднем, время действия одного элемента: " + (timeStop - timeStart) / 10 + " ns");
        System.out.println("Добавляем еще 10 элементов в разнобой, с уникальным и неуникальным ключом (случайно)");
        timeStart = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            int rnd = random.nextInt(20);
            System.out.println("Добавляем узел с ключом " + rnd + " ..." + tree.insertNode(rnd));
        }
        timeStop = System.nanoTime();
        System.out.println("Попытка добавить 10 элемента со случайными ключами в дерево заняла: " + (timeStop - timeStart) + " ns");
        System.out.println("В среднем, время действия одного элемента: " + (timeStop - timeStart) / 10 + " ns");

        // простое отображение дерева решил сделать через переопределение toString:
        tree.simplePrintTree();

        // находим узел по значению и выводим его в консоли
        int rnd = random.nextInt(20);
        System.out.println("Пытаемся найти элемент с индексом " + rnd);
        timeStart = System.nanoTime();
        Node foundNode = tree.findNodeByValue(rnd);
        if (foundNode != null) {
            System.out.println("Элемент с индексом " + rnd);
            System.out.println("Узел найден :" + foundNode);
        } else {
            System.out.println("Элемент с индексом не найден" + rnd);
            System.out.println("Значение, которое вернул метод:" + foundNode);
        }
        timeStop = System.nanoTime();
        System.out.println("Попытка найти элемент со случайным ключом равным " + rnd + " заняла: " + (timeStop - timeStart) + " ns");

        // удаляем один, ранее найденный, узел и выводим оставшееся дерево в консоли
        System.out.println("Пытаемся удалить элемент с индексом " + rnd);
        timeStart = System.nanoTime();
        tree.deleteNode(rnd);
        timeStop = System.nanoTime();
        System.out.println("Попытка удалить элемент со случайным ключом равным " + rnd + " заняла: " + (timeStop - timeStart) + " ns");
        // состояние дерева после удаления элемента
        tree.simplePrintTree();

        //6.4  ...поиск максимума и минимума.
        System.out.println("\n Задание 6.4 выполнение.");
        System.out.println("Поиск максимума");
        timeStop = System.nanoTime();
        System.out.println("      максимальное значение " + tree.getMax());
        System.out.println("      - Получение максимального значения заняло: " + (timeStop - timeStart) + " ns");
        System.out.println("  Альтернативное решение: именно поиск максимума");
        timeStop = System.nanoTime();
        System.out.println("      максимальное значение " + tree.findMax());
        System.out.println("      - Поиск максимального значения занял: " + (timeStop - timeStart) + " ns");

        System.out.println("Поиск минимума");
        timeStop = System.nanoTime();
        System.out.println("  Минимальное значение" + tree.getMin());
        System.out.println("      - Получение минимального значения заняло: " + (timeStop - timeStart) + " ns");
        System.out.println("  Альтернативное решение: именно поиск минимума");
        timeStop = System.nanoTime();
        System.out.println("      Минимальное значение" + tree.findMin());
        System.out.println("      - Поиск минимального значения занял: " + (timeStop - timeStart) + " ns");

        //6.6  ...алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.
        System.out.println("\n Задание 6.6 выполнение.");
        int[] arrTest = new int[10];
        for (int i = 0; i < arrTest.length; i++) {
            arrTest[i] = random.nextInt(10);
        }
        System.out.println("Не сортированный (исходный массив) :" + Arrays.toString(arrTest));
        timeStart = System.nanoTime();
        MyHeap myHeap = new MyHeap();
        myHeap.sort(arrTest);
        System.out.println("Сортировка " + arrTest.length + " элементов заняла: " + (System.nanoTime() - timeStart) + " ns");
        System.out.println("Результат myHeap сортировки массива:" + Arrays.toString(arrTest));

    }


    //6.7 Приведите пример сбалансированного дерева и его применения.
    // Ответ:
    //
    //
    // несколько схем идеально сбалансированных деревьев:
    //                  0                       0             0
    //                /   \                   /   \
    //              0       0                 0   0
    //            /   \   /   \
    //            0   0   0   0
    //                          \
    //                          0

    public static int rnd(int max) {
        return (int) (Math.random() * ++max);
    }
}
