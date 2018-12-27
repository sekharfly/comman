package com.action.dbmigration.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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

		// Connection dbConnection = connection.dbConnection();
		Connection dbConnection = mysql.mysql();
		Statement stmt = dbConnection.createStatement();

		JSONObject jsonObject = new JSONObject(json);
		JSONArray jsonArray = jsonObject.getJSONArray("data");

		StringBuilder sql = new StringBuilder("create table if NOT EXISTS dbmig.data(");

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

		// Connection dbConnection = connection.dbConnection();
		Connection dbConnection = mysql.mysql();
		Statement stmt = dbConnection.createStatement();

		JSONObject jsonObject = new JSONObject(json);
		JSONArray jsonArray = jsonObject.getJSONArray("data");

		StringBuilder sql = new StringBuilder("INSERT INTO dbmig.data VALUES (");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject object = jsonArray.getJSONObject(i);
			// String col = object.getString("col");
			String value = object.getString("value");

			String finalVal = "".concat("\"" + value + "\"");
			// String column = col.concat(" " + value);
			// System.out.println(column);
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
}
