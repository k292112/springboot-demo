package com.demo.gof.abstractFactory;

public class IntelCPU extends CPU{
    @Override
    public String toString() {
        return "IntelCPU{" +
                "dies='" + dies + '\'' +
                '}';
    }

    public IntelCPU() {
        this.dies = "intelCpu";
    }
}
