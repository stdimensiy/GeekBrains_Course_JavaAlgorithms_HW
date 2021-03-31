package ru.geekbrains.javaalgoritms.lesson6;

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
public class MyHeap {
    private static int heapSize;

    public static void sort(int[] arr) {
        buildHeap(arr);
        while (heapSize>1){
            svap(arr, 0, heapSize-1);
            heapSize--;
            heapify(arr, 0);
        }
    }

    public static void buildHeap(int[] arr) {
        heapSize = arr.length;
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i);
        }

    }

    public static void heapify(int[] arr, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize && arr[i] < arr[l]) {
            largest = l;
        }
        if (r < heapSize && arr[largest] < arr[r]) {
            largest = r;
        }
        if (i != largest) {
            svap(arr, i, largest);
            heapify(arr, largest);
        }
    }

    public static int left(int i) {
        return 2 * i + 1;
    }

    public static int right(int i) {
        return 2 * i + 2;
    }

    public static void svap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
