package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Lab2 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ravi","root","winner*123");
			String sql="insert into jlc values(99,'sri',11)";
			st=con.createStatement();
			int x= st.executeUpdate(sql);
			if(x==1)
			{
				System.out.println("Record Inserted in the table");
			}
			else{
				System.out.println("Record not inserted in the table");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally{
			try {
				if(st!=null)
					st.close();
				if(con!=null)
					st.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}

	}


}
