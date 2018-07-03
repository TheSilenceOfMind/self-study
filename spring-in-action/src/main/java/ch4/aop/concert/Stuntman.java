package ch4.aop.concert;

import org.springframework.stereotype.Component;

@Component("stuntman")
class Stuntman implements Performance {
    @Override
    public void perform() {
        if (Math.random() > 0.5)
            System.out.println("Stuntman: dangerous stunt! Watch out!");
        else
            throw new IllegalStateException("need refund!");
    }
}
