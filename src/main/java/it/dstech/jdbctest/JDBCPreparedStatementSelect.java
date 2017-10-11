package it.dstech.jdbctest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

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
		Statement statement = null;
		ResultSet resultSet = null;
		String selectTableSQL = "SELECT * FROM REGISTRATION";
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.prepareStatement(selectTableSQL);

			resultSet = statement.executeQuery(selectTableSQL);

			while (resultSet.next()) {
				System.out.println("ID " + resultSet.getInt("id"));
				System.out.println("NOME " + resultSet.getString("nome"));
				System.out.println("COGNOME " + resultSet.getString("cognome"));
				System.out.println("ETA " + resultSet.getInt("eta"));
				System.out.println("-----");
			}
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
