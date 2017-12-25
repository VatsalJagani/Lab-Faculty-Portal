<%-- 
    Document   : Header
    Created on : Jan 25, 2017, 9:36:03 PM
    Author     : VATSAL
--%>

<%@tag description="This is header tag" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" type="image/x-icon" href="${initParam['Root']}styles/img/favicon.ico"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="This is faculty portal for DDU">
    <meta name="author" content="DDU students">

    <title>Faculty Portal</title>

    <link href="${initParam['Root']}styles/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="${initParam['Root']}styles/js/jquery.js"></script>
    <script src="${initParam['Root']}styles/bootstrap/js/bootstrap.min.js"></script>
    <link href="${initParam['Root']}styles/css/sb-admin-2.css" rel="stylesheet">
    <link href="${initParam['Root']}styles/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="${initParam['Root']}styles/metisMenu/metisMenu.min.js"></script>
    <script src="${initParam['Root']}styles/js/sb-admin-2.js"></script>
    <style>
        
        .navbar-default{
            background-color: #404040;
        }
        #wrapper{
            background-color: #404040;
        }
        #wrapper .foot{
            color:white !important;
        }
        #wrapper .foot > a{
            color:yellow !important;
        }
        .nav > li > a:hover{
            background-color: #808080;
        }
        .nav > li > a:active{
            background-color: black;
        }
        .nav > li > a{
            font-size: medium;
            color: #1ac6ff;
        }
        .navbar-default .navbar-brand{
            color:orangered; 
            font-size: xx-large;
            font-family: algerian,casteller,elephant;
        }
        .navbar-default .navbar-brand:hover{
            color:red; 
        }
        #span-logo{
            color:#f2f2f2;
        }
        #span-logo:hover{
            color:white;
        }
        label {
    font-weight: normal !important;
}
    </style>