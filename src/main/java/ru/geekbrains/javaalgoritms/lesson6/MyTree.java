package ru.geekbrains.javaalgoritms.lesson6;

import java.util.Stack;

/**
 * Сourse: java algorithms
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 6
 * Created 01.03.2021
 * v 1.0
 */
public class MyTree {
    private Node rootNode;                              // корневой узел дерева
    private Node rightmostNode;                         // самый правый узел (лист) - максимальное значение
    private Node leftmostNode;                          // самый левый узел (лист) - минимальное значение
    private int count;                                  // общее количество узлов (для признака балансировки)
    private int levels;                                 // количество уровней дерева (для признака балансировки)

    public MyTree() {                                    // Конструктор создает пустое дерево с корневым узлом равным null
        rootNode = null;                                 // присваиваем значение null корневому элементу
        rightmostNode = null;                            // присваиваем значение null максимальному элементу
        leftmostNode = null;                             // присваиваем значение null минимальному элементу
    }

    // метод быстро возвращает максимальный элемент дерева
    public Node getMax() {
        return rightmostNode;
    }

    // резервный метод именно поиска максимального и минимального значения
    // согласно задания реализовать поиск максимума ( в дальнейшем проверю скорость)
    // реализован на базе основного свойства бинарного дерева поиска (правый наследник всегда больше)
    public Node findMax() {
        Node currentNode = rootNode;
        while (currentNode.getRightChild() != null) {
            currentNode = currentNode.getRightChild();
        }
        return currentNode;
    }

    // метод быстро возвращает минимальный элемент дерева
    public Node getMin() {
        return leftmostNode;
    }

    // резервный метод именно поиска минимального значения
    // согласно задания реализовать "поиск" минимума ( в дальнейшем проверю скорость)
    // реализован на базе основного свойства бинарного дерева поиска (левый наследник всегда меньше)
    public Node findMin() {
        Node currentNode = rootNode;
        while (currentNode.getLeftChild() != null) {
            currentNode = currentNode.getLeftChild();
        }
        return currentNode;
    }

    // Задание 6.3
    // Метод осуществляет поиск узла по значению
    public Node findNodeByValue(int findValue) {
        Node currentNode = rootNode;                       // назначаем тек. элементу корневой узел (начинаем поиск)
        while (currentNode.getValue() != findValue) {      // цикла поиска будет прерван если элемент будет найден
            if (findValue < currentNode.getValue()) {      // искомое значение меньше - движение влево?
                currentNode = currentNode.getLeftChild();  // делаем текущий левого потомка
            } else {                                       // искомое значение больше или равно движение вправо
                currentNode = currentNode.getRightChild(); // делаем текущий правого потомка
            }
            if (currentNode == null) {                     // потомков больше нет.
                return null;                               // прерываем цикл возвращаем null
            }
        }
        return currentNode;                                // если программа дошла сюда то возвращаем найденный элемент
    }

    // Задание 6.3
    // Метод осуществляет вставку нового узла в дерево (с использование поля родителя)
    public boolean insertNode(int newValue) {
        Node newNode = new Node();                         // создаем новый узел
        newNode.setValue(newValue);                        // записываем данные в узел
        if (rootNode == null) {                            // если корневой узел пустой (дерево пустое)
            newNode.setParent(null);                       // присваиваем ссылку на текущий узел минимальному элементу
            rootNode = newNode;                            // присваиваем корневому узлу ссылку на текущий узел
            rightmostNode = newNode;                       // присваиваем ссылку на текущий узел максимальному элементу
            leftmostNode = newNode;                        // присваиваем ссылку на текущий узел минимальному элементу
            count++;                                       // обновляем значение счетчика элементов
            levels++;                                      // обновляем значение уровня дерева
            return true;
        } else {                                           // если корневой узел существует тогда
            Node currentNode = rootNode;                   // делаем корневой элемент текущим и
            if (newValue < leftmostNode.getValue()) {      // записываем значение минимального элемента для
                leftmostNode = newNode;                    // быстрого доступа
                levels++;
            }
            if (newValue > rightmostNode.getValue()) {     // записываем значение максимального элемента для
                rightmostNode = newNode;                   // быстрого доступа
                levels++;
            }
            while (true) {                                        // создаем бесконечный цикл
                if (newValue == currentNode.getValue()) {         // если такой элемент в дереве уже есть,
                    return false;                                 // просто выходим из метода, возвращаем "неудача"
                } else if (newValue < currentNode.getValue()) {   // если новое значение меньше движемся влево
                    if (currentNode.getLeftChild() == null) {     // если был достигнут конец ветви (листа)
                        currentNode.setLeftChild(newNode);        // тогда делаем новый элемент левым потомком
                        newNode.setParent(currentNode);           // новому узлу назначаем родителя
                        count++;
                        return true;                              // выходим из метода, возвращаем "успех"
                    }
                    currentNode = currentNode.getLeftChild();     // иначе движемся влево
                } else {                                          // если новое значение больше движемся вправо
                    if (currentNode.getRightChild() == null) {    // если был достигнут конец ветви (листа),
                        currentNode.setRightChild(newNode);       // тогда делаем новый элемент правым потомком
                        newNode.setParent(currentNode);           // новому узлу назначаем родителя
                        count++;
                        return true;                              // выходим из метода, возвращаем "успех"
                    }
                    currentNode = currentNode.getRightChild();
                }
            }
        }
    }

    //Задание 6.4
    // метод простой визуализации дерева в консоли
    // сканирующий поуровнево обход сверху вниз
    public void simplePrintTree() {
        Stack extStack = new Stack();                           // внешний стек для значений дерева
        Stack intStack = new Stack();                           // внутренний стек для задания потомков элемента
        boolean isLvlEmpty = false;                             // флаг - признак пустого уровня
        System.out.println("--(start)-------- Simple Print Tree -------------------");
        extStack.push(rootNode);
        while (!isLvlEmpty) {
            isLvlEmpty = true;
            while (!extStack.isEmpty()) {                       // если внешний стек не пустой
                Node temp = (Node) extStack.pop();              // забираем из стека верхний элемент
                if (temp != null) {                             // если элемент не пустой
                    System.out.print("{" + temp.getValue() + "}"); // выдаем его значение в консоль
                    intStack.push(temp.getLeftChild());         // добавляем во внутренний стек, левого наследника
                    intStack.push(temp.getRightChild());        // добавляем во внутренний стек, правого наследника
                    if (!(temp.getLeftChild() == null &&        // проверяем если хотя-бы один наследник
                            temp.getRightChild() == null))      // тогда устанавливаем маркер что следующий уровень
                        isLvlEmpty = false;                     // не пустой и нужен еще виток
                } else {                                        // - если элемент пустой
                    System.out.print("{_}");                    // выводим специальный символ "заглушку" на его месте
                    intStack.push(null);                   // добавляем во внутренний стек, пустого левого наследника
                    intStack.push(null);                   // добавляем во внутренний стек, пустого правого наследника
                }                                               // чтобы зарезервировать место под пустой элемент уровнем ниже
            }
            System.out.println();                               // формируем перевод строки и переходим на след. уровень
            while (!intStack.isEmpty())                         // перемещаем из внутреннего стека во внешний все
                extStack.push(intStack.pop());                  // найденные и зарезервированные элементы след. уровня
        }
        System.out.println("--(stop)-------- Simple Print Tree -------------------");
    }

    // Задание 6.5
    // Удаление узла по значению (ключу) с использованием поля родителя
    public boolean deleteNode(int value) {
        Node currentNode = rootNode;
        Node parentNode = rootNode;
        boolean isLeftChild = true;
        // подзадача №1 найти удаляемый узел
        currentNode = findNodeByValue(value);
        if (currentNode == null)
            return false;              // если узел не найден выходим из метода возвращаем "неудача"
        parentNode = currentNode.getParent();

        //ситуация Первая - узел это Лист (потомков нет)
        if (currentNode.getLeftChild() == null &&
                currentNode.getRightChild() == null) {
            if (currentNode == rootNode) {
                rootNode = null;               // если узел - корень, то дерево очищается
                count = 0;
                levels = 0;
            } else {
                if (currentNode.getParent().getLeftChild() == currentNode)
                    currentNode.getParent().setLeftChild(null); // иначе - левый узел отсоединяется, от родителя
                if (currentNode.getParent().getRightChild() == currentNode)
                    currentNode.getParent().setRightChild(null); // иначе - правый узел отсоединяется, от родителя
                count--;
                if (currentNode == rightmostNode) rightmostNode = currentNode.getParent();
                if (currentNode == leftmostNode) leftmostNode = currentNode.getParent();
            }
            // ситуация вторая  - у удаляемого узла нет правого потомка тогда узел просто заменяется левым поддеревом
        } else if (currentNode.getRightChild() == null) {
            if (currentNode == rootNode) {                   // опять же если это корень дерева
                rootNode = currentNode.getLeftChild();
                count--;
                levels--;
            } else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getLeftChild());
            else
                parentNode.setRightChild(currentNode.getLeftChild());
        } else if (currentNode.getLeftChild() == null) { // узел заменяется правым поддеревом, если левого потомка нет
            if (currentNode == rootNode)
                rootNode = currentNode.getRightChild();
            else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getRightChild());
            else
                parentNode.setRightChild(currentNode.getRightChild());
        } else { // если есть два потомка, узел заменяется преемником
            Node heir = receiveHeir(currentNode);// поиск преемника для удаляемого узла
            if (currentNode == rootNode)
                rootNode = heir;
            else if (isLeftChild)
                parentNode.setLeftChild(heir);
            else
                parentNode.setRightChild(heir);
        }
        return true; // элемент успешно удалён
    }

    // метод возвращает узел со следующим значением после передаваемого аргументом.
    // для этого он сначала переходим к правому потомку, а затем
    // отслеживаем цепочку левых потомков этого узла.
    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRightChild();               // Переход к правому потомку
        while (currentNode != null)                            // Пока остаются левые потомки
        {
            parentNode = heirNode;                             // потомка задаём как текущий узел
            heirNode = currentNode;
            currentNode = currentNode.getLeftChild();          // переход к левому потомку
        }
        // Если преемник не является
        if (heirNode != node.getRightChild())                  // правым потомком,
        { // создать связи между узлами
            parentNode.setLeftChild(heirNode.getRightChild());
            heirNode.setRightChild(node.getRightChild());
        }
        return heirNode;                                        // возвращаем приемника
    }
}
