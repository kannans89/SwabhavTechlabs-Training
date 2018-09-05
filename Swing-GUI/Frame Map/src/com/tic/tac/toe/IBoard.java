package com.tic.tac.toe;

import java.util.HashMap;

public interface IBoard {
	public boolean isBoardFull();
	public void addCell(Integer position, Mark mark);
	public HashMap<Integer, Cell> getBoard();
	public int getMaxSize();
	public int getBoardType();
	public boolean isCellEmpty(int position);
	public boolean isBoardClear();
	public void setBoard(HashMap<Integer, Cell> board);
}
