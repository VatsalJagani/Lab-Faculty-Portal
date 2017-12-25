<%-- 
    Document   : offered_subjects
    Created on : Jan 28, 2017, 9:39:59 PM
    Author     : VATSAL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<h:Header />
<h:Navigation topic="Edit Offered Subjects" />
<c:if test="${subjectsMap eq null}">
    <form method="post" action="${initParam.Root}sp/admin/GetAllSubjects">
        <label><input type="radio" name="semType" value="odd">Odd</label>
        <br>
        <label><input type="radio" name="semType" value="even">Even</label>
        <br><br>    
        <input class="btn btn-primary" type="submit" name="submit" value="View">
    </form>
</c:if>
<c:if test="${subjectsMap != null}">
    <form action="${initParam.Root}sp/admin/EditOfferedSubjects" method="post">
        <input type="hidden" value="${requestScope.type}" name="semType">
        <c:forEach items="${subjectsMap}" var="sem">
            <table>
                <tr><th>${sem.key}</th></tr>
                        <c:forEach items="${sem.value}" var="s">

                    <tr><td>
                            <label><input type="checkbox" name="subjects" value="${s.subId}"
                                          <c:if test="${s.offered eq 1}">
                                              checked
                                          </c:if>
                                          >
                                &nbsp;&nbsp;
                                ${s.subName}</label>
                        </td>
                    </tr>

                </c:forEach>
                <tr><th>&ensp;</th></tr>
            </table>
        </c:forEach>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input type="submit" value="&emsp;Save&emsp;" class="btn btn-primary">
    </form>
</c:if>
<h:Footer />