<%-- 
    Document   : change_password
    Created on : Jan 25, 2017, 10:07:52 PM
    Author     : VATSAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<h:Header />
<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("passwd").value;
        var confirmPassword = document.getElementById("re-passwd").value;
	
        if (password != confirmPassword) {
            alert("Passwords did't match, please varify!!");
            return false;
        }
        else{
            document.getElementById("myForm").submit();
        }
    }
</script>
<h:Navigation topic="Change Your Password" />
<div class="row">
    <div class="col-md-8">
        <form action="changePassword" method="post" id="myForm" onsubmit="Validate();">
            <table align="center" class="table">
                
                <tr>
                    <td class="text-right"><h6>Current Password :</h6>&emsp;&emsp;</td>
                    <td><input type="password" name="cPassword" class="form-control" required></td>
                </tr>
                <tr>
                    <td class="text-right"><h6>New Password :</h6>&emsp;&emsp;</td>
                    <td><input type="password" id="passwd" name="nPassword" class="form-control" required></td>
                </tr>
                <tr>
                    <td class="text-right"><h6>Confirm Password :</h6>&emsp;&emsp;</td>
                    <td><input type="password" id="re-passwd" name="cnPassword" class="form-control" required></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" class="btn btn-primary" value="&emsp;&emsp;Change Password&emsp;&emsp;" /></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<h:Footer />
</body>
</html>