<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" />
        <title>Add Todo</title>
    </head>

    <body>  

        <div class="container">

            <h2>Enter Todo Details</h2>
            <form method="post">
                Description: <input type="text" name="description">
                <button type="submit" class="btn btn-success">Submit</button>
            </form>

        </div>


    </body>

    <script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js">

    </script>

    <script src="werbjars/jquery/3.6.0/jquery.min.js">

    </script>


</html>
