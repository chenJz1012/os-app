<%--
  Created by IntelliJ IDEA.
  User: cgj
  Date: 2015/9/7
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<html>
<head>
    <title>test</title>
    <script src="<%=basePath%>/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
    <script>
        function testAjaxError() {
            $.ajax({
                type: "GET",
                url: "<%=basePath%>/test/ajaxError",
                data: {},
                dataType: "json",
                success: function (data) {
                    if(data.success==false){
                        alert(data.err);
                    }
                },
                error: function (data) {

                }
            });
        }
        function ajaxLogin() {
            $.ajax({
                type: "Post",
                url: "<%=basePath%>/j_spring_security_check",
                data: {
                    "j_username":$("#j_username").val(),
                    "j_password":$("#j_password").val(),
                    "_spring_security_remember_me":$("#_spring_security_remember_me").is(':checked')
                },
                dataType: "json",
                success: function (data) {
                    if(data.success){
                        alert(data.message);
                        window.location.href = data.targetUrl;
                    }else{
                        alert(data.message);
                        window.location.href = data.targetUrl;
                    }
                },
                error: function (data) {

                }
            });
        }
        function ajaxLogout() {
            $.ajax({
                type: "GET",
                url: "<%=basePath%>/logout",
                dataType: "json",
                success: function (data) {
                    if(data.success){
                        alert(data.message);
                        window.location.href = data.targetUrl;
                    }
                },
                error: function (data) {

                }
            });
        }
    </script>
</head>
<body>
<a href="<%=basePath%>/test/normalError">测试页面请求异常</a>
<br/>
<a href="javascript:testAjaxError();">测试ajax异常</a>
<br>
<a href="<%=basePath%>/test/normalBusinessError">测试业务异常</a>
<br>
<br>
<input id="j_username" placeholder="用户名" type="input" /><br/>
<input id="j_password" placeholder="密码" type="password" /><br/>
<label><input type="checkbox" id="_spring_security_remember_me" value="true"/>Remember </label><br/>
<a href="javascript:ajaxLogin();">测试ajax登录</a><br/>
<a href="<%=basePath%>/logout">退出登录</a><br/>
<a href="javascript:ajaxLogout();">ajax退出登录</a>
</body>
</html>
