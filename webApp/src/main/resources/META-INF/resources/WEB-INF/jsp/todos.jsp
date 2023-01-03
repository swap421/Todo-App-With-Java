<%@ include file = "common/header.jspf" %>
<%@ include file = "common/navigation.jspf"%>
<div class = "container">
<h3>Your Todos</h3>
<table class = "table">
    <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done</th>
            <th></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <f:forEach items = "${todos}" var = "todo">
            <tr>
                <td>${todo.description}</td>
                <td>${todo.date}</td>
                <td>${todo.done}</td>
                <td><a href = "delete-todo?id=${todo.id}" class = "btn btn-danger">Delete</a></td>
                <td><a href = "update-todo?id=${todo.id}" class = "btn btn-warning">Update</a></td>
            </tr>
        </f:forEach>
    </tbody>
</table>
<a href = "add-todo" class = "btn btn-primary">Add Todo</a>
</div>
<%@ include file = "common/footer.jspf" %>
