package JDBC;
import JDBC.JDBCUtil;
import java.sql.*;


public class Lab8 {
public static void main(String[] args) {
	
	Connection con=null;
	PreparedStatement ps=null;
	try{
		con=JDBCUtil.getMySqlConnection();
		int sid=97;
		String nm="nivas";
		long phone=9917265;
		String qry="insert into stud values(?,?,?)";
		ps=con.prepareStatement(qry);
		ps.setInt(1,sid);
		ps.setString(2, nm);
		ps.setLong(3, phone);
		int x=ps.executeUpdate();
		if(x==1)
			System.out.println("Record Inserted");
		else
			System.out.println("No Record found");
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		JDBCUtil.cleanup(ps, con);
	}
}
}
