package ru.geekbrains.javaalgoritms.lesson7;

/**
 * Сourse: java algorithms
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 7
 * Created 07.03.2021
 * v 1.0
 */
public class Std_HW_Lesson7 {
    //Задание 7.1
    // Пример графа (связный ненаправленный граф)
    //       _-{B}---{C}---{D}
    //      /
    //   {A} --{E}---{F}
    //      \
    //       --{G}---{H}---{I}---{J}
    //
    // Пример графа (связный Направленный граф)
    //       _->{B}--->{C}--->{D}
    //      /
    //   {A} -->{E}--->{F}
    //      \
    //       -->{G}--->{H}--->{I}--->{J}
    //
    // Пример графа (НЕсвязный Направленный граф)
    //       _->{B}    {C}--->{D}
    //     /
    //   {A} -->{E}--->{F}
    //      \
    //       -->{G}--->{H}--->{I}--->{J}
    //
    // Пример графа (связный взвешенный Направленный граф)
    //       _-2->{B}--3-->{C}--5-->{D}
    //      /
    //   {A}--1->{E}-7->{F}
    //      \
    //       -2->{G}--4-->{H}--9-->{I}--1-->{J}

    public static void main(String[] args) {
        //Задание 7.1
        System.out.println("\nЗадание 7.1");
        System.out.println(" Пример графа (связный ненаправленный граф)");
        System.out.println("       _-{B}---{C}---{D}");
        System.out.println("      /");
        System.out.println("   {A} --{E}---{F}");
        System.out.println("      \\");
        System.out.println("       --{G}---{H}---{I}---{J}");
        System.out.println("");
        System.out.println(" Пример графа (связный Направленный граф)");
        System.out.println("       _->{B}--->{C}--->{D}");
        System.out.println("      /");
        System.out.println("   {A} -->{E}--->{F}");
        System.out.println("      \\");
        System.out.println("       -->{G}--->{H}--->{I}--->{J}");
        System.out.println("");
        System.out.println(" Пример графа (НЕсвязный Направленный граф)");
        System.out.println("       _->{B}    {C}--->{D}");
        System.out.println("     /");
        System.out.println("   {A} -->{E}--->{F}");
        System.out.println("      \\");
        System.out.println("       -->{G}--->{H}--->{I}--->{J}");
        System.out.println("");
        System.out.println(" Пример графа (связный взвешенный Направленный граф)");
        System.out.println("       _-2->{B}--3-->{C}--5-->{D}");
        System.out.println("      /");
        System.out.println("   {A}--1->{E}-7->{F}");
        System.out.println("      \\");
        System.out.println("       -2->{G}--4-->{H}--9-->{I}--1-->{J}");
        System.out.println("\nЗадание 7.2");
        //реализация графа и его базовых методов
        MyGraph graph = new MyGraph();
        System.out.println("Формируем вершины графа (За модель принят последний пример связного взвешенного направленного графа, из решения задания №7.1)");
        long timeStart = System.nanoTime();
        System.out.println(" - Добавляем вершину \"А\" ..." + (graph.addVertex('A') ? " OK" : "Error! Вершина не добавлена!")); // элемент с индексом 0
        System.out.println(" - Добавляем вершину \"B\" ..." + (graph.addVertex('B') ? " OK" : "Error! Вершина не добавлена!")); // элемент с индексом 1
        System.out.println(" - Добавляем вершину \"C\" ..." + (graph.addVertex('C') ? " OK" : "Error! Вершина не добавлена!")); // элемент с индексом 2
        System.out.println(" - Добавляем вершину \"D\" ..." + (graph.addVertex('D') ? " OK" : "Error! Вершина не добавлена!")); // элемент с индексом 3
        System.out.println(" - Добавляем вершину \"E\" ..." + (graph.addVertex('E') ? " OK" : "Error! Вершина не добавлена!")); // элемент с индексом 4
        System.out.println(" - Добавляем вершину \"F\" ..." + (graph.addVertex('F') ? " OK" : "Error! Вершина не добавлена!")); // элемент с индексом 5
        System.out.println(" - Добавляем вершину \"G\" ..." + (graph.addVertex('G') ? " OK" : "Error! Вершина не добавлена!")); // элемент с индексом 6
        System.out.println(" - Добавляем вершину \"H\" ..." + (graph.addVertex('H') ? " OK" : "Error! Вершина не добавлена!")); // элемент с индексом 7
        System.out.println(" - Добавляем вершину \"I\" ..." + (graph.addVertex('I') ? " OK" : "Error! Вершина не добавлена!")); // элемент с индексом 8
        System.out.println(" - Добавляем вершину \"J\" ..." + (graph.addVertex('J') ? " OK" : "Error! Вершина не добавлена!")); // элемент с индексом 9
        long timeStop = System.nanoTime();
        System.out.println(" => Добавка 10-и вершин в граф: " + (timeStop - timeStart) + " ns");
        System.out.println(" => В среднем, время затраченное на 1 вершину и ребро: " + (timeStop - timeStart) / 10 + " ns");
        System.out.println("Организуем связи вершин графа");
        timeStart = System.nanoTime();
        graph.addEdge(0, 1, 2, 2);
        graph.addEdge(0, 4, 1, 1);
        graph.addEdge(0, 6, 2, 2);
        graph.addEdge(1, 2, 3, 3);
        graph.addEdge(2, 3, 5, 5);
        graph.addEdge(4, 5, 7, 7);
        graph.addEdge(6, 7, 4, 4);
        graph.addEdge(7, 8, 9, 9);
        graph.addEdge(8, 9, 1, 1);
        timeStop = System.nanoTime();
        System.out.println(" => Организация 10-и связей между 10-ю вершинами в графа: " + (timeStop - timeStart) + " ns");
        System.out.println(" => В среднем, время затраченное на 1 вершину и ребро: " + (timeStop - timeStart) / 10 + " ns");

        //задание 7.3 решение
        System.out.println("\nЗадание 7.3");
        System.out.println("Обход графа в глубину");
        timeStart = System.nanoTime();
        graph.dfs(0);
        timeStop = System.nanoTime();
        System.out.println(" => Обход графа в глубину занял: " + (timeStop - timeStart) + " ns");

        //задание 7.4 решение
        System.out.println("\nЗадание 7.4");
        System.out.println("Обход графа в ширину");
        timeStart = System.nanoTime();
        graph.bfc(0);
        timeStop = System.nanoTime();
        System.out.println(" => Обход графа в ширину занял: " + (timeStop - timeStart) + " ns");
    }

}
