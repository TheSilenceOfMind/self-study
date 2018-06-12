package concurrency.exercises;

/**
 * This simple class is used to demonstrate using {@code wait()} and {@code notify()} mechanism
 * instead of using inefficient polling. The program counts to 100 and prints the result to {@code stdout}.
 * Particularly all members are {@code static} just to simplify the example.
 */
public class GuardedBlocks {

    private static MyOwnNumber numberClass = new MyOwnNumber(0);

    static final class MyOwnNumber {
        // number from which is incremented
        int num;
        // flag to identify if counting is done, set up by method countToSpecifiedDigit(int)
        boolean isCountedAlready;

        MyOwnNumber(int initValue) {
            this.num = initValue;
        }

        public synchronized void inc() {
            num++;
        }

        public synchronized void countToSpecifiedDigit(int toDigit) {
            while (isCountedAlready) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            System.out.println("I'm starting counting!");
            for (int i = 0; i < toDigit; i++) {
                inc();
            }
            System.out.println("I've done counting!");
            isCountedAlready = true;
            notify();
        }

        public synchronized void printCountedNumber() {
            while (!isCountedAlready) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            System.out.println("The current number equals to " + num);
        }
    }

    static final class CountThread implements Runnable {
        @Override
        public void run() {
            numberClass.countToSpecifiedDigit(100);
        }
    }

    static final class PrintThread implements Runnable {
        @Override
        public void run() {
            numberClass.printCountedNumber();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread printThread = new Thread(new PrintThread());
        Thread countThread = new Thread(new CountThread());
        printThread.start();
        countThread.start();
        printThread.join();
        countThread.join();
        System.out.println("main: all done!");
    }
}
