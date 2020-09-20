package com.demo.gof.abstractFactory;

public class MainBoadFactory {
    public static MainBoard makeMainBoard(String type){
        MainBoard mainBoard = null;
        if("AMD".equals(type)){
            mainBoard = new AmdMainBoard();
        }
        if("intel".equals(type)){
            mainBoard = new IntelMainBoard();
        }
        return mainBoard;
    }
}
