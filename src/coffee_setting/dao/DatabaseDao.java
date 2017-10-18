package coffee_setting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import coffee_setting.jdbc.DBCon;
import coffee_setting.jdbc.JdbcUtil;

public class DatabaseDao {
	private static final DatabaseDao instance = new DatabaseDao();

	public DatabaseDao() {
		// TODO Auto-generated constructor stub
	}

	public static DatabaseDao getInstance() {
		return instance;
	}
	
	public void executeUpdateSQL(String sql){
		Connection con = DBCon.getInstance().getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.printf("%s -%s%n",e.getErrorCode(), e.getMessage());
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
		}
		
	}
	
	public ResultSet executeQuerySQL(String sql) throws SQLException{
		Connection con = DBCon.getInstance().getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeQuery();
		
	}

}
