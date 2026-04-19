package com.xufan.learn.Thread;

/**
 * @author XuFan
 * @create 2023-05-25-10:00
 *  run方法是直接调用，start是让系统在合适的时间执行
 * 通过实现Runnable接口比继承Thread的方式更有优势（java不能多继承，但可以实现多个类）
 *
 */
public class ThreadCase implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("写" + i);
        }
    }
}
