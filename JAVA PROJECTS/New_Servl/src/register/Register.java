package register;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends HttpServlet {

	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name"); 
		String password=request.getParameter("password");
		String email =request.getParameter("email"); 
		String country=request.getParameter("country");
		
		try {
			Class.forName("com.mysql.jdbc.Driver") ; 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/reg","root","") ; 
			
			PreparedStatement ps= con.prepareStatement("insert into user(name,password,email,country)values(?,?,?,?)");
			 ps.setString(1,name); 
			 ps.setString(2,password); 
			 ps.setString(3,email); 
			 ps.setString(4,country); 
	int i		= ps.executeUpdate(); 
	if(i>0) {
		out.print("<p>Record saved successfully!</p>"); 
		 request.getRequestDispatcher("register.html").include(request,response); 
	}else {
		out.print("unccessfully");
	}
		}catch(Exception e2){System.out.println(e2);
			
		}
		

	}

}
