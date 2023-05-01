<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <style type="text/css">
    .tier{
      width: 1500px;
      border: 1px solid black;
      margin: 0px auto;
    }
    .border{
      border: 1px solid black;
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
    <div class="border">
    <img class="chacicon" src=${profile.characterImage}>
    <p>${profile.title}  ${profile.characterName }</p>
    <p>서버 : ${profile.serverName}</p>
    <p>길드 : ${profile.guildName}</p>
    <p>클래스 : ${profile.characterClassName}</p>
    <p>전투 레벨 : ${profile.characterLevel}</p>
    <p>원정대 레벨 : ${profile.expeditionLevel }</p>
    <p>아이템 레벨 : ${profile.itemAvgLevel}</p>
    <p>증명의 전장 등급 : ${profile.pvpGradeName}</p>
    <p>영지명 : ${profile.townName}</p>
    </div>
    <div class="border">
      <p>전투 특성</p>
      <c:forEach items="${statlist}" var="stat">
        <p>${stat.type} : ${stat.value}</p>
      </c:forEach>
    </div>
    <div class="border">
      <p>성향</p>
      <c:forEach items="${tendencylist}" var="tendency">
        <p>${tendency.type} : ${tendency.point}</p>
      </c:forEach>
    </div>
    <div class="border">
      <p>장비</p>
      <c:forEach items="${equipment}" var="equ">
        <p><img src="${equ.icon}">${equ.name}</p>
      </c:forEach>
    </div>
    <div class="border">
      <p>카드</p>
      <c:forEach items="${cardset}" var="card">
        <p><img src="${card.icon}"></p>
        <p>${card.name} : ${card.awakeCount}각성</p>
      </c:forEach>
      <p>세트 효과</p>
      <c:forEach items="${cardeffect}" var="cardef" varStatus="status">
        <c:forEach items="${cardef.items}" var="item" varStatus="status2">
          <p>${cardef.items.get(status2.index).name} : ${cardef.items.get(status2.index).description}</p>
        </c:forEach>
      </c:forEach>
    </div>
    <div class="border">
      <p>아바타</p>
      <c:forEach items="${avatar}" var="ava">
        <p><img src="${ava.icon}"></p>
        <p>${ava.name}</p>
      </c:forEach>
    </div>
    <div class="border">
      <p>보석</p>
        <c:forEach items="${gemlist.gems}" var="jewel" varStatus="status3">
          <p><img src="${jewel.icon}"> ${jewel.name}</p>
          <p>${gemlist.effects.get(status3.index).name} : ${gemlist.effects.get(status3.index).description}</p>
        </c:forEach>
    </div>
  </div>
</div>
</body>
</html>