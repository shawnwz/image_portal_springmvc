Submit.prototype.checkEmail=function() {
	var emailTxt = $("#EmailAddress").val();
	if (emailTxt.length<=50&&submitObj.check(emailTxt, /^(([\w\-_\.]{1,100})@([\w\-_\.]{1,100}).([\w\-_\.]){1,30})$/)) {//\w@\w*\.\w
		$.post("checkName", {
					"userName" : emailTxt
				}, function(data) {
					if (data.state == 1) {
						return true;
					}else{
						
						myAlert(data.message);
					}
				});
	} else {
		myAlert("请输入正确的电子邮箱:以数字、字母、下划线组成的,总长度在5~50个字符");
	}
	return false;
}

Submit.prototype.checkPwd=function() {
	var emailTxt = $("#Password").val();
	if (submitObj.check(emailTxt, /^(\w){6,20}$/)) {
		return true;
	} else {
		myAlert("<span>请输入有效的密码:以数字、字母、下划线组成的6~20个字符</span>");
	}
	return false;
}
Submit.prototype.registSubmit=function() {// FirstNameLastName
	
	
	var emailTxt = $("#EmailAddress").val();
	if (emailTxt.length<=50&&submitObj.check(emailTxt, /^(([\w\-_\.]{1,100})@([\w\-_\.]{1,100}).([\w\-_\.]){1,30})$/)) {
		$.post("checkName", {
					"userName" : emailTxt
				}, function(data) {
					if (data.state == 1) {
						
						if (/*Submit.prototype.checkEmail() &&*/ Submit.prototype.checkPwd()
						) {
					$.post("regist.do", $("#registForm").serialize(), function(data) {
								if (data.state == 1) {
									myAlert("注册成功", function() {
												window.location.href = "index";
											});
								} else if (data.state == -1) {
									myAlert("验证不通过");
								} else if (data.state == 0) {
									myAlert("注册失败用户名重复");
								}
							});
						}
						
					}else{
						
						myAlert(data.message);
					}
				});
	} else {
		myAlert("请输入正确的电子邮箱:以数字、字母、下划线组成的,总长度在5~50个字符");
	}
	
	
	
	
	

}
// ////////////////
