package com.revature.project0;

import java.sql.Connection;

	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;

	public class ConnectionUtils {
		private static Connection con = null;

		public static Connection getConnection() {
			Properties p = new Properties();
			try {
				FileReader reader = new FileReader("src/main/resources/db.properties");
				p.load(reader);
				String URL = p.getProperty("db.url");
				String port = p.getProperty("db.port");
				String db = p.getProperty("db.database");
				String user = p.getProperty("db.user");
				String pwd = p.getProperty("db.password");

				String DBURL = "jdbc:postgresql://" + URL + ":" + port + "/" + db;
				try {
					con = DriverManager.getConnection(DBURL, user, pwd);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return con;

}}
