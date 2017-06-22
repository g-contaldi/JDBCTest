package it.dstech.jdbctest.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilityConnection {

	public static Connection getDBConnection() throws Exception {

		Connection dbConnection = null;

		try {
			Class.forName(Variabili.DB_DRIVER);

		} catch (ClassNotFoundException e) {
			throw new Exception(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(Variabili.DB_CONNECTION, Variabili.DB_USER,
					Variabili.DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
}
