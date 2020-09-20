package com.demo.gof.abstractFactory;

public class IntelMainBoard extends MainBoard{
    public  IntelMainBoard(){
        this.desc = "IntelMainBoard";
    }

    @Override
    public String toString() {
        return "IntelMainBoard{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
