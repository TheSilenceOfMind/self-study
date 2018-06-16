package collections.set.concurrent;

import java.util.*;
import java.util.concurrent.*;

/**
 * Just for deeper understanding how COWArraySet works.
 * If you replace {@code cowSet} realization from COWArraySet to some General implementation (e.g. HashSet),
 * you'll get ConcurrentModificationException.
 *
 */
public class CopyOnWriteArraySetExample {

    public static void main(String[] args) {
        Set<Integer> set = new CopyOnWriteArraySet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        new WriteThread("Writer", set).start();
        new ReadThread("Reader", set).start();
    }

    private static class WriteThread extends Thread {

        private Set<Integer> set;

        public WriteThread(String name, Set<Integer> set) {
            this.set = set;
            super.setName(name);
        }

        public void run() {
            int count = 6;
            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                set.add(count++);
                System.out.println(super.getName() + " done");
            }
        }
    }


    private static class ReadThread extends Thread {

        private Set<Integer> set;

        ReadThread(String name, Set<Integer> set) {
            this.set = set;
            super.setName(name);
        }

        public void run() {
            while (true) {
                String output = "\n" + super.getName() + ":";
                Iterator<Integer> iterator = set.iterator();
                while (iterator.hasNext()) {
                    Integer next = iterator.next();
                    output += " " + next;
                    // fake processing time
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println(output);
            }
        }
    }

}

