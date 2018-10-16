
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Eprevue du candidat</title>

    <jsp:include page="/WEB-INF/jsp/head.jsp">
        <jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
    </jsp:include>

</head>
<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp">
        <jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
    </jsp:include>
    <div class="container">
        <div class="container text-center">

        </div>
    </div>
    <jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

    ${requestScope.get('epreuve').etat}
</body>
</html>
