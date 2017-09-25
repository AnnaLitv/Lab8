package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by Anna-PC on 22.09.2017.
 */
public class SerialTest {
    @Test
    public void deserIn() throws Exception {
        SetWag sw = new SetWag();
        sw.add(new WagonSit(1,2,23,45));
        sw.add(new WagonSleep(2,3,67,78));
        sw.add(new WagonSit(3,4,56,34));
        sw.add(new WagonSit(4,7,89,90));
        Serial ser = new Serial();
        ser.serIn(sw,"testser","ser");
        SetWag sw2 = new SetWag();
        sw2 = (SetWag)ser.DeserIn("testser","ser");
        int num = 0;
        for(int i=0;i<4;i++){
            if(sw.equals(sw.get(i),sw2.get(i)))
                num++;
        }
        assertEquals(4,num);
    }

    @Test
    public void deserInObj() throws Exception {
    }


    @Test
    public void parse() throws Exception {
        SetWag sw = new SetWag();
        sw.add(new WagonSit(1,2,23,45));
        sw.add(new WagonSleep(2,3,67,78));
        sw.add(new WagonSit(3,4,56,34));
        sw.add(new WagonSit(4,7,89,90));
        Serial ser = new Serial();
        ser.WriteText(sw,"testText.ser");
        SetWag sw1 = new SetWag();
        sw1=ser.parse(ser.ReadText("testText.ser"));
        int num=0;
        for(int i=0;i<4;i++){
            if(sw.equals(sw.get(i),sw1.get(i)))
                num++;
        }
        assertEquals(4,num);
    }

}