function SignUpNullCheak(){
	
	try {
		var id = document.getElementById("id").value;
		var pwd = document.getElementById("pwd").value;
		var name = document.getElementById("name").value;
		var sex = document.querySelector('input[name="sex"]:checked').value;
		
		if(id != '') {
			console.log("SignUpNullCheak_log : ID " + id);
			
			if(pwd != '') {
				console.log("SignUpNullCheak_log : PWD " + pwd);
				
				if (name != '') {
					console.log("SignUpNullCheak_log : NAME " + name);
					
					if(sex != '') {
						console.log("SignUpNullCheak_log : SEX " + sex);
						return true;
						
					}else {
						console.log("SignUpNullCheak_not : Not Found sex value");
						alert("성별을 입력해 주십시오");
						return false;
					}
					
				} else {
					console.log("SignUpNullCheak_not : Not Found name value");
					alert("이름을 입력해 주십시오");
					return false;
				}
				
			} else {
				console.log("SignUpNullCheak_not : Not Found pwd value");
				alert("비밀번호를 입력해 주십시오");
				return false;
			}
			
		} else {
			console.log("SignUpNullCheak_not : Not Found id value");
			alert("아이디를 입력해 주십시오");
			return false;
		}
		
	} catch (e) {
		console.log("SignUpNullCheak_error : " + e);
		return false;
	}
}

function SignUpPWDRegExp() {
	try {
		var pwd = document.getElementById("pwd").value;
		var pwdReg = new RegExp('(?!^[0-9]*$)(?!^[a-zA-Z!@#$%^&*()_+=<>?]*$)^([a-zA-Z!@#$%^&*()_+=<>?0-9]{6,15})$', 'gm');
		
		if (pwd != '') {
			
			if (pwdReg.test(pwd)) {
				
				console.log("SignUpPWDRegExp_log : PWD " + pwd);
				return true;
				
			} else {
				
				console.log("SignUpPWDRegExp_not : this password did not pass the RegExp : " + pwd);
				alert("비밀번호는 반드시 영문과 숫자로만 이루어지며 특수기호도 포함할 수 있습니다.\n길이는 6자리 이상 15자리 이하여야 합니다.");
				return false;
			}
			
		} else {
			console.log("SignUpPWDRegExp_not : Not Found pwd value");
			return false;
		}
		
	} catch (e) {
		console.log("SignUpPWDRegExp_error : " + e);
		return false;
	}
}

function SignUpIDRegExp() {
	
	try {
		
		var id = document.getElementById("id").value;
		var idReg = new RegExp('(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{6,20})$', 'gm');
		
		if (id != '') {
			if (idReg.test(id)) {
				console.log("SignUpIDRegExp_log : ID " + id);
				return true;
			} else {
				console.log("SignUpIDRegExp_not : this ID did not pass the RegExp : " + id);
				alert("아이디는 영문과 숫자로만 만들 수 있습니다.\n길이는 6자리 이상 20자리 이하여야 합니다.");
				return false;
			}
		} else {
			console.log("SignUpIDRegExp_not : Not Found id value");
			return false;
		}
		
	} catch (e) {
		console.log("SignUpIDRegExp_error : " + e);
		return false;
	}
	
}

function SignUpCheak() {
	try {
		var form = document.SignUpForm;
		if (SignUpNullCheak()) {
			
			console.log("SignUpCheak_log : PASS SignUpNullCheak");
			if (SignUpIDRegExp()) {
				
				console.log("SignUpCheak_log : PASS SignUpIDRegExp");
				
				if (SignUpPWDRegExp()) {
					
					console.log("SignUpCheak_log : PASS SignUpPWDRegExp");
					form.submit();
					
				} else {
					
					console.log("SignUpCheak_ERROR : ERROR SignUpPWDRegExp");
					
				}
			} else {
				
				console.log("SignUpCheak_ERROR : ERROR SignUpIDRegExp");
				
			}
			
		} else {
			console.log("SignUpCheak_ERROR : ERROR SignUpNullCheak");
		}
	} catch (e) {
		console.log("SignUpCheak_ERROR : " + e);
	}
}

function SignUpIDCheakPopUp() {
	try {
		var id = document.getElementById("id").value;
		
		if (id != '') {
			if(SignUpIDRegExp()) {

				var url = "/View/User/SignUpPopUp.jsp?id=" + id;
			    var name = "popup test";
			    var option = "width = 500, height = 500, top = 100, left = 200, location = no"
			    	
			    window.open(url, name, option);
			    
			    console.log("SignUpIDCheakPopUp_log : OPEN URL " + url);
			    
			} else {

				console.log("SignUpIDCheakPopUp_ERROR : this ID did not pass the RegExp : " + id);
				return false;
			}
		} else {

			console.log("SignUpIDCheakPopUp_not : Not Found id value");
			alert("아이디를 입력해 주십시오");
			return false;
		}
		
		
	    
	} catch (e) {
		console.log("SignUpIDCheakPopUp_ERROR : " + e);
	}
}