package com.xufan.learn.Strategy;

/**
 * @author XuFan
 * @create 2023-08-21-17:31
 */
public class IntermediateMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("对于中级会员的折扣为10%");
        return booksPrice * 0.9;
    }
}
