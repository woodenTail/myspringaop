package myaop.proxy;

import myaop.advisior.Advisor;
import myaop.TargetSource;

import java.util.List;

/**
 * @author 木鸢
 * @create by 2017-06-06 17:27
 */
public interface AopProxy {

    Object getProxy();

    Object getProxy(ClassLoader classLoader);

    public List<Advisor> getAdvisors();

    public void setAdvisors(List<Advisor> advisors);

    public TargetSource getTargetSource();

    public void setTargetSource(TargetSource targetSource);
}
