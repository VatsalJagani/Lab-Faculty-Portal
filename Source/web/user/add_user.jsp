<%-- 
    Document   : add_user
    Created on : Feb 27, 2017, 10:04:05 PM
    Author     : VATSAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<h:Header />
<script type="text/javascript" src="${initParam['Root']}styles/bootstrap-datetimepicker/moment.js"></script>
  <script type="text/javascript" src="${initParam['Root']}styles/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
  <link rel="stylesheet" href="${initParam['Root']}styles/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" />
<script type="text/javascript">
    $(function () {
        $('#date0').datetimepicker({format: 'DD/MM/YYYY'});
        $('#date1').datetimepicker({format: 'DD/MM/YYYY'});
    });
</script>
    <h:Navigation topic="Add New User" />
    <form action="${initParam.Root}user/AddUser">
        <table class="table table-striped table-hover">
            <tr>
                <td class="text-right">Name : </td>
                <td><input type="text" name="first" class="form-control" required="required" placeholder="First Name"></td>
                <td><input type="text" name="middle" class="form-control" required="required" placeholder="Middle Name"></td>
                <td><input type="text" name="last" class="form-control" required="required" placeholder="Last Name"></td>
            </tr>
            <tr>
                <td class="text-right">Salutation : </td>
                <td><input type="text" name="salutation" class="form-control" value="prof." required="required"></td>
            </tr>
            <tr>
                <td class="text-right">User-Type : </td>
                <td colspan="2"><select name="usertype" class="form-control" required="required"><option value="normal">Teaching-Staff</option><option value="non-tech">Non-Teaching Staff</option></select></td>
            </tr>
            <tr>
                <td class="text-right">Birth-Date : </td>
                <td><div class="input-group date" id="date0"><input type="text" name="birth-date" class="form-control" required="required" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span></div></td>
            </tr>
            <tr>
                <td class="text-right">Join Date : </td>
                <td><div class="input-group date" id="date1"><input type="text" name="join-date" class="form-control" required="required" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span></div></td>
            </tr>
            <tr>
                <td class="text-right">Gender : </td>
                <td colspan="2"><select name="gender" class="form-control" required="required"><option value="M">Male</option><option value="F">Female</option></select></td>
            </tr>
            <tr>
                <td class="text-right">Designation : </td>
                <td colspan="2"><select name="designation" class="form-control" required="required"><option value="P">Professor</option><option value="A">Assistant Professor</option><option value="N">Non-technical Staff</option><option value="H">HOD</option></select></td>
            </tr>
            <tr>
                <td class="text-right">Category : </td>
                <td colspan="2"><select name="category" class="form-control" required="required"><option value="g">GIA</option><option value="s">SFI</option></select></td>
            </tr>
            <tr>
                <td class="text-right">Type : </td>
                <td colspan="2"><select name="type" class="form-control" required="required"><option value="P">Permanent</option><option value="V">Visiting</option></select></td>
            </tr>
            <tr>
                <td colspan="4" class="text-center"><input type="submit" value="&emsp;Submit&emsp;" class="btn btn-primary"></td>
            </tr>
            <tr>
                <td colspan="4">Username and Password is : Department Name followed by Your Initial (all in small case)</td>
            </tr>
        </table>
    </form>
<h:Footer />