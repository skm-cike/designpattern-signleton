package com.skm.study.designpattern.signleton.register;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
* @描述: 枚举和容器的集合
* @作者: 陆华
* @日期: 16:30 2019-04-01 0001
* @修改人:
**/
public enum ContainerEnumSignleton implements Serializable {
    INSTANCE;
    private final static Map<String, Object> maps = new HashMap<>();

    public Map<String, Object> getMaps() {
        return maps;
    }

    public Object getData(String className) {
        //这里按照普通的容器式单例写法，使用doublecheck 就可以保证容器内部对象的单例。
        return null;
    }

    public final static ContainerEnumSignleton getInstance() {
        return INSTANCE;
    }
}
