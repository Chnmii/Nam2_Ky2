package Sudoku.oopsimple.controller;


import java.util.Scanner;

import Sudoku.oopsimple.model.Game;
import Sudoku.oopsimple.model.Node;
import Sudoku.oopsimple.utils.Constants;
import Sudoku.oopsimple.view.SudokuView;

public class SudokuController {
	private Game game;
	private SudokuView sodokuView;
	
	public SudokuController() {
		this.game = new Game(Constants.DEMO_GAME);
		this.sodokuView = new SudokuView(this.game);
	}
	
	/*
	 * Business
	 */
	public void start() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			this.sodokuView.showGame();
			Node node = this.sodokuView.inputNode(sc);
			/*
			 * Launch the game
			 */
			if (!node.isValidate()) {
				System.out.println("The input data is wrong, please re-input data!");
				continue;
			}
			if (this.game.isReservedNode(node)) {
				System.out.println("This node is reserved, please choose another node!");
				continue;
			}
			if (!this.game.isAcceptedByRow(node)) {
				System.out.println("Duplicated value in row, please choose another value!");
				continue;
			}
			if (!this.game.isAcceptedByCol(node)) {
				System.out.println("Duplicated value in column, please choose another value!");
				continue;
			}
			if (!this.game.isAcceptedByZone(node)) {
				System.out.println("Duplicated value in zone, please choose another value!");
				continue;
			}
			this.game.setNodeValue(node);
			if (this.game.isEndGame()) {
				System.out.println("Conglatulation, you win the game!");
				this.sodokuView.showGame();
				sc.close();
				return;
			} else {
				// continue the game ...
				System.out.println("Continue ...");
			}
		}
	}

}
