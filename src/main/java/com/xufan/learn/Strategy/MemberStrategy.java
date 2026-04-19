package com.xufan.learn.Strategy;

/**
 * @author XuFan
 * @create 2023-08-21-17:28
 */
public interface MemberStrategy {
    /**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    public double calcPrice(double booksPrice);
}
