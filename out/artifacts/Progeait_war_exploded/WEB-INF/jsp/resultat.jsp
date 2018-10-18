
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Epreuve du candidat</title>

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

        Wow vous êtes trop fort, bravo, 20 points pour Gryffondor

        <table class="table">
            <thead>
            <tr>
                <th scope="col" width="80%">Nom</th>
                <th scope="col" width="10%"></th>
                <th scope="col" width="10%"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${numquestion}" var="question" >
                <tr>
                    <td>${question.numOrdre}</td>
                    <td>${bonneprop.estBonne}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>
