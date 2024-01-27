import java.sql.*;
public class mysqlcon {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/collage","root","");
	PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1,3333);
			ps.setString(2,"aaaaa");
			ps.setInt(3,100);
			
			int i=ps.executeUpdate();
			System.out.println(i+"Record inserted");
			
			ResultSet rs=ps.executeQuery("select * from student");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getInt(3));
			}
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

	
}

