package sodoku.simple;

import java.util.Scanner;

public class Sodoku {

	public static int N = 3;
	public static int N_2 = N * N;

	public static int game[][] = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
			{ 0, 9, 8, 0, 0, 0, 0, 6, 0 }, { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
			{ 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
			{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
	public static int game_original[][] = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
			{ 0, 9, 8, 0, 0, 0, 0, 6, 0 }, { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
			{ 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
			{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

	public static void main(String[] args) {
		/*
		 * Khoi tao moi truong
		 */
		Scanner sc = new Scanner(System.in);
		int r, c, v;

		/*
		 * Algorithm
		 */
		while (true) {
			/*
			 * Step 1 - show game
			 */
			Sodoku.showGame(game);

			/*
			 * Step 2 - input
			 */
			System.out.println("Mời bạn nhập từ 1-9");
			System.out.print("row = ");
			r = sc.nextInt() - 1;
			System.out.print("column = ");
			c = sc.nextInt() - 1;
			System.out.print("value = ");
			v = sc.nextInt();

			/*
			 * Step 3 - validate
			 */
			if (!Sodoku.checkReserved(game_original, r, c)) {
				System.out.println("Phần tử này không được thay đổi. Mời bạn nhập lại.");
				continue;
			}
			int validate = Sodoku.checkExisted(game, r, c, v);
			if (validate == 1) {
				System.out.println("Đã có phần tử trong hàng. Mời bạn nhập lại.");
				continue;
			}
			if (validate == 2) {
				System.out.println("Đã có phần tử trong cột. Mời bạn nhập lại.");
				continue;
			}
			if (validate == 3) {
				System.out.println("Đã có phần tử trong vùng. Mời bạn nhập lại.");
				continue;
			}
			game[r][c] = v;
			/*
			 * Step 4 - end game?
			 */
			if (!Sodoku.checkEndGame(game)) {
				continue;
			} else {
				System.out.println("Chúc mừng, bạn đã hoàn thành trò chơi.");
				break;
			}
		}
		sc.close();
	}

	public static void showGame(int[][] game) {
		System.out.println("Game: ");
		for (int i = 0; i < N_2; i++) {
			for (int j = 0; j < N_2; j++) {
				System.out.print(game[i][j] + "|");
			}
			System.out.println();
		}
	}

	public static boolean checkReserved(int[][] game, int r, int c) {
		if (game[r][c] != 0) {
			return false;
		}
		return true;
	}

	public static int checkExisted(int[][] game, int r, int c, int v) {
		// Check by row
		for (int j = 0; j < N_2; j++) {
			if (game[r][j] == v) {
				return 1;
			}
		}
		// Check by column
		for (int i = 0; i < N_2; i++) {
			if (game[i][c] == v) {
				return 2;
			}
		}
		// Check by zone
		int zone = Sodoku.zone(r, c);
		for (int i = 0; i < N_2; i++) {
			for (int j = 0; j < N_2; j++) {
				if (Sodoku.zone(i, j) == zone) {
					if (game[i][j] == v) {
						return 3;
					}
				}
			}
		}
		return 0;
	}

	public static boolean checkEndGame(int[][] game) {
		for (int i = 0; i < N_2; i++) {
			for (int j = 0; j < N_2; j++) {
				if (game[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static int zone(int r, int c) {
		int zone = r / N * N + c / N;
		return zone;
	}
}
