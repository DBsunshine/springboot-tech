package tech.sun.mode.decorator;

/**
 * @program: springboot_tech
 * @description: 装饰者模式
 * @author: 孙东昊
 * @create: 2020-10-12 16:15
 **/
public abstract class Decorator implements Creator {
    private Creator creator;

    public Decorator(Creator c) {
        creator = c;
    }

    @Override
    public String handleContent() {
        return creator.handleContent();
    }
}
