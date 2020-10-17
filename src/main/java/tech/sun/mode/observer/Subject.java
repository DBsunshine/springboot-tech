package tech.sun.mode.observer;

/**
 * @program: springboot_tech
 * @description: 观察者模式 主题接口
 * @author: 孙东昊
 * @create: 2020-10-12 17:39
 **/
public interface Subject {
    /**
     * 添加和观察着
     * @param observer
     */
    void addObserver(Observer observer);

    /**
     * 删除观察者
     * @param observer
     */
    void deleteObserver(Observer observer);

    /**
     *
     * 通知观察者
     */
    void notifyObserver();

}
