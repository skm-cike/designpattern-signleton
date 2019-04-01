package com.skm.study.designpattern.signleton.register;


import java.io.*;

public class EnumSignletonTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        EnumSignleton enumSignleton = EnumSignleton.getInstance();
        enumSignleton.setObj(new Object());
        Object obj1 = enumSignleton.getObj();
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