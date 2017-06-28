package JDBC;
import JDBC.JDBCUtil;
import java.sql.*;


public class Lab5 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs =null;
		try{
			
			con=JDBCUtil.getMySqlConnection();
			int sid=97;
			String nm="Manish";
			long Ph=99995550;
			
			String qry=String.format("Insert into stud values(%d,'%s',%d)",sid,nm,Ph);
			System.out.println(qry);
			st=con.createStatement();
			int x=st.executeUpdate(qry);
			if(x==1)
			{
			System.out.println("Record Inserted");	
			}
				
			
			else
			{
				System.out.println("Record not Inserted");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.cleanup(rs,st,con);
		}
	}
}
