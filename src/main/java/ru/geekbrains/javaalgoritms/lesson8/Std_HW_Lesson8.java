package ru.geekbrains.javaalgoritms.lesson8;

import java.util.Arrays;
import java.util.Random;

/**
 * Сourse: java algorithms
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 8
 * Created 15.03.2021
 * v 1.0
 */
public class Std_HW_Lesson8 {
    private static Random random = new Random();
    public static void main(String[] args) {
        //Задание №8.1
        // Задача: Приведите пример использование хеш-таблиц.
        // Решение: Ясное дело в программировании, при выполнении задачи быстрого получения результата по некоторому
        // ключу. Например, реализация телефонного справочника на несколько десятков тысяч абонентов, в котором ключом
        // является обработанное хеш-функцией значение строки, состоящей из фамилии + имени и отчества абонента.
        // несомненно при большом количестве абонентов вероятность получит полного тезку абонента есть. В этой ситуации
        // применяется один из методов решения коллизий.
        // Аналогами хеш-таблицы могут быть представлены (грамотно сделанные) "табельные" на серьезных предприятиях где
        // требуется строгий и оперативный учет фактического нахождения персонала(рабочих) в конкретном месте, и быстрое
        // определение данных о сотруднике. (На шахте учет и оперативное реагирование выполняется именно таким методом,
        // у каждого шахтера есть свой номер и набор жетонов на лампу, спуск, подъем... (забывать уже стал), а в табельной
        // устроены стеллажи и установлен алгоритм размещения жетонов на них. В итоге одного взгляда (при возникновении
        // ЧП на стеллаж, или в момент пересменки, достаточно для определения сколько человек, например, не вернулись и забоя.
        // а и по номерку можно быстро поднять все данные о сотруднике.
        // Аналогом в реальной жизни может быть организация складского учета любых товаров на складе. (разумеется грамотная)
        // когда по определенному признаку товар (тип, наименование или еще какой) получает адрес хранения в конкретной
        // нумерованной позиции на стеллаже.
        // Еще одним аналогом может быть регистратура в поликлинике (хеш-таблица в этом случае - полки с карточками пациентов)
        // Аналогом можно считать Библиотеку - в ее случае, хеш-таблица — это хранилище или организованные и должным образом
        // пронумерованные полки с книгами. При выборе конкретной книги у администратора вы получаете вычисленное (назначенное)
        // с применением определенного алгоритма (хеш-функции) значение номера секции, подсекции, полки и можете быстро
        // переместиться в заданную точку и уже на месте решая (если понадобится) возникшую коллизию (если потребуется)
        // получить нужную книгу.
        // Задание №8.2
        // Задача: Приведите примеры ключей и коллизий.
        // решение: Рассмотрим пример библиотеки. Вы обращаетесь к библиотекарю с просьбой выдать вам для чтения книгу Михаила Булгакова
        // "Собачье сердце" - для библиотекаря фамилия и имя автора книги являются ключом (допустим), и сотрудник
        // библиотеки вам быстро выдает направление (допустим в библиотеке такая организация), что нужная вам книга
        // находится в секции Б, стеллаж 3, полка 2. Вы достаточно быстро находите нужный адрес (сгенерированный по
        // ключу для вас библиотекарем), однако на указанной полке вы не находите искомой книги, а точнее вы находите там
        // множество книг данного автора - вот это уже коллизия. Т.е.. одному ключу при выбранном алгоритме хеширования
        // соответствует не одно, а множество объектов, причем разных. Есть несколько решений коллизий, применимых при формировании
        // (заполнении) таблицы и получении данных из нее. Однако лучше всего заранее позаботиться о конфигурации
        // хеш-таблицы и надежности хеш-функции, чтобы коллизий было наименьшее количество, иначе эффективность
        // всей этой замечательной идеи начинает резко снижаться.
        // Задание №8.3
        // Задача: Приведите примеры популярных и эффективных хеш-функций.
        // Решение: Хеш-функции достаточно распространены и широко применяются в программировании. На текущий момент
        // времени наиболее часть применяются CRC-32; MD5 (наверное, чаще всего встречается в относительно простых интернет приложениях)
        // SHA-1, SHA-2, ГОСТ Р 34.11-2012 «Стрибог» - это наши программисты разработали, гордимся нашими умами.

        // Задание №8.4
        // Задача: На основе данных массива из задания 2.3 реализуйте хеш-таблицу с помощью открытой адресации,
        // а конкретнее метода линейного пробирования
        // Решение:
        System.out.println("выполнение задания №8.4");
        taskHashTable(10, false);
        // Задание №8.5
        // Задача: Перестройте программный код задания 8.4 из алгоритма линейного пробирования в алгоритм двойного хеширования.
        // Решение:
        System.out.println("выполнение задания №8.5");
        taskHashTable(10, true);
    }

    private static void taskHashTable(int size, boolean asDouble) {
        //int[] arr = ArrHelper.generateRandomArr(size, 100);
        int[] arr = new int[10];
        fillThisArrayRnd(arr , 100);
        MyHashTable hashTable = new MyHashTable(size);
        for (int value: arr) {
            hashTable.insert(new Item(value), asDouble);
        }
        System.out.println("Тестовый массив: " + Arrays.toString(arr));
        System.out.println("    Хеш-таблица: " + hashTable.displayValues());

        System.out.println("сравнение (отчет)");
        System.out.println("Позиции элемента в массиве / позиция элемента в хеш-таблице:");
        for (int ind = 0; ind < arr.length; ind++) {
            System.out.println("Элемент со значением: "+ arr[ind] + ": индекс в массиве = " + ind + ", индекс в хеш-таблице " + hashTable.findHash(arr[ind], asDouble));
        }
    }

    private static void fillThisArrayRnd(int[] arrTest, int bound){
        for (int i = 0; i < arrTest.length; i++) {
            arrTest[i] = random.nextInt(bound);
        }
    }

}
