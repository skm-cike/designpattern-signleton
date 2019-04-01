package com.skm.study.designpattern.signleton.register;

import java.io.Serializable;

/**
* @描述: 枚举单例 枚举属于常量,其无法生成多个，无法被反射和反序列破坏单例
* @作者: 陆华
* @日期: 15:53 2019-04-01 0001
* @修改人:
**/
public enum EnumSignleton implements Serializable {
    INSTANCE;

    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public final static EnumSignleton getInstance() {
        return INSTANCE;
    }
}
