<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 7/16/2019
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="resources/css/login.css" rel="stylesheet">
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>--%>
    <script src="resources/js/signUp1.js" type="text/javascript"></script>


    <title>Sign up </title>
</head>
<body>
<div id="container">

    <div class="top">
        <h1>My Luxury Hotel</h1>
        <nav>
            <ul>
                <li><a href="index.jsp" >Home</a></li>
                <li><a href="searchInput.jsp">Search rooms</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="#" class="active">SignUp</a></li>
                <li><a href="review.jsp">Reviews</a></li>
                <%--                <li><a href="login.jsp">Login</a></li>--%>
                <%--                <li><a href="#">SignUp</a></li>--%>
                <li><a href="#">Contact</a></li>
            </ul>
        </nav>
    </div>

    <div id="content">
        <h1>Sign up</h1>
        <form method="post" action='signUp'>

            User Name:
            <input name='userName' type="text" id="uname"/> <span id="space"></span> </br>
            Password:
            <input name='password' type='password' required/></br></br>

            <input type='submit' value='signUp' id="button1"/>
        </form>

    </div>

    <footer>Copyright 2019</footer>
</div>


</body>
</html>

