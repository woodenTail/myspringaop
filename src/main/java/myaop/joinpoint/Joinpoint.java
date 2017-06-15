package myaop.joinpoint;

/**
 * 连接点
 *
 * 一个连接点总是代表一个方法的执行。表示"在什么地方做"
 * 所有的切入点和通知最后都转换成连接点的执行
 *
 * @author 木鸢
 * @create by 2017-06-07 0:07
 */
public interface Joinpoint {

    Object proceed() throws Exception;
}
