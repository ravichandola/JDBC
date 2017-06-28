package JDBC;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.*;

public class Lab19 {
	public static void main(String[] args) {
		try
		{
				
		Class.forName("com.Mysql.jdbc.Driver");
		CachedRowSet rs= new CachedRowSetImpl();
		rs.setUrl("jdbc:Mysql://localhost:3306/southwind");
		rs.setUsername("root");
		rs.setPassword("winner*123");
		rs.setCommand("Select id,name,phone from stud");
		rs.execute();
		  while(rs.next())
		    {
			   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
