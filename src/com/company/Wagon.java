package com.company;
import java.io.Serializable;


public abstract class Wagon implements Serializable {
    int numberWag;
    int comfort;
    int people;
    int luggage;

    public Wagon(int numberWagon,  int comfort, int people, int luggage)
    {
        try {
            if (numberWagon<0)
                throw new NegativeValueException("NumberWagon");
            this.numberWag = numberWagon;
            if (comfort<0)
                throw new NegativeValueException("Comfort");
            this.comfort = comfort;
            if (people<0)
                throw new NegativeValueException("People");
            this.people = people;
            if (luggage<0)
                throw new NegativeValueException("Luggage");
            this.luggage = luggage;
        }catch(NegativeValueException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public Wagon()
    {
        this.numberWag = 0;
        this.comfort = 0;
        this.people = 0;
        this.luggage = 0;

    }
    public int getNumberWag(){
        return numberWag;
    }

    public int getComfort(){
        return comfort;
    }

    public int getPeople(){
        return people;
    }

    public int getLuggage(){
        return luggage;
    }
   /* public void setNumberWag(int numberWag){
        this.numberWag = numberWag;
    }

    public void setComfort(int comfort){
        this.comfort = comfort;
    }

    public void setPeople(int people){
        this.people = people;
    }

    public void setLuggage(int luggage){
        this.luggage = luggage;
    }*/

    public void print(Wagon wagon) {
        if (isSit()) {
            System.out.println("Sit wagon: " + wagon.numberWag);
        } else {
            System.out.println("Sleep wagon: " + wagon.numberWag);
        }
        System.out.println("Comfort class: " + String.valueOf(wagon.comfort));
        switch (comfort) {
            case 1:
                System.out.println("Comfort type: SW");
                break;
            case 2:
                System.out.println("Comfort type: Kupe");
                break;
            case 3:
                System.out.println("Comfort type: Platskart");
                break;
            case 4:
                System.out.println("Comfort type: Sit 1 class");
                break;
            case 5:
                System.out.println("Comfort type: Sit 2 class");
                break;
            case 6:
                System.out.println("Comfort type: Sit 3 class");
                break;
            case 7:
                System.out.println("Comfort type: Obschiy");
                break;
        }

        System.out.println("Number of people: " + String.valueOf(wagon.people));
        System.out.println("Number of luggage: " + String.valueOf(wagon.luggage));
        System.out.println("********************************************");
    }

    public boolean equals( Wagon n2){
        if(this instanceof Wagon && n2 instanceof Wagon) {
            if (this.getNumberWag() == n2.getNumberWag() && +
                    this.getComfort() == n2.getComfort() && +
                    this.getLuggage() == n2.getLuggage() && +
                    this.getPeople() == n2.getPeople())
                return true;
            else return false;
        }else  return false;
    }
    public abstract boolean isSit();
}

