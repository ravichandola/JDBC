package JDBC;
import JDBC.JDBCUtil;
import java.sql.*;

public class Lab6 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs =null;
		try{
			
			con=JDBCUtil.getMySqlConnection();
			int id=102;
			String qry=String.format("select * from stud where id=%d",id);
			st=con.createStatement();
			rs=st.executeQuery(qry);
			if(rs.next())
			{
				
					
				int sid=rs.getInt(1);
				String sname=rs.getString(2);
				int sphone=rs.getInt(3);
				System.out.println(sid+"\t"+sname+"\t"+sphone);
				}
						
			else
			{
				System.out.println("student not Found");
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
