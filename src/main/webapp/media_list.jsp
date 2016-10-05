<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频列表</title>
</head>
<body>
	<div>
		<ul>
			<c:forEach items="${videolist}" var="item">
				<li>title:${item.getName()}
					<a href="/web/media_player.jsp?name=${item.getName()}">
						<img alt="pic" width="20px" height="20px" src="/web/video.jpg">
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>