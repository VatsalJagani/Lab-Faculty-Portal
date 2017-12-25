<%-- 
    Document   : requests_of_load_arrangement
    Created on : Feb 3, 2017, 11:14:37 PM
    Author     : VATSAL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/portalTLD" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="lm.LoadArrangementRequest" %>
<h:Header />
    <h:Navigation topic="Load Arrangement Requests" />
    <c:if test="${allRequests != null}">
        <table class="table table-hover">
            <tr>
                <th>Faculty Name</th>
                <th>Leave Type</th>
                <th>Date</th>
                <th>Time</th>
                <th>Semester</th>
                <th>Subject</th>
                <th>Division/Batch</th>
                <th>Room no.</th>
                <th>Approve</th>
                <th>Reject</th>
            </tr>
            <c:forEach  var="request" items="${allRequests}">
                <tr>
                    <td>${request.facultyName}</td>
                    <td>${request.leaveType}</td>
                    <td><fmt:formatDate value="${request.loadArrangement.id.date}" type="date"></fmt:formatDate></td>
                    <td>${request.loadArrangement.id.time}</td>
                    <td>${request.loadArrangement.semester}</td>
                    <td>${request.loadArrangement.subjectName}</td>
                    <td>${request.loadArrangement.divBatch}</td>
                    <td>${request.loadArrangement.roomNo}</td>
                    <%-- also check if already approved then disabled button  --%>
                    <c:if test="${fn:equalsIgnoreCase(request.loadArrangement.status, 'Pending' )}">
                        <td><a class="btn btn-primary" title="This request is Pending.." href="LoadArrangementAccept?task=approve&leaveid=${request.loadArrangement.id.empLeaveId}&date=${request.loadArrangement.id.date}&time=${request.loadArrangement.id.time}">Approve</a></td>
                        <td><a class="btn btn-primary" title="This request is Pending.." href="LoadArrangementAccept?task=reject&leaveid=${request.loadArrangement.id.empLeaveId}&date=${request.loadArrangement.id.date}&time=${request.loadArrangement.id.time}">Reject</a></td>
                    </c:if>
                    <c:if test="${fn:equalsIgnoreCase(request.loadArrangement.status, 'Approved' )}">
                        <td colspan="2" class="text-left"><a class="btn disabled" title="This request is Approved..">Approved</a></td>
                    </c:if>
                    <c:if test="${fn:equalsIgnoreCase(request.loadArrangement.status, 'Rejected' )}">
                        <td colspan="2" class="text-right"><a class="btn disabled" title="This request is Rejected..">Rejected</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </c:if>
<h:Footer />