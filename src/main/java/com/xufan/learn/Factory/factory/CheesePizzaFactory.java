package com.xufan.learn.Factory.factory;

import com.xufan.learn.Factory.domain.CheesePizza;
import com.xufan.learn.Factory.domain.Pizza;

/**
 * @author XuFan
 * @create 2023-05-05-15:41
 */
public class CheesePizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza() {
        return new CheesePizza();
    }
}
