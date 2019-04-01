package com.skm.study.designpattern.signleton.lazy;


import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

public class LazySignletonTest {
    public static void main(String... args) throws IOException, ClassNotFoundException {
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        try {
            LazySignleton lazySignleton1 = LazySignleton.getInstance();
            out = new ObjectOutputStream(new FileOutputStream("lazySignleton.obj"));
            out.writeObject(lazySignleton1);
            out.flush();
            out.close();

            in = new ObjectInputStream(new FileInputStream("lazySignleton.obj"));
            LazySignleton lazySignleton2 = (LazySignleton)in.readObject();

            System.out.println(lazySignleton1 == lazySignleton2);
        } finally {
            if (null != out) {
                out.close();
            }
            if (null != in) {
                in.close();
            }
        }

    }
}
