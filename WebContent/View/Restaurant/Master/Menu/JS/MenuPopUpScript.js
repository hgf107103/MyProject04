function MenuAddPopUp(myid) {
	try {
		console.log("MenuAddPopUp_LOG : Menu Add PopUp OPEN ID : " + myid);
		if(myid == 'admin') {
			
			let check = confirm("메뉴 추가페이지를 띄울까요?");
			
			if(check) {
				
				let url = "/Restaurant/Master/Menu/AddMenu";
			    let name = "Menu Add";
			    let option = "width = 515, height = 650, top = 100, left = 200, location = no";
			    
			    window.open(url, name, option);
			} else {
				alert("취소되었습니다.");
				return false;
			}
			
		
		} else {
			console.log("MenuAddPopUp_NOT : You are not ADMIN");
			alert("admin계정이 아닙니다.");
			return false;
		}
		
	    
	} catch (e) {
		console.log("MenuAddPopUp_ERROR : " + e);
		return false;
	}
}


function MenuShowPopUp(myid) {
	try {
		console.log("MenuAddPopUp_LOG : Menu Add PopUp OPEN ID : " + myid);
		if(myid == 'admin') {
			
			let check = confirm("메뉴 확인 페이지를 띄울까요?");
			
			if(check) {
				
				let url = "/Restaurant/Master/Menu/ShowMenu?pageNumber=1";
			    let name = "Menu Show";
			    let option = "width = 575, height = 765, top = 100, left = 200, location = no, scrollbars = yes, re";
			    
			    window.open(url, name, option);
			} else {
				alert("취소되었습니다.");
				return false;
			}
			
		
		} else {
			console.log("MenuAddPopUp_NOT : You are not ADMIN");
			alert("admin계정이 아닙니다.");
			return false;
		}
		
	    
	} catch (e) {
		console.log("MenuAddPopUp_ERROR : " + e);
		return false;
	}
}