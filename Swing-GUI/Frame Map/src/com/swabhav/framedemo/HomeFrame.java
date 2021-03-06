package com.swabhav.framedemo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tic.tac.toe.Mark;
import com.tic.tac.toe.Player;

public class HomeFrame extends JFrame{
	String[] playersName;
	String[] playersMark;
	JTextField player1Name, player2Name, player1Mark, player2Mark;
	JButton playButton;
	public HomeFrame(String title) {
		setLayout(new BorderLayout());
		setTitle(title);
		setSize(600, 300);
		JPanel northPanel = new JPanel(new GridLayout(2, 1));
		
		JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titlePanel.add(new JLabel("Play Tic Tac Toe"));
		northPanel.add(titlePanel);
		
		JLabel label = new JLabel("Players details");
		label.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		JPanel namePanel = new JPanel(new GridLayout(4,1));
		namePanel.setAlignmentX(CENTER_ALIGNMENT);
		
		this.playersName = new String[2];
		this.playersMark = new String[2];
		
		JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
		playButton = new JButton("Start game");
		buttonPanel.add(playButton);
		
		getPlayersDetails();
		JLabel player1 = new JLabel("Player 1: "+playersName[0]);
		JLabel player2 = new JLabel("Player 2: "+playersName[1]);
		JLabel mark1 = new JLabel("Player 1 mark: "+playersMark[0]);
		JLabel mark2 = new JLabel("Player 2 mark: "+playersMark[1]);
		
		player1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		player2.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		mark1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		mark2.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		namePanel.add(player1);
		namePanel.add(player2);
		namePanel.add(mark1);
		namePanel.add(mark2);
		
		northPanel.add(namePanel);
		northPanel.add(buttonPanel);
		add(northPanel);
		setVisible(true);
	}
	
	public void getPlayersDetails() {
		playersName[0] = JOptionPane.showInputDialog("Player 1 name");
		playersName[1] = JOptionPane.showInputDialog("Player 2 name");
		playersMark[0] = JOptionPane.showInputDialog("Player 1 mark");
		playersMark[1] = JOptionPane.showInputDialog("Player 2 mark");
		checkPlayers();
		playButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TicTacToeFrame("Tic tac toe", playersName, playersMark);
				
			}
		});
	}
	
	public void checkPlayers() {
		if(playersName[0] == null || playersName[1] == null || playersMark[0] == null || playersMark[1] == null) {
			JOptionPane.showMessageDialog(this, "Please enter players details...");
			getPlayersDetails();
		}
	}
}
