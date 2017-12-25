<%-- 
    Document   : my_leave
    Created on : Feb 2, 2017, 4:43:09 PM
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
<script type="text/javascript">
    $(function () {
        $('#date').datetimepicker({format: ' yyyy',viewMode: "years", 
    minViewMode: "years"});
    });
</script>
<h:Navigation topic="Show My Leave" />
<c:if test="${currentList == null and previousList == null}">
    <form method="post" action="${initParam.Root}lm/MyLeaveDetails">
        <label onclick="$('#div-for-range').hide();"><input type="radio" name="listType" value="current" selected />Show All Leave for this year</label>
        <br><br>
        <label onclick="$('#div-for-range').show();"><input type="radio" name="listType" value="previous">Previous Year Records</label>
        <div class="row" id="div-for-range" style="display: none;">
            <div class="col-md-3">Year</div>
            <div class="col-md-3"><div class="input-group date" id="date"><input type="text" name="year" class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span></div></div>
        </div> 
        <br>
        <input class="btn btn-primary" type="submit" name="submit" value="View">
    </form>
</c:if>
<c:if test="${currentList != null}">
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
            <c:forEach items="${currentList}" var="leave" varStatus="no">
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
<c:if test="${previousList != null}">
    <c:if test="${year != null}">
        <div><h4>Leave History for Year : ${year-1}-${year}</h4></div>
    </c:if>
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
            <c:forEach items="${previousList}" var="leave" varStatus="no">
                <tr>
                    <td>${leave.id.empLeaveId}</td>
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