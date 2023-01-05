package org.mattcouts;

import org.mattcouts.entity.Person;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        // getting a class using getClass()
        String hello = "Hello";
        Class<?> stringClass = hello.getClass();
        System.out.println("Simple name: " + stringClass.getSimpleName());
        System.out.println("Canonical name: " + stringClass.getCanonicalName());

        // getting a class using Class.class
        stringClass = String.class;
        System.out.println("Simple name: " + stringClass.getSimpleName());

        // getting a class using class name
        stringClass = Class.forName("java.lang.String");
        System.out.println("Simple name: " + stringClass.getSimpleName());

        // getting a class' super class
        Class<?> stringSuperClass = stringClass.getSuperclass();
        System.out.println("Super class simple name: " + stringSuperClass.getSimpleName());

        // getting an array of a class' declared fields
        Field[] fields = stringClass.getDeclaredFields();
        System.out.println(Arrays.asList(fields));

        // getting specific declared fields using their name
        Person person = new Person();
        Field firstNameField = person.getClass().getDeclaredField("firstName");
        Field lastNameField = person.getClass().getDeclaredField("lastName");

        try {
            // setting the private field as accessible
            firstNameField.setAccessible(true);
            // setting the field's value
            firstNameField.set(person, "Matt");
            System.out.println("First name: " + firstNameField.get(person));
        } catch (IllegalAccessException e) {
            // this will not be executed because the field was set as accessible
            System.out.println("You cannot access this field");
        }

        try {
            // setting the field's value
            lastNameField.set(person, "Couts");
            System.out.println("Last name: " + lastNameField.get(person));
        } catch (IllegalAccessException e) {
            // this will be executed because lastName is a private field and was never set as accessible
            System.out.println("You cannot access this field");
        }
    }
}
