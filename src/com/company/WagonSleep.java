package com.company;


import java.io.Serializable;

public class WagonSleep extends Wagon implements Serializable{

    public WagonSleep(){
        super();
    }

    public WagonSleep(int numberWagon,  int comfort, int people, int luggage){
        super(numberWagon,   comfort,  people,  luggage);
    }
    public boolean isSit()
    {
        return false;
    }
}
