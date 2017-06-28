package JDBC;
import JDBC.JDBCUtil;
import java.sql.*;

public class Lab3 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		try{
			con=JDBCUtil.getMySqlConnection();
			String sql="insert into stud values(103,'ravi',8889999)";
			st=con.createStatement();
			int x=st.executeUpdate(sql);
			if(x==1)
			System.out.println("Record Inserted");
			else
				System.out.println("Not Inseted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.cleanup(st, con);
		}
	}
}
