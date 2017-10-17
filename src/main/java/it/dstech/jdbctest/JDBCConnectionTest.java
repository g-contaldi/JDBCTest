package it.dstech.jdbctest;

import java.sql.Connection;

import it.dstech.jdbctest.utility.DBUtilityConnection;

public class JDBCConnectionTest {

	public static void main(String[] args) {

		testConnection();

	}

	private static void testConnection() {

		try (Connection dbConnection = DBUtilityConnection.getDBConnection()) {
			System.out.println("Connessione stabilita con successo");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
