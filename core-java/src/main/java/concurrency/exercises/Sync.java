package concurrency.exercises;

public class Sync {

    private static Integer i = 0;

    private static synchronized void incI() {
        i++;
    }

    private static final class MyThread implements Runnable {
        @Override
        public void run() {
            for (int j = 0; j < 1_000_000; j++) {
                incI();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyThread());
        t1.start();
        Thread t2 = new Thread(new MyThread());
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
