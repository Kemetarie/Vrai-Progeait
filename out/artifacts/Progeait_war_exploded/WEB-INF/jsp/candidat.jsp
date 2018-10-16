
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            Date Debut de validité du test : ${requestScope.get('epreuve').dateDebutValidite} <br>
            Date Fin de validité du test : ${requestScope.get('epreuve').dateFinValidite}<br>
            Etat du test : ${requestScope.get('epreuve').etat}
            <div class="container pre-scrollable">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col" width="80%">Nom</th>
                        <th scope="col" width="10%"></th>
                        <th scope="col" width="10%"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listeTests}" var="Test">
                        <tr>
                            <td>${Test.libelle}</td>
                            <td style="text-align: right">
                                <a href='${pageContext.request.contextPath}/QCM/test&id=${Test.idTest}'>
                                        votre Test
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>


            </div>
        </div>
    </div>
    <jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>
