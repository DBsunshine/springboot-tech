package tech.sun.mode.observer;

import java.util.Observable;

/**
 * @program: springboot_tech
 * @description: JDK自带观察者
 * @author: 孙东昊
 * @create: 2020-10-13 09:15
 **/
public class DefaultSubject extends Observable {

    private String news;

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
        super.setChanged();
        super.notifyObservers(news);
    }

}
