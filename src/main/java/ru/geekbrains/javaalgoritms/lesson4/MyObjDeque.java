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

public class MyObjDeque<T> {
    private UnidirectionElement<T> front;
    private UnidirectionElement<T> rear;
    private int count;                     //текущее количество элементов в деке

    public MyObjDeque() {
        this.count = 0;
        this.front = null;
        this.rear = null;
    }

    // метод аналогичен обычному offer в очереди. Добавляет один элемент в конец очереди
    public UnidirectionElement<T> offerLast(T newElem) {
        UnidirectionElement<T> element = new UnidirectionElement<>(newElem);
        if (this.count == 0) {
            element.setNext(this.front);     // элемент запоминает что перед ним никого нет
            element.setPrevious(this.rear);     // элемент запоминает что за ним никого нет
            this.front = element;
            this.rear = element;
        } else {
            this.rear.setPrevious(element); // новый элемент говорит старому - я буду за вами.
            element.setNext(this.rear);     // новый запоминает старого у себя в памяти как следующий перед ним элемент
            element.setPrevious(null);      // новый запоминает что за ним никого нет
            this.rear = element;            // и становит ся за ним, становясь маркером последнего
        }
        count++;
        return element;
    }

    // метод аналогичен обычному offer в очереди. Но добавляет один элемент в начало очереди
    public UnidirectionElement<T> offerFirst(T newElem) {
        UnidirectionElement<T> element = new UnidirectionElement<>(newElem);
        if (this.count == 0) {
            element.setNext(this.front);        // элемент запоминает что перед ним никого нет
            element.setPrevious(this.rear);     // элемент запоминает что за ним никого нет
            this.front = element;
            this.rear = element;
        } else {
            this.front.setNext(element);        // новый элемент говорит старому - я перед тобой пойду, возражений ведь нет???....
            element.setPrevious(this.front);    // новый запоминает старого у себя в памяти как идущий за ним элемент
            element.setNext(null);              // новый запоминает что перед ним никого нет
            this.front = element;               // и становится перед ним, становясь маркером первого в очереди элемента
        }
        count++;
        return element;
    }

    public UnidirectionElement<T> pollFirst() {
        UnidirectionElement<T> tempElem = this.front;
        this.front = this.front.getPrevious();
        if (this.count > 0) this.count--;
        return tempElem;
    }

    public UnidirectionElement<T> pollLast() {
        UnidirectionElement<T> tempElem = this.rear;
        this.rear = this.rear.getNext();
        if (this.count > 0) this.count--;
        return tempElem;
    }

    // метод позволяет "посмотреть" получить первый элемент из головы очереди без удаления самого элемента.
    public UnidirectionElement<T> peekFirst() {
        return this.front;
    }

    // метод позволяет "посмотреть" получить последний элемент из хвоста очереди без удаления самого элемента.
    public UnidirectionElement<T> peekLast() {
        return this.rear;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        if (this.count == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        UnidirectionElement<T> tempElem = this.front;
        sb.append(tempElem);
        while (tempElem.getPrevious() != null) {
            tempElem = tempElem.getPrevious();
            sb.append(", ");
            sb.append(tempElem);
        }
        return sb.append(']').toString();
    }
}
