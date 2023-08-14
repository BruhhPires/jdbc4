package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st =  null;
		
		try {
			
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "DepartmentId = ? ");
			
			st.setDouble(1, 200);
			st.setDouble(2, 2);
			
			int rowsAffect = st.executeUpdate();
			
			System.out.println("Done! Rows Affected: " + rowsAffect);
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeConnection();
			DB.closeStatement(st);
		}

	}

}
