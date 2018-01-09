(function ( $ ) {
jQuery(document).ready(function() {

	
	
	var ajaxUrl_removeImgFromFavourite = 'post/removeImgFromFavourite.php';
	var ajaxUrl_removeLightBox = 'post/removeLightBox.php';

	
	//滚动条
	var $scrollbar = $("#scrollbar");
	var scrollbar = $scrollbar.data("plugin_tinyscrollbar");
	if($scrollbar.length > 0)
	{
		$scrollbar.tinyscrollbar();
	}
	
	
	//从灯箱页面页面删除图片通用方法
	function removeImgFromFavourite(_imgId,_lightBoxId)
	{
		//要删除的图片
		var $thumbToRemove=$('.pageFavourite .imgWrap img[imgId='+_imgId+']').parents('.galleryThumb');
		//要删除的图片所在的灯箱
		var $lightBox=$('.pageFavourite .favFolderBox[lightBoxId='+_lightBoxId+']');
		
		
		$.post(ajaxUrl_removeImgFromFavourite, {}, function(data) {
			if(data.status == 1)
			{
				//判断要删除的图片所在的灯箱 是否是当前灯箱,  并且此页中存在这个图片 如果是，页面中删除
				if($('.favFolderBox.active').attr('lightBoxId')==data.lightBoxId && $thumbToRemove.length>0)
				{	
					$thumbToRemove.fadeOut(300,function(){$thumbToRemove.remove(); $container.masonry('destroy'); $container.masonry();});
					$lightBox.find('.favFolderAmount span').html(data.lightBoxLength);
				}
			}else
			{
				popUp(data.errorMsg);
			}
			
		},"json")
	}
	
	//点击图片上的 删除按钮 删除图片
	$('.galleryThumb .icon-50-trash').on('click',function(){
		var imgId=$(this).closest('.galleryThumb').find('img').attr('imgId');
		var lightBoxId=$('.favFolderBox.active').attr('lightBoxId');
		
		// 调用通用函数， 传递参数 图片id和图片所在的灯箱id
		removeImgFromFavourite(imgId,lightBoxId);
	});
	
	//删除灯箱
	$('.favouriteFolderList').on('click','.btnClose',function(){
		
		// 记录删除按钮按下时 灯箱id，
		var lightBoxId=$(this).closest('.favFolderBox').attr('lightBoxId');
		var $lightBoxToRemove=$('.favouriteFolderList .favFolderBox[lightBoxId='+lightBoxId+']');
		
			// 按下删除按钮时 立即把灯箱变红收起（防止用户点击两次 会不小心点击到下面灯箱的删除按钮）， 如果删除不成功 会在把灯箱恢复
			$lightBoxToRemove.css({'background':'#884949'}).slideUp(600);
			
		$.post(ajaxUrl_removeLightBox, {}, function(data) {
			
			if(data.status == 1)
			{
				//如果成功 灯箱消失 并且刷新滚动条 删除灯箱
				$lightBoxToRemove.fadeOut(500,function(){
					
					$lightBoxToRemove.remove();
					if($('#scrollbar').length > 0)
					{
						scrollbar.update();	
					}
					//go to first page
					
					//如果删除的是当前灯箱 页面跳转到灯箱列表的 第一个灯箱页面
					if($lightBoxToRemove.hasClass('active') && $(this).parents('.navMobileSub').length <1)
					{	
						var topFolderLink=$('.pageFavourite .favFolderBox').eq(0).find('.folder').attr('href');
						location.href=topFolderLink;
						
						if($('.favFolderBox').length == 0)
						{
							location.href='userFavouriteEmpty.html';
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
		$.post('post/createNewFavouriteFolder.php', {}, function(data) {
			
			if(data.status == 1)
			{
				var nweFavFolder=$('<div class="favFolderBox" lightBoxId="'+data.lightBoxId+'"><a href="'+data.lightBoxLink+'" class="folder"><div class="favFolderName">新建收藏夹'+data.lightBoxId+'</div><div class="favFolderAmount">共<span>0</span>张图片</div></a><span class="btnClose icon-font icon-cross"></span></div>').prependTo($('.favouriteFolderList'));
				
				// 使当前新建的灯箱 支持拖拽
				nweFavFolder.makeThisDropable();
				scrollbar.update();
			}else
			{
				popUp(data.errorMsg);
			}
			
		},"json")
	}
	
	
	
	
	
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
				$.post('post/addToLightBox.php', {imgId:targetLightBoxId}, function(data) {
					if(data.status == 1)
					{
						//从当前灯箱删除 图片
						removeImgFromFavourite(imgRemovedId,currentLightBoxId);
						// 目标灯箱 图片数量 +1
						$targetLightBox.find('.favFolderAmount span').html(data.lightBoxLength);
						
					}else
					{
						popUp(data.errorMsg);
					}
				},"json")
			}
		});
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
			$.post('post/saveInfo.php', {}, function(data) {
		
				if(data.status == 1)
				{
					$('#lightBoxInfoName').attr('valueOld',lightBoxName);
					$lightBox.find('.favFolderName').html(lightBoxName);
				}else
				{
					popUp(data.errorMsg);
				}
			},"json")
		}
	});
	
	$('#lightBoxInfoClient').focusout(function() {
		if($(this).attr('valueOld')!=$(this).val())
		{
			$.post('post/saveInfo.php', {}, function(data) {
				if(data.status == 1)
				{
					$('#lightBoxInfoClient').attr('valueOld',$('#lightBoxInfoClient').val());
				}else
				{
					popUp(data.errorMsg);
				}
			},"json")
		}
	});
	$('#lightBoxInfoProject').focusout(function() {
		if($(this).attr('valueOld')!=$(this).val())
		{
			$.post('post/saveInfo.php', {}, function(data) {
	
				if(data.status == 1)
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
		if($(this).attr('valueOld')!=$(this).val())
		{
			$.post('post/saveInfo.php', {}, function(data) {
	
				if(data.status == 1)
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
		maxDate: "+0M +0D"
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
}( jQuery ));
