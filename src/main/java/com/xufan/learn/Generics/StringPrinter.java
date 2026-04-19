package com.xufan.learn.Generics;

/**
 * @author XuFan
 * @create 2026-04-19-10:14
 */
public class StringPrinter {
    String content;
    StringPrinter(String content){
        this.content = content;
    }

    public void print() {
        System.out.println(content);
    }
}
