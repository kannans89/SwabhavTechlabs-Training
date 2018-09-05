package com.swabhavtechlabs.tic.tac.toe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FourByFourBoard implements IBoard {

	private final int MAX_SIZE = 16;
	private final int BOARD_TYPE = 4;
	private HashMap<Integer, Cell> board;

	public FourByFourBoard() {
		this.board = new HashMap<>();
		for (int i = 0; i < MAX_SIZE; i++) {
			Cell cell = new Cell();
			board.put(i, cell);
		}
	}

	@Override
	public boolean isBoardFull() {
		Set<Map.Entry<Integer, Cell>> setView = board.entrySet();
		for (Map.Entry<Integer, Cell> entry : setView) {
			if (entry.getValue().getMark() == Mark.EMPTY) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void addCell(Integer key, Mark mark) {
		if (board.get(key).getMark() == Mark.EMPTY) {
			Cell cell = board.get(key);
			cell.setMark(mark);
			board.put(key, cell);
		}
	}

	@Override
	public HashMap<Integer, Cell> getBoard() {
		return this.board;
	}

	@Override
	public int getMaxSize() {
		return this.MAX_SIZE;
	}

	@Override
	public int getBoardType() {
		return this.BOARD_TYPE;
	}

	@Override
	public void setBoard(HashMap<Integer, Cell> board) {

	}

	@Override
	public boolean isCellEmpty(int position) {
		if (position >= MAX_SIZE)
			return false;
		if (board.get(position).getMark() == Mark.EMPTY)
			return true;
		return false;
	}

	@Override
	public boolean isBoardClear() {
		Set<Map.Entry<Integer, Cell>> setView = board.entrySet();
		for (Map.Entry<Integer, Cell> entry : setView)
			if (entry.getValue().getMark() != Mark.EMPTY)
				return false;
		return true;
	}
}
