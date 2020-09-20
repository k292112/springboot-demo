package com.demo.gof.abstractFactory;

public class AmdCPU extends CPU{
    public AmdCPU() {
        this.dies = "amdcput";
    }

    @Override
    public String toString() {
        return "AmdCPU{" +
                "dies='" + dies + '\'' +
                '}';
    }
}
