package myaop.proxy;

import myaop.advisior.Advisor;

import java.util.List;

/**
 * @author 木鸢
 * @create by 2017-06-06 16:58
 */
public class ProxyFactoryBean {

    private TargetSource targetSource;

    List<Advisor>    advisors;

    public Object getProxy(AopProxy proxy) {
        return proxy.getProxy();
    }
}
