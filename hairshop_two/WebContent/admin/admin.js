/**
 * 
 */
function worker_check() {
	if (document.frm.workerid.value == "") {
		alert("아이디를 입력하세요.");
		return false;
	} else if (document.frm.workerpw.value == "") {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
}
	
//function cancel_check(){ // main.jsp에서 예약취소버튼을 눌렀을 경우
//	var all = $(this).parents();
//	var ac = all.children().children();
//	
//	console.log(all.html());
//	
//	var cancel_name = $('a#name').text();
//	console.log(cancel_name);
//	var cancel_id = $('input#id').val();
//	var cancel = confirm(cancel_name + "님의 예약을 취소하시겠습니까?");
//	console.log(cancel_id);
	
//    if ( cancel == true ) {
//       location.href= "HairshopServlet?command=cusres_delete&id=" + cancel_id;
//    }
//}

function delete_check(){ // customer_detail.jsp에서 고객정보삭제버튼을 눌렀을 경우
	var cancel_name = $('td#name').text();
	var cancel_id = $('td#idd').text();
	var cancel = confirm(cancel_name + "님의 정보를 삭제하시겠습니까?");
	console.log(cancel_id);
	
	if(cancel==true){
		location.href="HairshopServlet?command=cus_delete&id=" + cancel_id;
	}
}

function open_win(url, name) { // submenu.jsp에서 고객등록 or 고객정보수정 클릭 시
	window.open(url, name, 'width=500, height=350');
}

function idcheck(){	// 중복확인 클릭 시 발생하는 함수
	if(document.formm.id.value == ""){
		alert("id를 입력해 주세요.");
		document.formm.id.focus();
		return;
	}
	var url = "HairshopServlet?command=id_check_form&id=" + document.formm.id.value;
	window.open(url, "idcheck", "toolbar=no, menubar=no, " +
			"scrollbars=yes, resizable=no, width=330, height=200");
}

function idok(){	// 중복확인 페이지에서 id 사용눌렀을 떄 발생하는 함수
	opener.formm.id.value="${id}";
	opener.formm.id.value="${id}";
	self.close();
}

function insert_customer(){ // customer_insert.jsp에서 빈칸입력안되게
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
		document.formm.action = "HairshopServlet?command=cus_insert";
		document.formm.submit();
	}
}

//main.jsp, customer_list.jsp에서 고객검색 시 빈칸입력안되게 설정
// 이거 스크립트문이 살짝 헷갈려요... 액션클래스 완성되면 말씀해주세요
function go_search(){   
	if(document.formm.searchText.value==""){
		alert("성명이나 연락처를 입력해주세요.")
		document.formm.searchText.focus();
		return;
	} else{
		document.formm.action = "HairshopServlet?command=cus_list";
		document.formm.submit();
	}
}

function go_detail_update(){ // customer_detail_update에서 빈칸 입력안되게
	var updatename = document.formm.name.value;
	var update = confirm(updatename + "님의 정보를 수정하시겠습니까?");
	
	if(document.formm.name.value==""){
		alert("수정하시려는 이름을 입력해주세요.")
		document.formm.name.focus();
	} else if(document.formm.phone.value==""){
		alert("수정하시려는 번호를 입력해주세요.")
		document.formm.phone.focus();
	} else if(document.formm.address.value==""){
		alert("수정하시려는 주소를 입력해주세요.")
		document.formm.address.focus();
	} else if(update == true){
		document.formm.action = "HairshopServlet?command=cus_update";
		document.formm.submit();
	}
}

function go_back(){
	history.back();
}