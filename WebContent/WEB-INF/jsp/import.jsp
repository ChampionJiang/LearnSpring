<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.UUID, java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Please select the files to upload
<form id="upload" method="post" action="upload" enctype="multipart/form-data" name="form1">
<input type="file" name="file"/><br/>
<input type="submit" name="Import" value="upload"/>

</form>

</body>
</html>
