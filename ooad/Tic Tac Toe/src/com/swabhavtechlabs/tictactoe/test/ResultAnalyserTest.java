package com.swabhavtechlabs.tictactoe.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.swabhavtechlabs.tic.tac.toe.ThreeByThreeBoard;
import com.swabhavtechlabs.tic.tac.toe.IBoard;
import com.swabhavtechlabs.tic.tac.toe.Mark;
import com.swabhavtechlabs.tic.tac.toe.Player;
import com.swabhavtechlabs.tic.tac.toe.ResultAnalyser;

class ResultAnalyserTest {
	IBoard board = new ThreeByThreeBoard();
	ResultAnalyser analyser = new ResultAnalyser(board);
	Player currentPlayer = new Player(Mark.X, "player1");
	ThreeByThreeBoard TTboard = new ThreeByThreeBoard();
	
	@Test
	void checkRowShouldGiveWinner() {
		board.addCell(3, currentPlayer.getMark());
		board.addCell(4, currentPlayer.getMark());
		board.addCell(5, currentPlayer.getMark());
		assertTrue((analyser.checkRow(board, 3) == true));
	}
	
	@Test
	void checkRowShouldNotGiveWinner() {
		board.addCell(3, currentPlayer.getMark());
		board.addCell(4, currentPlayer.getMark());
		board.addCell(7, currentPlayer.getMark());
		assertTrue((analyser.checkRow(board, 3) == false));
	}
	
	@Test
	void checkColumnShouldGiveWinner() {
		board.addCell(0, currentPlayer.getMark());
		board.addCell(3, currentPlayer.getMark());
		board.addCell(6, currentPlayer.getMark());
		assertTrue((analyser.checkColumn(board, 0) == true));
	}
	
	@Test
	void checkColumnShouldNotGiveWinner() {
		board.addCell(0, currentPlayer.getMark());
		board.addCell(3, currentPlayer.getMark());
		board.addCell(7, currentPlayer.getMark());
		assertTrue((analyser.checkColumn(board, 0) == false));
	}
	
	@Test
	void testAnalyseFirstRow() {
		board.addCell(0, currentPlayer.getMark());
		board.addCell(1, currentPlayer.getMark());
		board.addCell(2, currentPlayer.getMark());
		assertTrue((analyser.analyseHorizontally(board) == true));
	}
	
	@Test
	void testAnalyseSecondRow() {
		board.addCell(3, currentPlayer.getMark());
		board.addCell(4, currentPlayer.getMark());
		board.addCell(5, currentPlayer.getMark());
		assertTrue((analyser.analyseHorizontally(board) == true));
	}
	
	@Test
	void testAnalyseThirdRow() {
		board.addCell(6, currentPlayer.getMark());
		board.addCell(7, currentPlayer.getMark());
		board.addCell(8, currentPlayer.getMark());
		assertTrue((analyser.analyseHorizontally(board) == true));
	}

	@Test
	void testAnalyseFirstColumn() {
		board.addCell(0, currentPlayer.getMark());
		board.addCell(3, currentPlayer.getMark());
		board.addCell(6, currentPlayer.getMark());
	
		assertTrue((analyser.analysevertically(board) == true));
	}
	
	@Test
	void testAnalyseSecondColumn() {
		board.addCell(1, currentPlayer.getMark());
		board.addCell(4, currentPlayer.getMark());
		board.addCell(7, currentPlayer.getMark());
		assertTrue((analyser.analysevertically(board) == true));
	}
	
	@Test
	void testAnalyseThirdColumn() {
		board.addCell(2, currentPlayer.getMark());
		board.addCell(5, currentPlayer.getMark());
		board.addCell(8, currentPlayer.getMark());
		assertTrue((analyser.analysevertically(board) == true));
	}
	
	
	@Test
	void testAnalyseDiagonalOne() {
		board.addCell(0, currentPlayer.getMark());
		board.addCell(4, currentPlayer.getMark());
		board.addCell(8, currentPlayer.getMark());
		assertTrue((analyser.analyseDiagonally(board) == true));
	}
	
	@Test
	void testAnalyseDiagonalTwo() {
		board.addCell(2, currentPlayer.getMark());
		board.addCell(4, currentPlayer.getMark());
		board.addCell(6, currentPlayer.getMark());
		assertTrue((analyser.oppositeDiagonal(board) == true));
	}
}
