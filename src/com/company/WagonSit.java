package com.company;

import java.io.Serializable;

public class WagonSit extends Wagon implements Serializable {

    public WagonSit(){
        super();
    }

    public WagonSit(int numberWagon,  int comfort, int people, int luggage){
        super( numberWagon,   comfort,  people,  luggage);
    }
    public boolean isSit()
    {
        return true;
    }
}
