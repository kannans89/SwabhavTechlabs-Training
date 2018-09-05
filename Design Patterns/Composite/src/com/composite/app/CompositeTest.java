package com.composite.app;

public class CompositeTest {

	public static void main(String[] args) {
		ControlGroup html = new ControlGroup("html");
		ControlGroup body = new ControlGroup("body");
		ControlGroup div = new ControlGroup("div");
		Control p =  new Control("p");
		html.add(body);
		body.add(div);
		div.add(p);
		p.generateHTML();
	}

}
