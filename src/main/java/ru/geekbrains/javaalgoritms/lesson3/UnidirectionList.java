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
public class UnidirectionList<T> {
    // Реализация очень простого односвязного линкованного списка (коллекции)
    // для ДЗ в классе дерализованы следующие методы:
    // - isEmpty() проверяет пустой или не пустой список.
    // - add() добавляет новый элемент в начало списка (передаваемый параметра - объект)
    // - remove() предоставляет объект из начала списка и удаляет его.
    // - remove(индекс элемента) предоставляет объект по его текущему индексу в списке и удаляет его.
    // - removeAll() зачищает список, удаляя все элементы.
    // - getFirst() быстро предоставляет первый элемент списка или null если список пустой.
    // - get(индекс) предоставляет элемент списка по индексу (и не удаляет его).
    // - contains(объект) ищет в списке искомое значение и возвращает индекс позиции где элемент найден, или -1 если нет.
    // - toString() переопределен для быстрого и относительно красивого отображения содержимого коллекции
    private UnidirectionElement<T> first; //поле класса отвечающее за хранение первого элемента

    // конструктор инициализирующий пустой список
    public UnidirectionList() {
        this.first = null;
    }

    // метод возвращающий результат проверки пустой список или нет
    public boolean isEmpty() {
        return (this.first == null);
    }

    // метод осуществляющий включение элемента в список
    public void add(T newElem) {
        UnidirectionElement<T> element = new UnidirectionElement<>(newElem);
        element.setNext(this.first);
        this.first = element;
    }

    // метод осуществляющий исключение элемента из списка
    public UnidirectionElement<T> remove() {
        UnidirectionElement<T> tempElement = this.first;
        this.first = tempElement.getNext();
        return tempElement;
    }

    // метод осуществляющий исключение элемента из списка по индексу
    public UnidirectionElement<T> remove(int index) {
        UnidirectionElement<T> previousElement = null;
        UnidirectionElement<T> currentElement = first;
        while (currentElement.getNext() != null && index > 0) {
            index--;
            previousElement = currentElement;
            currentElement = currentElement.getNext();
        }
        previousElement.setNext(currentElement.getNext());
        return currentElement;
    }

    // метод осуществляющий исключение всех элементов списка
    public void removeAll() {
        this.first = null;
    }

    //метод возвращает первый элемент коллекции
    public UnidirectionElement<T> getFirst() {
        return first;
    }

    //метод возвращает элемент коллекции по его текущему индексу в ней (счет ведется от 0 как в массивах)
    public UnidirectionElement<T> get(int index) {
        UnidirectionElement<T> currentElement = first;
        while (currentElement.getNext() != null && index > 0) {
            index--;
            currentElement = currentElement.getNext();
        }
        return currentElement;
    }

    //метод возвращает индекс текущего положения искомого элемента в списке или -1 если не нашел.
    public int conteins(T element) {
        UnidirectionElement<T> currentElement = first;
        int count = -1;
        while (currentElement.getNext() != null) {
            count++;
            if (currentElement.getValue().equals(element)) {
                return count;
            }
            currentElement = currentElement.getNext();
        }
        return -1;
    }

    //метод быстрого вывода на печать всех элементов списка
    @Override
    public String toString() {
        if (isEmpty()) return "[] Список пуст";
        String resultString = "[";
        UnidirectionElement<T> currentElem = this.first;
        do {
            resultString = resultString + currentElem;
            currentElem = currentElem.getNext();
            if (currentElem != null) resultString += ", \n ";
        } while (currentElem != null);
        resultString += "] ";
        return resultString;
    }

}
