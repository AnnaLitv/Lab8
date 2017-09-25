package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by Anna-PC on 09.09.2017.
 */
public class Serial implements Serializable{

    public  void serIn(Object obj, String file_name, String format){
        try {
            FileOutputStream fileOut = new FileOutputStream(file_name + "." + format);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            fileOut.close();
            out.close();
        } catch (FileNotFoundException var5) {
            System.out.println("File not found!");
            System.exit(1);
        } catch (IOException var6) {
            System.out.println("Errors input/output!");
            System.exit(2);
        }

    }
    public static Object DeserIn(String file_name, String format) {
        Object retObj = null;

        try {
            FileInputStream fileIn = new FileInputStream(file_name + "." + format);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            retObj = in.readObject();
            fileIn.close();
            in.close();
        } catch (FileNotFoundException var5) {
            System.out.println("File not found!");
            System.exit(1);
        } catch (IOException var6) {
            System.out.println("Errors input/output!");
            System.exit(2);
        } catch (ClassNotFoundException var7) {
            System.out.println("Class not found!");
            System.exit(3);
        }

        return retObj;
    }

    public void SerObj(SetWag set, String file_name, String format,int num){
        try {
            FileOutputStream fileOut = new FileOutputStream(file_name + "." + format);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for(int i=0;i<num;i++){
                out.writeObject(set.get(i));
            }
            //out.writeObject(obj);
            fileOut.close();
            out.close();
        } catch (FileNotFoundException var5) {
            System.out.println("File not found!");
            System.exit(1);
        } catch (IOException var6) {
            System.out.println("Errors input/output!");
            System.exit(2);
        }
    }
    public static SetWag DeserInObj(String file_name, String format) {
        Object retObj = null;
        SetWag set = new SetWag();
        Node<Wagon> first= null ;
        Wagon wagon;
        try {
            FileInputStream fileIn = new FileInputStream(file_name + "." + format);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            while (in.available()>=0) {
                retObj = in.readObject();
                wagon = (Wagon) in.readObject();
                set.add(wagon);
            }
            fileIn.close();
            in.close();
        } catch (FileNotFoundException var5) {
            System.out.println("File not found!");
            System.exit(1);
        } catch (IOException var6) {
            System.out.println("Errors input/output!");
            System.exit(2);
        } catch (ClassNotFoundException var7) {
            System.out.println("Class not found!");
            System.exit(3);
        }

        return set;
    }

    public void WriteText(SetWag set, String name){
        int num = set.size();
        try{
            FileWriter fw = new FileWriter(name);
            for(int i=num-1;i>=0;i--){
                fw.write(set.toString(set.get(i))+"\r\n");
                //fw.write(" ");
            }
            fw.close();
        }catch (IOException ex){
            System.out.println("Errors input/output!");
            System.exit(2);
        }
    }
    public ArrayList<String> ReadText(String name) {
        ArrayList<String> lines=new ArrayList<>() ;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(name), Charset.forName("UTF-8")));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Errors input/output!");
        }

        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Errors input/output!");
        }
       /* for (String linses: lines){
            System.out.println(linses);
        }*/
        return lines;
    }
    public SetWag parse(ArrayList<String> arr){
        SetWag set = new SetWag();
        String str;
        for (String line: arr){
            str=line;
            int number,people,luggage,comfort;
            int com,dots;
            String pod;
                dots=str.indexOf(":");
                com=str.indexOf(",");
                pod=str.substring(dots+2,com);
                number=Integer.parseInt(pod);
                dots=str.indexOf(":",dots+1);
                com=str.indexOf(",",com+1);
                pod=str.substring(dots+2,com);
                comfort=Integer.parseInt(pod);
                dots=str.indexOf(":",dots+1);
                com=str.indexOf(",",com+1);
                pod=str.substring(dots+2,com);
                people=Integer.parseInt(pod);
                dots=str.indexOf(":",dots+1);
                com=str.indexOf("}",com+1);
                pod=str.substring(dots+2,com-1);
                luggage=Integer.parseInt(pod);
            if(str.contains("Sit wagon")){
                WagonSit ws = new WagonSit(number,comfort,people,luggage);
                set.add(ws);
            }else if(str.contains("Sleep wagon")){
                WagonSleep wsl = new WagonSleep(number,comfort,people,luggage);
                set.add(wsl);
            }
        }
        return set;
    }
}
