package ru.geekbrains.javaalgoritms.lesson1;

/**
 * Сourse: java algorithms
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson1
 * Created 20.02.2021
 * v 1.0
 */
public class Std_HW_Lesson1 {
    //переменные ссылочного типа
    private static String answer1 = "Пример алгоритма в жизни: порядок действий как заменить перегоревшую лампочку в светильнике\n" +
            "Такой алгоритм может выглядеть примерно так:\n" +
            "1. Начало -> взять неисправный светильник (в котором перегорела лампочка)\n" +
            "2. Выкрутить перегоревшую лампочку\n" +
            "3. Подготовить (взять) новую лампочку идентичную выкрученной по типу цоколя и размеру\n" +
            "4. Вкрутить новую лампочку в цоколь светильника\n" +
            "5. Конец -> вернуть светильник на место, отправить неисправную лампочку в мусор.\n\n" +
            "Пример структуры данных в жизни:\n" +
            "тип структуры данных: \"линейная\" - Список покупок в магазине\n" +
            "тип структуры данных: \"Иерархическая\" - например организационная структура предприятия\n" +
            "тип структуры данных: \"Сетевая\" - например модель взаимодействия между сотрудниками, работающими над\n" +
            "разными проектами в рамках организационной структуры компании (модель в которой каждый узел или сотрудник может взаимодействовать с каждым)\n" +
            "тип структуры данных: \"Табличная\" - например таблица Брадиса в старой тетрадке сзади или шахматная доска.\n";
    private static String answer2 = "Пример (представления) алгоритма в программировании:\n" +
            " Псевдокод --- Предназначен для представления алгоритма человеку," +
            "а не для компьютерной трансляции и последующего исполнения программы, представляющий из себя неформальный" +
            "язык описания алгоритмов, использующий ключевые слова императивных языков программирования, но опускающий" +
            "несущественные для понимания алгоритма подробности и специфический синтаксис.\n" +
            "Блок-схема -- распространённый тип схем (графических моделей), описывающих алгоритмы или процессы," +
            "в которых отдельные шаги изображаются в виде блоков различной формы, соединённых между собой линиями," +
            "указывающими направление последовательности.\n" +
            "Конкретный пример алгоритма (без представления) в программировании можно рассмотреть, например при" +
            "определении четности переданного числового значения: Алгоритм в данном случае представляет собой последовательность следующих действий:\n" +
            "1. Начало -> получение значение в переменную (допустим это метод и мы получаем готовые данные в переменную в качестве параметра)\n" +
            "2. Выполняем операцию получения остатка от деления на 2 при помощи операции извлечения остатка от деления (%)\n" +
            "3. Проверяем равно ли полученное результирующее значение нулю или нет\n" +
            "3.1 если Да (равно нулю) тогда возвращаем ответ, что проверяемое значение является четным числом\n" +
            "3.2 если НЕТ (остаток от деления нацело не равен нулю) тогда возвращаем ответ, что проверяемое значение является Нечетным числом\n" +
            "4. завершение  -> конец.\n" +
            "Пример структуры данных в программировании:\n" +
            "тип структуры данных: \"Линейная\" примерами могут быть одномерные массивы, стеки \"Stack\" и очереди \"Queue\". \n" +
            "тип структуры данных: \"Иерархическая\" примерами являются линкованные списки, древовидные множества treeSet\n" +
            "тип структуры данных: \"Сетевая\" - организация сетевых баз данных, которые являющихся модификацией " +
            "иерархических баз данных но отличающихся от них тем, что у дочернего элемента может быть несколько предков (элементов стоящих выше него в структуре.\n" +
            "тип структуры данных: \"Табличная\" -  двумерные массивы.\n";
    // переменные ссылочного типа
    private static String string_a = "Hello";
    private static String string_b = " world!!!";
    private static String string_c = string_a;

    // переменные содержащие примитивные значения
    private static byte byte_a = 1;
    private static byte byte_b = 2;
    private static byte byte_c = byte_a;
    private static short short_a = 1;
    private static short short_b = 2;
    private static short short_c = short_a;
    private static char char_a = 'A';
    private static char char_b = '\u2714';           // код символа галочки согласно таблицы символов юникод
    private static char char_c = char_a;
    private static int int_a = 1;
    private static int int_b = 2;
    private static int int_c = int_a;
    private static long long_a = 100L;
    private static long long_b = 200L;
    private static long long_c = long_a;
    private static float float_a = 1.1234f;
    private static float float_b = 2.3456f;
    private static float float_c = float_a;
    private static double double_a = 1.1234;
    private static double double_b = 2.3456;
    private static double double_c = double_a;
    private static boolean boolean_a = true;
    private static boolean boolean_b = false;
    private static boolean boolean_c = boolean_a;

    //Переменные абстрактного типа
    private static Cat cat_a = new Cat("Барсик");
    private static Cat cat_b = new Cat("Мурзик");
    private static Cat cat_c = new Cat("Барсик");
    private static Cat cat_d = cat_a;


    //Примитивные типы данных и их характеристики (напоминалочка)
    //byte      8  бит от -128 до 127
    //short     16 бит от -32768 до 32767
    //char      16 бит от 'u0000' до 'uFFFF'
    //int       32 бит от -2147483648 до 2147483647
    //long      64 бит от -9223372036854775808 до 9223372036854775807
    //float     32 бит от +-3.40282347E+38f (точность 6-7 значащих десятичных цифр)
    //double    64 бит от +-1,79769313486231570E+308 в степени -308 до 10 в степени 308 (точность 15 значащих десятичных цифр)
    //boolean    1 бит только 2 значения trie и false
    //Ссылочные типы данных
    //String - строка и в принципе все остальные в т.ч. и абстрактные.

    public static void main(String[] args) {
        //Задание 1.1 ответ.
        System.out.println("Выполнение задания №1.1:");
        System.out.println(answer1);
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        //Задание 2.1 ответ.
        System.out.println("Выполнение задания №2.1:");
        System.out.println(answer2);
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        //Задание 3.1 вывод результата.
        System.out.println("Выполнение задания №3.1:");
        System.out.println("типы данных, переменные и текущие значения хранимые в них");
        System.out.println("Примитивные типы данных:");
        System.out.println("Краткий отчет о поведении значений в них представлен в таблице: 3.1");
        System.out.println("------------------------------------------------------------------------------------------------------------- Таблица 3.1---");
        System.out.println("|  Пример присвоения значений и вычислений               |  Результат вывода значения переменной при помощи printLn(val)   |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|  byte byte_a = " + byte_a + ";                                      |   " + byte_a + "                                                             |");
        System.out.println("|  byte byte_b = " + byte_b + ";                                      |   " + byte_b + "                                                             |");
        System.out.println("|  byte byte_c = byte_a;                                 |   " + byte_c + "                                                             |");
        System.out.println("|  byte byte_x = (byte) (byte_a + byte_b);               |   " + (byte) (byte_a + byte_b) + "                                                             |");
        System.out.println("|  byte byte_x = (byte) (byte_a - byte_b);               |   " + (byte) (byte_a - byte_b) + "                                                            |");
        System.out.println("|  byte byte_x = (byte) (byte_a / byte_b);               |   " + (byte) (byte_a / byte_b) + "                                                             |");
        System.out.println("|  byte byte_x = (byte) (byte_a * byte_b);               |   " + (byte) (byte_a * byte_b) + "                                                             |");
        System.out.println("|  Результат сравнения byte_a > byte_b                   |   " + (byte_a > byte_b) + "                                                         |");
        System.out.println("|  Результат сравнения byte_a == byte_c                  |   " + (byte_a == byte_c) + "                                                          |");
        byte_c *= 2;        System.out.println("|  Результат изменения скопированного значения byte_c*2  |   " + byte_c + "                                                             |");
        System.out.println("|  Результат проверки источника копирования byte_а       |   " + byte_a + "                                                             |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|  short short_a = " + short_a + ";                                    |   " + short_a + "                                                             |");
        System.out.println("|  short short_b = " + short_b + ";                                    |   " + short_b + "                                                             |");
        System.out.println("|  short short_x = (short) (short_a + short_b);          |   " + (short_a + short_b) + "                                                             |");
        System.out.println("|  short short_x = (short) (short_a - short_b);          |   " + (short_a - short_b) + "                                                            |");
        System.out.println("|  short short_x = (short) (short_a * short_b);          |   " + (short_a * short_b) + "                                                             |");
        System.out.println("|  short short_x = (short) (short_a / short_b);          |   " + (short_a / short_b) + "                                                             |");
        System.out.println("|  Результат сравнения short_a > short_b                 |   " + (short_a > short_b) + "                                                         |");
        System.out.println("|  Результат сравнения short_a == short_c                |   " + (short_a == short_c) + "                                                          |");
        short_c *= 2;        System.out.println("|  Результат изменения скопированного значения short_c*2 |   " + short_c + "                                                             |");
        System.out.println("|  Результат проверки источника копирования short_a      |   " + short_a + "                                                             |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|  int int_a = " + int_a + ";                                        |   " + int_a + "                                                             |");
        System.out.println("|  int int_b = " + int_b + ";;                                       |   " + int_b + "                                                             |");
        System.out.println("|  int int_x = int_a + int_b;                            |   " + (int_a + int_b) + "                                                             |");
        System.out.println("|  int int_x = int_a - int_b;                            |   " + (int_a - int_b) + "                                                            |");
        System.out.println("|  int int_x = int_a * int_b;                            |   " + (int_a * int_b) + "                                                             |");
        System.out.println("|  int int_x = int_a / int_b;                            |   " + (int_a / int_b) + "                                                             |");
        System.out.println("|  Результат сравнения int_a > int_b                     |   " + (int_a > int_b) + "                                                         |");
        System.out.println("|  Результат сравнения int_a == int_c                    |   " + (int_a == int_c) + "                                                          |");
        int_c *= 2;
        System.out.println("|  Результат изменения скопированного значения long_c*2  |   " + int_c + "                                                             |");
        System.out.println("|  Результат проверки источника копирования double_a     |   " + int_a + "                                                             |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|  long long_a = " + long_a + "L;                                   |   " + long_a + "                                                           |");
        System.out.println("|  long long_b = " + long_b + "L;                                   |   " + long_b + "                                                           |");
        System.out.println("|  long long_x = long_a + long_b;                        |   " + (long_a + long_b) + "                                                           |");
        System.out.println("|  long long_x = long_a - long_b;                        |   " + (long_a - long_b) + "                                                          |");
        System.out.println("|  long long_x = long_a / long_b;                        |   " + (long_a / long_b) + "                                                             |");
        System.out.println("|  long long_x = long_a * long_b;                        |   " + (long_a * long_b) + "                                                         |");
        System.out.println("|  Результат сравнения long_a > long_b                   |   " + (long_a > long_b) + "                                                         |");
        System.out.println("|  Результат сравнения long_a == long_c                  |   " + (long_a == long_c) + "                                                          |");
        long_c *= 2;
        System.out.println("|  Результат изменения скопированного значения long_c*2  |   " + long_c + "                                                           |");
        System.out.println("|  Результат проверки источника копирования double_a     |   " + long_a + "                                                           |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|  float float_a = " + float_a + "f;                              |   " + float_a + "                                                        |");
        System.out.println("|  float float_b = " + float_b + "f;                              |   " + float_b + "                                                        |");
        System.out.println("|  float float_x = float_a + float_b;                    |   " + (float_a + float_b) + "                                                     |");
        System.out.println("|  float float_x = float_a - float_b;                    |   " + (float_a - float_b) + "                                                    |");
        System.out.println("|  float float_x = float_a * float_b;                    |   " + (float_a * float_b) + "                                                      |");
        System.out.println("|  float float_x = float_a / float_b;                    |   " + float_a / float_b + "                                                     |");
        System.out.println("|  Результат сравнения float_a > float_b                 |   " + (float_a > float_b) + "                                                         |");
        System.out.println("|  Результат сравнения float_a == float_c                |   " + (float_a == float_c) + "                                                          |");
        float_c *= 2;
        System.out.println("|  Результат изменения скопированного значения float_c*2 |   " + float_c + "                                                        |");
        System.out.println("|  Результат проверки источника копирования float_a      |   " + float_a + "                                                        |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|  double double_a = " + double_a + ";                             |   " + double_a + "                                                        |");
        System.out.println("|  double double_b = " + double_b + ";                             |   " + double_b + "                                                        |");
        System.out.println("|  double double_x = double_a + double_b;                |   " + (double_a + double_a) + "                                                        |");
        System.out.println("|  double double_x = double_a - double_b;                |   " + (double_a - double_b) + "                                           |");
        System.out.println("|  double double_x = double_a * double_b;                |   " + (double_a * double_b) + "                                                    |");
        System.out.println("|  double double_x = double_a / double_b;                |   " + (double_a / double_b) + "                                           |");
        System.out.println("|  Результат сравнения double_a > double_b               |   " + (double_a > double_b) + "                                                         |");
        System.out.println("|  Результат сравнения double_a == double_c              |   " + (double_a == double_c) + "                                                          |");
        double_c *= 2;
        System.out.println("|  Результат изменения скопированного значения double_c*2|   " + double_c + "                                                        |");
        System.out.println("|  Результат проверки источника копирования double_a     |   " + double_a + "                                                        |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|  char char_a = 'A';                                    |   " + char_a + "                                                             |");
        System.out.println("|  char char_b = '\\u2714';                               |   " + char_b + "                                                             |");
        System.out.println("|  char char_x = (char_a + char_b);                      |   " + (char)(char_a + char_b) + "                                                             |");
        System.out.println("|  char char_x = '\\u2242';                               |   " + '\u2242' + "                                                             |");
        System.out.println("|  char char_x = '\\u263B';                               |   " + '\u263B' + "                                                             |");
        System.out.println("|  Результат сравнения char_a > char_b                   |   " + (char_a > char_b) + "                                                         |");
        System.out.println("|  Результат сравнения char_a == char_c                  |   " + (char_a == char_c) + "                                                          |");
        char_c *= 2;
        System.out.println("|  Результат изменения скопированного значения char_c*2  |   " + char_c + "                                                             |");
        System.out.println("|  Результат проверки источника копирования char_a       |   " + char_a + "                                                             |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|  boolean boolean_a = true;                             |   " + boolean_a + "                                                          |");
        System.out.println("|  boolean boolean_b = false;                            |   " + boolean_b + "                                                         |");
        System.out.println("|  boolean boolean_x = !boolVal_a;                       |   " + !boolean_a + "                                                         |");
        System.out.println("|  boolean boolVal_x = boolVal_a || boolVal_b;           |   " + (boolean_a || boolean_b) + "                                                          |");
        System.out.println("|  boolean boolVal_x = boolVal_a && boolVal_b;           |   " + (boolean_a && boolean_b) + "                                                         |");
        System.out.println("|  boolean boolVal_x = !(boolVal_a && boolVal_b);        |   " + !(boolean_a && boolean_b) + "                                                          |");
        System.out.println("|  Результат сравнения boolean_a > boolean_a             |   ТАКАЯ ОПЕРАЦИЯ НЕДОПУСТИМА!                                   |");
        System.out.println("|  Результат сравнения boolean_a == boolean_b            |   " + (boolean_a == boolean_c) + "                                                          |");
        boolean_c = false;
        System.out.println("|  Результат изменения  значения boolean_c = false       |   " + boolean_c + "                                                         |");
        System.out.println("|  Результат проверки источника копирования boolean_a    |   " + boolean_a + "                                                          |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---                                                 ССЫЛОЧНЫЙ ТИП                                                        ---");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|  String string_a = \"Hello\";                            |   " + string_a + "                                                         |");
        System.out.println("|  String string_b = \"world!\";                           |   " + string_b + "                                                     |");
        System.out.println("|  String string_a = string_a + string_b;                |   " + string_a + string_b + "                                                |");
        System.out.println("|  String string_a = string_a - string_b;                |   ТАКАЯ ОПЕРАЦИЯ НЕДОПУСТИМА!                                   |");
        System.out.println("|  String string_a = string_a * string_b;                |   ТАКАЯ ОПЕРАЦИЯ НЕДОПУСТИМА!                                   |");
        System.out.println("|  String string_a = string_a / string_b;                |   ТАКАЯ ОПЕРАЦИЯ НЕДОПУСТИМА!                                   |");
        System.out.println("|  Результат сравнения string_a > string_b               |   ТАКАЯ ОПЕРАЦИЯ НЕДОПУСТИМА!                                   |");
        System.out.println("|  Результат сравнения string_a == string_c              |   " + (string_a == string_c) + "                                                          |");
        string_c = "Абра-кадабра";
        System.out.println("|  Результат изменения  значения boolean_c = false       |   " + string_c + "                                                  |");
        System.out.println("|  Результат проверки источника копирования boolean_a    |   " + string_a + "                                                         |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---                                                 АБСТРАКТНЫЙ ТИП                                                      ---");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-- Созданный тип Cat имеет два конструктора, при помощи которых можно создавать объекты передавая только имя, или созда - --");
        System.out.println("-- вать объект изначально содержащий имя, возраст и вес питомца. Быстрое преобразование объекта в строку для данного типа --");
        System.out.println("-- реализованы посредством переопределения метода toString(). Для организации возможности сравнения объектов абстрактного --");
        System.out.println("-- типа Cat переопределен метод equals()                                                                                 --");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|  Cat cat_a = new Cat(\"Барсик\");                        |   " + cat_a + "                         |");
        System.out.println("|  Cat cat_b = new Cat(\"Мурзик\");                        |   " + cat_b + "                         |");
        System.out.println("|  Cat cat_c = new Cat(\"Барсик\");                        |   " + cat_c + "                         |");
        System.out.println("|  Cat cat_d = cat_a;                                    |   " + cat_d + "                         |");
        System.out.println("|  Cat cat_x = (cat_a + cat_b); как объекты              |   ТАКАЯ ОПЕРАЦИЯ НЕДОПУСТИМА!                                   |");
        System.out.println("|  Cat cat_x = \" + cat_a + cat_b + \" как строки          |   " + cat_a + cat_b + " |");
        System.out.println("|  Cat cat_x = cat_a * cat_b;                            |   ТАКАЯ ОПЕРАЦИЯ НЕДОПУСТИМА!                                   |");
        System.out.println("|  Cat cat_x = cat_a / cat_b;                            |   ТАКАЯ ОПЕРАЦИЯ НЕДОПУСТИМА!                                   |");
        System.out.println("|  Результат сравнения cat_a > cat_b                     |   ТАКАЯ ОПЕРАЦИЯ НЕДОПУСТИМА!                                   |");
        System.out.println("|  Результат сравнения cat_a == cat_c                    |   " + (cat_a == cat_c) + "                                                         |");
        System.out.println("|  Результат сравнения cat_a.equals(cat_c)               |   " + cat_a.equals(cat_c) + "                                                          |");
        cat_d.setName("Не БаРсИк");
        System.out.println("|  Результат изменения  значения cat_d.set = false       |   " + cat_d + "                      |");
        System.out.println("|  Результат проверки источника копирования cat_a        |   " + cat_a + "                      |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        //Задание 4.1 вывод результата.
        // выполнение задания 4.1 вынесено в отдельный метод (для тренировки)
        answer4();
    }

    public static void answer4() {
        System.out.println("Результаты сравнения данных находящихся в разных переменных с комментариями");
        System.out.println("метод имитирует простейший поиск перебором и замер времени выполнения скрипта.");
        System.out.println("Для предоставления сколь-нибудь ощутимого результата для решения задачи приняты дополнительные условия:");
        System.out.println("Данные в которых осуществляется поиск организовать в массиве типа int[] размером 100000 элементов");
        System.out.println("Массив заполнить значениями в случайном порядке, для генерации значения использовать генератор");
        System.out.println("случайного значения (по ключу - индексу) т.е. массив должен содержать уникальные значения");
        System.out.println("в диапазоне от 0 до 100000 ячейки массива могут содержать либо значение, либо 0, 0 может находится");
        System.out.println("в больше чем одной ячейке массива.");
        System.out.println("Значение поиска элемент со значением 50000");
        System.out.println("Поиск организовать методом простого прямого перебора и сравнения");
        System.out.println("Время работы фрагмента кода осуществляющего поиск замерить с помощью базового метода System.nanoTime()");
        System.out.println("Результат работы метода вывести в консоль.");
        System.out.println("");
        System.out.println("Старт работы метода... OK");
        System.out.print("Подготовка массива для поиска...");
        int[] arr = new int[100000];
        for(int i = 0; i<arr.length; i++){
            int ind = rnd(arr.length-1);
            arr[ind] = i;
            //System.out.println(arr[ind] + "записан в элемент с индексом: " + ind);
        }
        System.out.println(" OK");
        System.out.print("Старт поиска значения равного 50000 ...");
        System.out.println(" OK");
        long timeStart = System.nanoTime();
        for (int i=0; i<arr.length; i++){
            if(arr[i]==50000){
                System.out.println("Искомое значение найдено в элементе с индексом " + i);
                break;
            }
            if(i==arr.length-1){
                System.out.println("Искомое значение в массиве отсутствует. Ну такое тоже возможно");
            }
        }
        long timeStop = System.nanoTime();
        long delta = timeStop-timeStart;
        System.out.println("Время затраченное на поиск искомого значения в массиве размером " + arr.length);
        System.out.println("составило " + (double) delta/1000000000 + " с.");
    }

    public static int rnd(int max)
    {
        return (int) (Math.random() * ++max);
    }
}
