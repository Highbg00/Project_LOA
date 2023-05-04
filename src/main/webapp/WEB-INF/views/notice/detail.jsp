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
		<td>댓글</td>
	</tr>
	<c:forEach items="${replylist}" var="reply">
		<tr>
			<th>${reply.writer}</th>
			<td>${reply.content}</td>
			<c:if test="${loginInfo.id eq reply.writer}">
				<td><a class="btn-fill" href="replymodify.no?id=${reply.reply_id}">수정</a>
					<a class="btn-fill" href="replydelete.no?id=${reply.reply_id}">삭제</a></td>
			</c:if>
		</tr>
	</c:forEach>

	<form action="replyinsert.no" method="post" enctype="multipart/form-data">
		<input type="hidden" name='notice_id' value="${vo.id} }">
		<input type="hidden" name='notice_id' value="${vo.id} }"> <!-- 댓글 순서용 댓글 갯수 넣는 곳 insert 구문에서 +1씩 추가할 예정 -->
		<tr>
			<th>댓글 작성</th>
			<td><textarea name='content' title='내용' class='chk' ></textarea></td>
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

	<c:if test="${ ! empty loginInfo }">
		<a class='btn-fill' href='reply.no?id=${vo.id }'>답글쓰기</a>
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

</script>
</html>