/**
 *  15.09.2015
 *  Dmitry Talankin
 */

package com.dtalankin;

import com.dtalankin.figures.Circle;
import com.dtalankin.figures.CircleFactory;
import com.dtalankin.figures.Point2D;
import com.dtalankin.figures.Rectangle;
import com.dtalankin.figures.Triangle;
import org.junit.Test;

public class Lesson2 {

    @Test
    public void task210() {
        System.out.println("\n================================ Task #2.10");
        Circle circle5 = CircleFactory.createCircle(2, 1, 5, Color.GREEN);
        Circle circle6 = CircleFactory.createCircle(2,1,7,Color.GREEN);
        Circle circle7 = CircleFactory.createCircle(2,1,9,Color.GREEN);
        Circle[] arrayCircles = new Circle[10];

        for(int i = 0; i < arrayCircles.length; i++) {
            arrayCircles[i] = CircleFactory.createCircle(i*2,i,i+1, Color.GREEN);
            arrayCircles[i].print();
        }

        System.out.println("Количество окружностей = " + CircleFactory.getCountCircles());

    }


    @Test
    public void task29() {
        System.out.println("\n================================ Task #2.9");
        Circle circle = new Circle(1,4,10,Color.GREEN);
        circle.print();

        circle.move(2, 5);
        circle.print();

        System.out.println("Площадь круга = " + circle.square());
        System.out.println("Длина окружности = " + circle.circuit());

        Circle circle1 = new Circle(0,0,10,Color.GREEN);
        circle1.print();
        System.out.println("Точка внутри окружности = " + circle1.isPointInside(0, -9));

        Point2D point2D3 = new Point2D(0,Color.GREEN);
        System.out.println(point2D3 + " находится внутри окружности = " + circle1.isPointInside(point2D3));

        Circle circle4 = new Circle(0,0,10,Color.GREEN);
        System.out.println("Окружности одинаковы " + circle4 + " и " + circle1 + " = " + circle4.equals(circle1));

    }


    @Test
    public void task28() {
        System.out.println("\n================================ Task #2.8");
        Triangle triangle1 = new Triangle(2,1,4,6,6,3,Color.GREEN);
        triangle1.print();
        System.out.println("Площадь треугольника = " + triangle1.square());

        triangle1.move(4, 4);
        triangle1.print();

        Triangle triangle2 = new Triangle(2,1,4,6,6,3,Color.GREEN);
        System.out.println("Точка внутри треугольника = " + triangle2.isPointInside(5, 5));

        Point2D point2D1 = new Point2D(3,Color.GREEN);
        System.out.println(point2D1 + " находится внутри треугольника = " + triangle2.isPointInside(point2D1));

        Triangle triangle3 = new Triangle(0,0,0,0,0,0,Color.GREEN);
        triangle3.print();
        System.out.println("Все стороны треугольника равны = " + triangle3.isAllSidesEquals());

        Triangle triangle4 = new Triangle(2,1,4,6,6,3,Color.GREEN);
        System.out.println("Треугольники равны " + triangle4 + " и " + triangle2 + " = " + triangle4.equals(triangle2));

    }

    @Test
    public void task27() {
        System.out.println("================================ Task #2.7");

        Rectangle rect = new Rectangle(1,2,3,4,Color.GREEN);
        rect.print();

        Rectangle rect1 = new Rectangle(10,5,Color.GREEN);
        Rectangle rect3 = new Rectangle(10,5,Color.GREEN);
        rect1.print();

        Rectangle rect2 = new Rectangle(Color.GREEN);
        rect2.print();

        rect2.move(4, 4);
        rect2.print();

        rect2.decreaseRectangle(2, 2);
        rect2.print();

        System.out.println("Площадь " + rect + " = " + rect.square());
        System.out.println("Точка с координатами находится внутри прямоугольника = " + rect1.isPointInside(9, 2));

        Point2D point2D = new Point2D(5,Color.GREEN);
        System.out.println("Точка 2D с координатами находится внутри прямоугольника = " + rect1.isPointInside(point2D));

        System.out.println(rect1 + " пересекается с " + rect + " = " + rect1.isCrossRectangles(rect));
        System.out.println(rect2 + " вложен в " + rect1 + " = " + rect2.isRectangleInside(rect1));

        System.out.println("До увеличения " + rect);
        rect.large(2, 4);
        System.out.println("После увеличения " + rect);

        System.out.println("Прямоугольники равны " + rect1 + " и " + rect3 + " = " + rect1.equals(rect3));
        System.out.println("Hash " + rect1 + " = " + rect1.hashCode());

    }
    @Test
    public void lesson2() {
        System.out.println("================================ Lesson #2");
        // циклы
        int[] b = {1,2,3};
        int[][] a = {{1,2,3},{3,2,1},{4,5,6}};
        boolean res = false;
        for (int i = 0; i< b.length; i++) {
            if (b[i] == 2) {
                res = true;
                break;
            }

        }

        outer:
        for (int i = 0; i< a.length; i++) {
            for (int j = 0; j< a[0].length; j++) {
                if (a[i][j] == 2) {
                    System.out.println("Yes " + i);
                    continue outer;
                }
            }
        }


        int k = 0;
        while (k< b.length) {
            System.out.println(b[k++]);
        }

        k = 0;
        do {
            System.out.println(b[k++]);
        } while (k < b.length);


        //классы
        //методы чаще public, но можно и private
        //поля в основном private
        Point2D point1 = new Point2D(10,Color.GREEN);
        Point2D point2 = new Point2D(10,Color.GREEN);

        System.out.println(Point2D.getCount());

        //point = null; - удаление ссылки и сборщик мусора когда то приступит к удалению
        //point.setX(47);

        if (point1.equals(point2)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }

        point1.moveTo(11, 10);
        point1.moveTo(22);
        point1.print();
        changePoint(point1);

        point1.print();

        Point2D point3 = fixedPoint(33,Color.GREEN);
        point3.print();

    }

    public static void changePoint (Point2D point) {
        point.moveTo(11, 33);
    }

    public static Point2D fixedPoint (int x, Color y) {
        Point2D pt = new Point2D(x,y);
        return pt;
    }


}
