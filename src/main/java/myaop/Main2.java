package myaop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import myaop.advice.MethodAfterAdvice;
import myaop.advice.MethodBeforeAdvice;
import myaop.advisior.Advisor;
import myaop.advisior.AfterAdvisiorHandler;
import myaop.advisior.BeforeAdvisiorHandler;
import myaop.pointcut.ExpressionPointcut;
import myaop.pointcut.PointCut;
import myaop.proxy.AopProxy;
import myaop.proxy.CglibAopProxy;
import myaop.proxy.JdkAopProxy;
import myaop.proxy.ProxyFactoryBean;
import myaop.proxy.TargetSource;
import myaop.service.MyAspect;
import myaop.service.TestAopApi;
import myaop.service.TestAopApiImpl;
import myaop.service.TestService;

/**
 * @author 木鸢
 * @create by 2017-06-06 16:46
 */
public class Main2 {

    public static void main(String[] args) throws NoSuchMethodException {


        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();

        AopProxy jdkAopProxy = new JdkAopProxy();

        TargetSource targetSource = new TargetSource();

        TestAopApi api = new TestAopApiImpl();
        targetSource.setTarget(api);
        targetSource.setTargetClassType(TestAopApi.class);
        jdkAopProxy.setTargetSource(targetSource);

        List<Advisor> advisors = getAdvisors();
        jdkAopProxy.setAdvisors(advisors);

        TestAopApi proxyApi = (TestAopApi)proxyFactoryBean.getProxy(jdkAopProxy);
        proxyApi.testAop();

        System.out.println("==================");

        AopProxy cglibAopProxy = new CglibAopProxy();
        TargetSource targetSource1 = new TargetSource();
        TestService service = new TestService();
        targetSource1.setTarget(service);
        targetSource1.setTargetClassType(TestService.class);
        cglibAopProxy.setTargetSource(targetSource1);
        cglibAopProxy.setAdvisors(getAdvisors());


        TestService cglibTest = (TestService)proxyFactoryBean.getProxy(cglibAopProxy);
        cglibTest.testAop();
    }

    private static List<Advisor> getAdvisors() throws NoSuchMethodException {
        PointCut pointCut = new ExpressionPointcut("*","pointCut");
        MyAspect myAspect = new MyAspect();
        Method beforeMethod = myAspect.getClass().getMethod("beforeTest");
        Method afterMethod = myAspect.getClass().getMethod("afterTest");
        MethodBeforeAdvice beforeAdvice = new MethodBeforeAdvice(myAspect, beforeMethod);
        MethodAfterAdvice afterAdvice = new MethodAfterAdvice(myAspect, afterMethod);

        Advisor advisor1 = new BeforeAdvisiorHandler(pointCut, beforeAdvice, null);
        Advisor advisor2 = new AfterAdvisiorHandler(pointCut, afterAdvice, null);
        Advisor advisor3 = new AfterAdvisiorHandler(pointCut, afterAdvice, null);
        List<Advisor>advisorList = new ArrayList<>();
        advisorList.add(advisor1);
        advisorList.add(advisor2);
        advisorList.add(advisor3);
        return advisorList;
    }
}
