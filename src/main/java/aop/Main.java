package aop;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        /*Spring AOP使用JDK动态代理或者CGLIB来为目标对象创建代理。如果被代理的目
        标对象实现了至少一个接口，则会使用JDK动态代理。所有该目标类型实现的接
        口都将被代理。若该目标对象没有实现任何接口，则创建一个CGLIB代理*/

        /*强制使用CGLIB代理需要将proxy-target-class 属性设为true:
        <aop:config proxy-target-class="true"></aop:config>*/

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop-schema.xml");
        TestAop testAop = (TestAop) context.getBean("testAop");
		testAop.testAop();

       /* TestAopApi testAopApi = (TestAopApi) context.getBean("testAopApi");
        testAopApi.testAop();*/
    }
}
