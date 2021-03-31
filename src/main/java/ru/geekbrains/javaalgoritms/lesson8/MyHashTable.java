package ru.geekbrains.javaalgoritms.lesson8;

import java.util.Arrays;

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
public class MyHashTable {
    private final Item[] hashArr;
    private final int arrSize;
    private final Item nonItem;
    private final int hashCoefficient;

    // базовый конструктор
    public MyHashTable(int arrSize) {
        this.arrSize = arrSize;
        hashArr = new Item[arrSize];
        nonItem = new Item(-1);
        int tableSize = getPrime(arrSize);
        hashCoefficient = tableSize % 10;
    }

    //вывести ключи
    public String displayValues() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int ind = 0; ind < arrSize; ind++) {
            result.append(hashArr[ind].getKey());
            if(ind < arrSize-1){
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    private int hashFunc(int key) {
        return key % arrSize;
    }

    private int hashFuncDouble(int key) {
        return hashCoefficient - key % hashCoefficient;
    }

    // метод добавления значения
    public void insert(Item item, boolean asDouble) {
        int key = item.getKey();
        int hash = hashFunc(key);
        int step = hashFuncDouble(key);
        while (hashArr[hash] != null && hashArr[hash].getKey() != -1) {
            if (asDouble) {
                hash += step;
            } else {
                ++hash;
            }
            hash %= arrSize;
        }
        hashArr[hash] = item;
    }

    //найти элемент
    public Item find(int key, boolean asDouble) {
        int hash = findHash(key, asDouble);
        return hash < 0 ? null : hashArr[hash];
    }

    //метод возвращает позицию элемента
    public int findHash(int key, boolean asDouble) {
        int hash = hashFunc(key);
        int step = hashFuncDouble(key);
        while (hashArr[hash] != null) {
            if (hashArr[hash].getKey() == key) {
                return hash;
            }
            if (asDouble) {
                hash += step;
            } else {
                ++hash;
            }
            hash %= arrSize;
        }
        return -1;
    }

    //удаление элемента из таблицы
    public Item delete(int key, boolean asDouble) {
        int hash = findHash(key, asDouble);
        if (hash != -1) {
            Item deletedItem = hashArr[hash];
            hashArr[hash] = nonItem;
            return deletedItem;
        }
        return null; //неудачная попытка
    }

    //увеличение размера таблицы
    private int getPrime(int min) {
        for (int ind = min + 1; true; ind++) {
            if (isPrime(ind)) {
                return ind;
            }
        }
    }

    private boolean isPrime(int ind) {
        for (int ind2 = 2; (ind2 * ind2 <= ind); ind2++) {
            if (ind % ind2 == 0) {
                return false;
            }
        }
        return true;
    }
}
