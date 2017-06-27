package myaop.service;

import org.springframework.stereotype.Service;

/**
 * @author 木鸢
 * @create by 2017-06-03 21:19
 */
public class TestService {

    public String testAop() {
        System.out.println("test cglib aop service");
        return "aop is ok";
    }
}
