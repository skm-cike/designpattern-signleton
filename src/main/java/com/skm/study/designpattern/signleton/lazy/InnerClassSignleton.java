package com.skm.study.designpattern.signleton.lazy;

import java.io.Serializable;

/**
* @描述: 内部类单例  如果没有使用InnerClassSignleton类的话，其内部类是会加载
* @作者: 陆华
* @日期: 15:25 2019-04-01 0001
* @修改人:
**/
public class InnerClassSignleton implements Serializable {
    /**
     * @描述: 防止反射破坏单例
     */
    private InnerClassSignleton() {
        if (null != SignletonClazz.INSTANCE) {
            throw new RuntimeException("不允许多次实例化");
        }
    }

    /**
     * @描述: 防止反序列化破坏单例
     * @return
     */
    private Object readResolve() {
        return getInstance();
    }

    public static final InnerClassSignleton getInstance() {
        return SignletonClazz.INSTANCE;
    }

    private static class SignletonClazz {
        private final static InnerClassSignleton INSTANCE = new InnerClassSignleton();
    }
}
