<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="employee.registration.details.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Information</title>
</head>
<body>

	<h3>Employee Detail</h3>
	<form name="insertform" action="RegisterEmployeeInfo" method="post">
		<table name="inserttable" style="background-color: skyblue; margin-left: 20px ; margin-right: 20px;">
			<tr>
				<td> First Name : </td> <td> <input type="text" name="firstname" required></td>
				<td> Last Name : </td> <td> <input type="text" name="lastname" required></td>
			</tr>
		    
		    <tr>
				<td> Joining Date : </td> <td> <input type="date" name="joiningdate"  required></td>
				<td> BirthDate : </td> <td> <input type="date" name="birthdate" required></td>
				
			</tr>
			
			 <tr>
				<td> Qualification : 	
					<select size="1" name="qualification">
						<option value="M.Tech">M.Tech</option>
						<option value="M.C.A.">M.C.A.</option>
						<option value="B.Tech" selected>B.Tech</option>
					</select>
				</td> 
				<td></td>
				<td> Salary : </td> <td> <input type="text" name="salary" required></td>
			</tr>
			
			 <tr>
				<td> Gender : </td> 
				<td> <input type="radio" name="gender" value="M" checked>Male</td>
				<td> <input type="radio" name="gender" value="F">Female</td>
			</tr>
		    
			<tr>
				<td> <input type="submit" name="submit" value="Submit"></td> 
				<td> <input type="button" name="reset"  onclick="location.href='employee.jsp';" value="Reset"></td> 
		
		</table>
		
	</form>
</body>
</html>