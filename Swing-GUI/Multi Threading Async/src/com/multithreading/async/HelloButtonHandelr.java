package com.multithreading.async;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class HelloButtonHandelr implements ActionListener {

	private Container container;
	public HelloButtonHandelr(Container container) {
		this.container = container;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(container, "Hello");
	}

}