package sodoku.oopsimple_iodb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import sodoku.oopsimple_iodb.model.Game;
import sodoku.oopsimple_iodb.model.Node;
import sodoku.oopsimple_iodb.utils.Constants;
import sodoku.oopsimple_iodb.utils.DataBaseUtils;
import sodoku.oopsimple_iodb.utils.FileUtils;
import sodoku.oopsimple_iodb.view.SodokuView;

public class SodokuController {

	private Game game;
	private SodokuView sodokuView;

	public SodokuController() {
		Node[][] game = null;
		try {
			switch (Constants.InitConfiguration.SODOKU_LOAD_FROM) {
			case Constants.DEFAULT_GAME:
				System.out.println("The game starts from default game!");
				this.game = new Game(Constants.DEMO_GAME);
				break;
			case Constants.FILE_GAME:
				System.out.println("The game starts from file game!");
				game = FileUtils.loadGameFromFile();
				this.game = new Game(game);
				break;
			case Constants.DATABASE_GAME:
				System.out.println("The game starts from database game!");
				game = DataBaseUtils.loadGameFromDatabase();
				this.game = new Game(game);
				break;
			default:
				System.out.println("The game starts from default game!");
				this.game = new Game(Constants.DEMO_GAME);
				break;
			}
			this.sodokuView = new SodokuView(this.game);
		} catch (NumberFormatException | SQLException | IOException e) {
			// TODO - Use the log file.
			e.printStackTrace();
		}
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
