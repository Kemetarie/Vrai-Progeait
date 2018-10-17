<%@ page language="java" errorPage="error.jsp" isErrorPage="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <audio controls loop hidden autoplay>
        <source src="${pageContext.request.contextPath}/images/Wub Wub.mp3">
    </audio>
    <style>
        body{
            background-color:black;
            animation: image 0.10s infinite alternate;
            animation:image 0.10s infinite alternate;
            animation:image 0.10s infinite alternate;
        }

        p{
            color: white;
        }
        h1{
            color: white;
        }
        @keyframes image{
            0%{
                background-color:blue;
            }
            25%{
                background-color:red;
                }
            50%{
                background-color:green;
            }
            75%{

                background-color:yellow;
            }
            100%{
                background-color:red;
            }
        }
    </style>
    <title>About Us</title>
    <jsp:include page="/WEB-INF/jsp/head.jsp">
        <jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
    </jsp:include>

</head>
<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp">
        <jsp:param name="contextPath" value="${pageContext.request.contextPath}"/>
    </jsp:include>

    <div class="container">

        <h1 class="mt-5">About Us</h1>
        <div class="col-md-12">
            <p>WE F*CKING SUCK</p>

        </div>
    </div>
    <jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>
