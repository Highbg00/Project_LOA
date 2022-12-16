<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Home</title>
  <link href="@{/css/common.css}" rel="stylesheet" />
  <style type="text/css">
    .main_logo {
      margin-top: 150px;
    }
  </style>
</head>
<body>
<tiles:insertAttribute name="header"/>
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