package JDBC;
import java.util.*;
import JDBC.JDBCUtil;
import java.sql.*;

public class Lab14 {

	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try{
			con=JDBCUtil.getMySqlConnection();
			String sql="insert into stud(id,name,phone)values(?,?,?)";
			ps=con.prepareStatement(sql);
			Scanner sc= new Scanner(System.in);
			char choice='y';
			do{
				System.out.println("Enter sid");
				int id=sc.nextInt();
				System.out.println("Enter Name");
				String nm=sc.next();
				System.out.println("Enter Phone");
				int ph=sc.nextInt();
				ps.setInt(1, id);
				ps.setString(2, nm);
				ps.setInt(3, ph);
				ps.addBatch();
				System.out.println("Do u want to add more?");
				sc.nextLine();
				choice=sc.nextLine().charAt(0);
			}
			while(choice=='y');
			int res[]=ps.executeBatch();
			for (int i = 0; i < res.length; i++) 
			{
				System.out.println("RES:"+"\t"+res[i]);
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
