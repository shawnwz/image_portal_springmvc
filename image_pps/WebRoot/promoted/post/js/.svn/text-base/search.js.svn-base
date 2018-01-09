// JavaScript Document
(function ( $ ) {
jQuery(document).ready(function() {
	var ajaxUrl_switchLightBox = 'post/switchLightBox.php';
	var ajaxUrl_createNewFavouriteFolder = 'post/createNewFavouriteFolder.php';
	var ajaxUrl_addToLightBox = 'post/addToLightBox.php';
	var ajaxUrl_removeFromLightBox = 'post/removeFromLightBox.php';
	var ajaxUrl_toolTip = 'post/toolTip.php';


// -------------- jcarousel lightBox
	
	// -- 灯箱初始化
	$('.jcarousel').jcarousel();
	
	// -- 灯箱 点击左边按钮
	$('.jcarousel-control-prev')
		.on('jcarouselcontrol:active', function() {
			$(this).removeClass('inactive');
		})
		.on('jcarouselcontrol:inactive', function() {
			$(this).addClass('inactive');
		})
		.jcarouselControl({
			target: '-='
		});
	// -- 灯箱 点击右边按钮
	$('.jcarousel-control-next')
		.on('jcarouselcontrol:active', function() {
			$(this).removeClass('inactive');
		})
		.on('jcarouselcontrol:inactive', function() {
			$(this).addClass('inactive');
		})
		.jcarouselControl({
			target: '+='
		});
	// -- 灯箱 页码
	$('.jcarousel-pagination')
		.on('jcarouselpagination:active', 'a', function() {
			$(this).addClass('active');
		})
		.on('jcarouselpagination:inactive', 'a', function() {
			$(this).removeClass('active');
		})
		.jcarouselPagination({
			// Options go here
		});
	

	
	resetLightBoxed();
	function resetLightBoxed(){
		$('.galleryWrap .galleryThumb').removeClass('lightBoxed'); 

		var _imgId;
		$('.jcarousel ul li img').each(function(){
			_imgId=$(this).attr('imgId');
			$('.galleryWrap .galleryThumb .imgWrap img[imgId='+_imgId+']').parents('.galleryThumb').addClass('lightBoxed'); // 搜索结果的小图显示灰色背景 标志已收藏
			$('.picDetailWrap img[imgId='+_imgId+']').closest('.picDetailWrap').addClass('lightBoxed');
		});
	}
	

	// -- 切换灯箱
	/*
		data.status
			0: 正确
			1：错误
		data.errorMsg
		url:
		
	*/
	function switchLightBox (){
		$('.jcarousel').addClass('loading');// 显示loading 图片
		$('.jcarousel ul').html("");
		// 发送ajax 请求
		
		$.post(ajaxUrl_switchLightBox, {}, function(data) {
			
			if(data.status == 1)
			{
				var htmlData = '';
				
				$.each(data.imgListData, function() {
					//<li><a href="#"><img src="images/search/thumb305_1.jpg" width="80" imgId="1099"/></a><span class="icon-font icon-8-delete"></span></li> // html 格式
					htmlData += '<li><a href="#"><img src="images/search/thumb305_1.jpg" width="80" imgId="' + this.imgId + '"></a><span class="icon-font icon-8-delete"></span></li>';
				})

				$('.jcarousel ul').html(htmlData); // 更新灯箱数据
				$('.jcarousel').jcarousel('reload'); // 刷新灯箱
				$('.jcarousel').removeClass('loading'); // 隐藏 加载图片
				
				resetLightBoxed();
			}else
			{
				popUp(data.errorMsg);
			}
		},"json")
	}
	//$('.lightBoxList li').click(switchLightBox);
	$('.lightBoxList').on('click','li',switchLightBox)
	
	
	// -- 创造新的收藏板
	/*
		data.status
			0: 正确
			1：错误
		data.errorMsg
	*/
	
	
	//lightBoxId
	function createNewFavouriteFolder(){
		if($('.listName').val()!="")
		{	//姓名不为空 调用后台方法
			
			$.post(ajaxUrl_createNewFavouriteFolder, {}, function( data ) {
				if(data.status == 1)
				{
					// 灯箱名不为空 清除错误提示
					$('.listName').attr('placeholder','创造新的收藏板');
					$('.listName').removeClass('error');
					
					// 显示最新的收藏版的名字在顶部
					$('.selectList ul li').removeClass('active');
					$('.selectList ul').prepend('<li class="active" lightBoxId="'+data.lightBoxId+'">'+$('.listName').val()+'<span class="num">0</span><span>图片</span></li>');	
					$('.lightBoxList .selectValue').html($('.selectList li.active').html());
					
					
					$('.jcarousel ul').html(''); // 新添加收藏版 内容为空
					$('.jcarousel').jcarousel('reload'); // 刷新灯箱
					//$('.jcarousel').removeClass('loading');
					
					$('.listName').val(''); // 清空添加收藏版的 input 数据
					resetLightBoxed();
				}else
				{
					popUp(data.errorMsg);
				}
			},"json")
		}else
		{
			// 灯箱名有错误时 提示错误
			$('.listName').attr('placeholder','请填写收藏板名称'); 
			$('.listName').addClass('error');
		}
	}
	$('.btnAdd').click(createNewFavouriteFolder);
	
		
	// -- 关闭灯箱
	$('.closeJcarousel').click(function(){
		if($('.lightBoxWrap').is(':visible'))
		{	
			$('#navRight ul li a.icon-11-favourite').removeClass('active');	
			$('.lightBoxWrapOut').stop('true','true').slideUp();
			$('.lightBoxWrap').stop('true','true').slideUp();
			$('body').removeClass('showLightBox');
		}
	})
	
	// -- 导航收藏图标打开/关闭灯箱
	$('#navRight ul li a.icon-11-favourite').click(function(){
		if($('.lightBoxWrapOut').is(':visible'))
		{
			$(this).removeClass('active');	
			$('.lightBoxWrapOut').stop('true','true').slideUp();
			$('body').removeClass('showLightBox');

		}else
		{
			$(this).addClass('active');	
			$('.lightBoxWrapOut').stop('true','true').slideDown(300,function(){$('.lightBoxWrapOut').css('overflow','');});
			$('.lightBoxWrap').stop('true','true').slideDown(300,function(){$('.lightBoxWrap').css('overflow','');});
			
			$('.jcarousel').jcarousel('reload');	
			$('body').addClass('showLightBox');
		}
	})
	
	// -- 通过图片id添加图片到灯箱
	var globalFirstAddFav=true; // 是否第一次添加
	function addToLightBox(_imgId){

		$.post(ajaxUrl_addToLightBox, {'imgId':_imgId}, function( data ) {
			if(data.status == 1)
			{
				if(globalFirstAddFav == true) // 如果第一次添加 默认打开灯箱
				{
					$('#navRight ul li a.icon-11-favourite').addClass('active');	
					$('.lightBoxWrapOut').stop('true','true').slideDown(300,function(){$('.lightBoxWrapOut').css('overflow','');});
					$('.lightBoxWrap').stop('true','true').slideDown(300,function(){$('.lightBoxWrap').css('overflow','');});
					$('body').addClass('showLightBox');
		
					globalFirstAddFav=false;
				}
				// 添加 此id 的图片数据 到灯箱尾端
				$('.jcarousel ul').append('<li><a href="#"><img src="images/search/thumb305_4.jpg" width="80" imgId="'+data.imgId+'"/></a><span class="icon-font icon-8-delete"></span></li>');
				$('.jcarousel').jcarousel('reload');// 刷新灯箱
				$('.jcarousel').jcarousel('scroll', $('.jcarousel li:last')); // 灯箱滚动到尾端
				
				$('.galleryWrap .galleryThumb .imgWrap img[imgId='+_imgId+']').parents('.galleryThumb').addClass('lightBoxed'); // 搜索结果的小图显示灰色背景 标志已收藏
				$('.picDetailWrap').addClass('lightBoxed');
				
				// 当前灯箱的 收藏数+1
				var currentNum=$('.jcarousel ul li').length;
				$('.selectValue span.num').html(currentNum);
				$('.selectWrap ul li.active span.num').html(currentNum);
				
			}else
			{
				popUp(data.errorMsg);	
			}
		},'json')

	}
	
	// -- 通过图片id 从灯箱删除图片
	function removeFromLightBox(_imgId){
		$.post(ajaxUrl_removeFromLightBox, {'imgId':_imgId}, function( data ) {
			if(data.status == 1){	
				// 删除此id 的图片数据
				$('.jcarousel ul li img[imgId='+_imgId+']').parents('li').remove();	
				$('.jcarousel').jcarousel('reload'); // 刷新灯箱
				$('.galleryWrap .galleryThumb.lightBoxed .imgWrap img[imgId='+_imgId+']').parents('.galleryThumb.lightBoxed').removeClass('lightBoxed');// 搜索结果的小图移除灰色背景
				$('.picDetailWrap').removeClass('lightBoxed');
				
				// 当前灯箱的 收藏数-1
				var currentNum=$('.jcarousel ul li').length;
				$('.selectValue span.num').html(currentNum);
				$('.selectWrap ul li.active span.num').html(currentNum);
			}else
			{
				popUp(data.errorMsg);	
			}
		},'json')
	}
	
	// -- 点击灯箱图片右上角的删除按钮 删除图片
	$('.jcarousel').on('click','.icon-8-delete',function(){
		$(this).parents('li').remove();
		$('.jcarousel').jcarousel('reload');
		removeFromLightBox($(this).parents('li').find('img').attr('imgId'));
	})
	
	
	// 点击搜索结果的图片的收藏按钮 收藏/取消收藏
	$('body').on('click', '.galleryWrap .galleryThumb .icon-11-favourite', function(event) {

		event.preventDefault();
		// 取得图片id
		var imgId=$(this).closest('.galleryThumb').find('img').attr('imgId');
		
		// 如果收藏了
		if($(this).closest('.galleryThumb').hasClass('lightBoxed'))
		{
			removeFromLightBox(imgId); // 取消收藏
		}else
		{
			addToLightBox(imgId);
		}
	})
	
	
	// 通过点击预览框.详细页面里的收藏按钮  收藏/取消收藏
	$('body').on('click', '.picDetailWrap .icon-11-favourite', function(event) {
		event.preventDefault();
		var imgId=$(this).closest('.picDetailWrap').find('img').attr('imgId');
		if($(this).closest('.picDetailWrap').hasClass('lightBoxed'))
		{
			removeFromLightBox(imgId);
		}else
		{
			addToLightBox(imgId);
		}
	})
// -------------- end jcarousel lightBox




// -------------- left filter panel 


	var selectCategory = new SelectBox($('#selectCategory'));
	var selectRace = new SelectBox($('#selectRace'));
	var selectAmount = new SelectBox($('#selectAmount'));
	// -- 刷新页面清除选择
	if($('.pageSearch').length > 0)
	{
		clearAllFilter();
	}

	
	// -- 清除选择
	function clearAllFilter()
	{
		
		// checkbox radiobox 重置
		$('.filterPanel input[type=checkbox], .filterPanel input[type=radio]').iCheck('uncheck');
		$('.filterPanel input[type=checkbox], .filterPanel input[type=radio]').iCheck('enable');
		$('.colorCurrent').removeClass($('.colorCurrent').attr('color'));
		
		
		// 选择图片布局 重置
		$('.selectOne a').removeClass('active');
		
		// 下拉菜单重置 
		$('.filterPanel select').val(0);
		selectRace.enable();
		if(selectAmount.data)
		{
			//selectCategory.refresh();
			selectRace.refresh();
			selectAmount.refresh(); 
		}

		
		$('#exclude').val('');
		$('.resultPanelInner .searchKeyWord .label').hide();
	}
	
	// -- 点击按钮清除选择
	$('.btnClearAll').click(function(){
		clearAllFilter();
	});
	// -- 打开颜色板
	$('.colorPicker .colorAdd').click(function(){
		if($(this).hasClass('icon-23-plus'))
		{
			$(this).removeClass('icon-23-plus');
			$(this).addClass('icon-cross');
			$('.colorList').addClass('open');
		}else
		{
			$(this).removeClass('icon-cross');
			$(this).addClass('icon-23-plus');
			$('.colorList').removeClass('open');
		}
	})
	
	// -- 选择颜色
	var currentColor;
	$('.colorList .colorBox').click(function(){
		$('.colorList .colorBox').removeClass('active');
		$(this).addClass('active');
		currentColor = $(this).attr('color');
		
		$('.colorCurrent').removeClass('color-'+$('.colorCurrent').attr('color'));
		
		
		$('.colorCurrent').addClass('color-'+currentColor);
		$('.colorCurrent').attr('color',currentColor);
		
		
		$('.colorPicker .colorAdd').removeClass('icon-cross');
		$('.colorPicker .colorAdd').addClass('icon-23-plus');
		$('.colorList').removeClass('open');
		
		
		$('#label-selectCcolor').show();
		$('#label-selectCcolor .color').addClass('color-'+currentColor);
	})
	
	// -- 删除颜色
	$('.colorCurrent').click(function(){
		$('.colorCurrent').removeClass('color-'+$('.colorCurrent').attr('color'));
		$('.colorList .colorBox').removeClass('active');
		$('#label-selectCcolor .color').removeClass('color-'+$('.colorCurrent').attr('color'));
		$('#label-selectCcolor').hide();
	})
	

	// 显示搜索选项 在搜索结果页最顶部
	$('.filterPanel select').selectBox().change(function(){

		if($(this)[0].selectedIndex == 0)
		{
			$('#label-'+$(this).attr('id')).hide();
		}else
		{
			$('#label-'+$(this).attr('id')).show();
			$('#label-'+$(this).attr('id')).find('.txt').html($(this).val());
		}
		
		// 当选择人数为0时 disable 人类选择板
		if($(this).attr('id') == 'selectAmount')
		{
			if($(this)[0].selectedIndex == 1)
			{
				//add Disable
				$('.offHuman input').iCheck('uncheck');
				$('.offHuman input').iCheck('disable');
				
				// 删除label
				$('#label-selectRace').find('.txt').html('');
				$('#label-selectRace').hide();
				
				$('#selectRace')[0].selectedIndex = 0;
				selectRace.refresh();
				selectRace.disable();
				
			}else
			{
				$('.offHuman input').iCheck('enable');
				selectRace.enable();
				selectRace.refresh();
			}
		}
	})
	
	
	
	
	
	// 选择 图片布局 并把选择结果显示在顶部
	$('.selectOne a').click(function(){
		
		if($(this).parent().hasClass('disable'))
		{
			return;
		}
		
		$('#label-'+$(this).parent().attr('id')).show();
		if($(this).parent().attr('id') == 'layoutWrap')
		{
			$('#label-'+$(this).parent().attr('id')).find('.txt').removeClass('icon-24-position1 icon-25-position2 icon-26-position3 icon-27-position4 icon-28-position5');
			$('#label-'+$(this).parent().attr('id')).find('.txt').addClass($(this).attr('class'));
		
		}else
		{
			$('#label-'+$(this).parent().attr('id')).find('.txt').html($(this).html());
		}
		$(this).parent().find('a').removeClass('active');
		$(this).addClass('active');
	})
	
	
	$('.selectOne a').toggle(
	
		function(){
			if($(this).parent().hasClass('disable'))
			{
				return;
			}
			
			if($(this).parent().hasClass('disable'))
			{
				return;
			}
			
			$('#label-'+$(this).parent().attr('id')).show();
			if($(this).parent().attr('id') == 'layoutWrap')
			{
				$('#label-'+$(this).parent().attr('id')).find('.txt').removeClass('icon-24-position1 icon-25-position2 icon-26-position3 icon-27-position4 icon-28-position5');
				$('#label-'+$(this).parent().attr('id')).find('.txt').addClass($(this).attr('class'));
			
			}else
			{
				$('#label-'+$(this).parent().attr('id')).find('.txt').html($(this).html());
			}
			$(this).parent().find('a').removeClass('active');
			$(this).addClass('active');
		},
		function(){
			if($(this).parent().hasClass('disable'))
			{
				return;
			}
			$('#label-'+$(this).parent().attr('id')).hide();
			$(this).parent().find('a').removeClass('active');
		}
	
	)
	
	
	
	
	
	// 特别的单选按钮 再次点击时取消选择
	$('.doubleCancle').on('ifClicked',function(event){
		$(this).iCheck('uncheck')
	})
	
	//test
	
	

	
	
	// 把选择框的 结果显示在最顶端
	$('.filterPanel input[type=checkbox], .filterPanel input[type=radio]')
	.on('ifChecked', function(event){
		$('#label-'+$(this).attr('id')).show();
		
	}).on('ifUnchecked', function(event){
		$('#label-'+$(this).attr('id')).hide();
	});	
	
	
	
	
	
	$('.checkTop input[type=checkbox]')
	.on('ifClicked', function(event){
		//alert(event.type + ' callback');
		
		if($(this).parent().hasClass('checked'))
		{
			$(this).closest('.checkGroupWrap').find('.checkSub input[type=checkbox]').iCheck('uncheck');
			
		}else
		{
			$(this).closest('.checkGroupWrap').find('.checkSub input[type=checkbox]').iCheck('check');	
		}
		
		
		
	})/*.on('ifUnchecked', function(event){
		
	});	*/
	
	
	$('.checkSub input[type=checkbox]')
	.on('ifChecked', function(event){
		
		$(this).closest('.checkGroupWrap').find('.checkTop > label  input[type=checkbox]').iCheck('check');
		
	}).on('ifUnchecked', function(event){
		
		if($(this).closest('.checkGroupWrap').find('.checkSub > label.checked').length <=1)
		{
			$(this).closest('.checkGroupWrap').find('.checkTop input[type=checkbox]').iCheck('uncheck');
		}
		
	});	
	
	
	
	
	
	
	
	
	// -- 点击选择结关闭按钮 重置选择
	$('.resultPanelInner .searchKeyWord').on('click','.icon-8-delete',function(){
				
		if($(this).parent().hasClass('label-exclude'))
		{
			$(this).parent().remove();
		}else
		{
			var checkId=$(this).parent().attr('id').replace('label-','');
			if($('#'+checkId).is("input[type=checkbox]") || $('#'+checkId).is("input[type=radio]"))
			{
				$('#'+checkId).iCheck('uncheck');
			}else if($('#'+checkId).is("select"))
			{
				$(this).parent().find('.txt').html('');
				$(this).parent().hide();
				$('#'+checkId)[0].selectedIndex = 0;
				$('#'+checkId).next('.selectBox').find('.selectBox-label').html($('#'+checkId).val());
				
			}else if($('#'+checkId).hasClass('colorCurrent'))
			{
				$('.colorCurrent').removeClass('color-'+$('.colorCurrent').attr('color'));
				$('#label-selectCcolor .color').removeClass('color-'+$('.colorCurrent').attr('color'));
				$('#label-selectCcolor').hide();
				
			}else if( $('#'+checkId).hasClass('selectOne') )
			{
				$('#'+checkId).find('a').removeClass('active');			
				$(this).parent().hide();
			}
			
		}
	})
	
	// -- 排除关键字
	$('.excludeWrap a.btnAdd').click(function(){

		if($('.excludeWrap input').val() != "")
		{
			var newLabel='<div class="label label-exclude"><span class="icon-font icon-8-delete"></span><span class="txt">'+$('.excludeWrap input').val()+'</span></div>';
			$('.searchKeyWord').append(newLabel);
			$('.label-exclude').show();
			$('.excludeWrap input').val('');
		}
	})
	
	
	// 显示/隐藏搜索面板
	$('.btnExpand').click(function(){
		if($('.filterPanel').css('margin-left')=='0px')
		{
			$('body').addClass('hideFilter').removeClass('showFilter');
			$(this).removeClass('icon-1-arrowLeft');
			$(this).addClass('icon-2-arrowRight');
		}else
		{
			$('body').removeClass('hideFilter').addClass('showFilter');
			$(this).removeClass('icon-2-arrowRight');
			$(this).addClass('icon-1-arrowLeft');
		}
		
		setTimeout(function(){
			//refreshBeforeMasonry();
		 	$container.masonry();
		 },600);
	})
	
// -------------- end left filter panel 


// -------------- search result

	// -- 是否打开详细布局
	$('.toggleDetail').click(function(){
		if($(this).hasClass('active'))
		{
			$(this).removeClass('active');
			$('body').removeClass('globalDetail');
			//refreshBeforeMasonry();
			$container.masonry();
		}else{
			
			$(this).addClass('active');
			$('body').addClass('globalDetail');
			//refreshBeforeMasonry();
			$container.masonry();
		}
	})
	
	// -- 是否打开预览布局
	$('.togglePreview').click(function(){
		if($(this).hasClass('active'))
		{
			$(this).removeClass('active');
			$('body').removeClass('globalPreview');
			$('.galleryWrap .galleryThumb .imgWrap').tooltipster('disable');
		}else{
			
			$(this).addClass('active');
			$('body').addClass('globalPreview');
			$('.galleryWrap .galleryThumb .imgWrap').tooltipster('enable');
		}
	})
	
	// -- 切换三种浏览布局
	$('.picLayoutWrap a').click(function(){
		var index=$('.picLayoutWrap a').index(this)+1;
		
		$('body').removeClass('layout1 layout2 layout3');
		$('body').addClass('layout'+index);
		
		
		$('.picLayoutWrap a').removeClass('active');
		$(this).addClass('active');
		
		setTimeout(function(){
			//refreshBeforeMasonry();
			$container.masonry();
		},600);
	})
	
	
	
	function refreshBeforeMasonry()
	{
		$('.galleryThumb .imgWrap').each(function(){
			
			var imgW=$(this).find('img').attr('width');
			var imgH=$(this).find('img').attr('height');
			
			//console.log($('.galleryThumb').width()+'=='+imgW)
			$(this).height(imgH*$('.galleryThumb').width()/imgW);
/*			if($('body').hasdClass('layout3') )
			{
				
			}*/
			
		})	
	}
	
	// 瀑布流
	var $container;	
	if( $('.galleryWrap').length > 0)
	{
		$container= $('.galleryWrap').masonry({
			itemSelector : '.galleryWrap .galleryThumb',
			isAnimated: false
		});
		
		
		// 新添加部分 
		
		/*
		 主要逻辑：
		 先把图片隐藏css  等图片排好位置再显示 line 671. 同类逻辑的代码 再ajax新的图片时也要进行一次 line 703- 716
		 1. 图片加载过程中 每隔0.3s 排一下位置， 没有加载的图片不排位置
		 2. 图片加载成功 排好位置 显示出来
		 
		 interValClear 时间间隔是否到了
		 attr:loading 图片是否加载中
		*/
		var interValClear=true;
		$('.galleryWrap .galleryThumb img').attr('loading','true');
		$('.galleryWrap .galleryThumb img').one('load',function() {
			
			$(this).attr('loading','false');
			if(interValClear==true)
			{
				interValClear=false;
				window.setTimeout(function(){
					interValClear=true;
					$container.masonry();
					$('.galleryWrap .galleryThumb img[loading="false"]').css('opacity',1);
				},300);
			}
		})
	
		$('.galleryWrap').infinitescroll({
	
			navSelector  	: "#loadMore:last",
			nextSelector 	: "a#loadMore:last",
			itemSelector 	: ".galleryWrap .galleryThumb",
			behavior: 'local',
	 		msgText  :'',
			finishedMsg     : "" ,
			debug		 	: false,
			dataType	 	: 'html',
			maxPage         : 3,
			path: function(index) {
				return "gallery" + index + ".html";
			},
			errorCallback: function(){
				$('.searchResultFooter').show();
			}
		},function(newElements, data, url){
			
			var $newElems = $(newElements);
			$container.masonry( 'appended', $newElems );
			
			
			
			$newElems.find('img').attr('loading','true');
			$newElems.find('img').one('load',function() {
				$(this).attr('loading','false');
				if(interValClear==true)
				{
					interValClear=false;
					window.setTimeout(function(){
						interValClear=true;
						//console.log('tes');
						$container.masonry();
						$newElems.find('img[loading="false"]').css('opacity',1);
					},300);
				}
			})
			
			enableToolTips();
			resetLightBoxed();
		});
	}

	// 预览框
	/*
		data.status
			0: 正确
			1：错误
		data.errorMsg
	*/
	
	/*<div class="picDetailWrap">
		<div class="imgWrap"><img src="images/search/popup.jpg" imgId="123"/></div>
		<div class="picCont">
			<div class="tag"><span>RM</span>创意类</div>
			<div class="header">图片的短名字</div>
			<div class="picInfo">
				图片编号: 204023333<br/>
				摄影师   Andrew Alderson<br/>
				专辑名字  Blink <br/>
			</div>
			<a href="#" class="btnPurple btnShopCart btn-block">加购物车 </a>
			<div class="btnWrap iconWrap">
				<a href="#" class="icon-font icon-22-download"></a>
				<a href="javascript:void(0)" class="icon-font icon-11-favourite"></a>
				<a href="#" class="icon-font icon-29-search2"></a>
			</div>
		</div>
	</div>*/

	//enableToolTips();
	function enableToolTips()
	{	
		$('.galleryWrap .galleryThumb .imgWrap').tooltipster({
			content: '',
			contentAsHTML: true,
			position:'right',
			arrow:false,
			interactive:true,
			//updateAnimation:false,
			touchDevices: false,
			minWidth:860,
			//offsetX:-260,
			delay:1000,
			//autoClose: false,
			functionBefore: function(origin, continueTooltip) {
				// we'll make this function asynchronous and allow the tooltip to go ahead and show the loading notification while fetching our data
				continueTooltip();
				// next, we want to check if our data has already been cached
				if (origin.data('ajax') !== 'cached') {
					
					var imgLightBoxedClass="";
					
					//判断是否收藏
					if(origin.parents('.galleryWrap .galleryThumb.lightBoxed').length > 0)
					{
						imgLightBoxedClass="lightBoxed";
					}else
					{
						imgLightBoxedClass="";
					}
					$.ajax({
						type: 'POST',
						dataType:'json',
						url: ajaxUrl_toolTip,
						data:{'imgId':origin.find('img').attr('imgId'), 'lightBoxId':$('.lightBoxList li.active').attr('lightBoxId')},
						success: function(data) {
							// update our tooltip content with our returned data and cache it

							var htmlData='';
							if(data.status == 1)
							{
								// 两个按钮 有 .btns2
								/*htmlData='<div class="picDetailWrap '+imgLightBoxedClass+'"><div class="imgWrap"><a href="#"><img src="images/search/popup.jpg" imgId="'+data.imgId+'"/></a></div><div class="picCont"><div class="tag"><span>RM</span>创意类</div><div class="header" title="AndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAlderson">AndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAlderson</div><div class="picInfo">图片编号: 204023333<br/>摄影师   Andrew Alderson<br/>专辑名字  Blink <br/></div><a href="#" class="btnPurple btnShopCart btn-block">加购物车</a><div class="btnWrap iconWrap btns2"><!--<a href="javascript:void(0)" class="icon-font icon-22-download"></a>--><a href="javascript:void(0)" class="icon-font icon-11-favourite"></a><a href="javascript:void(0)" class="icon-font icon-29-search2"></a></div></div></div>';*/	
								// 3个按钮没 有 .btns2
								htmlData='<div class="picDetailWrap '+imgLightBoxedClass+'"><div class="imgWrap"><a href="#"><img src="images/search/popup.jpg" imgId="'+data.imgId+'"/></a></div><div class="picCont"><div class="tag"><span>RM</span>创意类</div><div class="header" title="AndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAlderson">AndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAldersonAndrewAlderson</div><div class="picInfo">图片编号: 204023333<br/>摄影师   Andrew Alderson<br/>专辑名字  Blink <br/></div><a href="#" class="btnPurple btnShopCart btn-block">加购物车</a><div class="btnWrap iconWrap"><a href="javascript:void(0)" class="icon-font icon-22-download"></a><a href="javascript:void(0)" class="icon-font icon-11-favourite"></a><a href="javascript:void(0)" class="icon-font icon-29-search2"></a></div></div></div>';
								

							}else
							{
								htmlData=data.errorMsg;
							}
							
							origin.tooltipster('content', htmlData).data('ajax', 'cached');
							$('.tooltipster-default').css('background','none');
						}
					});
				}
			}
		});
		if(!$('body').hasClass('globalPreview'))
		{
			$('.galleryWrap .galleryThumb .imgWrap').tooltipster('disable');
		}
	}
	
	
	
	
	
// -------------- search result
	
	//查找相似
	

	

	$('body').on('click', '.jsSearchSimlar', function(){
		
		var $img = $(this).closest('.galleryThumb').find('img');
		var imgId= $img.attr('imgId');
		var paddingLeft= ($img.width()*92/$img.height()) +30;
		if(paddingLeft > 170)
		{
			paddingLeft= 170;
		}
		
		$.post('post/searchSimlar.php', {}, function(data) {
			
			if(data.status == 1)
			{
				$('.mlt-image').stop().fadeIn();
				
				//$('.mlt-image img').attr('src',data.imgUrl);  -> 
				$('.mlt-image img').attr('src',$img.attr('src')); // 假的src, 请用上一行代码
				$('.searchFiled').css('paddingLeft',paddingLeft);
				$('.mlt-image').css('width',paddingLeft - 30);
				
				
			}else
			{
				popUp(data.errorMsg);
			}
		},"json")
	})



$('.mlt-image .icon-8-delete').click(function(){
	
	$('.mlt-image').stop().hide();
	$('.mlt-image img').attr('src','');
	$('.searchFiled').css('paddingLeft',40);
	$('.mlt-image').css('width',0);
	
})



	

	

	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
});
}( jQuery ));



