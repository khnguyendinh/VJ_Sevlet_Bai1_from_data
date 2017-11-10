<%--
  Created by IntelliJ IDEA.
  User: lampstudio
  Date: 11/11/2017
  Time: 1:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form
        action="ReadParams" method="POST" target="_blank"
>
    <input type="checkbox" name="maths" checked="checked"/> Maths
    <input type="checkbox" name="physics"/> Physics
    <input type="checkbox" name="chemistry" checked="checked"/> Chem
    <input type="submit" value="Select Subject"/>
</form>
</body>
</html>
