package ru.geekbrains.javaalgoritms.lesson3;

/**
 * Сourse: java algorithms
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 3
 * Created 25.02.2021
 * v 1.0
 */
public class UnidirectionElement<T> {
    private T unidirectionElement;
    private UnidirectionElement<T> next;

    public UnidirectionElement(T unidirectionElement) {
        this.unidirectionElement = unidirectionElement;
    }

    public UnidirectionElement<T> getNext() {
        return next;
    }

    public void setNext(UnidirectionElement<T> next) {
        this.next = next;
    }

    public T getValue() {
        return unidirectionElement;
    }

    @Override
    public String toString() {
        return unidirectionElement.toString();
    }
}
