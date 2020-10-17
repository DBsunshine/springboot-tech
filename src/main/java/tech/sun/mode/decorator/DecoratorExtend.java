package tech.sun.mode.decorator;

/**
 * @program: springboot_tech
 * @description: 装饰者模式
 * @author: 孙东昊
 * @create: 2020-10-12 16:19
 **/
public class DecoratorExtend extends Decorator {

    public DecoratorExtend(Creator c) {
        super(c);
    }

    @Override
    public String handleContent() {
        StringBuilder sb = new StringBuilder("Decorator ");
        sb.append(super.handleContent());
        return sb.toString();
    }
}
