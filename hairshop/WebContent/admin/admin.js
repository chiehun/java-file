/**
 * 
 */
function cancel_check(){ // main.jsp에서 예약취소버튼을 눌렀을 경우
	var cancel_name = $('a#name').text();
	var cancel_id = $('input#id').val();
	var cancel = confirm(cancel_name + "님의 예약을 취소하시겠습니까?");
	console.log(cancel_id);
	 
    if ( cancel == true ) {
       location.href= "HairshopServlet?command=cusres_delete&id=" + cancel_id;
    }
}

function delete_check(){ // customer_detail.jsp에서 고객정보삭제버튼을 눌렀을 경우
	var cancel_name = $('td#name').text();
	var cancel_id = $('td#id').text();
	var cancel = confirm(cancel_name + "님의 정보를 삭제하시겠습니까?");
	console.log(cancel_id);
	
	if(cancel==true){
		location.href="서블릿?커맨드=삭제처리&id=" + cancel_id;
	}
}

function open_win(url, name) { // submenu.jsp에서 고객등록 or 고객정보수정 클릭 시
	window.open(url, name, 'width=500, height=350');
}

function idcheck(){
	if(document.formm.id.value == ""){
		alert("id를 입력해 주세요.");
		document.formm.id.focus();
		return;
	}
	var url = "서블릿?아이디체크&id=" + document.formm.id.value;
	window.open(url, "idcheck", "toolbar=no, menubar=no, " +
			"scrollbars=yes, resizable=no, width=330, height=200");
}

function idok(){
	opener.formm.id.value="${id}";
	opener.formm.id.value="${id}";
	self.close();
}

function insert_customer(){ // 입력다했는지 체크하는 구문 삽입할 것!!!!!!!!!!!!!!
	if(document.formm.id.value==""){
		document.formm.id.focus();
	} else if(document.formm.id.value != document.formm.reid.value){
		alert("중복확인이 필요합니다.");
		document.formm.id.focus();
	} else if(document.formm.pw.value==""){
		document.formm.pw.focus();
	} else if(document.formm.pw.value != document.formm.pwcheck.value){
		alert("패스워드가 서로 다릅니다.")
		document.formm.pw.focus();
	} else if(document.formm.name.value==""){
		document.formm.name.focus();
	} else if(document.formm.phone.value==""){
		document.formm.phone.focus();
	} else if(document.formm.address.value==""){
		document.formm.address.focus();
	} else {
		document.formm.action = "서블릿?커맨드=등록처리 후 class에서 close.jsp로 페이지 이동해주세요";
		document.formm.submit();
	}
}