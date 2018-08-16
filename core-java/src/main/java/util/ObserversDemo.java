package util;

import java.util.*;

public class ObserversDemo {
    public static void main(String[] args) {
        Observer o1 = new Watcher1();
        Observer o2 = new Watcher2();
        BeingWatched observed = new BeingWatched();

        observed.addObserver(o1);
        observed.addObserver(o2);

        observed.counter(10);
    }
}

class Watcher1 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update called, count is " + arg);
    }
}

class Watcher2 implements  Observer {

    @Override
    public void update(Observable o, Object arg) {
        if ((Integer)arg == 0) {
            System.out.println("done" + '\7');
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
    }
}

class BeingWatched extends Observable {
    void counter(int period) {
        for (; period >= 0; period--) {
            setChanged();
            notifyObservers(period);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
        }
    }
}


