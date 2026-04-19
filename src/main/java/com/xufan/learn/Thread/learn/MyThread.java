package com.xufan.learn.Thread.learn;

/**
 * @author XuFan
 * @create 2023-06-30-14:09
 */
public class MyThread extends Thread{
    private int count = 100;
    public MyThread(String name) {
        //super的意义在于调用父类构造方法，通过参数判断调用父类的那个构造方法
        super();
        this.setName(name);
    }
    @Override
    public synchronized void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由 " + currentThread().getName()
                    + " 计算，count=" + count+" 线程id" + getId());

        }
    }

}
