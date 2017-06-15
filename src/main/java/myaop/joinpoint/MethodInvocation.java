package myaop.joinpoint;

import java.lang.reflect.Method;

/**
 * @author 木鸢
 * @create by 2017-06-07 0:11
 */
public interface MethodInvocation extends Joinpoint {

    Method getMethod();

    Object[] getArguments();
}
