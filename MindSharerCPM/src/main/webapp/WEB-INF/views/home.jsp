<%@page import="com.mscp.web.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	User dao = (User) request.getAttribute("user");
	System.out.printf("%s %s", dao.getNickName(), dao.getRegDttm().toString());
%> 
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8" >
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  admin uid is <%=dao.getUid() %>. </P>
<P>  admin deviceId is <%=dao.getDeviceId() %>. </P>
<P>  admin nickName is <%=dao.getNickName() %>. </P>
<P>  admin regDttm is <%=dao.getRegDttm().toString() %>. </P>
</body>
</html>
