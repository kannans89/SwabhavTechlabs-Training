package com.swabhavtechlabs.annotations;

import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) {
		Meta meta = new Meta();
		// AnnotationExample annotation= meta.annotationMethod1();
		// System.out.println(annotation.str() + "\t"+annotation.val());

		Class classObj = Meta.class;
		Method[] methods = classObj.getMethods();
		int i=0;
		for (Method method : methods) {
			NeedsRefactoring annotation = method.getAnnotation(NeedsRefactoring.class);
			if (annotation == null) {
				continue;
			}
			System.out.println("Method name is "+method.getName()+"\t"+annotation);
			i++;
		}
		System.out.println("Number of methods that has NeedsforRefactoring "+i);
	}
}
