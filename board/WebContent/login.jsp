<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function moveto()
	{
		window.location = 'join.jsp';
	}
</script>
</head>
<body>
<% 
	if(request.getAttribute("check")!=null){
		int check = (Integer)request.getAttribute("check");
		if(check != 1) {
%>
			<script language="javascript">
				alert("로그인 실패");
			</script>
<%
		}
	}
%>
	
		
	<form action="loginOk.lg" method="post" name="login_form">
		ID : <input type="text" name="id"> <br>
		PW : <input type="password" name="pw"> <br>
		&nbsp;&nbsp;&nbsp;<input type="submit" value="로그인">&nbsp;<input type="button" value="회원가입" onclick="moveto()">
	</form>
</body>
</html>