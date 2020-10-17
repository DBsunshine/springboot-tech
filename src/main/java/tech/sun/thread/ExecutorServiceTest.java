package tech.sun.thread;

import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: springboot_tech
 * @description: 多线程带返回值
 * @author: 孙东昊
 * @create: 2020-09-20 15:34
 **/
public class ExecutorServiceTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int taskNum = 5;
        ExecutorService pool = new ThreadPoolExecutor(taskNum, taskNum,
                60L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(taskNum));
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < taskNum; i++) {
            Callable c = new MyCallable(i + "");
            Future f = pool.submit(c);
            list.add(f);
        }
        pool.shutdown();

        for (Future future : list) {
            System.out.println("" + future.get().toString());
        }
    }

    static class MyCallable implements Callable {
        private String threadName;

        public MyCallable(String str) {
            this.threadName = str;
        }

        @Override
        public Object call() throws Exception {
            return threadName + "返回的信息";
        }
    }


}
