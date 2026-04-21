package com.xufan.learn.Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XuFan
 * @create 2026-04-19-15:51
 */
public class GenericeTest {
    public static void main(String[] args) {
        StringPrinter printer = new StringPrinter("123");
        printer.print();

        Printer<String> printer1 = new Printer<>("1233");
        printer1.print();

        List<String> list = new ArrayList<>();
        list.add("temp1");
        list.add("temp2");
        print(list);
    }

    private static <T> void print(T list){
        System.out.println(list);
    }
}
