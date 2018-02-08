<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page session = "false" %>
<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file = "include/header.jsp" %>

	<!-- left column -->
<div class = "col-md-12">
	<!-- general form elements -->
	
	<div class = "box">
		<div class = "box-header with-border">
			<h3 class = "box-title">LIST ALL PAGE</h3>
		</div>
	
		
		<div class = "box-body">
			<table class = "table table-bordered">
				<tr>
					<th style = "width: 10px">BNO</th> <!-- th태그 : 표 제목 -->
					<th>TITLE</th>
					<th>WRITER</th>
					<th>REGDATE</th>
					<th style = "width: 40px">VIEWCNT</th>
				</tr>
			</table>
		</div>
		<!-- /.box.body -->
		
		<div class = "box-footer">Footer</div>
		<!-- /.box.footer -->
	</div>
</div>
<!-- /.col (left) -->
	
	
	
	<!-- regist 성공 시 -->
	<script>
		var result = '${msg}';
		
		if(result == 'success'){
			alert("처리가 완료되었습니다.");
		}
	</script>
	
<%@ include file = "include/footer.jsp" %>
	