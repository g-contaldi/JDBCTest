package it.dstech.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.dstech.jdbctest.utility.DBUtilityConnection;

public class JDBCPreparedStatementDelete {

	public static void main(String[] argv) throws Exception {

		try {
			deleteRecordIntoTable();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void deleteRecordIntoTable() throws Exception {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "DELETE FROM REGISTRATION " + " WHERE ID = ?";

		try {
			dbConnection = DBUtilityConnection.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, 1);

			preparedStatement.executeUpdate();
			System.out.println("Record eliminato nella tabella REGISTRATION!");
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
