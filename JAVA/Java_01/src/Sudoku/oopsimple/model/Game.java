package Sudoku.oopsimple.model;

import Sudoku.oopsimple.utils.Constants;

public class Game {
	// Attributes
		private Node[][] game; // 9 x 9 nodes

		// Constructors
		public Game(Node[][] game) {
			this.game = game;
		}

		public Game() {
			this.game = new Node[Constants.GAME_SIZE][Constants.GAME_SIZE];
			for (int i = 0; i < Constants.GAME_SIZE; i++) {
				for (int j = 0; j < Constants.GAME_SIZE; j++) {
					Node node = new Node(i, j, 0, false);
					this.game[i][j] = node;
				}
			}
		}

		public Game(int[][] game) {
			this.game = new Node[Constants.GAME_SIZE][Constants.GAME_SIZE];
			for (int i = 0; i < Constants.GAME_SIZE; i++) {
				for (int j = 0; j < Constants.GAME_SIZE; j++) {
					int value = game[i][j];
					Node node = new Node(i, j, value, value > 0 ? true : false);
					this.game[i][j] = node;
				}
			}
		}

		// Getters and setters
		public Node[][] getGame() {
			return game;
		}

		public void setGame(Node[][] game) {
			this.game = game;
		}

		public void setNodeValue(Node node) {
			int row = node.getRow();
			int col = node.getCol();
			int value = node.getValue();
			Node node_in_game = this.getNode(row, col);
			node_in_game.setValue(value);
		}

		public Node getNode(int row, int col) {
			return this.game[row][col];
		}

		@Override
		public String toString() {
			StringBuilder sdata = new StringBuilder();
			sdata.append("============== GAME ===============\n");
			for (Node[] nodes : this.game) {
				for (Node node : nodes) {
					sdata.append(node.getValue() + " | ");
				}
				sdata.append("\n");
			}
			return sdata.toString();
		}

		public boolean isAcceptedByRow(Node node) {
			int row = node.getRow();
			int value = node.getValue();
			for (int j = 0; j < Constants.GAME_SIZE; j++) {
				if (this.getNode(row, j).getValue() == value) {
					return false;
				}
			}
			return true;
		}

		public boolean isAcceptedByCol(Node node) {
			int col = node.getCol();
			int value = node.getValue();
			for (int i = 0; i < Constants.GAME_SIZE; i++) {
				if (this.getNode(i, col).getValue() == value) {
					return false;
				}
			}
			return true;
		}

		public boolean isAcceptedByZone(Node node) {
			int zone = node.getZone();
			int value = node.getValue();
			for (int i = 0; i < Constants.GAME_SIZE; i++) {
				for (int j = 0; j < Constants.GAME_SIZE; j++) {
					Node node_in_game = this.getNode(i, j);
					if (node_in_game.getZone() == zone) {
						if (node_in_game.getValue() == value) {
							return false;
						}
					}
				}
			}
			return true;
		}

		public boolean isEndGame() {
			for (Node[] nodes : this.game) {
				for (Node node : nodes) {
					if (node.getValue() == 0) {
						return false;
					}
				}
			}
			return true;
		}

		public boolean isReservedNode(Node node) {
			int row = node.getRow();
			int col = node.getCol();
			Node node_in_game = this.getNode(row, col);
			return node_in_game.isReserved();
		}
}
