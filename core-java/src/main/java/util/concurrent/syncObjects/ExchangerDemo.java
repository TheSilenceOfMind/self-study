package util.concurrent.syncObjects;

import java.util.concurrent.*;

public class ExchangerDemo {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(new ProducerThread(exchanger)).start();
        Thread.sleep(2000);
        new Thread(new ConsumerThread(exchanger)).start();
    }

}

class ProducerThread implements Runnable {
    Exchanger<String> exchanger;
    String str;

    public ProducerThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        this.str = "";
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                for (int j = 0; j < 5; j++) {
                    str += (char) ('A' + j);
                    System.out.println("(P): Created string: " + str);
                    Thread.sleep(1000);
                }
                System.out.println("(P): waiting consumer to get string...");
                exchanger.exchange(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ConsumerThread implements Runnable {
    Exchanger<String> exchanger;
    String str;

    public ConsumerThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++)
            try {
                str = exchanger.exchange(str);
                System.out.println("(C): Got string, preparing to print...");
                System.out.println("(C): String: " + str);
                System.out.println("(C): Waiting 8 sec to do preparing stuff...");
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
