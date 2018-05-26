
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    About<br>
                    <h1></h1>
                    <p>We are a music news and review site that posts frequently about a wide range of music</p>
		</section>
	<aside>
            <jsp:include page="verticalNavBar.jsp"/>
	</aside>
	</main>
            <jsp:include page="footer.jsp"/>
</body>
</html>
