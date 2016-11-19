/**
 *  15.09.2015
 *  Dmitry Talankin
 */

package com.dtalankin;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import com.dtalankin.exceptions.TraineeException;
import com.dtalankin.trainees.Group;
import com.dtalankin.trainees.Trainee;
import org.junit.Test;

public class Lesson7 {

    @Test
    public void task723() {
        System.out.println("\n================================ Task #7.23");
        int hashSize = 6;
        int setSize = 5;
        int diff = 0;
//взять другой сет

        Set<BitSet> hashSet = new HashSet<>();

        for(int i=0; i<hashSize; i++) {
            BitSet bitSet = bitSetFactory(setSize);

            if (hashSet.add(bitSet) && i > 0) {
                diff += hashSet.size()-1;
            }
        }

        for(BitSet bs : hashSet) {
            System.out.println(bs);
        }
        System.out.println("размер hashSet = " + hashSet.size() + "  количество множеств = " + diff);
    }

    private BitSet bitSetFactory(int setSize) {
        BitSet bitSet = new BitSet();

        do {
            bitSet.set((int)(Math.random()*10));
        } while (bitSet.cardinality() < setSize);
        return bitSet;
    }


    @Test
    public void task722() {
        System.out.println("\n================================ Task #7.22");
        System.out.println("   enumSetAll");
        EnumSet<Color> enumSetAll = EnumSet.allOf(Color.class);
        for (Color c : enumSetAll) {
            System.out.println(c);
            if (c.equals(Color.YELLOW)) {
                System.out.println("Color YELLOW exists");
            }
        }

        System.out.println("  enumSetOne");
        EnumSet<Color> enumSetOne = EnumSet.of(Color.YELLOW);
        for (Color c : enumSetOne) {
            System.out.println(c);
            if (c.equals(Color.YELLOW)) {
                System.out.println("Color YELLOW exists");
            }
        }

        System.out.println("  enumSetRange");
        EnumSet<Color> enumSetRange = EnumSet.range(Color.BLUE, Color.BLACK);
        for (Color c : enumSetRange) {
            System.out.println(c);
            if (c.equals(Color.RED)) {
                System.out.println("Color RED exists");
            }
        }

        System.out.println("  enumSetEmpty");
        EnumSet<Color> enumSetEmpty = EnumSet.noneOf(Color.class);
        for (Color c : enumSetEmpty) {
            System.out.println(c);
            if (c.equals(Color.RED)) {
                System.out.println("Color RED exists");
            }
        }
    }

    @Test
    public void task721() {
        System.out.println("\n================================ Task #7.21");
        BitSet bitSet = new BitSet();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        // BitSet
        long timeStart1 = System.currentTimeMillis();
        bitSet.set(0, 1000000);
        long timeEnd1 = System.currentTimeMillis() - timeStart1;

        // HashSet
        long timeStart2 = System.currentTimeMillis();
        for(int i=0; i<1000000; i++) {
            hashSet.add(i);
        }
        long timeEnd2 = System.currentTimeMillis() - timeStart2;

        // TreeSet
        long timeStart3 = System.currentTimeMillis();
        for(int i=0; i<1000000; i++) {
            treeSet.add(i);
        }
        long timeEnd3 = System.currentTimeMillis() - timeStart3;

        //TimeUnit.MILLISECONDS.toSeconds()

        System.out.println("BitSet = " + timeEnd1 + "   HashSet = " + timeEnd2 + "   TreeSet = " + timeEnd3);
    }

    @Test
    public void task720() {
        System.out.println("\n================================ Task #7.20");
        BitSet bitSet = new BitSet();
        bitSet.set(50);
        bitSet.set(90);
        System.out.println("Set has value 50 : " + bitSet.get(50));
        System.out.println("Set has value 90 : " + bitSet.get(90));
        System.out.println("Length = " + bitSet.length());
        System.out.println("Cardinality = " + bitSet.cardinality());
        bitSet.clear(90);
        System.out.println("Set has value 50 : " + bitSet.get(50));
        System.out.println("Set has value 90 : " + bitSet.get(90));
        System.out.println("Length = " + bitSet.length());
        System.out.println("Cardinality = " + bitSet.cardinality());

    }

    @Test
    public void task719() {
        System.out.println("\n================================ Task #7.19");
        SortedMap<Trainee, String> map = new TreeMap<>((t1, t2) -> t1.getFirstName().compareTo(t2.getFirstName()));
        try {
            map.put(new Trainee("Jeckie", "Chan", 4), "SibADI");
            map.put(new Trainee("Silvester", "Stalone", 3), "PED");
            map.put(new Trainee("Chack", "Norris", 1), "SibADI");

            //poluchit institute po klychy
            System.out.println("    get institute by traniee");
            System.out.println(map.get(new Trainee("Jeckie", "Ly", 4)));
            //poluchit tolko kluchi
            System.out.println("    print all traniees");
            for(Trainee tr : map.keySet()) {
                System.out.println(tr);
            }
            //set iz par mepa
            System.out.println("    print all pairs");
            for(Object o : map.entrySet()) {
                System.out.println(o);
            }
        } catch (TraineeException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void task718() {
        System.out.println("\n================================ Task #7.18");
//        SortedMap<Trainee, String> map = new TreeMap<>();
        SortedMap<Trainee, String> map = new TreeMap<>((t1,t2) -> t1.getLastName().compareTo(t2.getLastName()));
        try {
            map.put(new Trainee("Jeckie", "Chan", 4), "SibADI");
            map.put(new Trainee("Vladimir", "Putin", 4), "OMGU");
            map.put(new Trainee("Dmitry", "Medvedev", 2), "OMTU");
            map.put(new Trainee("Silvester", "Stalone", 3), "PED");
            map.put(new Trainee("Chack", "Norris", 1), "SibADI");
            map.put(new Trainee("Dmitry", "Talankin", 4), "SibADI");

            //poluchit institute po klychy
            System.out.println("    get institute by traniee");
            System.out.println(map.get(new Trainee("Dmitry", "Talankin", 4)));
            System.out.println(map.get(new Trainee("Vladimir", "Putin", 4)));
            System.out.println(map.get(new Trainee("Vladimir", "Korzh", 1)));
            //poluchit tolko kluchi
            System.out.println("    print all traniees");
            for(Trainee tr : map.keySet()) {
                System.out.println(tr);
            }
            //set iz par mepa
            System.out.println("    print all pairs");
            for(Object o : map.entrySet()) {
                System.out.println(o);
            }

        } catch (TraineeException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void task717() {
        System.out.println("\n================================ Task #7.17");
        Map<Trainee, String> map = new HashMap<>();
        try {
            map.put(new Trainee("Jeckie", "Chan", 4), "SibADI");
            map.put(new Trainee("Vladimir", "Putin", 4), "OMGU");
            map.put(new Trainee("Dmitry", "Medvedev", 2), "OMTU");

            //poluchit institute po klychy
            System.out.println("    get institute by traniee");
            System.out.println(map.get(new Trainee("Jeckie", "Chan", 4)));

            //poluchit tolko kluchi
            System.out.println("    print all traniees");
            for(Trainee tr : map.keySet()) {
                System.out.println(tr);
            }

            map.put(new Trainee("Dmitry", "Medvedev", 2), "OMPED");
            System.out.println("    some tests");
            //set iz par mepa
            for(Object o : map.entrySet()) {
                System.out.println(o);
            }
            //poluchit tolko znacheniya
            for(String v : map.values()) {
                System.out.println(v);
            }

        } catch (TraineeException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void task716() {
        System.out.println("\n================================ Task #7.16");

        // ArrayList .............................
        List<Integer> listInt = new ArrayList<>();
        for(int i=0; i<100000; i++) {
            listInt.add((int)(Math.random()*100000));
        }

        long timeStart1 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        for (int i=0; i<10000; i++) {
            System.out.println(listInt.get(listInt.indexOf(52510)));
        }
        long timeEnd1 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - timeStart1;

        // HashSet .............................
        Set<Integer> hashSet = new HashSet<>();
        for(int i=0; i<100000; i++) {
            hashSet.add((int)(Math.random()*100000));
        }

        long timeStart2 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        for (int i=0; i<10000; i++) {
            for(int v : hashSet) {
                if (v == 52510) {
                    System.out.println(v);
                    break;
                }
            }
        }
        long timeEnd2 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - timeStart2;

        // TreeSet .............................
        Set<Integer> treeSet = new TreeSet<>();
        for(int i=0; i<100000; i++) {
            treeSet.add((int)(Math.random()*100000));
        }

        long timeStart3 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        for (int i=0; i<10000; i++) {
            for(int v : treeSet) {
                if (v == 52510) {
                    System.out.println(v);
                    break;
                }
            }
        }
        long timeEnd3 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - timeStart3;
        System.out.println("arraylist = " + timeEnd1 + "   HashSet = " + timeEnd2 + "   TreeSet = " + timeEnd3);
    }

    @Test
    public void task715() {
        System.out.println("\n================================ Task #7.15");
        Set<Trainee> set = new TreeSet<>((t1,t2) -> t1.getFirstName().compareTo(t2.getFirstName()));
        try {
            set.add(new Trainee("Jeckie", "Chan", 4));
            set.add(new Trainee("Vladimir", "Putin", 4));
            set.add(new Trainee("Dmitry", "Medvedev", 2));

            Trainee jeckie = new Trainee("Dmitry", "Talankin", 5);
            System.out.println("set содержит trainee : " + set.contains(jeckie));
            for(Trainee tr : set) {
                if(tr.equals(jeckie)) {
                    System.out.println(tr);
                    break;
                }
            }
        } catch (TraineeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task714() {
        System.out.println("\n================================ Task #7.14");
        Set<Trainee> set = new TreeSet<>();
        try {
            set.add(new Trainee("Jeckie", "Chan", 4));
            set.add(new Trainee("Vladimir", "Putin", 4));
            set.add(new Trainee("Dmitry", "Medvedev", 2));

            Trainee jeckie = new Trainee("Jeckie", "Chan", 4);
            Trainee andrey = new Trainee("Andrey", "Makarevich", 5);
            System.out.println("set содержит trainee : " + set.contains(jeckie));
            for(Trainee tr : set) {
                if(tr.equals(jeckie)) {
                    System.out.println(tr);
                    break;
                }
            }
        } catch (TraineeException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void task713() {
        System.out.println("\n================================ Task #7.13");
        Set<Trainee> set = new HashSet<>();
        try {
            set.add(new Trainee("Jeckie", "Chan", 4));
            set.add(new Trainee("Vladimir", "Putin", 4));
            set.add(new Trainee("Dmitry", "Medvedev", 2));

            Trainee jeckie = new Trainee("Jeckie", "Chan", 4);
            Trainee andrey = new Trainee("Andrey", "Makarevich", 5);
            System.out.println("set содержит trainee : " + set.contains(jeckie));
            for(Trainee tr : set) {
                if(tr.equals(jeckie)) {
                    System.out.println(tr);
                    break;
                }
            }
        } catch (TraineeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task712() {
        System.out.println("\n================================ Task #7.12");
        Queue<Trainee> queue = new PriorityQueue<Trainee>((t1, t2) -> t1.getRating().compareTo(t2.getRating()));

        try {
            queue.add(new Trainee("Jeky", "Chan", 4));
            queue.add(new Trainee("Silvester", "Stalone", 3));
            queue.add(new Trainee("Chack", "Norris", 1));
            queue.add(new Trainee("Dmitry", "Talankin", 4));
            queue.add(new Trainee("Vladimir", "Putin", 4));
            queue.add(new Trainee("Dmitry", "Medvedev", 2));

            while(!queue.isEmpty()) {
                System.out.println(queue.poll());
            }

            System.out.println("очередь пуста : " + queue.isEmpty());
        } catch (TraineeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task711() {
        System.out.println("\n================================ Task #7.11");
        int n = 99999;
        List<Integer> listInt = new ArrayList<>();
        for (int i=0; i<n; i++){
            listInt.add(i);
        }
        long timeStart1 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        for (int i=0; i<n; i++){
            System.out.println(listInt.get((int)(Math.random()*(n))));
        }
        long timeEnd1 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - timeStart1;

        listInt.clear();

        listInt = new LinkedList<>();
        for (int i=0; i<n; i++){
            listInt.add(i);
        }
        long timeStart2 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        for (int i=0; i<n; i++){
            System.out.println(listInt.get((int)(Math.random()*(n))));
        }
        long timeEnd2 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - timeStart2;

        System.out.println("arraylist = " + timeEnd1 + "   linkedlist = " + timeEnd2);
    }

    @Test
    public void task710() {
        System.out.println("\n================================ Task #7.10");
        List<Trainee> trainees = new ArrayList<>();
//        List<Trainee> trainees = new LinkedList<>();

        try {
            trainees.add(new Trainee("Jeky", "Chan", 4));
            trainees.add(new Trainee("Silvester", "Stalone", 3));
            trainees.add(new Trainee("Chack", "Norris", 1));
            trainees.add(new Trainee("Dmitry", "Talankin", 4));
            trainees.add(new Trainee("Vladimir", "Putin", 4));
            trainees.add(new Trainee("Dmitry", "Medvedev", 2));

            for(Trainee trainee : trainees) {
                System.out.println(trainee);
            }
            //1
            Collections.reverse(trainees);
            System.out.println("1 ***** after reverse *****");
            for(Trainee trainee : trainees) {
                System.out.println(trainee);
            }
            //2
            System.out.println("2 ***** after shifting in 2 positions to right *****");
            trainees.add(null);
            trainees.add(null);
            int size = trainees.size();
            int shift=2;
            for(int i=size-1; i>=0; i--) {
                if(i<shift) {
                    trainees.set(i, null);
                } else {
                    trainees.set(i, trainees.get(i - shift));
                }
            }
            for(Trainee trainee : trainees) {
                System.out.println(trainee);
            }
            //3
            System.out.println("3 ***** randomly permutes *****");
            Collections.shuffle(trainees);
            for(Trainee trainee : trainees) {
                System.out.println(trainee);
            }
            //4
            System.out.println("4 ***** find out max(rating) *****");
            trainees.remove(null);
            trainees.remove(null);
            int maxRating = Collections.max(trainees, ((t1, t2) -> t1.getRating().compareTo(t2.getRating()))).getRating();
            for(Trainee trainee : trainees) {
                if(trainee.getRating() == maxRating) {
                    System.out.println(trainee);
                }
            }
            //5
            System.out.println("5 ***** sort by raiting *****");
            trainees.sort((t1, t2) -> -t1.getRating().compareTo(t2.getRating()));
            for(Trainee trainee : trainees) {
                System.out.println(trainee);
            }
            //6
            System.out.println("6 ***** sort by first name *****");
            trainees.sort((t1, t2) -> t1.getFirstName().compareTo(t2.getFirstName()));
            for(Trainee trainee : trainees) {
                System.out.println(trainee);
            }
            //7
            System.out.println("7 ***** find out by name *****");
            trainees.sort((t1, t2) -> t1.getFirstName().compareTo(t2.getFirstName()));
            for(Trainee trainee : trainees) {
                if(trainee.getFirstName().equals("Dmitry")) {
                    System.out.println(trainee);
                }
            }

        } catch (TraineeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task709() {
        System.out.println("\n================================ Task #7.09");
        List<Trainee> trainees = new ArrayList<>();
        try {
            trainees.add(new Trainee("Jeky", "Chan", 4));
            trainees.add(new Trainee("Silvester", "Stalone", 5));
            trainees.add(new Trainee("Chack", "Norris", 3));
            trainees.add(new Trainee("Dmitry", "Talankin", 4));
            Group group = new Group("Main", trainees);

            for(Trainee trainee : group.getTrainees()) {
                if(trainee.getFirstName().equals("Jeky")) {
                    System.out.println(trainee);
                }
            }

        } catch (TraineeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task707() {
        System.out.println("\n================================ Task #7.07");
        List<Trainee> trainees = new LinkedList<>();
        try {
            trainees.add(new Trainee("Jeky", "Chan", 4));
            trainees.add(new Trainee("Silvester", "Stalone", 5));
            trainees.add(new Trainee("Chack", "Norris", 3));
            trainees.add(new Trainee("Dmitry", "Talankin", 5));
            Group group = new Group("Main", trainees);
            group.getTrainees().sort((Trainee o1, Trainee o2) -> o1.getFirstName().compareTo(o2.getFirstName()));

            for(Trainee trainee : group.getTrainees()) {
                System.out.println(trainee);
            }

        } catch (TraineeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void task706() {
        System.out.println("\n================================ Task #7.06");
        List<Trainee> trainees = new LinkedList<>();
        try {
            trainees.add(new Trainee("Jeky", "Chan", 4));
            trainees.add(new Trainee("Silvester", "Stalone", 5));
            trainees.add(new Trainee("Chack", "Norris", 3));
            trainees.add(new Trainee("Dmitry", "Talankin", 4));
            Group group = new Group("Main", trainees);
            //1 way
            System.out.println("***** 1 way *****");
            group.getTrainees().sort(new Comparator<Trainee>() {
                @Override
                public int compare(Trainee o1, Trainee o2) {
                    return -o1.getRating().compareTo(o2.getRating());
                }
            });
            for(Trainee trainee : group.getTrainees()) {
                System.out.println(trainee);
            }

            //2 way
            System.out.println("***** 2 way *****");
            group.getTrainees().sort((Trainee o1, Trainee o2) -> o1.getRating().compareTo(o2.getRating()));

            for(Trainee trainee : group.getTrainees()) {
                System.out.println(trainee);
            }

            //3 way
            System.out.println("***** 3 way *****");
            Collections.sort(group.getTrainees(),(Trainee o1, Trainee o2) -> -o1.getRating().compareTo(o2.getRating()));

            for(Trainee trainee : group.getTrainees()) {
                System.out.println(trainee);
            }

        } catch (TraineeException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void task7061() {
        System.out.println("\n================================ Task #7.061");
        //ниже просто тренировался
        //последний стажер не добавлен, т.к. имеет оценку, которая уже существует в наборе set
        SortedSet<Trainee> comparableTrainees = new TreeSet<Trainee>(new Comparator<Trainee>() {
            @Override
            public int compare(Trainee o1, Trainee o2) {
                return o1.getRating().compareTo(o2.getRating());
            }
        });

        try {
            Trainee t1 = new Trainee("Jeky", "Chan", 4);
            Trainee t2 = new Trainee("Silvester", "Stalone", 5);
            Trainee t3 = new Trainee("Chack", "Norris", 3);
            Trainee t4 = new Trainee("Dmitry", "Talankin", 4);
            System.out.println(comparableTrainees.add(t1));
            System.out.println(comparableTrainees.add(t2));
            System.out.println(comparableTrainees.add(t3));
            System.out.println(comparableTrainees.add(t4));
//            Group group = new Group("Main", comparableTrainees);
//            for(Trainee trainee : (SortedSet<Trainee>)group.getTrainees()) {
//                System.out.println(trainee);
//            }

        } catch (TraineeException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void task705() {
        System.out.println("\n================================ Task #7.05");
        try {
            Trainee t1 = new Trainee("Silvester", "Stalone", 5);
            Trainee t2 = new Trainee("Jeky", "Chan", 4);
            Trainee[] trainees = new Trainee[2];
            trainees[0] = t1;
            trainees[1] = t2;

            Trainee[] traineesNull1 = new Trainee[0];
//            Group g1 = new Group("Maths", trainees);
//!            Group g2 = new Group("Maths", traineesNull1);
//!            Group g2 = new Group("", trainees);
        } catch (TraineeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void task704() {
        System.out.println("\n================================ Task #7.04");
        try {
            Trainee t1 = new Trainee("Silvester", "Stalone", 5);
            System.out.println(t1.toString());
//!            Trainee t1 = new Trainee("", "Stalone", 5);
//!            Trainee t1 = new Trainee("Silvester", null, 5);
//!            Trainee t1 = new Trainee("Silvester", "Stalone", 6);
        } catch (TraineeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void task701() {
        System.out.println("\n================================ Task #7.01");
        try {
            Trainee t1 = new Trainee("Silvester", "Stalone", 5);
            Trainee t2 = new Trainee("Jeky Chan", "Stalone", 4);
            System.out.println(t2.getFirstName().compareTo(t1.getFirstName()));
        } catch (TraineeException e) {
            System.out.println(e.getMessage());
        }

    }
    


}
