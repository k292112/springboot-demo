package com.demo.gof.abstractFactory;

public class AmdMainBoard extends MainBoard{
    public  AmdMainBoard(){
        this.desc = "AmdMainBoard";
    }

    @Override
    public String toString() {
        return "AmdMainBoard{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
