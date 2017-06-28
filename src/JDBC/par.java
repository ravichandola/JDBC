package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class par {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/southwind","root","winner*123");
			String sql="insert into stud values(10100,'sumith',98797)";
			st=con.createStatement();
			int x=st.executeUpdate(sql);
			if(x==1){
				System.out.println("recored created");
			}
			else{
				System.out.println("not created");
			}
			
			
			}catch(Exception e){
			e.printStackTrace();
			}finally{
				try {
					st.close();
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
		
	}}