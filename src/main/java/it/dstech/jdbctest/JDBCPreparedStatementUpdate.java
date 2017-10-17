package it.dstech.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.dstech.jdbctest.utility.DBUtilityConnection;

public class JDBCPreparedStatementUpdate {

	public static void main(String[] args) {

		updateRecordIntoTable();

	}

	private static void updateRecordIntoTable() {

		String query = "UPDATE REGISTRATION SET" + " NOME = ?" + " WHERE ID = ?";

		try (Connection dbConnection = DBUtilityConnection.getDBConnection();
				PreparedStatement preparedStatement = dbConnection.prepareStatement(query)) {

			preparedStatement.setString(1, "alberto");
			// preparedStatement.setString(2, "baudo");
			// preparedStatement.setInt(3, 88);
			preparedStatement.setInt(2, 3);

			preparedStatement.executeUpdate();
			System.out.println("Record aggiornato nella tabella REGISTRATION!");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
