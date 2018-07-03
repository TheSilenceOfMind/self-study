package ch4.aop.concert;

import org.springframework.stereotype.Component;

@Component("actress")
class Actress implements Performance {

    @Override
    public void perform() {
        if (Math.random() > 0.5)
            System.out.println("Actress: I'm performing!");
        else
            throw new IllegalStateException("need refund!");
    }

}
