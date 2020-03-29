package com.tacoxiang.serlizabled;

import com.tacoxiang.pojo.PersonPojo;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : tacoxiang
 * Time : 2020/3/29
 * Package : com.tacoxiang.serlizabled
 * ProjectName: TacoJaScala
 * Describe :
 * ============================================================
 */
public class PersonSerilize {

    private static final String dataPath = PersonSerilize.class.getClassLoader().getResource("conf/data").getPath();


    public static void writePersonObject(PersonPojo personPojo, String file) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(personPojo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PersonPojo readPersonObject(String file) {
        ObjectInputStream ois = null;
        PersonPojo object = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            object = (PersonPojo) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void main(String[] args) {
        PersonPojo personPojo = new PersonPojo("tacoxiang");
        String dataFile = dataPath + "/person.pojo";
        writePersonObject(personPojo, dataFile);
        // PersonPojo{name='tacoxiang'}
        System.out.println(readPersonObject(dataFile));
    }
}

