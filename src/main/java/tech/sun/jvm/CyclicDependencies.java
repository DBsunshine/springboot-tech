package tech.sun.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: springboot_tech
 * @description: JVM监控
 * @author: 孙东昊
 * @create: 2020-10-14 12:27
 **/
public class CyclicDependencies {
    /**
     * 声明缓存对象
     */
    private static final Map map = new HashMap();

    public static void main(String args[]) {
        try {
            //给打开visualVM时间
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //循环添加对象到缓存
        for (int i = 0; i < 1000000; i++) {
            TestMemory t = new TestMemory();
            map.put("key" + i, t);
        }
        System.out.println("first");
        //为dump出堆提供时间
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000000; i++) {
            TestMemory t = new TestMemory();
            map.put("key" + i, t);
        }
        System.out.println("second");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3000000; i++) {
            TestMemory t = new TestMemory();
            map.put("key" + i, t);
        }
        System.out.println("third");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 4000000; i++) {
            TestMemory t = new TestMemory();
            map.put("key" + i, t);
        }
        System.out.println("forth");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("qqqq");
    }
}
