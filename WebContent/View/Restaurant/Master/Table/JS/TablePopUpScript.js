function TableShowPopUp(myid) {
	try {
		console.log("TableShowPopUp_LOG : Menu Add PopUp OPEN ID : " + myid);
		if(myid == 'admin') {
			
			let check = confirm("테이블 확인 페이지를 띄울까요?");
			
			if(check) {
				
				let url = "/Restaurant/Master/Table/ShowTable?pageNumber=1";
			    let name = "Table Show";
			    let option = "width = 665, height = 475, top = 100, left = 200, location = no, scrollbars = yes, re";
			    
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
function paymentShowPopUp(myid) {
	try {
		console.log("PaymentShowPopUp_LOG : Menu Add PopUp OPEN ID : " + myid);
		if(myid == 'admin') {
			
			let check = confirm("결제 내역 페이지를 띄울까요?");
			
			if(check) {
				
				let url = "/Restaurant/Master/Table/ShowPayment";
				let name = "Payment Show";
				let option = "width = 730, height = 700, top = 100, left = 200, location = no, scrollbars = yes, re";
				
				window.open(url, name, option);
			} else {
				alert("취소되었습니다.");
				return false;
			}
			
			
		} else {
			console.log("PaymentShowPopUp_NOT : You are not ADMIN");
			alert("admin계정이 아닙니다.");
			return false;
		}
		
		
	} catch (e) {
		console.log("PaymentShowPopUp_ERROR : " + e);
		return false;
	}
}