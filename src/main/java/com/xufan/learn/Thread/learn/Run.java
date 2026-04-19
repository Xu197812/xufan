package com.xufan.learn.Thread.learn;

/**
 * @author XuFan
 * @create 2023-06-30-14:02
 */
public class Run {
//    public static void main(String[] args) {
//        Runnable runnable = new MyRunnable();
//        Thread thread = new Thread(runnable,"1");
//        thread.start();
//        System.out.println("运行结束!");
//    }
//    public static void main(String[] args) {
//        MyThread a = new MyThread("A");
//        MyThread b = new MyThread("B");
//        MyThread c = new MyThread("C");
//        a.start();
//        b.start();
//        c.start();
//    }
    public static void main(String[] args) throws InterruptedException {
        MyThread mythread=new MyThread("");
        //线程a b c启动的时候，执行的是myThread的方法，此时数据共享
        Thread a=new Thread(mythread,"A");
        Thread b=new Thread(mythread,"B");
        Thread c=new Thread(mythread,"C");

        a.start();
        Thread.sleep(200);
        a.interrupt();
        b.start();
        c.start();

    }

}
