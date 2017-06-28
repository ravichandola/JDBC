package JDBC;
import JDBC.JDBCUtil;
import java.sql.*;


public class Lab13 {

	public static void main(String[] args) {
		Connection con =null;
		Statement st= null;
		try{
			con=JDBCUtil.getMySqlConnection();
			st=con.createStatement();
			String s1="insert into stud values(103,'sri@jlc',95454)";
			st.addBatch(s1);
			String s2="insert into stud values(104,'ajil@jlc',93354)";
			st.addBatch(s2);
			String s3="insert into stud values(105,'sumit@jlc',82354)";
			st.addBatch(s3);
			String s4="insert into stud values(106,'annup@jlc',80554)";
			st.addBatch(s4);
			String s5="insert into stud values(107,'manish@jlc',893354)";
			st.addBatch(s5);
			
			int x[]=st.executeBatch();
			for (int i = 0; i < x.length; i++) 
			{
				System.out.println(x[i]);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		finally{
			JDBCUtil.cleanup(st, con);
		}
	}

}
