<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" />
        <link rel="stylesheet" href="webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.min.css" />
        <title>Add Todo</title>
    </head>

    <body>  

        <div class="container">

            <h2>Enter Todo Details</h2>
            <form:form method="post" modelAttribute="todo">

                <fieldset class="mb-3">
                    <form:label path="description">Description</form:label>
                    <form:input type="text" path="description" required="required" />
                    <form:errors path="description" cssClass="text-warning"/>
                </fieldset>

                <fieldset class="mb-3">
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input type="text" path="targetDate" required="required" />
                    <form:errors path="targetDate" cssClass="text-warning"/>
                </fieldset>

                <button type="submit" class="btn btn-success">Submit</button>
            </form:form>
        
        </div>


    </body>

    <script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>

    <script type="text/javascript">
        $('#targetDate').datepicker({format: 'yyyy-mm-dd'});
    </script>

</html>
