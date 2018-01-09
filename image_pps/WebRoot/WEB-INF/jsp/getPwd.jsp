<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript" src="js/require.js"></script>
<script type="text/javascript" src="js/photographer.js"></script> 
<body class="pageSuccess">
<jsp:include page="inc/pagetop_user.jsp" /> 
<script type="text/javascript">
$(document).ready(function(){
	$("#getPwdButton").click(getPwd);
	
});

function key13(e,a){
	if(e&&e.keyCode==13){
		loginUser();
	}
}

function go()
{
	window.location.href = "login";
}
function getPwd(){
		if(typeof($("#userName").val())!="undefined")
		{ 
			keyup();
			$.post("resetpwd.do", $("#registForm").serialize(), function(data) { 
			 
				if (data.state == 1)
				{
					//alert(data.message);
					//location.href="login";
					$("#sectionCont").hide();
					$("#sectionContSuccess").show();
					setTimeout('go()', 5000 );
				}
				else
				{
					$('#userName').parent().removeClass('has-success').addClass('has-error');
					$('#userName').parent().find('label.has-error').show().html("邮箱有误，请重新输入");
	
				}
			});
		}
		else
		{
					$('#userName').parent().removeClass('has-success').addClass('has-error');
					$('#userName').parent().find('label.has-error').show().html("邮箱有误，请重新输入");
		}
	}
	
	function keyup()
	{
			var emailTxt = $("#userName").val();
		if (emailTxt.length<=50&&submitObj.check(emailTxt, /^(([\w\-_\.]{1,100})@([\w\-_\.]{1,100}).([\w\-_\.]){1,30})$/)) {//\w@\w*\.\w
			 
			$('#userName').parent().removeClass('has-error').addClass('has-success');
			$('#userName').parent().find('label.has-error').hide();
		} else {
			$('#userName').parent().removeClass('has-success').addClass('has-error');
			$('#userName').parent().find('label.has-error').show().html("邮箱有误，请重新输入");
			return;
		}
	}
	
</script>
<link href="css/collections.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" charset="utf-8"
	src="js/myjs/_mySubmit.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/myjs/_myRegist.js"></script>


<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">
	<div class="container">
		
		<div class="row subPageWrap">
			<div class="passwordRecoveryCont">
				<div class="col-md-6 col-md-offset-3">
					<div class="col-md-10 col-md-offset-1">
						<h2 class="Source-Han-Light"><span class="icon-51-question icon-font"></span>忘记密码？不用担心!</h2>
						<br/>
						<p class="h4">输入您注册时填写的邮箱来找回您的密码：</p>
						<br/>
						<form id="registForm" role="form" method="post" class="postForm form-lg">
							<div class="form-group">
								<div class="input-group focusWrap" id="emailAddr">
									<div class="input-group-addon icon-font icon-10-email"></div>
									<input id="userName" name="userName" class="form-control"  placeholder="邮件地址" onkeyup="keyup()"></input>
									<label class="has-error" for="formEmail" generated="true"></label>
								</div>
								<div class="btnBtm">
									<input id="getPwdButton" class="btnSubmit btn-block btnPurple" name="" type="submit" value="发&nbsp;&nbsp;送"/>
								</div>
							</div><!--form-group-->
						</form>
					</div>
				</div>
			</div><!--passwordRecoveryCont-->
			
			
			
		</div><!--subPageWrap-->
	</div><!--container-->
</div><!--sectionCont-->
<!-- InstanceEndEditable -->


<!-- InstanceBeginEditable name="cont" -->
<div id="sectionContSuccess" style="display:none">
	<div class="container">
		
		<div class="row subPageWrap">
			<div class="passwordRecoveryCont">
				<div class="col-md-8 col-md-offset-2">
					<div class="col-md-10 col-md-offset-1">
						<h2 class="Source-Han-Light"><span class="icon-40-success icon-font"></span>发送成功！</h2>
						<br/>
						<p class="h4">谢谢!我们给您的邮箱发送了一个链接用来重新创建密码。</p>
						<br/>
						
					</div>
				</div>
			</div><!--passwordRecoveryCont-->
			
			
			
		</div><!--subPageWrap-->
	</div><!--container-->
</div><!--sectionCont-->
<!-- InstanceEndEditable -->	 


	 
<jsp:include page="inc/bottomflow.jsp" />

</body>
<!-- InstanceEnd --></html>