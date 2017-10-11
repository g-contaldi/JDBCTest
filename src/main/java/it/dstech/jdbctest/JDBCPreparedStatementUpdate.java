package it.dstech.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.dstech.jdbctest.utility.DBUtilityConnection;

public class JDBCPreparedStatementUpdate {

	public static void main(String[] argv) throws Exception {

		try {
			updateRecordIntoTable();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void updateRecordIntoTable() throws Exception {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "UPDATE REGISTRATION SET" + " NOME = ?" + " WHERE ID = ?";

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, "alberto");
//			preparedStatement.setString(2, "baudo");
//			preparedStatement.setInt(3, 88);
			preparedStatement.setInt(2, 3);

			preparedStatement.executeUpdate();
			System.out.println("Record aggiornato nella tabella REGISTRATION!");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}
}
