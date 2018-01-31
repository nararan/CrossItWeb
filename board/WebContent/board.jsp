<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="jdk.nashorn.internal.ir.RuntimeNode.Request"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<%
	if(session.getAttribute("memberId") == null) {
%>
	<<jsp:forward page="login.jsp" />
<%
	}
	String mId = (String)session.getAttribute("memberId");
	String mName = (String)session.getAttribute("memberName");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	접속정보 || 이름 : <%= mName %> , ID : <%= mId %> || <br>
	
<%
String str="안녕하세요";
out.println(str);

//String strInUser = new String(request.getParameter("txtInUser").getBytes("Cp1252"), "EUC-KR"); 

//String strInUser = new String(request.getParameter("txtInUser").getBytes("KSC5601"),"8859_1"); 

//String strInUser = new String(request.getParameter("txtInUser").getBytes("EUC-KR"), "KSC5601"); 

//String strInUser = new String(request.getParameter("txtInUser").getBytes("8859_1"),"MS949"); 

// 브라우저에 한글을 출력하기 전에 먼저 변환해 줌
str = new String(str.getBytes("8859_1"), "KSC5601");
out.println(str);

// 파일이나 DB에 한글을 저장할 때 먼저 아래처럼 변환해 줌
str = new String(str.getBytes("KSC5601"), "8859_1");
out.println(str);


str = new String(str.getBytes("KSC5601"), "8859_1");
out.println(str);


str = new String(str.getBytes("Cp1252"), "EUC-KR");
out.println(str);
%> 
	
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.bId}</td>
			<td>${dto.bName}</td>
			<td>
				<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
				<a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
			<td>${dto.bDate}</td>
			<td>${dto.bHit}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"> <a href="write_view.do">글작성</a> </td>
		</tr>
	</table>
</body>
</html>