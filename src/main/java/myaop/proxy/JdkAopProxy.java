package myaop.proxy;

import myaop.advisior.Advisor;
import myaop.TargetSource;
import myaop.joinpoint.MethodInvocation;
import myaop.joinpoint.ReflectiveMethodInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 木鸢
 * @create by 2017-06-06 17:28
 */
public class JdkAopProxy implements AopProxy, InvocationHandler {

    TargetSource targetSource;

    List<Advisor> advisors;

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(targetSource.getTargetClassType().getClassLoader(),
                                      new Class<?>[] { targetSource.getTargetClassType() }, this);
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return Proxy.newProxyInstance(classLoader,
                new Class<?>[] { targetSource.getTarget().getClass() }, this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<Advisor> advisors = getAdvisors();
        List<Advisor>beforeAdvisors = new ArrayList<>();
        /*List<Advisor>afterAdvisiors = new ArrayList<>();

        for(Advisor advisor : advisors){
            if(advisor.getAdvice() instanceof BeforeAdvice){
                beforeAdvisors.add(advisor);
            }
            if(advisor.getAdvice() instanceof AfterAdvice){
                afterAdvisiors.add(advisor);
            }
        }
         for(Advisor advisor : beforeAdvisors){
            BeforeAdvice advice = (BeforeAdvice) advisor.getAdvice();
            advice.before(method, args, targetSource.getTarget());
        }

        method.invoke(targetSource.getTarget(), args);

        for(Advisor advisor : afterAdvisiors){
            AfterAdvice advice = (AfterAdvice) advisor.getAdvice();
            advice.after(method, args, targetSource.getTarget());
        }*/


        MethodInvocation invocation = new ReflectiveMethodInvocation(proxy, targetSource.getTarget(), method, args,
                                                                     targetSource.getTargetClassType(), getAdvisors());
        Object res = invocation.proceed();

        return res;
    }

    public List<Advisor> getAdvisors() {
        return advisors;
    }

    public void setAdvisors(List<Advisor> advisors) {
        this.advisors = advisors;
    }

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }
}
