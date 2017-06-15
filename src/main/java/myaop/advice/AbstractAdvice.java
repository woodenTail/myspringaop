package myaop.advice;

import java.lang.reflect.Method;

/**
 * @author 木鸢
 * @create by 2017-06-06 16:47
 */
public abstract class AbstractAdvice implements Advice{

    //切面类实例 <bean id="myBefore" class="aop.MyBefore"/>
    private Object aspectBean;

    //切面方法 beforeTest  <aop:before method="beforeTest" pointcut-ref="pointcutXXX"></aop:before>
    private Method aspectJAdviceMethod;


    public Object getAspectBean() {
        return aspectBean;
    }

    public void setAspectBean(Object aspectBean) {
        this.aspectBean = aspectBean;
    }

    public Method getAspectJAdviceMethod() {
        return aspectJAdviceMethod;
    }

    public void setAspectJAdviceMethod(Method aspectJAdviceMethod) {
        this.aspectJAdviceMethod = aspectJAdviceMethod;
    }
}
