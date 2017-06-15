package myaop.joinpoint;

import myaop.advisior.Advisor;
import myaop.advice.AfterAdvice;
import myaop.advice.BeforeAdvice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author 木鸢
 * @create by 2017-06-07 0:14
 */
public class ReflectiveMethodInvocation implements MethodInvocation{

    protected  Object proxy;

    protected  Object target;

    protected  Method method;

    protected Object[] arguments;

    private  Class<?> targetClass;

    List<Advisor> advisors;

    int currentAdvisorIndex= -1;


    public ReflectiveMethodInvocation(Object proxy, Object target, Method method, Object[] arguments,
                                      Class<?> targetClass, List<Advisor> advisors) {
        this.proxy = proxy;
        this.target = target;
        this.method = method;
        this.arguments = arguments;
        this.targetClass = targetClass;
        this.advisors = advisors;
    }

    @Override
    public Method getMethod() {
        return null;
    }

    @Override
    public Object[] getArguments() {
        return new Object[0];
    }

    @Override
    public Object proceed() throws Exception{
        currentAdvisorIndex ++;
        if(currentAdvisorIndex == (advisors.size()) ){
            return method.invoke(target, arguments);
        }

        Advisor advisor = advisors.get(currentAdvisorIndex);
        advisor.handler(this);
        return null;
    }


}
