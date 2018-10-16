<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp"
         isErrorPage="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="header">
    <img src="${pageContext.request.contextPath}/images/ENI.jpg" alt="ENI" height="42" width="42">
    <div class="header-right">
        <a class="active" href="/QCM/homejsp">Home</a>
        <c:choose>
        <c:when test="${sessionScope.get('user') == null}">
            <a class="active" href="/QCM/connect">Se connecter</a>
        </c:when>
        <c:otherwise>

            <a href="/QCM/connect" >Se déconnecter</a>
            <a href="/QCM/candidat">Vos tests</a>
        </c:otherwise>
        </c:choose>
        <a href="/QCM/contact">Contact</a>
        <a href="/QCM/about">About</a>
    </div>
</div>