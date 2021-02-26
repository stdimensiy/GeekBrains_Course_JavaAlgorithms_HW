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
public class UnidirectionElement<T> {
    private final T unidirectionElement;
    private UnidirectionElement<T> next;
    private UnidirectionElement<T> previous;

    public UnidirectionElement(T unidirectionElement) {
        this.unidirectionElement = unidirectionElement;
    }

    public UnidirectionElement<T> getNext() {
        return this.next;
    }

    public UnidirectionElement<T> getPrevious() {
        return this.previous;
    }

    public void setNext(UnidirectionElement<T> next) {
        this.next = next;
    }

    public void setPrevious(UnidirectionElement<T> previous) {
        this.previous = previous;
    }

    public T getValue() {
        return unidirectionElement;
    }

    @Override
    public String toString() {
        return unidirectionElement.toString();
    }
}
