<%-- 
    Document   : subject_preferences
    Created on : Jan 25, 2017, 11:42:46 PM
    Author     : VATSAL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/tlds/portalTLD" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<h:Header />
<h:Navigation topic="Select Subject Preferences" />

<form method="post" action="${initParam.Root}sp/UpdateSubjectPreferences" onsubmit="return validateSelection();">
    <c:if test="${subjectsMap eq null}">
        <h3><font color="green">Subject Preference Module is disabled</font></h3>
    </c:if>
    <c:if test="${subjectsMap != null}">
        <c:forEach var="sem" items="${subjectsMap}">
            <table border="0" style="width:100%">
                <tr>
                    <th colspan="1">${sem.key}</th>
                </tr>

                <c:forEach items="${sem.value}" var="s">

                    <c:if test="${s.offered eq 1}">                        
                        <tr>
                            <td><label><input type="checkbox" name="subjects" value="${s.subId}"
                                       <c:if test="${!empty selectedSubIds && fn:contains( selectedSubIds, s.subId )}">
                                           checked
                                       </c:if>
                                           >
                                &nbsp;&nbsp;
                                ${s.subName}</label>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
            <br>             
        </c:forEach>
            <hr>
        <table boder="0">
            <tr><th colspan="3"><h4>Preferred Time Slot</h4></th></tr>
            <tr>
                <td><label><input type="radio" name="slot" value="Morning"
                           <c:if test="${!empty slotPreference && fn:equalsIgnoreCase( slotPreference , 'Morning' )}">
                               checked
                           </c:if>
                               >Morning</label>&emsp;&emsp;
                </td>
                <td><label><input type="radio" name="slot" value="Noon"
                           <c:if test="${!empty slotPreference && fn:equalsIgnoreCase(slotPreference, 'Noon' )}">
                               checked
                           </c:if>
                           >Noon</label>&emsp;&emsp;
                </td>
                <td><label><input type="radio" name="slot" value="Any"
                           <c:if test="${!empty slotPreference && fn:equalsIgnoreCase(slotPreference, 'Any' )}">
                               checked
                           </c:if>
                           <c:if test="${empty slotPreference}">
                               checked
                           </c:if>
                           >Any</label>&emsp;&emsp;
                </td>    
            </tr>
        </table>
        <br>
        <input class="btn btn-primary" type="submit" name="Submit" value="&ensp;Confirm&ensp;">

        <script type="text/javascript">
            function validateSelection()
            {
                var howMany = 0;
                var cboxes = document.getElementsByName('subjects');
                var len = cboxes.length;
                for (var i = 0; i < len; i++)
                {
                    if (cboxes[i].checked)
                        howMany++;
                }
                //var howMany = $('input[type="checkbox"]:checked').length;
                if (howMany < 3)
                {
                    alert("Select minimum 3 subjects");
                    return false;
                }
                else
                {
                    //document.myForm.submit();
                    return true;
                }
            }
        </script>
    </c:if>
</form>
<h:Footer />
