package com.skm.study.designpattern.signleton.register;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
* @描述: 容器式单例
* @作者: 陆华
* @日期: 15:57 2019-04-01 0001
* @修改人:
**/
public class ContainerSignleton implements Serializable {
    private final static Map<String, Object> maps = new ConcurrentHashMap<>();
    private ContainerSignleton() {
        //这里不做反射破坏单例判断。因为maps本身是final ,static的，属于饿汉式，不会生成多个。其内部的对象不在这里初始化。
        //如果maps本身做成懒汉式，那么需要在这里做防止反射破坏单例
    }

    //测试maps是否会出现多个
    //仅做测试使用
    public static final Object getMaps() {
        return maps;
    }

    //readResolve只能用到被单例的对象中，其该对象的类必须是序列化的
//    public Object readResolve() {
//        return maps;
//    }

    public static final Object get(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object rtn = maps.get(className);

        //双重检查，保证单例的情况下同时保证性能
        if (null == rtn) {
            synchronized (ContainerSignleton.class) {
                if (null == rtn) {
                    maps.put(className, Class.forName(className).newInstance());
                    rtn = maps.get(className);
                }
            }
        }
        return rtn;
    }
}
