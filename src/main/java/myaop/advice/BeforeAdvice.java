package myaop.advice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 木鸢
 * @create by 2017-06-06 16:47
 */
public interface BeforeAdvice extends Advice{

    void before(Method method, Object obj, Object target) throws InvocationTargetException, IllegalAccessException;

}
