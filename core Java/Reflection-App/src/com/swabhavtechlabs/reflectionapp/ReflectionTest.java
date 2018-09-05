package com.swabhavtechlabs.reflectionapp;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionTest {
	public static void main(String args[]) throws NoSuchMethodException, SecurityException {
		Reflection reflection = new Reflection();
		Class objectClass = Object.class;
		
		Constructor[] constructor = reflection.getConstructor(objectClass);
		for(Constructor con: constructor) {
			System.out.println("Constructor = "+con.getName());
		}
		System.out.println("Number of constructor are = "+constructor.length);
		Method[] methods = reflection.getMethods(objectClass);
		System.out.println("Diffrent methods of Rectangle class are");
		for(Method method: methods) {
				System.out.println("Method = "+method.getName());
		}
		System.out.println("Number of methods are = "+methods.length);
		int noOfGetAndSet = reflection.gettersAndSetters(objectClass);
		System.out.println("Number of getters and setters = " +noOfGetAndSet);
	}
}
