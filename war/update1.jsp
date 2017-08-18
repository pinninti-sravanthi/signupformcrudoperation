<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="update">
		<center>
			<select name="option">
				<option value="name">name</option>
				<option value="password">password</option>
				<option value="phonenumber">phonenumber</option>
			</select> 
			
			Enter the new update data:<input type="text"name="newvalue">
			
			<input type="submit" value="update">
			
		</center>
	</form>

</body>
</html>