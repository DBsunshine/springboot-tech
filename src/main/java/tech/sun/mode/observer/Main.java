package tech.sun.mode.observer;

/**
 * @program: springboot_tech
 * @description:
 * @author: 孙东昊
 * @create: 2020-10-12 17:57
 **/
public class Main {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        Observer observer = new ObserverImpl();
        Observer observer1 = new Observer0Impl();
        subject.addObserver(observer);
        subject.addObserver(observer1);
        subject.notifyObserver();

        // JDK自带观察者模式

        DefaultSubject defaultSubject = new DefaultSubject();
        DefaultObserver defaultObserver = new DefaultObserver();
        DefaultObserver0 defaultObserver0 = new DefaultObserver0();
        defaultSubject.addObserver(defaultObserver);
        defaultSubject.addObserver(defaultObserver0);
        defaultSubject.setNews("JDK通知->");

    }
}
