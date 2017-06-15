package myaop.bussiness;

import org.springframework.stereotype.Service;

/**
 * @author 木鸢
 * @create by 2017-06-03 21:19
 */
@Service("testAopApi")
public class TestAopApiImpl implements TestAopApi {

    @Override
    public String testAop() {
        System.out.println("test aop service");
        return "aop is ok";
    }
}
