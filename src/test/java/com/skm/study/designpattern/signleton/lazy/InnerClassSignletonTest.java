package com.skm.study.designpattern.signleton.lazy;


import java.io.*;

public class InnerClassSignletonTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InnerClassSignleton instance1 = InnerClassSignleton.getInstance();
        InnerClassSignleton instance2;
        String fileName = "innerClassSignleton.obj";
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            out.writeObject(instance1);
            out.flush();
            out.close();

            instance2 = (InnerClassSignleton)in.readObject();
            System.out.println(instance1 == instance2);
        }
    }
}
