<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Meal list</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meal list</h2>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>DateTime</th>
            <th>Description</th>
            <th>Calories</th>
        </tr>
    <c:forEach var="meal" items="${requestScope.meallist}">
       <tr>
           <td><c:out value="${fn:replace(meal.getDateTime(), 'T', ' ')}" /></td>
           <td><c:out value="${meal.getDescription()}"/></td>
           <td><c:out value="${meal.getCalories()}"/></td>
       </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>
