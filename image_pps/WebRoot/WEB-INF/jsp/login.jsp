<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?06d046c45fc354feaec92ccb1e49f895";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>

<body class="pageLogin">
<jsp:include page="inc/pagetop_user.jsp" /> 
<script type="text/javascript">
$(document).ready(function(){
	$("#signInButton").click(loginUser);
	
});

function key13(e,a){
	if(e&&e.keyCode==13){
		loginUser();
	}
}

function loginUser(){
		if(typeof($("#userName").val())!="undefined"&&
				typeof($("#password").val())!="undefined"){
			
			$.post("userlogin.do", $("#formLogin").serialize(), function(data) {
				if (data.state == 1) {
					//myAlert("登陆成功", function() {
					//			window.location.href = "${backurl}";
					//		});
					var url="${backurl}";
					if(url.indexOf("/search")>0)
					{
						if(url.indexOf("#")>=0)
							url=url.substr(0,url.indexOf("#"));
						url+=$.cookie("shash");
					}
					
					window.location.href = url;
				} else if (data.state == -1) {
					alert("验证不通过");
				} else if (data.state == 0) {
					alert("用户名或密码错误");
				}
			});
		}else{
			alert("用户名或密码错误");
		}
	}
</script>
    <link href="flowsearch/css/sub.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/jquery-ui.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" charset="utf-8"
	src="js/myjs/_mySubmit.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/myjs/_myRegist.js"></script>
<!-- InstanceBeginEditable name="cont" -->



<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">
	<div class="container">
		
		<div class="row subPageWrap">
			<div class="col-md-6 registerForm">
				<div class="row">
					<div class="col-md-10">
						
						
						<h2 class="Source-Han-Light">登录</h2>

						<form role="form" method="post" id="formLogin" action="userlogin" class="postForm form-lg">
							<div class="form-group">
								<div class="input-group focusWrap">
									<div class="input-group-addon icon-font icon-10-email"></div>
									<input id="userName" name="userName" class="form-control" type="email1" placeholder="用户名或邮件地址"></input>
									<label class="has-error" for="formEmail" generated="true"></label>
								</div>
								<div class="input-group focusWrap">
									<div class="input-group-addon icon-font icon-12-password"></div>
									<input id="password" name="password" class="form-control" type="password" placeholder="密码" onkeypress="key13(event,this)"></input>
									<label class="has-error" for="formPassword" generated="true"></label>
									<a href="getPwd" class="linkForget">忘记密码？</a>
								</div>
								<div class="btnBtm">
									<input class="btnSubmit btn-block btnPurple" name="" type="submit" value="登&nbsp;&nbsp;录" id="signInButton"/>
								</div>
								<div class="txtLinkFooter text-right"><a href="registpage">注册新用户</a></div>
							</div><!--form-group-->
						</form>
					</div><!--col-md-10-->
				</div><!--row-->
			</div><!--registerForm-->
		
			<div class="col-md-6 registerServices hidden-xs">
				<div class="row">
					<div class="col-md-10 col-md-offset-2">
					
						<h3 class="Source-Han-Light">高品为用户提供的服务</h3>
						<ul class="nav nav-tabs tab-md Source-Han-Light" role="tablist">
							<li class="active"><a href="#tab1" role="tab" data-toggle="tab">搜索</a></li>
							<li><a href="#tab2" role="tab" data-toggle="tab">浏览</a></li>
							<li><a href="#tab3" role="tab" data-toggle="tab">收藏</a></li>
							<li><a href="#tab4" role="tab" data-toggle="tab">下载</a></li>
							<li><a href="#tab5" role="tab" data-toggle="tab">推荐</a></li>
							<li><a href="#tab6" role="tab" data-toggle="tab">活动</a></li>
						</ul>
						<!-- Tab panes -->
						<div class="tab-content row text-center">
							<div class="tab-pane active" id="tab1"><img src="flowsearch/images/login/service1.jpg"/></div>
							<div class="tab-pane" id="tab2"><img src="flowsearch/images/login/service2.jpg"/></div>
							<div class="tab-pane" id="tab3"><img src="flowsearch/images/login/service3.jpg"/></div>
							<div class="tab-pane" id="tab4"><img src="flowsearch/images/login/service4.jpg"/></div>
							<div class="tab-pane" id="tab5"><img src="flowsearch/images/login/service5.jpg"/></div>
							<div class="tab-pane" id="tab6"><img src="flowsearch/images/login/service6.jpg"/></div>
						</div>
					
					</div><!--col-md-10-->
				</div><!--row-->
				
			</div><!--registerServices-->
		</div><!--row-->
	</div><!--container-->
</div><!--sectionCont-->


<jsp:include page="inc/bottomflow.jsp" />

</body>
<!-- InstanceEnd --></html>
 
