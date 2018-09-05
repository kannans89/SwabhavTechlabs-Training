package com.swabhavtechlabs.tictactoe.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.swabhavtechlabs.tic.tac.toe.Cell;
import com.swabhavtechlabs.tic.tac.toe.Mark;

class CellTest {
	Cell cell = new Cell();
	Mark mark;
	@Test
	void shouldSetMarkToO() {
		Mark mark = Mark.O;
		cell.setMark(mark);
		assertTrue(cell.getMark() == Mark.O);
	}
	@Test
	void shouldSetMarkToX() {
		Mark mark = Mark.X;
		cell.setMark(mark);
		assertTrue(cell.getMark() == Mark.X);
	}
	
	@Test 
	void shouldGetX(){
		cell.setMark(Mark.X);
		mark = cell.getMark();
		assertTrue(mark == Mark.X);
	}

	@Test
	void shoudGetMarkO() {
		cell.setMark(Mark.O);
		mark = cell.getMark();
		assertTrue(mark == Mark.O);
	}
	
	@Test
	void shouldSetIfEmpty() {
		Cell newCell = new Cell();
		newCell.setMark(Mark.EMPTY);
		newCell.setMark(Mark.O);
		mark = newCell.getMark();
		System.out.println(newCell.getMark());
		assertTrue(mark == Mark.O);
	}
	
	@Test
	void shouldSetToEmpty() {
		cell.setMarkToEmpty();
		assertTrue(cell.getMark() == Mark.EMPTY);
	}
}
