
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>Enter todo detail</h1>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
            <form:label path="description">Description:</form:label>
            <form:input name="description" path="description"
                        required="required"/>
            <form:errors path="description" cssClass="text-warning" />
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date:</form:label>
            <form:input name="targetDate" path="targetDate"
                        required="required"/>
            <form:errors path="targetDate" cssClass="text-warning" />
        </fieldset>

        <form:input name="done" path="id" type="hidden"/>
        <form:input name="done" path="done" type="hidden"/>
        <input type="submit" class="btc btn-success"/>
    </form:form>
</div>
<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
    $("#targetDate").datepicker({
        format: "yyyy-mm-dd",
        startDate: "-3d"
    })
</script>
