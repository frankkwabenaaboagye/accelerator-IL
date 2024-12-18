<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>ToDo List</title>
</head>
<body>
<h2>ToDo List</h2>
<ul>
    <c:forEach var="todo" items="${todos}">
        <li>
                ${todo.title} - ${todo.completed ? 'Completed' : 'Not Completed'}
            <a href="/todo/complete/${todo.id}">Complete</a>
        </li>
    </c:forEach>
</ul>
<form action="/todo/add" method="POST">
    <input type="text" name="title" placeholder="New ToDo" required />
    <button type="submit">Add</button>
</form>
</body>
</html>