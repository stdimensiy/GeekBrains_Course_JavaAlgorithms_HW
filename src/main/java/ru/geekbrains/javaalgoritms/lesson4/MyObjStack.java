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

public class MyObjStack<T> {
    private UnidirectionElement<T> top;

    public MyObjStack() {
        this.top = null;
    }

    public UnidirectionElement<T> push(T newElem) {
        UnidirectionElement<T> element = new UnidirectionElement<>(newElem);
        element.setNext(this.top);
        this.top = element;
        return element;
    }

    public UnidirectionElement<T> peek() {
        return this.top;
    }

    public UnidirectionElement<T> pop() {
        UnidirectionElement<T> temp = this.top;
        this.top = this.top.getNext();
        return temp;
    }

    @Override
    public String toString() {
        if (this.top == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        UnidirectionElement<T> temptop = this.top;
        do {
            sb.append(temptop);
            if (temptop.getNext() != null) sb.append(", ");
            temptop = temptop.getNext();
        } while (temptop != null);
        return sb.append(']').toString();
    }
}
