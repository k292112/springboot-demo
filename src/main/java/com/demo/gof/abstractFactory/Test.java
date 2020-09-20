package com.demo.gof.abstractFactory;

public class Test {
    public static void main(String[] args) {
        //1.组装intel电脑
        ComputerFactory computerFactory = new IntelComputerFactory();
        Computer intel = computerFactory.makeComputer();
        System.out.println(intel);

        //1.组装amd电脑
        ComputerFactory amdFactory = new AmdComputerFactory();
        Computer amd = amdFactory.makeComputer();
        System.out.println(amd);
    }
}
