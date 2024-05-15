<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
    </head>

    <body>

        <div class="login">
            <h4>Welcome to the login page! <strong>${name}</strong></h4>
            
            <form method="post">
                Name: 
                <input type="text" name="name"> 
                Password: <input type="password" name="password">
                <button type="submit">Enviar</button>
            </form>
    
            <strong>${loginError}</strong>

        </div>



    </body>

    <style>
        html, body {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        .login {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .login strong {
            color: red;
        }

    </style>

</html>
