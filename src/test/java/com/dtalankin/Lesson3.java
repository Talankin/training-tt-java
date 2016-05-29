/**
 *  15.09.2015
 *  Dmitry Talankin
 */

package com.dtalankin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

import com.dtalankin.cars.Car;
import com.dtalankin.figures.Circle;
import com.dtalankin.figures.Cylinder;
import com.dtalankin.figures.Figure;
import com.dtalankin.figures.Point2D;
import com.dtalankin.figures.Point3D;
import com.dtalankin.figures.Rectangle;
import com.dtalankin.figures.Rectangle3D;
import com.dtalankin.figures.Triangle;
import org.junit.Test;

public class Lesson3 {

    @Test
    public void task313() {
        System.out.println("\n================================ Task #3.13");

        Car car = new Car("Toyota", 2000, 180, Color.RED);
        car.print();
        Car car1 = new Car("Nissan", 2000, 180, Color.RED);
        car1.print();

        Colored col = car;
        col.setColor(Color.RED);
        car.print();
        car.setColor(Color.RED);
        car.print();

        Circle circle = new Circle(1,1,10,Color.GREEN);
        circle.print();
        Colored col1 = circle;
        col1.setColor(Color.GREEN);
        circle.print();

        Rectangle rect1 = new Rectangle(1,4,5,3,Color.GREEN);
        rect1.print();
        Colored col2 = rect1;
        col2.setColor(Color.GREEN);
        rect1.print();

        Rectangle3D rect3d = new Rectangle3D(1,4,5,3,6,Color.GREEN);
        rect3d.print();
        Colored col7 = rect3d;
        col7.setColor(Color.GREEN);
        rect3d.print();

        Triangle tri = new Triangle(1,3,4,5,6,7,Color.GREEN);
        tri.print();
        Colored col3 = tri;
        col3.setColor(Color.GREEN);
        tri.print();

        Point2D p2d = new Point2D(1,2,Color.GREEN);
        p2d.print();
        Colored col4 = p2d;
        col4.setColor(Color.GREEN);
        p2d.print();

        Point3D p3d = new Point3D(1,2,3,Color.GREEN);
        p3d.print();
        Colored col5 = p3d;
        col5.setColor(Color.GREEN);
        p3d.print();

        Cylinder cyl = new Cylinder(1,2,10,3,Color.GREEN);
        cyl.print();
        Colored col6 = cyl;
        col6.setColor(Color.GREEN);
        cyl.print();


    }

    @Test
    public void task312() {
        System.out.println("\n================================ Task #3.12");

        Car car = new Car("Toyota", 2000, 180, Color.GREEN);
        Car car1 = new Car("Nissan", 2000, 180, Color.GREEN);
        car.print();
        car1.print();

        System.out.println("машины равны : " + car.equals(car1));


    }

    @Test
    public void task311() {
        System.out.println("\n================================ Task #3.11");
        Rectangle3D r3D2 = new Rectangle3D(Color.GREEN);
        Rectangle r5 =new Rectangle(5,5,Color.GREEN);
        Cylinder c3 = new Cylinder(2,2,2,2,Color.GREEN);
        Circle cir2 = new Circle(5,5,5,Color.GREEN);
        Figure f2, f3, f4, f5;
        f2 = r3D2;
        f2.print();
        System.out.println(f2);
        f3 = r5;
        f3.print();
        System.out.println(f3);
        f4 = c3;
        f4.print();
        System.out.println(f4);
        f5 = cir2;
        f5.print();
        System.out.println(f5);

    }

    @Test
    public void task310() {
        System.out.println("\n================================ Task #3.10");
        Rectangle3D r3D1 = new Rectangle3D(Color.GREEN);
        Rectangle r4 =new Rectangle(5,5,Color.GREEN);
        r4.print();
        r4 = r3D1;
        r4.print();

        Cylinder c2 = new Cylinder(2,2,2,2,Color.GREEN);
        Circle cyr1 = new Circle(5,5,5,Color.GREEN);
        cyr1.print();
        cyr1 = c2;
        cyr1.print();

    }

    @Test
    public void task39() {
        System.out.println("\n================================ Task #3.9");
        Circle c1 = new Circle(1,3,10,Color.GREEN);
        c1.print();
        c1.move(5, 6);
        c1.print();
        System.out.println("getX1() = " + c1.getX1());
        test(c1);
        c1.print();

        Rectangle r1 = new Rectangle(2,4,Color.GREEN);
        r1.print();
        r1.move(5, 5);
        r1.print();
        Rectangle r2 = new Rectangle(2,4,1,3,Color.GREEN);
        r2.print();

        Rectangle r3 = new Rectangle(Color.GREEN);
        r3.print();
        test(r3);
        r3.print();

        Triangle t1 = new Triangle(1,1,0,0,4,4,Color.GREEN);
        t1.print();
        t1.move(5, 5);
        t1.print();
        test(t1);
        t1.print();

        Triangle t2 = new Triangle(1,1,2,2,3,3,Color.GREEN);
        Figure f1 = t2;
        f1.print();
        test(f1);
        f1.print();

    }

    @Test
    public void task38() {
        System.out.println("\n================================ Task #3.8");
        Cylinder cyl = new Cylinder(1,1,10,5,Color.GREEN);
        cyl.print();

        cyl.move(2, 2);
        cyl.print();
        System.out.println("Площадь основания цилиндра = " + cyl.square());
        System.out.println("Объем цилиндра = " + cyl.volume());
        System.out.println("Точка внутри цилиндра = " + cyl.isPointInside(3, 12, 3));

        Point3D p1 = new Point3D(3,-6,3,Color.GREEN);
        System.out.println("Точка 3D внутри цилиндра = " + cyl.isPointInside(p1));

        Cylinder cyl2 = new Cylinder(1,1,10,5,Color.GREEN);
        Cylinder cyl3 = new Cylinder(1,1,10,4,Color.GREEN);
        System.out.println("Цилиндры одинаковы " + cyl2 + " и " + cyl3 + " = " + cyl2.equals(cyl3));

    }

    @Test
    public void task37() {
        System.out.println("\n================================ Task #3.7");
        // Удалить из класса Rectangle3D метод, вычисляющий объем,
        // и вычислить объем, используя анонимный класс
        double volumeRect3D = new Rectangle3D(0,0,5,4,4,Color.GREEN) {
            double volume() {
                return super.square() * getHeight();
            }
        }.volume();

        System.out.println("Объем пар-да = " + volumeRect3D);

    }

    @Test
    public void task36() {
        System.out.println("\n================================ Task #3.6");
        Rectangle3D rect3D1 = new Rectangle3D(10,3,8,2,25,Color.GREEN);
        Rectangle3D rect3D2 = new Rectangle3D(8,21,20,Color.GREEN);
        Rectangle3D rect3D3 = new Rectangle3D(Color.GREEN);
        Rectangle3D rect3D4 = new Rectangle3D(7,5,5,20,21,Color.GREEN);

        rect3D1.print();
        rect3D1.move(100, 200);
        rect3D1.print();

        rect3D2.print();
        rect3D2.decreaseRectangle(0, 0);
        rect3D2.print();

        System.out.println("Площадь основания = " + rect3D1.square());
        //System.out.println("Объем пар-да = " + rect3D1.volume());

        rect3D2.print();
        System.out.println("Точка с координатами находится внутри параллелипипеда = " + rect3D2.isPointInside3D(6, 19, 10));
        Point3D p3D = new Point3D(6, 19, 19,Color.GREEN);
        System.out.println("Точка 3D с координатами находится внутри параллелипипеда = " + rect3D2.isPointInside3D(p3D));
        rect3D2.print();
        rect3D4.print();
        System.out.println("Параллелипипед1 пересекается с пар-дом 2 = " + rect3D2.isCrossRectangles(rect3D4));
        System.out.println(rect3D4 + " вложен в " + rect3D2 + " = " + rect3D4.isRectangleInside(rect3D2));

        Rectangle3D rect3D5 = new Rectangle3D(7,5,5,20,21,Color.GREEN);
        System.out.println("Парал-ды равны " + rect3D4 + " и " + rect3D5 + " = " + rect3D4.equals(rect3D5));

    }

    @Test
    public void task35() {
        System.out.println("\n================================ Task #3.5");
        BigInteger bigI = new BigInteger("888888888888888889999999999999999999999999999999999999998888888888888888888888888");
        BigDecimal bigD = new BigDecimal("888888888888888889999999999999999999999999999999999999998888888888888888888888888000003333377777");
        bigI = bigI.multiply(bigD.toBigInteger());
        bigD = bigD.add(bigD);
        bigD = bigD.multiply(bigD);
        System.out.println("bigI = " + bigI + ";\nbigD = " + bigD);

    }

    @Test
    public void task34() {
        System.out.println();
        System.out.println("\n================================ Task #3.4");
        int a = 47;
        double b = 33.55;
        int a2 = 0;
        double b2 = 0.0;
        Integer a1 = new Integer(a);
        Double b1 = new Double(b);
        a2 = a1;
        b2 = b1;
        System.out.println("a2 = " + a2 + " b2 = " + b2);

    }

    @Test
    public void task33() {
        System.out.println();
        System.out.println("\n================================ Task #3.3");
        StringBuilder sb = new StringBuilder();
        System.out.println("sb = " + sb.toString());
        sb.append(true);
        System.out.println("sb = " + sb.toString());
        sb.append("far");
        System.out.println("sb = " + sb.toString());
        sb.append('f');
        System.out.println("sb = " + sb.toString());
        sb.insert(3, "-------");
        System.out.println("sb = " + sb.toString());

    }

    @Test
    public void task32() {
        System.out.println("\n================================ Task #3.2");
        String str = new String("any text here text");
        String str1 = "defacto";
        String str2 = "tdsdefacto rtu";
        String str3 = "facto";
        String str4 = "deFacTo";
        String str5 = "pijame";
        str5 += str1;

        System.out.println("length = " + str.length());

        System.out.println("charAt = " + str.charAt(9));

        System.out.println("indexOf = " + str.indexOf('t'));
        System.out.println("indexOf = " + str.indexOf('t', 5));
        System.out.println("indexOf = " + str.indexOf("text"));
        System.out.println("indexOf = " + str.indexOf("text", 11));
        System.out.println("lastIndexOf = " + str.lastIndexOf('t'));
        System.out.println("lastIndexOf = " + str.lastIndexOf('x', 10));
        System.out.println("lastIndexOf = " + str.lastIndexOf("text"));
        System.out.println("lastIndexOf = " + str.lastIndexOf("text", 10));

        System.out.println("equals = " + str1.equals(str2));
        System.out.println("equals = " + str1.equals(str4));
        System.out.println("equals = " + str1.equalsIgnoreCase(str4));

        System.out.println("compareTo = " + "S".compareTo("a"));
        System.out.println("compareTo = " + "ab".compareTo("ab"));
        System.out.println("compareTo = " + "ab".compareTo("ac"));
        System.out.println("compareToIgnoreCase = " + "S".compareToIgnoreCase("a"));

        System.out.println("concate = " + "sdoba".concat("***net"));
        System.out.println("+ : " + "sdoba" + "net");
        System.out.println("+= : " + str5);

        System.out.println("startsWith = " + str2.startsWith(str1));
        System.out.println("startsWith = " + str2.startsWith(str1, 3));
        System.out.println("endsWith = " + "aaaadcv".endsWith("adcv"));

        System.out.println("substring = " + "aaaadcv".substring(4));
        System.out.println("substring = " + "aaaadcv".substring(4, 6));

        System.out.println("getBytes = " + Arrays.toString("abcd".getBytes()));
        char[] buf = new char[3];
        "abcd".getChars(0, 3, buf, 0);
        for(char ch : buf) {
            System.out.println("getChars = " + ch);
        }

        System.out.println("replace = " + "abcdbbb".replace('b', 'f'));
        System.out.println("replaceFirst = " + "abcdbbb".replaceFirst("bbb", "f"));

        String[] arrStr = "a,c,d,bb,55,eeee,,jj".split(",");
        for(String elem : arrStr) {
            System.out.println("split = " + elem);
        }
        System.out.println();
        String[] arrStr1 = "a,c,d,bb,55,eeee".split(",",3);
        for(String elem : arrStr1) {
            System.out.println("split = " + elem);
        }

        System.out.println("trim = " + "    abcdbbb    ");
        System.out.println("trim = " + "    abcdbbb    ".trim());


        System.out.println("valueOf = " + String.valueOf(buf));
        System.out.format("Local time: %tT", Calendar.getInstance());

    }

    @Test
    public void lesson3() {
        System.out.println("\n================================ Lesson #3");

        String str1 = new String("999");
        String str2 = "999";
        int len = str1.length();
        System.out.println("len = " + len);

        // оболочки типов
        int x = 10; // притимтивный тип
        // оболочка вокруг примитивного типа: экземпляр класса внутри который содержит 4 байта int
        Integer x1 = x;// new Integer(x);
        Double d = 10.6d; // new Double(10.6d)
        //Double d = 10.6f; нельзя передать float но можно стринг - см параметры в документашке
        Double d1 = new Double("999");
        System.out.println("d1 = " + d1);

        BigInteger bInt = new BigInteger("999999999999999999999999999999999999999999999999999999999999999999999999999");
        BigInteger bInt1 = bInt.add(bInt);

        System.out.println("bInt1 = " + bInt1);

        BigDecimal bDec = new BigDecimal("77777777777777777777777777777777777777777777777777777777777777777777777777777.7777E5");
        BigDecimal bDec1 = bDec.multiply(bDec);
        System.out.println("bDec1 = " + bDec1);

        double s = Math.sin(Math.PI);
        System.out.println("s = " + s);

        // -------------- Наследование -----------------
        Point3D pt3 = new Point3D(10,20,30,Color.GREEN);
        Point2D pt4 = pt3; // типа виртуальность

        Point2D[] arr = new Point2D[2];
        arr[0] = new Point2D(10,Color.GREEN);
        arr[1] = new Point3D(10,20,30,Color.GREEN);
        for(Point2D pt : arr) {
            pt.moveTo(100,200);
        }

        // ----------- Абстрактные классы --------------
        Point2D pt5 = new Point2D(1,Color.GREEN);
        final Point2D pt6 = pt5;

        // ----------- Анонимные классы ----------------
        int vol = new Point3D(1,2,3,Color.GREEN) {
            int volume() {
                return getX() * getY() * getZ();
            }
        }.volume();

        System.out.println("vol = " + vol);
    }

    static void test(Figure f) {
        f.move(2,2);
    }
}
