package ru.geekbrains.javaalgoritms.lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Сourse: java algorithms
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 3
 * Created 24.02.2021
 * v 1.0
 */
public class Std_HW_Lesson3 {
    //при выполнении ДЗ для наглядности принято решение не использовать массив int из ДЗ к уроку №2 а создать заново
    //массив строк. Собственный класс для удобства проверки (чтобы не скачивать и не запускать весь проект) решено
    //перенести в пакет lesson3
    //Для задания 3.3 создан класс UnidirectionList реализующий односвязный список элементов UnidirectionElement
    //элементы могут быть любого типа.

    private static String[] strings = new String[10]; // Создаем массив из 10  строк

    public static void main(String[] args) {
        //Задание №3.1
        System.out.println("Задание 3.1   ");
        strings[0] = "Первый";
        strings[1] = "Второй";
        strings[2] = "Третий";
        strings[3] = "Четвертый";
        strings[4] = "Пятый";
        strings[5] = "Шестой";
        strings[6] = "Седьмой";
        strings[7] = "Восьмой";
        strings[8] = "Девятый";
        strings[9] = "Десятый";
        // создаем простой список
        long timeStart = System.nanoTime();
        ArrayList<String> arrayList = new ArrayList(Arrays.asList(strings));
        System.out.println("Операция преобразования массива строк (10 элементов) в ArrayList заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.println("Содержимое arrayList: " + arrayList);
        System.out.println();

        //Задание №3.2
        System.out.println("Задание 3.2   ");
        System.out.println("Метод быстрого вывода всех элементов списка в консоль опробован выше.");
        timeStart = System.nanoTime();
        System.out.print("Добавление 1 элемента в начало списка ...");
        arrayList.add(0, "Новый элемент в начало");
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        timeStart = System.nanoTime();
        System.out.print("Добавление 1 элемента в середину списка...");
        arrayList.add(6, "Новый элемент в середину");
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        timeStart = System.nanoTime();
        System.out.print("Добавление 1 элемента в конец списка ...");
        arrayList.add(arrayList.size(), "Новый элемент в середину");
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.println();

        System.out.print("Удаление 1 элемента в начало списка ...");
        timeStart = System.nanoTime();
        arrayList.remove(0);
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.print("Удаление 1 элемента в середину списка ...");
        timeStart = System.nanoTime();
        arrayList.remove(6);
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.print("Удаление 1 элемента в конец списка ...");
        timeStart = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.println();

        System.out.print("Чтение 1 элемента в начало списка ... ");
        timeStart = System.nanoTime();
        arrayList.get(0);
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.print("Чтение 1 элемента в середину списка ...");
        timeStart = System.nanoTime();
        arrayList.get(6);
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.print("Чтение 1 элемента в конец списка ... ");
        timeStart = System.nanoTime();
        arrayList.get(arrayList.size() - 1);
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.println();

        //Задание №3.3
        System.out.println("Задание 3.3 разработка и проверка односвязного списка UnidirectionList.");
        UnidirectionList<Cat> myCatUniList = new UnidirectionList<>();
        Cat cat1 = new Cat("Мурзик");
        myCatUniList.add(new Cat("Барсик"));
        myCatUniList.add(cat1);
        myCatUniList.add(new Cat("Алиса"));
        myCatUniList.add(new Cat("Джина"));
        myCatUniList.add(new Cat("Кекс"));
        myCatUniList.add(new Cat("Квашин"));
        System.out.println("Заполнение и ввод всех элементов связанного списка по порядку их следования в списке");
        System.out.println(myCatUniList);
        System.out.println("Проверка работоспособности метода удаления первого элемента");
        myCatUniList.remove();
        System.out.println(myCatUniList);
        System.out.println("Проверка работоспособности метода удаления элемента по индексу (например удалим элемент с индексом 2)");
        myCatUniList.remove(2);
        System.out.println(myCatUniList);
        System.out.println("Проверка работоспособности метода предоставления текущего индекса вхождения в список искомого значения");
        System.out.println("Например мы ищем объект Cat(\"Мурзик\")");
        System.out.println("Индекс позиции вхождения: " + myCatUniList.conteins(cat1) + " все верно метод работает!");
        System.out.println("Проверка работоспособности метода предоставления (без удаления) элемента списка по его текущему индексу");
        System.out.println("Передаем в качестве параметра индекс ранее найденного кота \"Мурзика\" ");
        System.out.println(myCatUniList.get(myCatUniList.conteins(cat1)) + " все верно метод работает!");
        System.out.println("Проверка работоспособности метода удаления всех элементов из списка");
        myCatUniList.removeAll();
        System.out.println(myCatUniList);
        System.out.println("Все работает, задание выполнено полностью.");
        System.out.println();

        //Задание №3.4
        System.out.println("Задание 3.4   ");
        ArrayList<Cat> catArrayList = new ArrayList<>();
        catArrayList.add(new Cat("Барсик"));
        catArrayList.add(cat1);
        catArrayList.add(new Cat("Алиса"));
        catArrayList.add(new Cat("Тыдро подарочное"));
        catArrayList.add(new Cat("Рыжий"));
        catArrayList.add(new Cat("Джина"));
        catArrayList.add(new Cat("кекс"));
        catArrayList.add(new Cat("Квашин"));
        catArrayList.add(new Cat("Цыган"));
        catArrayList.add(new Cat("Мара"));
        // Тоже самое но уже в виде связанного списка
        LinkedList<Cat> catLinkedList = new LinkedList<>(catArrayList);
        // опробование метода equals для двух типов списков
        System.out.println("Проверка списков на идентичность при помощи метода equals");
        boolean eq = catLinkedList.equals(catArrayList);
        System.out.println(eq ? eq + " списки идентичны" : eq + "списки различаются");
        System.out.println("Вывод содержимого списка catArrayList в консоль:");
        System.out.println(catArrayList);
        System.out.println("Вывод содержимого списка catLinkedList в консоль:");
        System.out.println(catLinkedList);
        System.out.println("очевидно, что значения эквивалентны полностью.");
        System.out.println();

        System.out.println("Метод быстрого вывода всех элементов списка в консоль опробован выше.");
        timeStart = System.nanoTime();
        System.out.print("Добавление 1 элемента в начало списка inkedList ...");
        catLinkedList.add(0, cat1);
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        timeStart = System.nanoTime();
        System.out.print("Добавление 1 элемента в середину списка inkedList...");
        catLinkedList.add(5, cat1);
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        timeStart = System.nanoTime();
        System.out.print("Добавление 1 элемента в конец списка inkedList ...");
        catLinkedList.add(catLinkedList.size(), cat1);
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.println();

        System.out.print("Удаление 1 элемента в начало списка LinkedList ...");
        timeStart = System.nanoTime();
        catLinkedList.remove(0);
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.print("Удаление 1 элемента в середину списка LinkedList ...");
        timeStart = System.nanoTime();
        catLinkedList.remove(6);
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.print("Удаление 1 элемента в конец списка LinkedList ...");
        timeStart = System.nanoTime();
        catLinkedList.remove(arrayList.size() - 1);
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.println();

        System.out.print("Чтение 1 элемента в начало списка LinkedList ... ");
        timeStart = System.nanoTime();
        catLinkedList.get(0);
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.print("Чтение 1 элемента в середину списка LinkedList ...");
        timeStart = System.nanoTime();
        catLinkedList.get(6);
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.print("Чтение 1 элемента в конец списка LinkedList ... ");
        timeStart = System.nanoTime();
        catLinkedList.get(arrayList.size() - 1);
        System.out.println(" ОК! Операция заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.println();

        //Задание №3.5
        System.out.println("Задание 3.5 - работа с итератором и удаляем из catArrayList кота с именем Рыжий");
        Iterator<Cat> catALIterator = catArrayList.iterator();
        Iterator<Cat> catLLIterator = catLinkedList.iterator();
        timeStart = System.nanoTime();
        while (catALIterator.hasNext()) {
            Cat currentCat;
            currentCat = catALIterator.next();
            System.out.println(currentCat);
            if (currentCat.getName().equals("Рыжий")) {
                catALIterator.remove();
            }
        }
        System.out.println("Вывод содержимого списка catArrayList после модификации в консоль:");
        System.out.println(catArrayList);
        System.out.println("Операция по удалению одного элемента из catArrayList заняла " + (System.nanoTime() - timeStart) + " ns");
        System.out.println("таже процедура со связанным списком удаляем из catLinkedList кота с именем Рыжий");
        timeStart = System.nanoTime();
        while (catLLIterator.hasNext()) {
            Cat currentCat;
            currentCat = catLLIterator.next();
            System.out.println(currentCat);
            if (currentCat.getName().equals("Рыжий")) {
                catLLIterator.remove();
            }
        }
        System.out.println("Вывод содержимого списка catArrayList после модификации в консоль:");
        System.out.println(catLinkedList);
        System.out.println("Операция по удалению одного элемента из catArrayList заняла " + (System.nanoTime() - timeStart) + " ns");
    }
}
