<%-- 
    Document   : print_sp
    Created on : Jan 26, 2017, 9:18:36 PM
    Author     : VATSAL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/tlds/portalTLD" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<h:Header />
<script type="text/javascript">
            function printData()
            {
                var divToPrint=document.getElementById("printTable");
                 var htmlToPrint = '' +
                    '<style type="text/css">' +
        'table, table th, table td {' +
                  'border: 1px solid black;'+
                 'border-collapse: collapse;'+      
                 'font-family:areial;'+
                 'text-align: left;'+
                 'font-size:100%;'+
                 'height: 10px;'+
                 'line-height: 120%;'+
                 'padding: 5px;'+
        '}' +
        '</style>';
    htmlToPrint += divToPrint.outerHTML;
                newWin= window.open("");
                newWin.document.write(htmlToPrint);
                newWin.print();
                newWin.close();
            }
        </script>
<h:Navigation topic="All Preferences" />
<c:if test="${allList == null}">
    <form method="post" action="${initParam.Root}sp/admin/AllPreferences">

                                <label><input type="radio" name="listType" value="sub">Subject Wise</label>
                                    <br><br>
                                <label><input type="radio" name="listType" value="faculty">Faculty Wise</label>
                                <br><br>
                                <label><input type="radio" name="listType" value="slot">Slot Wise</label>
                                <br><br>    
                                <input class="btn btn-primary" type="submit" name="submit" value="View">
                         </form>
</c:if>
    <c:if test="${allList != null}">
        <c:choose>
            <c:when test="${fn:equalsIgnoreCase(listType, 'sub' )}">
                <c:set var="title1" value="Subject" scope="page" />
                <c:set var="title2" value="Faculty Names" scope="page" />
                <c:set var="sub_title" value="Subject wise" scope="page" />
            </c:when>
            <c:when test="${fn:equalsIgnoreCase(listType, 'faculty' )}">
                <c:set var="title1" value="Faculty Names" scope="page" />
                <c:set var="title2" value="Subject" scope="page" />
                <c:set var="sub_title" value="Faculty wise" scope="page" />
            </c:when>
            <c:when test="${fn:equalsIgnoreCase(listType, 'slot' )}">
                <c:set var="title1" value="Prefered Slot" scope="page" />
                <c:set var="title2" value="Faculty Names" scope="page" />
                <c:set var="sub_title" value="Slot wise" scope="page" />
            </c:when>
        </c:choose>
        <form method="post" action="${initParam.Root}sp/admin/print_sp.jsp">
                           <div id="printTable">
                               <h4>Subject Preference List (${pageScope.sub_title})</h4>
                           <table class="table table-bordered">
                        <tr>
                            <th class="myrow">${title1}</th>
                            <th class="myrow">${title2}</th>
                        </tr>
                <c:forEach var="mapEntry" items="${allList}">
                <tr>
                    <td colspan="1">${mapEntry.key}</td>
                    <td>

                <c:forEach var="listValue" items="${mapEntry.value}">
                    ${listValue},&ensp;
                </c:forEach>
                    </td>
                </tr>
                </c:forEach>
                           </table>
                           </div>
            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; 
            <input class="btn btn-success" type="button" name="print" value="Print" onclick="printData()">
                               &emsp;&emsp;&emsp;&emsp;&emsp;
                               <input class="btn btn-primary" type="submit" name="submit" value="Back">
                       </form>
        </c:if>
        
<h:Footer />