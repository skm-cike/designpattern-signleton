package com.skm.study.designpattern.signleton.hungry;


import java.io.*;

/**
* @描述: 恶汉式单例测试
* @作者: 陆华
* @日期: 16:16 2019-04-01 0001
* @修改人:
**/
public class HungrySignletonTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Object obj1 = HungrySignleton.getInstance();
        Object obj2 = null;
        String fileName = "hungrySingleton.obj";
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