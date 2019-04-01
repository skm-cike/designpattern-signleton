package com.skm.study.designpattern.signleton.register;

import java.io.*;

/**
* @描述: 枚举容器式测试
* @作者: 陆华
* @日期: 16:32 2019-04-01 0001
* @修改人:
**/
public class ContainerEnumSignletonTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Object obj1 = ContainerEnumSignleton.getInstance().getMaps();
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