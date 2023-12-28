package sodoku.oopsimple_iodb.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sodoku.oopsimple_iodb.model.Node;

public class FileUtils {
	/*
	 * Read the configuration file
	 */
	public static Node[][] loadGameFromFile() throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		Node[][] game = null;
		try {
			fr = new FileReader(Constants.InitConfiguration.SODOKU_FILENAME);
			br = new BufferedReader(fr);
			List<String> ldata = new ArrayList<String>();
			String line = null;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (!line.isEmpty()){
					ldata.add(line);
				}
			}
			if (ldata.isEmpty()){
				throw new IOException("No data found!");
			}
			int ran_index = (int)(Math.random() * ((ldata.size() - 1 - 0) + 1));
			String value = ldata.get(ran_index);
			String[] data = value.trim().split(",");
			if (data.length != Constants.InitConfiguration.GAME_SIZE * Constants.InitConfiguration.GAME_SIZE) {
				throw new IOException("The size of data is not correct!");
			}
			game = new Node[Constants.InitConfiguration.GAME_SIZE][Constants.InitConfiguration.GAME_SIZE];
			for (int i = 0; i < Constants.InitConfiguration.GAME_SIZE; i++) {
				for (int j = 0; j < Constants.InitConfiguration.GAME_SIZE; j++) {
					int v_node = Integer.parseInt(data[i * Constants.InitConfiguration.GAME_SIZE + j]);
					game[i][j] = new Node(i, j, v_node, v_node > 0 ? true : false);
				}
			}
		} finally {
			if (br != null) {
				br.close();
			}
			if (fr != null) {
				fr.close();
			}
		}
		return game;
	}
}
