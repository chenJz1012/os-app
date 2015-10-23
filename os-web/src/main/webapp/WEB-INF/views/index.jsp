<%--
  Created by IntelliJ IDEA.
  User: cgj
  Date: 2015/10/14
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + path;
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
    <meta charset="utf-8">
    <title>plugins</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <meta content="plugins" name="description">
    <meta content="ChenGJ" name="author">

    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"
          rel="stylesheet" type="text/css">
    <link href="<%=basePath%>/assets/global/plugins/font-awesome/css/font-awesome.min.css"
          rel="stylesheet" type="text/css">
    <link href="<%=basePath%>/assets/global/plugins/simple-line-icons/simple-line-icons.min.css"
          rel="stylesheet" type="text/css">
    <link href="<%=basePath%>/assets/global/plugins/bootstrap/css/bootstrap.min.css"
          rel="stylesheet" type="text/css">
    <link href="<%=basePath%>/assets/global/plugins/uniform/css/uniform.default.css"
          rel="stylesheet" type="text/css">
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN THEME STYLES -->
    <!-- DOC: To use 'rounded corners' style just load 'components-rounded.css' stylesheet instead of 'components.css' in the below style tag -->
    <link href="<%=basePath%>/assets/global/css/components-rounded.css" id="style_components"
          rel="stylesheet" type="text/css">
    <link href="<%=basePath%>/assets/global/css/plugins.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath%>/assets/admin/layout3/css/layout.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath%>/assets/admin/layout3/css/themes/default.css" rel="stylesheet"
          type="text/css" id="style_color">
    <link href="<%=basePath%>/assets/admin/layout3/css/custom.css" rel="stylesheet" type="text/css">


    <link rel="stylesheet" type="text/css"
          href="<%=basePath%>/assets/global/plugins/select2/select2.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%=basePath%>/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>

    <!-- END THEME STYLES -->
    <link rel="shortcut icon" href="favicon.ico">
    <script>
        var os_root = "<%=basePath%>";
    </script>
</head>
<body>
<!-- BEGIN HEADER TOP -->
<div class="page-header">
    <div class="page-header-top">
        <div class="container">
            <div class="page-logo">
                <a href="<%=basePath%>"><img
                        src="<%=basePath%>/assets/admin/layout3/img/logo-default.png"
                        alt="logo" class="logo-default"></a>
            </div>
            <a href="javascript:;" class="menu-toggler"></a>

            <div class="top-menu">
                <ul class="nav navbar-nav pull-right">
                    <!-- BEGIN NOTIFICATION DROPDOWN -->
                    <li class="dropdown dropdown-extended dropdown-dark dropdown-notification"
                        id="header_notification_bar">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"
                           data-hover="dropdown" data-close-others="true">
                            <i class="icon-bell"></i>
                            <span class="badge badge-default">7</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="external">
                                <h3>You have <strong>12 pending</strong> tasks</h3>
                                <a href="javascript:;">view all</a>
                            </li>
                            <li>
                                <ul class="dropdown-menu-list scroller" style="height: 250px;"
                                    data-handle-color="#637283">
                                    <li>
                                        <a href="javascript:;">
                                            <span class="time">just now</span>
										<span class="details">
										<span class="label label-sm label-icon label-success">
										<i class="fa fa-plus"></i>
										</span>
										New user registered. </span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown dropdown-extended dropdown-dark dropdown-tasks"
                        id="header_task_bar">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"
                           data-hover="dropdown" data-close-others="true">
                            <i class="icon-calendar"></i>
                            <span class="badge badge-default">3</span>
                        </a>
                        <ul class="dropdown-menu extended tasks">
                            <li class="external">
                                <h3>You have <strong>12 pending</strong> tasks</h3>
                                <a href="javascript:;">view all</a>
                            </li>
                            <li>
                                <ul class="dropdown-menu-list scroller" style="height: 275px;"
                                    data-handle-color="#637283">
                                    <li>
                                        <a href="javascript:;">
										<span class="task">
										<span class="desc">New release v1.2 </span>
										<span class="percent">30%</span>
										</span>
										<span class="progress">
										<span style="width: 40%;"
                                              class="progress-bar progress-bar-success"
                                              aria-valuenow="40" aria-valuemin="0"
                                              aria-valuemax="100"><span
                                                class="sr-only">40% Complete</span></span>
										</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="droddown dropdown-separator">
                        <span class="separator"></span>
                    </li>
                    <li class="dropdown dropdown-extended dropdown-dark dropdown-inbox"
                        id="header_inbox_bar">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"
                           data-hover="dropdown" data-close-others="true">
                            <span class="circle">3</span>
                            <span class="corner"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="external">
                                <h3>You have <strong>7 New</strong> Messages</h3>
                                <a href="javascript:;">view all</a>
                            </li>
                            <li>
                                <ul class="dropdown-menu-list scroller" style="height: 275px;"
                                    data-handle-color="#637283">
                                    <li>
                                        <a href="inbox.html?a=view">
										<span class="photo">
										<img src="<%=basePath%>/assets/admin/layout3/img/avatar.png"
                                             class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Lisa Wong </span>
										<span class="time">Just Now </span>
										</span>
										<span class="message">
										Vivamus sed auctor nibh congue nibh. auctor nibh auctor nibh... </span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown dropdown-user dropdown-dark">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"
                           data-hover="dropdown" data-close-others="true">
                            <img alt="" class="img-circle"
                                 src="<%=basePath%>/assets/admin/layout3/img/avatar.png">
                            <span class="username username-hide-mobile">Nick</span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-default">
                            <li>
                                <a href="extra_profile.html">
                                    <i class="icon-user"></i> My Profile </a>
                            </li>
                            <li>
                                <a href="inbox.html">
                                    <i class="icon-envelope-open"></i> My Inbox <span
                                        class="badge badge-danger">
								3 </span>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:;">
                                    <i class="icon-rocket"></i> My Tasks <span
                                        class="badge badge-success">
								7 </span>
                                </a>
                            </li>
                            <li class="divider">
                            </li>
                            <li>
                                <a href="login.html">
                                    <i class="icon-key"></i> Log Out </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="page-header-menu">
        <div class="container">
            <div class="hor-menu ">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="<%=basePath%>">主页</a>
                    </li>
                    <li class="menu-dropdown classic-menu-dropdown ">
                        <a data-hover="megamenu-dropdown" data-close-others="true"
                           data-toggle="dropdown" href="javascript:;">
                            多级菜单 <i class="fa fa-angle-down"></i>
                        </a>
                        <ul class="dropdown-menu pull-left">
                            <li class=" dropdown-submenu">
                                <a href=":;">
                                    <i class="icon-puzzle"></i>
                                    Multi Level </a>
                                <ul class="dropdown-menu">
                                    <li class=" ">
                                        <a href="javascript:;">
                                            <i class="icon-settings"></i>
                                            Item 1 </a>
                                    </li>
                                    <li class=" ">
                                        <a href="javascript:;">
                                            <i class="icon-user"></i>
                                            Item 2 </a>
                                    </li>
                                    <li class=" ">
                                        <a href="javascript:;">
                                            <i class="icon-globe"></i>
                                            Item 3 </a>
                                    </li>
                                    <li class=" dropdown-submenu">
                                        <a href="#">
                                            <i class="icon-folder"></i>
                                            Sub Items </a>
                                        <ul class="dropdown-menu">
                                            <li class=" ">
                                                <a href="javascript:;">
                                                    Item 1 </a>
                                            </li>
                                            <li class=" ">
                                                <a href="javascript:;">
                                                    Item 2 </a>
                                            </li>
                                            <li class=" ">
                                                <a href="javascript:;">
                                                    Item 3 </a>
                                            </li>
                                            <li class=" ">
                                                <a href="javascript:;">
                                                    Item 4 </a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class=" ">
                                        <a href="javascript:;">
                                            <i class="icon-share"></i>
                                            Item 4 </a>
                                    </li>
                                    <li class=" ">
                                        <a href="javascript:;">
                                            <i class="icon-bar-chart"></i>
                                            Item 5 </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- END HEADER TOP -->

<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
    <!-- BEGIN PAGE HEAD -->
    <div class="page-head">
        <div class="container">
            <!-- BEGIN PAGE TITLE -->
            <div class="page-title">
                <h1>PLUGINS
                    <small>插件</small>
                </h1>
            </div>
            <!-- BEGIN PAGE TOOLBAR -->
            <div class="page-toolbar">
                <!-- BEGIN THEME PANEL -->
                <div class="btn-group btn-theme-panel">
                    <a href="javascript:;" class="btn dropdown-toggle" data-toggle="dropdown">
                        <i class="icon-settings"></i>
                    </a>

                    <div class="dropdown-menu theme-panel pull-right dropdown-custom hold-on-click">
                        <div class="row">
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <h3>主题颜色</h3>

                                <div class="row">
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <ul class="theme-colors">
                                            <li class="theme-color theme-color-default"
                                                data-theme="default">
                                                <span class="theme-color-view"></span>
                                                <span class="theme-color-name">Default</span>
                                            </li>
                                            <li class="theme-color theme-color-blue-hoki"
                                                data-theme="blue-hoki">
                                                <span class="theme-color-view"></span>
                                                <span class="theme-color-name">Blue Hoki</span>
                                            </li>
                                            <li class="theme-color theme-color-blue-steel"
                                                data-theme="blue-steel">
                                                <span class="theme-color-view"></span>
                                                <span class="theme-color-name">Blue Steel</span>
                                            </li>
                                            <li class="theme-color theme-color-yellow-orange"
                                                data-theme="yellow-orange">
                                                <span class="theme-color-view"></span>
                                                <span class="theme-color-name">Orange</span>
                                            </li>
                                            <li class="theme-color theme-color-yellow-crusta"
                                                data-theme="yellow-crusta">
                                                <span class="theme-color-view"></span>
                                                <span class="theme-color-name">Yellow Crusta</span>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <ul class="theme-colors">
                                            <li class="theme-color theme-color-green-haze"
                                                data-theme="green-haze">
                                                <span class="theme-color-view"></span>
                                                <span class="theme-color-name">Green Haze</span>
                                            </li>
                                            <li class="theme-color theme-color-red-sunglo"
                                                data-theme="red-sunglo">
                                                <span class="theme-color-view"></span>
                                                <span class="theme-color-name">Red Sunglo</span>
                                            </li>
                                            <li class="theme-color theme-color-red-intense"
                                                data-theme="red-intense">
                                                <span class="theme-color-view"></span>
                                                <span class="theme-color-name">Red Intense</span>
                                            </li>
                                            <li class="theme-color theme-color-purple-plum"
                                                data-theme="purple-plum">
                                                <span class="theme-color-view"></span>
                                                <span class="theme-color-name">Purple Plum</span>
                                            </li>
                                            <li class="theme-color theme-color-purple-studio"
                                                data-theme="purple-studio">
                                                <span class="theme-color-view"></span>
                                                <span class="theme-color-name">Purple Studio</span>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-6 col-xs-12 seperator">
                                <h3>布局设置</h3>
                                <ul class="theme-settings">
                                    <li>
                                        主题 风格
                                        <select class="theme-setting theme-setting-style form-control input-sm input-small input-inline"
                                                data-container="body" data-placement="left">
                                            <option value="boxed" selected="selected">方角
                                            </option>
                                            <option value="rounded">圆角</option>
                                        </select>
                                    </li>
                                    <li>
                                        页面布局
                                        <select class="theme-setting theme-setting-layout form-control input-sm input-small input-inline"
                                                data-container="body" data-placement="left">
                                            <option value="boxed" selected="selected">盒子布局</option>
                                            <option value="fluid">宽屏布局</option>
                                        </select>
                                    </li>
                                    <li>
                                        顶部风格
                                        <select class="theme-setting theme-setting-top-menu-style form-control input-sm input-small input-inline"
                                                data-container="body" data-placement="left">
                                            <option value="dark" selected="selected">暗黑</option>
                                            <option value="light">明亮</option>
                                        </select>
                                    </li>
                                    <li>
                                        顶部模式
                                        <select class="theme-setting theme-setting-top-menu-mode form-control input-sm input-small input-inline tooltips"
                                                data-original-title="Enable fixed(sticky) top menu"
                                                data-container="body" data-placement="left">
                                            <option value="fixed">固定</option>
                                            <option value="not-fixed" selected="selected">不固定
                                            </option>
                                        </select>
                                    </li>
                                    <li>
                                        导航菜单风格
                                        <select class="theme-setting theme-setting-mega-menu-style form-control input-sm input-small input-inline tooltips"
                                                data-original-title="Change mega menu dropdowns style"
                                                data-container="body" data-placement="left">
                                            <option value="dark" selected="selected">暗黑</option>
                                            <option value="light">明亮</option>
                                        </select>
                                    </li>
                                    <li>
                                        导航菜单模式
                                        <select class="theme-setting theme-setting-mega-menu-mode form-control input-sm input-small input-inline tooltips"
                                                data-original-title="Enable fixed(sticky) mega menu"
                                                data-container="body" data-placement="left">
                                            <option value="fixed" selected="selected">固定</option>
                                            <option value="not-fixed">不固定</option>
                                        </select>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- END THEME PANEL -->
            </div>
            <!-- END PAGE TOOLBAR -->
        </div>
    </div>
    <!-- END PAGE HEAD -->
    <!-- BEGIN PAGE CONTENT -->
    <div class="page-content">
        <div class="container">
            <!-- BEGIN PAGE BREADCRUMB -->
            <ul class="page-breadcrumb breadcrumb">
                <li>
                    <a href="#">Home</a><i class="fa fa-angle-right"></i>
                </li>
                <li class="active">
                    Dashboard
                </li>
            </ul>
            <!-- END PAGE BREADCRUMB -->

            <div class="row">
                <div class="col-md-6 col-sm-12">
                    <!-- BEGIN PORTLET-->
                    <div class="portlet light ">
                        <div class="portlet-title">
                            <div class="caption caption-md">
                                <i class="icon-bar-chart theme-font hide"></i>
                                <span class="caption-subject theme-font bold uppercase">Sales Summary</span>
                                <span class="caption-helper hide">weekly stats...</span>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="row list-separated">
                                <div class="col-md-3 col-sm-3 col-xs-6">
                                    <div class="font-grey-mint font-sm">
                                        Total Sales
                                    </div>
                                    <div class="uppercase font-hg font-red-flamingo">
                                        13,760 <span class="font-lg font-grey-mint">$</span>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-6">
                                    <div class="font-grey-mint font-sm">
                                        Revenue
                                    </div>
                                    <div class="uppercase font-hg theme-font">
                                        4,760 <span class="font-lg font-grey-mint">$</span>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-6">
                                    <div class="font-grey-mint font-sm">
                                        Expenses
                                    </div>
                                    <div class="uppercase font-hg font-purple">
                                        11,760 <span class="font-lg font-grey-mint">$</span>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-3 col-xs-6">
                                    <div class="font-grey-mint font-sm">
                                        Growth
                                    </div>
                                    <div class="uppercase font-hg font-blue-sharp">
                                        9,760 <span class="font-lg font-grey-mint">$</span>
                                    </div>
                                </div>
                            </div>
                            <ul class="list-separated list-inline-xs hide">
                                <li>
                                    <div class="font-grey-mint font-sm">
                                        Total Sales
                                    </div>
                                    <div class="uppercase font-hg font-red-flamingo">
                                        13,760 <span class="font-lg font-grey-mint">$</span>
                                    </div>
                                </li>
                                <li>
                                </li>
                                <li class="border">
                                    <div class="font-grey-mint font-sm">
                                        Revenue
                                    </div>
                                    <div class="uppercase font-hg theme-font">
                                        4,760 <span class="font-lg font-grey-mint">$</span>
                                    </div>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <div class="font-grey-mint font-sm">
                                        Expenses
                                    </div>
                                    <div class="uppercase font-hg font-purple">
                                        11,760 <span class="font-lg font-grey-mint">$</span>
                                    </div>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <div class="font-grey-mint font-sm">
                                        Growth
                                    </div>
                                    <div class="uppercase font-hg font-blue-sharp">
                                        9,760 <span class="font-lg font-grey-mint">$</span>
                                    </div>
                                </li>
                            </ul>
                            <div id="sales_statistics" class="portlet-body-morris-fit morris-chart"
                                 style="height: 260px">
                            </div>
                        </div>
                    </div>
                    <!-- END PORTLET-->
                </div>
                <div class="col-md-6 col-sm-12">
                    <!-- BEGIN EXAMPLE TABLE PORTLET-->
                    <div class="portlet light">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-cogs font-green-sharp"></i>
                                <span class="caption-subject font-green-sharp bold uppercase">Table</span>
                            </div>
                            <div class="actions btn-set">
                                <button class="btn green-haze btn-circle"><i
                                        class="fa fa-check"></i> Add
                                </button>
                                <div class="btn-group">
                                    <a class="btn yellow btn-circle" href="javascript:;"
                                       data-toggle="dropdown">
                                        <i class="fa fa-check-circle"></i> Edit <i
                                            class="fa fa-angle-down"></i>
                                    </a>
                                    <ul class="dropdown-menu pull-right">
                                        <li>
                                            <a href="javascript:;">
                                                Duplicate </a>
                                        </li>
                                        <li>
                                            <a href="javascript:;">
                                                Delete </a>
                                        </li>
                                        <li class="divider">
                                        </li>
                                        <li>
                                            <a href="javascript:;">
                                                Print </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <table class="table table-striped table-bordered table-hover"
                                   id="sample_2">
                                <thead>
                                <tr>
                                    <th class="table-checkbox">
                                        <input type="checkbox" class="group-checkable"
                                               data-set="#sample_2 .checkboxes"/>
                                    </th>
                                    <th>
                                        Username
                                    </th>
                                    <th>
                                        Email
                                    </th>
                                    <th>
                                        Status
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="odd gradeX">
                                    <td>
                                        <input type="checkbox" class="checkboxes" value="1"/>
                                    </td>
                                    <td>
                                        shuxer
                                    </td>
                                    <td>
                                        <a href="mailto:shuxer@gmail.com">
                                            shuxer@gmail.com </a>
                                    </td>
                                    <td>
									<span class="label label-sm label-success">
									Approved </span>
                                    </td>
                                </tr>
                                <tr class="odd gradeX">
                                    <td>
                                        <input type="checkbox" class="checkboxes" value="1"/>
                                    </td>
                                    <td>
                                        looper
                                    </td>
                                    <td>
                                        <a href="mailto:looper90@gmail.com">
                                            looper90@gmail.com </a>
                                    </td>
                                    <td>
									<span class="label label-sm label-warning">
									Suspended </span>
                                    </td>
                                </tr>
                                <tr class="odd gradeX">
                                    <td>
                                        <input type="checkbox" class="checkboxes" value="1"/>
                                    </td>
                                    <td>
                                        userwow
                                    </td>
                                    <td>
                                        <a href="mailto:userwow@yahoo.com">
                                            userwow@yahoo.com </a>
                                    </td>
                                    <td>
									<span class="label label-sm label-success">
									Approved </span>
                                    </td>
                                </tr>
                                <tr class="odd gradeX">
                                    <td>
                                        <input type="checkbox" class="checkboxes" value="1"/>
                                    </td>
                                    <td>
                                        user1wow
                                    </td>
                                    <td>
                                        <a href="mailto:userwow@gmail.com">
                                            userwow@gmail.com </a>
                                    </td>
                                    <td>
									<span class="label label-sm label-default">
									Blocked </span>
                                    </td>
                                </tr>
                                <tr class="odd gradeX">
                                    <td>
                                        <input type="checkbox" class="checkboxes" value="1"/>
                                    </td>
                                    <td>
                                        restest
                                    </td>
                                    <td>
                                        <a href="mailto:userwow@gmail.com">
                                            test@gmail.com </a>
                                    </td>
                                    <td>
									<span class="label label-sm label-success">
									Approved </span>
                                    </td>
                                </tr>
                                <tr class="odd gradeX">
                                    <td>
                                        <input type="checkbox" class="checkboxes" value="1"/>
                                    </td>
                                    <td>
                                        foopl
                                    </td>
                                    <td>
                                        <a href="mailto:userwow@gmail.com">
                                            good@gmail.com </a>
                                    </td>
                                    <td>
									<span class="label label-sm label-success">
									Approved </span>
                                    </td>
                                </tr>
                                <tr class="odd gradeX">
                                    <td>
                                        <input type="checkbox" class="checkboxes" value="1"/>
                                    </td>
                                    <td>
                                        weep
                                    </td>
                                    <td>
                                        <a href="mailto:userwow@gmail.com">
                                            good@gmail.com </a>
                                    </td>
                                    <td>
									<span class="label label-sm label-success">
									Approved </span>
                                    </td>
                                </tr>
                                <tr class="odd gradeX">
                                    <td>
                                        <input type="checkbox" class="checkboxes" value="1"/>
                                    </td>
                                    <td>
                                        coop
                                    </td>
                                    <td>
                                        <a href="mailto:userwow@gmail.com">
                                            good@gmail.com </a>
                                    </td>
                                    <td>
									<span class="label label-sm label-success">
									Approved </span>
                                    </td>
                                </tr>
                                <tr class="odd gradeX">
                                    <td>
                                        <input type="checkbox" class="checkboxes" value="1"/>
                                    </td>
                                    <td>
                                        pppol
                                    </td>
                                    <td>
                                        <a href="mailto:userwow@gmail.com">
                                            good@gmail.com </a>
                                    </td>
                                    <td>
									<span class="label label-sm label-success">
									Approved </span>
                                    </td>
                                </tr>
                                <tr class="odd gradeX">
                                    <td>
                                        <input type="checkbox" class="checkboxes" value="1"/>
                                    </td>
                                    <td>
                                        test
                                    </td>
                                    <td>
                                        <a href="mailto:userwow@gmail.com">
                                            good@gmail.com </a>
                                    </td>
                                    <td>
									<span class="label label-sm label-success">
									Approved </span>
                                    </td>
                                </tr>
                                <tr class="odd gradeX">
                                    <td>
                                        <input type="checkbox" class="checkboxes" value="1"/>
                                    </td>
                                    <td>
                                        userwow
                                    </td>
                                    <td>
                                        <a href="mailto:userwow@gmail.com">
                                            userwow@gmail.com </a>
                                    </td>
                                    <td>
									<span class="label label-sm label-default">
									Blocked </span>
                                    </td>
                                </tr>
                                <tr class="odd gradeX">
                                    <td>
                                        <input type="checkbox" class="checkboxes" value="1"/>
                                    </td>
                                    <td>
                                        test
                                    </td>
                                    <td>
                                        <a href="mailto:userwow@gmail.com">
                                            test@gmail.com </a>
                                    </td>
                                    <td>
									<span class="label label-sm label-success">
									Approved </span>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- END EXAMPLE TABLE PORTLET-->
                </div>
            </div>
        </div>

    </div>
    <!-- END PAGE CONTENT -->
</div>
<!-- END PAGE CONTAINER -->

<!-- BEGIN PRE-FOOTER -->
<div class="page-prefooter">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12 footer-block">
                <h2>关于</h2>

                <p>
                    Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam dolore.
                </p>
            </div>
            <div class="col-md-6 col-sm-6 col-xs-12 footer-block">
                <h2>联系我们</h2>
                <address class="margin-bottom-40">
                    Phone: 18600200791<br>
                    Email: <a href="mailto:597160667@qq.com">597160667@qq.com</a>
                </address>
            </div>
        </div>
    </div>
</div>
<!-- END PRE-FOOTER -->
<!-- BEGIN FOOTER -->
<div class="page-footer">
    <div class="container">
        2015 &copy; OrangeSide by ChenGj. <a
            href="#"
            title="Purchase Metronic just for 27$ and get lifetime updates for free"
            target="_blank">OrangeSide!</a>
    </div>
</div>
<div class="scroll-to-top">
    <i class="icon-arrow-up"></i>
</div>
<!--[if lt IE 9]>
<script src="<%=basePath%>/assets/global/plugins/respond.min.js"></script>
<script src="<%=basePath%>/assets/global/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="<%=basePath%>/assets/global/plugins/jquery-1.10.2.min.js"
        type="text/javascript"></script>
<script src="<%=basePath%>/assets/global/plugins/jquery-migrate.min.js"
        type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="<%=basePath%>/assets/global/plugins/jquery-ui/jquery-ui.min.js"
        type="text/javascript"></script>
<script src="<%=basePath%>/assets/global/plugins/bootstrap/js/bootstrap.min.js"
        type="text/javascript"></script>
<script src="<%=basePath%>/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
        type="text/javascript"></script>
<script src="<%=basePath%>/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
        type="text/javascript"></script>
<script src="<%=basePath%>/assets/global/plugins/jquery.blockui.min.js"
        type="text/javascript"></script>
<script src="<%=basePath%>/assets/global/plugins/jquery.cookie.min.js"
        type="text/javascript"></script>
<script src="<%=basePath%>/assets/global/plugins/uniform/jquery.uniform.min.js"
        type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<%=basePath%>/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="<%=basePath%>/assets/admin/layout3/scripts/layout.js" type="text/javascript"></script>
<script src="<%=basePath%>/assets/admin/layout3/scripts/theme.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script type="text/javascript"
        src="<%=basePath%>/assets/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript"
        src="<%=basePath%>/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
        src="<%=basePath%>/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<script src="<%=basePath%>/assets/admin/pages/scripts/table-managed.js"></script>


<script src="<%=basePath%>/assets/os-plugins/sea.js" type="text/javascript"></script>
<script src="<%=basePath%>/assets/os-plugins/os-plugins-path.js"
        type="text/javascript"></script>

<script>
    pathjs.config({
        base: os_root
    });
    seajs.config({
        base: os_root
    });
    seajs.use([pathjs.path("element")], function (element) {
        var row = element.build().row({
            render: "div.page-content > div.container",
            id: "row_id"
        });
        var col1 = element.build().col({
            id: "col_id",
            span: "6",
            render: row
        });
        var col2 = element.build().col({
            id: "col2_id",
            span: "6",
            render: row
        });
        var alertDiv = element.build().alert({
            id: "alert_id",
            type: "success",
            message: "成功",
            close: false
        });
        var h4 = $('<h4 class="block">Default Alerts</h4>');
        var button = element.build().button({
            cls: "green-haze btn-circle",
            icon: "fa fa-check",
            text: "我是button",
            click: function () {
                alert(0);
            }
        });
        var portlet = element.build().portlet({
            id: "portlet_id",
            title: "我的标题",
            titleIcon: "fa fa-cogs font-green-sharp",
            render: col1,
            titleAction: [button],
            scrollable: true,
            fullscreen: true,
            item: [alertDiv, h4, "aaaaaaaaaaaaa<br/><br/><br/><br/><br/><br/><br/>aaaaa"]
        });
        var portlet2 = element.build().portlet({
            id: "portlet2_id",
            title: "我的标题2",
            render: col2
        }).alert("warning", "警告", 2000);
    });
</script>
<script>
    jQuery(document).ready(function () {
        Metronic.init(); // init metronic core componets
        Layout.init(); // init layout
        Theme.init(); //init themes setting
        TableManaged.init();
    });
</script>
</body>
</html>
