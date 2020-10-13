<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>02_upload.jsp : 동일 파일 중복 선택</title>
</head>
<body>
<form action="upload2.do" method="post" enctype="multipart/form-data">
		
		1: 파일 지정하기 : <input type="file" name="uploadFile1"><br/>
		2: 파일 지정하기 : <input type="file" name="uploadFile2"><br/>
		3: 파일 지정하기 : <input type="file" name="uploadFile3"><br/>
		<input type="submit" value="전송">
	</form>

</body>
</html>