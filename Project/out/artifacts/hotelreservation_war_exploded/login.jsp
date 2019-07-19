<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 7/14/2019
  Time: 2:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginServlet</title>
    <link href="resources/css/login.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="resources/js/login.js"></script>
</head>
<body>

<div id="container">

    <div class="top">
        <h1>My Luxury Hotel</h1>
        <nav>
            <ul>
                <li><a href="index.jsp" class="active">Home</a></li>
                <li><a href="searchInput.jsp">Search rooms</a></li>
                <li><a href="review.jsp">Reviews</a></li>
                <%--                <li><a href="login.jsp">Login</a></li>--%>
                <%--                <li><a href="#">SignUp</a></li>--%>
                <li><a href="#">Contact</a></li>
            </ul>
        </nav>
    </div>

    <div id="content">
        <h1>Login Credentials</h1>
        <form id="input" method="post" action="login">
            <%
                String value = "", checkbox = "";
                Cookie[] cookies = request.getCookies();
                if(cookies != null){
                    for(Cookie c : cookies){
                        if(c.getName().equals("userCookie")){
                            value = c.getValue();
                            checkbox = "checked";
                            break;
                        }
                    }
                }
                //  value = request.getCookies()[0].getValue();
            %>
            User Name:
            <input id="userName" name="userName" required value='<%=value%>'/></br></br>
            Password:
            <input id="password" name="password" type='password' required/></br></br>
            <div id="warn">

            </div>
            <button id="btn" type="button">Login</button>
            <input id="submitBtn" type="submit" hidden>
            <label><input id="cb" type='checkbox' name='remember' value="on" <%=checkbox%>/> Remember Me</label>
        </form>
    </div>

    <footer>Copyright 2019</footer>
</div>

</body>
</html>

