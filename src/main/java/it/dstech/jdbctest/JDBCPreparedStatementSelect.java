package it.dstech.jdbctest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.dstech.jdbctest.utility.DBUtilityConnection;

public class JDBCPreparedStatementSelect {

	public static void main(String[] args) throws SQLException {

		selectRecordIntoTable();

	}

	private static boolean selectRecordIntoTable() throws SQLException {

		ResultSet resultSet = null;
		String query = "SELECT * FROM REGISTRATION";
		try (Connection dbConnection = DBUtilityConnection.getDBConnection();
				Statement statement = dbConnection.prepareStatement(query)) {

			resultSet = statement.executeQuery(query);

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
		if (resultSet.isBeforeFirst())
			return true;
		else
			return false;

	}
}
