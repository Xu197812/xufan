package com.xufan.learn.SimpleFactory.domain;

/**
 * @author XuFan
 * @create 2023-05-05-15:15
 */
public abstract class Pizza {
    //准备
    public abstract void prepared();
    //烘烤
    public abstract void bake();
    //切
    public abstract void cut();
    //打包
    public abstract void box();
}
