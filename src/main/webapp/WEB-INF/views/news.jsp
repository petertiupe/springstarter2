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
    <title>News</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />">
</head>
<body>
<h1>Latest News</h1>

<table class="table">
    <c:forEach items="${newList}" var="news">
        <tr>
            <td>${news.titel}</td>
            <td>${news.text}</td>
            <td>${news.dateTime}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
