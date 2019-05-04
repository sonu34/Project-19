<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="common_things.Common_Things"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <!-- meta -->
    <meta charset="utf-8">
    <link rel='stylesheet' href='css/style.css'>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>	 
                <div class='container' style="text-align:center;height:25px">
                <img alt="Online Ocr" src="https://onlineocr.net/Images/ONLINE_OCR_LOGO.JPG"><br>
                <h1>FREE OCR SERVICE</h1><br>
                <h1>CONVERT IMAGE PNG/JPG TO TEXT</h1><br><br>
				<form action="<%=Common_Things.url %>/FileUploadHandler/" enctype="multipart/form-data" method="post">
				                <h5>Select</h5><br>
				                <input type="file" name="file2" /><br><br>
								<h5>File Name</h5><br>
								<input type="text" name="file_name_given">             <br><br>
				              <input style="text-align:center; class="btn btn-primary" type="submit" value="upload" />
				  </form>
				  <hr><br>
				  <div style="text-align:right;">@ENGLISH</div>
				</div>
</body>
</html>