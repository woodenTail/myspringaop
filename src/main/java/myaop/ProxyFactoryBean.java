package myaop;

import myaop.advisior.Advisor;
import myaop.proxy.AopProxy;

import java.util.List;

/**
 * @author 木鸢
 * @create by 2017-06-06 16:58
 */
public class ProxyFactoryBean {

    private TargetSource targetSource;

    List<Advisor>    advisors;

    Object getProxy(AopProxy proxy) {
        return proxy.getProxy();
    }
}
