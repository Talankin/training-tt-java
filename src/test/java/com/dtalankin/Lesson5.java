/**
 *  15.09.2015
 *  Dmitry Talankin
 */

package com.dtalankin;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.util.Locale;

import com.dtalankin.cars.Car;
import com.dtalankin.exceptions.ColorException;
import com.dtalankin.exceptions.TraineeException;
import com.dtalankin.figures.Point3D;
import com.dtalankin.figures.Rectangle;
import com.dtalankin.trainees.Trainee;
import org.junit.Test;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class Lesson5 {

    @Test
    public void task524() {
        System.out.println("\n================================ Task #5.24");
        try {
            WatchDir.watchService = FileSystems.getDefault().newWatchService();
            FileSystems.getDefault().getPath("D:\\@\\test\\").
                    register(WatchDir.watchService, ENTRY_MODIFY, ENTRY_CREATE, ENTRY_DELETE);
            WatchDir.watchFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task523() {
        System.out.println("\n================================ Task #5.23");
        File dir = new File("D:\\@\\test\\");
        FilenameFilter filtr = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String lCaseName = name.toLowerCase();
                if (lCaseName.endsWith(".dat"))
                    return true;
                else
                    return false;
            }
        };

        for (File file : dir.listFiles(filtr)) {
            String pathFileWithOutExt = file.getPath().toLowerCase().replaceFirst(".dat", ".bin");
            File fileDest = new File(pathFileWithOutExt);
            file.renameTo(fileDest);
        }
    }

    @Test
    public void task521() {
        System.out.println("\n================================ Task #5.21");
        byte[] byteArr = null;
//        int size = 1000; // можно задать размер явно, чтобы не было переалокации при увеличении массива

        Trainee trainee21 = null;
        try {
            trainee21 = new Trainee("Silvester", "Stalone", 5);
            System.out.println(trainee21.toString());
        } catch (TraineeException e) {
            System.out.println(e.getMessage());
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(trainee21);
            byteArr = baos.toByteArray();

            ByteBuffer buffer = ByteBuffer.allocate(byteArr.length);
            buffer.put(byteArr);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void task520() {
        System.out.println("\n================================ Task #5.20");

        int size = 100;

        try (FileChannel channel = new RandomAccessFile(new File("trainee20.dat"),"rw").getChannel()) {
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE,0,size*Integer.BYTES);

            for (int i=0; i<size; i++) {
                buffer.putInt(i);
            }
            System.out.println("size = " + channel.size() + " position = " + buffer.position());

            int a = buffer.getInt(99*4);
            System.out.println(a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void task519() {
        System.out.println("\n================================ Task #5.19");

        int size = 15;

        try (FileChannel channel = new RandomAccessFile(new File("trainee2.txt"),"rw").getChannel()) {
            //в этом месте происходит расширение памяти, поэтому сколько задано size столько занесется в память через файл
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE,0,size);
            byte b = buffer.get();
            System.out.println("size = " + channel.size() + " position = " + buffer.position());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void task518() { //record28
        System.out.println("\n================================ Task #5.18");

        int size = 50;

        try (FileChannel channel = new FileInputStream(new File("trainee2.txt")).getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(size);
            channel.read(buffer);
            System.out.println("size = " + channel.size() + " position = " + buffer.position());
            buffer.position(0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void task517() { //record24
        System.out.println("\n================================ Task #5.17");
        byte[] byteArr = null;
        int size = 10;

        Trainee trainee5 = null;
        try {
            trainee5 = new Trainee("Silvester", "Stalone", 4);
            System.out.println(trainee5.toString());
        } catch (TraineeException e) {
            System.out.println(e.getMessage());
        }

        //взять массив байтов и поработать с ним
        ByteArrayOutputStream baos = new ByteArrayOutputStream(size);
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(trainee5);
            byteArr = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream bais = new ByteArrayInputStream(byteArr);
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
            Trainee trainee6 = (Trainee)ois.readObject();
            System.out.println(trainee6.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task516() {
        System.out.println("\n================================ Task #5.16");
        //разнести исключения по разным уровням во всех последних тасках
        Trainee trainee3 = null;
        try {
            trainee3 = new Trainee("Arnold", "Schwarzenegger", 5);
            System.out.println(trainee3.toString());
        } catch (TraineeException e) {
            System.out.println(e.getMessage());
        }

        try (ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream("trainee3.dat"))) {
            objOutputStream.writeObject(trainee3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("trainee3.dat"))) {
            Trainee trainee4 =  (Trainee)objectInputStream.readObject();
            System.out.println(trainee4.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void task515() {
        System.out.println("\n================================ Task #5.15");

        String[] arrayStr = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("trainee2.txt"))) {
            arrayStr = bufferedReader.readLine().split(" ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Trainee trainee1 = new Trainee(arrayStr[0],
                    arrayStr[1],
                    Integer.parseInt(arrayStr[2]));
            System.out.println(trainee1.toString());
        } catch (TraineeException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void task514() {
        System.out.println("\n================================ Task #5.14");

        Trainee trainee = null;
        try {
            trainee = new Trainee("Bob", "Dylan", 4);
        } catch (TraineeException e) {
            System.out.println(e.getMessage());
        }

        try (PrintStream printStream1 = new PrintStream(new File("trainee2.txt"))){
            printStream1.println(trainee.getFirstName()
                    + " " + trainee.getLastName()
                    + " " + trainee.getRating());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task513() {
        System.out.println("\n================================ Task #5.13");

        String firstName = "";
        String lastName = "";
        int rating = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("trainee1.txt"))) {
            firstName = bufferedReader.readLine();
            lastName = bufferedReader.readLine();
            rating = Integer.parseInt(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Trainee trainee1 = new Trainee(firstName, lastName, rating);
            System.out.println(trainee1.toString());
        } catch (TraineeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void task512() {
        System.out.println("\n================================ Task #5.12");

        Trainee trainee = null;
        try {
            trainee = new Trainee("Dmitry", "Talankin", 5);
        } catch (TraineeException e) {
            System.out.println(e.getMessage());
        }

        try (PrintStream printStream1 = new PrintStream(new File("trainee1.txt"))){
            printStream1.println(trainee.getFirstName()
                    + "\n" + trainee.getLastName()
                    + "\n" + trainee.getRating());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task511() {
        System.out.println("\n================================ Task #5.11");
        Rectangle rectangle4 = new Rectangle(1,3,5,7,Color.WHITE);

        try (PrintStream printStream = new PrintStream(new File("ps.txt"),"UTF-8")) {
            printStream.println("вывожу прямоугольник в файл: ");
            printStream.print(rectangle4);
            double d = 5.763491;
            printStream.println();
            printStream.printf("%f\n", d);
            printStream.printf(Locale.ENGLISH, "%f\n", d);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void task510() {
        System.out.println("\n================================ Task #5.10");
        Rectangle[] arrayRect = new Rectangle[5];
        arrayRect[0] = new Rectangle(1,2,3,4,Color.BLUE);
        arrayRect[0].print();
        System.out.println(Color.BLUE.ordinal());
        arrayRect[1] = new Rectangle(2,4,6,8,Color.WHITE);
        arrayRect[1].print();
        System.out.println(Color.WHITE.ordinal());
        arrayRect[2] = new Rectangle(11,22,33,44,Color.BLACK);
        arrayRect[2].print();
        System.out.println(Color.BLACK.ordinal());
        arrayRect[3] = new Rectangle(1,2,44,55,Color.YELLOW);
        arrayRect[3].print();
        System.out.println(Color.YELLOW.ordinal());
        arrayRect[4] = new Rectangle(1,2,22,40,Color.GREEN);
        arrayRect[4].print();
        System.out.println(Color.GREEN.ordinal());


        try (DataOutputStream dataOutputStream = new DataOutputStream (new FileOutputStream("rectangles.dat"))) {

            for (Rectangle rect : arrayRect) {
                dataOutputStream.writeInt(rect.getX1());
                dataOutputStream.writeInt(rect.getY1());
                dataOutputStream.writeInt(rect.getX2());
                dataOutputStream.writeInt(rect.getY2());
                dataOutputStream.writeInt(rect.getColor().ordinal());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(new File("rectangles.dat"), "rw")) {

            for (int i = 0; i < 5; i++) {
                randomAccessFile.seek((arrayRect.length - i - 1) * 5 * Integer.BYTES);
                System.out.println(randomAccessFile.readInt() + "  " +
                        randomAccessFile.readInt() + "  " +
                        randomAccessFile.readInt() + "  " +
                        randomAccessFile.readInt() + "  " +
                        randomAccessFile.readInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void task508and509() {
        System.out.println("\n================================ Task #5.08-5.09");
        Rectangle rectangle = new Rectangle(1,2,Color.BLUE);
        rectangle.print();

        try (ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream("rectangle.dat"))) {
            objOutputStream.writeObject(rectangle);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Rectangle rectangle1 = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("rectangle.dat"))) {
            rectangle1 = (Rectangle)objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        rectangle1.print();
    }

    @Test
    public void task507() {
        System.out.println("\n================================ Task #5.07");
        // dirs
        File dir1 = new File("D:\\Temp\\01");
        dir1.mkdir();

        File dir2 = new File("D:\\Temp\\02\\03");
        dir2.mkdirs();
        dir2.delete();

        File dir3 = new File("D:\\Temp\\04");
        dir1.renameTo(dir3);

        System.out.println("full name : " + dir1.getAbsolutePath());
        System.out.println("dir exists : " + dir1.exists());
        if (dir1.exists()) {
            System.out.println("is dir : " + dir1.isDirectory());
        } else {
            System.out.println("невозможно определить файл это или директория " + dir1.getAbsolutePath());
        }

        // files
        File dir4 = new File("D:\\Temp\\files");
        dir4.mkdirs();

        File file1 = new File(dir4, "file1.txt");
        File file2 = new File(dir4, "file2.txt");
        try {
            file1.createNewFile();
            System.out.println("file created : " + file1.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }
        file1.renameTo(file2);
        System.out.println("file renamed : " + file2.exists());
        if (file2.exists()) {
            System.out.println("is file : " + file2.isFile());
        } else {
            System.out.println("невозможно определить файл это или директория " + file2.getAbsolutePath());
        }

        System.out.println("full name : " + file2.getAbsolutePath());

        file2.delete();
        System.out.println("file not deleted : " + file2.exists());

        // list of files
        File dir5 = new File("C:\\windows");
        System.out.println("list of files in " + dir5.getAbsolutePath());

        FilenameFilter filtr = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String lCaseName = name.toLowerCase();
                if (lCaseName.startsWith("m") && lCaseName.endsWith(".txt"))
                    return true;
                else
                    return false;
            }
        };
        for (File file : dir5.listFiles(filtr)) {
            System.out.println(file.getName());
        }
    }

    @Test
    public void task506() {
        System.out.println("\n================================ Task #5.06");
        Trainee tr = null;
        Trainee tr1 = null;
        Trainee tr2 = null;
        Trainee tr3 = null;

        try {
            tr = new Trainee("Dmitry", "Talankin", 5);
            System.out.println(tr);
            tr1 = new Trainee("Ivan", "Ivanov", 1);
            System.out.println(tr1);
            tr2 = new Trainee("Sidor", "Sidorov", 2);
            System.out.println(tr2);
            tr3 = new Trainee("Vasily", null, 2);
            System.out.println(tr3);
        } catch (TraineeException e) {
            System.out.println(e.getMessage());
        }

        try {
            tr2.setRating(3);
            tr1.setFirstName("Van");
            tr1.setLastName(null);

        } catch (TraineeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(tr2);
        System.out.println(tr1);

    }

    @Test
    public void task501() {
        System.out.println("\n================================ Task #5.01");
        Car car23 = null;
        try {
            car23 = new Car("toyota", 2000, 200, "GREE");
        } catch (ColorException e) {
            System.out.println("Выбранный вами цвет отсутствует в системе. Создан объект с цветом WHITE");
            car23 = new Car("toyota", 2000, 200);
        }
        car23.print();

        Rectangle rect6 = null;
        try {
            rect6 = new Rectangle("BLU");
        } catch (ColorException e) {
            System.out.println("Выбранный вами цвет отсутствует в системе. Создан объект с цветом WHITE");
            rect6 = new Rectangle(Color.WHITE);
        }
        rect6.print();

        Point3D p1 = null;
        try {
            p1 = new Point3D("RE");
        } catch (ColorException e) {
            System.out.println("Выбранный вами цвет отсутствует в системе. Создан объект с цветом WHITE");
            p1 = new Point3D(Color.WHITE);
        }
        p1.print();

    }


    @Test
    public void lesson5() {
        System.out.println("\n================================ Lesson #5");
        // Исключения
        try {
            DemoException.f(0);

        }
        catch (ArithmeticException ex) {
            ex.printStackTrace();

        }
        System.out.println("Тут программа продолжила свою работу");

    }


}
