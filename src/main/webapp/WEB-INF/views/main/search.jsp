<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <style type="text/css">
    .tierimg{
      width: 200px;
      height: 200px;
    }
    .sumicon{
      width: 170px;
      height: 170px;
    }
    .tier{
      width: 1500px;
      border: 1px solid black;
      margin: 0px auto;
    }
    .crawl{
      align-self: center;
      width: 700px;
      border: 1px solid black;
    }
    .record{
      align: center;
      display: inline-block;
      width: 700px;
      border: 1px solid black;
    }
    .champicon{
      width: 50px;
      height: 50px
    }
    .spellicon{
      width: 25px;
      height: 25px;
    }
    .itemicon{
      width: 32px;
      height: 32px;
    }
  </style>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
<form action="search" method="post">
  <p>
    <input type="text" placeholder="캐릭터명을 입력하십시오." name="userid"/>
    <a class='btn-fill' onclick="$('form').submit()">검색</a>
  </p>
</form>
<div style="width: 1500px; border: 1px solid black; align: center;" class="tier">
  <div>
    <img class="chacicon" src=${vo.characterImage}>
    <p>${vo.title}  ${vo.characterName }</p>
    <p>원정대 레벨 : ${vo.expeditionLevel }</p>
  </div>
</div>
</body>
</html>