<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
    </head>

    <body>

        <div class="container">
            <h4>Welcome to the login page!</h4>
            
            <form method="post">
                Name: 
                <input type="text" name="name"> 
                Password: <input type="password" name="password">
                <button type="submit">Enviar</button>
            </form>
    
            <strong>${loginError}</strong>

        </div>

    </body>

</html>
