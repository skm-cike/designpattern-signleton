package com.skm.study.designpattern.signleton.register;

import java.io.*;

public class ContainerSignletonTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Object obj1 = ContainerSignleton.getMaps();
        Object obj2;
        //测试饿汉式是否会被单例破坏
        String fileName = "ContainerSignletonTest.obj";
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            out.writeObject(obj1);
            out.flush();
            out.close();

            obj2 = in.readObject();

            System.out.println(obj1 == obj2);
        }
    }
}
