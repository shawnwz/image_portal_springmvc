<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>高品图像 – 高品质的图库摄影及插画</title>
<%@include file="/header.jsp"%>
<link href="css/indexstyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/wow/style.css" type="text/css"></link>

<script type="text/javascript">
	/*首页 动画*/
	$(document).ready(function() {
		$(".index-banner").height($(window).height() - $(".top").height()-$(".menu").height());//大图图片高度
		$(".info1").height($(window).height() - $(".top").height());
		
		
		$(".index-banner .index-banner-button").click(function() {
			$(".info1").removeClass("mySys");
			$(".info1").removeClass("donghu_down");
			$(".index-middle-button").removeClass("donghu_down");//down
			setTimeout(function() {
				$(".index-middle-button").addClass("donghu_up");//up
				$(".info1").addClass("donghu_up");
			}, 150);
			$(".index-middle-button").removeClass("mySys");
			$(this).addClass("mySys");
		});
		
		
		$(".index-middle-button").click(function() {

			$(".index-middle-button").removeClass("donghu_up");
			$(".index-middle-button").addClass("donghu_down");

			$(".info1").removeClass("donghu_up");
			$(".info1").addClass("donghu_down");

			setTimeout(function() {
				$(".info1").scrollTop(0);
				$(".index-banner .index-banner-button").removeClass("mySys");
				$(".index-middle-button").addClass("mySys");
				$(".info1").addClass("mySys");

			}, 2010);

		});
		
		
		$("#zhegai").css("height", "1160px");
		/* end 首页动画*/
		
		
		BindAutoClear($("#q"),"Search");
	});
</script>
</head>
<script type="text/javascript" src="css/static/js/style.js"></script>
<script type="text/javascript" src="js/s.page.js"></script>

<!--[if IE 6]>
			<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a.js"></script>
			<script type="text/javascript">
				DD_belatedPNG.fix('.png-img');
			</script>
		<![endif]-->
<body onresize="chickbodywidth()" onload="chickbodywidth()"
	style="overflow: hidden;">
	
<jsp:include page="inc/top.jsp"/>

	<div class="index-banner">
		<div id="bigview"><div class="ws_images">
			<ul>
			<c:forEach items="${list}" var="item" varStatus="stat">
    			<li><img class="index-banner-img"  title="${item.memo}" link="image${item.gaopinId}"
					src="http://alpha.app.gaopinimages.com/webres/upload/${item.path}" /></li>
					
    		</c:forEach>
			</ul>
			</div>
			<span class="wsl"></span>
			<a href="javascript:void(0);" class="ws_frame"></a>
		</div>
		<input id="q" class="index-banner-search" value="" style="border: 1px solid #A0A0A0;" autocomplete="off"/>
		<div class="index-banner-imformation">
			<a href="javascript:void(0);" onmouseover="boxshow('banner-imformation')"
				onmouseout="boxhidden('banner-imformation')" onclick="location.href=$('#banner-imformation').attr('link')"><img
				src="css/static/images/index_banner_imformation.png" />
			</a>
			<span id="banner-imformation">42-43675230 / Creative / Crush<img
				src="css/static/images/index_banner_imformation_bor.png" />
			</span>
			
		</div>
		<div class="index-banner-button">
			<img src="css/static/images/banner_bottom_button.png" />
		</div>
		
	</div>

	<div class="info1 mySys" style="">
		<div class="myZhegai" id="zhegai" style=""></div>
		<div class="myZhegai" id="context" style="height:1160px;">
			<div class="index-middle-pic-box">
			
			

				<div style="width: 1032px; margin:0 auto;height: 100%;">
				
				<iframe src="index3" style="width: 100%;height: 80%;border:2px inset;"></iframe>
				</div>








				<p class="share-box mysys">
					<a href="#"><img src="css/static/images/share_sina.png" />
					</a> <a href="#"><img src="css/static/images/share_qqweibo.png" />
					</a> <a href="#"><img src="css/static/images/share_weixin.png" />
					</a> <a href="#"><img src="css/static/images/share_dou.png" />
					</a> <a href="#"><img src="css/static/images/share_renren.png" />
					</a> <a href="#"><img src="css/static/images/share_qq.png" />
					</a>
				</p>
			</div>


			<!-- 尾巴 -->
			<div style="background-color: #181818;">

				<div class="index-bottom-menu">
					<div class="index-bottom-menu-middle">
						<div>
							<p>创意类</p>
							<p>
								<a href="#">版权管理图片</a>
							</p>
							<p>
								<a href="#">免版税图片</a>
							</p>
							<p>
								<a href="#">插图</a>
							</p>
							<p>
								<a href="#">虚拟CD</a>
							</p>
						</div>
						<div>
							<p>编辑类</p>
							<p>
								<a href="#">纪实</a>
							</p>
							<p>
								<a href="#">艺术作品</a>
							</p>
							<p>
								<a href="#">档案</a>
							</p>
							<p>
								<a href="#">时事及体育</a>
							</p>
							<p>
								<a href="#">娱乐</a>
							</p>
						</div>
						<div>
							<p>我的账户</p>
							<p>
								<a href="#">档案资料</a>
							</p>
							<p>
								<a href="#">小样图下载记录</a>
							</p>
							<p>
								<a href="#">订单记录</a>
							</p>
							<p>
								<a href="#">灯箱</a>
							</p>
						</div>
						<div>
							<p>我们的政策</p>
							<p>
								<a href="#">网站使用协议</a>
							</p>
							<p>
								<a href="#">隐私保护政策</a>
							</p>
							<p>
								<a href="#">Cookie政策</a>
							</p>
							<p>
								<a href="#">授权条款及条件</a>
							</p>
						</div>
						<div>
							<p>客户服务</p>
							<p>
								<a href="#">与我们联系</a>
							</p>
							<p>
								<a href="#">搜索提示</a>
							</p>
							<p>
								<a href="#">网站使用帮助</a>
							</p>
						</div>
						<div>
							<p>公司简介</p>
							<p>
								<a href="#">关于我们</a>
							</p>
							<p>
								<a href="#">招聘信息</a>
							</p>
						</div>
					</div>
				</div>

				
<div class="index-friend-bg">
	<a href="http://www.corbisimages.com/"><img src="images/friend1.png" /></a>
	<a href="http://www.corbismotion.com/"><img src="images/friend2.png" /></a>
	<a href="http://corbisentertainment.com/"><img src="images/friend3.png" /></a>
	<a href="http://www.splashnews.com"><img src="images/friend4.png" /></a>
</div>

				<div class="index-bottom">© 2013由Gaopin Images
					高品图像提供。本网站所有影像均由Gaopin Images 高品图像授权发布。侵权必究。 沪ICP备13010110号-1</div>

			</div>

		</div>

		<div class="index-middle-button mySys">
			<img src="css/static/images/index_middle_bg.png" style="margin-left: -10px;"/>
		</div>

	</div>
	<script type="text/javascript" src="css/wow/wowslider.js"></script>
	<script type="text/javascript" src="css/wow/wowSliderkenburns.js"></script>
	<script language="javascript">
	
		$(document).ready(function() {
			//wowSliderkenburns.js
			var optionkenburn = {
					effect : "kenburns",
					prev : "",
					next : "",
					duration : 40 * 100,
					delay : 20 * 100,
					width : 1433,
					height : 1087,
					autoPlay : true,
					playPause : false,
					stopOnHover : false,
					loop : false,
					bullets : 0,
					caption : true,
					captionEffect : "slide",
					controls : false,
					onBeforeStep : 0,
					images : 0
				};
			//kenburns
			jQuery("#bigview").wowSliderkenburns(optionkenburn);
			
			/*
			//wowSliderstack.js
			var optionstack = {
					effect : "stack_vertical",
					prev : "",
					next : "",
					duration : ${duration},
					delay : ${delay},
					autoPlay : true,
					playPause : false,
					stopOnHover : false,
					loop : false,
					bullets : 0,
					caption : true,
					captionEffect : "slide",
					controls : false,
					onBeforeStep : 0,
					images : 0
				};
			//kenburns
			jQuery("#bigview").wowSliderStack(optionstack);
			*/
			/*
			var option = {
				duration : 400,
				delay : 0
			};
			jQuery("#wowslider-container1").wowSlider(option);
			jQuery("#wowslider-container2").wowSlider(option);
			jQuery("#wowslider-container3").wowSlider(option);
			jQuery("#wowslider-container4").wowSlider(option);
			jQuery("#wowslider-container5").wowSlider(option);
			jQuery("#wowslider-container6").wowSlider(option);
			jQuery("#wowslider-container7").wowSlider(option);
			jQuery("#wowslider-container8").wowSlider(option);
			jQuery("#wowslider-container9").wowSlider(option);
			*/
		});
	</script>
</body>
</html>