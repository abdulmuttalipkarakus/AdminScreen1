<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User</title>
</head>
<body>
<form>
            <input type="hidden" name="id">
            <label for="name">User Name</label>
            <input type="text" id="name" name="name"/>
            <label for="name">User Surname</label>
            <input type="text" id="surname" name="surname"/>
            <label for="name">Telephone</label>
            <input type="text" id="telephone" name="telephone"/>
            <table border="1">
            <tr>
                <td><input type="button" value="create" onclick="window.location='user/update?id=${user.id}?name=${user.name}?surname=${user.surname}?telephone=${user.telephone}'"/></td>
                <td><input type="button" value="cancel" onclick="window.location='user/cancel'"/></td>
            </tr>
            </table>
   </form>
</body>
</html>