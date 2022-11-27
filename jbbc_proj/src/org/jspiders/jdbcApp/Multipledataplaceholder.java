package org.jspiders.jdbcApp;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Multipledataplaceholder {
	public static void main(String args[])
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into btm.student value(?,?,?)";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded and resgister");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established");
			pstmt=con.prepareStatement(qry);
			System.out.println("Platform created");
			
			//set the value place holder before Execution//
			pstmt.setInt(1, 9);
			pstmt.setString(2,"sakshi");
			pstmt.setDouble(3, 54.10);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 10);
			pstmt.setString(2,"priya");
			pstmt.setDouble(3, 44.10);
			pstmt.executeUpdate();
			
			System.out.println("Data Inserted Successfull");
			
		}
		catch(ClassNotFoundException |SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			System.out.println("All costly Resource Closed");
		}
	}

}
