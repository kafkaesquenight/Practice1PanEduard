package pan.eduard.Practice1;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Aspect
@Component
@Slf4j
public class MyAspect {
    @Before("execution(* pan.eduard.Practice1.service.ServiceD.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("logBefore called. Method name: " + joinPoint.getSignature().toShortString());

    }
    @After("execution(* pan.eduard.Practice1.service.ServiceD.*(..))")
    public void logAfter(JoinPoint joinPoint){
        log.info("After called. Method name: " + joinPoint.getSignature().toShortString());
    }
    @Pointcut("execution(* pan.eduard.Practice1.service..*(..))")
    protected void loggingOperation(){

    }
    @Around("execution(* pan.eduard.Practice1.service.ServiceD.*(..))")
    public void logAround() {
        log.info("Around method getting called");
    }

    @AfterReturning("execution(* pan.eduard.Practice1.service..*(..))")
    public void afterReturning(JoinPoint joinPoint){
        log.info("AfterReturning. Method name: " + joinPoint.getSignature().toShortString());
    }

    @AfterThrowing("execution(* pan.eduard.Practice1.service.ServiceC*.*(..))")
    public void AfterReturning(JoinPoint joinPoint){
        log.info("AfterReturning. Method name: " + joinPoint.getSignature().toShortString());
    }


}
