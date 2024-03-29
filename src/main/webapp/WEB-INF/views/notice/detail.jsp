<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.8/sweetalert2.min.css" rel="stylesheet"> 
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.js"></script>
</head>
<body>
<h3>공지글 안내</h3>
<table>
	<tr>
		<th class='w-px120'>제목</th>
		<td class='left' colspan="5">${vo.title }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${vo.name }</td>
		<th>작성일자</th>
		<td>${vo.writedate }</td>
		<th>조회수</th>
		<td>${vo.readcnt }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td class='left' colspan="5">${fn:replace(vo.content, crlf, '<br>') }</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td class='left' colspan="5">${vo.filename }
			<c:if test="${not empty vo.filename }">
				<a href='download.no?id=${vo.id }'><i class="fa-solid fa-download"></i></a>
			</c:if>
		</td>
	</tr>
	<tr>
		<th colspan="6">댓글</th>
	</tr>
	<c:forEach items="${replylist}" var="reply" varStatus="status">
		<form id="reply${status.count}" action="replymodify.no" method="post" enctype="multipart/form-data">
			<input type="hidden" name="reply_id" value="${reply.reply_id}">
			<input type="hidden" name='notice_id' value="${reply.notice_id}">
			<tr>
				<th>${reply.writer}</th>
				<td colspan="4" class="left"><span id="display_reply${status.count}">${reply.content}</span><input type="text" id="reply-content-modify${status.count}" name="content" value="${reply.content}" style="display: none;"></td>
				<c:if test="${loginInfo.id eq reply.writer}">
					<td><a id="reply_modify${status.count}" class="btn-fill" onclick="reply_modify(${status.count})">수정</a>
						<a id="reply_modify_comp${status.count}" class="btn-fill" onclick="if( emptyCheck() ) document.getElementById('reply${status.count}').submit()" style="display: none;">수정 완료</a>
						<a class="btn-fill" href="replydelete.no?reply_id=${reply.reply_id}&notice_id=${vo.id}" style="display: inline-block">삭제</a></td>
				</c:if>
			</tr>
		</form>
	</c:forEach>

	<form action="replyinsert.no" method="post" enctype="multipart/form-data">
		<input type="hidden" name='notice_id' value="${vo.id}">
		<tr>
			<th>댓글 작성</th>
			<td colspan="4"><textarea class="reply-content" name='content' title='내용' class='chk' ></textarea></td>
			<td><a class='btn-fill' onclick="if( emptyCheck() ) $('form').submit()">작성하기</a></td>
		</tr>
	</form>

</table>
<div class='btnSet'>
	<a class='btn-fill' 
		href='list.no?curPage=${page.curPage }&search=${page.search}&keyword=${page.keyword}'>목록으로</a>
	<c:if test="${loginInfo.id eq vo.writer }">
		<a class='btn-fill' href='modify.no?id=${vo.id }'>수정</a>

		<a class='btn-fill' onclick="notice_delete(${vo.id})">삭제</a>
	</c:if>
</div>
</body>
<script type="text/javascript">
function notice_delete(id) {
	Swal.fire ({
			title: '정말 삭제 하시겠습니까?',
			text: '다시 되돌릴 수 없습니다. 신중하세요.',
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: '승인',
			cancelButtonText: '취소',
			reverseButtons: true,
		}).then(result => {
			if (result.isConfirmed) {
				location.href='delete.no?id=' + id;
			}
	}); 
	
	
}
function reply_modify(count){
	document.getElementById('display_reply'+count).style.display = 'none';
	document.getElementById('reply-content-modify'+count).style.display = 'block';
	document.getElementById('reply_modify'+count).style.display = 'none';
	document.getElementById('reply_modify_comp'+count).style.display = 'inline-block';
}

</script>
</html>