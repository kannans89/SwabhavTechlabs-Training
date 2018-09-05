package com.swabhavtechlabs.reflectionapp;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Reflection {
	public Constructor[] getConstructor(Class class1) throws NoSuchMethodException, SecurityException {
		Constructor[] constructor = class1.getDeclaredConstructors();
		return constructor;
	}
	
	public Method[] getMethods(Class class1) throws NoSuchMethodException, SecurityException {
		Method[] methods = class1.getMethods();
		return methods;
	}
	
	public int gettersAndSetters(Class class1) throws NoSuchMethodException, SecurityException {
		Method[] methods = null;
		int i = 0;
		for(Method method: class1.getMethods()) {
			if(method.getName().startsWith("get") || method.getName().startsWith("set")) {
				System.out.println("Getters ans Setters:"+method.getName());
				i++;
			}			
		}
		return i;
	}
}
