package com.swabhavtechlabs.tic.tac.toe;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class TicTacToeMenu {
	public static Scanner sc = new Scanner(System.in);

	public static int getPositionFromPlayer(Player currentPlayer) {
		System.out.println("\n" + currentPlayer.getName() + " Enter position\t");
		int position = sc.nextInt();
		return position;
	}

	public static void printResult(IBoard board, GameStatus status) {
		printBoard(board);
		System.out.println();
		if (status == GameStatus.O_WON)
			System.out.println("<-------------Player 1 Winner O----------------->");
		else if (status == GameStatus.X_WON)
			System.out.println("<-------------Player 2 Winner X----------------->");
		else
			System.out.print("<-------------Match draw----------------->");
	}

	public static void main(String[] args) {
		
		ThreeByThreeBoard board = new ThreeByThreeBoard();
		Player[] players = new Player[2];
		ResultAnalyser analyser = new ResultAnalyser(board);
		players[0] = new Player(Mark.O, "Player 1");
		players[1] = new Player(Mark.X, "Player 2");
		Game game = new Game(board, players, analyser);
		game.init();
		GameStatus status = game.getGameStatus();
				
		printBoard(board);
		do {
			int position = getPositionFromPlayer(game.getCurrentPlayer());
			if (board.isCellEmpty(position)) {
				status = game.play(position);
				if (!checkResult(status, board))
					break;
			} else
				System.out.println("Invalid position, please enter diffrent position");
			
		} while (status == GameStatus.PROGRESS);
	}

	private static boolean checkResult(GameStatus result, IBoard board) {
		printBoard(board);
		if (result == GameStatus.X_WON || result == GameStatus.O_WON)
			printResult(board, result);
		else if (result == GameStatus.DRAW) {
			printResult(board, result);
			System.out.print("\tMatch Draw!!!");
			return false;
		}
		return true;
	}

	private static void printBoard(IBoard board) {
		int counter = 0;
		System.out.println("\nBoard status");
		Set<Map.Entry<Integer, Cell>> setView = board.getBoard().entrySet();
		for (Map.Entry<Integer, Cell> entry : setView) {
			if (counter == board.getBoardType()) {
				System.out.println();
				counter = 0;
			}
			if (entry.getValue().getMark() == Mark.EMPTY)
				System.out.print("-" + "\t");
			else
				System.out.print(entry.getValue().getMark() + "\t");
			counter++;
		}
	}
}