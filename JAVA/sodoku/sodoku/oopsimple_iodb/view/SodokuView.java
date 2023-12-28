package sodoku.oopsimple_iodb.view;

import java.util.Scanner;

import sodoku.oopsimple_iodb.model.Game;
import sodoku.oopsimple_iodb.model.Node;

public class SodokuView {
	/*
	 * Model
	 */
	private Game game;

	public SodokuView(Game game) {
		this.game = game;
	}

	/*
	 * Console mode - No UI.
	 */
	public void showGame() {
		System.out.println(this.game.toString());
	}

	public Node inputNode(Scanner sc) {
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
