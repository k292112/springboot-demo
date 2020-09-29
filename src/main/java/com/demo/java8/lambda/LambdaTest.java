package com.demo.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * lambda 表达式
 * Lambda 表达式，也可称为闭包，它是推动 Java 8 发布的最重要新特性。
 * Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
 * 使用 Lambda 表达式可以使代码变的更加简洁紧凑。
 * (parameters) -> expression
 * 或
 * (parameters) ->{ statements; }
 */
public class LambdaTest {
    public static void main(String[] args) {
        // 有一个参数，无返回值
        String s = "hello lambda";
        Consumer<String> consumer = (a) -> System.out.println(a);
        consumer.accept(s);//hello lambda
        // 有一个参数，无返回值 （小括号可以省略不写）
        Consumer<String> consumer1 = a -> System.out.println(a);
        consumer1.accept(s);//hello lambda

        // 比较1：
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
        System.out.println(com1.compare(2, 2));
        // 比较2：若 Lambda 表达式体中的内容已有方法实现，则我们可以使用“方法引用”
        // 对象 :: 实例方法  类 :: 静态方法  类 :: 实例方法
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(2, 2));

        System.out.println("---------------------------------------------------------------------");

        // 自定义排序
        List<Employee> emps = Arrays.asList(
                new Employee(101, "Z3", 20, 9999.99),
                new Employee(102, "L4", 20, 7777.77),
                new Employee(103, "W5", 20, 6666.66),
                new Employee(104, "Tom", 20, 1111.11),
                new Employee(105, "Jerry", 60, 4444.44)
        );
        // 排序：
        Collections.sort(emps, (a, b) -> {
            if (a.getAge() == b.getAge()) {
                return a.getName().compareTo(b.getName());
            } else {
                return a.getAge().compareTo(b.getAge());// 默认正序，相反 前面加 -（）
            }
        });
        for (Employee emp : emps) {
            System.out.println(emp);
        }

    }


}

class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private Double salary;

    public Employee(Integer id, String name, Integer age, Double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}


