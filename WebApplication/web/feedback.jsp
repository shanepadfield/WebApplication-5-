
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Shane's Music News and Reviews</title>
<link rel="stylesheet" href="newcss.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<jsp:include page="header.jsp"/>
    <jsp:include page="horizontalNavBar.jsp"/>
	<main>
		<section>
                    Rate the album<br>
                    <article>
                    <img src="Images/${item.itemCode}.jpg" alt="${item.itemName}">
                    <h1>${item.itemName}</h1>
                    <h3>Album Review</h3>
                    
                    <form action="ProfileController?action=confirmUpdate&itemCode=${item.itemCode}" method="post">
                        <br><br><br><br><br><br><br>
                        <!--<a href="ProfileController?action=confirmUpdate&itemCode=${item.itemCode}" class="button">Confirm Rating</a>-->
                        
                        <p>Listened: 
                            <label><input type="radio" name="listened" value="true" ${listened == true ? 'checked="checked"' : ''}>Yes</label>
                            <label><input type="radio" name="listened" value="false"${listened == false ? 'checked="checked"' : ''}>No</label>
                        </p>

                        Rating:
                        <select name="userRating">
                            <option value="1" ${userRating == 1 ? 'selected="selected"' : ''}>1</option>
                            <option value="2" ${userRating == 2 ? 'selected="selected"' : ''}>2</option>
                            <option value="3" ${userRating == 3 ? 'selected="selected"' : ''}>3</option>
                            <option value="4" ${userRating == 4 ? 'selected="selected"' : ''}>4</option>
                            <option value="5" ${userRating == 5 ? 'selected="selected"' : ''}>5</option>
                        </select>
                        <br><br><br>
                        <input type="submit" value="Confirm Rating">
                    </form>
                    <br><br>
                    <a href="ProfileController">Return to the Saved Items page</a>
                    </article>
		</section>
	<aside>
	<jsp:include page="verticalNavBar.jsp"/>
	</aside>
	</main>
<jsp:include page="footer.jsp"/>
</body>
</html>