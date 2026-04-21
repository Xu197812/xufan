package com.xufan.learn.Generics;

/**
 * @author XuFan
 * @create 2026-04-19-19:04
 */
public class Printer<T> {
    T content;
    Printer(T content){
        this.content = content;
    }

    public void print() {
        System.out.println(content);
    }
}
