package it.dstech.jdbctest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.dstech.jdbctest.utility.DBUtilityConnection;

public class JDBCPreparedStatementSelect {

	public static void main(String[] args) throws Exception {

		try {
			selectRecordIntoTable();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static boolean selectRecordIntoTable() throws Exception {
		Connection dbConnection = null;
		Statement Statement = null;
		ResultSet resultSet = null;
		String selectTableSQL = "SELECT* FROM REGISTRATION";
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			Statement = dbConnection.prepareStatement(selectTableSQL);

			resultSet = Statement.executeQuery(selectTableSQL);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		if (resultSet.isBeforeFirst()) {
			return true;
		} else {
			return false;
		}
	}
}
