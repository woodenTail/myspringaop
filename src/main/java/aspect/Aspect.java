package aspect;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 木鸢
 * @create by 2017-06-03 21:48
 */
@org.aspectj.lang.annotation.Aspect
@Order(1)
@Component
public class Aspect {

    @Pointcut("execution(* aspect..*(..))")
    public void aspect() {
    }

    @Before("aspect()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before " + joinPoint.getSignature().getName() + ":\t"
                           + JSONObject.toJSONString(joinPoint.getArgs()));
    }

    @Around("execution(* aspect..*(..))")
    public Object around(JoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = ((ProceedingJoinPoint) joinPoint).proceed();
        long end = System.currentTimeMillis();
        System.out.println("Used time : " + (end - start) + " ms!");
        return object;
    }
}
