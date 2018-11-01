package util.concurrent.syncObjects;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        new IncThread(sem, "Incrementator");
        new DecThread(sem, "Decrementator");
    }
}

class Shared {
    static int count = 0;
}

class IncThread implements Runnable {
    String name;
    Semaphore sem;

    IncThread(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);

        try {
            System.out.println(name + " is waiting for permit.");
            sem.acquire();
            System.out.println(name + " gets a permit.");

            // Now, access shared resource.
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                // Now, allow a context switch -- if possible.
                Thread.sleep(300);
            }

        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(name + " release the permit.");
        sem.release();
    }
}

class DecThread implements Runnable {
    String name;
    Semaphore sem;

    DecThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Starting " + name);

        try {
        // First, get a permit.
            System.out.println(name + " is waiting for a permit.");
            sem.acquire();
            System.out.println(name + " gets a permit.");

            // Now, access shared resource.
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);
                // Now, allow a context switch -- if possible.
                Thread.sleep(300);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        // Release the permit.
        System.out.println(name + " releases the permit.");
        sem.release();
    }
}