<%-- 
    Document   : pending_request
    Created on : Mar 9, 2017, 7:40:19 PM
    Author     : VATSAL
--%>

<%-- copy code from the requests_of_load_arrangement.jsp 
import EmpLeaveRequest pojo class
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/portalTLD" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="hibernate.pojos.EmpLeaveRequest" %>
<h:Header />
    <h:Navigation topic="Pending Leave Requests" />
    <c:if test="${allRequests != null}">
        <table class="table table-hover">
            <tr>
                <th>Emp. Leave Id</th>
                <th>Faculty Name</th>
                <th>Leave Type</th>
                <th>Apply Date</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>No of Days</th>
                <th>Reason</th>
                <th>Address During Leave</th>
                <th>Remark</th>
                <th>Approve</th>
                <th>Reject</th>
            </tr>
            <c:forEach var="req" items="${allRequests}">
                <form action="ApproveRequest?leaveid=${req.empLeaveId}" method="post">    
                <tr>
                    <td>${req.empLeaveId}</td>
                    <td>${req.empName}</td>
                    <td>${req.leaveShortName}</td>
                    <td><fmt:formatDate value="${req.applyDate}" type="date"></fmt:formatDate></td>
                    <td><fmt:formatDate value="${req.startDate}" type="date"></fmt:formatDate></td>
                    <td><fmt:formatDate value="${req.endDate}" type="date"></fmt:formatDate></td>
                    <td><fmt:formatNumber maxFractionDigits="1">${req.noOfDays}</fmt:formatNumber></td>
                    <td>${req.reason}</td>
                    <td>${req.addressDuringLeave}</td>
                    <td><input type="text" class="form-control" value="${req.hodRemark}" name="remark"</td>
                    <%-- also check if already approved then disabled button  --%>
                    <c:if test="${fn:equalsIgnoreCase(req.status, 'Pending' )}">
                    <td><input type="submit" class="btn btn-primary" title="This request is Pending.." name="task" value="Approve"></td>
                        <td><input type="submit" class="btn btn-primary" title="This request is Pending.." name="task" value="Reject"></td>
                    </c:if>
                    
                    <c:if test="${fn:equalsIgnoreCase(req.status, 'Approved' )}">
                        <td colspan="2" class="text-left"><a class="btn disabled" title="This request is Approved..">Approved</a></td>
                    </c:if>
                    <c:if test="${fn:equalsIgnoreCase(req.status, 'Rejected' )}">
                        <td colspan="2" class="text-right"><a class="btn disabled" title="This request is Rejected..">Rejected</a></td>
                    </c:if>
                </tr>
                </form>
            </c:forEach>
        </table>
    </c:if>
<h:Footer />
