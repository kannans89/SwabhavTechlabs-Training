package com.swabhavtechlabs.annotations;

import java.lang.reflect.Method;

public class Meta {	
	
	@AnnotationExample(str = "Annotation Example", val = 10)
	public AnnotationExample annotationMethod1() {
		AnnotationExample annotation  = null;
		Meta meta = new Meta();
		try {
			Class<?> object = meta.getClass();
			Method method = object.getMethod("annotationMethod1");
			annotation = method.getAnnotation(AnnotationExample.class);
		} catch(NoSuchMethodException e) {
			e.printStackTrace();
		}
		return annotation;
	}
	
	@NeedsRefactoring
	public void testMethod1() {
		
	}
	
	@NeedsRefactoring
	public void testMethod2() {
		
	}
	
	@NeedsRefactoring
	public void testMethod3() {
		
	}
	
	@NeedsRefactoring
	public void testMethod4() {
		
	}
}
