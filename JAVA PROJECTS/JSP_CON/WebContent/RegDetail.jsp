<%@ include file="Connection.jsp" %>
<%@ page import= "java.sql.*" %>
<%!  int Id; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Registration Detail</title>
</head>
<body>
<%!
ResultSet rs;
Statement st;
%>
<%
out.println("<a href='index.jsp'>Add New Employee</a>"); 
try{
st=con.createStatement();
rs=st.executeQuery("select *from reg");
%>
<center><h1 align="center">Registration Detail</h1></center>
<table border="1" align="center">
<tr>
<td>Id</td>
<td>Name</td>
<td>Password</td>
<td>Email</td>
<td>Country</td>
<td>Edit</td>
<td>Delete</td>
</tr>
<%
while(rs.next())
{
Id=rs.getInt(1);
%>
<tr>

<td><%out.println(rs.getInt(1)); %></td> 
<td><%out.println(rs.getString(2)); %></td>
<td><%out.println(rs.getString(3)); %></td>
 <td><%out.println(rs.getString(4)); %></td>
  <td><%out.println(rs.getString(5)); %></td>
   <td><a href="updateReg.jsp?id=<%= Id %>">edit</a></td>
<td><a href="delete.jsp?id=<%= Id %>">delete</a></td>
</tr>
<%
}
rs.close();
st.close();
con.close();
%>
</table>
<%
}
catch(Exception e){out.println(e); }
%>
</body>
</html>