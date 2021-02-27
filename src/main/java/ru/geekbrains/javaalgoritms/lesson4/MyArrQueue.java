package ru.geekbrains.javaalgoritms.lesson4;

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
public class MyArrQueue<T> {
    private int maxSize;            //максимальный размер очереди
    private T[] queue;              //хранилище элементов очереди (в виде массива)
    private int front;              //указатель первого элемента в очереди (голова)
    private int rear;               //указатель последнего элемента в очереди (хвост)
    private int count;              //текущее количество элементов в очереди

    public MyArrQueue(int maxSize) {
        this.maxSize = maxSize;
        this.count = 0;
        this.front = 0;
        this.rear = -1;
        this.queue = (T[]) new Object[maxSize];
    }

    public boolean offer(T element) {
        if (this.count < this.maxSize) {
            if (this.rear == this.maxSize) this.rear = -1;
            this.queue[++this.rear] = element;
            this.count++;
            return true;
        }
        return false;
    }

    public T poll() {
        if (this.front == -1) return null;
        this.count--;
        if (this.front == this.maxSize) this.front = -1;
        return this.queue[++this.front];
    }

    public T peek() {
        if (this.front == -1) return null;
        return this.queue[this.front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == maxSize;
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        if (this.count == 0)
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int x = 0, y = this.front; x < this.count; x++) {
            if (y == maxSize) y = 0;
            T t = queue[y++];
            sb.append(t);
            if (x < this.count - 1) sb.append(", ");
        }
        return sb.append(']').toString();
    }
}
