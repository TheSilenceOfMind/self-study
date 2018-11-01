package ioc;

import java.math.BigDecimal;

class Pocket {
    protected int money;

    Pocket(int money) {
        this.money = money;
    }

    protected void print() {
        System.out.println("parent print()");
    }

    public String toString() {
        return String.valueOf(money);
    }
}
