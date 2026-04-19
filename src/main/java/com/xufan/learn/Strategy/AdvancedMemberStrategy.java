package com.xufan.learn.Strategy;

/**
 * @author XuFan
 * @create 2023-08-21-17:32
 */
public class AdvancedMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("对于高级会员的折扣为20%");
        return booksPrice * 0.8;
    }
}
