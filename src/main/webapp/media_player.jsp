<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset=UTF-8">
<title>视频播放</title>
</head>
<body>
	<%
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "utf-8");
	%>
	<video width="80%" height="80%" src="<%=name %>" controls="controls"></video>
</body>
</html>