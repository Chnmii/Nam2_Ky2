package sodoku.oopsimple_iodb.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sodoku.oopsimple_iodb.model.Node;

public class DataBaseUtils {

	public static void loadDriver() throws IOException {
		try {
			Class.forName(Constants.InitConfiguration.SODOKU_DB_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new IOException("Can not load database driver!");
		}
	}

	public static Node[][] loadGameFromDatabase() throws NumberFormatException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		Node[][] game = null;
		try {
			conn = DriverManager.getConnection(Constants.InitConfiguration.SODOKU_URL,
					Constants.InitConfiguration.SODOKU_USER, Constants.InitConfiguration.SODOKU_PASSWORD);
			stmt = conn.createStatement();
			String sql = "SELECT value FROM game WHERE fkLevel=" + Constants.InitConfiguration.SODOKU_LEVEL
					+ " ORDER BY RAND() LIMIT 1;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String value = rs.getString("value");
				if (value == null) {
					throw new SQLException("No data found!");
				}
				String[] data = value.trim().split(",");
				if (data.length != Constants.InitConfiguration.GAME_SIZE * Constants.InitConfiguration.GAME_SIZE) {
					throw new SQLException("The size of data is not correct!");
				}
				game = new Node[Constants.InitConfiguration.GAME_SIZE][Constants.InitConfiguration.GAME_SIZE];
				for (int i = 0; i < Constants.InitConfiguration.GAME_SIZE; i++) {
					for (int j = 0; j < Constants.InitConfiguration.GAME_SIZE; j++) {
						int v_node = Integer.parseInt(data[i * Constants.InitConfiguration.GAME_SIZE + j]);
						game[i][j] = new Node(i, j, v_node, v_node > 0 ? true : false);
					}
				}
			}
			rs.close();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return game;
	}
}
