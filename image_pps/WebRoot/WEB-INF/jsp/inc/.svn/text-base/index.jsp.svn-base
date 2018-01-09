<%@page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.gaopin.entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>高品图像 – 高品质的图库摄影及插画</title>
<meta name="viewport" content="width=device-width" />
<meta name="description" content="著名的创意资源供应机构，为广告、营销及媒体专业人员提供视觉素材——创意图片、编辑图片、免版税图片、插画、影像视频以及版权服务。" />
<meta name="keywords" content="图库,图片库,图片社,图片公司,图片网站,创意图片,编辑图片,免版税图片,插画,影像,视频,影视素材,短片,素材,广告摄影,商业摄影,正版图片,历史图片,历史照片,风景图片,旅游图片,名人肖像,明星图片,娱乐图片,纪实图片,人文图片,自然图片,科技图片,艺术作品,精品图片,高清图片,图片下载" />
<link rel="Shortcut Icon" href="flowsearch/images/favorite.ico" type="image/x-icon" />
<link rel="Bookmark" href="flowsearch/images/favorite.ico" type="image/x-icon" />
<link rel="icon" href="flowsearch/images/favorite.ico" type="image/x-icon" />

<link href="css-flow/layout.css" rel="stylesheet" type="text/css" />
<link href="css-flow/font.css" rel="stylesheet" type="text/css" />
<!-- <link href="css-flow/nav.css" rel="stylesheet" type="text/css" /> -->
<link href="css-flow/cont.css" rel="stylesheet" type="text/css" />
<link href="css-flow/responsive.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js-flow/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/s.page.js"></script>
<script language="javascript">
$(document).ready(function() {
		var html = '';
		<c:forEach items="${list}" var="item" varStatus="stat">
		html += '<div class="bannerImg">';
		//http://www.gaopinimages.com/webrescarousel-homeNews
		html += '<img src="webres/upload/${item.path}" width="1920" height="670"/>';
		html += '<div class="label Source-Han-Light hidden-xs hidden-sm"><a href="http://gaopinimages.com/image/${item.gaopinId}">${item.memo}</a> <a href="${item.link}">${item.linkName}</a></div>';
		html += '</div>';
		</c:forEach>
		$(".bannerImgWrap").append(html);
		
	$("#reg-frm-sbmt").click(function(){submitObj.registSubmit();});
	
	$("#registForm input").each(function(){
		$(this).data("placeholder",$(this).attr("placeholder"));
		$(this).focus(function(){
			$(this).attr("placeholder","");
			});
		$(this).blur(function(){
			$(this).attr("placeholder",$(this).data("placeholder"));
			});
	});
	
});		
function openPage(url){
	window.open(url, "", 
			"toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=yes, width=800, height=600");
	
}
</script>
<script type="text/javascript" src="flowsearch/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="flowsearch/js/jquery.ui.datepicker-zh-CN.js"></script>
<link href="css/jquery-ui.css" rel="flowsearch/stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/favourite.js"></script>

<script type="text/javascript" src="js-flow/banner.js"></script>
<script type="text/javascript" src="js-flow/modernizr.custom.10564.js"></script>
<script type="text/javascript" src="js-flow/bootstrap.min.js"></script>
<script type="text/javascript" src="js-flow/jquery.md5.js"></script>
<script type="text/javascript" src="js-flow/youziku.js"></script>
<!--[if lte IE 9]>
<script type="text/javascript" src="js/respond.min.js"></script>
<![endif]-->
<script type="text/javascript" charset="utf-8"
	src="js/myjs/_mySubmit.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/myjs/_myRegist.js"></script>
	
	
<link href="flowsearch/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/layout.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/font.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/jquery.selectBox.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/nav.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/cont.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/responsive.css" rel="stylesheet" type="text/css" />

<!-- new add 1212 s -->
<script type="text/javascript" src="flowsearch/js/imagesloaded.pkgd.min.js"></script>
<script type="text/javascript" src="flowsearch/js/masonry.pkgd.min.js"></script>
<script type="text/javascript" src="flowsearch/js/jquery.infinitescroll.js"></script>

<link href="flowsearch/css/jcarousel.responsive.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/jquery.selectBox.js"></script>
<script type="text/javascript" src="flowsearch/js/icheck.js"></script>
<link href="flowsearch/css/blue.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/tooltipster.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/jquery.tooltipster.js"></script>
<!-- <script type="text/javascript" src="flowsearch/js/jquery.validate.js"></script> -->
<!-- <script type="text/javascript" src="flowsearch/js/form.js"></script> -->
<!--[if lte IE 9]>
<script type="text/javascript" src="flowsearch/js/respond.min.js"></script>
<![endif]-->
<!-- InstanceBeginEditable name="head" -->
<script type="text/javascript" src="flowsearch/js/search.js"></script>
<!-- new add 1212 e -->


<script type="text/javascript" src="flowsearch/js/jquery.jcarousel.js"></script>
    <script type="text/javascript" src="flowsearch/js/default.js"></script>
    <script type="text/javascript" src="flowsearch/js/lightbox.js"></script>
    <script type="text/javascript" src="flowsearch/js/jquery.jqModal.js"></script>
    <script type="text/javascript" src="flowsearch/js/sub.js"></script>
    <script type="text/javascript" src="flowsearch/js/jquery.validate.js"></script>
    <script type="text/javascript" src="flowsearch/js/form.js"></script>
<script type="text/javascript" src="flowsearch/myjs/jquery.cookie.js"></script>
<link href="flowsearch/css/sub.css" rel="stylesheet" type="text/css" />

<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?06d046c45fc354feaec92ccb1e49f895";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>

<script type="text/javascript">
(function() {
var jkb = document.createElement('script'); jkb.type = "text/javascript"; jkb.async = true;
jkb.src = document.location.protocol + "//exp.jiankongbao.com/loadtrace.php?host_id=13140&style=6&type=1";
var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(jkb, s);
})();
</script>      

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-62125481-1', 'auto');
  ga('send', 'pageview');

</script> 

<script type="text/javascript" src="flowsearch/js/nav.js"></script>

</head>
<body class="pageHome">
<jsp:include page="./inc/pagetop_user.jsp" /> 
<!-- InstanceEndEditable -->

<div id="userCenterMobileMenu"  class="hoverShowTarget" targetParent="navUserCenter">
	
	<ul class="navMobile" style="display:none">
		<li><a href="my/person" class="iconUser">个人信息</a></li>
		<li class="active"><a href="my/lightbox" class="iconFolder" >收藏夹</a> <span style=" display: none; " class="icon-font icon-2-arrowRight"></span></li>
		<li><a href="my/myqp" class="iconHistory" >下载记录</a></li>
		<li><a href="#" class="iconInvoice" style="display:none">发票</a></li>
		<li><a href="#" class="iconSet" style="display:none">套餐</a></li>
		<li><a href="logout.do" class="btnLogOut btnPurple">退出登录</a></li>
	</ul>
	<ul class="navMobile">
				<li><a href="my/person" class="iconUser">个人信息</a></li>
				<li><a href="my/lightbox" class="iconFolder">收藏夹</a> </li>
				<li><a href="my/myqp" class="iconHistory">下载记录</a></li>
<!-- 				<li><a href="#" class="iconInvoice">发票</a></li> -->
<!-- 				<li><a href="#" class="iconSet">套餐</a></li> -->
				<li><a href="logout.do" class="iconLogOut btnLogOut">退出登录</a></li>
			</ul>
	
	<div class="navMobileSub visible-xs visible-sm"  >
		<div class="favFolderControl">
			<span class="icon-font icon-46-createNew btnCreateNewInFav"></span>
			<span class="icon-font icon-50-trash"></span>
		</div>

		<div class="favouriteFolderList">
			<div class="favFolderBox" lightBoxId="1">
				<a href="userFavourite.html" class="folder">
					<div class="favFolderName">秋天图片收集1</div>
					<div class="favFolderAmount">共<span>10</span>张图片</div>
				</a>
				<span class="btnClose icon-font icon-cross"></span>
			</div><!--favListBox-->
			<div class="favFolderBox" lightBoxId="2">
				<a href="userFavourite2.html" class="folder">
					<div class="favFolderName">秋天图片收集2</div>
					<div class="favFolderAmount">共<span>10</span>张图片</div>
				</a>
				<span class="btnClose icon-font icon-cross"></span>
			</div><!--favListBox-->
			<div class="favFolderBox" lightBoxId="3">
				<a href="userFavourite.html" class="folder">
					<div class="favFolderName">秋天图片收集3</div>
					<div class="favFolderAmount">共<span>10</span>张图片</div>
				</a>
				<span class="btnClose icon-font icon-cross"></span>
			</div><!--favListBox-->
			<div class="favFolderBox" lightBoxId="4">
				<a href="userFavourite2.html" class="folder">
					<div class="favFolderName">秋天图片收集4</div>
					<div class="favFolderAmount">共<span>10</span>张图片</div>
				</a>
				<span class="btnClose icon-font icon-cross"></span>
			</div><!--favListBox-->
		</div>
	</div>
</div><!--userCenterMobileMenu-->
	

<div id="sectionCont">
	<div id="homeBanner">
		
		<div class="bannerWrap autoRotate">
			<div class="bannerImgWrap">
<!-- 				<div class="bannerImg"> -->
<!-- 					<img src="images-flow/home/topBanner/banner1.jpg" width="1920" height="670"/> -->
<!-- 					<div class="label Source-Han-Light hidden-xs hidden-sm"><a href="#">133201438387 by Charlie Harding</a> <a href="#">查看相似</a></div> -->
<!-- 				</div> -->
<!-- 				<div class="bannerImg"> -->
<!-- 					<img src="images-flow/home/topBanner/banner2.jpg" width="1920" height="670"/> -->
<!-- 					<div class="label Source-Han-Light hidden-xs hidden-sm"><a href="#">133101653393 by aurora-RF</a> <a href="#">查看最新</a></div> -->
<!-- 				</div> -->
<!-- 				<div class="bannerImg"> -->
<!-- 					<img src="images-flow/home/topBanner/banner3.jpg" width="1920" height="670"/> -->
<!-- 					<div class="label Source-Han-Light hidden-xs hidden-sm"><a href="#">133200514672 by Ming H2 Wu</a> <a href="#">查看相似</a></div> -->
<!-- 				</div> -->
<!-- 				<div class="bannerImg"> -->
<!-- 					<img src="images-flow/home/topBanner/banner4.jpg" width="1920" height="670"/> -->
<!-- 					<div class="label Source-Han-Light hidden-xs hidden-sm"><a href="#">133200512108 by John Lund</a> <a href="#">查看最新</a></div> -->
<!-- 				</div> -->
<!-- 				<div class="bannerImg"> -->
<!-- 					<img src="images-flow/home/topBanner/banner5.jpg" width="1920" height="670"/> -->
<!-- 					<div class="label Source-Han-Light hidden-xs hidden-sm"><a href="#">133100037175 by TOMIO TAKAHASHI</a> <a href="#">查看摄影师作品</a></div> -->
<!-- 				</div> -->
			</div>
			
			
			<div class="searchBar">
				<div class="container">
					<div class="searchBarInner col-md-9">
						<span class="SiYuan-ExtraLight hidden">搜索高品图像</span>
						<input id="q" class="searchFiled SiYuan-ExtraLight" name="" type="text" placeholder="搜索高品图像"></input>
						<a href="#" class="btnSearch icon-font icon-13-search"></a>
					</div>
				</div>
			</div>
 
			<div class="bannerThumbWrap hidden-xs hidden-sm"></div>
			<div class="btnPageDown icon-font icon-9-down hidden-xs hidden-sm"></div>
 
		</div><!--bannerWrap-->
	
	</div><!--homeBanner-->
	

	
	<div class="container">
		<c:choose>
			<c:when test="${questionType eq 1}">
				<div class="row row1 hidden-xs">
					<div class="col-md-12">
						<a href="${questionIUrl }" id="ad1" class="boxAd">
							<img src="webres/upload/${questionISrc }"/>
						</a>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="row row1 hidden-xs">
					<div class="col-md-8">
						<a href="${questionIIUrl0 }" id="ad2" class="boxAd">
							<img src="webres/upload/${questionIISrc0 }"/>
						</a>
					</div>		
					<div class="col-md-4 hidden-sm">
						<a href="${questionIIUrl }" id="ad3" class="boxAd">
							<img src="webres/upload/${questionIISrc }"/>
							<div class="cont">
								<div class="header"><img src="webres/upload/${questionIITitle }"/></div>
								<p>${questionIIInfo }</p>
							</div>
						</a>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
		
		<div id="carousel-homeNews" class="carousel slide row">
			<!-- Wrapper for slides -->
			<div class="carousel-inner Source-Han-Light" role="listbox">
				<div class="item active">
					<a href="${questionSMUrl }">
						${questionSMInfo }<br/>
						${questionSMSrc } 
					</a>			
				</div>
			</div><!--carousel-homeNews-->

			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-homeNews" role="button" data-slide="prev">
				<span class="icon-font icon-1-arrowLeft"></span>
			</a>
			<a class="right carousel-control" href="#carousel-homeNews" role="button" data-slide="next">
				<span class="icon-font icon-2-arrowLeft"></span>
			</a>
		</div>

		
		
		<div class="row2">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs Source-Han-Light" role="tablist">
				<li class="active"><a href="#tab1" role="tab" data-toggle="tab">创意灵感</a></li>
				<li><a href="#tab2" role="tab" data-toggle="tab">编辑之选</a></li>
			</ul>
			
			<!-- Tab panes -->
			
			<div class="tab-content row">
				<div class="tab-pane active" id="tab1">
					<div class="col-md-4 col-sm-4 column">
						<a href="${newOnlineUrl1 }" class="boxCollection">
							<img src="webres/upload/${newOnlineSrc1 }"/>
							<div class="cont"><span class="Source-Han-Light txt">${newOnlineTitle1 }</span></div>
						</a>
						<a href="photostock659" target="_blank" class="boxCollectionMore hidden-sm hidden-xs">
							<div class="header SiYuanBold">激发灵感</div>
							<p class="SiYuan-ExtraLight">为您提供来自全球顶级的商业摄影图片、插画以及影像等创意素材。</p>
						</a>
					</div>
					<div class="col-md-3 col-sm-4 column">
						<a href="${newOnlineUrl2 }" class="boxCollection">
							<img src="webres/upload/${newOnlineSrc2 }"/>
							<div class="cont"><span class="Source-Han-Light txt">${newOnlineTitle2 }</span></div>
						</a>
						<a href="${newOnlineUrl3 }" class="boxCollection">
							<img src="webres/upload/${newOnlineSrc3 }"/>
							<div class="cont"><span class="Source-Han-Light txt">${newOnlineTitle3 }</span></div>
						</a>
					</div>
					<div class="col-md-5 col-sm-4 column">
						<a href="${newOnlineUrl4 }" class="boxCollection">
							<img src="webres/upload/${newOnlineSrc4 }"/>
							<div class="cont"><span class="Source-Han-Light txt">${newOnlineTitle4 }</span></div>
						</a>
						<a href="${newOnlineUrl5 }" class="boxCollection">
							<img src="webres/upload/${newOnlineSrc5 }"/>
							<div class="cont"><span class="Source-Han-Light txt">${newOnlineTitle5 }</span></div>
						</a>
					</div>
				</div>
				<div class="tab-pane" id="tab2">
				
					<div class="col-md-4 col-sm-4 column">
						<a href="${gaopinSelectUrl1 }" class="boxCollection">
							<img src="webres/upload/${gaopinSelectSrc1 }"/>
							<div class="cont"><span class="Source-Han-Light txt">${gaopinSelectTitle1 }</span></div>
						</a>
						<a href="http://gaopinimages.com/photostock/1" class="boxCollectionMore hidden-sm hidden-xs">
							<div class="header SiYuanBold">推荐精彩</div>
							<p class="SiYuan-ExtraLight">为您挑选高质量的自然、人文、科技、艺术、历史等题材图片。</p>
						</a>
					</div>
					<div class="col-md-3 col-sm-4 column">
						<a href="${gaopinSelectUrl2 }" class="boxCollection">
							<img src="webres/upload/${gaopinSelectSrc2 }"/>
							<div class="cont"><span class="Source-Han-Light txt">${gaopinSelectTitle2 }</span></div>
						</a>
						<a href="${gaopinSelectUrl3 }" class="boxCollection">
							<img src="webres/upload/${gaopinSelectSrc3 }"/>
							<div class="cont"><span class="Source-Han-Light txt">${gaopinSelectTitle3 }</span></div>
						</a>
					</div>
					<div class="col-md-5 col-sm-4 column">
						<a href="${gaopinSelectUrl4 }" class="boxCollection">
							<img src="webres/upload/${gaopinSelectSrc4 }"/>
							<div class="cont"><span class="Source-Han-Light txt">${gaopinSelectTitle4 }</span></div>
						</a>
						<a href="${gaopinSelectUrl5 }" class="boxCollection">
							<img src="webres/upload/${gaopinSelectSrc5 }"/>
							<div class="cont"><span class="Source-Han-Light txt">${gaopinSelectTitle5 }</span></div>
						</a>
					</div>
				
				</div>
			</div>
			
			
			<a href="imgsets" class="btnMore Source-Han-Light" >查看所有</a>
		</div><!--row2-->
		
		<div class="row3">
			
			<div class="left hidden-sm hidden-xs">
				<img src="images-flow/home/registerBg.jpg"/>
				<div class="cont">
					<div class="header SiYuan-ExtraLight">马上注册<small>享受更多服务</small></div>
					<p class="Source-Han-Light">
						免费下载无水印小样图<br/>
						收藏你的喜爱，分享你的发现<br/>
						会员积分制，可获惊喜奖励
					</p>
				</div>
			</div>
			<div class="right">
				<div class="cont">
					<div class="header SiYuan-ExtraLight">高品图像</div>
					
					<div class="form-group">
						<form id="registForm" action="regist.do" method="post">
<!-- 							<div class="input-group has-error" > -->
							<div class="input-group focusWrap" >
								<div class="input-group-addon icon-font icon-18-userName"></div>
								<input class="form-control" id="userName" name="userName" type="text" placeholder="用户名"></input>
								<label class="has-error" for="formName" generated="true"></label>
							</div>
<!-- 							<div class="input-group has-success"> -->
							<div class="input-group focusWrap" >
								<div class="input-group-addon icon-font icon-10-email"></div>
								<input id="EmailAddress" name="email"  class="form-control" type="email" placeholder="邮件地址"></input>
								<label class="has-error" for="formName" generated="true"></label>
							</div>
							<div class="input-group focusWrap">
								<div class="input-group-addon icon-font icon-12-password"></div>
								<input id="Password" name="password" class="form-control" type="password" placeholder="设置密码"></input>
								<label class="has-error" for="formName" generated="true"></label>
							</div>
							<div class="btnBtm">
								<a id="reg-frm-sbmt" class="btn-block btnPurple SiYuan-ExtraLight" style=" cursor: pointer; ">现在注册</a>
							</div>
						</form>
					</div>
					
					
				</div><!--cont-->
			</div>
		</div><!--row3-->
	</div><!--container-->
	
	
	
	
	
	
	
	
	
	
</div><!--sectionCont-->


<jsp:include page="inc/bottomflow.jsp" />

</body>
</html>
