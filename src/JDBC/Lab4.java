package JDBC;
import JDBC.JDBCUtil;
import java.sql.*;

public class Lab4 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs =null;
		try{
			
			con=JDBCUtil.getMySqlConnection();
			String qry="select * from stud";
			st=con.createStatement();
			rs=st.executeQuery(qry);
			if(rs.next())
			{
				do{
					
				int sid=rs.getInt(1);
				String name=rs.getString(2);
				int phone=rs.getInt(3);
				System.out.println(sid+"\t"+name+"\t"+phone);
				}
				while(rs.next());
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
