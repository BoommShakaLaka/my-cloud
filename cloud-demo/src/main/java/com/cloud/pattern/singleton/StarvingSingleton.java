package com.cloud.pattern.singleton;

import java.lang.reflect.InvocationTargetException;

public class StarvingSingleton {
    private static final StarvingSingleton starvingSingleton = new StarvingSingleton();
    private StarvingSingleton(){ }
    public static StarvingSingleton getInstance(){
        return starvingSingleton;
    }

}

