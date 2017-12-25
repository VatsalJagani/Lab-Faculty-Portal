<%-- 
    Document   : enable_preferences
    Created on : Jan 28, 2017, 8:51:29 PM
    Author     : VATSAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<h:Header />
    <h:Navigation topic="Enable-Disable Subject-Preferences Module" />
    <div>
        <form action="${initParam.Root}sp/admin/EnablePreferencesModule" method="post">
        <table class="table table-responsive table-bordered">
            <tr><th><label><input type="radio" name="preference" value="closed">Disable Module</label></th></tr>
            <tr><td><label><input type="radio" name="preference" value="odd">Enable with ODD semester</label></td></tr>
            <tr><td><label><input type="radio" name="preference" value="even">Enable with EVEN semester</label></td></tr>
            <tr><td class="text-center"><input type="submit" value="Set" class="btn btn-primary"></td></tr>
        </table>
        </form>
    </div>
<h:Footer />