package tech.sun.mode.observer;

import java.util.Vector;

/**
 * @program: springboot_tech
 * @description:
 * @author: 孙东昊
 * @create: 2020-10-12 17:45
 **/
public class SubjectImpl implements Subject {
    Vector<Observer> observers = new Vector<>();

    @Override
    public void addObserver(Observer observer) {
        observers.addElement(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.removeElement(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.doMyself("观察到...");
        }

    }
}
