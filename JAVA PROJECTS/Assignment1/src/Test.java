import java.sql.*;
import java.io.*;
class Test {
 public static void main(String args[]) throws Exception {
 Class.forName("com.mysql.cj.jdbc.Driver");
 Connection con = DriverManager.getConnection(
 "jdbc:mysql://localhost/collage", "root", "");
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 System.out.println("insert:1");
 System.out.println("update:2");
 System.out.println("delete:3");
 System.out.println("show:4");
 System.out.println("exit:5");
 PreparedStatement preparedStmt = con.prepareStatement("?");
 System.out.println("select querry:");
 int a = Integer.parseInt(br.readLine());
 preparedStmt.setInt(1,a);
 System.out.println("you are select");
 do {
 int b = a;
 switch (b) {
 case 1:
 System.out.println("insert");
 PreparedStatement d = con.prepareStatement("insert into student values(?,?,?)");
 System.out.println("enter id:");
 int e = Integer.parseInt(br.readLine());
 System.out.println("enter name:");
 String f = br.readLine();
 System.out.println("enter age:");
 int g = Integer.parseInt(br.readLine());
 d.setInt(1, e);
 d.setString(2, f);
 d.setInt(3, g);
 int i = d.executeUpdate();
 System.out.println(i + " records inserted");
 break;
 case 2:
 System.out.println("update");
 PreparedStatement l = con.prepareStatement("update student set name=?,age=? where id=?");
 System.out.println("enter name:");
 String h = br.readLine();
 System.out.println("enter age:");
 int k = Integer.parseInt(br.readLine());
 System.out.println("enter id:");
 int m = Integer.parseInt(br.readLine());
 l.setString(1, h);
 l.setInt(2, k);
 l.setInt(3, m);
 int j = l.executeUpdate();
 System.out.println(j + " records updated");
 break;
 case 3:
 System.out.println("delete");
 PreparedStatement n = con.prepareStatement("DELETE FROM student WHERE id = ?");
 System.out.println("enter id:");
 int o = Integer.parseInt(br.readLine());
 n.setInt(0,o);
 int p = n.executeUpdate();
 System.out.println(p + " records deleted");
 break;
 case 4:
 System.out.println("show");
 Statement q = con.createStatement();
 ResultSet rs = q.executeQuery("select * from student");
 while (rs.next())
	 
 System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
rs.getString(3));
 con.close();
 break;
 default:
 System.out.println("exit");
 break;
 }
 System.out.println("Do you want to continue: y/n");
 String s = br.readLine();
 if (s.startsWith("n")) {
 break;
 }
 } while (true);
 con.close();
 }
}
