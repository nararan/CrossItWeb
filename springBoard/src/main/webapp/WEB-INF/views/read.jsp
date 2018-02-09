<%@ include file = "include/header.jsp" %>

	<form role = "form" method = "post">
		<input type = 'hidden' name = 'bno' value = '${boardVO.bno}'>
	</form>

	<div class = "box">
			<div class = "box-header with-border">
				<h3 class = "box-title">READ BOARD</h3>
			</div>
		
			<div class = "box-body">
				<div class = "form-group">
					<label for = "exampleInputEmail1">Title</label>
					<input type = "text" name = "title" class = "form-control" value = "${boardVO.title}" readonly = "readonly">
				</div>
				<div class = "form-group">
					<label for = "exampleInputPassword1">Content</label>
					<textarea class = "form-control" name = "content" rows = "3" readonly = "readonly">${boardVO.content}</textarea>
				</div>
				<div class = "form-group">
					<label for = "exampleInputEmail1">Writer</label>
					<input type = "text" name = "writer" class = "form-control" value = "${boardVO.writer}" readonly = "readonly">
				</div>
			</div>
		
			<div class = "box-footer">
				<button type = "submit" class = "btn btn-warning">Modify</button>
				<button type = "submit" class = "btn btn-danger">Remove</button>
				<button type = "submit" class = "btn btn-primary">LIST ALL</button>
			</div>
	</div>
	
	
	<script>
		$(document).ready(function(){
			
			var formObj = $("form[role='form']");
			
			console.log(formObj);
			
			$(".btn-warning").on("click", function(){
				formObj.attr("action", "/modify");
				formObj.attr("method", "get");
				formObj.submit();
			});
			
			$(".btn-danger").on("click", function(){
				formObj.attr("action", "/remove");
				formObj.submit();
			});
			
			$(".btn-primary").on("click", function(){
				self.location = "/listAll";
			});

		});
	</script>
	

<%@ include file = "include/footer.jsp" %>