package sodoku.oopsimple_iodb.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationFile {
	/*
	 * Read the configuration file
	 */
	public static void readInitConfigFile() throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(Constants.SODOKU_INIT_FILE);
			br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (line.startsWith(Constants.SODOKU_LEVEL)) {
					String[] data = line.split("=");
					if (data.length == 2) {
						try {
							int value = Integer.parseInt(data[1].trim());
							if (value > 0 || value < 4) {
								Constants.InitConfiguration.SODOKU_LEVEL = value;
							} else {
								Constants.InitConfiguration.SODOKU_LEVEL = 1;
							}
						} catch (NumberFormatException e) {
							Constants.InitConfiguration.SODOKU_LEVEL = 1;
						}
					}else{
						Constants.InitConfiguration.SODOKU_LEVEL = 1;
					}
				}
				if (line.startsWith(Constants.SODOKU_GAME_SIZE)) {
					String[] data = line.split("=");
					if (data.length == 2) {
						try {
							int value = Integer.parseInt(data[1].trim());
							Constants.InitConfiguration.ZONE_SIZE = value;
							Constants.InitConfiguration.GAME_SIZE = value * value;
						} catch (NumberFormatException e) {
							Constants.InitConfiguration.ZONE_SIZE = 3;
							Constants.InitConfiguration.GAME_SIZE = 9;
						}
					}else{
						Constants.InitConfiguration.ZONE_SIZE = 3;
						Constants.InitConfiguration.GAME_SIZE = 9;
					}
				}
				if (line.startsWith(Constants.SODOKU_LOAD_DATA_FROM)) {
					String[] data = line.split("=");
					if (data.length == 2) {
						try {
							int value = Integer.parseInt(data[1].trim());
							Constants.InitConfiguration.SODOKU_LOAD_FROM = value;
						} catch (NumberFormatException e) {
							Constants.InitConfiguration.SODOKU_LOAD_FROM = Constants.DEFAULT_GAME;
						}
					}else{
						Constants.InitConfiguration.SODOKU_LOAD_FROM = Constants.DEFAULT_GAME;
					}
				}
				if (line.startsWith(Constants.SODOKU_FILENAME)) {
					String[] data = line.split("=");
					if (data.length == 2) {
						Constants.InitConfiguration.SODOKU_FILENAME = data[1].trim();
					}else{
						Constants.InitConfiguration.SODOKU_FILENAME = "game.txt";
					}
				}
				if (line.startsWith(Constants.SODOKU_DB_DRIVER)) {
					String[] data = line.split("=");
					if (data.length == 2) {
						Constants.InitConfiguration.SODOKU_DB_DRIVER = data[1].trim();
					} else {
						Constants.InitConfiguration.SODOKU_DB_DRIVER = "com.mysql.cj.jdbc.Driver";
					}
				}
				if (line.startsWith(Constants.SODOKU_URL)) {
					String[] data = line.split("=");
					if (data.length == 2) {
						Constants.InitConfiguration.SODOKU_URL = data[1].trim();
					} else {
						Constants.InitConfiguration.SODOKU_URL = "jdbc:mysql://localhost:3306/sodoku";
					}
				}
				if (line.startsWith(Constants.SODOKU_USER)) {
					String[] data = line.split("=");
					if (data.length == 2) {
						Constants.InitConfiguration.SODOKU_USER = data[1].trim();
					} else {
						Constants.InitConfiguration.SODOKU_USER = "root";
					}
				}
				if (line.startsWith(Constants.SODOKU_PASSWORD)) {
					String[] data = line.split("=");
					if (data.length == 2) {
						Constants.InitConfiguration.SODOKU_PASSWORD = data[1].trim();
					} else {
						Constants.InitConfiguration.SODOKU_PASSWORD = "";
					}
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
	}
}
