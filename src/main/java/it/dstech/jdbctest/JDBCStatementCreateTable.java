package it.dstech.jdbctest;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import it.dstech.jdbctest.utility.DBUtilityConnection;

public class JDBCStatementCreateTable {

	public static void main(String[] argv) throws Exception {

		try {
			createDbUserTable();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void createDbUserTable() throws Exception {

		Connection dbConnection = null;
		Statement statement = null;

		String createTableSQL = "CREATE TABLE REGISTRATION " + "(ID INTEGER NOT NULL AUTO_INCREMENT, "
				+ " NOME VARCHAR(255), " + " COGNOME VARCHAR(255), " + " ETA INTEGER, " + " PRIMARY KEY ( id ))";

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(createTableSQL);
			statement.execute(createTableSQL);
			System.out.println("Tabella \"REGISTRATION\" creata con successo!");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}
}
