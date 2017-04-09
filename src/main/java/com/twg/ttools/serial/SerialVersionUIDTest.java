package com.twg.ttools.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by twg on 2017/4/5.
 */
public class SerialVersionUIDTest {
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
