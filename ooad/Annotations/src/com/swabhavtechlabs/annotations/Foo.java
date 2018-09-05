package com.swabhavtechlabs.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Foo {
	
	@ProType
	public boolean a(String a) {
		return true;
	}
	
	@ProType
	public boolean b(String b) {
		return true;
	}
	
	@ProType
	public boolean c(String c) {
		return false;
	}
	
	@ProType
	public boolean d(String d) {
		return true;
	}
}
