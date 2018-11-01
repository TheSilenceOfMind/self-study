package util.concurrent.syncObjects;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        int num = 10;
        CountDownLatch cdl = new CountDownLatch(num);

        System.out.println("Starting.");

        new MyThread(cdl, num);
        try {
            cdl.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            System.out.println("Done");
        }
    }

}

class MyThread implements Runnable {
    CountDownLatch cdl;
    int num;

    public MyThread(CountDownLatch cdl, int num) {
        this.cdl = cdl;
        this.num = num;
        new Thread(this).start();
    }

    public void run() {
        for (int i = 0; i < num; i++) {
            System.out.println(i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cdl.countDown();
        }
    }
}
