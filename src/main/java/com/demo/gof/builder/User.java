package com.demo.gof.builder;

/**
 * 建造者模式  内部维护一个builder类，实现设置属性返回this，然后build方法返回 new user对象；
 */
public class User {
    String name;
    int age;
    //内部builder类
    public static class UserBuilder{
        String name;
        int age;
        private UserBuilder(){}

        //链式调用设置属性
        public UserBuilder name(String name){
            this.name = name;
            return this;
        }
        //链式调用设置属性
        public UserBuilder name(int age){
            this.age = age;
            return this;
        }
        //build 负责把 userbuiler对象的属性 复制到 user中
        public User build(){
            if(name == null || age == 0){
                throw new RuntimeException("name 或者 age 为空");
            }
            return new User(name,age);
        }

    }
    //静态方法获取静态类
    public static UserBuilder builder(){
        return new UserBuilder();
    }


    private User() {
    }

    private User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
