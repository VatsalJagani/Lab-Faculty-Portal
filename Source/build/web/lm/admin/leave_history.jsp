<%-- 
    Document   : leave_history
    Created on : Feb 3, 2017, 11:20:18 PM
    Author     : VATSAL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/tlds/portalTLD" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="hibernate.pojos.EmpLeaveRequest" %>
<h:Header />
<script type="text/javascript">
    function printData()
    {
        var divToPrint = document.getElementById("printTable");
        var htmlToPrint = '' +
                '<style type="text/css">' +
                'table, table th, table td {' +
                'border: 2px solid black;' +
                'border-collapse: collapse;' +
                'font-family:areial;' +
                'text-align: left;' +
                'font-size:100%;' +
                'height: 10px;' +
                'line-height: 120%;' +
                'padding: 5px;' +
                '}' +
                '</style>';
        htmlToPrint += divToPrint.outerHTML;
        newWin = window.open("");
        newWin.document.write(htmlToPrint);
        newWin.print();
        newWin.close();
    }
</script>
<h:Navigation topic="Show Leave History" />
<c:if test="${list == null}">
    <form method="post" action="${initParam.Root}lm/admin/LeaveHistory">

        <table class="table">
            <tr>
                <td align="right">Faculty (Initials) : </td>
                <td><input class="form-control" type="text" name="initials"></td>
            </tr>
            <tr>
                <td colspan="2" class="text-center"><input class="btn btn-primary" type="submit" value="Get History"></td>
            </tr>
        </table>
    </form>
</c:if>
<c:if test="${list != null}">
    <div><h4><u>Leave History of Faculty : ${facultyname}</u></h4></div>
    <table class="table text-center table-responsive table-bordered table-hover table-striped">
        <tr class="active">
                    <th>EMP.LEAVE ID</th>
                    <th>LEAVE TYPE</th>
                    <th>APPLY DATE</th>
                    <th>FROM</th>
                    <th>TO</th>
                    <th>APPROVE DATE</th>
                    <th>NO OF DAYS</th>
                    <th>REASON FOR LEAVE</th>
                    <th>ADDRESS DURING LEAVE</th>
                    <th>REMARK</th>
                    <th>HOD REMARK</th>
                    <th>STATUS</th>
            </tr>
            <c:forEach items="${list}" var="leave" varStatus="no">
                <tr>
                    <td>${leave.empLeaveId}</td>
                    <td>${leave.leaveShortName}</td>
                    <td><fmt:formatDate value="${leave.applyDate}" type="date"></fmt:formatDate></td>
                    <td><fmt:formatDate value="${leave.startDate}" type="date"></fmt:formatDate></td>
                    <td><fmt:formatDate value="${leave.endDate}" type="date"></fmt:formatDate></td>
                    <td><fmt:formatDate value="${leave.approveDate}" type="date"></fmt:formatDate></td>
                    <td><fmt:formatNumber maxFractionDigits="1">${leave.noOfDays}</fmt:formatNumber></td>
                    <td>${leave.reason}</td>
                    <td>${leave.addressDuringLeave}</td>
                    <td>${leave.remark}</td>
                    <td>${leave.hodRemark}</td>
                    <td>${leave.status}</td>
                </tr>
            </c:forEach>
    </table>
</c:if>

<h:Footer />