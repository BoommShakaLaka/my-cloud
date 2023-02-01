package com.cloud.basic.reject;

import com.cloud.pojo.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RejectDemo {

    public static void main(String[] args) throws ClassNotFoundException {
//        1、通过对象获取class对象
        User user = new User();
        Class<? extends User> clazz = user.getClass();
//        2、通过某个类的class属性获取Class对象
        Class<User> clazz1 = User.class;
//        3、调用 Class 类中的 forName 静态方法以获取该类对应的 Class 对象，这是最安全、 性能也最好的方法
        Class<?> clazz2 = Class.forName("com.cloud.pojo.User");


//      获取 Person 类的所有方法的信息
        Method[] method = clazz.getDeclaredMethods();
        for (Method m : method) {
            System.out.println(m.toString());
        }
//      获取 Person类的所有成员的属性信息
        Field[] field = clazz.getDeclaredFields();
        for (Field f : field) {
            System.out.println(f.toString());

        }
//      获取 Person 类的所有构造方法的信息
        Constructor[] constructor = clazz.getDeclaredConstructors();
        for (Constructor c : constructor) {
            System.out.println(c.toString());
        }
    }
}
