function MenuAddPopUp(myid) {
	try {
		console.log("MenuAddPopUp_LOG : Menu Add PopUp OPEN ID : " + myid);
		if(myid == 'admin') {
			
			confirm("");
			
			var url = "/View/Restaurant/Master/Menu/MenuAddPage.jsp";
		    var name = "Menu Add";
		    var option = "width = 500, height = 500, top = 100, left = 200, location = no"
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