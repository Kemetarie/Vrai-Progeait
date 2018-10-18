
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

            <h1>Question n°${requestScope.get('questions_tirage').numOrdre}</h1>
            <h2>${requestScope.get('questions').enonce}</h2>
            <form action="/QCM/question" method="post">
                <table class="table">
                    <tbody>
                        <c:forEach items="${list_propositions}" var="Propositions" >
                            <tr>
                                <td><input type="checkbox" name="proposition${Propositions.idProposition}question${Propositions.idQuestion}"></td>
                                <td>${Propositions.enonce}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <input type="submit" name="Valider">

            </form>
        </div>
    </div>

    <jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

</body>
</html>
