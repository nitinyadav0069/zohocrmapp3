<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create page</title>
</head>
<body>
<h1>Create Online</h1>

<form action="saveLead" method="post">
     <pre>
     First Name<input type="text" name="firstname"/>
     last Name<input type="text" name="lastname"/>
     email<input type="text" name="email"/>
     mobile<input type="text" name="mobile"/>
     <input type="submit" value="save"/>
     
     
     </pre>
</form>

${msg}

</body>
</html>