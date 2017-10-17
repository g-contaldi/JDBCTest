package it.dstech.jdbctest.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtilityConnection {

	public static Connection getDBConnection() {

		Connection dbConnection = null;
		try {
			Class.forName(Variabili.DB_DRIVER);
			dbConnection = DriverManager.getConnection(Variabili.DB_CONNECTION, Variabili.DB_USER,
					Variabili.DB_PASSWORD);
			return dbConnection;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
