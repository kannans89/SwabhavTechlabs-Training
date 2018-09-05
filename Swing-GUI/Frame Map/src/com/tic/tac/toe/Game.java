package com.tic.tac.toe;

import java.util.HashMap;

public class Game {
	private Player player1 = null;
	private Player player2 = null;
	private Player currentPlayer = null;
	private IBoard board;
	private GameStatus gameStatus;
	private ResultAnalyser analyser = null;

	public Game(IBoard board, Player[] players, ResultAnalyser analyser) {
		this.player1 = players[0];
		this.player2 = players[1];
		this.board = board;
		this.analyser = analyser;
	}

	public void init() {
		this.currentPlayer = player1;
		this.gameStatus = GameStatus.PROGRESS;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public void switchPlayer() {
		if (this.currentPlayer == this.player1) {
			this.currentPlayer = this.player2;
		} else
			this.currentPlayer = this.player1;
	}

	public HashMap<Integer, Cell> getBoard() {
		return board.getBoard();
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	public GameStatus play(int position) {
			board.addCell(position, currentPlayer.getMark());
			this.gameStatus = analyser.analyseBoard(board);
			switchPlayer();
			return gameStatus;
	}
}