package com.swabhavtechlabs.tictactoe.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.swabhavtechlabs.tic.tac.toe.ThreeByThreeBoard;
import com.swabhavtechlabs.tic.tac.toe.Cell;
import com.swabhavtechlabs.tic.tac.toe.Mark;
import com.swabhavtechlabs.tic.tac.toe.Player;

class BoardTest {
	HashMap<Integer, Cell> newBoard = new HashMap<>(9);
	ThreeByThreeBoard board = new ThreeByThreeBoard();

	@Test
	void shouldTestIsBoardFull() {
		for (int i = 0; i < board.getMaxSize(); i++) {
			board.addCell(i, Mark.O);
		}
		assertTrue(board.isBoardFull() == true);
	}

	@Test
	void shouldTestBoardIsNotFull() {
		for (int i = 0; i < board.getMaxSize() - 3; i++) {
			board.addCell(i, Mark.O);
		}
		assertTrue(board.isBoardFull() == false);
	}

	@Test
	void shouldCellEmpty() {
		for (int i = 0; i < board.getMaxSize() - 3; i++) {
			board.addCell(i, Mark.O);
		}
		assertTrue(board.isCellEmpty(8) == true);
	}

	@Test
	void shouldNotMarkIfAlreadyMarked() {
		for (int i = 0; i < board.getMaxSize() - 3; i++) {
			board.addCell(i, Mark.O);
		}
		assertTrue(board.isCellEmpty(5) == false);
	}
	
	@Test
	void testToCheckIfBoardIsClear() {
		for (int i = 0; i < board.getMaxSize(); i++) {
			board.addCell(i, Mark.EMPTY);
		}
		assertTrue(board.isBoardClear() == true);
	}
	
	@Test
	void testToCheckIfBoardIsNotClear() {
		for (int i = 0; i < board.getMaxSize(); i++) {
			if(i==0)
				board.addCell(i, Mark.O);
			else
				board.addCell(i, Mark.EMPTY);
		}
		assertTrue(board.isBoardClear() == false);
	}
}
