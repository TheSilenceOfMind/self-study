package collections.map;

import java.util.EnumMap;

public class EnumMapExample {

    private enum STATE {
        NEW, RUNNING, WAITING, FINISHED
    }

    public static void main(String[] args) {
        EnumMap<STATE, Integer> threadsStates = new EnumMap<>(STATE.class);

        for (STATE state : STATE.values()) {
            threadsStates.put(state, 0);
        }

        System.out.println(threadsStates);
    }
}
