package aspect;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.TestAop;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aspect.xml");
        Bussiness bussiness = (Bussiness) context.getBean("bussiness");
		bussiness.testAspect("hello world");
    }
}
