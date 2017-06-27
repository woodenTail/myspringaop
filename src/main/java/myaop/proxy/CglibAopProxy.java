package myaop.proxy;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import myaop.advisior.Advisor;
import myaop.joinpoint.MethodInvocation;
import myaop.joinpoint.ReflectiveMethodInvocation;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.NoOp;

/**
 * @author 木鸢
 * @create by 2017-06-06 17:28
 */
public class CglibAopProxy implements AopProxy {

    TargetSource targetSource;

    List<Advisor> advisors;


    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetSource.getTargetClassType());
        Callback  cb = new DynamicAdvisedInterceptor();
        enhancer.setCallback(cb);
        return enhancer.create();
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
       return null;
    }


    class CglibMethodInvocation extends ReflectiveMethodInvocation{

        MethodProxy methodProxy;

        public CglibMethodInvocation(Object proxy, Object target, Method method, Object[] arguments,
                                     Class<?> targetClass, List<Advisor> advisors,MethodProxy methodProxy) {
            super(proxy, target, method, arguments, targetClass, advisors);
            this.methodProxy = methodProxy;
        }

        @Override
        public Object invokeJoinpoint() throws Exception {
            try {
                return methodProxy.invokeSuper(proxy, arguments);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return null;
        }

    }

    class DynamicAdvisedInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            MethodInvocation invocation = new CglibMethodInvocation(proxy, targetSource.getTarget(), method, args,
                    targetSource.getTargetClassType(), getAdvisors(),methodProxy);
            Object res = invocation.proceed();

            return res;
        }
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
