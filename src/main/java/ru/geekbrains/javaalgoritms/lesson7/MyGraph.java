package ru.geekbrains.javaalgoritms.lesson7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Сourse: java algorithms
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 7
 * Created 0.03.2021
 * v 1.0
 */
public class MyGraph {
    private final int MAX_VERTS = 10;
    private Vertex vertexArray[];                    // массив вершин
    private int adjMat[][];                          // матрица смежности
    private int nVerts;                              // текущее количество вершин
    private Stack<Integer> stack;                    // пока примем как в занятии только целочисленные значения
    private Queue<Integer> queue;

    public MyGraph() {
        vertexArray = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        stack = new Stack<>();
    }

    // Базовый метод - Добавить вершину графа
    public boolean addVertex(char lab) {
        vertexArray[nVerts++] = new Vertex(lab);
        return true;
    }

    // Базовый метод - Добавить ребро графа (реализация подразумевает объявление ребер для направленных  и
    // взвешенных графов, причем возможно объявление ребер с разным весом при связи вершин в разных направлениях)
    public void addEdge(int start, int end, int weightStartEnd, int weightEndStart) {
        adjMat[start][end] = weightStartEnd;
        adjMat[end][start] = weightEndStart;
    }

    //метод сброса флагов посещения вершин графа
    public void resetVisited() {
        for (int j = 0; j < nVerts; j++) {
            vertexArray[j].setWasVisited(false);
        }

    }

    // Метод обхода графа в глубину (Depth-First Search = DFS = dfs)
    public void dfs(int indexVertex) {
        do {
            if (indexVertex == -1)                                                // в цикле проверяем индекс вершины
                stack.pop();                                                      // которую еще не посетили (в том числе
            else {                                                                // стартовой) если  он не -1 то
                System.out.println(vertexArray[indexVertex].setWasVisited(true)); // добавляем его в стек, иначе убираем
                stack.push(indexVertex);                                          // верхний элемент из стека. Помечаем вершину
            }                                                                     // как посещенную и печатаем отчет. Если стек не пуст
        } while (!stack.empty() && ((indexVertex = getUnvisitedVertex(stack.peek())) != -2)); // смотрим на верхний индекс и запрашиваем индекс вершины которую еще не посещали.
        resetVisited();                                                           // зачищаем флаги посещения
    }

    // Метод обхода графа в ширину («go wide, bird’s eye-view» Bird’s-First Search = BFS = bfs)
    public void bfc(int indexVertex) {
        queue = new LinkedList<>();
        System.out.println(vertexArray[indexVertex].setWasVisited(true));
        queue.add(indexVertex);
        do {
            int tempIndex;
            indexVertex = queue.remove();
            while ((tempIndex = getUnvisitedVertex(indexVertex)) != -1) {
                System.out.println(vertexArray[tempIndex].setWasVisited(true));
                queue.add(tempIndex);
            }
        } while (!queue.isEmpty());
        resetVisited();
    }

    // метод проверки наличия у вершины смежных вершин которые не посетили, возвращает индекс найденной вершины или -1
    private int getUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) if (!(adjMat[v][j] < 1 || vertexArray[j].isWasVisited())) return j;
        return -1;
    }
}
