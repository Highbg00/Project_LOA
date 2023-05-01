function emptyCheck() {
	var ok = true;
	$('.chk').each(function() {
		if ( $(this).val() == '' ) {  // 입력 값이 없다면
		// 해당 태그의 속성 중 title 값을 가져와 + '을 입력하세요!' 경고창을 띄움	
			alert($(this).attr('title') + '을 입력하세요!');
			$(this).focus();
		// 입력한 내용이 없는 상태... false
			ok = false;
			return ok;	
		}		
	});
	return ok;	
}