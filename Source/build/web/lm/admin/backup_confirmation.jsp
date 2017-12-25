<%-- 
    Document   : backup_confirmation
    Created on : May 5, 2017, 5:56:29 PM
    Author     : VATSAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<h:Header />
    <h:Navigation topic="Confirmation" />
    <h4 class="text-center">Confirm you wanna take backup of leave management module, this will lead to move all data from this year to backup</h4>
    <form action="${initParam['Root']}lm/admin/Backup">
        <div class="text-center"><input type="submit" class="btn btn-danger text-center" value="Confirm"></div>
    </form>
<h:Footer />