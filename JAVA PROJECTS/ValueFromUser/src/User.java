import java.sql.*;
import java.io.*;
public class User {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost/collage","root","");
         BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
         PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");
         do {
        	 System.out.println("ENTER ID:");
        	 int id= Integer.parseInt(br.readLine());
        	 
        	 System.out.println("ENTER NAME");
        	 String name = br.readLine();
        	 
        	 System.out.println("ENTER PASSWORD:");
        	 String password=br.readLine();
              
        	 ps.setInt(1,id);
             ps.setString(2,name);
             ps.setString(3,password);
             
             int i = ps.executeUpdate();
             System.out.println(i+"Recordg Inserted");
             
             System.out.println("Do You Want To Continue:Y/N");
             String s=br.readLine();
             
             if(s.startsWith("n")) {
            	 System.out.println("EXIT");
            	 break;
             }
             }while(true);
         con.close();
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
	}

}
