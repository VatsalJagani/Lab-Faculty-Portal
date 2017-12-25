<%-- 
    Document   : Navigation
    Created on : Jan 25, 2017, 9:36:30 PM
    Author     : VATSAL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Here is both navigation" pageEncoding="UTF-8"%>
<%@attribute name="topic" required="true" %>
</head>
<body>
<div id="wrapper">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><span id="span-logo">Faculty</span> Portal</a>
            </div>
            
            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        ${sessionScope.user.userName}&emsp;<i class="fa fa-user fa-fw	"></i><i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="${initParam['Root']}change_password.jsp"><i class="fa fa-gear fa-fw"></i> Change Password</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="${initParam['Root']}doLogout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                </li>
            </ul>
  
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="hidden-xs text-center">
                                <img src="${initParam["Root"]}styles/img/ddu_logo.jpg" class="img" height="85" width="85" alt="DDU logo" />
                            </div>
                        </li>
                        
                        <li class="divider"></li><li class="divider"></li><li class="divider"></li><li class="divider"></li><li class="divider"></li>
                        <!-- subject preferences -->
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Subject Preferences<i class="fa arrow"></i></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${initParam['Root']}sp/GetSubjectPreferences">Edit Your Subject Preferences</a>
                                </li>
                                <li>
                                    <a href="${initParam['Root']}sp/offered_subjects.jsp">View Offered Subjects</a>
                                </li>
                                <c:if test="${sessionScope.user.userType.equalsIgnoreCase('admin_sp')}">
                                <li>
                                    <a href="${initParam['Root']}sp/admin/edit_offered_subjects.jsp">Edit Offered Subject</a>
                                </li>
                                <li>
                                    <a href="${initParam['Root']}sp/admin/enable_preferences.jsp">Enable/Disable Preferences</a>
                                </li>
                                <li>
                                    <a href="${initParam['Root']}sp/admin/print_sp.jsp">Print Subject Preferences List</a>
                                </li>
                                <li>
                                    <a href="${initParam['Root']}sp/admin/backup_confirmation.jsp">Take Backup</a>
                                </li>
                                </c:if>
                            </ul>
                        </li>
			
                        
                        <li class="divider"></li><li class="divider"></li><li class="divider"></li><li class="divider"></li><li class="divider"></li>
                        <!-- leave management -->
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Leave Management<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${initParam['Root']}lm/GetLeaveDetails">Apply For Leave</a>
                                </li>
                                <li>
                                    <a href="${initParam['Root']}lm/my_leave.jsp">Show My Leave</a>
                                </li>
                                <li>
                                    <a href="${initParam['Root']}lm/RequestsOfLoadArrangement">Load-arrangement Requests</a>
                                </li>
                                
                                <c:if test="${sessionScope.user.userType.equalsIgnoreCase('admin')}">
                                <li>
                                    <a href="${initParam['Root']}lm/admin/LeaveRequests">Pending Leave Requests</a>
                                </li>
                                <li>
                                    <a href="${initParam['Root']}lm/admin/leave_history.jsp">Leave History</a>
                                </li>
                                <li>
                                    <a href="${initParam['Root']}lm/admin/backup_confirmation.jsp">Backup & Reset</a>
                                </li>
                                </c:if>
                            </ul>
                        </li>
                        <li class="divider"></li><li class="divider"></li><li class="divider"></li><li class="divider"></li><li class="divider"></li>
                        <c:if test="${sessionScope.user.userType.equalsIgnoreCase('admin')}">
                            <li>
                                <a href="#"><i class="fa fa-wrench fa-fw"></i> User Management<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="${initParam['Root']}user/add_user.jsp">Add User</a>
                                    </li>
                                    <li>
                                        <a href="${initParam['Root']}user/reset_password.jsp">Reset Password</a>
                                    </li>
                                    
                                </ul>
                            </li>
                            <li class="divider"></li><li class="divider"></li><li class="divider"></li><li class="divider"></li><li class="divider"></li>

                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>

        <div id="page-wrapper" style="margin-top:25px">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${topic}</h1>
                </div>
            </div>