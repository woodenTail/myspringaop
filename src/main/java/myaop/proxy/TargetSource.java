package myaop.proxy;

/**
 * @author 木鸢
 * @create by 2017-06-06 20:05
 */
public class TargetSource {

    private Object   target;

    private Class<?> targetClassType;


    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Class<?> getTargetClassType() {
        return targetClassType;
    }

    public void setTargetClassType(Class<?> targetClassType) {
        this.targetClassType = targetClassType;
    }
}
