package tech.sun.mode.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @program: springboot_tech
 * @description: JDK自带的观察者
 * @author: 孙东昊
 * @create: 2020-10-13 09:02
 **/
public class DefaultObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg + "自带观察者1");
    }
}
