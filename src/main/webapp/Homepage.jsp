<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage</title>
</head>
<body>
This is the main page.

<%
String username=null, Jid=null;
/* Cookie[] ck = request.getCookies();
if(ck != null)
{
	for(Cookie ir : ck)
	{
		if(ir.getName().equals("UserName")){ username = ir.getValue();}
		if(ir.getName().equals("JSESSIONID")) { Jid = ir.getValue();}
	
	}
}
if(username == null && Jid == null)
{
	response.sendRedirect("login.jsp");
}
*/ 
if(request.getSession().getAttribute("username")== null)
{
	response.sendRedirect("login.jsp");
}
else{
	username = request.getSession().getAttribute("username").toString();
	Jid = request.getSession().getId();
}

%>
Username inserted:   <%= username %> <br>
Session id is: <%= Jid %>
<br>
<br>

 <form action="<%= request.getContextPath()%>/Logout" method="get">
    <input type="hidden" name="action" value="destroy">
    <input type="submit" value="logout">

</form> 
</body>
</html>