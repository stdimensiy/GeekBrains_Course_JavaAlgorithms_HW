package ru.geekbrains.javaalgoritms.lesson2;

import java.util.Arrays;

/**
 * Сourse: java algorithms
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 2
 * Created 23.02.2021
 * v 1.0
 */
public class Std_HW_Lesson2 {
    private static int[] arrOrigin = new int[10];

    public static void main(String[] args) {
        int bound = arrOrigin.length;
        for (int i = 0; i < bound; i++) arrOrigin[i] = rnd(1_000);
        // обкатка основных методов библиотеки Arrays
        // вывод значений массива в строку обкатан отдельно
        // Копирование массива
        System.out.println("Задание 2.1");
        System.out.println("Оригинальный массив: " + Arrays.toString(arrOrigin));
        long timeStart = System.nanoTime();
        int[] workCopy = Arrays.copyOf(arrOrigin, bound);
        System.out.println("Применение стандартного метода Arrays.copyOf() для данного массива заняло: "
                + (System.nanoTime() - timeStart) + " ns");
        System.out.println("Копия ориг. массива: " + Arrays.toString(workCopy));
        // сортировка массива
        timeStart = System.nanoTime();
        Arrays.sort(workCopy);
        System.out.println("Применение стандартного метода Arrays.sort() для данного массива заняло: "
                + (System.nanoTime() - timeStart) + " ns");
        System.out.println("Массив отсортирован: " + Arrays.toString(workCopy));
        System.out.println();


        System.out.println("Задание 2.2");
        System.out.println("Линейный поиск в оригинальном массиве: " + Arrays.toString(arrOrigin));
        // выполнение линейного поиска
        int desiredValue = workCopy[workCopy.length - 1];
        timeStart = System.nanoTime();
        System.out.println(" --- Ищем значение " + desiredValue + " предположительно худший вариант");
        for (int i = 0; i < bound; i++) {
            if (workCopy[i] == desiredValue) {
                System.out.print(" --- Искомое значение найдено в позиции " + i);
                break;
            }
        }
        System.out.println(" за время равное: " + (System.nanoTime() - timeStart) + " ns");
        // выполнение бинарного поиска
        timeStart = System.nanoTime();
        desiredValue = workCopy[workCopy.length - 1];
        System.out.println("Бинарный поиск в отсортированном массиве: " + Arrays.toString(workCopy));
        System.out.println(" --- Ищем значение " + desiredValue + " предположительно худший вариант");
        System.out.print(" --- Искомое значение найдено в позиции " + Arrays.binarySearch(workCopy, desiredValue));
        System.out.println(" за время равное: " + (System.nanoTime() - timeStart) + " ns");
        System.out.println("Вывод: при малых значениях размера массива применение иного поиска отличного от линейного" +
                " перебора может быть неэффективным, за счет затрат времени на подготовку (сортировку) и выполнение поиска.");
        System.out.println();

        System.out.println("Задание 2.3");
        int newLength = 40000;  //  в финальной версии размер массива увеличен в 100 раз для наглядности.
        System.out.print("Инициализация и заполнение случайными значениями оригинального массива int размером "
                + newLength + " элементов ... ");
        timeStart = System.nanoTime();
        arrOrigin = new int[newLength];
        for (int i = 0; i < newLength; i++) arrOrigin[i] = rnd(1_000);
        System.out.println(" OK! затраченное время: " + ((double)(System.nanoTime() - timeStart)/1000000000) + " сек.");
        System.out.print("Копирование методом copyOf() оригинального массива в рабочий массив размером "
                + newLength + " элементов ... ");
        timeStart = System.nanoTime();
        workCopy = Arrays.copyOf(arrOrigin, newLength);
        System.out.println(" OK! затраченное время: " + ((double)(System.nanoTime() - timeStart)/1000000000) + " сек.");
        System.out.print("Сортировка методом sort() массив размером " + newLength + " элементов ... ");
        timeStart = System.nanoTime();
        Arrays.sort(workCopy);
        System.out.println(" OK! затраченное время: " + ((double)(System.nanoTime() - timeStart)/1000000000) + " сек.");
//        System.out.println("Массив отсортирован: " + Arrays.toString(workCopy));
//        System.out.println("Массив отсортирован: " + Arrays.toString(arrOrigin));
        System.out.println();

        System.out.println("Задание 2.4");
        workCopy = Arrays.copyOf(arrOrigin, newLength);
//        System.out.println("Массив до сортировки: " + Arrays.toString(workCopy));
        System.out.print("Реализация метода пузырьковой сортировки массива размером " + newLength + " элементов ... ");
        timeStart = System.nanoTime();
        bubbleSort(workCopy);
        System.out.println(" OK! затраченное время: " + ((double)(System.nanoTime() - timeStart)/1000000000) + " сек.");
//        System.out.println("Массив  отсортирован: " + Arrays.toString(workCopy));
        System.out.println();

        System.out.println("Задание 2.5");
        workCopy = Arrays.copyOf(arrOrigin, newLength);
//        System.out.println("Массив до сортировки: " + Arrays.toString(workCopy));
        System.out.print("Реализация метода сортировки \"выбором\" для массива размером " + newLength + " элементов ... ");
        timeStart = System.nanoTime();
        selectionSort(workCopy);
        System.out.println(" OK! затраченное время: " + ((double)(System.nanoTime() - timeStart)/1000000000) + " сек.");
//        System.out.println("Массив  отсортирован: " + Arrays.toString(workCopy));
        System.out.println();

        System.out.println("Задание 2.6");
        workCopy = Arrays.copyOf(arrOrigin, newLength);
//        System.out.println("Массив до сортировки: " + Arrays.toString(workCopy));
        System.out.print("Реализация сортировки методом \"Вставки\" массива размером " + newLength + " элементов ... ");
        timeStart = System.nanoTime();
        insertSort(workCopy);
        System.out.println(" OK! затраченное время: " + ((double)(System.nanoTime() - timeStart)/1000000000) + " сек.");
//        System.out.println("Массив  отсортирован: " + Arrays.toString(workCopy));

    }

    public static int rnd(int max) {
        return (int) (Math.random() * ++max);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];        // не стал пока выносить в отдельный метод ибо ну очень просто...
                    arr[j] = arr[j + 1];     // и фактической экономии кода нет (тут 1 строка) там 5
                    arr[j + 1] = tmp;
                }
            }
        }

    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // первый цикл перебирает все индексы элементов массива слева направо
            int min = arr[i];
            int min_i = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }

    }

    public static void insertSort(int[] arr) {
        int pisitionIn;
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            pisitionIn = i;
            while (pisitionIn > 0 && arr[pisitionIn-1]>=tmp){
                arr[pisitionIn] = arr[pisitionIn-1];
                pisitionIn--;
            }
            arr[pisitionIn]=tmp;
        }
    }
}
