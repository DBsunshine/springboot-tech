package tech.sun.thread;

/**
 * @program: springboot_tech
 * @description: 线程顺序执行
 * @author: 孙东昊
 * @create: 2020-10-14 15:38
 **/
public class ThreadMainJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("打开冰箱！");
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("拿出一瓶牛奶！");
            }
        });

        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("关上冰箱！");
            }
        });

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
    }

}
