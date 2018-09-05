package com.tic.tac.toe;

import java.util.HashMap;

public class ResultAnalyser {
	int counterX, counterO, maxSize, boardType;
	GameStatus status = null;
	HashMap<Integer, Cell> TicTacToeBoard;
	IBoard board;

	public ResultAnalyser(IBoard board) {
		this.board = board;
		this.counterO = 0;
		this.counterX = 0;
		this.TicTacToeBoard = board.getBoard();
		this.maxSize = board.getMaxSize();
		this.boardType = board.getBoardType();
	}

	public GameStatus analyseBoard(IBoard board) {
		if (analyseHorizontally(board) || analysevertically(board) || analyseDiagonally(board))
			return checkWhoIsWinner();
		else if (board.isBoardFull() && !((this.counterO == boardType) || (this.counterX == boardType)))
			return GameStatus.DRAW;
		else
			return GameStatus.PROGRESS;
	}

	private GameStatus checkWhoIsWinner() {
		if (this.counterO == boardType) {
			return GameStatus.O_WON;
		} else {
			return GameStatus.X_WON;
		}
	}

	public boolean analyseHorizontally(IBoard board) {
		int i;
		for (i = 0; i <= maxSize - boardType; i = i + boardType) {
			this.counterO = 0;
			this.counterX = 0;
			if (checkRow(board, i))
				return true;
		}
		return false;
	}

	public boolean checkRow(IBoard board, int i) {
		for (int j = 0; j < boardType; j++)
			if (TicTacToeBoard.get(i + j).getMark() != Mark.EMPTY)
				increment(i + j);
		if (this.counterO == boardType || this.counterX == boardType)
			return true;
		return false;
	}

	public boolean analysevertically(IBoard board) {
		int i;
		this.counterX = 0;
		this.counterO = 0;
		for (i = 0; i < boardType; i++) {
			this.counterX = 0;
			this.counterO = 0;
			if (checkColumn(board, i))
				return true;
		}
		return false;
	}

	public boolean checkColumn(IBoard board, int i) {
		for (int j = 0; j <= maxSize - boardType; j = j + boardType)
			if (TicTacToeBoard.get(i + j).getMark() != Mark.EMPTY)
				increment(i + j);

		if (this.counterO == boardType || this.counterX == boardType)
			return true;
		return false;
	}

	public boolean analyseDiagonally(IBoard board) {
		int j;
		this.counterO = 0;
		this.counterX = 0;
		for (j = 0; j <= maxSize; j = j + (boardType + 1))
			if (TicTacToeBoard.get(j).getMark() != Mark.EMPTY)
				increment(j);
			else
				return false;
		if (this.counterX == boardType || this.counterO == boardType)
			return true;
		return oppositeDiagonal(board);
	}

	public boolean oppositeDiagonal(IBoard board) {
		int i;
		this.counterO = 0;
		this.counterX = 0;
		for (i = boardType - 1; i <= maxSize - boardType; i = i + (boardType - 1))
			if (TicTacToeBoard.get(i).getMark() != Mark.EMPTY)
				increment(i);
			else
				return false;
		return checkWinner();
	}

	private boolean checkWinner() {
		if (this.counterX == boardType || this.counterO == boardType)
			return true;
		return false;
	}

	private void increment(int i) {
		if (TicTacToeBoard.get(i).getMark() == Mark.O) {
			this.counterO++;
		} else {
			this.counterX++;

		}
	}
}
