
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation. WebServlet;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException
{
response.setContentType("text/html");
PrintWriter out=response.getWriter();
String sid=request.getParameter("id");
int id=Integer.parseInt(sid);
String name=request.getParameter("name");
String pass=request.getParameter("password");
String email =request.getParameter("email");
String country=request.getParameter("country");
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc: mysql://localhost/emp_data","root","");
Statement st;
st=con.createStatement();
st.execute("update registeruser set name='"+name+"' ,password='"+pass+"',email='"+email+"',country='"+country+"'where id='"+id+"'");
response.sendRedirect("View");
}catch(Exception e2){System.out.println(e2);}
}
}