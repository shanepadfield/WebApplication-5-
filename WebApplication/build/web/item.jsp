<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
                    Home > Categories > Item<br>
                    <article>
                    <img src="Images/${item.itemCode}.jpg" alt="${item.itemName}">
                    <h1>${item.itemName}</h1>
                    <h3>Album Review</h3>
                    <h3>${item.score}</h3>
                    <br><br><br><br><br>
                    <c:choose>
                        <c:when test="${currentProfile != null}">
                            <a href="ProfileController?action=favorite&itemCode=${item.itemCode}" class="button">Save It!</a>
                            <a href="ProfileController?action=rate&itemCode=${item.itemCode}" class="button">Rate It!</a>
                        </c:when>
                        <c:otherwise>
                            <p><a href="ProfileController?action=signin">Sign in</a> to save or rate items</p>
                        </c:otherwise>
                    </c:choose>
                    <br><br>
                    <p>${item.description}</p><br>
                    <a href="CatalogController">Return to the Categories page</a>
                    </article>
		</section>
	<aside>
	<jsp:include page="verticalNavBar.jsp"/>
	</aside>
	</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
