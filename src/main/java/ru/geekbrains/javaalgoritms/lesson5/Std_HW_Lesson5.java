package ru.geekbrains.javaalgoritms.lesson5;

import java.util.Arrays;

/**
 * Сourse: java algorithms
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 5
 * Created 28.02.2021
 * v 1.0
 */
public class Std_HW_Lesson5 {
    private static int maxIteration = 40;    // максимальное количество итерация для эксперимента в задании 5.4

    public static void main(String[] args) {
        //Задание 5.1 Приведите пример использования рекурсии.
        // ответ(ы):    1. Алгоритм вычисления факториала целого неотрицательного числа n
        //              2. вычисление числа Фибоначчи.
        //              3. почти все геометрически фракталы задаются именно рекурсией, например треугольник Серпинского.
        //              4. Простейший алгоритм обхода дерева каталогов и составления списка всех вложенных файлов, выполняется с помощью рекурсии.

        //Задание 5.2 Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.
        // решения:
        // 1. метод реализует бесконечную рекурсию (для запуска раскомментировать, в результате работы бросит StackOverflowError).
        // infiniteRecursion();
        // метод рекурсивно организует обратный отсчет от любого целочисленного значения n до 0.
        exampleSimpleRecursion(10);

        //Задание 5.3 Приведите пример изображающий стек вызова и стек вызова с рекурсией.
        // Ответ(ы) Вопрос ..нутый, но отвечать нужно...
        // - изображение(схематическое) стека вызовов (в его классической реализации)  в архиве ДЗ файл callStack.PNG
        // - изображения(схематическое) стека вызовов с рекурсией  в архиве ДЗ файл callStackWidthRecursion.PNG
        //   (данное изображение хоть и с комментариями на английском, но схематически очень понятное, на базе
        //   вычисления факториала числа виден процесс заполнения стека, и каскадное возвращение рекурсивно вычисленного
        //   значения в точку вызова) (ну что нашел, сам рисовать я не собирался..., автор я вижу тоже не сильно напрягался)

        //Задание 5.4 Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию.
        //Оцените два алгоритма с помощью базового метода System.nanoTime().
        // решение: Для выполнения задания примем условное число итераций равной 100000 (для наглядности результата)
        //          действие выполняемое внутри цикла и рекурсивно будет вычисление значения синуса i
        //          где i является и счетчиком итераций и аргументом функции sin(i) выраженным в градусах.

        // реализация задачи на базе цикла
        // объявление переменной точки отсчета времени
        long timeStart = System.nanoTime();
        for (int i = 0; i < maxIteration; i++) {
            double radiansI = Math.toRadians(i);
            double res = Math.sin(radiansI);
            //System.out.println(res);
        }
        long tw_forLoop = System.nanoTime() - timeStart;
        System.out.println("Решение задачи занимающей " + maxIteration + " итераций с помощью цикла заняло: " + tw_forLoop + " нс.");

        // реализация задачи при помощи рекурсии
        timeStart = System.nanoTime();
        exampleMathRecursion(0);
        long tw_forRecursion = System.nanoTime() - timeStart;
        System.out.println("Решение задачи занимающей " + maxIteration + " итераций с помощью рекурсии заняло: " + tw_forRecursion + " нс.");
        // Результаты наблюдений:
        // при малых значениях количества итераций (до 100 например) рекурсия на порядок быстрее цикла
        // чем больше итераций тем разница во времени будет меньше, однако при данном решении рекурсия все равно быстрее цикла
        // испробовал разные варианты провел более 10 тестов. Рекурсия быстрее (автор похоже нам по ушам проездил)
        // однако все равно главным недостатком рекурсии выявлен тот факт, что с большими количествами итераций рекурсия
        // справиться не может, переполнение стека (на моей машине) происходит уже на значениях чуть более 15000, когда как циклу
        // можно скормить миллионы итераций спокойно. В итоге рекурсия - быстрее цикла но применима при ограниченном количестве итераций
        // в пределах нескольких сотен реже тысяч, при значениях более 1000 итераций разница времени исполнения становится незначительной
        // при значениях итераций десятки тысяч применение рекурсии может вызвать ошибку или неприменимо вообще.

        //Задание 5.5 Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.
        //Оцените алгоритм двоичного рекурсивного поиска с помощью базового метода System.nanoTime() и сравните с обычным двоичным поиском.
        //решение: 1. Создаем массив из MAX элементов.
        //         2. Сортируем его методом sort.
        //         3. Для чистоты эксперимента назначаем конкретный элемент (как-бэ наихудший вариант) с индексом MAX-2
        //         4. Организуем поиск значения в массив е методом бинарного поиска, замеряем время
        //         5. Создаем собственный метод реализующий бинарный поиск в массиве, запускаем, замеряем время
        //         6. сравниваем.
        System.out.println("Задание 5.5");
        int newLength = 100000;  //  размер массива случайных значений для тестирования.
        System.out.print("Инициализация и заполнение случайными значениями оригинального массива int размером "
                + newLength + " элементов ... ");
        int[] arrOrigin = new int[newLength];
        for (int i = 0; i < newLength; i++) arrOrigin[i] = rnd(newLength);
        int[] workCopy = Arrays.copyOf(arrOrigin, arrOrigin.length);
        System.out.println(" OK!");
        timeStart = System.nanoTime();
        Arrays.sort(arrOrigin);
        long timeSortOriginArr = System.nanoTime() - timeStart;
        //System.out.println(Arrays.toString(arrOrigin));
        System.out.println(" Массив отсортирован!");
        // Назначаем значение поиска (точнее присваиваем оригинальное, чтобы точно не нарваться на совпадение)
        int desiredValue = arrOrigin[arrOrigin.length - 2];
        //System.out.println(Arrays.toString(arrOrigin));
        System.out.print(" Старт поиска методом binarySearch() библиотеки Arrrays ...");
        System.out.print(" OK!\n Искомое значение найдено в позиции " + Arrays.binarySearch(arrOrigin, desiredValue));
        System.out.println(" за время равное: " + (System.nanoTime() - timeStart) + " ns");
        timeStart = System.nanoTime();
        int findPoz = myBinarySearch(arrOrigin, desiredValue);
        System.out.print(" Старт поиска методом myBinarySearch() разработанным в рамках ДЗ ...");
        System.out.print(" OK!\n Искомое значение найдено в позиции " + findPoz);
        System.out.println(" за время равное: " + (System.nanoTime() - timeStart) + " ns");
        //задание выполнено. Однако отмечена следующая особенность
        // в противоположность лекции бинарный поиск реализованный методом рекурсии
        // работает особенно при больших значениях размера массива (таких как) 100 млн элементов
        // работает как минимум на порядок быстрее (в данном случае на 5 порядков т.е. в 10000 раз быстрее)
        // чем метод Arrays.binarySearch() при том что дает в точности такой же результат.
        // результат смутил, поэтому я проверил все еще с десяток раз с разными значениями и размерами массива
        // обнаружил весьма интересные особенности поведения бинарного поиска, но производительность метода с рекурсией
        // была во много раз выше чем родного метода библиотеки arrays.

        // Задание 5.6 На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием.
        // Оцените алгоритм сортировки слиянием с помощью базового метода System.nanoTime() и сравните с сортировкой методом sort().
        // !!! Уточнение принятое в ДЗ реализация алгоритма должна быть произведена с использованием рекурсии
        // за основу должен быть взят не массив из задания 2.1 а любой массив удобный для реализации алгоритма и сравнения.
        // в данном случае будет взят тот же массив из задания 5.4 только неотсортированный.
        // замер времени сортировки массива методом sort() библиотеки arrays произведен в задании 5.5

        System.out.println("Задание 5.6");
        System.out.println("Сортировка тестового массива размером " + newLength + " элементов, выполнена методом sort()" +
                " библиотеки Arrays за: " + timeSortOriginArr + " ns");
       // System.out.println("Оригинальный массив: " + Arrays.toString(workCopy));
        System.out.print(" Старт сортировки методом слияния mySort() с применением рекурсии ...");
        timeStart = System.nanoTime();
        workCopy = mySort(workCopy);
        System.out.println("OK!\n Сортировка выполнена за время равное: " + (System.nanoTime() - timeStart) + " ns");
        //System.out.println("Отсортированный массив: " + Arrays.toString(workCopy));

        //Задание выполнено
        // вывод, опять таки применение рекурсии очевидно дало огромную экономию по времени, причем очень большую
        // Так что наш, Чудо - АФФТАР Видеокурса нам какую-то шляпу втулил...
        // в итоге при решении конкретных задач нужно опираться на разные методы тестируя производительность
        // и затраты памяти.
    }

    public static void infiniteRecursion() {
        System.out.println("Привет! Я забодаю тебя этим сообщением!");
        infiniteRecursion();
    }

    public static void exampleSimpleRecursion(int n) {
        if (n < 0) return;
        System.out.println(n);
        exampleSimpleRecursion(--n);
    }

    public static void exampleMathRecursion(int n) {
        if (n > maxIteration - 1) return;
        double radiansI = Math.toRadians(n);
        double res = Math.sin(radiansI);
        //System.out.println(res);
        exampleMathRecursion(++n);
    }

    public static int rnd(int max) {
        return (int) (Math.random() * ++max);
    }

    public static int myBinarySearch(int[] arr, int desiredValue) {
        return myBinarySearchRecursive(arr, desiredValue, 0, arr.length - 1);
    }

    public static int myBinarySearchRecursive(int[] arr, int desiredValue, int indexStart, int indexStop) {
        if (indexStart > indexStop) return -1;
        int middleIndex = (indexStart + indexStop) / 2;
        if (arr[middleIndex] > desiredValue)
            return myBinarySearchRecursive(arr, desiredValue, indexStart, middleIndex - 1);
        if (arr[middleIndex] < desiredValue)
            return myBinarySearchRecursive(arr, desiredValue, middleIndex + 1, indexStop);
        return middleIndex;
    }

    public static int[] mergeArray(int[] arrayA, int[] arrayB) {
        int[] arrayC = new int[arrayA.length + arrayB.length];
        int indArrA = 0;
        int indArrB = 0;
        for (int i = 0; i < arrayC.length; i++) {
            if (indArrA < arrayA.length && indArrB < arrayB.length) {
                if (arrayA[indArrA] < arrayB[indArrB]) arrayC[i] = arrayA[indArrA++];
                else arrayC[i] = arrayB[indArrB++];
            } else if (indArrA == arrayA.length) arrayC[i] = arrayB[indArrB++];
            else if (indArrB == arrayB.length) arrayC[i] = arrayA[indArrA++];
        }
        return arrayC;
    }

    public static int[] mySort(int[] arr) {
        if (arr == null) return null;
        if (arr.length < 2) return arr;
        int[] arrayB = new int[arr.length / 2];
        System.arraycopy(arr, 0, arrayB, 0, arr.length / 2);
        int[] arrayC = new int[arr.length - arr.length / 2];
        System.arraycopy(arr, arr.length / 2, arrayC, 0, arr.length - arr.length / 2);
        arr = mergeArray(mySort(arrayB), mySort(arrayC));
        return arr;
    }
}
