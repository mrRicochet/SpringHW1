package ru.good.HW_8.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation. * ;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class UserActionTracker {
    @Before("@annotation(TrackUserAction)")
    public void logMethodInvocation(JoinPoint joinPoint) {
        System.out.println("Действие пользователя: " + joinPoint.getSignature().getName() + " метод был вызван.");
    }
}
