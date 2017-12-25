<%-- 
    Document   : home
    Created on : Jan 25, 2017, 10:04:05 PM
    Author     : VATSAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<h:Header />
    <h:Navigation topic="Welcome, ${sessionScope.user.userName}" />
<h:Footer />