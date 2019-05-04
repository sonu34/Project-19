<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="common_things.Common_Things"%>
<%@page import="OCR.create_file"%>
<%@page import="OCR.read_file"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <!-- meta -->
    <meta charset="utf-8">
    <link rel='stylesheet' href='css/style.css'>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>	
                <div style="height:25;" class='container'>
                <img alt="Online Ocr" src="https://onlineocr.net/Images/ONLINE_OCR_LOGO.JPG"><br>
                <h1>FREE OCR SERVICE</h1><br>
                <h1>CONVERT IMAGE PNG/JPG TO TEXT</h1><hr><hr><br>
				<%
				String file_name=(String)request.getParameter("file_name");
				String file_name_given=(String)request.getParameter("file_name_given");
				
				//creating the out put file after upload and reading
				create_file obj_create_file=new create_file();
				obj_create_file.create_output_file(file_name);
				
				//read the created out put file
				read_file obj_read_file=new read_file();
				String read=obj_read_file.read_file(file_name);
				%>
				<h4>Upload File : </h4>
				<%=file_name %><br><br>
				<h4>File Name : </h4>
				<%=file_name_given %><br>
	
<br>
<br>
<hr>
<%=read %>
<hr>
<br><br>
<br><br><br>
read success!!...
<hr><br>
				  <div style="text-align:right;">@ENGLISH</div>
</div>
</body>
</html>