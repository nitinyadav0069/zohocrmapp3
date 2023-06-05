<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update page</title>
</head>
<body>
<h1>Update Online</h1>

<form action="updateLead" method="post">
     <pre>
     <input type="hidden" name="id" value="${lead.id}"/>
     First Name<input type="text" name="firstname" value="${lead.firstname}"/>
     last Name<input type="text" name="lastname" value="${lead.lastname}"/>
     email<input type="text" name="email" value="${lead.email}"/>
     mobile<input type="text" name="mobile" value="${lead.mobile}"/>
     <input type="submit" value="update"/>
     
     
     </pre>
</form>

${msg}

</body>
</html>