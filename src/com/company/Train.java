package com.company;
import java.io.Serializable;

import java.util.ArrayList;


public class Train implements Serializable{
    int numberTrain;
    private ArrayList<Wagon> wagons;

    public Train() {
        wagons = new ArrayList<>();
    }

    public Train(ArrayList<Wagon> wagons) {
        this.wagons = wagons;
    }

    public ArrayList<Wagon> getWagons(){
        return wagons;
    }


}

