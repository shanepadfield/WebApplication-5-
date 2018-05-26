<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    
<head>
<title>Shane's Music News and Reviews</title>
<link rel="stylesheet" href="newcss.css">
</head>

<body>
    <jsp:include page="header.jsp"/>
    <jsp:include page="horizontalNavBar.jsp"/>
	<main>
		<section>
                    Home > Categories
                    <h1>Categories</h1><br>
                    <h2>Metal Reviews</h2>
                    
                    <c:forEach items="${anReviews}" var="i">
                    <c:if test="${i.category == 'Metal'}">
                        <a href="CatalogController?itemCode=${i.itemCode}">${i.itemName}</a><br>
                    </c:if>
                    </c:forEach>
                    
                    <h2>Rock/Pop Reviews</h2>
                    
                    <c:forEach items="${anReviews}" var="i">
                    <c:if test="${i.category == 'Rock/Pop'}">
                        <a href="CatalogController?itemCode=${i.itemCode}">${i.itemName}</a><br>
                    </c:if>
                    </c:forEach>
                    
		</section>
	<aside>
	<jsp:include page="verticalNavBar.jsp"/>
	</aside>
	</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
