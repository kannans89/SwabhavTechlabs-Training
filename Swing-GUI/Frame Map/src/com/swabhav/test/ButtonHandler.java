package com.swabhav.test;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonHandler implements ActionListener {

	private Container container;
	private JButton button;
	public ButtonHandler(Container container, JButton button) {
		this.container = container;
		this.button = button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		System.out.println(source);
		if(source.equalsIgnoreCase("RED")) {
			System.out.println("Width: "+button.getWidth()+"\nHeight: "+button.getWidth());
			container.setBackground(Color.RED);
		} else {
			System.out.println("Width: "+button.getWidth()+"\nHeight: "+button.getWidth());
			container.setBackground(Color.GREEN);
		}
	}

}
