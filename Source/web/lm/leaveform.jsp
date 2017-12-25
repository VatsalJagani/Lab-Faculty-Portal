<%-- 
    Document   : leaveform
    Created on : Feb 1, 2017, 9:58:44 PM
    Author     : VATSAL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/portalTLD" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>

<h:Header />
<script type="text/javascript" src="${initParam['Root']}styles/bootstrap-datetimepicker/moment.js"></script>
  <script type="text/javascript" src="${initParam['Root']}styles/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
  <link rel="stylesheet" href="${initParam['Root']}styles/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" />
<script type="text/javascript">
            $(function () {
                $('#date0').datetimepicker({format: 'DD/MM/YYYY'});
                $('#date1').datetimepicker({format: 'DD/MM/YYYY'});
                $('#date2').datetimepicker({format: 'DD/MM/YYYY'});
            });
            
            function typeChange() {
                if (document.getElementById("leave").value == "hcl"){
                    $('#halfCausal').show();
                    $('#other1').hide();
                    $('#other2').hide();
                }     
                else{
                    $('#halfCausal').hide();
                    $('#other1').show();
                    $('#other2').show();
                }        
            }
        </script>
    <h:Navigation topic="Apply For Leave" />
    <form method="post" action="${initParam.Root}lm/InsertLeave">
        <table class="table">
            <tr>
                <td class="text-right">Leave For : </td>
                <td colspan="2"><select class="form-control" id="leave" name="type" onchange="typeChange()">
                    <option value="cl">Casual Leave</option>
                    <option value="hcl">Half Casual Leave</option>
                    <option value="sl">Sick Leave</option>
                    <option value="dl">Duty Leave</option>
                    <c:if test="${fn:equalsIgnoreCase(sessionScope.user.userType,'nontech')}">
                        <option value="pl">Privilege Leave</option>
                    </c:if>
                    <c:if test="${fn:equalsIgnoreCase(sessionScope.user.gender,'F')}">
                        <option value="ml">Maternity Leave</option>
                    </c:if>
                    </select></td>
            </tr>
            <tr id="halfCausal" style="display:none">
                <td class="text-right">Date :-</td>
                <td colspan="2"><div class="input-group date" id="date0"><input type="text" name="ddate" class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span></div></td>
            </tr>
            
            <tr id="other1">
                <td rowspan="2" class="text-right">Period :-</td>
                <td class="text-right">From : </td>
                <td><div class="input-group date" id="date1"><input type="text" name="from" class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span></div></td>
            </tr>
            <tr id="other2">
                <td class="text-right">To : </td>
                <td><div class="input-group date" id="date2"><input type="text" name="to" class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span></div></td>
            </tr>
            <tr>
                <td class="text-right">Reason for leave : </td>
                <td colspan="2"><input type="text" name="reason" class="form-control" required="required" /></td>
            </tr>
            <tr>
                <td class="text-right">Address During Leave : </td>
                <td colspan="2"><input type="text" name="addr" class="form-control" required="required" /></td>
            </tr>
            <tr>
                <td class="text-right">Remark : </td>
                <td colspan="2"><input type="text" name="remark" class="form-control" required="required" /></td>
            </tr>
            
            <tr>
                <td class="text-right">Load arrangement : </td>
                <td class="text-right">No of slots you want to arrange : </td>
                <td class="text-right"><input type="number" name="slots" class="form-control" required="required" /></td>
            </tr>
            <tr>
                <td colspan="3" class="text-center"><input type="submit" class="btn btn-primary" name="submit" value="&emsp;Submit&emsp;" ></td>
            </tr>
        </table>
    </form>
    <br>
    <div class="row">
        <div class="col-md-6">
            <table class="table table-hover table-bordered">
        <tr><th colspan="2" class="active text-center">Leave Available Information</th></tr>
        <tr><td>Causal-Leave Available</td><th>${empLeaveInfo.clAvailable}</th></tr>
        <tr><td>Sick-Leave Available</td><th>${empLeaveInfo.slAvailable}</th></tr>
        <c:if test="${fn:equalsIgnoreCase(sessionScope.user.userType,'nontech')}">
        <tr><td>Privilege-Leave Available</td><th>${empLeaveInfo.plAvailable}</th><tr>
        </c:if>
        <c:if test="${fn:equalsIgnoreCase(sessionScope.user.gender,'F')}">
        <tr><td>Maternity-Leave Available</td><th>${empLeaveInfo.mlAvailable}</th><tr>
        </c:if>
    </table>
        </div>
    </div>
    
<h:Footer />