package com.xufan.learn.Strategy;

/**
 * @author XuFan
 * @create 2023-08-21-17:28
 */
public class PrimaryMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double bookPrice){
        System.out.println("对于初级会员的没有折扣");
        return bookPrice;
    }

}
