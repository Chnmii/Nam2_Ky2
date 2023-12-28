package Sudoku.oopsimple.view;

import java.util.Scanner;

import Sudoku.oopsimple.model.Game;
import Sudoku.oopsimple.model.Node;

public class SudokuView {
	/*
	 * Model
	 */
	private Game game;
	
	public SudokuView(Game game) {
		this.game = game;
	}

	/*
	 * Console mode - No UI.
	 */
	public void showGame() {
		System.out.println(this.game.toString());
	}
	
	public Node inputNode(Scanner sc){
		System.out.println("Please input the data:");
		System.out.print("Row: ");
		int row = sc.nextInt() - 1;
		System.out.print("Col: ");
		int col = sc.nextInt() - 1;
		System.out.print("Value: ");
		int value = sc.nextInt();
		Node node = new Node(row, col, value, false);
		return node;
	}
}
