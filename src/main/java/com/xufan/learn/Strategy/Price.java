package com.xufan.learn.Strategy;

/**
 * @author XuFan
 * @create 2023-08-21-17:27
 */
public class Price {
    public MemberStrategy memberStrategy;
    public Price(MemberStrategy memberStrategy){
        this.memberStrategy = memberStrategy;
    }
    public double quote(double booksPrice){
        return this.memberStrategy.calcPrice(booksPrice);
    }
}
