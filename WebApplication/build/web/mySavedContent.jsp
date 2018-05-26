<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                <h1>My Saved Albums</h1><br>
                <c:choose>
                    <c:when test="${not empty currentProfile.items}">
                        <table>
                            <th>Album & Artist</th>
                            <th>Rating</th>
                            <th>Listened</th>
                            <th></th>
                    
                            <c:forEach items="${currentProfile.items}" var="i">
                                <tr>
                                    <td><a href="CatalogController?itemCode=${i.item.itemCode}">${i.item.itemName}</a></td>
                                    <c:choose>
                                        <c:when test="${i.rating == 0}">
                                            <td>None</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${i.rating}/5</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${i.madeIt == true}">
                                            <td>Yes</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>No</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td><a href="ProfileController?action=update&itemCode=${i.item.itemCode}">Update</a>
                                    <a href="ProfileController?action=delete&itemCode=${i.item.itemCode}">Delete</a></td> 
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <p>No items saved</p>  
                    </c:otherwise>
                </c:choose>
            </section>
            <aside>
                <jsp:include page="verticalNavBar.jsp"/>
            </aside>
        </main>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
