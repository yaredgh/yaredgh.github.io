<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 7/14/2019
  Time: 2:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href= "login.css">
    <title>LoginServlet</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    String userName = "", password = "", rememberVal = "";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cookuser")) {
                userName = cookie.getValue();
            }
            if (cookie.getName().equals("cookpass")) {
                password = cookie.getValue();
            }
            if (cookie.getName().equals("cookrem")) {
                rememberVal = cookie.getValue();
            }
        }
    }
%>
 <form action="login" method="post"/>
     UserName: <input type="text" name="userName"/>
     Password: <input type="password" name="password"/>
     <input type="checkbox" name="remember" value="1"
     <%= "1".equals(rememberVal.trim()) ?"checked =checked":"" %>/>
     <label>Remember me</label><br>
     <input type="submit" value="login"/>
 </form>



</body>
</html>
