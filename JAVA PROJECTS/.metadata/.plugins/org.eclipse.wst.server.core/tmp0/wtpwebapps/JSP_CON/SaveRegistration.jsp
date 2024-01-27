<%@include file="Connection.jsp"%>
<%@page import= "java.sql.*"%>
<%
String name=request.getParameter("name"); 
String password=request.getParameter("password");
String email =request.getParameter("email"); 
String country=request.getParameter("country");
PreparedStatement ps=con.prepareStatement("insert into reg(name,password,email,country)values(?,?,?,?)");
 ps.setString(1,name); 
 ps.setString(2,password); 
 ps.setString(3,email); 
 ps.setString(4,country); 
 ps.executeUpdate(); 
 out.print("<p>Record saved successfully!</p>"); 
 request.getRequestDispatcher("index.jsp").include(request,response); 
 con.close(); 
 %>