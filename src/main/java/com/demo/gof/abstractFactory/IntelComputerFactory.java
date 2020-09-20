package com.demo.gof.abstractFactory;

public class IntelComputerFactory implements ComputerFactory {

    public Computer makeComputer() {
        Computer computer = new Computer();
        CPU cpu = CPUFactory.makeCpu("intel");
        computer.setCpu(cpu);
        MainBoard mainBoard = MainBoadFactory.makeMainBoard("intel");
        computer.setMainBoard(mainBoard);
        return computer;
    }

}
