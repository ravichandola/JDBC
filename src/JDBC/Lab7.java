package JDBC;
import JDBC.JDBCUtil;
import java.sql.*;

public class Lab7 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		ResultSet rs =null;
		try{
			
			con=JDBCUtil.getMySqlConnection();
			int id=102;
			String qry=null;
			qry="select * from stud"; 
			
			st=con.createStatement();
			rs=st.executeQuery(qry);
			boolean b1=st.execute(qry);
			if(b1)
			{
				rs=st.getResultSet();
				if(rs.next())
				{
					do{
						int sid=rs.getInt(1);
						String sname=rs.getString(2);
						int sphone=rs.getInt(3);
						System.out.println(sid+"\t"+sname+"\t"+sphone);
						
				}while(rs.next());
					
				}
			}
						
			else
			{
				int x=st.getUpdateCount();
				System.out.println("Result:"+x);
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
