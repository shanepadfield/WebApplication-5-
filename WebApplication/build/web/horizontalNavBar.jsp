<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<nav id="horizontal">
        <ul>
            <c:choose>
                <c:when test="${currentProfile != null}">                   
                    <li><a href="ProfileController?action=signout">(Sign out)</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="ProfileController?action=signin">Sign In</a></li>
                </c:otherwise>
            </c:choose>
            <li><a href="ProfileController">My Saved Music</a></li>
            <li><a href="">Other</a></li>
        </ul>
    </nav>
</html>
