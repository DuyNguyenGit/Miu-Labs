package bank.tracing;

import bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class LogAdvice {
    @Autowired
    ILogger logger;

    @After("execution (* bank.dao.*.*(..))")
    public void logAdvice(JoinPoint joinPoint) {
        logger.log("method=" + joinPoint.getSignature().getName());
    }

    @Around("execution (* bank.service.*.*(..))")
    public Object logAdvice(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch("");
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        System.out.println("The duration of : " + call.getTarget().getClass() + ":" + call.getSignature().getName() + "() is " + totaltime + " ms");
        return retVal;

    }

    @After("execution (* bank.jms.JMSSender.sendJMSMessage(..)) && args(message)")
    public void logJMSSendingMessage(JoinPoint call, String message) {
        logger.log("method=" + call.getTarget().getClass() + ":" + call.getSignature().getName() + ". The message is \"" + message + "\"");
    }
}
