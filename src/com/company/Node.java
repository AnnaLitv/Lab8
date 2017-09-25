package com.company;
import java.io.Serializable;

public class Node<T> implements Serializable {
    private Node next;
    private Wagon item;

    public Node() {
        this.next = null;
    }

    public Node(Wagon elem) {
        this.item = elem;
        this.next = null;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    public boolean hasNext(){
        return !(next == null);
    }


    public Wagon getWagon() {
        return item;
    }

    public void setWagon(Wagon item) {
        this.item = item;
    }

   /* public Wagon getNumberWag() {
        return item.getNumberWag();
    }*/
}

