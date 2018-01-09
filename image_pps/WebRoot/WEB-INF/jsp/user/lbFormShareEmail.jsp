<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<link rel="Shortcut Icon" href="images/favorite.ico" type="image/x-icon" />
<link rel="Bookmark" href="images/favorite.ico" type="image/x-icon" />
<link rel="icon" href="images/favorite.ico" type="image/x-icon" />
<link href="flowsearch/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/layout.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/font.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/nav.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/cont.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/responsive.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="flowsearch/js/jquery-1.8.3.min.js"></script>
<!--[if lte IE 9]>
<script type="text/javascript" src="flowsearch/js/respond.min.js"></script>
<![endif]-->
<!-- <script type="text/javascript" src="flowsearch/js/default.js"></script> -->
<script type="text/javascript" src="flowsearch/js/jquery.validate.js"></script>
<script type="text/javascript" src="flowsearch/js/form.js"></script>

</head>
<body class="lbWrap">



	<h2>分享链接到邮箱</h2>
	<div class="intro">把所有权移交给另一 Gaopin 会员其它会员将会收到复制灯箱。在不影响您的灯箱图片的情况下，他们可以随意改动有关图片。</div>

	<form role="form" method="post" class="postForm form-lg form-normal">
		<div class="form-group">
			
			<div class="input-group">
				<div class="row">
					<div class="col-xs-2 control-label">由：</div>
					<div class="col-xs-10">
						${sendEmailer }
					</div>
				</div>
			</div>
			<div class="input-group">
				<div class="row">
					<div class="col-xs-2 control-label">致：</div>
					<div class="col-xs-10">
						<input type="text" class="form-control" id="formEmail1" name="formEmail1" placeholder="对方的邮箱地址">
						<label class="has-error" for="formEmail" generated="true"></label>
					</div>
				</div>
			</div>
			
			<div class="input-group">
				<div class="row">
					<div class="col-xs-2 control-label">主题：</div>
					<div class="col-xs-10">
						<input type="text" class="form-control" id="formEmail2" name="formEmail2">
					</div>
				</div>
			</div>
			<div class="input-group">
				<div class="row">
					<div class="col-xs-2 control-label">链接：</div>
					<div class="col-xs-10 linkBreak">
						http://gaopinimages.com:
					</div>
				</div>
			</div>
			
			<div class="input-group">
				<div class="row">
					<div class="col-xs-2 control-label">附言：</div>
					<div class="col-xs-10">
						<textarea type="text" class="form-control" id="formEmail3" name="formEmail3" rows="4"></textarea>
					</div>
				</div>
			</div>

			
			<div class="btnBtm">
				<div class="row">
					<div class="col-xs-offset-2 col-xxs-offset-0 col-xs-3 col-xxs-12">
					<input id="sendEmail" class="btnSubmi btn-block btnPurple SiYuan-ExtraLight" name="" type="button" value="分享"/>
					</div>
				</div>
			</div>
		</div><!--form-group-->
	</form>





















</body>
</html>
<script>
	
$(document).ready(function(){
// alert(0);
	var boxid= ${lightboxId };
					if(boxid == 0)
					{
						alert("请选择灯箱");
						this.close();
						return;
					}
	var url = "";
	var urlChar=document.URL.split("/");//$("base").attr("href").split("/");
	$.ajax({
		url : "my/getcode",
		type : "post",
		data : "boxid=" + boxid,
		async : false,
		success : function(data) {
			
			url = urlChar[0]+"//"+urlChar[2]+"/anounymous/lightbox?code="
					+ data.code;
					
			$(".linkBreak").html(url);
		}
	});
	
	$("#sendEmail").bind(
				"click",
				function() {
					//发送邮件
					$.ajax({
						url : "my/sendEmail",
						type : "post",
						data : "title=" + $("#formEmail2").val()
								+ "&url=" + $(".linkBreak").html()
								+ "&msg=" + $("#formEmail3").val()
								+ "&accepter="
								+ $("#formEmail1").val()
								+"&localPpath="+urlChar[0]+"//"+urlChar[2]+"/",
						success : function(data) {
							alert("发送成功", function() {
								//location.reload(true);
							});
						}
					});
				});
})
</script>