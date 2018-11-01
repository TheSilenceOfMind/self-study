package mixin;

import java.util.*;

public class Exercise_38 {
    public static void main(String[] args) {
    }
}


class Basic {
    private String value;

    public void set(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}

class Decorator extends Basic {
    protected Basic basic;

    Decorator(Basic basic) { this.basic = basic; }

    public void set(String val) { basic.set(val); }
    public String get() { return basic.get(); }
}

class TimeStamped extends Decorator {
    private final long timeStamp;

    TimeStamped(Basic basic) {
        super(basic);
        timeStamp = new Date().getTime();
    }

    public long getStamp() { return timeStamp; }
}

