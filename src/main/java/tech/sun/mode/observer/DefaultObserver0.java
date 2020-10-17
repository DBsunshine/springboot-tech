package tech.sun.mode.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @program: springboot_tech
 * @description: JDK自带观察者2
 * @author: 孙东昊
 * @create: 2020-10-13 09:21
 **/
public class DefaultObserver0 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg + "自带观察者2");
    }
}
