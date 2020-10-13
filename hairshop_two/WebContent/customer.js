function gogo(){
	window.open("admin/index.jsp");
//	self.close();
}

function insert_customer(){
	if(document.formm.id.value==""){
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
		document.formm.action ="HairshopServlet?command=cus_join";
		document.formm.submit();
	}
}

function id_check() {
	if (document.formm.id.value == "") {
		alert("아이디를 입력하세요.");
		return false;
	} else if (document.formm.pw.value == "") {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
}