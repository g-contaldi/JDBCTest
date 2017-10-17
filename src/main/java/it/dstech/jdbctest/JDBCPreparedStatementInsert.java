package it.dstech.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.dstech.jdbctest.utility.DBUtilityConnection;

public class JDBCPreparedStatementInsert {

	public static void main(String[] args) {

		insertRecordIntoTable();

	}

	private static void insertRecordIntoTable() {

		String query = "INSERT INTO REGISTRATION" + "(ID, NOME, COGNOME, ETA) VALUES" + "(default,?,?,?)";

		try (Connection dbConnection = DBUtilityConnection.getDBConnection();
				PreparedStatement preparedStatement = dbConnection.prepareStatement(query)) {

			preparedStatement.setString(1, "pippo");
			preparedStatement.setString(2, "franco");
			preparedStatement.setInt(3, 100);
			preparedStatement.executeUpdate();
			System.out.println("Record inserito nella tabella REGISTRATION!");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}
}
