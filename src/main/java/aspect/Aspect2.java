package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 木鸢
 * @create by 2017-06-03 21:48
 */
@org.aspectj.lang.annotation.Aspect
@Order(2) //切面优先级排序
@Component
public class Aspect2 {

    @Pointcut("execution(* aspect..*(..))")
    public void aspect() {
    }

    @Before("aspect()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before2 " + joinPoint.getSignature().getName() + ":\t"
                           + JSONObject.toJSONString(joinPoint.getArgs()));
    }

}
