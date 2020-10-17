package tech.sun.mode.decorator;

/**
 * @program: springboot_tech
 * @description: 装饰者模式
 * @author: 孙东昊
 * @create: 2020-10-12 16:11
 **/
public class CreatorImpl implements Creator {
    @Override
    public String handleContent() {
        return "Content of Packet";
    }
}
