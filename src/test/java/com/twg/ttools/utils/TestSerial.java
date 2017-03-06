package com.twg.ttools.utils;

import java.io.*;

/**
 * Created by twg on 2017/3/7.
 */
public class TestSerial implements Serializable {
    private static final long serialVersionUID = -3608524995607589200L;
    private String name;
    private String address;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address =address;
    }
}


class SerialVersionUIDTest{
    public static void main(String[] args) throws Exception{
        TestSerial person = new TestSerial();
        person.setName("hackingwu");
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("test"));
        oo.writeObject(person);
        oo.close();
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("test"));
        TestSerial person_back = (TestSerial)oi.readObject();
        System.out.println("HI,My name is "+person_back.getName());
        oi.close();
    }
}

