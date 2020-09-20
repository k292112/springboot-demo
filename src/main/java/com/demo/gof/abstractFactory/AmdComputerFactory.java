package com.demo.gof.abstractFactory;

/**
 * amd 工厂制作 amd 电脑
 */
public class AmdComputerFactory implements ComputerFactory {
    public Computer makeComputer() {
        Computer computer = new Computer();
        CPU cpu = CPUFactory.makeCpu("AMD");
        computer.setCpu(cpu);
        MainBoard mainBoard = MainBoadFactory.makeMainBoard("AMD");
        computer.setMainBoard(mainBoard);
        return computer;
    }
}
