package myaop.advisior;

import myaop.pointcut.PointCut;
import myaop.advice.Advice;

/**
 * @author 木鸢
 * @create by 2017-06-15 22:38
 */
public abstract class AdvisiorHandler extends DefaultAdvisor{
    public AdvisiorHandler(PointCut pointCut, Advice advice, Integer order) {
        super(pointCut, advice, order);
    }
}
