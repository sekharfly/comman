package com.action.dbmigration.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDb {

	public Connection mysql() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmig", "root", "SekharFly");

			return con;

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
