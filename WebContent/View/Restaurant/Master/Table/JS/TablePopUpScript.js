function TableShowPopUp(myid) {
	try {
		console.log("TableShowPopUp_LOG : Menu Add PopUp OPEN ID : " + myid);
		if(myid == 'admin') {
			
			let check = confirm("테이블 확인 페이지를 띄울까요?");
			
			if(check) {
				
				let url = "/Restaurant/Master/Table/ShowTable";
			    let name = "Table Show";
			    let option = "width = 680, height = 700, top = 100, left = 200, location = no, scrollbars = yes, re";
			    
			    window.open(url, name, option);
			} else {
				alert("취소되었습니다.");
				return false;
			}
			
		
		} else {
			console.log("TableShowPopUp_NOT : You are not ADMIN");
			alert("admin계정이 아닙니다.");
			return false;
		}
		
	    
	} catch (e) {
		console.log("MenuAddPopUp_ERROR : " + e);
		return false;
	}
}
function UserShowPopUp(myid) {
	try {
		console.log("UserShowPopUpPopUp_LOG : Menu Add PopUp OPEN ID : " + myid);
		if(myid == 'admin') {
			
			let check = confirm("유저 명단 페이지를 띄울까요?");
			
			if(check) {
				
				let url = "/Restaurant/Master/Table/ShowUser";
				let name = "User Show";
				let option = "width = 575, height = 700, top = 100, left = 200, location = no, scrollbars = yes, re";
				
				window.open(url, name, option);
			} else {
				alert("취소되었습니다.");
				return false;
			}
			
			
		} else {
			console.log("UserShowPopUp_NOT : You are not ADMIN");
			alert("admin계정이 아닙니다.");
			return false;
		}
		
		
	} catch (e) {
		console.log("UserShowPopUp_ERROR : " + e);
		return false;
	}
}