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
public class MyObjQueue<T> {
    private UnidirectionElement<T> front;
    private UnidirectionElement<T> rear;
    private int count;              //текущее количество элементов в очереди

    public MyObjQueue() {
        this.count = 0;
        this.front = null;
        this.rear = null;
    }

    public UnidirectionElement<T> offer(T newElem) {
        UnidirectionElement<T> element = new UnidirectionElement<>(newElem);
        if (this.front == null) {
            //element.setNext(this.front);
            //element.setPrevious(this.rear);
            this.front = element;
            this.rear = element;
        } else {
            this.rear.setPrevious(element);
            //element.setNext(this.rear);
            //element.setPrevious(null);
            this.rear = element;
        }
        count++;
        return element;
    }

    public UnidirectionElement<T> poll() {
        UnidirectionElement<T> tempElem = this.front;
        this.front = this.front.getPrevious();
        count--;
        return tempElem;
    }

    public UnidirectionElement<T> peek() {
        return this.front;
    }

    public boolean isEmpty() {
        return count == 0;
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
        UnidirectionElement<T> tempElem = this.front;
        sb.append(tempElem);
        while (tempElem.getPrevious() != null){
            tempElem = tempElem.getPrevious();
            sb.append(", ");
            sb.append(tempElem);
        }
        return sb.append(']').toString();
    }
}
