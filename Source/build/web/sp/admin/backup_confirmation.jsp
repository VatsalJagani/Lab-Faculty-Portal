<%-- 
    Document   : backup_confirmation
    Created on : May 5, 2017, 5:43:33 PM
    Author     : VATSAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<h:Header />
    <h:Navigation topic="Confirmation" />
    <h4 class="text-center">Confirm you wanna take backup of subject preferences module, this will lead to move all data from this year to backup</h4>
    <form action="${initParam['Root']}sp/admin/SpBackup">
        <div class="text-center"><input type="submit" class="btn btn-danger text-center" value="Confirm"></div>
    </form>
<h:Footer />