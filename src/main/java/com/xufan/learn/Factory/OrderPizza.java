package com.xufan.learn.Factory;

import com.xufan.learn.Factory.domain.Pizza;
import com.xufan.learn.Factory.factory.CheesePizzaFactory;
import com.xufan.learn.Factory.factory.GreekPizzaFactory;
import com.xufan.learn.Factory.factory.PizzaFactory;

/**
 * @author XuFan
 * @create 2023-05-05-15:46
 */
public class OrderPizza {
    public static void main(String[] args) {
        //工厂方法不一定每一次都返还一个新的对象，但是它所返还的对象一定是它自己创建的。
        //TODO//工厂方法返还的应当是抽象类型，而不是具体类型，只有这样才能保证针对产品的多态性
        //工厂对象应当有一个抽象的超类型作为父类
        //TODO//工厂方法模式的核心是一个抽象工厂类，而简单工厂模式的核心在一个具体类。
        PizzaFactory pizzaFactory = new CheesePizzaFactory();
        Pizza pizza = pizzaFactory.createPizza();
        pizza.prepared();
        pizza.bake();
        pizza.cut();
        pizza.box();


        //关键在于不需要创建新的对象
        pizzaFactory = new GreekPizzaFactory();
        pizza = pizzaFactory.createPizza();
        pizza.prepared();
        pizza.bake();
        pizza.cut();
        pizza.box();



    }
}
