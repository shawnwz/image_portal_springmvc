<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../inc/pageheader.jsp" %>
<script type="text/javascript" src="js/require.js"></script>
<script type="text/javascript" src="js/photographer.js"></script>
<script type="text/javascript" src="js/search_left.js"></script>
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
<!-- 内容区开始 -->
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/photographer.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<div class="main clearfix padding-lr35">
    <div class="photo_div_top" style="border-bottom: none;">
        <div class="photo_tt">
        <h1>摄影师：${name}</h1>
        <h2 class="mtp5"><a href="/search#p=1&q=${name}" class="c6699cc">查看所有 ${name}的图片</a></h2>
        </div>
        <div class="clearfix">
        	            <div class="photo_div left">
                <div id="container">			
                    <div class="navigation-container">
                        <div id="thumbs" class="navigation">
                            <a class="pageLink prev" href="#" title="Previous Page"></a>
                        
                            <ul class="thumbs noscript">
                            <c:forEach items="${covers}" var="item" varStatus="stat">
								<li>
                                    <a class="thumb" name="leaf" href="${item.imageHost}HOVER/${item.path}" title="${item.title} # {item.id}">
                                        <img src="${item.imageHost}HOVER/${item.path}" alt="${item.title}" />
                                    </a>
                                    <div class="caption">
                                        <a href="images${item.corbisId}" target="_blank" class="c6699cc">${item.corbisId}</a> | ${item.title}</div>
                                </li>
    						</c:forEach>
                             </ul>
                            <a class="pageLink next" style="visibility: hidden;" href="#" title="Next Page"></a>
                        </div>
                    </div>
                    <div class="content_photo">
                        <div class="slideshow-container">
                            <div id="controls" class="controls" style="bottom: 22px;"></div>
                            <div id="loading" class="loader"></div>
                            <div id="slideshow" class="slideshow"></div>
                        </div>
                        <div id="caption" class="caption-container">
                            <div class="photo-index" style="right:80px;"></div>
                        </div>
                    </div>
            </div>
            </div>
                        <div class="photo_txt left">
                <h1></h1>
                <p>${curitem.intro}</p>
            </div>
            
        </div>
        
        
    </div>

    <div class="mtp10 browse-filmstrip">
    	<div class="header">
        	<h1>${name}的最近的图片</h1>
            <p class="mtp10">这是我们的${name}最近新增加的图片。每次添加了新图片，此页面就会自动更新。点击以下缩略图便可查看该图片的更多详情。</p>
        </div>
		<div class="filmstrip-navigation">
			<a class="filmstrip-next" id='scrollArrRight_02' href="javascript:;">
			</a>
			<a class="filmstrip-prev" id='scrollArrLeft_02' href="javascript:;" style="margin-left:5px;">
			</a>
			<a href="/search#p=1&q=${name}">查看所有图片</a>		</div>

        <div class="right_tp clearfix mtp10" id="photo_slides">
            <div class="slides_container" style="width:auto;" id="scrollCont_02">
            	                <div class="slides" style="width:auto;">
							<c:forEach items="${map}" var="item" varStatus="stat">
								 <dl class="photo_dl left"><dt><a href="/image/${item.corbisId}" target="_blank">
								 <img src="${item.imageHost}THUMBNAIL/${item.path}"></a></dt><dd>版权管理&nbsp;(${item.licenseType!=null&&item.licenseType==2?"RM":"RF"})</dd>
								 <dd><a href="/photographer/${name}" class="c6699cc">${name}</a></dd><dd>${item.title}</dd></dl>

    						</c:forEach>
                	                   
                                    </div>
                            </div>
            
        	<span class="ckz mrt14"><a href="/search#p=1&q=${name}">查看所有图片</a></span>
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
scrollPic_02.scrollContId = "scrollCont_02"; 
scrollPic_02.arrLeftUpId = "scrollArrLeft_02"; 
scrollPic_02.arrRightDownId = "scrollArrRight_02"; 

scrollPic_02.arrVertical = true;

scrollPic_02.frameSet = 935; 
scrollPic_02.pageSet = 935; 

scrollPic_02.speed = 5; 
scrollPic_02.space = 100; 
scrollPic_02.autoPlay = false; 
scrollPic_02.autoPlayTime = 15; 

scrollPic_02.initialize(); 
</script>
  
<!-- 内容区结束-->
<jsp:include page="../inc/pagebuttom.jsp" />
  