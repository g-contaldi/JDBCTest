package it.dstech.jdbctest;

import java.sql.Connection;
import java.sql.SQLException;

import it.dstech.jdbctest.utility.DBUtilityConnection;

public class JDBCConnectionTest {

	public static void main(String[] argv) {

		try {
			testConnection();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void testConnection() throws SQLException {

		Connection dbConnection = null;
		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			System.out.println("Connessione stabilita con successo");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}

}
