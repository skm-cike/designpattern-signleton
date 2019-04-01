package com.skm.study.designpattern.signleton.hungry;

import java.io.Serializable;

/**
* @描述: 饿式单例
* @作者: 陆华
* @日期: 14:50 2019-04-01 0001
* @修改人:
**/
public class HungrySignleton implements Serializable {
    private final static HungrySignleton INSTANCE = new HungrySignleton();
    private HungrySignleton() {
        if (null != INSTANCE) {
            throw new RuntimeException("防止反射破坏单例");
        }
    }
    public final static HungrySignleton getInstance() {
        return INSTANCE;
    }

    /**
     * @描述: 饿汉式单例同样会被反序列化破坏,使用readResolve解决反序列化破坏
     * @return
     */
    private Object readResolve() {
        return INSTANCE;
    }
}
