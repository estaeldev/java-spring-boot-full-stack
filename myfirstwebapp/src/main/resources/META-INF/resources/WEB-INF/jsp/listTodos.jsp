<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">

    <h2>Your Todos</h2>

    <table class="table">
        <thead>
            <tr>
                <th>DESCRIPTION</th>
                <th>TARGET DATE</th>
                <th>DANE</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                    <td> 
                        <a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a> 
                        <a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a> 
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="add-todo" class="btn btn-success">Add Todo</a>

</div>


<%@ include file="common/footer.jspf" %>
