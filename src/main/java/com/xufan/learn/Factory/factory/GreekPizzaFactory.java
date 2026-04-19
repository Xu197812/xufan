package com.xufan.learn.Factory.factory;

import com.xufan.learn.Factory.domain.GreekPizza;
import com.xufan.learn.Factory.domain.Pizza;

/**
 * @author XuFan
 * @create 2023-05-05-15:42
 */
public class GreekPizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza() {
        return new GreekPizza();
    }
}
