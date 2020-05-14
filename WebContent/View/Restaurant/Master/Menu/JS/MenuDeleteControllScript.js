function deleteCheck(number, name, cost, category, categoryNumber) {
		try {
			
			let form = document.getElementById("menuDeleteForm" + number);
			
			console.log("DeleteCheck_LOG : " + number + " / " + name + " / " + cost + " / " + category + " / " + categoryNumber);
			
			let check = confirm("메뉴 번호 : " + number + "번\n메뉴 이름 : " + name + "\n메뉴 가격 : " + cost + "원\n카테고리 : " + category + "\n위 메뉴를 삭제하시겠습니까?");
			
			if(check) {
				console.log("DeleteCheck_LOG : pass first check");
				let checkTwo = confirm("마지막으로 묻겠습니다.\n정말로 삭제하시겠습니까?");
				if (checkTwo) {
					
					console.log("DeleteCheck_LOG : pass final check");
					alert("메뉴를 삭제합니다.");
					form.submit();
					
				} else {
					console.log("DeleteCheck_NOT : not pass final check");
					alert("메뉴 삭제가 취소되었습니다.");
					return false;
				}
			} else {
				console.log("DeleteCheck_NOT : not pass first check");
				alert("메뉴 삭제가 취소되었습니다.");
				return false;
			}
		
		} catch (e) {
			console.log("DeleteCheck_ERROR : " + e);
			alert("오류가 발생했습니다.\n" + e);
			return false;
		}
	}