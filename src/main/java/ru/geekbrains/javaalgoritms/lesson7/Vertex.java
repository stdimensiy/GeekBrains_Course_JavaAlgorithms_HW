package ru.geekbrains.javaalgoritms.lesson7;

/**
 * Сourse: java algorithms
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 7
 * Created 07.03.2021
 * v 1.0
 */
public class Vertex {
    private char label;                                           // метка вершины (по примеру материала занятия №7)
    private boolean wasVisited;                                   // флаг признак того, что вершина была посещена

    public Vertex(final char label) {
        this.label = label;
        wasVisited = false;
    }

    public char getLabel() {
        return this.label;
    }

    public boolean isWasVisited() {
        return this.wasVisited;
    }

    public Vertex setWasVisited(final boolean wasVisited) {
        this.wasVisited = wasVisited;
        return this;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                '}';
    }
}
