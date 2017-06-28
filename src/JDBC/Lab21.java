package JDBC;
import java.sql.*;
public class Lab21 {
public static void main(String [] args)
{
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	
	try
	{
	 Class.forName("com.mysql.jdbc.Driver");
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/southwind", "root","winner*123");
	 //String sql="select * from stud";
	 String sql="insert into stud values(102,'anup',7893455)";
	 st=con.createStatement();
	 //rs=st.executeQuery(sql);
	 int x=st.executeUpdate(sql);
	 /*while(rs.next())
	 {
		 int si=rs.getInt(1);
		 String sname=rs.getString(2);
		 int j=rs.getInt(3);
		System.out.println(si+"\t"+sname+"\t"+j);
	 }
	 */
	 if(x==1)
	 {
		 System.out.println("Record Inserted");
	 }
	 else
	 {
		 System.out.println("Not Inserted");
	 }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

finally
{
	try
	{
		if(rs!=null)
		
			rs.close();
		if(st!=null)
			st.close();
		if(con!=null)
			con.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
}