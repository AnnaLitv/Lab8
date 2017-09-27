package com.company;
import java.io.Serializable;
import java.util.*;

public class SetWag implements Set<Wagon>,Serializable {

    private int size=0;
    private Node<Wagon> first;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    private Node<Wagon> getByIndex(int index) {
        if(index<size()) {
            Node<Wagon> node = first;
            while (index > 0 && node != null) {
                index--;
                node=node.getNext();
            }
            return node;
        }
        return null;
    }

    public Wagon get(int index) {
        Wagon element;
        if (index >= 0 && index < size()) element = getByIndex(index).getWagon();
        else throw new IndexOutOfBoundsException();
        return element;
    }

    @Override
    public boolean contains(Object o) {
       Wagon wg = (Wagon)o;
        Node<Wagon> wag = null;
        wag=first;
        int i=0;
        while (wag!=null){
            if(get(i).equals(wg))
            return  true;
            wag = wag.getNext();
            i++;
        }
        return false;
    }

    @Override
    public Iterator<Wagon> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = getByIndex(i).getWagon();
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {

        return null;
    }

    @Override
    public boolean add(Wagon wagon) {
        if(wagon!=null) {
            Node<Wagon> node = null;
            if (first == null || size() == 0) {
                node = new Node<>(wagon);
                first = node;
            } else {
                Node tmp = new Node<>(wagon);
                tmp.setNext(first);
                first = tmp;
            }
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
       if(o != null){
           Wagon wg = (Wagon)o;
           Node<Wagon> wag;
           wag=first;
           int i=0;
           if(get(i).equals(wg)){
               first = first.getNext();
               size--;
               return  true;
           }
           else {
               i++;
               while (wag.hasNext()) {
                   if (get(i).equals(wg))
                   {
                       wag.setNext(wag.getNext().getNext());
                       size--;
                       return true;
                   }
                   wag = wag.getNext();
                   i++;
               }
           }
       }
       return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if(c!=null) {
            SetWag set = (SetWag) c;
            for (int i = set.size() - 1; i >= 0; i--) {
                if (!contains(set.get(i))) {
                    remove(set.get(i));
                }
            }
            return true;
        }else return false;
    }

    @Override
    public boolean removeAll(Collection<? > c) {
        if(c!=null) {
            SetWag set = (SetWag) c;
            for (int i = set.size() - 1; i >= 0; i--) {
                if (contains(set.get(i))) {
                    remove(set.get(i));
                }
            }
            return true;
        }else return false;
    }

    @Override
    public void clear() {
        size=0;
        first=null;
    }

    public void initSetByDefaultValues() {
        add((Wagon) new WagonSit(3,6,34,23));
        add((Wagon) new WagonSit(4,5,34,23));
        add((Wagon) new WagonSleep(5,5,56,34));
        add((Wagon) new WagonSit(6,3,34,23));
        add((Wagon) new WagonSleep(7,4,34,65));
        add((Wagon) new WagonSit(8,2,34,233));
        add((Wagon) new WagonSleep(9,1,335,4));
    }

    public String toString(Wagon wag){
        String  type;
        int comf, peop, lug, numb;
         if (wag.isSit()) {
            type="Sit wagon";
        } else {
            type="Sleep wagon";
        }
        numb=wag.getNumberWag();
        comf=wag.getComfort();
        peop=wag.getPeople();
        lug=wag.getLuggage();
        String result = type+" = {number: "+numb+", comfort: "+comf+", people: "+peop+", luggage: "+lug+" }";
        return result;
    }
    public void print(){
        Wagon wag;
        Node<Wagon> tmp = first;

        System.out.println("Length of array: " + size());
        System.out.println("");
        int i=0;

        while (tmp != null) {
            wag=tmp.getWagon();
            wag.print(get(i));
            tmp = tmp.getNext();
            i++;
        }
    }

    public boolean equals( SetWag sw2){
       if(sw2 instanceof SetWag && this instanceof SetWag){
           if (this.size()==sw2.size()){
               for(int i=0;i<this.size();i++){
                   if(this.get(i).equals(sw2.get(i)))return true;
                   else return false;
               }
           }
       }
       return false;
   }
}
