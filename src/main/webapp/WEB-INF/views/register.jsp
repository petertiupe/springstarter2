<%--
  Created by IntelliJ IDEA.
  User: R606-05
  Date: 05.12.2017
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Register</h1>
<form method="POST">
    First Name: <input type="text" name="vorname" /><br/>
    Last Name: <input type="text" name="nachname" /><br/>
    Username: <input type="text" name="username" /><br/>
    Password: <input type="password" name="passwort" /><br/>
    <input type="submit" value="Register" />
</form>
</body>
</html>
