import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
@SuppressWarnings("serial")
public class App_Form extends HttpServlet{
public void doGet(HttpServletRequest req, HttpServletResponse res) throws
ServletException,IOException
{
try {
res.setContentType("text/Html");
PrintWriter pw = res.getWriter();
String FirstName=req.getParameter("FirstName");
String LastName=req.getParameter("LastName");
String Gender=req.getParameter("Gender");
String Country=req.getParameter("Country");


pw.println("<b>REGISTRATION COMPLETE </b>");
pw.println("<table border = 1><tr><th>FirstName:</th><td>"+ FirstName
+"</td></tr><tr><th>LastName:</th><td>"+ LastName +"</td></tr><tr><th>Gender:</th><td>"+
Gender +"</td></tr><tr><th>Country:</th><td>"+ Country +"</td></tr></table>");
} catch (Exception e) { System.out.println(e);
}
}
}
