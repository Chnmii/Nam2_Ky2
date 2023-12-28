package sodoku.oopsimple_iodb;

import java.io.IOException;

import sodoku.oopsimple_iodb.controller.SodokuController;
import sodoku.oopsimple_iodb.utils.ConfigurationFile;
import sodoku.oopsimple_iodb.utils.DataBaseUtils;

public class Sodoku {

	public static void main(String[] args) {
		try {
			/*
			 * Load the ini configuration file
			 */
			ConfigurationFile.readInitConfigFile();
			/*
			 * Load database driver
			 */
			DataBaseUtils.loadDriver();
			/*
			 * Start the game
			 */
			SodokuController sc = new SodokuController();
			sc.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
