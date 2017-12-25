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
        //alert("hello");
        if (document.getElementById("reset").value == "all") {
            var password = document.getElementById("new-pass").value;
            if (password == "") {
                alert("Passwords can not be empty!!");
                return false;
            }
            else {
                document.getElementById("myForm").submit();
            }
        }
        else {
            var user = document.getElementById("user").value;
            var password = document.getElementById("passwd").value;
            if (password == "" || user == "") {
                alert("Username or Password can not be empty!!");
                return false;
            }
            else{
                document.getElementById("myForm").submit();
            }
        }
    }
    function typeChange() {
        if (document.getElementById("reset").value == "single") {
            $('#for-single').show();
            $('#for-all').hide();

        }
        else {
            $('#for-single').hide();
            $('#for-all').show();

        }
    }
</script>
<h:Navigation topic="Reset Password" />
<div class="row">
    <div class="col-md-8">
        <form action="${initParam.Root}user/ResetPassword" method="post" id="myForm" onsubmit="Validate();">

            <table class="table">
                <tr>
                    <td class="text-right">Reset Password For : </td>
                    <td colspan="2"><select class="form-control" id="reset" name="type" onchange="typeChange()">
                            <option value="single">Change For Single User</option>
                            <option value="all">Change For All User</option>
                        </select></td>
                </tr>
            </table>
            <div id="for-single" style="display:block">
                <table class="table">
                <tr>
                    <td class="text-right"><h6>Username(short name) :</h6>&emsp;&emsp;</td>
                    <td><input type="text" id="user" name="username" class="form-control"></td>
                </tr>
                <tr>
                    <td class="text-right"><h6>New Password :</h6>&emsp;&emsp;</td>
                    <td><input type="password" id="passwd" name="password" class="form-control"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><a onclick="Validate()" class="btn btn-primary">&emsp;&emsp;Reset Password&emsp;&emsp;</a></td>
                </tr>
            </table>
            </div>
            <div id="for-all" style="display:none">
                <table class="table">
                <tr>
                    <td class="text-right"><h6>New Password for All User :</h6>&emsp;&emsp;</td>
                    <td><input type="password" id="new-pass" name="new-password" class="form-control"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><a onclick="Validate()" class="btn btn-primary">&emsp;&emsp;Reset Password&emsp;&emsp;</a></td>
                </tr>
            </table>
                </div>

        </form>
    </div>
</div>
<h:Footer />
</body>
</html>