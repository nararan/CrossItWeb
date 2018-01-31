<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" >
	function pwcheck(){
		if(document.join_form.id.value && document.join_form.pw.value && document.join_form.name.value && document.join_form.address.value && document.join_form.email.value)
		{
			;
		}	
		else
		{
			alert("비어있는 필드가 있습니다. 모든 필드를 입력해주세요.");
			return;
		}
		
		
		if(document.join_form.pw.value != document.join_form.pw_con.value)
		{
			alert("패스워드가 일치하지 않습니다. 다시 입력해주세요.");	
		}
		else{
			alert("회원가입 완료");
			document.join_form.submit();
		}
	}
</script>
</head>
<body>
	<form action="joinOk.lg" method="post" name="join_form">
		ID : <input type="text" name="id"> <br>
		PW : <input type="password" name="pw"> <br>
		PW(confirmed) : <input type="password" name="pw_con"> <br>
		Name : <input type="text" name="name"> <br>
		address : <input type="text" name="address"> <br>
		e-mail : <input type="text" name="email"> <br>
		&nbsp;&nbsp;&nbsp;<input type="button" value="가입요청" onclick="pwcheck()">&nbsp;<input type="reset" value="취소" onclick="javascript:window.location = 'main.lg'">
	</form>

</body>
</html>