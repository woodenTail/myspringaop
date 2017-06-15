package aspect;

import org.springframework.stereotype.Component;

/**
 * @author 木鸢
 * @create by 2017-06-03 21:19
 */
@Component
public class Bussiness {
    public String testAspect(String arg) {
        System.out.println("test aspect");
        return "test aspect" +arg;
    }
}
