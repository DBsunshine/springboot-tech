package tech.sun.thread;

/**
 * @program: springboot_tech
 * @description: runnable测试
 * @author: 孙东昊
 * @create: 2020-09-20 15:23
 **/
public class MyThreadTest implements Runnable {
    @Override
    public void run() {
        System.out.println("MyThread.run()");
    }

    public static void main(String[] args) {
        MyThreadTest m1 = new MyThreadTest();
        Thread t1 = new Thread(m1);
        t1.start();
    }
}
