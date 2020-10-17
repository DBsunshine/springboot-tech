package tech.sun.mode.decorator;

/**
 * @program: springboot_tech
 * @description:
 * @author: 孙东昊
 * @create: 2020-10-12 16:28
 **/
public class Main {
    public static void main(String[] args) {
        Creator create = new DecoratorExtend(new CreatorImpl());
        String str = create.handleContent();
        System.out.println(str);
    }
}
