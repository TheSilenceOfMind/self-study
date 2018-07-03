package ch4.aop.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
class Audience {

    @Pointcut("execution(* ch4.aop.concert.Performance.perform(..))")
    private void performance() {
    }

    @Around("performance()")
    void watchPerformance(ProceedingJoinPoint jp) throws IllegalStateException {
        try {
            System.out.println("Audience: silencing cell phones.");
            System.out.println("Audience: taking seats.");
            jp.proceed();
            System.out.println("Audience: CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("Audience: demand refund.");
            throw new IllegalStateException("demand refund.");
        }
    }

}
