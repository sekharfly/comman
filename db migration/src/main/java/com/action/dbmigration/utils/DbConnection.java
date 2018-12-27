package com.action.dbmigration.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public Connection dbConnection() {
		Connection con = null;
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection(
					"jdbc:h2:~/file/advertiserss;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;AUTO_RECONNECT=TRUE", "sa",
					"");
			System.out.println(con);
			return con;
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
