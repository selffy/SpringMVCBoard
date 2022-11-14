$(function(){

	$("button").click(function(event){
		event.preventDefault();
	});
	// 등록버튼 클릭시 등록화면으로 이동
	$("#regBtn").click(function(event){
		location.href = "/board/boardInsert";
	});
	
	// 입력폼 서밋/리셋
	$(".boardInsertBtns").click(function(event){
		if($(this).attr("id")=="boardInsertSubmitBtn"){
			$("#boardInsertForm").submit();
		}else if($(this).attr("id")=="boardInsertResetBtn"){
			document.forms["boardInsertForm"].reset();
		}
	});
	
	
	// 검색 버튼 클릭
	/*
	$("#searchBtn").click(function(event){
		event.preventDefault();
		
		if (!$("select[name='type']").val()) {
			alert("검색종류를 선택하세요");
			return false;
		}
		if (!$("input[name='keyword']").val()) {
			alert("키워드를 입력하세요");
			return false;
		}
		
		addClicklistener("#searchBtn", "selectFormList", "/board/list" );
	});
	*/
	
	addClicklistener("#searchBtn", "listFromSearch", "/board/list" );
	// 수정버튼 클릭시 수정 처리
	$("#updateBtn").click(function(event){
		event.preventDefault();
		if(confirm("정말 수정하실건가요?")){
			$("#updateForm").submit();
		}else{
			return false;
		}
	});
	
	// 삭제 버튼
	$("#deleteBtn").click(function(event){
		event.preventDefault();
		if(confirm("정말 삭제하실건가요?")){
			location.href = "/board/delete?bno="+$(this).attr("bno");
		}else{
			return false;
		}
		
	});
	
	// 수정 화면 이동 버튼
	addClicklistener("#updateFormBtn", "update", "/board/updateForm" );
	
	// 페이지 번호를 유지하면서 리스트로 이동
	addClicklistener("#listBtn", "listFormPaging", "/board/list" );
	
	// 페이지번호 바뀜, 리스트 화면
	addClicklistener(".pageNumLink", "selectFormList", "/board/list" );
	
	// 제목 클릭시 뷰 화면으로 이동
	addClicklistener(".move", "selectFromList", "/board/select" );
});


// CSS 클래스명, Input엘리먼트name속성의 값들, 이동할 경로
function addClicklistener(element, command, action){
	$(element).click(function(event){
		event.preventDefault();
		$("input[name='pageNum']").val($(this).attr("pagenum"));
		$("input[name='bno']").val($(this).attr("bno"));
		$("input[name='type']").val($("select[name='type']").val());
		$("input[name='keyword']").val($("input[name='keyword']").val());
		if(command=="listFromSearch"){
			$("input[name='pageNum']").val('1');
		}
		$("#actionForm").attr("action", action);
		$("#actionForm").submit();
	});
}