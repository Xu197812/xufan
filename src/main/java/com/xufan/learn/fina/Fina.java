package com.xufan.learn.fina;

/**
 * @author XuFan
 * @create 2023-08-14-14:48
 */
public class Fina {
    public static Fina fina;
    public static synchronized Fina getInstance(){
        if (fina == null){
            synchronized (Fina.class){
                if (fina == null){
                    fina = new Fina();
                }
            }
        }
        return fina;
    }
}

