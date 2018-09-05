package com.swabhavtechlabs.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Foo foo = new Foo();
		Class cls = foo.getClass();
		Object obj = cls.newInstance();
		
		Method[] methods = cls.getMethods();
		int proTypeFail=0, proTypePass =0;
		
		
		
		for(Method method: methods) {
			if(method.isAnnotationPresent(ProType.class)) {
				if((boolean) method.invoke(obj, new String())) {
					proTypePass++;
				}else {
					proTypeFail++;
				}
			}
		}
		System.out.println("Pro test pass "+proTypePass);
		System.out.println("Pro test fail "+proTypeFail);
	}

}
