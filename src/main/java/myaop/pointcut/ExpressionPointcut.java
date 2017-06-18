package myaop.pointcut;

import java.lang.reflect.Method;

/**
 * @author 木鸢
 * @create by 2017-06-06 16:38
 */
public class ExpressionPointcut implements PointCut {

    String expression;

    String pointId;


    public ExpressionPointcut(String expression, String pointId) {
        this.expression = expression;
        this.pointId = pointId;
    }

    @Override
    public String getPointCutId() {
        return pointId;
    }

    @Override
    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return true;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object[] args) {
        return true;
    }

}
