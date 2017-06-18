package myaop.advisior;

import myaop.pointcut.PointCut;
import myaop.advice.Advice;

/**
 * @author 木鸢
 * @create by 2017-06-06 17:15
 */
public abstract class DefaultAdvisor implements Advisor {

    PointCut pointCut;

    Advice advice;

    Integer order;

    public DefaultAdvisor(PointCut pointCut, Advice advice, Integer order) {
        this.pointCut = pointCut;
        this.advice = advice;
        this.order = order;
    }

    @Override
    public PointCut getPointCut() {
        return pointCut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Integer getOrder() {
        return order;
    }

    public void setPointCut(PointCut pointCut) {
        this.pointCut = pointCut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
