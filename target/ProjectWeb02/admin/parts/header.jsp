<%@ page import="vn.nlu.fit.utils.Util" %><%--
  Created by IntelliJ IDEA.
  User: Minh Hung Tran
  Date: 19/12/2019
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>DHT Admin</title>

    <meta name="description" content="Static &amp; Dynamic Tables"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href=" <%=Util.fullPathAdmin("assets/css/bootstrap.min.css")%>"/>
    <link rel="stylesheet" href=" <%=Util.fullPathAdmin("assets/font-awesome/all.css")%>"/>
    <link rel="stylesheet" href=" <%=Util.fullPathAdmin("assets/font-awesome/4.5.0/css/font-awesome.min.css")%>"/>

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="<%=Util.fullPathAdmin("assets/css/fonts.googleapis.com.css")%>"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="<%=Util.fullPathAdmin("assets/css/ace.min.css")%>" class="ace-main-stylesheet" id="main-ace-style"/>

    <!--[if lte IE 9]-->
    <link rel="stylesheet" href='<%=Util.fullPathAdmin("assets/css/ace-part2.min.css")%>' class="ace-main-stylesheet"/>
    <!--[endif]-->
    <link rel="stylesheet" href="<%=Util.fullPathAdmin("assets/css/ace-skins.min.css")%>"/>
    <link rel="stylesheet" href="<%=Util.fullPathAdmin("assets/css/ace-rtl.min.css")%>"/>

    <!--[if lte IE 9]-->
    <link rel="stylesheet" href="<%=Util.fullPathAdmin("assets/css/ace-ie.min.css")%>"/>
    <link rel="stylesheet" href="<%=Util.fullPathAdmin("assets/css/style.css")%>">
    <!-- inline styles related to this page -->
    <link rel="stylesheet" href="<%=Util.fullPathAdmin("assets/css/product-list.css")%>">

    <!-- ace settings handler -->
    <script src="<%=Util.fullPathAdmin("assets/js/ace-extra.min.js")%>"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]-->
    <script src="<%=Util.fullPathAdmin("assets/js/html5shiv.min.js")%>"></script>
    <script src="<%=Util.fullPathAdmin("assets/js/respond.min.js")%>"></script>

</head>