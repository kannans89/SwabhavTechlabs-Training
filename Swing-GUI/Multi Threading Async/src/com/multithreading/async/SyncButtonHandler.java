package com.multithreading.async;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JLabel;

public class SyncButtonHandler implements ActionListener {

	private JLabel label;
	Container container;
	private Date date;
	
	public SyncButtonHandler(Container container) {
		this.container = container;
		this.date = new Date();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			while(true) {
				long id = Thread.currentThread().getId();
				int newId = (int) id;
				label = new JLabel(id+"");
				container.add(label);
				System.out.println(id);
			}
	}

}
