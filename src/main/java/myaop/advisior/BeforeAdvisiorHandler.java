package myaop.advisior;

import myaop.pointcut.PointCut;
import myaop.advice.BeforeAdvice;
import myaop.joinpoint.MethodInvocation;

/**
 * @author 木鸢
 * @create by 2017-06-15 22:38
 */
public class BeforeAdvisiorHandler extends AdvisiorHandler{

    BeforeAdvice beforeAdvice;
    public BeforeAdvisiorHandler(PointCut pointCut, BeforeAdvice advice, Integer order) {
        super(pointCut, advice, order);
        beforeAdvice = advice;
    }

    @Override
    public void handler(MethodInvocation invocation) throws Exception {
        beforeAdvice.before(invocation.getMethod(), invocation.getArguments(), invocation);
        invocation.proceed();
     }
}
