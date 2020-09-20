package com.demo.gof.abstractFactory;

public  class Computer {
     CPU cpu;
     MainBoard MainBoard;

    public Computer() {
    }

    public Computer(CPU cpu, MainBoard mainBoard) {
        this.cpu = cpu;
        MainBoard = mainBoard;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public MainBoard getMainBoard() {
        return MainBoard;
    }

    public void setMainBoard(MainBoard mainBoard) {
        MainBoard = mainBoard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu=" + cpu +
                ", MainBoard=" + MainBoard +
                '}';
    }
}
