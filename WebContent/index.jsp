
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <h2>Admin Screen</h2>
 
        <form>
            <input type="button" value="create" onclick="window.location='/create'"/>
 
    <table border="1">
        <c:forEach var="user" items="${userList}">
            <tr>
            <td><input type="hidden" name="id" value="${user.id}"></td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.telephone}</td>
                <td><input type="button" value="delete" onclick="window.location='/delete?id=${user.id}'"/></td>
                <td><input type="button" value="update" onclick="window.location='/update?id=${user.id}'"/></td>
            </tr>
        </c:forEach>
    </table>  
    
        </form>
</body>
</html>