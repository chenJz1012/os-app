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
    </script>
</head>
<body>
<a href="<%=basePath%>/test/normalError">测试页面请求异常</a>
<br/>
<a href="javascript:testAjaxError();">测试ajax异常</a>
</body>
</html>
