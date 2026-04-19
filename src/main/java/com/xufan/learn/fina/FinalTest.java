package com.xufan.learn.fina;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author XuFan
 * @create 2023-08-14-14:51
 */
public class FinalTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        Set<String> temp = new HashSet<>();
        for (int i = 0; i< 100; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    temp.add(Fina.getInstance().toString());
                    System.out.println(Thread.currentThread().getName()+":"+Fina.getInstance());
                }
            });
        }
        temp.forEach(System.out::println);
    threadPool.shutdown();
    }
}
