<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>List Todos</title>
    </head>

    <body>  

        <h2>Welcome ${name}</h2>
        <hr>
        <h2>Your Todos</h2>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>DESCRIPTION</th>
                    <th>TARGET DATE</th>
                    <th>DANE</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>


</html>
