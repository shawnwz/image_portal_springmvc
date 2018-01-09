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
<script>
function checkName()
{
	var user = $("#formEmail").val();
	if(user == "")
	{
		alert("邮箱不可为空！");
		return;
	}
			$.ajax({
					url : "my/checkuser",
					type : "post",
					data : "user=" + user,
					success : function(data) {
						if(data.code==1){
							shiftLightbox(user);
						}else if(data.code==-1){
							alert("验证失败，请重新验证");
						}else if(data.code==0){
							alert("该用户不存在");
						}
					}
				});
}

function shiftLightbox(userid) {
					var boxid= ${lightboxId };
					if(boxid == 0)
					{
						alert("请选择灯箱");
						return;
					}
					
					$.ajax({
						url : "my/shiftlightbox",
						type : "post",
						data : "boxid=" +boxid
								+ "&userid=" +userid,
						success : function(data) {
									if(data.code==-1){
										alert("发送失败");
									}else if(data.code==1){
										alert("转移成功");
									}else if(data.code==0){
										alert("转移失败");	
									}
						},
						complete :function(){
							
						}
					});
				}
</script>
</head>
<body class="lbWrap">

 

	<h2>分享给其它高品会员</h2>
	<div class="intro">把所有权移交给另一 Gaopin 会员其它会员将会收到复制灯箱。在不影响您的灯箱图片的情况下，
他们可以随意改动有关图片。 </div>

	<form role="form" method="post" class="postForm form-lg form-normal">
		<div class="form-group">
			
 
			
				<div class="row">
					<div class="col-xs-8 col-xxs-12">
						<div class="input-group">
							<input type="text" class="form-control" id="formEmail" name="formEmail1" placeholder="对方的用户名或邮箱地址">
							<label class="has-error" for="formEmail" generated="true"></label>
						</div>
					</div>
					<div class="col-xs-3 col-xxs-12">
						<input class="btnSubmi btn-block btnPurple SiYuan-ExtraLight" name="" type="button" value="分享" onclick="checkName()"/>
					</div>
				</div>
			

 
		</div><!--form-group-->
	</form>





















</body>
</html>
