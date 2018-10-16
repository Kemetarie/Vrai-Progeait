
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
            Date Debut de validité du test : ${requestScope.get('epreuve').dateDebutValidite} <br>
            Date Fin de validité du test : ${requestScope.get('epreuve').dateFinValidite}<br>
            Etat du test : ${requestScope.get('epreuve').etat}
            ${listeTests}
            <c:forEach var="toto" items="${listeTests}"  >
                <p>${toto}
            </c:forEach>
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
                    <c:forEach items="${listeTests}" var="toto" >
                        <tr>
                            <td>${toto}</td>
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
