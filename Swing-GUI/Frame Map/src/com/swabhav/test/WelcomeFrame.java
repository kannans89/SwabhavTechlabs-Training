package com.swabhav.test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class WelcomeFrame extends JFrame {
	private Color lightBlue;
	private JButton redBUtton;
	private JButton greenButton;
	
	public WelcomeFrame(String title) {
		lightBlue = new Color(51, 153, 255);
		setLayout(new FlowLayout());
		setTitle(title);
		setSize(1024, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		redBUtton = new JButton("Red");
		redBUtton.setSize(new Dimension(200, 100));
		greenButton = new JButton("Green");
		greenButton.setSize(new Dimension(200, 100));
		Container contentPane = getContentPane();
		
		redBUtton.addActionListener(new ButtonHandler(contentPane, redBUtton));
		greenButton.addActionListener(new ButtonHandler(contentPane, greenButton));
		add(redBUtton);
		add(greenButton);
		getContentPane().setBackground(Color.RED);
		setVisible(true);
	}
}