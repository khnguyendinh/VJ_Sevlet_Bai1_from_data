<%--
  Created by IntelliJ IDEA.
  User: KHOAND
  Date: 11/13/2017
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>File Upload:</h3>
Select a file to upload: <br />
<form action="UploadServlet" method="POST"
      enctype="multipart/form-data">
    <input type="file" name="file" size="50000" />
    <br />
    <input type="submit" value="Upload File" />
</form>
</body>
</html>
