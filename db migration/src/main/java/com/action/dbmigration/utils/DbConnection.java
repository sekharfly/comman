package com.action.dbmigration.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public Connection dbConnection(String url, String name, String password) {
		Connection con = null;
		try {
			// "jdbc:mysql://localhost:3306/dbmig", "root", "SekharFly"
			con = DriverManager.getConnection(url, name, password);
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return con;
		}

	}
}
