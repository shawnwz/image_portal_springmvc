<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ page import="com.gaopin.entity.User"%>
<jsp:include page="question_header.jsp" /> 
<script type="text/javascript" src="js/require.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/myjs/_mySubmit.js"></script>
<script type="text/javascript" charset="utf-8"
	src="promoted/js/_myRegist.js"></script>
  
<script type="text/javascript">
$(document).ready(function() {
	$("#reg-frm-sbmt").click(function(){submitObj.registSubmit();});
	$("#signInButton").click(loginUser);
	
	 <%User user = (User)session.getAttribute(User.class.getName());
		if(user!=null){%>
			//var url="Questionnaire/step3.do?login=1";
			var url=$("#baseUrl").val()+"Questionnaire/step3.do?login=1";
					window.location.href = url;
	<%} %>
});

// function key13(e,a){
// 	if(e&&e.keyCode==13){
// 		loginUser();
// 	}
// }

function loginUser(){
		if(typeof($("#userNameLogin").val())!="undefined"&&
				typeof($("#passwordLogin").val())!="undefined"){
			
			$.post("userlogin.do", $("#loginForm").serialize(), function(data) {
				if (data.state == 1) {
					//回填fr_questionnaire表 userid
					$.post("Questionnaire/updateUserId.do", {}, function(data) {
						 
					});
					
					var url=$("#baseUrl").val()+"Questionnaire/step3.do?login=1";
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


<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">
	<div class="container">
 		<div class="row1"><img src="promoted/images/promoted/topBanner.jpg"/></div><!--row1-->

				
		<div class="row2 row">
			<div class="col-md-6 col-md-offset-3">
				<h2 class="SiYuanBold">为什么参与？</h2>
				<p>高品网站已经全新改版上线，你对新网站有什么建议？请完成下面几个小问题，	只要你的信息真实有效， 就会获得我们为你准备的精美好礼，价值RMB120，礼品有限，先到先得，快快点击参与！</p>
			</div>
		</div><!--row2-->
		
		
		

		
		<div class="applyWrap promotedApply" id="formApply">
				<div class="headerBar"><span class="SiYuan-ExtraLight">有奖调查</span></div>
				
				<div class="applyContWrap">
					<div class="stepCont">
						<div class="stepProcess">
							<div class="dot past">1</div>
							<div class="bar past"></div>
							<div class="dot active">2</div>
						</div><!--stepProcess-->
						<div class="contBox">
							
							<ul class="nav nav-tabs tab-login " role="tablist">
								<li class="active"><a href="#tab1" role="tab" data-toggle="tab">注册</a></li>
								<li><a href="#tab2" role="tab" data-toggle="tab">登录</a></li>
							</ul>
							<!-- Tab panes -->
							<div class="tab-content row text-center">
								<div class="tab-pane active" id="tab1">
									<div class="intro">
										感谢你的参与，请注册并完善个人资料，我们将按你填写的联系方式分配专员为你派送价值 RMB120 的精美好礼！你的支持，是高品前进的动力！
									</div>
									<form role="form" method="post" id="registForm" class="postForm form-lg">
										<div class="input-group focusWrap">
											<div class="input-group-addon icon-font icon-18-userName"></div>
											<input id="userName" name="userName" class="form-control" type="text" placeholder="用户名"></input>
											<label class="has-error" for="formName" generated="true"></label>
										</div>
										<div class="input-group focusWrap">
											<div class="input-group-addon icon-font icon-10-email"></div>
											<input id="EmailAddress" name="email" class="form-control" type="email" placeholder="邮件地址"></input>
											<label class="has-error" for="formEmail" generated="true"></label>
										</div>
										
										
										<div class="input-group focusWrap">
											<div class="input-group-addon icon-font icon-12-password"></div>
											<input id="Password" name="password" class="checkfPassword form-control" type="password" placeholder="设置密码"></input>
											<label class="has-error" for="formPassword" generated="true"></label>
											<div class="icon-font icon-52-eye btnShowPasswd"></div>
										</div>
											
										<div class="btnBtm">
											<a id="reg-frm-sbmt" href="#" class="btnNext">注册，完善资料</a>
											<!--<input class="btnSubmit btn-block btnPurple" name="" type="submit" value="注&nbsp;&nbsp;册" onClick="location.href='registerSuccess.html'"/>-->
										</div>
									</form>
								</div>
								<div class="tab-pane" id="tab2">
									<div class="intro">
										感谢你的参与，请注册并完善个人资料，我们将按你填写的联系方式分配专员为你派送价值 RMB120 的精美好礼！你的支持，是高品前进的动力！
									</div>
									<form method="post" id="loginForm" action="userlogin" class="postForm2 form-lg">

										<div class="input-group focusWrap">
											<div class="input-group-addon icon-font icon-10-email"></div>
											<input id="userNameLogin" name="userName" class="form-control" type="email" placeholder="用户名或邮件地址"></input>
											<label class="has-error" for="formEmail" generated="true"></label>
										</div>
										<div class="input-group focusWrap">
											<div class="input-group-addon icon-font icon-12-password"></div>
											<input id="passwordLogin" name="password" class="form-control" type="password" placeholder="密码"></input>
											<label class="has-error" for="formPassword" generated="true"></label>
										</div>
										<div class="btnBtm">
											<a href="#" id="signInButton" class="btnNext">登录，完善资料</a>
										</div>

									</form>
								
								</div>
							</div>
							
							
						</div><!--contBox-->
					</div><!--stepCont-->

				</div><!--applyContWrap-->
		</div><!--applyWrap-->
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	</div><!--container-->
</div><!--sectionCont-->
<!-- InstanceEndEditable -->
<div id="sectionBtm">
	<div class="container">

        <div class="row">
            <div class="col-lg-12"><a href="javascript:void(0)" class="logo"><img src="images/logoFooter.png"></a></div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <div class="boxContact">
                    <h6 class="hotline">热线：</h6>
                    400-820-0268
                    <br><br>
                    <h6 class="email">服务电邮：</h6>
                    <a href="mailto:service@gaopinimages.com" target="_blank">service@gaopinimages.com</a>
                </div>
                <div class="aboutTitleFooter">关注我们</div>
                <div class="greyBg">
                    <div class="boxMedia">
                        <div class="icon"><img src="images/iconWeChat.gif"></div>
                        <div class="label">官方微信</div>
                    </div>
                    <div class="boxMedia ">
                        <a href="javascript:void(0)" class="icon icon-font icon-16-sina"></a>
                        <div class="label hidden-xs hidden-sm">官方微博</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="visible-xs visible-sm hidden-md hidden-lg footerMobileLink">
                    <a href="aboutus.html">ABOUT US</a><br>
                    <a href="javascript:;" style="display:none;">搜索技巧</a>
                </div>
            </div>
            <div class="col-md-2 col-md-offset-1">
                <dl>
                    <dt><a href="aboutus.html">ABOUT</a></dt>
                    <dd><a href="aboutus.html"> About Gaopin</a></dd>
                    <dd><a href="news.html"> 高品新闻</a></dd>
                    <dd><a href="careers.html"> 加入我们</a></dd>
                    <dd><a href="terms.html#horizontalTab1"> 网站使用协议</a></dd>
                    <dd><a href="terms.html#horizontalTab2"> 隐私保护政策</a></dd>
                    <dd><a href="terms.html#horizontalTab3"> Cookie政策</a></dd>
                    <dd><a href="terms.html#horizontalTab4"> 授权条款及条件</a></dd>
                </dl>
            </div>
            <div class="col-md-2">
                <dl>
                    <dt><a href="photostock659">创意图片</a></dt>
                    <dd><a href="photostock660">创意RM</a></dd>
                    <dd><a href="photostock662">创意RF</a></dd>
                </dl>
                <dl>
                    <dt><a href="photostock661">编辑图片</a></dt>
                    <dt><a href="imgsets">高品专题</a></dt>
                    <dt style="display:none"><a href="javascript:;">高品视频</a></dt>
                </dl>
            </div>
            <div class="col-md-2">
                <dl>
                    <dt><a href="Contributor/index.na">供稿通道</a></dt>
                    <dd><a href="Contributor/index.na">申请成为供稿人</a></dd>
                    <dd>&nbsp;</dd>
                </dl>
                <dl>
                    <dt style="display:none"><a href="javascript:;">我的账户</a></dt>
                    <dd style="display:none"><a href="javascript:;">个人历史</a></dd>
                    <dd style="display:none"><a href="javascript:;">订购历史</a></dd>
                    <dd><a href="my/lightbox">收藏夹</a></dd>
                </dl>
            </div>
            <div class="col-md-2">
                <dl>
                    <dt>客户服务</dt>
                    <dd><a href="contactus.html">联系我们</a></dd>
                    <dd style="display:none"><a href="javascript:;">搜索技巧</a></dd>
                </dl>
            </div>
        </div>

    </div>
</div><!--sectionBtm-->

<div id="footer">
	<div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 copyright"><div>© 2015 由高品(上海)图像服务有限公司提供。本网站所有影像均由高品(上海)图像服务有限公司授权发布。侵权必究。       沪ICP备09095511号</div></div>
        </div>
    </div>
</div>






			
</body>
<!-- InstanceEnd --></html>
