<%-- 
    Document   : index
    Created on : Jan 25, 2017, 9:26:27 PM
    Author     : VATSAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<h:Header />
<style>
    @media (min-width: 768px) {
        .sidebar {
            width: 260px;
        }
    }
    .navbar-header {
        float: left;
        padding: 15px;
        text-align: center;
        width: 100%;
    }
    .navbar-brand {float:none;}
</style>
<script type="text/javascript" src="${applicationScope.Root}styles/js/coin-slider.min.js"></script>

    <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header text-center">
            <a class="navbar-brand" href="#"><span style="color:white">Faculty</span> Portal</a>
        </div>

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="sidebar-search">
                        <div class="hidden-xs text-center">
                            <img src="${applicationScope.Root}styles/img/ddu_logo.jpg" class="img" height="85" width="85" alt="DDU logo" />
                        </div>
                    </li>

                    <li>
                        <div class="login-panel panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Sign-In to Faculty Portal</h3>
                            </div>
                            <div class="panel-body">
                                <form role="form" action="doLogin" method="post">
                                    <fieldset>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="User-Name" name="username" type="text"  required autofocus/>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Password" name="password" type="password"  required/>
                                        </div>
                                        <input type="submit" class="btn btn-lg btn-success btn-block" value="Login" />
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div>
        <div>
            <div style="margin-left:300px;margin-top:120px;margin-right:0px;padding-right:0px;">
                <div id="main_carousel" class="carousel slide row" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#main_carousel" data-slide-to="0" class="active"></li>
                        <li data-target="#main_carousel" data-slide-to="1"></li>
                        <li data-target="#main_carousel" data-slide-to="2"></li>
                        <li data-target="#main_carousel" data-slide-to="3"></li>
                        <li data-target="#main_carousel" data-slide-to="4"></li>
                        <li data-target="#main_carousel" data-slide-to="5"></li>
                        <li data-target="#main_carousel" data-slide-to="6"></li>
                        <li data-target="#main_carousel" data-slide-to="7"></li>
                        <li data-target="#main_carousel" data-slide-to="8"></li>
                        <li data-target="#main_carousel" data-slide-to="9"></li>
                        <li data-target="#main_carousel" data-slide-to="10"></li>
                        <li data-target="#main_carousel" data-slide-to="11"></li>
                    </ol>
                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox"> 
                        <div class="item active">
                            <img src="${applicationScope.Root}styles/img/slide1.jpg" width="920" height="360" alt="" />
                            <div class="carousel-caption"></div>
                        </div>
                        <div class="item">
                            <img src="${applicationScope.Root}styles/img/slide2.jpg" width="920" height="360" alt="" />
                            <div class="carousel-caption"></div>
                        </div>
                        <div class="item">
                            <img src="${applicationScope.Root}styles/img/slide3.jpg" width="920" height="360" alt="" />
                            <div class="carousel-caption"></div>
                        </div>
                        <div class="item">
                            <img src="${applicationScope.Root}styles/img/slide4.jpg" width="920" height="360" alt="" />
                            <div class="carousel-caption"></div>
                        </div>
                        <div class="item">
                            <img src="${applicationScope.Root}styles/img/slide5.jpg" width="920" height="360" alt="" />
                            <div class="carousel-caption"></div>
                        </div>
                        <div class="item">
                            <img src="${applicationScope.Root}styles/img/slide6.jpg" width="920" height="360" alt="" />
                            <div class="carousel-caption"></div>
                        </div>
                        <div class="item">
                            <img src="${applicationScope.Root}styles/img/slide7.jpg" width="920" height="360" alt="" />
                            <div class="carousel-caption"></div>
                        </div>
                        <div class="item">
                            <img src="${applicationScope.Root}styles/img/slide8.jpg" width="920" height="360" alt="" />
                            <div class="carousel-caption"></div>
                        </div>
                        <div class="item">
                            <img src="${applicationScope.Root}styles/img/slide9.jpg" width="920" height="360" alt="" />
                            <div class="carousel-caption"></div>
                        </div>
                        <div class="item">
                            <img src="${applicationScope.Root}styles/img/slide10.jpg" width="920" height="360" alt="" />
                            <div class="carousel-caption"></div>
                        </div>
                        <div class="item">
                            <img src="${applicationScope.Root}styles/img/slide11.jpg" width="920" height="360" alt="" />
                            <div class="carousel-caption"></div>
                        </div>
                        <div class="item">
                            <img src="${applicationScope.Root}styles/img/slide12.jpg" width="920" height="360" alt="" />
                            <div class="carousel-caption"></div>
                        </div>
                    </div>
                </div>
            </div>
            <h:Footer />
            <script type="text/javascript">
                $(document).ready(function () {
                    $('.carousel').carousel({
                        interval: 2000
                    });

                    $('.carousel').carousel('cycle');
                });
            </script>
            </body>
            </html>