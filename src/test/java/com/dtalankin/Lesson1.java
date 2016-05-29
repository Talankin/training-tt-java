/**
 *  15.09.2015
 *  Dmitry Talankin
 */

package com.dtalankin;

import java.util.Scanner;

import org.junit.Test;

public class Lesson1 {
    final static float EPS = 0.00001f;

    @Test
    public void task16() {
        System.out.println("================================ Task #1.6");

        int[] array2 = {1,2,3,4,5,0};
        int len2 = array2.length;
        boolean isAsc = true;
        boolean isDesc = true;
        boolean isSort = true;
        int elem = array2[0];

        System.out.print("массив : " + elem + " ");
        for (int i = 1; i < len2; i++) {
            System.out.print(array2[i] + " ");
            //по убыванию
            if (isDesc) {
                if (array2[i] < elem) {
                    elem = array2[i];
                    isAsc = false;
                } else {
                    isDesc = false;
                }
            }

            //по возрастанию
            if (isAsc) {
                if (array2[i] > elem) {
                    elem = array2[i];
                    isDesc = false;
                } else {
                    isAsc = false;
                }
            }

            //без сортировки
            if (!isAsc && !isDesc) {
                isSort = false;
                break;
            }
        }

        System.out.println();
        if (isSort) {
            if (isDesc) {
                System.out.println("Массив отсортирован по убыванию ");
            } else {
                System.out.println("Массив отсортирован по возрастанию ");
            }
        } else {
            System.out.println("Массив без сортировки ");
        }
    }

    @Test
    public void task15() {
        System.out.println("================================ Task #1.5");

        int[] array1 = {3,2,1,5};
        int len = array1.length;
        int sum1 = 0;
        int multi1 = 1;
        float middle;
        int min = array1[0];
        int max = array1[0];

        System.out.print("массив : ");
        for (int elem: array1) {
            System.out.print(elem + " ");
            sum1 += elem;
            multi1 *= elem;

            if (elem < min) {
                min = elem;
            }

            if (elem > max) {
                max = elem;
            }
        }

        middle = sum1/(float)len;

        System.out.println();
        System.out.println("Сумма элементов массива = " + sum1);
        System.out.println("Произведение элементов массива = " + multi1);
        System.out.println("Среднее значение элементов массива = " + middle);
        System.out.println("Минимальное значение элементов массива = " + min);
        System.out.println("Максимальное значение элементов массива = " + max);

    }

    @Test
    public void task14() {
        System.out.println("================================ Task #1.4");
        float xL, xR, yUp, yBot;

        Scanner scannerFloatShape = new Scanner(System.in);
        System.out.println("Введите Х координату первой вершины прямоугольника: ");
//        float x1 = scannerFloatShape.nextFloat();
        float x1 = 4.5f;
        System.out.println("Введите Y координату первой вершины прямоугольника: ");
//        float y1 = scannerFloatShape.nextFloat();
        float y1 = 3.5f;
        System.out.println("Введите Х координату второй вершины прямоугольника: ");
//        float x2 = scannerFloatShape.nextFloat();
        float x2 = 1.3f;
        System.out.println("Введите Y координату второй вершины прямоугольника: ");
//        float y2 = scannerFloatShape.nextFloat();
        float y2 = 6.6f;


        if (Math.abs(x1 - x2) <= EPS) {
            xL = x1;
            xR = x1;
        } else if (x1 < x2) {
            xL = x1;
            xR = x2;
        } else {
            xL = x2;
            xR = x1;
        }

        if (Math.abs(y1 - y2) <= EPS) {
            yUp = y1;
            yBot = y1;
        } else if (y1 < y2) {
            yUp = y1;
            yBot = y2;
        } else {
            yUp = y2;
            yBot = y1;
        }
        System.out.println("Координаты вашего прямоугольника получились такие: ");
        System.out.println("Левая верхняя точка: (" + xL + "; " + yUp + ")");
        System.out.println("Правая нижняя точка: (" + xR + "; " + yBot + ")");

        System.out.println("Введите X координату произвольной точки: ");
//        float pX = scannerFloatShape.nextFloat();
        float pX = 2.2f;
        System.out.println("Введите Y координату произвольной точки: ");
//        float pY = scannerFloatShape.nextFloat();
        float pY = 2.3f;

        if (Math.abs(pX - xL) <= EPS ||
                Math.abs(pX - xR) <= EPS ||
                Math.abs(pY - yUp) <= EPS ||
                Math.abs(pY - yBot) <= EPS) {
            System.out.println("Точка находится на грани прямоугольника");
        } else if (pX < xL ||
                pX > xR ||
                pY < yUp ||
                pY > yBot) {
            System.out.println("Точка находится за периметром прямоугольника");
        } else {
            System.out.println("Точка находится внутри прямоугольника");
        }

    }


    @Test
    public void task13() {
        System.out.println("================================ Task #1.3");
        System.out.println("Ввведите по очереди два вещественных числа числа:");
//        Scanner scannerFloat = new Scanner(System.in);
//        float f1 = scannerFloat.nextFloat();
//        float f2 = scannerFloat.nextFloat();
        float f1 = 4.4f;
        float f2 = 5.5f;

        float sumf = f1 + f2;
        float multif = f1 * f2;

        System.out.println("f1 + f2 = " + sumf);
        System.out.println("f1 * f2 = " + multif);

        if (Math.abs(f1 - f2) <= EPS) {
            System.out.println("f1 = f2" + f1 + "   " + f2);
        } else if (f1 < f2) {
            System.out.println("f1 < f2");
        } else {
            System.out.println("f1 > f2");
        }

    }


    @Test
    public void task12() {
        System.out.println("================================ Task #1.2");
        System.out.println("Ввведите по очереди два целых числа:");
//        Scanner scannerInt = new Scanner(System.in);
//        int x = scannerInt.nextInt();
//        int y = scannerInt.nextInt();
        int x = 5;
        int y = 6;

        int sum = x + y;
        int multi = x * y;
        int quot = x / y;
        int rem = x % y;

        System.out.println("x + y = " + sum);
        System.out.println("x * y = " + multi);
        System.out.println("x / y = " + quot);
        System.out.println("x % y = " + rem);

        if (x > y) {
            System.out.println("x > y");
        } else if (x < y) {
            System.out.println("x < y");
        } else {
            System.out.println("x = y");
        }

    }

    @Test
    public void task11() {
        System.out.println("================================ Task #1.1");
        System.out.println("Hello, World");
    }
}
