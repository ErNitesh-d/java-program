<%@ include file="Connection.jsp" %>
<%@ page import="java.sql.*" %>
<%

String sid=request.getParameter("id");
int id=Integer.parseInt(sid);
PreparedStatement ps=con.prepareStatement("delete from reg where id=?");
ps.setInt(1,id);
ps.executeUpdate();
con.close();
response.sendRedirect("RegDetail.jsp");
%>