function paymentDetailShow(formNumber) {
	try {
		
		if (formNumber != '') {
			console.log("PaymentDetailShow_Log : Show Payment Detail");
			let form = document.getElementById("detail" + formNumber);
			form.submit();
			
		} else {
			console.log("PaymentDetailShow_NOT : Not value formNumber");
			alert("오류가 발생했습니다.\n" + e);
			return false;
		}
		
		
		
		
		
	} catch (e) {
		console.log("PaymentDetailShow_ERROR : " + e);
		alert("오류가 발생했습니다.\n" + e);
		return false;
	}
}