function UpdateMenu() {
	try {
		var name = document.getElementById("menuName").value;
		var cost = document.getElementById("menuCost").value;
		var category = document.querySelector('input[name="category"]:checked').value;
		var form = document.UpdateMenuForm;
		
		if (UpdateNameCheak()) {
			console.log("UpdateMenu_log : PASS UpdateNameCheak");
			
			if (UpdateCostCheak()) {
				
				var lastQuestion = confirm("메뉴 이름 : " + name + "\n메뉴 가격 : " + cost + "원\n카테고리 : " + category + "\n이상의 내역이 맞습니까?")
				if (lastQuestion) {
					console.log("UpdateMenu_log : Allow submit");
					form.submit();
				} else {
					console.log("UpdateMenu_log : Denied submit");
					alert("메뉴 추가가 취소되었습니다.");
					return false;
				}
				
			} else {
				console.log("UpdateMenu_ERROR : ERROR AddCostCheak");
				return false;
			}
			
		} else {
			console.log("UpdateMenu_ERROR : ERROR AddNameCheak");
			return false;
		}
	} catch (e) {
		console.log("UpdateMenu_error : " + e);
		alert("오류가 발생했습니다.\n" + e);
		return false;
	}
}

function UpdateNameCheak() {
	try {
		var name = document.getElementById("menuName").value;
		var nameReg = new RegExp("^([a-zA-Z가-힣0-9]{2,20})$", "gm");
		
		if(name != '') {
			
			if(nameReg.test(name)) {
				console.log("UpdateNameCheak_log : menuName " + name);
				return true;
			} else {
				console.log("UpdateNameCheak_not : this MENUNAME did not pass the RegExp : " + name);
				alert("메뉴 이름은 영문, 한글, 숫자만 사용할 수 있습니다.\n띄어쓰기, 자음 글자, 모음 글자는 허가되지 않습니다.\n6자리 이상 20자리 이하여야 합니다.");
				return false;
			}
			
		} else {
			console.log("UpdateNameCheak_not : Not Found menuName value");
			alert("메뉴 이름을 적어 주십시오");
			return false;
		}
		
	} catch (e) {
		console.log("UpdateNameCheak_error : " + e);
		alert("오류가 발생했습니다.\n" + e);
		return false;
	}
	
	
	
}
function UpdateCostCheak() {
	try {
		let costValue = document.getElementById("menuCost").value;
		
		if(costValue != '') {
			if(Number(costValue) % 100 == 0){
				console.log("UpdateCostCheak_log : menuCost " + costValue);
				return true;
			} else {
				console.log("UpdateCostCheak_not : Not Found menuCost value");
				alert("메뉴 가격은 100원 단위로 적어야합니다.");
				return false;
			}
		} else {
			console.log("UpdateCostCheak_not : Not Found menuCost value");
			alert("메뉴 가격을 적어주십시오");
			return false;
		}
		
	} catch (e) {
		console.log("UpdateCostCheak_error : " + e);
		alert("오류가 발생했습니다.\n" + e);
		return false;
	}
}