package ru.geekbrains.javaalgoritms.lesson4;

import ru.geekbrains.javaalgoritms.lesson3.Cat;

import java.util.Iterator;

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
public class MyArrStack<T> {
    private int maxSize;
    private T[] stack;
    private int top;

    public MyArrStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = (T[]) new Object[maxSize];
        this.top = -1;
    }

    public T push(T element) {
        this.stack[++this.top] = element;
        return element;
    }

    public T peek() {
        return this.stack[this.top];
    }

    public T pop() {
        return this.stack[this.top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public int size() {
        return top + 1;
    }

    @Override
    public String toString() {
        if (this.top == -1)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int x = 0; x < stack.length; x++) {
            T t = stack[x];
            if (t == null) {
                break;
            } else {
                sb.append(t);
                if (x < stack.length - 1 && stack[x + 1] != null) sb.append(", ");
            }
        }
        return sb.append(']').toString();
    }
}
