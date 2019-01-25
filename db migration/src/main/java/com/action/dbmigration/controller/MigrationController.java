package com.action.dbmigration.controller;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.action.dbmigration.utils.DbConnection;
import com.action.dbmigration.utils.MySqlDb;

@RestController
public class MigrationController {

	DbConnection connection = new DbConnection();
	MySqlDb mysql = new MySqlDb();

	@RequestMapping(value = "/migrationteableCreation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> CreateTable(@RequestBody String json) throws JSONException, SQLException {

		JSONObject jsonObject = new JSONObject(json);
		JSONArray jsonArray = jsonObject.getJSONArray("data");
		String tableName = jsonObject.getString("tableName");
		String connectionUrl = jsonObject.getString("connectionUrl");
		String connectionUserName = jsonObject.getString("connectionUserName");
		String connectionUserPassword = jsonObject.getString("connectionUserPassword");

		// Connection dbConnection = mysql.mysql(connectionUrl, connectionUserName,
		// connectionUserPassword);
		Connection dbConnection = connection.dbConnection(connectionUrl, connectionUserName, connectionUserPassword);
		Statement stmt = dbConnection.createStatement();

		StringBuilder sql = new StringBuilder("create table if NOT EXISTS " + tableName + "(");

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject object = jsonArray.getJSONObject(i);
			String col = object.getString("col");
			String type = object.getString("type");
			String size = object.getString("size");
			String column = col.concat(" " + type);
			column = column.concat("(" + size + ")");
			System.out.println(column);
			if (i != jsonArray.length() - 1) {
				column = column.concat(",");
			}
			sql.append(column);
		}
		sql.append(")");
		stmt.executeUpdate(sql.toString());
		dbConnection.close();
		return new ResponseEntity<String>("success fully table created", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/migrationInsetIntoteable", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insetIntoTable(@RequestBody String json) throws SQLException, JSONException {

		JSONObject jsonObject = new JSONObject(json);
		JSONArray jsonArray = jsonObject.getJSONArray("data");
		String tableName = jsonObject.getString("tableName");
		String connectionUrl = jsonObject.getString("connectionUrl");
		String connectionUserName = jsonObject.getString("connectionUserName");
		String connectionUserPassword = jsonObject.getString("connectionUserPassword");

		Connection dbConnection = mysql.mysql(connectionUrl, connectionUserName, connectionUserPassword);
		Statement stmt = dbConnection.createStatement();

		StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " VALUES (");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject object = jsonArray.getJSONObject(i);
			String value = object.getString("value");

			String finalVal = "".concat("\"" + value + "\"");
			if (i != jsonArray.length() - 1) {
				finalVal = finalVal.concat(",");
			}
			sql.append(finalVal);
		}
		sql.append(")");

		stmt.executeUpdate(sql.toString());
		dbConnection.close();
		return new ResponseEntity<String>("inserted successfully inserted", HttpStatus.OK);
	}

	@RequestMapping(value = "/exportCSV", method = RequestMethod.GET)
	public String exportCSV() {
		String filename = "/home/sekharv/Desktop/test.csv";
		try {
			FileWriter fw = new FileWriter(filename);

			Connection dbConnection = mysql.mysql("", "", "");
			Statement stmt = dbConnection.createStatement();

			String query = "select * from dbmig.data";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				fw.append(rs.getString(1));
				fw.append(',');
				fw.append(rs.getString(2));
				fw.append('\n');
			}
			fw.flush();
			fw.close();
			dbConnection.close();
			System.out.println("CSV File is created successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "successfully wrote";
	}

	@RequestMapping(value = "/showtables", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> showTables(@RequestBody String json) throws SQLException, JSONException {

		JSONObject jsonObject = new JSONObject(json);
		// JSONArray jsonArray = jsonObject.getJSONArray("data");
		// String tableName = jsonObject.getString("tableName");
		String connectionUrl = jsonObject.getString("connectionUrl");
		String connectionUserName = jsonObject.getString("connectionUserName");
		String connectionUserPassword = jsonObject.getString("connectionUserPassword");

		Connection dbConnection = connection.dbConnection(connectionUrl, connectionUserName, connectionUserPassword);
		Statement stmt = dbConnection.createStatement();

		StringBuilder sql = new StringBuilder("show tables");

		ResultSet executeQuery = stmt.executeQuery(sql.toString());

		String tables = "";
		ArrayList<String> arrayList = new ArrayList<String>();

		while (executeQuery.next()) {
			System.out.println(executeQuery.getString(1));
			tables = executeQuery.getString(1);
			arrayList.add(tables);
		}

		dbConnection.close();
		return new ResponseEntity<String>(arrayList.toString(), HttpStatus.OK);
	}

}
