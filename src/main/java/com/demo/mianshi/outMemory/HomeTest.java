package com.demo.mianshi.outMemory;

import java.util.ArrayList;
import java.util.List;

public class HomeTest {
    List list = null;
    public void SetList(){
        list = new ArrayList<>();
        while (true){
            list.add("abc");
        }
    }
}
