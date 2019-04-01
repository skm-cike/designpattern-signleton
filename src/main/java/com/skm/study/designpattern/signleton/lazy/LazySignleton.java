package com.skm.study.designpattern.signleton.lazy;

import java.io.Serializable;

/**
* @描述: 懒汉式单例
* @作者: 陆华
* @日期: 14:51 2019-04-01 0001
* @修改人:
**/
public class LazySignleton implements Serializable {
    private static LazySignleton INSTANCE;
    private LazySignleton() {
        //防止反射实例化
        if (null != INSTANCE) {
            throw new RuntimeException("已有实例，无法再实例化");
        }
    }

    public static final LazySignleton getInstance() {
        //double check 防止多次初始化的情况下，同时保证性能，避免每次都进锁
        if (null == INSTANCE) {
            synchronized (LazySignleton.class) {
                if (null == INSTANCE) {
                    INSTANCE = new LazySignleton();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * @描述: 防止反序列化破坏单例
     * @return
     */
    private Object readResolve() {
        return INSTANCE;
    }

}
