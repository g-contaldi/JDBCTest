package it.dstech.jdbctest;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import it.dstech.jdbctest.utility.DBUtilityConnection;

public class JDBCStatementCreateTable {

	public static void main(String[] args) {

		createDbUserTable();

	}

	private static void createDbUserTable() {

		String query = "CREATE TABLE REGISTRATION " + "(ID INTEGER NOT NULL AUTO_INCREMENT, " + " NOME VARCHAR(255), "
				+ " COGNOME VARCHAR(255), " + " ETA INTEGER, " + " PRIMARY KEY ( id ))";

		try (Connection dbConnection = DBUtilityConnection.getDBConnection();
				Statement statement = dbConnection.prepareStatement(query)) {

			System.out.println(query);
			statement.execute(query);
			System.out.println("Tabella \"REGISTRATION\" creata con successo!");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
