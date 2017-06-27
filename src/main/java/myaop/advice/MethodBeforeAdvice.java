package myaop.advice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 木鸢
 * @create by 2017-06-06 16:47
 */
public class MethodBeforeAdvice extends AbstractAdvice implements BeforeAdvice{

    public MethodBeforeAdvice(Object aspectBean, Method aspectJAdviceMethod) {
        setAspectBean(aspectBean);
        setAspectJAdviceMethod(aspectJAdviceMethod);
    }

    @Override
    public void before(Method method, Object obj, Object target) throws InvocationTargetException, IllegalAccessException {
        getAspectJAdviceMethod().invoke(getAspectBean());
    }
}
