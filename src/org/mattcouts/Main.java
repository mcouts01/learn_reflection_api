package org.mattcouts;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
	    // write your code here
        String hello = "Hello";
        Class<?> helloClass = hello.getClass();
        System.out.println("Simple name: " + helloClass.getSimpleName());
        System.out.println("Canonical name: " + helloClass.getCanonicalName());

        Class<?> stringClass = String.class;
        System.out.println("Simple name: " + stringClass.getSimpleName());

        stringClass = Class.forName("java.lang.String");
        System.out.println("Simple name: " + stringClass.getSimpleName());

        Class<?> stringSuperClass = stringClass.getSuperclass();
        System.out.println("Super class simple name: " + stringSuperClass.getSimpleName());

        Field[] fields = stringClass.getDeclaredFields();
        System.out.println(Arrays.asList(fields));
    }
}
