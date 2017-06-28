package JDBC;
import JDBC.JDBCUtil;
import java.sql.*;


public class Lab9 {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			con=JDBCUtil.getMySqlConnection();
			int sid=102;
			String qry="select * from stud where id=?";
			
			ps=con.prepareStatement(qry);
			ps.setInt(1,sid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				int id=rs.getInt(1);
				String nm=rs.getString(2);
				Long phone=rs.getLong(3);
			System.out.println(sid+"\t"+nm+"\t"+phone);
			}
			
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
