<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" />
        <title>List Todos</title>
    </head>

    <body>  

        <div class="container">

            <h2>Welcome ${name}</h2>
            <hr>
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


    </body>

    <script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js">

    </script>

    <script src="werbjars/jquery/3.6.0/jquery.min.js">

    </script>


</html>
