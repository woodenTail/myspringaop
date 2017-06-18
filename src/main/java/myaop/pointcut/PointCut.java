package myaop.pointcut;

import java.lang.reflect.Method;

/**
 * 切入点
 *
 * @author 木鸢
 * @create by 2017-06-06 16:20
 */
public interface PointCut {


    String getPointCutId();

    String getExpression();
    /**
     * 方法是否匹配当前切入点
     * @param method
     * @param targetClass
     * @return
     */
    boolean matches(Method method, Class<?> targetClass);

    boolean matches(Method method, Class<?> targetClass, Object[] args);

}
