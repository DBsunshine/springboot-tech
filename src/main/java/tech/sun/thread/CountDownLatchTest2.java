package tech.sun.thread;

import java.util.concurrent.*;

/**
 * @program: springboot_tech
 * @description: CountDownLatchTest
 * @author: 孙东昊
 * @create: 2020-09-20 19:47
 **/
public class CountDownLatchTest2 {
    public static void main(String[] args) {
        int taskNum = 3;
        ExecutorService pool = new ThreadPoolExecutor(taskNum, taskNum,
                60L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(taskNum));
        CountDownLatch cdl = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            CountRunnable runnable = new CountRunnable(cdl);
            pool.execute(runnable);
        }
    }
}

class CountRunnable implements Runnable {
    private CountDownLatch countDownLatch;
    public CountRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            synchronized (countDownLatch) {
                /*** 每次减少一个容量*/
                countDownLatch.countDown();
                System.out.println("thread counts = " + (countDownLatch.getCount()));
            }
            countDownLatch.await();
            System.out.println("concurrency counts = " + (100 - countDownLatch.getCount()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
