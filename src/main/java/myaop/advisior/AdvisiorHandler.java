package myaop.advisior;

import myaop.PointCut;
import myaop.advice.Advice;
import myaop.joinpoint.MethodInvocation;

/**
 * @author 木鸢
 * @create by 2017-06-15 22:38
 */
public abstract class AdvisiorHandler extends DefaultAdvisor{
    public AdvisiorHandler(PointCut pointCut, Advice advice, Integer order) {
        super(pointCut, advice, order);
    }
}
