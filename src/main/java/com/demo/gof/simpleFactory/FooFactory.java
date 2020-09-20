package com.demo.gof.simpleFactory;

/**
 * 简单工厂类：根据不同的类型 new出不同的 食物对象；
 */
public class FooFactory {
    public static Food makeFood(String type){
        Food food = null;
        if("china".equals(type)){
            food = new ChineseFood();
        }
        if("ameri".equals(type)){
            food = new AmericFood();
        }
        return food;
    }

    public static void main(String[] args) {
        Food chinaFood = FooFactory.makeFood("china");
        Food ameriFood = FooFactory.makeFood("ameri");
    }

}
