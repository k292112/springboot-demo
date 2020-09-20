package com.demo.gof.abstractFactory;

public class CPUFactory {
    public static CPU makeCpu(String type){
        CPU cpu = null;
        if("AMD".equals(type)){
            cpu = new AmdCPU();
        }
        if("intel".equals(type)){
            cpu = new IntelCPU();
        }
        return cpu;

    }
}
