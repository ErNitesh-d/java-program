<%@ include file="Connection.jsp" %>
<%@ page import="java.sql.*" %>

<%! int Id; %>
<%! String Name, Password, Email, Country; %>
<%
out.println("<h1>Update Employee</h1>");
String sid=request.getParameter("id");
int id=Integer.parseInt(sid);
PreparedStatement ps = con.prepareStatement("select * from reg where id=?");
ps.setInt(1,id);
ResultSet rs=ps.executeQuery();
if(rs.next()){
id=rs.getInt(1);
Name=rs.getString(2);
Password=rs.getString(3);
Email=rs.getString(4);
Country=rs.getString(5);
}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update.jsp" method="post">

<table>
<tr>
<td></td>
<td><input type='hidden' name='id' value=<%= id %>></td>
</tr>
<tr>
<td>Name:</td>
<td><input type="text" name="name" value=<% out.print(Name); %>></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password" value=<%out.print(Password); %> >
</td>
</tr>
<tr>
<td>Email:</td>
<td><input type="email" name="email" value=<%out.print(Email); %>></td>
</tr>
<tr>
<td>Country: </td>
<td>
<select name="country" style="width:150px">
<option>India</option>
<option>USA</option>
<option>UK</option>
<option>Other</option>
</select>
</td>
</tr>
<td colspan="2"><input type="submit" value="Update Employee"/></td>
</tr>
<tr>
</table>
</form>
</body>
</html>
