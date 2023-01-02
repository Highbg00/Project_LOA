<%--
  Created by IntelliJ IDEA.
  User: qnrhk
  Date: 2022-12-13
  Time: 오후 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="search" method="post">
    <div class="main_logo">
        <img src="@{/img/logo.png}"/>

        <p style="margin-top: 50px;">
            <input type="text" placeholder="캐릭터명을 입력하십시오." name="userid"/>
            <a class='btn-fill' onclick="$('form').submit()">검색</a>
        </p>
    </div>
</form>
</body>
</html>
