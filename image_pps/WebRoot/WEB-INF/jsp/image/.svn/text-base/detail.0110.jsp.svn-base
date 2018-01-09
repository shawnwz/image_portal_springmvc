<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>搜索结果</title>
<%@include file="/header.jsp" %>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/style.js"></script>
<script langeuage="javascript">
	
	
</script>
</head>
		<!--[if IE 6]>
			<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a.js"></script>
			<script type="text/javascript">
				DD_belatedPNG.fix('.png-img');
			</script>
		<![endif]-->
<body onresize="chickbodywidth()" onload="chickbodywidth()">
	<div class="top">
    	<img src="images/logo.png" class="logo" />
        <div class="imformation">
        	<a href="#"><font size=3><b>Timer[<span id="pageSize">50</span>]:　<span id="timer">--</span></b></font> ms</a>
        	<a href="#"><img src="images/top_phone.png" />400-820-0268</a>
            <a href="#"><img src="images/top_user.png" />Ryan Liu</a> <img src="images/user_more.png" onclick="boxshow('userbox')" />
        </div>
        <div class="user-control" id="userbox" onmouseover="boxshow('userbox')" onmouseout="boxhidden('userbox')">
        	<a href="#"><p>我的账户</p></a>
            <a href="#"><p>灯箱</p></a>
        </div>
    </div>
    
    <div class="menu">
    	<div id="menubox1" onmouseover="meunshow('menubox1')" onmouseout="meunhidden('menubox1')" class="menu-box">
        	<a href="#" class="menu-a-hover">创意图片</a>
        	<div class="menu-showbox">
            	<a href="#"><p><img src="images/showmenu-pic1-1.png" /><span>版权管理图片</span><br />高品质商业类摄影</p></a>
            	<a href="#"><p><img src="images/showmenu-pic1-2.png" /><span>免版税图片</span><br />无限制商业类及编辑类用途</p></a>
            	<a href="#"><p><img src="images/showmenu-pic1-3.png" /><span>插画</span><br />从手绘线条到优美的插画</p></a>
            	<a href="#"><p><img src="images/showmenu-pic1-4.png" /><span>虚拟CD</span><br />内容多样化的免版税图片库</p></a>
            </div>
        </div>
    	<div id="menubox2" onmouseover="meunshow('menubox2')" onmouseout="meunhidden('menubox2')" class="menu-box">
        	<a href="#">编辑图片</a>
        	<div class="menu-showbox" style="width:300px;">
            	<a href="#"><p><img src="images/showmenu-pic2-1.png" /><span>纪实</span><br />文化、大自然、科学，以及摄影大师的作品</p></a>
            	<a href="#"><p><img src="images/showmenu-pic2-2.png" /><span>艺术作品</span><br />多个世纪的大师级视像意念</p></a>
            	<a href="#"><p><img src="images/showmenu-pic2-3.png" /><span>档案</span><br />记录历史性时刻的图像</p></a>
            	<a href="#"><p><img src="images/showmenu-pic2-4.png" /><span>事实与体育</span><br />定期更新的时事及体育类图像</p></a>
            	<a href="#"><p><img src="images/showmenu-pic2-5.png" /><span>娱乐</span><br />关于艺人及娱乐盛事的详尽报导</p></a>
            	<a href="#"><p><img src="images/showmenu-pic2-6.png" /><span>Outline</span><br />为现在炙手可热的名人所拍摄的独家肖像图片</p></a>
            </div>
        </div>
    	<div class="menu-box"><a href="#">影像素材</a></div>
    	<div class="menu-box"><a href="#">娱乐新闻</a></div>
        
    </div>
    
    <div id="detail" class="detail">
    <c:if test="${!empty imageInfo}">
    	<img src="http://124.202.155.69:8001/PREVIEW/${previewPath}"/><br/>
    	<p><b>${imageInfo.title }</b></p>
    	<p>图片编号：${imageInfo.corbisId}</p>
    	<p>肖像使用授权：${modeRelease}</p>
    	<p>产权使用授权：${propertyRelease}</p>
    	<c:if test="${!empty photographer}">
    		<p>摄影师：<a href="${photographer.id}">${photographer.name}</a></p>
    	</c:if>
    	<p>出处：${imageInfo.creditLine}</p>
    	<p>授权类型：${licenseType}</p>
    	<c:if test="${!empty imageCategory}">
    		<p>类别：<a href="${imageCategory.id}">${imageCategory.name}</a></p>
    	</c:if>
    	<c:if test="${!empty collection}">
    		<p>图片库：<a href="${collection.id}">${collection.name}</a></p>
    	</c:if>
    	<p>最大尺寸：${maxSize}</p>
    	<p>----------------------------</p>
    	<c:if test="${!empty keys}">
    		<p><font color='white' size='3'><b>${keys}</b></font></p>
    	</c:if>
    	
    </c:if>
    </div>
 	
       
    <div class="index-bottom-menu"><div class="index-bottom-menu-middle">
    	<div>
        	<p>创意类</p>
            <p><a href="#">版权管理图片</a></p>
            <p><a href="#">免版税图片</a></p>
            <p><a href="#">插图</a></p>
            <p><a href="#">虚拟CD</a></p>
        </div>
    	<div>
        	<p>编辑类</p>
            <p><a href="#">纪实</a></p>
            <p><a href="#">艺术作品</a></p>
            <p><a href="#">档案</a></p>
            <p><a href="#">时事及体育</a></p>
            <p><a href="#">娱乐</a></p>
        </div>
    	<div>
        	<p>我的账户</p>
            <p><a href="#">档案资料</a></p>
            <p><a href="#">小样图下载记录</a></p>
            <p><a href="#">订单记录</a></p>
            <p><a href="#">灯箱</a></p>
        </div>
    	<div>
        	<p>我们的政策</p>
            <p><a href="#">网站使用协议</a></p>
            <p><a href="#">隐私保护政策</a></p>
            <p><a href="#">Cookie政策</a></p>
            <p><a href="#">授权条款及条件</a></p>
        </div>
    	<div>
        	<p>客户服务</p>
            <p><a href="#">与我们联系</a></p>
            <p><a href="#">搜索提示</a></p>
            <p><a href="#">网站使用帮助</a></p>
        </div>
    	<div>
        	<p>公司简介</p>
            <p><a href="#">关于我们</a></p>
            <p><a href="#">招聘信息</a></p>
        </div>
    </div></div>
    
    <div class="index-friend-bg">
    	<a href="#"><img src="images/friend1.png" /></a>
    	<a href="#"><img src="images/friend2.png" /></a>
    	<a href="#"><img src="images/friend3.png" /></a>
    	<a href="#"><img src="images/friend4.png" /></a>
    </div>
    
    <div class="index-bottom">
    	© 2013由Gaopin Images 高品图像提供。本网站所有影像均由Gaopin Images 高品图像授权发布。侵权必究。 沪ICP备13010110号-1
    </div>
</body>
</html>
