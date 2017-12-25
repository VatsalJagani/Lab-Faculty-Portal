<%-- 
    Document   : load_arrange
    Created on : Feb 2, 2017, 3:53:39 PM
    Author     : VATSAL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="gen.Subject" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/portalTLD" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>

<h:Header />
<script type="text/javascript" src="${initParam['Root']}styles/bootstrap-datetimepicker/moment.js"></script>
  <script type="text/javascript" src="${initParam['Root']}styles/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
  <link rel="stylesheet" href="${initParam['Root']}styles/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" />
<script type="text/javascript">
            $(function () {
                $('.date').datetimepicker();
            });
        </script>
    <h:Navigation topic="Arrangement of work during leave" />
    <form method="post" action="${initParam.Root}lm/ArrangeLoad">
        <input type="hidden" value="${slots}" name="slots">
        <input type="hidden" value="${leaveid}" name="leaveId">
        <table class="table">
            <tr>
                <th>Sr no.</th>
                <th>Date</th>
                <th>Semester</th>
                <th>Subject</th>
                <th>Division/Batch</th>
                <th>Room no.</th>
                <th>Faculty who will engage Class</th>
            </tr>
            <c:forEach var="no" begin="1" end="${slots}">
                <tr>
                    <td>${no}</td>
                    <td><div class="input-group date" class="date"><input type="text" name="time[${no}]" class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span></div></td>
                    <td><select class="form-control" name="sem[${no}]">
                        <option value="01">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">M.Tech 1</option>
                        <option value="10">M.Tech 2</option>
                        <option value="11">M.Tech 3</option>
                        <option value="12">M.Tech 4</option>
                        
                    </select></td>
                    <td><select class="form-control" name="sub[${no}]">
                        <c:forEach var="sub" items="${subjects}">
                            <option value="${sub.subShortName}">${sub.subShortName}</option>
                        </c:forEach>
                    </select></td>
                    <td><input type="text" name="div[${no}]" class="form-control" required="required" /></td>
                    <td><input type="text" name="roomno[${no}]" class="form-control" required="required" /></td>
                    <td><select name="faculty[${no}]" class="form-control">
                            <c:forEach var="f" items="${faculties}">
                                <option value="${f.id}">${f.firstName} ${f.lastName}</option>
                            </c:forEach>
                                </select></td>
                </tr>
            </c:forEach>
               <!-- NOt Coded yet 
               <tr>
                    <td colspan="8"><a onclick="AddMore()">Add New</a></td>
                </tr> -->
            <tr>
                <td colspan="7" class="text-center"><input type="submit" class="btn btn-primary" name="submit" value="&emsp;Submit&emsp;" ></td>
            </tr>
            
        </table>
    </form>
<h:Footer />