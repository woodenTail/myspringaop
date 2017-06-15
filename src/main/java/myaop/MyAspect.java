package myaop;


/**
 * 前置通知
 */
public class MyAspect {

    public void beforeTest(){
        System.out.println("before");
    }

    public void afterTest(){
        System.out.println("after");
    }
}
