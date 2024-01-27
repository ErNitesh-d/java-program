
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Edit")
public class Edit extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException{
	
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	out.println("<h1>Update Record</h1>");
	String sid=request.getParameter("id");
	int id=Integer.parseInt(sid);
	try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection ("jdbc:mysql://localhost/emp_data","root","");
	Statement st;
	st=con.createStatement();
	
	ResultSet res=st.executeQuery("select *from registeruser where id="+id+"");
	res.next();
	out.print ("<form action='EditServlet' method='post'>");
	out.print ("<input type='hidden' name='id' value='"+res.getInt("id")+"'/><br>");
	out.print("Name: <input type='text' name='name' value='"+ res.getString("name")+ "	<br>");
	
	out.print("Password: <input type='password' name='password' value='"+res.getString
	("password")+"'/> <br>");
	out.print("Email: <input type='email' name='email'value='"+res.getString("email")+"'/> <br>");
	out.print("Country:");
	out.print("<select name='country' style='width:150px'>");
	out.print("<option>India</option>");
	out.print("<option>USA</option>");
	out.print("<option>UK</option>");
	out.print("<option>Other</option>");
	out.print("</select><br><br>");
	out.print("<input type='submit' value='Edit &amp; Save '/>");
	out.print("</form>");
	}catch(Exception e2) {System.out.println(e2);}
}
}
