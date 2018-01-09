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
<link href="css/img.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	 
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
	style="/* overflow: hidden; */">

	<jsp:include page="inc/top.jsp" />

	<div class="index-banner" style="height:auto">
		<div class="beforpaly" style="width: 100%;z-index: 999;left: 0px;top: 0px;display: block;position:absolute;" >
			<img style="width: 100%;" src="http://www.gaopinimages.com/webres/upload/${imgFirst.path}"  />
		</div>
		<div id="bigview">
			<div class="ws_images">

			</div>
			<span class="wsl"></span> <a href="javascript:void(0);"
				class="ws_frame"></a>
		</div>
		<input id="q" class="index-banner-search" value=""
			style="border: 1px solid #A0A0A0;z-index: 1000;" autocomplete="off" />
		<div class="index-banner-imformation" >
			<a href="javascript:void(0);"
				onmouseover="boxshow('banner-imformation')"
				onmouseout="boxhidden('banner-imformation')"
				onclick="location.href=$('#banner-imformation').attr('link')"><img
				src="css/static/images/index_banner_imformation.png" /> </a> <span
				id="banner-imformation">42-43675230 / Creative / Crush<img
				src="css/static/images/index_banner_imformation_bor.png" /> </span>

		</div>
		<div class="index-banner-button mySys">
			<img src="css/static/images/banner_bottom_button.png" />
		</div>

	</div>

	<div class="info1 infodiv_underbigview" style=" overflow: visible;top: 800px;">
		<div class="myZhegai" id="zhegai" style="opacity: 1;background-color: #181818;"></div>
		<div class="myZhegai" id="context" style="height:1160px;">
			<div class="index-middle-pic-box">



				<div style="width: 1032px; margin:0 auto;height: 100%;margin-bottom: -125px;">

					<div id="images">
						<div class="kong"></div>



						<div id="pic_one">

							<a class="a_png a_png01" href="photostock/7"></a>
							<!--Mask-->
							<div id="cont_a01">
								<img id="cont_img01 " src="images/01.jpg" alt="图片01"
									title="图片01" style="height: auto;" />
								<p class="yi">创 意</p>
							</div>

							<a class="a_png a_png02" href="photostock/1"></a>
							<!--Mask-->
							<div id="cont_a02">
								<img id="cont_img02 " src="images/02.jpg" alt="图片02"
									title="图片02" style="height: auto;" />
								<p class="yi">编 辑</p>
							</div>
						</div>

						<div id="pic_two">

							<a class="b_png a_png01" href="http://gaopinimages.com:80/anounymous/lightbox?code=a4e09cfeb7671b352c074b7b7a6b9d79"></a>
							<!--Mask-->
							<div id="banner_a01">
								<img id="cont_img03 " src="images/03.jpg" alt="图片03"
									title="图片03" style="height: auto;" />
								<p class="banner">
									<span class="ban_bg">团聚中秋</span><br/>
									在中秋这个团圆的节日里，与家人一起赏月吃月饼吧！但愿人长久，千里共婵娟。
								</p>
							</div>

							<a class="b_png a_png02" href="http://gaopinimages.com:80/anounymous/lightbox?code=5effa585a533ed7a904852a747914e38"></a>
							<!--Mask-->
							<div id="banner_a02">
								<img id="cont_img04 " src="images/04.jpg" alt="图片04"
									title="图片04" style="height: auto;" />
								<p class="banner">
									<span class="ban_bg">浪漫七夕</span><br />
									天街夜色凉如水，卧看牵牛织女星。让浪漫的爱情从七夕开始！
								</p>
							</div>
						</div>

						<div id="pic_thr">

							<a class="b_png a_png01" href="http://gaopinimages.com:80/anounymous/lightbox?code=102288b009297f236ffd2d612cd7f676"></a>
							<!--Mask-->
							<div id="banner_a03">
								<img id="cont_img05 " src="images/05.jpg" alt="图片05"
									title="图片05" style="height: auto;" />
								<p class="banner">
									<span class="ban_bg">泳装模特</span><br />
									穿上漂亮、性感泳装，在沙滩上日光浴，在海水中嬉戏，为炎炎夏日增添一道靓丽风景线。
								</p>
							</div>

							<a class="b_png a_png02" href="http://www.gaopinimages.com:80/anounymous/lightbox?code=3b1ce30fb12098d83f42907e20e304e2"></a>
							<!--Mask-->
							<div id="banner_a04">
								<img id="cont_img06 " src="images/06.jpg" alt="图片06"
									title="图片06" style="height: auto;" />
								<p class="banner">
									<span class="ban_bg">跳动水花</span><br />
									生命不息，运动不止，跟随跳动的水花感受生命的活力。
								</p>
							</div>
						</div>
					</div>
				</div>
				<p class="share-box mySys">
					<a href="#"><img src="css/static/images/share_sina.png" /> </a> <a
						href="#"><img src="css/static/images/share_qqweibo.png" /> </a> <a
						href="#"><img src="css/static/images/share_weixin.png" /> </a> <a
						href="#"><img src="css/static/images/share_dou.png" /> </a> <a
						href="#"><img src="css/static/images/share_renren.png" /> </a> <a
						href="#"><img src="css/static/images/share_qq.png" /> </a>
				</p>
			</div>


			<!-- 尾巴 -->
			<jsp:include page="inc/bottom.jsp" />

		</div>

		<div class="index-middle-button mySys">
			<img src="css/static/images/index_middle_bg.png"
				style="margin-left: -10px;" />
		</div>

	</div>
	<script type="text/javascript" src="css/wow/wowslider.js"></script>
	<script type="text/javascript" src="css/wow/wowSliderkenburns.js"></script>
	<script language="javascript">
		$(document).ready(function() {
			var hei=$(window).width()*1080/1920; 　
			//hei=$(".index-banner img").height();//
			$(".infodiv_underbigview").css("top",(hei+120)+"px");
			//$(".index-banner").css("height",hei+"px");
			
		hei=$(".index-banner img").height();//
		$(".infodiv_underbigview").css("top",(hei+120)+"px");
		//$(".index-banner").css("height",hei+"px");
		//return;
		var html = '<ul style="display:none;">';
		<c:forEach items="${list}" var="item" varStatus="stat">
		html += '<li><img class="index-banner-img"  title="${item.memo}" link="image${item.gaopinId}"					src="http://www.gaopinimages.com/webres/upload/${item.path}"  /></li>';
		</c:forEach>
		html += '</ul>';
		$("#bigview .ws_images").append(html);
		$(".index-banner-imformation").css(
					"bottom",
					$(".index-banner").height() - $(window).height() + 131
							+ "px");
							
							
			startshow();

		 
		});
		function startshow() {
			$(".beforpaly").fadeOut(1000);

			//wowSliderkenburns.js
			var optionkenburn = {
				effect : "kenburns",
				prev : "",
				next : "",
				duration : 40 * 150,
				delay : 20 * 150,
				width : 1433,
				height : 2087,
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
			jQuery("#bigview").wowSliderkenburns(null);
			

			
			$(".ws_images ul").show();
			//start show 
			//xxxxxxxxxxxxxxxxx
			$(".infodiv_underbigview").css("top","auto");
		}
	</script>
</body>
</html>