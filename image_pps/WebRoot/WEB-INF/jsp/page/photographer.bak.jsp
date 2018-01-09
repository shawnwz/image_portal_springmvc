<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>摄像师</title>
<%@include file="/header.jsp" %>
<link href="css/jquery-ui-1.9.1.custom.css" rel="stylesheet" type="text/css" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
	<script type="text/javascript" src="js/style.js"></script>
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="js/require.js"></script>
		<!--[if IE 6]>
			<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a.js"></script>
			<script type="text/javascript">
				DD_belatedPNG.fix('.png-img');
			</script>
		<![endif]-->
    <script type="text/javascript">
		var FT  = FT || {};
		FT.vars = FT.vars || {};
		FT.vars.BASE_URL    = '';
		FT.vars.FRONT_PATH  = FT.vars.BASE_URL + 'js/';
		FT.vars.JQUERY_PATH = FT.vars.FRONT_PATH + 'jquery-1.8.2.min.js';
		FT.vars.SHORT_ID    = '_collection_detail';
		FT.vars.CURR_UID    = "0";
		FT.vars.CURR_USER   = "";
		require([FT.vars.BASE_URL + 'js/front.js']);
	</script>

<body onresize="chickbodywidth()" onload="imgsize();chickbodywidth()">
	<div class="top">
    	<img src="images/logo.png" class="logo" />
        <div class="imformation">
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
    
    <div class="picture-searchbox">
    	<input type="text" class="input-text" value="建筑" />
        <a href="javascript:boxshow('h-search')" class="hsearch-text">高级搜索</a>
        <span><b>464,854</b><br />结果关于 <b>建筑</b> <a href="javascript:boxshow('searchimformationbox')">(澄清)</a></span>
        
			<jsp:include page="../inc/search_adv.jsp"> 
		    	<jsp:param name="page" value="search_adv"/>
		    </jsp:include>
    </div>
    <div class="picture-searchbox-imfor" id="searchimformationbox">
    	<span>澄清词义</span><br /><br />
        您搜索的字词有多种含义。点击词义(澄清)链接来澄清您的搜索。<br /><br />
        <a href="javascript:boxhidden('searchimformationbox')">不要再显示此信息</a>
        <img class="searchimforbottom" src="images/searchbox_bottom.gif" />
        <img class="searchimforclose" onclick="boxhidden('searchimformationbox')" src="images/close_button.png" />
    </div>
    
  
<div class="main clearfix padding-lr35">

    <div class="photo_div_top">
        <div class="photo_tt">
        <h1>图片库：Cardinal</h1>
        <h2 class="mtp5"><a href="http://beta.gaopinimages.com/search#p=1&c=598" class="c6699cc">查看所有 Cardinal 的图片</a></h2>
        </div>

        <div class="clearfix">
        	            <div class="photo_div left">
                <div id="container">			
                    <div class="navigation-container">
                        <div id="thumbs" class="navigation">
                            <a class="pageLink prev" href="#" title="Previous Page"></a>
                        
                            <ul class="thumbs noscript">
                            	                            	<li>
                                    <a class="thumb" name="leaf" href="images/linshi/a3d5b.jpg" title="Title #0">
                                        <img src="images/linshi/a3d5.jpg" alt="Title #0" />
                                    </a>
                                    <div class="caption">
                                        <a href="http://beta.gaopinimages.com/images/1716335" target="_blank" class="c6699cc">42-20326389</a> | Little Boy Filling a Pail at the Beach                                    </div>
                                </li>
                            	                            	<li>
                                    <a class="thumb" name="leaf" href="http://beta.gaopinimages.com/uploads/litpic/preview/1f/af/a4/b054.jpg" title="Title #0">
                                        <img src="http://beta.gaopinimages.com/uploads/litpic/litpic/1f/af/a4/b054.jpg" alt="Title #0" />
                                    </a>
                                    <div class="caption">
                                        <a href="http://beta.gaopinimages.com/images/4920951" target="_blank" class="c6699cc">42-36614122</a> | Reflections in high-rises, Chicago, Illinois, USA                                    </div>
                                </li>
                            	                            	<li>
                                    <a class="thumb" name="leaf" href="http://beta.gaopinimages.com/uploads/litpic/preview/d0/6a/cc/407b.jpg" title="Title #0">
                                        <img src="http://beta.gaopinimages.com/uploads/litpic/litpic/d0/6a/cc/407b.jpg" alt="Title #0" />
                                    </a>
                                    <div class="caption">
                                        <a href="http://beta.gaopinimages.com/images/4920953" target="_blank" class="c6699cc">42-36614128</a> | Reflections in high-rises, Chicago, Illinois, USA                                    </div>
                                </li>
                            	                            	<li>
                                    <a class="thumb" name="leaf" href="http://beta.gaopinimages.com/uploads/litpic/preview/88/3c/97/0e1c.jpg" title="Title #0">
                                        <img src="http://beta.gaopinimages.com/uploads/litpic/litpic/88/3c/97/0e1c.jpg" alt="Title #0" />
                                    </a>
                                    <div class="caption">
                                        <a href="http://beta.gaopinimages.com/images/5008580" target="_blank" class="c6699cc">42-37412992</a> | New tire on white background                                    </div>
                                </li>
                            	                            	<li>
                                    <a class="thumb" name="leaf" href="http://beta.gaopinimages.com/uploads/litpic/preview/bb/1a/2b/a8bb.jpg" title="Title #0">
                                        <img src="http://beta.gaopinimages.com/uploads/litpic/litpic/bb/1a/2b/a8bb.jpg" alt="Title #0" />
                                    </a>
                                    <div class="caption">
                                        <a href="http://beta.gaopinimages.com/images/5008661" target="_blank" class="c6699cc">42-37415588</a> | Pearl necklace                                    </div>
                                </li>
                            	                            </ul>
                            <a class="pageLink next" style="visibility: hidden;" href="#" title="Next Page"></a>
                        </div>
                    </div>
                    <div class="content_photo">
                        <div class="slideshow-container">
                            <div id="controls" class="controls"></div>
                            <div id="loading" class="loader"></div>
                            <div id="slideshow" class="slideshow"></div>
                        </div>
                        <div id="caption" class="caption-container">
                            <div class="photo-index"></div>
                        </div>
                    </div>
            </div>
            </div>
                        <div class="photo_txt left">
                <h1></h1>
                <p>RF Cardinal Standard+Corbis Super RF</p>
            </div>
            
        </div>
        
        
    </div>

    <div class="mtp10 browse-filmstrip">
    	<div class="header">
        	<h1>Cardinal的最近的图片</h1>
            <p class="mtp10">这是我们的 Cardinal 图库最近新增加的图片。每次添加了新图片，此页面就会自动更新。点击以下缩略图便可查看该图片的更多详情。</p>
        </div>
		<div class="filmstrip-navigation">
			<a class="filmstrip-next" id='scrollArrRight_02' href="javascript:;">
			</a>
			<a class="filmstrip-prev" id='scrollArrLeft_02' href="javascript:;" style="margin-left:5px;">
			</a>
			<a href="http://beta.gaopinimages.com/search#p=1&c=598">查看所有图片</a>		</div>

        <div class="right_tp clearfix mtp10" id="photo_slides">
            <div class="slides_container" style="width:auto;" id="scrollCont_02">
            	                <div class="slides" style="width:auto;">
                	                    <dl class="photo_dl left">
                	                      <dt><a href="http://beta.gaopinimages.com/images/1716335" target="_blank"><img src="images/linshi/a3d5.jpg"></a></dt><dd>免版税图片 (RF)</dd><dd><a href="http://beta.gaopinimages.com/photographer/Sean Justice" class="c6699cc">Sean Justice</a></dd><dd>Little Boy Filling a Pail at the Beach</dd></dl>
                                        <dl class="photo_dl left"><dt><a href="http://beta.gaopinimages.com/images/4920951" target="_blank"><img src="http://beta.gaopinimages.com/uploads/litpic/litpic/1f/af/a4/b054.jpg"></a></dt><dd>免版税图片 (RF)</dd><dd><a href="http://beta.gaopinimages.com/photographer/David Henderson" class="c6699cc">David Henderson</a></dd><dd>Reflections in high-rises, Chicago, Illinois, USA</dd></dl>
                                        <dl class="photo_dl left"><dt><a href="http://beta.gaopinimages.com/images/4920953" target="_blank"><img src="http://beta.gaopinimages.com/uploads/litpic/litpic/d0/6a/cc/407b.jpg"></a></dt><dd>免版税图片 (RF)</dd><dd><a href="http://beta.gaopinimages.com/photographer/David Henderson" class="c6699cc">David Henderson</a></dd><dd>Reflections in high-rises, Chicago, Illinois, USA</dd></dl>
                                        <dl class="photo_dl left"><dt><a href="http://beta.gaopinimages.com/images/5008580" target="_blank"><img src="http://beta.gaopinimages.com/uploads/litpic/litpic/88/3c/97/0e1c.jpg"></a></dt><dd>免版税图片 (RF)</dd><dd><a href="http://beta.gaopinimages.com/photographer/Andreas Hirsch" class="c6699cc">Andreas Hirsch</a></dd><dd>New tire on white background</dd></dl>
                                        <dl class="photo_dl left"><dt><a href="http://beta.gaopinimages.com/images/5008661" target="_blank"><img src="http://beta.gaopinimages.com/uploads/litpic/litpic/bb/1a/2b/a8bb.jpg"></a></dt><dd>免版税图片 (RF)</dd><dd><a href="http://beta.gaopinimages.com/photographer/Andreas Hirsch" class="c6699cc">Andreas Hirsch</a></dd><dd>Pearl necklace</dd></dl>
                                    </div>
                            </div>
            
        	<span class="ckz mrt14"><a href="http://beta.gaopinimages.com/search#p=1&c=598">查看所有图片</a></span>
        </div>
    
    </div>


</div>
<script type="text/javascript">
;(function () {
    requirejs([
        FT.vars.FRONT_PATH + 'jquery.galleriffic.js',
		FT.vars.FRONT_PATH + 'jquery.opacityrollover.js',
		FT.vars.FRONT_PATH + 'slides.min.jquery.js',
		FT.vars.FRONT_PATH + 'utils.js'
    ], function (galleriffic, opacityrollover, slides, Utils) {
		$(function(){
			$('#photo_slides').slides({
				preload: true,
				generatePagination: false,
				generateNextPrev: true
			});
		});
				$(document).ready(function() {
			// We only want these styles applied when javascript is enabled
			$('div.content_photo').css('display', 'block');

			// Initially set opacity on thumbs and add
			// additional styling for hover effect on thumbs
			var onMouseOutOpacity = 1.0;
			$('#thumbs ul.thumbs li, div.navigation a.pageLink').opacityrollover({
				mouseOutOpacity:   onMouseOutOpacity,
				mouseOverOpacity:  1.0,
				fadeSpeed:         'fast',
				exemptionSelector: '.selected'
			});
			
			// Initialize Advanced Galleriffic Gallery
			var gallery = $('#thumbs').galleriffic({
				delay:                     2500,
				numThumbs:                 10,
				preloadAhead:              10,
				enableTopPager:            false,
				enableBottomPager:         false,
				imageContainerSel:         '#slideshow',
				controlsContainerSel:      '#controls',
				captionContainerSel:       '#caption',
				loadingContainerSel:       '#loading',
				renderSSControls:          true,
				renderNavControls:         true,
				playLinkText:              'Play Slideshow',
				pauseLinkText:             'Pause Slideshow',
				prevLinkText:              '&lsaquo; Previous Photo',
				nextLinkText:              'Next Photo &rsaquo;',
				nextPageLinkText:          'Next &rsaquo;',
				prevPageLinkText:          '&lsaquo; Prev',
				enableHistory:             true,
				autoStart:                 true,
				syncTransitions:           true,
				defaultTransitionDuration: 900,
				onSlideChange:             function(prevIndex, nextIndex) {
					// 'this' refers to the gallery, which is an extension of $('#thumbs')
					this.find('ul.thumbs').children()
						.eq(prevIndex).fadeTo('fast', onMouseOutOpacity).end()
						.eq(nextIndex).fadeTo('fast', 1.0);

					// Update the photo index display
					this.$captionContainer.find('div.photo-index')
						.html((nextIndex+1) +' / '+ this.data.length);
				},
				onPageTransitionOut:       function(callback) {
					this.fadeTo('fast', 0.0, callback);
				},
				onPageTransitionIn:        function() {
					var prevPageLink = this.find('a.prev').css('visibility', 'hidden');
					var nextPageLink = this.find('a.next').css('visibility', 'hidden');
					
					// Show appropriate next / prev page links
					if (this.displayedPage > 0)
						prevPageLink.css('visibility', 'visible');

					var lastPage = this.getNumPages() - 1;
					if (this.displayedPage < lastPage)
						nextPageLink.css('visibility', 'visible');

					this.fadeTo('fast', 1.0);
				}
			});

			/**************** Event handlers for custom next / prev page links **********************/

			gallery.find('a.prev').click(function(e) {
				gallery.previousPage();
				e.preventDefault();
			});

			gallery.find('a.next').click(function(e) {
				gallery.nextPage();
				e.preventDefault();
			});

			/****************************************************************************************/

			/**** Functions to support integration of galleriffic with the jquery.history plugin ****/

			// PageLoad function
			// This function is called when:
			// 1. after calling $.historyInit();
			// 2. after calling $.historyLoad();
			// 3. after pushing "Go Back" button of a browser
			function pageload(hash) {
				// alert("pageload: " + hash);
				// hash doesn't contain the first # character.
				if(hash) {
					$.galleriffic.gotoImage(hash);
				} else {
					gallery.gotoIndex(0);
				}
			}

	

			/****************************************************************************************/
		});
		    });
})();

var scrollPic_02 = new ScrollPic();
scrollPic_02.scrollContId = "scrollCont_02"; //��������ID
scrollPic_02.arrLeftUpId = "scrollArrLeft_02"; //���ͷID
scrollPic_02.arrRightDownId = "scrollArrRight_02"; //�Ҽ�ͷID

scrollPic_02.arrVertical = true;

scrollPic_02.frameSet = 935; //��ʾ����
scrollPic_02.pageSet = 935; //��ҳ���

scrollPic_02.speed = 5; 
scrollPic_02.space = 100; 
scrollPic_02.autoPlay = false; //�Զ�����
scrollPic_02.autoPlayTime = 15; //�Զ����ż��ʱ��(��)

scrollPic_02.initialize(); //��ʼ��
</script>
    
       
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
    	© 2013由Gaopin Images 高品图像提供。本网站所有影像均由Gaopin Images 高品图像授权发布。侵权必究。 沪ICP备09095511号
    </div>
</body>
</html>
