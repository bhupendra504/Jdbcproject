package org.jspiders.jdbcApp;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Particularid {
   public static void main(String args[])
   {
	   Connection con=null;
	   PreparedStatement pstmt=null;
	   ResultSet rs=null;
	   String qry="select * from btm.student where id=?";
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter Id???");
	   int id=sc.nextInt();
	   sc.close();
	   try
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		   pstmt=con.prepareStatement(qry);
		   //set the value for placeholder before execution//
		   pstmt.setInt(1, id);
		   //Execute SQL Query//
		   rs=pstmt.executeQuery();
		   //check for record in cursor or buffer memory //
		   if(rs.next())
		   {
			   String name=rs.getString(2);
			   double perc=rs.getDouble(3);
			   System.out.println("Name="+name+"perc="+perc);
		   }
		   else 
		   {
			   System.err.println("No data found for id = "+id);
		   } 
	   }
	   catch(ClassNotFoundException |SQLException e)
	   {
		   e.printStackTrace();
	   }
	   finally
	   {
		   if(rs!=null)
		   {
			   try
			   {
				   rs.close();
			   }
			   catch(SQLException e)
			   {
				   e.printStackTrace();
			   }
		   }
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
	   }
	   
   }

}
