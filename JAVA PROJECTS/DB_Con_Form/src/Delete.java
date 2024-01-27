import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Delete")
public class Delete extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException{
	String sid=request.getParameter("id");
	int id=Integer.parseInt(sid);
	try{
		Class.forName("com.mysql.jdbc.Driver");
	
	Connection con=DriverManager.getConnection("jdbc: mysql://localhost/emp_data","root","");
	Statement st;
	st=con.createStatement();
	st.execute("delete from registeruser where id='"+id+"'");
	response.sendRedirect("View");
	
	}catch(Exception e2){System.out.println(e2);}
	}
}