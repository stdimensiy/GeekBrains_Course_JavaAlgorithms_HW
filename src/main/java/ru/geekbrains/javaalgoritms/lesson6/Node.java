package ru.geekbrains.javaalgoritms.lesson6;

/**
 * Сourse: java algorithms
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 6
 * Created 04.03.2021
 * v 1.0
 */
public class Node {

    private int value;         // ключ узла
    private Node leftChild;    // ссылка на левый узел потомок
    private Node rightChild;   // ссылка на правый узел потомок
    private Node parent;       // ссылка на родительский узел (запрета на использование подобного подхода нет,
    // применение в алгоритмах приводится в работе О.В. СЕНЮКОВА СБАЛАНСИРОВАННЫЕ ДЕРЕВЬЯ ПОИСКА
    // МГУ факультет ВМК 2014 ( для выполнения ДЗ использован дополнительный материал)

    public Node getParent() {
        return this.parent;
    }

    public void setParent(Node node) {
        this.parent = node;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(final Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(final Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "Значение: " + value +
                ", Родительский узел " +(parent != null ? parent.getValue() : parent) +
                ", Узел левого потомка: " + (leftChild != null ? leftChild.getValue() : leftChild) +
                ", Узел правого потомка: " + (rightChild != null ? rightChild.getValue(): rightChild) +
                '}';
    }
}
