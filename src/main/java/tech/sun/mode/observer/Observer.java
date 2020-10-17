package tech.sun.mode.observer;

/**
 * @program: springboot_tech
 * @description: 观察者模式 观察者接口
 * @author: 孙东昊
 * @create: 2020-10-12 17:40
 **/
public interface Observer {
    /**
     * 收到通知后执行自己的业务逻辑
     * @param event
     */
    void doMyself(String event);
}
