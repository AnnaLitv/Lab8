package com.company;

/**
 * Created by Литвиненко on 30.05.2016.
 */
public class NegativeValueException extends Exception {
    public NegativeValueException(String propertyName){
        initCause(new Throwable("Property " + propertyName + " is negative!"));
    }
}
