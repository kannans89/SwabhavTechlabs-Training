package com.composite.app;

import java.util.ArrayList;
import java.util.List;

public class ControlGroup implements IHTMLTag {

	IHTMLTag control = new Control();
	List<IHTMLTag> htmlTags = new ArrayList<>();
	String tagName;
	public ControlGroup() {}
	public ControlGroup(String tag) {
		this.tagName = tag;
	}
	
	@Override
	public void generateHTML() {
		System.out.println("<"+tagName+">");
		for(IHTMLTag control: htmlTags) {
			control.generateHTML();
		}
		System.out.println("</"+tagName+">");
	}
	
	public void add(IHTMLTag control) {
		htmlTags.add(control);
	}
	@Override
	public String getTagName() {
		return this.tagName;
	}
	@Override
	public void setTagName(String tagName) {
		// TODO Auto-generated method stub
		
	}

}
