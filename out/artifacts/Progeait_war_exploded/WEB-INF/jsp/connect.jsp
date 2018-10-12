<%--
  Created by IntelliJ IDEA.
  User: kretail2017
  Date: 12/10/2018
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/jsp/head.jsp">
        <jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
    </jsp:include>

</head>
<body>

<jsp:include page="/WEB-INF/jsp/header.jsp">
    <jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
</jsp:include>

<title>Se connecter</title>
<div class="container">

    <div class="container text-center">
        <form method="post" action="/QCM/connect">
            <label>Nom d'utilisateur <input type="text" class="form-text" placeholder="Nom d'utilisateur"
                                            name="user"></label> <br>
            <label>Mot de passe <input type="password" placeholder="Mot de passe" class="form-text"
                                       name="password"></label> <br>
            <input type="submit" class="btn btn-success" value="Se connecter">
        </form>
    </div>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>
