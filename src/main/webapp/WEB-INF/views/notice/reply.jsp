<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src='js/file_check.js'></script>
</head>
<body>
<h3>답글 작성</h3>
<form action="reply_insert.no" method="post" enctype="multipart/form-data">
	<input type="hidden" name='root' value="${vo.root }">
	<input type="hidden" name='step' value="${vo.step }">
	<input type="hidden" name='indent' value="${vo.indent }">

	<table>
		<tr>
			<th class='w-px120'>제목</th>
			<td>
				<input type="text" name="title" title='제목' class='chk' />
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name='content' title='내용' class='chk' ></textarea>
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td class='left'>
				<label>
				<a><img src='imgs/select.png' class='file-img' /></a>
				<input type="file" name="file" id='attach-file' />
				</label>
				<span id='file-name'></span>
				<a id='delete-file'><i class="fa-solid fa-circle-minus"></i></a>
			</td>
		</tr>
		
		
	</table>
</form>
<div class='btnSet'>
	<a class='btn-fill' onclick=" if( emptyCheck() ) $('form').submit()">저장하기</a>
	<a class='btn-empty' href='list.no'>취소</a>
</div>
</body>
</html>







