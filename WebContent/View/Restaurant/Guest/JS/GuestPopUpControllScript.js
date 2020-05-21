function EnableTableShowPopUp(myname) {
	try {
		console.log("EnableTableShowPopUp_LOG : Menu Add PopUp OPEN ID : " + myname);
		
			let check = confirm("환영합니다. " + myname + "님\n자리를 확인하시겠습니까?");
			
			if(check) {
				
				let url = "/Restaurant/Guest/DisableTable?pageNumber=1";
			    let name = "Enable Table Show";
			    let option = "width = 550, height = 550, top = 100, left = 200, location = no, scrollbars = yes, re";
			    
			    window.open(url, name, option);
			} else {
				alert("취소되었습니다.");
				return false;
			}
			
	    
	} catch (e) {
		console.log("EnableTableShowPopUp_ERROR : " + e);
		return false;
	}
}