package ru.good.HW_8.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation. * ;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Aspect
@Component
public class UserActionTracker {
    private final Logger logger = Logger.getLogger(UserActionTracker.class.getName());

    public UserActionTracker(){
        try {
            FileHandler fh = new FileHandler("log.txt", true);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.addHandler(fh);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "result")
    public void log(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        Object[] args = joinPoint.getArgs();

        logger.info("Логирование:");
        logger.info("Метод: " + methodName);
        logger.info("Класс: " + className);
        logger.info("Аргументы: " + args);
        logger.info("Результат: " + result);
        logger.info("Конец логирования.");
    }
}
