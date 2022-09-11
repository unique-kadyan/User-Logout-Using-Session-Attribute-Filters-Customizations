<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/Login" method="post" >
UserName <input type="text" class="com.beans.Login" name="userName" value="Enter your Username here" required="required" /><br/>
Password <input type="password" class="com.beans.Login" name="password" value="Enter your Password here" required="required" /> <br/>
<input type="hidden" value="loginSubmit" name="action" />
<input type = "submit" value="submit" />
</form>
</body>
</html>