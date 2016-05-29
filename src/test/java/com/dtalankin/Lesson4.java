/**
 *  15.09.2015
 *  Dmitry Talankin
 */

package com.dtalankin;

import com.dtalankin.boxes.ArrayBox;
import com.dtalankin.boxes.ArrayBoxT;
import com.dtalankin.boxes.Box;
import com.dtalankin.boxes.BoxT;
import com.dtalankin.boxes.NamedArrayBox;
import com.dtalankin.boxes.PairBox;
import com.dtalankin.cars.Car;
import com.dtalankin.exceptions.ColorException;
import com.dtalankin.figures.Circle;
import com.dtalankin.figures.Cylinder;
import com.dtalankin.figures.Figure;
import com.dtalankin.figures.Point3D;
import com.dtalankin.figures.Rectangle;
import com.dtalankin.figures.Rectangle3D;
import com.dtalankin.figures.Triangle;
import org.junit.Test;

public class Lesson4 {
    final static float EPS = 0.00001f;

    @Test
    public void task426() {
        System.out.println("\n================================ Task #4.26");
        Color[] colors = Color.values();
        for(Color col : colors) {
            System.out.println(col);
        }
    }

    @Test
    public void task425() {
        System.out.println("\n================================ Task #4.25");
        Car car = null;
        try {
            car = new Car("toyota", 2000, 200, "GREEN");
        } catch (ColorException e) {
            e.printStackTrace();
        }
        car.print();
        Rectangle rect5 = null;
        try {
            rect5 = new Rectangle("BLUE");
        } catch (ColorException e) {
            e.printStackTrace();
        }
        rect5.print();
        Point3D p = null;
        try {
            p = new Point3D("RED");
        } catch (ColorException e) {
            e.printStackTrace();
        }
        p.print();
    }

    @Test
    public void task422() {
        System.out.println("\n================================ Task #4.22");
        PairBox<Rectangle3D, Cylinder> pb1 = new PairBox<>(new Rectangle3D(Color.RED), new Cylinder(6,5,4,3,Color.BLACK));
        PairBox<Rectangle, Circle> pb2 = new PairBox<>(new Rectangle(Color.RED), new Circle(3,4,3,Color.BLUE));
        PairBox<Triangle, Circle> pb3 = new PairBox<>(new Triangle(1,3,45,3,2,4,Color.BLUE), new Circle(3,4,3,Color.BLUE));
        PairBox<Triangle, Triangle> pb4 = new PairBox<>(new Triangle(1,3,45,3,2,4,Color.RED), new Triangle(1,3,45,3,2,4,Color.RED));
        System.out.println("площади равны : " + pb1.isSameSquare());
        System.out.println("площади равны : " + pb4.isSameSquare());
    }

    @Test
    public void task421() {
        System.out.println("\n================================ Task #4.21");
        PairBox<Rectangle3D, Cylinder> pb1 = new PairBox<>(new Rectangle3D(Color.RED), new Cylinder(6,5,4,3,Color.RED));
        PairBox<Rectangle, Circle> pb2 = new PairBox<>(new Rectangle(Color.RED), new Circle(3,4,3,Color.RED));
        PairBox<Triangle, Circle> pb3 = new PairBox<>(new Triangle(1,3,45,3,2,4,Color.RED), new Circle(3,4,3,Color.RED));
        //! PairBox<String, Circle> pb3 = new PairBox<>(new String("test"), new Circle(3,4,3,5));
    }

    @Test
    public void task420() {
        System.out.println("\n================================ Task #4.20");
        PairBox<Rectangle3D, Cylinder> pb1 = new PairBox<>(new Rectangle3D(Color.RED), new Cylinder(6,5,4,3,Color.RED));
        PairBox<Rectangle, Circle> pb2 = new PairBox<>(new Rectangle(Color.RED), new Circle(3,4,3,Color.RED));
        //! PairBox<String, Circle> pb3 = new PairBox<>(new String("test"), new Circle(3,4,3,5));
    }

    @Test
    public void task419() {
        System.out.println("\n================================ Task #4.19");
        PairBox<Rectangle3D, Cylinder> pb1 = new PairBox<>(new Rectangle3D(Color.RED), new Cylinder(6,5,4,3,Color.RED));
    }

    @Test
    public void task418() {
        System.out.println("\n================================ Task #4.18");
        NamedArrayBox<Rectangle3D> abN1 = new NamedArrayBox<>(new Rectangle3D[7], "Name1");
        NamedArrayBox<Rectangle> abN2 = new NamedArrayBox<>(new Rectangle[7], "Name2");
        //! NamedArrayBox<Circle> abN3 = new NamedArrayBox<>(new Circle[3], "Name2");
    }

    @Test
    public void task416() {
        System.out.println("\n================================ Task #4.16");
        ArrayBox<Rectangle3D> arrRect2 = new ArrayBox<>(new Rectangle3D[7]);
        ArrayBox<Rectangle> arrRect3 = new ArrayBox<>(new Rectangle[8]);
        //! ArrayBox<String> arrRect = new ArrayBox<>(new String[5]);
    }

    @Test
    public void task415() {
        System.out.println("\n================================ Task #4.15");
        ArrayBoxT<String> arrRect = new ArrayBoxT<>(new String[5]);
    }

    @Test
    public void task414() {
        System.out.println("\n================================ Task #4.14");
        ArrayBoxT<Rectangle3D> arrRect = new ArrayBoxT<>(new Rectangle3D[5]);
    }

    @Test
    public void task413() {
        System.out.println("\n================================ Task #4.13");
        ArrayBoxT<Rectangle> arrRect = new ArrayBoxT<>(new Rectangle[5]);
    }

    @Test
    public void task411() {
        System.out.println("\n================================ Task #4.11");
        Box<Rectangle> bRect6 = new Box<>(new Rectangle(Color.RED));
        Box<Rectangle> bRect7 = new Box<>(new Rectangle(7,4,Color.RED));
        Box<Rectangle3D> bRect3D8 = new Box<>(new Rectangle3D(Color.RED));
        Box<Circle> circ9 = new Box<>(new Circle(5,4,5,Color.RED));
        Box<Cylinder> cyl10 = new Box<>(new Cylinder(5,4,4,2,Color.RED));
        System.out.println("площади равны : " + isSameSquareStatic(circ9, bRect7));
    }

    @Test
    public void task49() {
        System.out.println("\n================================ Task #4.9");
        Box<Rectangle> bRect3 = new Box<>(new Rectangle(7,4,Color.RED));
        Box<Rectangle3D> bRect3D4 = new Box<>(new Rectangle3D(Color.RED));
        System.out.println("площади равны : " + bRect3D4.isSameSquare(bRect3));
    }

    @Test
    public void task48() {
        System.out.println("\n================================ Task #4.8");
        Box<Rectangle3D> bRect3D3 = new Box<>(new Rectangle3D(5,3,2,1,4,Color.RED));
        Box<Rectangle> bRect3 = new Box<>(new Rectangle(7,4,Color.RED));
        //! Box<Cylinder> cyl = new Box<>(new Cylinder(5,3,4,3,2));
        System.out.println(bRect3D3.square() + "   " + bRect3.square());
    }

    @Test
    public void task47() {
        System.out.println("\n================================ Task #4.7");
        Box<Rectangle3D> bRect3D3 = new Box<>(new Rectangle3D(5,3,2,1,4,Color.RED));
        Box<Rectangle> bRect3 = new Box<>(new Rectangle(7,4,Color.RED));
        //! Box<Cylinder> cyl = new Box<>(new Cylinder(5,3,4,3,2));
        System.out.println(bRect3D3.square() + "   " + bRect3.square());
    }

    @Test
    public void task45() {
        System.out.println("\n================================ Task #4.5");
        Box<Rectangle3D> bRect3D1 = new Box<>(new Rectangle3D(Color.RED));
        Box<Rectangle> bRect3D2 = new Box<>(new Rectangle(Color.RED));
    }

    @Test
    public void task44() {
        System.out.println("\n================================ Task #4.4");
        BoxT<String> str = new BoxT<>(new String("test"));
    }

    @Test
    public void task43() {
        System.out.println("\n================================ Task #4.3");
        BoxT<Rectangle3D> bRect3D = new BoxT<>(new Rectangle3D(Color.RED));
    }

    @Test
    public void task42() {
        System.out.println("\n================================ Task #4.2");
        BoxT<Rectangle> bRect = new BoxT<>(new Rectangle(Color.RED));
    }
    
    @Test
    public void lesson4() {
        System.out.println("\n================================ Lesson #4");
        // Интерфейсы

    }

    public static boolean isSameSquareStatic(Box<? extends Figure> obj1, Box<? extends Figure> obj2) {
        return Math.abs(obj1.square() - obj2.square()) <= EPS;
    }

}
