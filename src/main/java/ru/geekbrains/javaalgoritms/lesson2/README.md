### GeekBrains_Course_JavaAlgorithms_HW_Lesson_2
---
### Домашняя работа к занятию №2
Студента GeekBrains ***Веремеенко Дмитрия***    
Факультет: ***Android-разработки***    
Курс: ***Алгоритмы Java***
### Задание:
---
- [X] ***Задача №2.1***	На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих
  примитивных или ссылочных типов данных.
  Выполните обращение к массиву и базовые операции класса Arrays.
  Оценить выполненные методы с помощью базового класса System.nanoTime().
- [X] ***Задача №2.2***	На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
  Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте
  уже существующий массив данных.
- [X] ***Задача №2.3***	Создайте массив размером 400 элементов.
  Выполните сортировку с помощью метода sort().
  Оцените сортировку с помощью базового класса System.nanoTime().
- [X] ***Задача №2.4***	На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
  Оцените сортировку с помощью базового класса System.nanoTime().    
- [X] ***Задача №2.5***	На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
  Оцените сортировку с помощью базового класса System.nanoTime().
  Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.    
- [X] ***Задача №2.6***	На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
  Оцените сортировку с помощью базового класса System.nanoTime().
  Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.
  

### Отчет о выполнении:
---    
:heavy_check_mark: ***Задача №2.1.*** Задание выполнено. Объявлен и инициирован одномерный массив (оригинал), 
заполнен случайными значениями типа int. Выполнены обращения к массиву и базовые операции библиотеки 
Arrays (toString(),copyOf(), sort()).    
:heavy_check_mark: ***Задача №2.2.*** Задание выполнено. Создана рабочая копия оригинального массива в котором выполнен
линейный, а затем двоичный поиск значения (значение выбрано специально с учетом наихудшего положения в массиве, 
для чистоты эксперимента). Оба варианта оснащены замером времени выполнения.
Результат выведен в консоль (как и вывод).    
:heavy_check_mark: ***Задача №2.3.*** Задание выполнено. Оригинальный массив заданного размера создан,
заполнен случайными значениями и отсортирован по возрастанию методом sort(). ДЛя большей наглядности разницы времени
исполнения каждого конкретного алгоритма сортировки, количество элементов в массиве увеличено до 40000.    
:heavy_check_mark: ***Задача №2.4.*** Задание выполнено. Метод пузырьковой сортировки создан, сортировка массива
произведена, замер времени осуществлен. Результат выведен в консоль.   
:heavy_check_mark: ***Задача №2.5.*** Задание выполнено. Метод сортировки выбором создан, сортировка массива
произведена, замер времени осуществлен. Результат выведен в консоль.    
:heavy_check_mark: ***Задача №2.6.*** Задание выполнено. Метод сортировки вставкой создан, сортировка массива
произведена, замер времени осуществлен. Результат выведен в консоль.

 P.S. Дополнительная информация. В коде присутствуют закомментированные строки вывода состояния массивов до обработки и после.
Из кода убирать не стал специально, если кто будет разбирать работу примера и нужно убедиться в 
достоверности результата, необходимо уменьшить размер массива в строке 66 и снять комментарии 
с закомментированных строк, тогда работа программы станет намного наглядней и понятней.
      
---   

*StDimensiy 24.02.2021*
