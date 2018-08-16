package ioc;

import java.math.BigDecimal;

class Pocket {
    private int money;

    Pocket(int money) {
        this.money = money;
    }

    public String toString() {
        return String.valueOf(money);
    }
}
