package collections.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * simple realization of countdown (in sec) with dummy using of queue. Just for example and practice :)
 */
public class Countdown {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 5; i++)
            q.add(i);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
            Thread.sleep(1000);
        }
    }
}
