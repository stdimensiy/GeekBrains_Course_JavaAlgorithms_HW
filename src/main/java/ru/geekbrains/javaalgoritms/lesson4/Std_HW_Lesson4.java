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
    private static final Stack<Cat> stackUtilCat = new Stack<>();                        // методы push(), pop(), peek() - реализованы в базовом классе
    private static final MyArrStack<Cat> myArrStack = new MyArrStack<>(8);
    private static final MyObjStack<Cat> myObjStack = new MyObjStack<>();
    //создаем очередь базового исполнения библиотеки util
    private static final Queue<Cat> queueUtilCat = new LinkedList<>();                    // методы offer(), peek(), poll() - реализованы в базовом классе
    private static final MyArrQueue<Cat> myArrQueue = new MyArrQueue<>(8);         // взяты за основу и реализованы в собственных
    private static final MyObjQueue<Cat> myObjQueue = new MyObjQueue<>();                 // в собственных версиях очереди
    //создаем дек базового исполнения библиотеки util
    private static final Deque<Cat> dequeUtilCat = new ArrayDeque<>(8);        // методы offerFirst(), offerLast(), peekFirst()
    private static final MyArrDeque<Cat> myArrDeque = new MyArrDeque<>(8);         // peekLast(), poolFirst(), poolLast() - взяты за основу
    private static final MyObjDeque<Cat> myObjDeque = new MyObjDeque<>();                 // и реализованы в собственных версиях дека
    //создаем приоритетную очередь базового исполнения библиотеки util
    private static final PriorityQueue<Cat> priorityQueueUtilCat = new PriorityQueue<>(); // Приоритетная очередь объявления и инициирована для собственного класса Сат
    // для оформления
    private static String tw_StUt_NP = "      ....   ";                                   // пустая вставка для таблицы

    private static long timeStart;


    private static TableInfo tableInfo = new TableInfo();

    public static void main(String[] args) {
        System.out.println("Домашнее задание №4");

        //*** НАЧАЛО МОДУЛЯ РАБОТЫ СО СТЕКАМИ
        //СТЕКИ ------------  модуль работы с основными методами трех стеков, базовым (util) и двумя собственными
        //
        // ТЕСТИРОВАНИЕ СТЕКА ИЗ БИБЛИОТЕКИ UTIL
        // Процедура наполнения стека данными (для тестирования закидываем в каждый вид стека по 3 одинаковых объекта
        System.out.println();
        System.out.println("Тестирование стека Stack библиотеки Util");
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода push()" + stackUtilCat.push(new Cat("Барсик")));
        System.out.println(" - Результат работы метода push()" + stackUtilCat.push(new Cat("Мурзик")));
        System.out.println(" - Результат работы метода push()" + stackUtilCat.push(new Cat("Дурсик")));
        String tw_StUt_Pu = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setStack(TableInfo.R_OFFER_LAST_UTIL, System.nanoTime() - timeStart);
        // Отображение промежуточного состояния всего стека встроенным методом toString
        System.out.println(" ---> Стек stackUtilCat (базовый)  заполнен: " + stackUtilCat);
        // Процедура - "посмотреть" (peek) на верхний элемент стека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peek()" + stackUtilCat.peek());
        System.out.println(" - Результат работы метода peek()" + stackUtilCat.peek());
        System.out.println(" - Результат работы метода peek()" + stackUtilCat.peek());
        String tw_StUt_Pe = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setStack(TableInfo.R_PEEK_LAST_UTIL, System.nanoTime() - timeStart);
        // Процедура - "снять" (pop) верхний элемент стека (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода pop()" + stackUtilCat.pop());
        System.out.println(" - Результат работы метода pop()" + stackUtilCat.pop());
        System.out.println(" - Результат работы метода pop()" + stackUtilCat.pop());
        String tw_StUt_Po = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setStack(TableInfo.R_POLL_FIRST_UTIL, System.nanoTime() - timeStart);
        // Отображение итогового состояния всего стека встроенным методом toString
        System.out.println("---> Стек stackUtilCat (базовый) итог. вар.: " + stackUtilCat);

        // ТЕСТИРОВАНИЕ собственного СТЕКА MyArrStack реализованного на базе массива
        System.out.println();
        System.out.println("Тестирование стека MyArrStack реализованного на базе массива");
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода push()" + myArrStack.push(new Cat("Барсик")));
        System.out.println(" - Результат работы метода push()" + myArrStack.push(new Cat("Мурзик")));
        System.out.println(" - Результат работы метода push()" + myArrStack.push(new Cat("Дурсик")));
        String tw_StMA_Pu = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setStack(TableInfo.R_OFFER_LAST_MYARR, System.nanoTime() - timeStart);
        // Отображение промежуточного состояния всего стека встроенным методом toString
        System.out.println(" ---> Стек myArrStack (реализация через массив) заполнен: " + myArrStack);
        // Процедура - "посмотреть" (peek) на верхний элемент стека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peek()" + myArrStack.peek());
        System.out.println(" - Результат работы метода peek()" + myArrStack.peek());
        System.out.println(" - Результат работы метода peek()" + myArrStack.peek());
        String tw_StMA_Pe = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setStack(TableInfo.R_PEEK_LAST_MYARR, System.nanoTime() - timeStart);
        // Процедура - "снять" (pop) верхний элемент стека (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода pop()" + myArrStack.pop());
        System.out.println(" - Результат работы метода pop()" + myArrStack.pop());
        System.out.println(" - Результат работы метода pop()" + myArrStack.pop());
        String tw_StMA_Po = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setStack(TableInfo.R_POLL_FIRST_MYARR, System.nanoTime() - timeStart);
        // Отображение итогового состояния всего стека встроенным методом toString
        System.out.println("---> Стек myArrStack (реализация через массив) итог. вар.: " + myArrStack);

        // ТЕСТИРОВАНИЕ собственного СТЕКА MyObjStack реализованного на базе коллекции объектов (линкованного списка)
        System.out.println();
        System.out.println("Тестирование стека MyObjStack реализованного на базе коллекции объектов (линкованного списка)");
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода push()" + myObjStack.push(new Cat("Барсик")));
        System.out.println(" - Результат работы метода push()" + myObjStack.push(new Cat("Мурзик")));
        System.out.println(" - Результат работы метода push()" + myObjStack.push(new Cat("Дурсик")));
        String tw_StMO_Pu = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setStack(TableInfo.R_OFFER_LAST_MYOBJ, System.nanoTime() - timeStart);
        // Отображение промежуточного состояния всего стека встроенным методом toString
        System.out.println(" ---> Стек MyObjStack реализованного на базе коллекции объектов заполнен: " + myObjStack);
        // Процедура - "посмотреть" (peek) на верхний элемент стека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peek()" + myObjStack.peek());
        System.out.println(" - Результат работы метода peek()" + myObjStack.peek());
        System.out.println(" - Результат работы метода peek()" + myObjStack.peek());
        String tw_StMO_Pe = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setStack(TableInfo.R_PEEK_LAST_MYOBJ, System.nanoTime() - timeStart);
        // Процедура - "снять" (pop) верхний элемент стека (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода pop()" + myObjStack.pop());
        System.out.println(" - Результат работы метода pop()" + myObjStack.pop());
        System.out.println(" - Результат работы метода pop()" + myObjStack.pop());
        String tw_StMO_Po = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setStack(TableInfo.R_POLL_FIRST_MYOBJ, System.nanoTime() - timeStart);
        // Отображение итогового состояния всего стека встроенным методом toString
        System.out.println("---> Стек MyObjStack реализованного на базе коллекции объектов итог. вар.: " + myObjStack);
        //СТЕКИ ------------  модуль работы с основными методами трех стеков базовым (util) и двумя собственными
        //*** Конец МОДУЛЯ РАБОТЫ СО СТЕКАМИ

        //*** НАЧАЛО МОДУЛЯ РАБОТЫ С ОЧЕРЕДЯМИ
        //ОЧЕРЕДИ ------------  модуль работы с основными методами трех очередей, базовой (util) и двумя собственными
        //
        // ТЕСТИРОВАНИЕ ОЧЕРЕДИ ИЗ БИБЛИОТЕКИ UTIL
        // Процедура наполнения стека данными (для теста закидываем в каждый вид очереди по 3 одинаковых объекта
        System.out.println();
        System.out.println("Тестирование очереди Queue библиотеки Util");
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода offer()" + (queueUtilCat.offer(new Cat("Барсик")) ? " true - элемент " + new Cat("Барсик") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offer()" + (queueUtilCat.offer(new Cat("Мурзик")) ? " true - элемент " + new Cat("Мурзик") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offer()" + (queueUtilCat.offer(new Cat("Дурсик")) ? " true - элемент " + new Cat("Дурсик") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        String tw_QuUt_Pu = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setQueue(TableInfo.R_OFFER_LAST_UTIL, System.nanoTime() - timeStart);
        // Отображение промежуточного состояния всей очереди встроенным методом toString
        System.out.println(" ---> Очередь (по представлению toString) для queueUtilCat (базовый) заполнена: " + queueUtilCat);
        // Процедура - "посмотреть" (peek) на фронтальный элемент очереди (выход) (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peek()" + queueUtilCat.peek());
        System.out.println(" - Результат работы метода peek()" + queueUtilCat.peek());
        System.out.println(" - Результат работы метода peek()" + queueUtilCat.peek());
        String tw_QuUt_Pe = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setQueue(TableInfo.R_PEEK_LAST_UTIL, System.nanoTime() - timeStart);
        // Процедура - "снять" (pop) фронтальный элемент очереди (выход) и стереть его
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода poll()" + queueUtilCat.poll());
        System.out.println(" - Результат работы метода poll()" + queueUtilCat.poll());
        System.out.println(" - Результат работы метода poll()" + queueUtilCat.poll());
        String tw_QuUt_Po = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setQueue(TableInfo.R_POLL_FIRST_UTIL, System.nanoTime() - timeStart);
        // Отображение итогового состояния всей очереди встроенным методом toString
        System.out.println("---> Очередь queueUtilCat после всех модификаций итог. вар.: " + queueUtilCat);

        // ТЕСТИРОВАНИЕ собственной ОЧЕРЕДИ MyArrQueue реализованной на базе массива
        System.out.println();
        System.out.println("Тестирование очереди myArrQueue реализованного на базе массива");
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода offer()" + (myArrQueue.offer(new Cat("Барсик")) ? " true - элемент " + new Cat("Барсик") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offer()" + (myArrQueue.offer(new Cat("Мурзик")) ? " true - элемент " + new Cat("Мурзик") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offer()" + (myArrQueue.offer(new Cat("Дурсик")) ? " true - элемент " + new Cat("Дурсик") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        String tw_QuMA_Pu = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setQueue(TableInfo.R_OFFER_LAST_MYARR, System.nanoTime() - timeStart);
        // Отображение промежуточного состояния всей очереди встроенным методом toString
        System.out.println(" ---> Очередь (по представлению toString) для myArrQueue заполнена: " + myArrQueue);
        // Процедура - "посмотреть" (peek) на фронтальный элемент очереди (выход) (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peek()" + myArrQueue.peek());
        System.out.println(" - Результат работы метода peek()" + myArrQueue.peek());
        System.out.println(" - Результат работы метода peek()" + myArrQueue.peek());
        String tw_QuMA_Pe = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setQueue(TableInfo.R_PEEK_LAST_MYARR, System.nanoTime() - timeStart);
        // Процедура - "снять" (pop) фронтальный элемент очереди (выход) и стереть его
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода poll()" + myArrQueue.poll());
        System.out.println(" - Результат работы метода poll()" + myArrQueue.poll());
        System.out.println(" - Результат работы метода poll()" + myArrQueue.poll());
        String tw_QuMA_Po = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setQueue(TableInfo.R_POLL_FIRST_MYARR, System.nanoTime() - timeStart);
        // Отображение итогового состояния всей очереди встроенным методом toString
        System.out.println("---> Очередь myArrQueue итог. вар.: " + myArrQueue);

        // ТЕСТИРОВАНИЕ собственной ОЧЕРЕДИ MyObjQueue реализованного на базе коллекции объектов (линкованного списка)
        System.out.println();
        System.out.println("Тестирование очереди MyObjQueue реализованного на базе коллекции объектов (линкованного списка)");
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода offer()" + myObjQueue.offer(new Cat("Барсик")));
        System.out.println(" - Результат работы метода offer()" + myObjQueue.offer(new Cat("Мурзик")));
        System.out.println(" - Результат работы метода offer()" + myObjQueue.offer(new Cat("Дурсик")));
        String tw_QuMO_Pu = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setQueue(TableInfo.R_OFFER_LAST_MYOBJ, System.nanoTime() - timeStart);
        // Отображение промежуточного состояния всей очереди встроенным методом toString
        System.out.println(" ---> Очередь (по представлению toString) для myObjQueue заполнена: " + myObjQueue);
        // Процедура - "посмотреть" (peek) на фронтальный элемент очереди (выход) (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peek()" + myObjQueue.peek());
        System.out.println(" - Результат работы метода peek()" + myObjQueue.peek());
        System.out.println(" - Результат работы метода peek()" + myObjQueue.peek());
        String tw_QuMO_Pe = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setQueue(TableInfo.R_PEEK_LAST_MYOBJ, System.nanoTime() - timeStart);
        // Процедура - "снять" (pop) фронтальный элемент очереди (выход) и стереть его
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода poll()" + myObjQueue.poll());
        System.out.println(" - Результат работы метода poll()" + myObjQueue.poll());
        System.out.println(" - Результат работы метода poll()" + myObjQueue.poll());
        String tw_QuMO_Po = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setQueue(TableInfo.R_POLL_FIRST_MYOBJ, System.nanoTime() - timeStart);
        // Отображение итогового состояния всй очереди встроенным методом toString
        System.out.println("---> Очередь myObjQueue итог. вар.: " + myObjQueue);
        //
        //ОЧЕРЕДИ ------------  модуль работы с основными методами трех реализаций очереди базовой (util) и двумя собственными
        //*** Конец МОДУЛЯ РАБОТЫ С ОЧЕРЕДЯМИ

        //*** НАЧАЛО МОДУЛЯ РАБОТЫ С ДВУНАПРАВЛЕННЫМИ ОЧЕРЕДЯМИ (ДЕКАМИ)
        //ДЕКИ ------------  модуль работы с основными методами трех реализаций двунаправленной очередей, базовой (util) и двух собственных
        //
        // ТЕСТИРОВАНИЕ ДЕКИ ИЗ БИБЛИОТЕКИ UTIL
        // Процедура наполнения ДЕКи данными (для теста закидываем в каждый метод и вид по 3 одинаковых объекта (метода)
        System.out.println();
        System.out.println("Тестирование очереди Queue библиотеки Util");
        // добавляем элементы в хвост очереди (как обычно)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода offerLast()" + (dequeUtilCat.offerLast(new Cat("Барсик")) ? " true - элемент " + new Cat("Барсик") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offerLast()" + (dequeUtilCat.offerLast(new Cat("Мурзик")) ? " true - элемент " + new Cat("Мурзик") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offerLast()" + (dequeUtilCat.offerLast(new Cat("Дурсик")) ? " true - элемент " + new Cat("Дурсик") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        String tw_DeUt_Pu = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_OFFER_LAST_UTIL, System.nanoTime() - timeStart);
        // добавляем элементы в голову очереди (вот это уже особенность)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода offerFirst()" + (dequeUtilCat.offerFirst(new Cat("Мурка")) ? " true - элемент " + new Cat("Мурка") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offerFirst()" + (dequeUtilCat.offerFirst(new Cat("Алиса")) ? " true - элемент " + new Cat("Алиса") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offerFirst()" + (dequeUtilCat.offerFirst(new Cat("Джина")) ? " true - элемент " + new Cat("Джина") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        String tw_DeUt_Pl = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_OFFER_FIRST_UTIL, System.nanoTime() - timeStart);
        // Отображение промежуточного состояния всей очереди встроенным методом toString
        System.out.println(" ---> Очередь (по представлению toString) для dequeUtilCat (базовый)  заполнена: " + dequeUtilCat);
        // Процедура - "посмотреть" (peekFirst) на элемент головы дека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peekFirst()" + dequeUtilCat.peekFirst());
        System.out.println(" - Результат работы метода p317eekFirst()" + dequeUtilCat.peekFirst());
        System.out.println(" - Результат работы метода peekFirst()" + dequeUtilCat.peekFirst());
        String tw_DeUt_Pe = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_PEEK_FIRST_UTIL, System.nanoTime() - timeStart);
        // Процедура - "посмотреть" (peekLast) на элемент хвоста дека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peekLast()" + dequeUtilCat.peekLast());
        System.out.println(" - Результат работы метода peekLast()" + dequeUtilCat.peekLast());
        System.out.println(" - Результат работы метода peekLast()" + dequeUtilCat.peekLast());
        String tw_DeUt_Pk = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_PEEK_LAST_UTIL, System.nanoTime() - timeStart);
        // Процедура - "снять" (pollFirst) верхний элемент из головы очереди (дека) (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода pollFirst()" + dequeUtilCat.pollFirst());
        System.out.println(" - Результат работы метода pollFirst()" + dequeUtilCat.pollFirst());
        System.out.println(" - Результат работы метода pollFirst()" + dequeUtilCat.pollFirst());
        String tw_DeUt_Po = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_POLL_FIRST_UTIL, System.nanoTime() - timeStart);
        // Процедура - "снять" (pollFirst) крайний элемент из хвоста очереди (дека) (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода pollLast()" + dequeUtilCat.pollLast());
        System.out.println(" - Результат работы метода pollLast()" + dequeUtilCat.pollLast());
        System.out.println(" - Результат работы метода pollLast()" + dequeUtilCat.pollLast());
        String tw_DeUt_Pd = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_POLL_LAST_UTIL, System.nanoTime() - timeStart);
        // Отображение итогового состояния всй очереди встроенным методом toString
        System.out.println("---> Очередь dequeUtilCat итог. вар.: " + dequeUtilCat);

        // ТЕСТИРОВАНИЕ  собственной ДЕКИ MyArrDeque реализованной на базе массива
        System.out.println();
        System.out.println("Тестирование собственной реализации двунаправленной очереди myArrDeque на базе массива");
        // добавляем элементы в хвост очереди ( как обычно)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода offerLast()" + (myArrDeque.offerLast(new Cat("Барсик")) ? " true - элемент " + new Cat("Барсик") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offerLast()" + (myArrDeque.offerLast(new Cat("Мурзик")) ? " true - элемент " + new Cat("Мурзик") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offerLast()" + (myArrDeque.offerLast(new Cat("Дурсик")) ? " true - элемент " + new Cat("Дурсик") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        String tw_DeMA_Pu = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_OFFER_LAST_MYARR, System.nanoTime() - timeStart);
        // добавляем элементы в голову очереди (вот это уже особенность)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода offerFirst()" + (myArrDeque.offerFirst(new Cat("Мурка")) ? " true - элемент " + new Cat("Мурка") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offerFirst()" + (myArrDeque.offerFirst(new Cat("Алиса")) ? " true - элемент " + new Cat("Алиса") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offerFirst()" + (myArrDeque.offerFirst(new Cat("Джина")) ? " true - элемент " + new Cat("Джина") + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        String tw_DeMA_Pl = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_OFFER_FIRST_MYARR, System.nanoTime() - timeStart);
        // Отображение промежуточного состояния всей очереди встроенным методом toString
        System.out.println(" ---> Дека (по представлению toString) для myArrDeque заполнена: " + myArrDeque);
        // Процедура - "посмотреть" (peekFirst) на элемент головы дека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peekFirst()" + myArrDeque.peekFirst());
        System.out.println(" - Результат работы метода peekFirst()" + myArrDeque.peekFirst());
        System.out.println(" - Результат работы метода peekFirst()" + myArrDeque.peekFirst());
        String tw_DeMA_Pe = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_PEEK_FIRST_MYARR, System.nanoTime() - timeStart);
        // Процедура - "посмотреть" (peekLast) на элемент хвоста дека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peekLast()" + myArrDeque.peekLast());
        System.out.println(" - Результат работы метода peekLast()" + myArrDeque.peekLast());
        System.out.println(" - Результат работы метода peekLast()" + myArrDeque.peekLast());
        String tw_DeMA_Pk = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_PEEK_LAST_MYARR, System.nanoTime() - timeStart);
        // Процедура - "снять" (pollFirst) верхний элемент из головы очереди (дека) (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода pollFirst()" + myArrDeque.pollFirst());
        System.out.println(" - Результат работы метода pollFirst()" + myArrDeque.pollFirst());
        System.out.println(" - Результат работы метода pollFirst()" + myArrDeque.pollFirst());
        String tw_DeMA_Po = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_POLL_FIRST_MYARR, System.nanoTime() - timeStart);
        // Процедура - "снять" (pollFirst) крайний элемент из хвоста очереди (дека) (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода pollLast()" + myArrDeque.pollLast());
        System.out.println(" - Результат работы метода pollLast()" + myArrDeque.pollLast());
        System.out.println(" - Результат работы метода pollLast()" + myArrDeque.pollLast());
        String tw_DeMA_Pd = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_POLL_LAST_MYARR, System.nanoTime() - timeStart);
        // Отображение итогового состояния всй очереди (дек) встроенным методом toString
        System.out.println("---> Дека myArrDeque итог. вар.: " + myArrDeque);

        // ТЕСТИРОВАНИЕ  собственной ДЕКи MyObjDeque реализованной на базе списка линкованных элементов
        System.out.println();
        System.out.println("Тестирование собственной реализации двунаправленной очереди myArrDeque на базе массива");
        // добавляем элементы в хвост очереди ( как обычно)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода offerLast()" + myObjDeque.offerLast(new Cat("Барсик")));
        System.out.println(" - Результат работы метода offerLast()" + myObjDeque.offerLast(new Cat("Мурзик")));
        System.out.println(" - Результат работы метода offerLast()" + myObjDeque.offerLast(new Cat("Дурсик")));
        String tw_DeMO_Pu = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_OFFER_LAST_MYOBJ, System.nanoTime() - timeStart);
        // добавляем элементы в голову очереди (вот это уже особенность)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода offerFirst()" + myObjDeque.offerFirst(new Cat("Мурка")));
        System.out.println(" - Результат работы метода offerFirst()" + myObjDeque.offerFirst(new Cat("Алиса")));
        System.out.println(" - Результат работы метода offerFirst()" + myObjDeque.offerFirst(new Cat("Джина")));
        String tw_DeMO_Pl = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_OFFER_FIRST_MYOBJ, System.nanoTime() - timeStart);
        // Отображение промежуточного состояния деки встроенным методом toString
        System.out.println(" ---> Дека (по представлению toString) для myObjDeque заполнена: " + myObjDeque);
        // Процедура - "посмотреть" (peekFirst) на элемент головы дека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peekFirst()" + myObjDeque.peekFirst());
        System.out.println(" - Результат работы метода peekFirst()" + myObjDeque.peekFirst());
        System.out.println(" - Результат работы метода peekFirst()" + myObjDeque.peekFirst());
        String tw_DeMO_Pe = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_PEEK_FIRST_MYOBJ, System.nanoTime() - timeStart);
        // Процедура - "посмотреть" (peekLast) на элемент хвоста дека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peekLast()" + myObjDeque.peekLast());
        System.out.println(" - Результат работы метода peekLast()" + myObjDeque.peekLast());
        System.out.println(" - Результат работы метода peekLast()" + myObjDeque.peekLast());
        String tw_DeMO_Pk = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_PEEK_LAST_MYOBJ, System.nanoTime() - timeStart);
        // Процедура - "снять" (pollFirst) верхний элемент из головы очереди (дека) (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода pollFirst()" + myObjDeque.pollFirst());
        System.out.println(" - Результат работы метода pollFirst()" + myObjDeque.pollFirst());
        System.out.println(" - Результат работы метода pollFirst()" + myObjDeque.pollFirst());
        String tw_DeMO_Po = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_POLL_FIRST_MYOBJ, System.nanoTime() - timeStart);
        // Процедура - "снять" (pollFirst) крайний элемент из хвоста очереди (дека) (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода pollLast()" + myObjDeque.pollLast());
        System.out.println(" - Результат работы метода pollLast()" + myObjDeque.pollLast());
        System.out.println(" - Результат работы метода pollLast()" + myObjDeque.pollLast());
        String tw_DeMO_Pd = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setDeque(TableInfo.R_POLL_LAST_MYOBJ, System.nanoTime() - timeStart);
        // Отображение итогового состояния всего дека, после манипуляций, переопределенным методом toString
        System.out.println("---> Дека myObjDeque итог. вар.: " + myObjDeque);
        //ДЕКИ ------------  модуль работы с основными методами трех реализаций двунаправленных очередей базовой (util) и двумя собственными
        //*** Конец МОДУЛЯ РАБОТЫ С ДЕКАМИ

        //*** НАЧАЛО МОДУЛЯ РАБОТЫ С ПРИОРИТЕТНЫМИ ОЧЕРЕДЯМИ
        //ПРИОРИТЕТНЫЕ ОЧЕРЕДИ---  модуль работы с основными методами приоритетной очереди
        //
        // ТЕСТИРОВАНИЕ ПРИОРИТЕТНОЙ ОЧЕРЕДИ ИЗ БИБЛИОТЕКИ UTIL
        // Процедура наполнения ОЧЕРЕДИ данными (для теста закидываем в каждый метод и вид по 3 одинаковых объекта (метода)
        // для решения данной задачи создана приоритетная очередь элементов собственного класса Cat. Класс для этих целей пришлось
        //слегка модифицировать. Тестирование выполнено, в финальной версии ДЗ оставлены только запросы результаты которых
        // идут в результирующую таблицу замера времени выполнения методлов.
        //*** небольшая оговорка, приоритетность элементов класса Cat определена по возрасту кота. (для тренировки)
        System.out.println();
        System.out.println("Тестирование очереди Queue библиотеки Util");
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода offer()" + (priorityQueueUtilCat.offer(new Cat("Барсик", 2.7, 5)) ? " true - элемент " + new Cat("Барсик", 2.7, 5) + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offer()" + (priorityQueueUtilCat.offer(new Cat("Мурзик", 2.8, 3)) ? " true - элемент " + new Cat("Мурзик", 2.8, 3) + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        System.out.println(" - Результат работы метода offer()" + (priorityQueueUtilCat.offer(new Cat("Дурсик", 2.9, 6)) ? " true - элемент " + new Cat("Дурсик", 2.9, 6) + " добавлен в очередь." : "Ошибка! Элемент не добавлен в очередь."));
        String tw_PqUt_Pu = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setPriority(TableInfo.R_OFFER_LAST_UTIL, System.nanoTime() - timeStart);
        // Отображение промежуточного состояния всего стека встроенным методом toString
        System.out.println(" ---> Очередь (по представлению toString) для queueUtilCat (базовый)  заполнена: " + priorityQueueUtilCat);
        // Процедура - "посмотреть" (peek) на верхний элемент стека (возвращает значение элемента и НЕ стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода peek()" + priorityQueueUtilCat.peek());
        System.out.println(" - Результат работы метода peek()" + priorityQueueUtilCat.peek());
        System.out.println(" - Результат работы метода peek()" + priorityQueueUtilCat.peek());
        String tw_PqUt_Pe = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setPriority(TableInfo.R_PEEK_LAST_UTIL, System.nanoTime() - timeStart);
        // Процедура - "снять" (pop) верхний элемент стека (возвращает значение элемента и стирает его)
        timeStart = System.nanoTime();
        System.out.println(" - Результат работы метода poll()" + priorityQueueUtilCat.poll());
        System.out.println(" - Результат работы метода poll()" + priorityQueueUtilCat.poll());
        System.out.println(" - Результат работы метода poll()" + priorityQueueUtilCat.poll());
        String tw_PqUt_Po = String.format("%1$10d", System.nanoTime() - timeStart);
        tableInfo.setPriority(TableInfo.R_POLL_FIRST_UTIL, System.nanoTime() - timeStart);
        // Отображение итогового состояния всего стека встроенным методом toString
        System.out.println("---> Очередь queueUtilCat итог. вар.: " + priorityQueueUtilCat);

        //заполнение "-не проведен-"
        tableInfo.setPriority(TableInfo.R_OFFER_LAST_MYARR, 0L);
        tableInfo.setPriority(TableInfo.R_OFFER_LAST_MYOBJ, 0L);
        tableInfo.setPriority(TableInfo.R_PEEK_LAST_MYARR, 0L);
        tableInfo.setPriority(TableInfo.R_PEEK_LAST_MYOBJ, 0L);
        tableInfo.setPriority(TableInfo.R_POLL_FIRST_MYARR, 0L);
        tableInfo.setPriority(TableInfo.R_POLL_FIRST_MYOBJ, 0L);


        //tableInfo[0] = new TableInfo("Util", "Добавить: push(), offer() или offerLast()");

        // вывод сводного результата среднего времени выполнения однотипных основных операций для стека, очереди, дека и приоритетной очереди
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------------- Таблица 4.1 ---");
        System.out.println("- Type  - Действие: методы для разных коллекций     -     Stack       ---      Queue      ---      Deque      ---  PriorityQueue  -");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("- Util  - Добавить: push(), offer() или offerLast() - " + tw_StUt_Pu + " ns   ---  " + tw_QuUt_Pu + " ns  ---  " + tw_DeUt_Pu + " ns  ---  " + tw_PqUt_Pu + " ns  -");
        System.out.println("- Util  - Добавить: offerFirst()                    - " + tw_StUt_NP + "   ---  " + tw_StUt_NP + "  ---  " + tw_DeUt_Pl + " ns  ---  " + tw_StUt_NP + "  -");
        System.out.println("- MyArr - Добавить: push(), offer() или offerLast() - " + tw_StMA_Pu + " ns   ---  " + tw_QuMA_Pu + " ns  ---  " + tw_DeMA_Pu + " ns  ---  -не проведен-  -");
        System.out.println("- MyArr - Добавить: offerFirst()                    - " + tw_StUt_NP + "   ---  " + tw_StUt_NP + "  ---  " + tw_DeMA_Pl + " ns  ---  " + tw_StUt_NP + "  -");
        System.out.println("- MyObj - Добавить: push(), offer() или offerLast() - " + tw_StMO_Pu + " ns   ---  " + tw_QuMO_Pu + " ns  ---  " + tw_DeMO_Pu + " ns  ---  -не проведен-  -");
        System.out.println("- MyObj - Добавить: offerFirst()                    - " + tw_StUt_NP + "   ---  " + tw_StUt_NP + "  ---  " + tw_DeMO_Pl + " ns  ---  " + tw_StUt_NP + "  -");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("- Util  - Получить не удалять: peek(), peekLast()   - " + tw_StUt_Pe + " ns   ---  " + tw_QuUt_Pe + " ns  ---  " + tw_DeUt_Pe + " ns  ---  " + tw_PqUt_Pe + " ns  -");
        System.out.println("- Util  - Получить не удалять: peekFirst()          - " + tw_StUt_NP + "   ---  " + tw_StUt_NP + "  ---  " + tw_DeUt_Pk + " ns  ---  " + tw_StUt_NP + "  -");
        System.out.println("- MyArr - Получить не удалять: peek(), peekLast()   - " + tw_StMA_Pe + " ns   ---  " + tw_QuMA_Pe + " ns  ---  " + tw_DeMA_Pe + " ns  ---  -не проведен-  -");
        System.out.println("- MyArr - Получить не удалять: peekFirst()          - " + tw_StUt_NP + "   ---  " + tw_StUt_NP + "  ---  " + tw_DeMA_Pk + " ns  ---  " + tw_StUt_NP + "  -");
        System.out.println("- MyObj - Получить не удалять: peek(), peekLast()   - " + tw_StMO_Pe + " ns   ---  " + tw_QuMO_Pe + " ns  ---  " + tw_DeMO_Pe + " ns  ---  -не проведен-  -");
        System.out.println("- MyObj - Получить не удалять: peekFirst()          - " + tw_StUt_NP + "   ---  " + tw_StUt_NP + "  ---  " + tw_DeMO_Pk + " ns  ---  " + tw_StUt_NP + "  -");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("- Util  - Получ./удал.: pop(), poll() ,pollFirst()  - " + tw_StUt_Po + " ns   ---  " + tw_QuUt_Po + " ns  ---  " + tw_DeUt_Po + " ns  ---  " + tw_PqUt_Po + " ns  -");
        System.out.println("- Util  - Получить и удалить: pollLast()            - " + tw_StUt_NP + "   ---  " + tw_StUt_NP + "  ---  " + tw_DeUt_Pd + " ns  ---  " + tw_StUt_NP + "  -");
        System.out.println("- MyArr - Получ./удал.: pop(), poll() ,pollFirst()  - " + tw_StMA_Po + " ns   ---  " + tw_QuMA_Po + " ns  ---  " + tw_DeMA_Po + " ns  ---  -не проведен-  -");
        System.out.println("- MyArr - Получить и удалить: pollLast()            - " + tw_StUt_NP + "   ---  " + tw_StUt_NP + "  ---  " + tw_DeMA_Pd + " ns  ---  " + tw_StUt_NP + "  -");
        System.out.println("- MyObj - Получ./удал.: pop(), poll() ,pollFirst()  - " + tw_StMO_Po + " ns   ---  " + tw_QuMO_Po + " ns  ---  " + tw_DeMO_Po + " ns  ---  -не проведен-  -");
        System.out.println("- MyObj -  Получить и удалить: pollLast()           - " + tw_StUt_NP + "   ---  " + tw_StUt_NP + "  ---  " + tw_DeMO_Pd + " ns  ---  " + tw_StUt_NP + "  -");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");


        //вывод таблицы итогов
        tableInfo.print();
    }

    private static class TableInfo {
        private static final int R_OFFER_LAST_UTIL = 0;
        private static final int R_OFFER_FIRST_UTIL = 1;
        private static final int R_OFFER_LAST_MYARR = 2;
        private static final int R_OFFER_FIRST_MYARR = 3;
        private static final int R_OFFER_LAST_MYOBJ = 4;
        private static final int R_OFFER_FIRST_MYOBJ = 5;
        private static final int R_PEEK_LAST_UTIL = 6;
        private static final int R_PEEK_FIRST_UTIL = 7;
        private static final int R_PEEK_LAST_MYARR = 8;
        private static final int R_PEEK_FIRST_MYARR = 9;
        private static final int R_PEEK_LAST_MYOBJ = 10;
        private static final int R_PEEK_FIRST_MYOBJ = 11;
        private static final int R_POLL_FIRST_UTIL = 12;
        private static final int R_POLL_LAST_UTIL = 13;
        private static final int R_POLL_FIRST_MYARR = 14;
        private static final int R_POLL_LAST_MYARR = 15;
        private static final int R_POLL_FIRST_MYOBJ = 16;
        private static final int R_POLL_LAST_MYOBJ = 17;
        private Row[] rows;

        public TableInfo() {
            rows = new Row[] {
                    new Row("Util",  "Добавить: push(), offer() или offerLast()"),
                    new Row("Util",  "Добавить: offerFirst()"),
                    new Row("MyArr", "Добавить: push(), offer() или offerLast()"),
                    new Row("MyArr", "Добавить: offerFirst()"),
                    new Row("MyObj", "Добавить: push(), offer() или offerLast()"),
                    new Row("MyObj", "Добавить: offerFirst()"),
                    new Row("Util",  "Получить не удалять: peek(), peekLast()"),
                    new Row("Util",  "Получить не удалять: peekFirst()"),
                    new Row("MyArr", "Получить не удалять: peek(), peekLast()"),
                    new Row("MyArr", "Получить не удалять: peekFirst()"),
                    new Row("MyObj", "Получить не удалять: peek(), peekLast()"),
                    new Row("MyObj", "Получить не удалять: peekFirst()"),
                    new Row("Util",  "Получ./удал.: pop(), poll() ,pollFirst()"),
                    new Row("Util",  "Получить и удалить: pollLast()"),
                    new Row("MyArr", "Получ./удал.: pop(), poll() ,pollFirst()"),
                    new Row("MyArr", "Получить и удалить: pollLast()"),
                    new Row("MyObj", "Получ./удал.: pop(), poll() ,pollFirst()"),
                    new Row("MyObj", "Получить и удалить: pollLast()")
            };
        }

        private void setStack(int position, Long value) {
            rows[position].stack = value;
        }
        private void setQueue(int position, Long value) {
            rows[position].queue = value;
        }
        private void setDeque(int position, Long value) {
            rows[position].deque = value;
        }
        private void setPriority(int position, Long value) {
            rows[position].priority = value;
        }

        private void print() {
            for(Row row: rows) {
                System.out.println(row.toString());
            }
        }

        private class Row {
            String type;
            String name;
            Long stack;
            Long queue;
            Long deque;
            Long priority;
            private Row(String type, String name) {
                this.type = type;
                this.name = name;
            }

            private String longToStr(Long value) {
                String text = "";
                if (value == null) {
                    text = String.format("%13s", ".... ");
                } else if (value.equals(0L)) {
                    text = "-не проведен-";
                } else {
                    text = String.format("%10s ns", value);
                }
                return text;
            }

            @Override
            public String toString() {
                return String.format("| %-5s | %-41s | %s | %s | %s | %s |", type, name, longToStr(stack), longToStr(queue), longToStr(deque), longToStr(priority));
            }
        }
    }

}
