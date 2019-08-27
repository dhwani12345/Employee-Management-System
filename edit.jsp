<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="employee.registration.details.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
</head>
<body>

	<h3>Inside Edit.jsp !!!</h3>
		
	<form name="updateform" action="EditEmployeeInfo" method="post">
	<table name="update_table" border=1 style="background-color: skyblue; margin-left: 20px ; margin-right: 20px;"> 
			<tr> 
				<th>Sr.no</th> 
				<th>FirstName</th> 
				<th>LastName</th> 
				<th>BirthDate</th> 
				<th>JoiningDate</th>
				<th>Salary</th>
				<th>Edit</th>
			</tr>
			
			<tr>
				<td><input type="text" name="sr_no" required></td>
				<td><input type="text" name="FirstName" required></td>
				<td><input type="text" name="LastName" required></td>
				<td><input type="text" name="BirthDate" required></td>
				<td><input type="text" name="JoinDate" required></td>
				<td><input type="text" name="Salary" required></td>
				<td><input type="submit" name="edit" value="Edit"></td>
			</tr>
			
		</table>
	
	</form>
	
</body>
</html>