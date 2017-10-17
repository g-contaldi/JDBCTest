package it.dstech.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.dstech.jdbctest.utility.DBUtilityConnection;

public class JDBCPreparedStatementDelete {

	public static void main(String[] args) {

		deleteRecordIntoTable();

	}

	private static void deleteRecordIntoTable() {

		String query = "DELETE FROM REGISTRATION " + " WHERE ID = ?";

		try (Connection dbConnection = DBUtilityConnection.getDBConnection();
				PreparedStatement preparedStatement = dbConnection.prepareStatement(query)) {

			preparedStatement.setInt(1, 1);
			preparedStatement.executeUpdate();
			System.out.println("Record eliminato nella tabella REGISTRATION!");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
