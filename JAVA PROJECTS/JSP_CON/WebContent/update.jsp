<%@ include file="Connection.jsp" %>
<%@ page import="java.sql.*" %>
<%
String sid=request.getParameter("id");
int id=Integer.parseInt(sid);
String name=request.getParameter("name");
String password=request.getParameter("password");
String email=request.getParameter("email");
String country=request.getParameter("country");

PreparedStatement ps=con.prepareStatement("update reg setname=?,password=?,email=?,country=? where id=?");
ps.setString(1,name);
ps.setString(2,password);
ps.setString(3,email);
ps.setString(4,country);
ps.setInt(5,id);
ps.executeUpdate();
con.close();
response.sendRedirect("RegDetail.jsp");
%>