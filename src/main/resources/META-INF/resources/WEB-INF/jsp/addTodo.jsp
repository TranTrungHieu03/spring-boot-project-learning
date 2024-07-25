<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>List todo page</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>

<div class="container">
    <h1>Enter todo detail</h1>
    <form:form method="post" modelAttribute="todo">
        Description: <form:input name="description" path="description"
                                 required="true"/>
        <form:errors path="description" cssClass="text-warning" />
        <form:input name="done" path="id" type="hidden"/>
        <form:input name="done" path="done" type="hidden"/>
        <input type="submit" class="btc btn-success"/>
    </form:form>
</div>

</body>
</html>