package com.practice.extra.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBDelegate {

	private static final String JDBC_PASSWD = "";
	private static final String JDBC_USR = "";
	private static final String JDBC_CONN_URL = "jdbc:oracle:thin:@//localhost:1521/orcldb";
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	public static void updateDBWithFileDetails(String filePart1, String filePart2) throws Exception {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_CONN_URL, JDBC_USR, JDBC_PASSWD);
			stmt = conn.createStatement();
			String sqlInsertQuery;

			sqlInsertQuery = "insert into fileDatabase Values('" + filePart1 + "','" + filePart2 + "')";
			stmt.executeUpdate(sqlInsertQuery);
			stmt.close();
			conn.close();

		}

		catch (Exception e) {
			throw e;
		} finally {
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
		}

	}
	
}
