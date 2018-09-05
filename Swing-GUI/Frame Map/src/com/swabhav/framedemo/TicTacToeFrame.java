package com.swabhav.framedemo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tic.tac.toe.Game;
import com.tic.tac.toe.GameStatus;
import com.tic.tac.toe.Mark;
import com.tic.tac.toe.Player;
import com.tic.tac.toe.ResultAnalyser;
import com.tic.tac.toe.ThreeByThreeBoard;

public class TicTacToeFrame extends JFrame {
	JButton[] buttons = new JButton[9];
	String[] playersName, playersMark;
	TicTacToeButtonHandler handler;
	JPanel ticTacToePanel, statusPanel;
	
	public TicTacToeFrame() {
		setLayout(new GridLayout(4, 4));
		setTitle("temp");
		setSize(768, 512);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ticTacToePanel = new JPanel(new GridLayout(3, 3));
		statusPanel = new JPanel(new GridLayout(1, 1));
		statusPanel.add(new JLabel("Progress"));
		
		createButtons(this);
		add(ticTacToePanel);
		add(statusPanel);
		setVisible(true);
	}
	public TicTacToeFrame(String title, String[] playersName, String[] playersMark) {
		setLayout(new GridLayout(2, 2));
		setTitle(title);
		setSize(768, 512);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ticTacToePanel = new JPanel(new GridLayout(3, 3));
		
		statusPanel = new JPanel(new GridLayout(1, 1));
		
		System.out.println((playersMark == null)+" in tic tac toe framew");
		this.playersMark = playersMark;
		this.playersName = playersName;
		handler = new TicTacToeButtonHandler(getContentPane(), playersName, playersMark, statusPanel);
		createButtons(this);
		add(ticTacToePanel);
		add(statusPanel);
		setVisible(true);
	}

	public void createButtons(Container container) {
		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttons[i].setText(i+"");
			ticTacToePanel.add(buttons[i]);
			buttons[i].addActionListener(handler);
		}
	}
	
}
