package tech.sun.thread;

/**
 * @program: springboot_tech
 * @description: 线程
 * @author: 孙东昊
 * @create: 2020-09-18 19:14
 **/
public class ThreadTest extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread.run()");
    }

    public static void main(String[] args) {
        ThreadTest m1 = new ThreadTest();
        m1.start();
    }
}
