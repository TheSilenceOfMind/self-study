package concurrency;


public class ThreadsExample {

    class CounterThread implements Runnable {
        private int from;
        private int to;
        private int msInterval;

        CounterThread(int from, int to, int msInterval) {
            this.from = from;
            this.to = to;
            this.msInterval = msInterval;
        }

        @Override
        public void run() {
            try {
                for (int i = from; i <= to; i++) {
                    printMessageFromThread(String.valueOf(i));
                    Thread.sleep(msInterval);
                }
            } catch (InterruptedException e) {
                printMessageFromThread("I was interrupted!");
            } finally {
                printMessageFromThread("Ending thread execution...");
            }
        }

    }

    private static void printMessageFromThread(String msg) {
        System.out.format("%s: %s%n", Thread.currentThread().getName(), msg);
    }

    public static void main(String[] args) throws InterruptedException {
        printMessageFromThread("Let's count together!");
        final int threadsAmount = 100;
        final int msPatienceToInterrupt = 5000;

        ThreadsExample app = new ThreadsExample();
        for (int i = 0; i < threadsAmount; i++) {
            Thread thread = new Thread(app.new CounterThread(1, 5,
                    (new java.util.Random()).nextInt(3000)));
            thread.start();
            printMessageFromThread("new thread started!");
            thread.join(msPatienceToInterrupt);
            if (thread.isAlive()) {
                printMessageFromThread("Tired of waiting! I'm stopping your counting!");
                thread.interrupt();
                thread.join();
            }
        }
    }
}

