<%@ page language="java" errorPage="error.jsp" isErrorPage="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Contact</title>
    <jsp:include page="/WEB-INF/jsp/head.jsp">
        <jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
    </jsp:include>

</head>
<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp">
        <jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
    </jsp:include>

    <div class="container">

        <h1 class="mt-5">OUI</h1>
        <div class="col-md-12">

            <img src="${pageContext.request.contextPath}/images/phone.jpeg" height="1000" width="1000">
        </div>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

</body>
</html>
