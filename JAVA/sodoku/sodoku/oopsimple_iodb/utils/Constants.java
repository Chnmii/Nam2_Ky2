package sodoku.oopsimple_iodb.utils;

public interface Constants {
	public static final int DEFAULT_GAME = 1;
	public static final int FILE_GAME = 2;
	public static final int DATABASE_GAME = 3;
	/*
	 * Configuration file - read the init file.
	 */
	public static final String SODOKU_INIT_FILE = "src\\config\\config_io_db.ini";
	public static final String SODOKU_LEVEL = "SODOKU_LEVEL";
	public static final String SODOKU_GAME_SIZE = "SODOKU_GAME_SIZE";
	public static final String SODOKU_LOAD_DATA_FROM  = "SODOKU_LOAD_DATA_FROM";
	
	public static final String SODOKU_FILENAME = "SODOKU_FILENAME";
	
	public static final String SODOKU_DB_DRIVER = "SODOKU_DB_DRIVER";
	public static final String SODOKU_URL = "SODOKU_URL";
	public static final String SODOKU_USER = "SODOKU_USER";
	public static final String SODOKU_PASSWORD = "SODOKU_PASSWORD";
	
	/*
	 * Default value and default game
	 */
	public class InitConfiguration{
		public static int ZONE_SIZE = 3;
		public static int GAME_SIZE = 9;
		public static int SODOKU_LEVEL = 1;
		
		public static int SODOKU_LOAD_FROM = Constants.DEFAULT_GAME;
		public static String SODOKU_FILENAME = "src\\games\\game.txt";
		
		public static String SODOKU_DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		public static String SODOKU_URL = "jdbc:mysql://localhost:3306/sodoku";
		public static String SODOKU_USER = "root";
		public static String SODOKU_PASSWORD = "";
	}
	
	public static final int DEMO_GAME[][] = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
			{ 0, 9, 8, 0, 0, 0, 0, 6, 0 }, { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
			{ 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
			{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
	
	
}
