package ru.geekbrains.javaalgoritms.lesson4;

import java.util.*;

/**
 * Сourse: java algorithms
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 4
 * Created 26.02.2021
 * v 1.0
 */
public class Std_HW_Lesson4 {
    /* как я понял общую концепцию задания.
    /  1. необходимо создать самостоятельно (реализовать) стек, очередь, дек и приоритетную очередь причем сделать это на базе массивов.
    /  2. все самостоятельные реализации стека и очередей укомплектовать стандартными для данных коллекций методами
    /  3. отдельно создать стек и очередь реализованные не на базе массива а на базе коллекции объектов.
    /  4. ориентируясь на материал урока подключить и подготовить реализацию вышеперечисленных коллекций средствами библиотеки утиль.
    /  5. выполнить поочередно все стандартные методы для каждой реализации и сравнить результаты замера времени.
    /  грубо говоря берем добавление элемента закидываем в стек (на базе массива),. в очередь, в дек и в приоритетную очередь, результаты замера
    /  времени выводим в таблицу или просто сравниваем, повторяем для других операций.

    /  Оговорки принятые для данного домашнего задания.
    /  Вероятно автор курса ошибся ссылаясь на пункт предыдущего ДЗ 3.4 где требовалась реализация двунаправленного списка
    /  так как материал урока содержит однонаправленный список и обращение к его реализации. да и по логике понятно, что нам необходим
    /  однонаправленный линкованный список. Поэтому пункт обращения к 3.4. игнорирован и заменен на пункт 3.3.
    /  пункт 3.4. принят только в части соблюдения требований заполнения списка объектами своего класса ( в моем случае котами) */

    //приступаем.
    //создаем набор стеков базового (util), собственного на базе массива и собственного на базе объектов
    private static Stack<Cat> stackUtilCat = new Stack<>();                        // методы push(), pop(), peek() - реализованы в базовом классе
    private static MyArrStack<Cat> myArrStack = new MyArrStack<>(8);
    private static MyObjStack<Cat> myObjStack = new MyObjStack<>();
    //создаем очередь базового исполнения библиотеки util
    private static Queue<Cat> queueUtilCat = new LinkedList<>();                        // методы  - реализованы в базовом классе
    private static MyArrQueue<Cat> myArrQueue = new MyArrQueue<>(8);
    private static MyObjQueue<Cat> myObjQueue = new MyObjQueue<>();
    //создаем дек базового исполнения библиотеки util
    private static Deque<Cat> dequeUtilCat;                        // методы  - реализованы в базовом классе
    //создаем приоритетную очередь базового исполнения библиотеки util
    private static PriorityQueue<Cat> priorityQueueUtilCat;        // методы  - реализованы в базовом классе

    private static long timeStart;

    public static void main(String[] args) {
        System.out.println("Домашнее задание №4");

        //*** НАЧАЛО МОДУЛЯ РАБОТЫ СО СТЕКАМИ
        //СТЕКИ ------------  модуль работы с основными методами трех стеков базовым (util) и двумя собственными
        //
        // ТЕСТИРОВАНИЕ СТЕКА ИЗ БИБЛИОТЕКИ UTIL
        // Процедура наполнения стека данными (для теста закидываем в каждый вид стека по 3 одинаковых объекта
        System.out.println();
        System.out.println("Тестирование стека Stack библиотеки Util");
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода push()" + stackUtilCat.push(new Cat("Барсик")));
        System.out.println(" - Результат работы метода push()" + stackUtilCat.push(new Cat("Мурзик")));
        System.out.println(" - Результат работы метода push()" + stackUtilCat.push(new Cat("Дурсик")));
        long tw_StUt_Pu = System.nanoTime() - timeStart;
        // Отображение промежуточного состояния всего стека встроенным методом toString
        System.out.println(" ---> Стек stackUtilCat (базовый)  заполнен: " + stackUtilCat);
        // Процедура - "посмотреть" (peek) на верхний элемент стека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peek()" + stackUtilCat.peek());
        System.out.println(" - Результат работы метода peek()" + stackUtilCat.peek());
        System.out.println(" - Результат работы метода peek()" + stackUtilCat.peek());
        long tw_StUt_Pe = System.nanoTime() - timeStart;
        // Процедура - "снять" (pop) верхний элемент стека (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода pop()" + stackUtilCat.pop());
        System.out.println(" - Результат работы метода pop()" + stackUtilCat.pop());
        System.out.println(" - Результат работы метода pop()" + stackUtilCat.pop());
        long tw_StUt_Po = System.nanoTime() - timeStart;
        // Отображение итогового состояния всего стека встроенным методом toString
        System.out.println("---> Стек stackUtilCat (базовый) итог. вар.: " + stackUtilCat);

        // ТЕСТИРОВАНИЕ собственного СТЕКА MyArrStack реализованного на базе массива
        // Процедура наполнения стека данными (для теста закидываем в каждый вид стека по 3 одинаковых объекта
        System.out.println();
        System.out.println("Тестирование стека MyArrStack реализованного на базе массива");
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода push()" + myArrStack.push(new Cat("Барсик")));
        System.out.println(" - Результат работы метода push()" + myArrStack.push(new Cat("Мурзик")));
        System.out.println(" - Результат работы метода push()" + myArrStack.push(new Cat("Дурсик")));
        long tw_StMA_Pu = System.nanoTime() - timeStart;
        // Отображение промежуточного состояния всего стека встроенным методом toString
        System.out.println(" ---> Стек myArrStack (реализация через массив) заполнен: " + myArrStack);
        // Процедура - "посмотреть" (peek) на верхний элемент стека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peek()" + myArrStack.peek());
        System.out.println(" - Результат работы метода peek()" + myArrStack.peek());
        System.out.println(" - Результат работы метода peek()" + myArrStack.peek());
        long tw_StMA_Pe = System.nanoTime() - timeStart;
        // Процедура - "снять" (pop) верхний элемент стека (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода pop()" + myArrStack.pop());
        System.out.println(" - Результат работы метода pop()" + myArrStack.pop());
        System.out.println(" - Результат работы метода pop()" + myArrStack.pop());
        long tw_StMA_Po = System.nanoTime() - timeStart;
        // Отображение итогового состояния всего стека встроенным методом toString
        System.out.println("---> Стек myArrStack (реализация через массив) итог. вар.: " + myArrStack);

        // ТЕСТИРОВАНИЕ собственного СТЕКА MyObjStack реализованного на базе коллекции объектов (линкованного списка)
        // Процедура наполнения стека данными (для теста закидываем в каждый вид стека по 3 одинаковых объекта
        System.out.println();
        System.out.println("Тестирование стека MyObjStack реализованного на базе коллекции объектов (линкованного списка)");
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода push()" + myObjStack.push(new Cat("Барсик")));
        System.out.println(" - Результат работы метода push()" + myObjStack.push(new Cat("Мурзик")));
        System.out.println(" - Результат работы метода push()" + myObjStack.push(new Cat("Дурсик")));
        long tw_StMO_Pu = System.nanoTime() - timeStart;
        // Отображение промежуточного состояния всего стека встроенным методом toString
        System.out.println(" ---> Стек MyObjStack реализованного на базе коллекции объектов  заполнен: " + myObjStack);
        // Процедура - "посмотреть" (peek) на верхний элемент стека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peek()" + myObjStack.peek());
        System.out.println(" - Результат работы метода peek()" + myObjStack.peek());
        System.out.println(" - Результат работы метода peek()" + myObjStack.peek());
        long tw_StMO_Pe = System.nanoTime() - timeStart;
        // Процедура - "снять" (pop) верхний элемент стека (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода pop()" + myObjStack.pop());
        System.out.println(" - Результат работы метода pop()" + myObjStack.pop());
        System.out.println(" - Результат работы метода pop()" + myObjStack.pop());
        long tw_StMO_Po = System.nanoTime() - timeStart;
        // Отображение итогового состояния всего стека встроенным методом toString
        System.out.println("---> Стек MyObjStack реализованного на базе коллекции объектов итог. вар.: " + myObjStack);
        //СТЕКИ ------------  модуль работы с основными методами трех стеков базовым (util) и двумя собственными
        //*** Конец МОДУЛЯ РАБОТЫ СО СТЕКАМИ

        //*** НАЧАЛО МОДУЛЯ РАБОТЫ С ОЧЕРЕДЯМИ
        //ОЧЕРЕДИ ------------  модуль работы с основными методами трех очередей базовым (util) и двумя собственными
        //
        // ТЕСТИРОВАНИЕ ОЧЕРЕДИ ИЗ БИБЛИОТЕКИ UTIL
        // Процедура наполнения стека данными (для теста закидываем в каждый вид стека по 3 одинаковых объекта
        System.out.println();
        System.out.println("Тестирование очереди Queue библиотеки Util");
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода offer()" + (queueUtilCat.offer(new Cat("Барсик"))? " true - элемент "+ new Cat("Барсик") + " добавлен в очередь.": "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offer()" + (queueUtilCat.offer(new Cat("Мурзик"))? " true - элемент "+ new Cat("Мурзик") + " добавлен в очередь.": "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offer()" + (queueUtilCat.offer(new Cat("Дурсик"))? " true - элемент "+ new Cat("Дурсик") + " добавлен в очередь.": "Ошибка! Элемент не добавлен в очередь."));
        long tw_QuUt_Pu = System.nanoTime() - timeStart;
        // Отображение промежуточного состояния всего стека встроенным методом toString
        System.out.println(" ---> Очередь (по представлению toString) для queueUtilCat (базовый)  заполнена: " + queueUtilCat);
        // Процедура - "посмотреть" (peek) на верхний элемент стека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peek()" + queueUtilCat.peek());
        System.out.println(" - Результат работы метода peek()" + queueUtilCat.peek());
        System.out.println(" - Результат работы метода peek()" + queueUtilCat.peek());
        long tw_QuUt_Pe = System.nanoTime() - timeStart;
        // Процедура - "снять" (pop) верхний элемент стека (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода poll()" + queueUtilCat.poll());
        System.out.println(" - Результат работы метода poll()" + queueUtilCat.poll());
        System.out.println(" - Результат работы метода poll()" + queueUtilCat.poll());
        long tw_QuUt_Po = System.nanoTime() - timeStart;
        // Отображение итогового состояния всего стека встроенным методом toString
        System.out.println("---> Очередь queueUtilCat итог. вар.: " + queueUtilCat);

        // ТЕСТИРОВАНИЕ собственной ОЧЕРЕДИ MyArrQueue реализованного на базе массива
        // Процедура наполнения стека данными (для теста закидываем в каждый вид стека по 3 одинаковых объекта
        System.out.println();
        System.out.println("Тестирование очереди Queue библиотеки Util");
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода offer()" + (myArrQueue.offer(new Cat("Барсик"))? " true - элемент "+ new Cat("Барсик") + " добавлен в очередь.": "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offer()" + (myArrQueue.offer(new Cat("Мурзик"))? " true - элемент "+ new Cat("Мурзик") + " добавлен в очередь.": "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offer()" + (myArrQueue.offer(new Cat("Дурсик"))? " true - элемент "+ new Cat("Дурсик") + " добавлен в очередь.": "Ошибка! Элемент не добавлен в очередь."));
        long tw_QuMA_Pu = System.nanoTime() - timeStart;
        // Отображение промежуточного состояния всего стека встроенным методом toString
        System.out.println(" ---> Очередь (по представлению toString) для myArrQueue заполнена: " + myArrQueue);
        // Процедура - "посмотреть" (peek) на верхний элемент стека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peek()" + myArrQueue.peek());
        System.out.println(" - Результат работы метода peek()" + myArrQueue.peek());
        System.out.println(" - Результат работы метода peek()" + myArrQueue.peek());
        long tw_QuMA_Pe = System.nanoTime() - timeStart;
        // Процедура - "снять" (pop) верхний элемент стека (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода poll()" + myArrQueue.poll());
        System.out.println(" - Результат работы метода poll()" + myArrQueue.poll());
        System.out.println(" - Результат работы метода poll()" + myArrQueue.poll());
        long tw_QuMA_Po = System.nanoTime() - timeStart;
        // Отображение итогового состояния всего стека встроенным методом toString
        System.out.println("---> Очередь myArrQueue итог. вар.: " + myArrQueue);

        // ТЕСТИРОВАНИЕ собственной ОЧЕРЕДИ MyObjQueue реализованного на базе коллекции объектов (линкованного списка)
        // выполняются по три равнозначных или одинаковых запроса для усреднения результата замера времени
        System.out.println();
        System.out.println("Тестирование очереди MyObjQueue реализованного на базе коллекции объектов (линкованного списка)");
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода offer()" + myObjQueue.offer(new Cat("Барсик")));
        System.out.println(" - Результат работы метода offer()" + myObjQueue.offer(new Cat("Мурзик")));
        System.out.println(" - Результат работы метода offer()" + myObjQueue.offer(new Cat("Дурсик")));
        long tw_QuMO_Pu = System.nanoTime() - timeStart;
        // Отображение промежуточного состояния всего стека встроенным методом toString
        System.out.println(" ---> Очередь (по представлению toString) для myObjQueue заполнена: " + myObjQueue);
        // Процедура - "посмотреть" (peek) на верхний элемент стека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peek()" + myObjQueue.peek());
        System.out.println(" - Результат работы метода peek()" + myObjQueue.peek());
        System.out.println(" - Результат работы метода peek()" + myObjQueue.peek());
        long tw_QuMO_Pe = System.nanoTime() - timeStart;
        // Процедура - "снять" (pop) верхний элемент стека (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода poll()" + myObjQueue.poll());
        System.out.println(" - Результат работы метода poll()" + myObjQueue.poll());
        System.out.println(" - Результат работы метода poll()" + myObjQueue.poll());
        long tw_QuMO_Po = System.nanoTime() - timeStart;
        // Отображение итогового состояния всй очереди встроенным методом toString
        System.out.println("---> Очередь myObjQueue итог. вар.: " + myObjQueue);





        // вывод сводного результата
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------- Таблица 4.1 ---");
        System.out.println("- Type  - Action(n-el) -     Stack       ---      Queue      ---      Deque      ---  PriorityQueue  -");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("- Util  -              - " + tw_StUt_Pu + " ns  ---  " + tw_QuUt_Pu + " ns  ---  0123456789 ns  ---  0123456789 ns  -");
        System.out.println("- MyArr -  push(3 шт.) - " + tw_StMA_Pu + " ns  ---  " + tw_QuMA_Pu + " ns  ---  0123456789 ns  ---  0123456789 ns  -");
        System.out.println("- MyObj -              - " + tw_StMO_Pu + " ns  ---  " + tw_QuMO_Pu + " ns  ---  0123456789 ns  ---  0123456789 ns  -");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("- Util  -              - " + tw_StUt_Pe + " ns  ---  " + tw_QuUt_Pe + " ns  ---  0123456789 ns  ---  0123456789 ns  -");
        System.out.println("- MyArr -  peek()      - " + tw_StMA_Pe + " ns  ---  " + tw_QuMA_Pe + " ns  ---  0123456789 ns  ---  0123456789 ns  -");
        System.out.println("- MyObj -              - " + tw_StMO_Pe + " ns  ---  " + tw_QuMO_Pe + " ns  ---  0123456789 ns  ---  0123456789 ns  -");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("- Util  -              - " + tw_StUt_Po + " ns  ---  " + tw_QuUt_Po + " ns  ---  0123456789 ns  ---  0123456789 ns  -");
        System.out.println("- MyArr -   pop()      - " + tw_StMA_Po + " ns  ---  " + tw_QuMA_Po + " ns  ---  0123456789 ns  ---  0123456789 ns  -");
        System.out.println("- MyObj -              - " + tw_StMO_Po + " ns  ---  " + tw_QuMO_Po + " ns  ---  0123456789 ns  ---  0123456789 ns  -");
        System.out.println("------------------------------------------------------------------------------------------------------");


    }


}
