<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form Cryption</title>
<script type="text/javascript" src="script/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="script/lib/AesUtil.js"></script>
<script type="text/javascript" src="script/lib/jquery.jcryption.3.0.js"></script>
<script type="text/javascript" src="script/my.js"></script>
<script type="text/javascript">
	var appPath = '<%=path %>';
</script>
<style>
.container {
	margin: 40px auto;
	width: 800px;
	text-align: center;
}
ul.controls {
	list-style: none;
	padding: 20px 0;
}

ul.controls li {
	margin-bottom: 15px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Form Cryption Test</h1>
		<form action="TestServlet" method="get" id="normal">
			<fieldset>
				<ul class="controls">
					<li><label>UserName: </label><input type="text" name="username"></li>
					<li><label>PassWord: </label><input type="password" name="password"></li>
				</ul>
				<input type="button" id="testBtn" value="Test">
				<input type="submit" id="submitBtn" value="Submit">
				<input type="reset" id="testBtn" value="Reset">
			</fieldset>
		</form>
	</div>
</body>
</html>