package tech.sun.mode.observer;

/**
 * @program: springboot_tech
 * @description:
 * @author: 孙东昊
 * @create: 2020-10-12 17:56
 **/
public class Observer0Impl implements Observer {
    @Override
    public void doMyself(String event) {
        System.out.println("第二个" + event);
    }
}
