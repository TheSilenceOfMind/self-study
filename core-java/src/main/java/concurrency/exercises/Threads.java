package concurrency.exercises;

public class Threads {

    private static final String MESSAGE = "Hello, world!";
    private static final String THREAD_GREETING_FORMAT = "From %s : " + MESSAGE + "%n";

    public static void main(String[] args) {
        Threads app = new Threads();

        Thread interfaceThread = new Thread(app.new myThreadThroughInterface());
        interfaceThread.start();

        Thread extendedThread = app.new myThreadThroughInheritance();
        extendedThread.start();
    }

    class myThreadThroughInterface implements Runnable {
        @Override
        public void run() {
            System.out.printf(THREAD_GREETING_FORMAT, this.getClass().getSimpleName());
        }
    }

    class myThreadThroughInheritance extends Thread {
        @Override
        public void run() {
            System.out.printf(THREAD_GREETING_FORMAT, this.getClass().getSimpleName());
        }
    }

}
