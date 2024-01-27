import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/View")
public class ViewData extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/emp_data","root","");
   Statement st;
			st=con.createStatement();
			ResultSet res=st.executeQuery("select *from registeruser");
			out.println("<table border='1'>");
			out.println("<tr><th>id</th>"
			+ "<th>Name</th>"
			+ "<th>Password</th>"
			+ "<th>Email</th>"
			+ "<th>Country</th>"
			+ "<th>Edit</th>"
			+"<th>Delete</th></tr>");
			
			while(res.next())
			{
			int id=res.getInt("id");
			out.println("<tr>");
			out.println("<td>"+res.getInt("id")+"</td>");
			out.println("<td>"+res.getString("name")+"</td>");
			out.println("<td>"+res.getString("password")+"</td>");
			out.println("<td>"+res.getString("email")+"</td>");
			out.println("<td>"+res.getString("country")+"</td>");
			out.print("<td><a href=Edit?id="+id+">Edit</a></td>");
			out.print(" <(td>/<a href=Delete?id="+id+">Delete</a></td>");
			out.println("</tr>");
			}
			
			}catch (Exception e2) {System.out.println(e2);}
			out.println("<table>");
			out.println("<a href='register.html'>Add Record</a>");
			out.close();
			}
}