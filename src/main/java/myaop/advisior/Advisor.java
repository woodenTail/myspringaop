package myaop.advisior;

import myaop.PointCut;
import myaop.advice.Advice;
import myaop.joinpoint.MethodInvocation;

/**
 * 通知器
 * 一个切入点多个通知的时候,注册多个通知器
 *
 *   <aop:aspect id="aspectXXX" ref="myBefore">
 *   <aop:pointcut id="pointcutXXX" expression="execution(* aop..*(..))"></aop:pointcut>
 *    <aop:before method="beforeTest" pointcut-ref="pointcutXXX"></aop:before>
 *  <aop:after method="afterTest" pointcut-ref="pointcutXXX"></aop:after>
 * @author 木鸢
 * @create by 2017-06-06 17:14
 */
public interface Advisor {

    PointCut getPointCut();

    Advice getAdvice();

    Integer getOrder();

    void handler(MethodInvocation invocation) throws Exception;
}
