package com.swabhavtechlabs.tictactoe.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.swabhavtechlabs.tic.tac.toe.Game;
import com.swabhavtechlabs.tic.tac.toe.GameStatus;
import com.swabhavtechlabs.tic.tac.toe.Mark;
import com.swabhavtechlabs.tic.tac.toe.Player;
import com.swabhavtechlabs.tic.tac.toe.ResultAnalyser;
import com.swabhavtechlabs.tic.tac.toe.ThreeByThreeBoard;

class GameTest {
	ThreeByThreeBoard board = new ThreeByThreeBoard();
	Player[] players = new Player[2];
	ResultAnalyser analyser = new ResultAnalyser(board);
	
	@Test
	void shouldSwitchPlayerToPlayer2() {
		players[0] = new Player(Mark.X, "player1");
		players[1] = new Player(Mark.O, "player2");
		Game game = new Game(board, players, analyser);
		game.init();
		assertTrue(game.switchPlayer() == players[1]);
	}
	
	@Test
	void shouldSwitchPlayerToPlayer1() {
		players[0] = new Player(Mark.X, "player1");
		players[1] = new Player(Mark.O, "player2");
		Game game = new Game(board, players, analyser);
		game.init();
		game.setCurrentPlayer(players[1]);
		assertTrue(game.switchPlayer() == players[0]);
	}

	@Test
	void shouldResultStatusIsX_WON() {
		players[0] = new Player(Mark.X, "player1");
		players[1] = new Player(Mark.O, "player2");
		Game game = new Game(board, players, analyser);
		game.init();
		for (int i = 0; i < 3; i++) {
			board.addCell(i, Mark.X);
		}
		GameStatus status = game.play(4);
		assertTrue(status == GameStatus.X_WON);
	}
	
	@Test
	void shouldResultStatusIsO_WON() {
		players[0] = new Player(Mark.X, "player1");
		players[1] = new Player(Mark.O, "player2");
		Game game = new Game(board, players, analyser);
		game.init();
		for (int i = 0; i < 3; i++) {
			board.addCell(i, Mark.O);
		}
		GameStatus status = game.play(4);
		assertTrue(status == GameStatus.O_WON);
	}
	
	@Test
	void shouldResultStatusIsBoard_Full() {
		players[0] = new Player(Mark.X, "player1");
		players[1] = new Player(Mark.O, "player2");
		Game game = new Game(board, players, analyser);
		game.init();
		for (int i = 0; i < board.getMaxSize(); i++) {
			if(i == 0 || i==1 || i==5 || i==6)
				board.addCell(i, Mark.X);
			if(i==8)
				break;
			board.addCell(i, Mark.O);
		}
		GameStatus status = game.play(8);
		assertTrue(status == GameStatus.DRAW);
	}
	
	@Test
	void shouldResultStatusIsProgress() {
		players[0] = new Player(Mark.X, "player1");
		players[1] = new Player(Mark.O, "player2");
		Game game = new Game(board, players, analyser);
		game.init();
		
		board.addCell(0, Mark.X);
		GameStatus status = game.play(1);
		assertTrue(status == GameStatus.PROGRESS);
	}
}
