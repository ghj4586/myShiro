<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>success</h2>



	<shiro:hasRole name="admin">
		<a href="admin.jsp">admin</a>

	</shiro:hasRole>

	<shiro:hasAnyRoles name="user">

		<a href="user.jsp">user</a>
	</shiro:hasAnyRoles>

	<a href="shiro/testannotation">test annotation</a>


	<a href="shiro/logout">Logout</a>
</body>
</html>