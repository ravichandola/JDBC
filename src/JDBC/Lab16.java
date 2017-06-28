package JDBC;
import JDBC.JDBCUtil;
import java.util.*;
import java.sql.*;


public class Lab16 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try
		{
			con=JDBCUtil.getMySqlConnection();
			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery("Select * from stud");
			while(rs.next())
			
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
			
			rs.moveToInsertRow();
			rs.updateInt(108, 9);
			rs.updateString(2, "aahan");
			rs.updateInt(108, 229);
			rs.insertRow();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.cleanup(rs, st, con);
		}
	}

}
