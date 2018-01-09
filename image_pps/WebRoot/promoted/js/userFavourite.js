
var curLightBoxid = 0 ;
(function ( $ ) {
jQuery(document).ready(function() {
	
var myCurImageData = null;
var myCurDataImageArray = new Array();
var mylightboxpz = 8;
var mylightboxp = 1;
var ajaxUrl_removeImgFromAll ='my/deletelightboximg';
var ajaxUrl_removeImgFromFavourite = 'my/dellightboximages';
var ajaxUrl_removeLightBox = 'my/dellightbox';


//滚动条
var $scrollbar = $("#scrollbar");
var scrollbar = $scrollbar.data("plugin_tinyscrollbar");
if($scrollbar.length > 0)
{
	$scrollbar.tinyscrollbar();
}


	refreshlightbox();
	function refreshlightbox() {
		$(".favouriteGallery.layout3.globalDetail").empty();
		$(".selectBox-dropdown-menu.selectBox-options.selectBox-options-bottom").html("");
			$.post("my/getlightboxeslist", {t : Math.random()}, function(data) {
				if (data && data.error == 0 && data.data && data.data.length > 0) {
					
					var lightboxId = getQueryString("lightboxId");
					if(lightboxId != null)
					{
						curLightBoxid = lightboxId;
					}
					else
					{
						curLightBoxid = data.data[data.data.length-1].id;
					}

					//bind lightboxid to link for lbFormShareMember/lbFormShareEmail
					var sendEmailer = $(".icon-font.icon-54-shareEmail").attr("sendEmailer");
					
					$(".icon-font.icon-54-shareEmail").attr("href","lbFormShareEmail.na?width=750&height=660&lightboxid="+curLightBoxid+"&sendEmailer="+sendEmailer+"");
					$(".icon-font.icon-42-users").attr("href","lbFormShareMember.na?width=750&height=320&lightboxid="+curLightBoxid+"&sendEmailer="+sendEmailer+""); 
					
						
					$('.favouriteFolderList').empty();
					
					$.each(data.data, function(i, n) {
//						$(".mylightbox-left .select-widget div").append(
//								'<a href="javascript:void(0);" value="' + n.key
//										+ '"><p>' + n.value + '</p></a>');
						var nweFavFolder=$('<div class="favFolderBox" lightBoxId="'+n.id+'"><a href="my/lightbox?lightboxId='+n.id+'" class="folder"><div class="favFolderName">'+n.name+'</div><div class="favFolderAmount">共<span>'+n.imageNum+'</span>张图片</div></a><span class="btnClose icon-font icon-cross"></span></div>').prependTo($('.favouriteFolderList'));
						// 使当前新建的灯箱 支持拖拽
						nweFavFolder.makeThisDropable();
						
						if(n.id == curLightBoxid)
						{
							$("#lightBoxInfoName").val(n.name);
							$("#lightBoxInfoClient").val(n.customer);
							$("#lightBoxInfoNote").val(n.memo);
							$("#lightBoxInfoProject").val(n.projectName);
						}
						
						
						//phone
//						var phoneHtml = '<li  lightBoxId="'+n.id+'"><a href="my/lightbox?lightboxId='+n.id+'">'+n.name+'</a></li>';
//						$(".selectBox-dropdown-menu.selectBox-options.selectBox-options-bottom").append(phoneHtml);
						var phoneHtml = '<option value="'+n.id+'">'+n.name+'</option>';
						$("#phoneLightBox").append(phoneHtml);
					});
					
					SelectBox.prototype.getOptions("inline");
					
					$("div[lightboxid="+curLightBoxid+"]").addClass("active");
					//class="selectBox-selected"
					
					
					 refreshlightboxitems();
				} else if (data && data.error == 401) {
					myAlert("请先登录",function(){
					});
				} else {
					myAlert("请先登录",function(){
					});
				}
				
				//scrollbar.update();
				$("#scrollbar").data("plugin_tinyscrollbar").update();
			});
	}
	
	function refreshlightboxitems() {
		curLightBoxid = $('.favouriteFolderList').find(".active").attr("lightboxid");
		if(curLightBoxid&&typeof(curLightBoxid)!="undefined")
		$.post(
						"my/getlightboxitems",
						{
							key : curLightBoxid,
							t : Math.random()
						},
						function(data) {
							if (data && data.error == 0 ) {
								if(data.data.length == 0)
								{
									loadEmpty();
								}
								
								myCurImageData = data;
								mylightboxp = 1;
								mylightBoxSetShow();
								
								return;
								
							} else if (data && data.error == 401) {
								alert("请先登录");
							} else {
								alert("请先登录");
							}
						});
	}
	
	function mylightBoxSetShow(p) {
		
		$(".favouriteGallery.layout3.globalDetail").empty();
		myCurDataImageArray = new Array();
		var data = myCurImageData.data;
		var total = Math.ceil(data.length / mylightboxpz);
		var map = myCurImageData.map;
		// paging .
		mylightboxp = p ? p : mylightboxp;
		if (mylightboxp > Math.ceil(data.length / mylightboxpz))
			mylightboxp = Math.ceil(data.length / mylightboxpz);
		if (mylightboxp < 1)
			mylightboxp = 1;

		$("#picbox_center").empty();
		for (i = (mylightboxp - 1) * mylightboxpz; i < data.length
				&& i < (mylightboxp) * mylightboxpz; i++) {
			var n = data[i];
			var eles = map[n.corbisId];
			if (!eles)
				continue;
			myCurDataImageArray["image" + eles.id] = eles;
			var rf =typeof(eles)!="undefined"&& eles.licenseType && eles.licenseType == 2 ? "RM" : "RF";

			var memo = n.memo.replace(/\'+/g, "&prime;");
			memo = memo.replace(/\"+/g, "&Prime;");
			
			var html = '<div href="#" class="galleryThumb" style=" ">'
				+ '	<div class="imgWrap">'
				+ '		<a href="image/'+n.corbisId+'" target="_blank"><img src="'
				+ eles.imageHost
				+ 'THUMBNAIL/180/'
				+ eles.path
				+ ' "  width="305" height="251" class="ui-draggable ui-draggable-handle" imgId="'+n.corbisId+'"></a>'
				+ '		<div class="btnWrap">'
				+ '			<a href="javascript:void(0)" class="icon-font icon-22-download"></a>'
//				+ '			<a href="javascript:void(0)" class="icon-font icon-31-shoppingCart2"></a>'
				+ '			<a href="javascript:void(0)" class="icon-font icon-50-trash"></a>'
				+ '		</div>'
				+ '	</div>'
				+ '	<div class="thumbDetail">'
				+ '		'+rf+'<br>'
				+ '		'+n.corbisId+'<br><a href="javascript:void(0)">'+eles.scn+'</a>   /   <a href="javascript:void(0)">'+eles.collectionName+'</a><br>'
				+ '		'+eles.title+'<br>'
				+ '		'+ eles.location +'<br>'
				+ '		'+ eles.photoDate +'<br>'
				+ '		<div class="btnWrap"></div>'
				+ '	</div>'
				+ '</div>';
			$(".favouriteGallery.layout3.globalDetail").append(html);
			
			
		}
		
		$('body,html').animate({scrollTop:0},500); 
		
		//page
		
		var pageHtml = '<a href="javascript:void(0)" class="btnPrev icon-font icon-1-arrowLeft" ></a>'
			+'<input name="" type="text" class="targetNum" value="'+mylightboxp+'"/>'
			+'<a href="javascript:void(0)" class="btnNext" >'
			+'<span class="left">/ '+total+' </span>'
			+'<span class="right SiYuan-ExtraLight">下一页</span>'
			+'</a>';
		
		$(".pageNumWrap").html(pageHtml);
		
		//翻页事件
		$(".pageNumWrap .btnPrev").bind("click",  function(){
			mylightBoxSetShow(mylightboxp - 1);
		} );
			
		$(".pageNumWrap .btnNext").bind("click", function(){
			mylightBoxSetShow(mylightboxp + 1);
		} );
		
		var pageHtmlPhone = '<a href="javascript:void(0)" class="icon-font icon-1-arrowLeft"></a>'
			+'<input name="" type="text" value="'+mylightboxp+'">'
			+'<span class="total" style=" height: 34px; line-height: 34px; "> / '+total+'</span>'
			+'<a href="javascript:void(0)" class="icon-font icon-2-arrowRight"></a>';

		$(".pagination-sm").html(pageHtmlPhone);

		$(".pagination-sm .icon-1-arrowLeft").bind("click",  function(){
			mylightBoxSetShow(mylightboxp - 1);
		} );
			
		$(".pagination-sm .icon-2-arrowRight").bind("click", function(){
			mylightBoxSetShow(mylightboxp + 1);
		} );
		
		
		//点击图片上的 删除按钮 删除图片
		$('.galleryThumb .icon-50-trash').bind('click',function(){
			var imgId=$(this).closest('.galleryThumb').find('img').attr('imgId');
			var lightBoxId=$('.favFolderBox.active').attr('lightBoxId');
			
			// 调用通用函数， 传递参数 图片id和图片所在的灯箱id
			removeImgFromFavourite(imgId,lightBoxId);
		});
		
		//点击图片上的 下载按钮 下载图片
		$('.galleryThumb .icon-22-download').bind('click',function(){
			var imgId=$(this).closest('.galleryThumb').find('img').attr('imgId');
			var lightBoxId=$('.favFolderBox.active').attr('lightBoxId');
			
			location.href = "dl/getImg.do?type=0&corbisId="+imgId;
		});
		
		
		if($('.pageFavourite .galleryThumb').length > 0)
		{
			// 使图片支持 "拖"
			$('.pageFavourite .galleryThumb .imgWrap img').draggable({
				cursor: "move",
				revert: "invalid" ,
				appendTo: "body",
				helper: "clone",
				opacity:0.95,
				zIndex: 100,
				containment: ".userCenterWrap",
				cursorAt: { left: 40, top: 40 } 
			});
			
			//使灯箱支持“接收”
			$(".pageFavourite .overview .favFolderBox").not('.active').droppable({
				hoverClass: "hover",
				drop: function( event, ui ) {
					
					
					//灯箱收到图片后
					var imgRemovedId=ui.draggable.closest('.galleryThumb').find('img').attr('imgId');// 即将删除的图片
					var currentLightBoxId = $('.pageFavourite .overview .favFolderBox.active').attr('lightBoxId'); // 当前灯箱id
					var targetLightBoxId = $(this).attr('lightBoxId');// 接收到图片的灯箱id
					var $targetLightBox=$('.pageFavourite .favFolderBox[lightBoxId='+targetLightBoxId+']'); //接收到图片的目标灯箱
					//addToLightBox
					//removeFromLightBox
					
					
					//删除 图片
					$.post('my/copylightboximg', {imgId:imgRemovedId,newBoxId:targetLightBoxId,oldBoxId:currentLightBoxId}, function(data) {
						if(data.code == 1)
						{
							//从当前灯箱删除 图片
							removeImgFromFavourite(imgRemovedId,currentLightBoxId);
							// 目标灯箱 图片数量 +1
							var num = $targetLightBox.find('.favFolderAmount span').html();
							$targetLightBox.find('.favFolderAmount span').html( Number(num)+Number(1));
							
						}else
						{
							popUp(data.msg);
						}
					},"json")
				}
			});
		}
	}
		
	//空图片页面
	function loadEmpty()
	{
		
		var html ='<div class="favouriteEmpty">'
			+'<h2 class="Source-Han-Light"><span class="icon-40-success icon-font"></span>您的收藏夹还没有图片</h2>'
			+'热门搜索：'
			+'<a href="/search#q=大自然" class="searchLabel">大自然</a>'
			+'<a href="/search#q=蔬菜" class="searchLabel">蔬菜</a>'
			+'<a href="/search#q=水果" class="searchLabel">水果</a>'
			+'<a href="/search#q=非洲" class="searchLabel">非洲</a>'
//			+'<a href="javascript:void(0)" class="searchLabel">大自然</a>'
//			+'<a href="javascript:void(0)" class="searchLabel">蔬菜</a>'
		+'</div>';
		$(".favouriteGalleryWrap").html(html);
	}
		
	//下载当前全部图片
	$(".pull-left .icon-22-download").bind('click',function(){

		var lightBoxId=$('.favFolderBox.active').attr('lightBoxId');
		$.post("my/addlightboximagesdownload",{key:lightBoxId},
				function(data){
			if(data&&data.error==0)
			{
				location.href="/"+data.url;
			}
			else if(data&&data.error==401)
			{
				alert("请先登录");
			}
			else 
			{
				alert("错误");
			}
		});
		
	});
	
	//点击 删除按钮 删除所有图片
	$(".pull-left .icon-50-trash").bind('click',function(){
		var lightBoxId=$('.favFolderBox.active').attr('lightBoxId');
		//alert(lightBoxId);
		$.post(ajaxUrl_removeImgFromAll, {boxId:lightBoxId}, function(data) {
			if(data.code == 1)
			{
				$(".favouriteGalleryWrap").empty();
				refreshlightbox();
			}else
			{
				popUp(data.msg);
			}
			
		},"json")
	});
	
	//从灯箱页面页面删除图片通用方法
	function removeImgFromFavourite(_imgId,_lightBoxId)
	{
		//要删除的图片
		var $thumbToRemove=$('.pageFavourite .imgWrap img[imgId='+_imgId+']').parents('.galleryThumb');
		//要删除的图片所在的灯箱
		var $lightBox=$('.pageFavourite .favFolderBox[lightBoxId='+_lightBoxId+']');
		
		
		$.post(ajaxUrl_removeImgFromFavourite, {key:_imgId,lightBoxId:_lightBoxId}, function(data) {
			if(data.error == 0)
			{
				//判断要删除的图片所在的灯箱 是否是当前灯箱,  并且此页中存在这个图片 如果是，页面中删除
				if( $thumbToRemove.length>0)
				{	
					//$thumbToRemove.fadeOut(300,function(){$thumbToRemove.remove(); $container.masonry('destroy'); $container.masonry();});
					$thumbToRemove.remove();
					var num = $lightBox.find('.favFolderAmount span').html() -1;
					$lightBox.find('.favFolderAmount span').html(num);
				}
			}else
			{
				popUp(data.error);
			}
			
		},"json")
	}
	
	
	//删除灯箱
	$('.favouriteFolderList').on('click','.btnClose',function(){
		
		// 记录删除按钮按下时 灯箱id，
		var lightBoxId=$(this).closest('.favFolderBox').attr('lightBoxId');
		var $lightBoxToRemove=$('.favouriteFolderList .favFolderBox[lightBoxId='+lightBoxId+']');
		
			// 按下删除按钮时 立即把灯箱变红收起（防止用户点击两次 会不小心点击到下面灯箱的删除按钮）， 如果删除不成功 会在把灯箱恢复
			$lightBoxToRemove.css({'background':'#884949'}).slideUp(600);
			
		$.post(ajaxUrl_removeLightBox, {key : lightBoxId}, function(data) {
			
			if(data && data.error == 0)
			{
				//如果成功 灯箱消失 并且刷新滚动条 删除灯箱
				$lightBoxToRemove.fadeOut(500,function(){
					
					$lightBoxToRemove.remove();
					if($('#scrollbar').length > 0)
					{
						//scrollbar.update();	
						$("#scrollbar").data("plugin_tinyscrollbar").update();
					}
					//go to first page
					
					//如果删除的是当前灯箱 页面跳转到灯箱列表的 第一个灯箱页面
					if($lightBoxToRemove.hasClass('active') && $(this).parents('.navMobileSub').length <1)
					{	
						var topFolderLink=$('.pageFavourite .favFolderBox').eq(0).find('.folder').attr('href');
						location.href=topFolderLink;
						
						//此if逻辑未使用
						if($('.favFolderBox').length == 0)
						{
							//location.href='userFavouriteEmpty.html';
						}
					}
				});
			}else
			{
				// 删除不成功 灯箱再变回来
				popUp(data.errorMsg);
				$lightBoxToRemove.css({'background':''}).slideDown(300);
			}
			
		},"json")
	})
	
	
	

	
/*	<div class="favFolderBox active" lightBoxId="1">
		<a href="userFavourite.html" class="folder">
			<div class="favFolderName">秋天图片收集1</div>
			<div class="favFolderAmount">共<span>10</span>张图片</div>
		</a>
		<span class="btnClose icon-font icon-cross"></span>
	</div>*/
	
	//新建灯箱
	$('.btnCreateNewInFav').click(createNewFavouriteFolder2);	
	function createNewFavouriteFolder2()
	{
		$.post('my/addlightbox', {name :"新建收藏夹"}, function(data) {
			
			if(data.error == 0)
			{
				var nweFavFolder=$('<div class="favFolderBox" lightBoxId="'+data.data.id+'"><a href="'+data.lightBoxLink+'" class="folder"><div class="favFolderName">新建收藏夹'+data.data.id+'</div><div class="favFolderAmount">共<span>0</span>张图片</div></a><span class="btnClose icon-font icon-cross"></span></div>').prependTo($('.favouriteFolderList'));
				
				// 使当前新建的灯箱 支持拖拽
				nweFavFolder.makeThisDropable();
				scrollbar.update();
			}else
			{
				popUp(data.errorMsg);
			}
			
		},"json")
	}
	
	
	
	
	
	
 
		
		
	
	// 使新建的灯箱 支持拖拽
    jQuery.fn.makeThisDropable = function() {
        $(this).droppable({
			hoverClass: "hover",
			drop: function( event, ui ) {
				var imgRemovedId=ui.draggable.closest('.galleryThumb').find('img').attr('imgId');
				var currentLightBoxId = $('.pageFavourite .overview .favFolderBox.active').attr('lightBoxId');
				var targetLightBoxId = $(this).attr('lightBoxId');
				var $targetLightBox=$('.pageFavourite .favFolderBox[lightBoxId='+targetLightBoxId+']'); //接收到图片的目标灯箱
				//addToLightBox
				//removeFromLightBox
				
				$.post('post/addToLightBox.php', {imgId:targetLightBoxId}, function(data) {
					if(data.status == 1)
					{
						removeImgFromFavourite(imgRemovedId,currentLightBoxId);
						$targetLightBox.find('.favFolderAmount span').html(data.lightBoxLength);
					}else
					{
						popUp(data.errorMsg);
					}
				},"json")
			}
		});
    }
	
	
	
	/*
		灯箱信息 即时编辑
	
	*/
	
	// 保存各输入框 的当前信息
	$('.editLive').each(function(){
		$(this).attr('valueOld',$(this).val());
	})
	
	/*
		编辑完姓名之后，
			1.判断灯箱名字 是否为空 如果为空变回旧的名字
			2.用灯箱的新名字和保存的旧名字对比 如果有变化 向后台发送请求 保存当前灯箱名
	*/ 
	$('#lightBoxInfoName').focusout(function() {
		
		if($.trim($(this).val())=="")
		{
			popUp('灯箱名字不能为空');
			$('#lightBoxInfoName').val($(this).attr('valueOld'));
		}else($(this).attr('valueOld')!=$(this).val())
		{
			var lightBoxId=$('.favFolderBox.active').attr('lightBoxId');
			var $lightBox=$('.pageFavourite .favFolderBox[lightBoxId='+lightBoxId+']');
			var lightBoxName=$(this).val();
			$.post('my/updateboxname', {boxname:lightBoxName,boxid:lightBoxId}, function(data) {
		
				if(data.code==1)
				{
					$('#lightBoxInfoName').attr('valueOld',lightBoxName);
					$lightBox.find('.favFolderName').html(lightBoxName);
				}
				else
				{
					popUp("修改失败");
				}
			},"json")
		}
	});
	
	$('#lightBoxInfoClient').focusout(function() {
		curLightBoxid = $('.favouriteFolderList').find(".active").attr("lightboxid");
		if($(this).attr('valueOld')!=$(this).val())
		{
			$.post('my/saveboxinfo', {customer:$(this).val(),boxid:curLightBoxid}, function(data) {
				if(data.code == 1)
				{
					$('#lightBoxInfoClient').attr('valueOld',$('#lightBoxInfoClient').val());
				}else
				{
					popUp("修改失败");
				}
			},"json")
		}
	});
	$('#lightBoxInfoProject').focusout(function() {
		curLightBoxid = $('.favouriteFolderList').find(".active").attr("lightboxid");
		if($(this).attr('valueOld')!=$(this).val())
		{
			$.post('my/saveboxinfo', {projectname:$(this).val(),boxid:curLightBoxid}, function(data) {
				if(data.code == 1)
				{
					$('#lightBoxInfoProject').attr('valueOld',$('#lightBoxInfoProject').val());
				}else
				{
					popUp(data.errorMsg);
				}
			},"json")
		}
	});
	$('#lightBoxInfoNote').focusout(function() {
		curLightBoxid = $('.favouriteFolderList').find(".active").attr("lightboxid");
		if($(this).attr('valueOld')!=$(this).val())
		{
			$.post('my/saveboxinfo', {memo:$(this).val(),boxid:curLightBoxid}, function(data) {
				if(data.code == 1)
				{
					$('#lightBoxInfoNote').attr('valueOld',$('#lightBoxInfoNote').val());
				}else
				{
					popUp(data.errorMsg);
				}
			},"json")
		}
	});
 
	
	
	
	
	
	
/*	
	function refreshBeforeMasonry()
	{
		$('.galleryThumb .imgWrap').each(function(){
			
			var imgW=$(this).find('img').attr('width');
			var imgH=$(this).find('img').attr('height');
			//console.log($('.galleryThumb').width()+'=='+imgW)
			$(this).height(imgH*$('.galleryThumb').width()/imgW);
			//$(this).width($('.galleryThumb').width());
		})	
	}
	
	*/
	

		

	
	

	
	
	$( "#from" ).datepicker({
		changeMonth: true,
		changeYear: true,
		numberOfMonths: 2,
		changeYear: true,
		minDate: '2013/10/13',
		maxDate: "+0M +0D",
		onClose: function( selectedDate ) {
			$( "#to" ).datepicker( "option", "minDate", selectedDate );
		}
	});
	
	$( "#to" ).datepicker({
		changeMonth: true,
		changeYear: true,
		numberOfMonths: 2,
		minDate: '2013/10/13',
		maxDate: "+0M +0D",
		onClose: function( selectedDate ) {
			//$( "#from" ).datepicker( "option", "maxDate", selectedDate );
		}
	});
	
	
	
	$( ".date" ).datepicker({
		changeMonth: true,
		changeYear: true,
		changeYear: true,
		maxDate: "+0M +0D",
	});
	
		
	var $container= $('.favouriteGallery');
	if( $('.favouriteGallery').length > 0)
	{
		$container.imagesLoaded( function() {
		 	$container.masonry({
				itemSelector : '.favouriteGallery  .galleryThumb'
			});
		});
	}

	
});

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
    }

}( jQuery ));
