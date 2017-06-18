package myaop.advisior;

import myaop.pointcut.PointCut;
import myaop.advice.AfterAdvice;
import myaop.joinpoint.MethodInvocation;

/**
 * @author 木鸢
 * @create by 2017-06-15 22:38
 */
public class AfterAdvisiorHandler extends AdvisiorHandler{

    AfterAdvice afterAdvice;

    public AfterAdvisiorHandler(PointCut pointCut, AfterAdvice advice, Integer order) {
        super(pointCut, advice, order);
        afterAdvice =  advice;
    }

    @Override
    public void handler(MethodInvocation invocation) throws Exception {
        invocation.proceed();
        afterAdvice.after(invocation.getMethod(), invocation.getArguments(), invocation);
     }
}
