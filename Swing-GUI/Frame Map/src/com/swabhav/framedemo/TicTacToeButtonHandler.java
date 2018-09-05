package com.swabhav.framedemo;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.tic.tac.toe.Game;
import com.tic.tac.toe.GameStatus;
import com.tic.tac.toe.Mark;
import com.tic.tac.toe.Player;
import com.tic.tac.toe.ResultAnalyser;
import com.tic.tac.toe.ThreeByThreeBoard;

public class TicTacToeButtonHandler implements ActionListener {

	int position;
	private Mark currentMark;
	private ThreeByThreeBoard board;
	private Player[] players;
	private ResultAnalyser analyser;
	private Game game = null;
	private GameStatus status;
	Container container;
	JPanel panel;
	
	private Icon xIcon = new ImageIcon("/home/manu/Desktop/Swabhav/Swing-GUI/Frame Map/src/x.png");
	private Icon oIcon = new ImageIcon("/home/manu/Desktop/Swabhav/Swing-GUI/Frame Map/src/O.jpg");
		
	public void conStructPlayers(String[] playersMark, String[] playersName) {
		players = new Player[2];
		if(playersMark[0] == "x" || playersMark[0] == "X") {
			players[0] = new Player(Mark.X, playersName[0]);
			players[1] = new Player(Mark.O, playersName[1]);
		} else {
			players[0] = new Player(Mark.O, playersName[0]);
			players[1] = new Player(Mark.X, playersName[1]);
		}
	}
	public TicTacToeButtonHandler(Container container, String[] playersName, String[] playersMark, JPanel statusPanel) {
		board = new ThreeByThreeBoard();
		analyser = new ResultAnalyser(board);
		System.out.println(playersMark == null);
		conStructPlayers(playersMark, playersName);
		this.container = container;
		this.panel = statusPanel;
		game = new Game(board, this.players, analyser);
		game.init();
		status = game.getGameStatus();
		System.out.println(game.getCurrentPlayer().getMark());
		currentMark = game.getCurrentPlayer().getMark();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		String s = e.getActionCommand();
		int position = Integer.parseInt(s);
		if(game.getCurrentPlayer().getMark() == Mark.O) {
			System.out.println("o");
			((AbstractButton) source).setIcon(oIcon);
		}	
		else if(game.getCurrentPlayer().getMark() == Mark.X){
			System.out.println("x");
			((AbstractButton) source).setIcon(xIcon);
		}
		System.out.println(game.getGameStatus());
		callPlay(position);
		setDetails();
		checkStatus();
	}
	
	public void callPlay(int position) {
		game.play(position);
	}
	
	public void setDetails() {
		this.currentMark = game.getCurrentPlayer().getMark();
		this.status = game.getGameStatus();
	}
	
	public void checkStatus() {
		if(status == GameStatus.X_WON) {
			System.out.println("x won");
			panel.removeAll();
			panel.add(new JLabel(this.game.getCurrentPlayer().getName()+" won", SwingConstants.CENTER));
			JOptionPane.showMessageDialog(container, "X won "+game.getCurrentPlayer().getName());
			
		}
		else if(status == GameStatus.O_WON) {
			System.out.println("O won "+game.getCurrentPlayer().getName());
			panel.removeAll();
			panel.add(new JLabel(this.game.getCurrentPlayer().getName()+" won", SwingConstants.CENTER));
			JOptionPane.showMessageDialog(container, "O won "+game.getCurrentPlayer().getName());
			
		}
		else if(status == GameStatus.DRAW) {
			System.out.println("Draw");
			panel.removeAll();
			panel.add(new JLabel("Match draw", SwingConstants.CENTER));
			JOptionPane.showMessageDialog(container, "DRAW");
			
		} else {
			int i = panel.getComponentCount();
			System.out.println(i);
			if(i>=1) {
			
				panel.removeAll();
			}
			panel.add(new JLabel("Game Status= "+status+"", SwingConstants.CENTER));
		}
	}

}
