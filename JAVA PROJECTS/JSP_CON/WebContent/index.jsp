<html>
<head>
<meta charset="ISO-8859-1"> 
<title> program </title> 
</head> 
<body> 
<h1> Add New Employee </h1>
<form action="SaveRegistration.jsp" method ="post" >
<table> 
<tr>
 		<td> Name:</td>
 		<td><input type="text" name="name"/> </td>
</tr>
<tr>
 		<td> Password:</td>
 		<td> <input type="password" name="password"/> </td>
</tr>
<tr>
 		<td> Email:</td> 
 		<td> <input type="email" name="email"/> </td>
</tr>
<tr>
<td>Country:</td>
<td>
		<select name="country" style="width 150px"> 
		<option>India</option> 
		<option>USA</option> 
		<option>UK</option>
		 <option>Other</option>
 		</select>
 </td>
 </tr>
 <tr>
 	<td colspan="2"><input type="submit" value="Save Employee"/></td>
 </tr>
 </table>
 </form>
 <br/>
 		<a href="RegDeatil.jsp">View Details</a>
</body>
</html>

