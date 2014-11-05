package me.undertook;

import java.sql.*;

public class PGTest {
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String URL_PREFIX = "jdbc:postgresql://";
	
	public static void main(String[] args) throws Exception {
		
		/* register driver */
		Class.forName(JDBC_DRIVER);
		
		/* connect */
		String url = URL_PREFIX + args[0] + ":" + args[1] + "/" + args[2];
		Connection conn = DriverManager.getConnection(url, args[3], args[4]);
		
		/* prepare sql */
		String sql = "select * from test where start_date > ?+1";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDate(1, new Date(0));
		
		/* execute query and traverse result */
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getDate(1));
		}
	}
}
