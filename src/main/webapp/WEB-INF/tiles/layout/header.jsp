<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "path" value = "${pageContext.request.contextPath}" />

<link rel='stylesheet' type='text/css' href="${path}/css/common.css?v=<%=new Date().getTime() %>">

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
    header div img{
        margin-left: 200px;
    }

    .com{
        font-size: 30px;
        margin-left: 20px;
        padding-top: 10px;
    }
</style>
<header style="border-bottom: 1px solid #ccc; padding: 15px 0; text-align: left;">
    <div class="logo" style="width: 1920px;">
        <a href="<c:url value="/"/>"><img src="@{/img/logo.png}"></a>
        <a class="com" href="community">커뮤니티</a>
        <div style='position: absolute;right: 0; top: 24px; margin-right: 200px;'>
            <!-- 로그인을 하지 않은 경우 -->
            <c:if test="${ empty loginInfo }">
                <ul>
                    <li>
                        <a class='btn-fill' href='login'>로그인</a>
                        <a class='btn-fill' href='member'>회원가입</a>
                    </li>
                </ul>
            </c:if>
            <!-- 로그인한 경우 -->
            <c:if test="${ !empty loginInfo }">
                <ul>
                    <li>
                        <strong>${loginInfo.name }</strong>님
                    </li>
                    <li>
                        <a class='btn-fill' href='logout'>로그아웃</a>
                    </li>
                </ul>
            </c:if>
        </div>
    </div>
</header>