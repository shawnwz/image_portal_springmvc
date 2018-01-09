Submit.prototype.checkEmail=function() {
	var emailTxt = $("#EmailAddress").val();
	if (emailTxt.length<=50&&submitObj.check(emailTxt, /^(([\w\-_\.]{1,100})@([\w\-_\.]{1,100}).([\w\-_\.]){1,30})$/)) {//\w@\w*\.\w
		$.post("checkName", {
					"userName" : emailTxt
				}, function(data) {
					if (data.state == 1) {
						return true;
					}else{
						
						//alert(data.message);
					}
				});
	} else {
		$('#EmailAddress').parent().removeClass('has-success').addClass('has-error');
		$('#EmailAddress').parent().find('label.has-error').show().html("以数字、字母、下划线组成的,总长度在5~50个字符");
	
	}
	return true;
}

Submit.prototype.checkPwd=function() {
	var emailTxt = $("#Password").val();
	
	if(emailTxt.length<=0)
	{
		$('#Password').parent().removeClass('has-success').addClass('has-error');
		$('#Password').parent().find('label.has-error').show().html("以数字、字母、下划线组成的6~20个字符");

		return false;
	}
	
	if (submitObj.check(emailTxt, /^(\w){6,20}$/)) {
		$('#Password').parent().removeClass('has-error').addClass('has-success');
		$('#Password').parent().find('label.has-error').hide();
		return true;
	} else {
//		alert("请输入有效的密码:以数字、字母、下划线组成的6~20个字符");
		$('#Password').parent().removeClass('has-success').addClass('has-error');
		$('#Password').parent().find('label.has-error').show().html("以数字、字母、下划线组成的6~20个字符");

	}
	return false;
} 

Submit.prototype.registSubmit=function() {// FirstNameLastName

	var isSuccess = 0;
	
	
	var emailTxt = $("#EmailAddress").val();
	if (emailTxt.length<=50 &&submitObj.check(emailTxt, /^(([\w\-_\.]{1,100})@([\w\-_\.]{1,100}).([\w\-_\.]){1,30})$/)) {
		$('#EmailAddress').parent().removeClass('has-error').addClass('has-success');
		$('#EmailAddress').parent().find('label.has-error').hide();
		//isSuccess = 0;
	} else {
		//alert("请输入正确的电子邮箱:以数字、字母、下划线组成的,总长度在5~50个字符");
		$('#EmailAddress').parent().removeClass('has-success').addClass('has-error');
		$('#EmailAddress').parent().find('label.has-error').show().html("以数字、字母、下划线组成的,总长度在5~50个字符");
		
		isSuccess = 1;
	}
	
	
	var username = $("#userName").val();
	if (username.length >0) {

		$('#userName').parent().removeClass('has-error').addClass('has-success');
		$('#userName').parent().find('label.has-error').hide();
		 
	} else {
//		alert("请输入有效的密码:以数字、字母、下划线组成的6~20个字符");
		$('#userName').parent().removeClass('has-success').addClass('has-error');
		$('#userName').parent().find('label.has-error').show().html("用户名不能为空");
		isSuccess = 1;
	}
	

	if (!Submit.prototype.checkPwd())
	{
		isSuccess = 1;
	}
	
	if(isSuccess > 0)
	{
		return;
	}
	
	$.post("checkName", {
				"userName" : emailTxt
			}, function(data) {
				if (data.state == 1) {
					
					if (/*Submit.prototype.checkEmail() &&*/ Submit.prototype.checkPwd())
					 {
						$.post("regist.do", $("#registForm").serialize(), function(data) {
							if (data.state == 1) {
								alert("注册成功", function() {
										});
								window.location.href = "registSuccess.do";
							} else if (data.state == -1) {
								alert("验证不通过");
							} else if (data.state == 0) {
								alert("注册失败用户名重复");
							}
						});
					}
					else
					{
						
						
					}
					
				}else{
					
					alert(data.message);
				}
			});
	
	

}
// ////////////////
