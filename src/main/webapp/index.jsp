<%@ page import="com.example.javaweb_assignment.pojo.Admin" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangtianxiang
  Date: 2022/6/1
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>商家管理</title>
  </head>
  <body>
  <button onclick="f()">按钮</button>
  <script>
    function f()
    {
      <%! Admin curAdmin; %>
      <% curAdmin = (Admin)request.getSession().getAttribute("admin"); %>
      const msg = "<%=request.getAttribute("kind")%>";
      const admin = "<%= curAdmin.getName()%>";
              alert(msg + "成功，欢迎" + admin);
    }
  </script>
  </body>
</html>
