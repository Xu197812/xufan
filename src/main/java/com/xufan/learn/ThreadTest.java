package com.xufan.learn;

import com.xufan.learn.Thread.ThreadCase;

import java.util.concurrent.*;

/**
 * @author XuFan
 * @create 2023-05-25-10:01
 */
public class ThreadTest {
    public static void main(String[] args) {

        ThreadCase threadCase = new ThreadCase();
        Thread thread = new Thread(threadCase, "线程1");
        thread.start();
        for (int y = 0; y < 200; y++) {
            System.out.println("看" + y);
        }
        ExecutorService es = new ThreadPoolExecutor(50,100,0, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 100; i++){
            es.submit(threadCase);
        }

    }

}
