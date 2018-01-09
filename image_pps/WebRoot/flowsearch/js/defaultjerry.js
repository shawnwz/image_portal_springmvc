(function ( $ ) {
jQuery(document).ready(function() {


	
	$("a").each(function(index) {
		if($(this).attr('href')=='#')
		{
			 $(this).attr('href','javascript:void(0)');
		}
	});
	

		
	// 美化选择框 select
	$(function(){
		//$('select').customSelect();
		
		if($('select').length > 0)
		{
			$('select').selectBox({
				mobile: true
			});
		}
		
	});
	
	
	
	function popUp(message)
	{
		alert(message);
	}
	
	if($(".bannerWrap").length)
	{
		$(".bannerWrap").rotateBanner();
	}

	//change hover to click on mobile
	/*
	$('.hoverShow').click( function(){
	    if($('#navLeft>ul').css('display')=='none'){
		    $(this).addClass('active');
			var targetShow = $(this).attr('targetShow');
			$('#'+targetShow).addClass('expand');
	    }else{
			$(this).removeClass('active');
			var targetShow = $(this).attr('targetShow');
			$('#'+targetShow).removeClass('expand');
		}
	})
	$('.hoverShow').hover(
		function(){
			$(this).addClass('active');
			var targetShow = $(this).attr('targetShow');
			$('#'+targetShow).addClass('expand');
		},
		function(){
			$(this).removeClass('active');
			var targetShow = $(this).attr('targetShow');
			$('#'+targetShow).removeClass('expand');
		}
	)
	*/
	$('#navMobileMenu').click( function(){
	    if($('#navLeft>ul').css('display')=='none'){
		    $('#navMobileMenu').addClass('active');
			var targetShow = $(this).attr('targetShow');
			$('#'+targetShow).addClass('expand');
	    }else{
			$('#navMobileMenu').removeClass('active');
			var targetShow = $(this).attr('targetShow');
			$('#'+targetShow).removeClass('expand');
		}
	});
	
	$('#navUserCenter').click( function(){	    
		if($('#userCenterMobileMenu').css('display')=='none'){
		    $('#navUserCenter').addClass('active');
			var targetShow = $(this).attr('targetShow');
			$('#'+targetShow).addClass('expand');
	    }else{
			$('#navUserCenter').removeClass('active');
			var targetShow = $(this).attr('targetShow');
			$('#'+targetShow).removeClass('expand');
		}
	})
	

	$('#navUserCenter').hover(
		function(){
			$('#navUserCenter').addClass('active');
			var targetShow = $(this).attr('targetShow');
			$('#'+targetShow).addClass('expand');
		},
		function(){
			$('#navUserCenter').removeClass('active');
			var targetShow = $(this).attr('targetShow');
			$('#'+targetShow).removeClass('expand');
		}
	)

	
	$('.hoverShowTarget').hover(
		function(){
			var targetParent = $(this).attr('targetParent')
			$('#'+targetParent).addClass('active');
			$(this).addClass('expand');
			
		},
		function(){
			var targetParent = $(this).attr('targetParent')
			$('#'+targetParent).removeClass('active');
			$(this).removeClass('expand');
		}
	)
	
	$('.collapse').click(function(){
		if($(this).parent().hasClass('expand'))
		{
			$(this).parent().removeClass('expand');
		}else
		{
			$(this).parent().addClass('expand');
			
			$('.collapseFav').removeClass('active');
			$('#userCenterMobileMenu').removeClass('expand');
			$('body').css({'overflow':'auto','height':'auto'});
		}
	})
	
	
	$('.collapseFav').click(function(){
		if($('#userCenterMobileMenu').hasClass('expand'))
		{
			$('.collapseFav').removeClass('active');
			$('#userCenterMobileMenu').removeClass('expand');
			$('body').css({'overflow':'auto','height':'auto'});
			
			
		}else
		{
			$('.collapseFav').addClass('active');
			$('#userCenterMobileMenu').addClass('expand');
			$('body').css({'overflow':'hidden','height':'100%'});
			
			$('.collapse').parent().removeClass('expand');
		}
	})

	
	$('.expandPanelBtn').click(function(){
		
		if($(this).closest('.expandPanelWrap').hasClass('expand'))
		{
			$(this).closest('.expandPanelWrap').removeClass('expand');
		}else
		{
			$(this).closest('.expandPanelWrap').addClass('expand');
		}
	})
	
	
	
	$('.searchBar .searchBarInner').focusin(function() {
		$(this).addClass('focused');
	})
	.focusout(function() {
		$(this).removeClass('focused');
	});
	
	
	
	$('.focusWrap').focusin(function() {
		$(this).addClass('focused');
	})
	.focusout(function() {
		$(this).removeClass('focused');
	});
	
	
	
	
	
	
	
	
	
	
	
	
	if( $('#carousel-homeNews .item').length == 1)
	{
		$('#carousel-homeNews .carousel-control').hide();
	}
	
	
	
	$('.btnPageUp, .scrollTop').click(function(){
		
		$('body,html').animate({scrollTop:0},500); 
	})
	
	$('#homeBanner .btnPageDown').click(function(){
		
		$('body,html').animate({scrollTop:$('#homeBanner').innerHeight() + $('#topBar').innerHeight()},500); 
		
	})
	
	
	/* form */
	
	$('body').click(function(event){
		if($(event.target).parents('.selectWrap').length == 0){
			$('.selectWrap .selectList').hide();
			$('.selectWrap').removeClass('expand');
		}
		if($(event.target).parents('.autoCloseWrap').length == 0)
		{
			$('.autoCloseWrap').removeClass('expand');
		}
	})
	
	$('.selectWrap .selectValue').click(function(){
		if($(this).parents('.selectWrap').hasClass('expand'))
		{
			$(this).parents('.selectWrap').removeClass('expand');
			$(this).parents('.selectWrap').find('.selectList').stop().slideUp(100);			
		}else
		{
			$(this).parents('.selectWrap').addClass('expand');
			$(this).parents('.selectWrap').find('.selectList').stop().slideDown(100);	
		}
	});
	
	
	$('.selectWrap ul').on('click','li',function(){
		$(this).parent().find('li').removeClass('active');
		$(this).addClass('active');
		if($(this).parents('.selectWrap').find('.selectValue').is("input[type=text]"))
		{
			$(this).parents('.selectWrap').find('.selectValue').val($(this).html());
		}else
		{
			$(this).parents('.selectWrap').find('.selectValue').html($(this).html());
		}
		$(this).parents('.selectList').hide();		
	});
	


	$('.dropDownBtn').hover(
		function(){
			$(this).parents('.dropDownWrap').addClass('expand');
		},
		function(){
			//$('.dropDownPanel').hide();
		}
	)
	
	
	$('.dropDownWrap').hover(
		function(){
			//$(this).addClass('expand');
		},
		function(){
			$(this).removeClass('expand');
		}
	);
	
	
	
	

	if($('input[type=checkbox]').length > 0)
	{
		$('input[type=checkbox], input[type=radio]').iCheck({
			checkboxClass: 'icheckbox_square-blue',
			radioClass: 'iradio_square-blue',
			labelHover: false
		});
	
	}

	
	
	
	$('.btnSlideDown').click(function(){
		
		if(!$('.hideMore').is(':visible'))
		{
			$(this).parents('.filterSection').find('.hideMore').slideDown();
		}else
		{
			$(this).parents('.filterSection').find('.hideMore').slideUp();
		}
			
	})

	

	
	
	
	
	$('.btnMobileExpand').click(function(){
		if($('.filterPanel').css('margin-left')=='0px')
		{
			$('body').addClass('hideFilter').removeClass('showFilter');
			$('.btnExpand').removeClass('icon-1-arrowLeft');
			$('.btnExpand').addClass('icon-2-arrowRight');
		}else
		{
			$('body').removeClass('hideFilter').addClass('showFilter');
			$('.btnExpand').removeClass('icon-2-arrowRight');
			$('.btnExpand').addClass('icon-1-arrowLeft');
		}
	})
	

	
	

	
	
	$(window).bind('scroll', function() {
		 if ($(window).scrollTop() > $('.navWrap').innerHeight()) {
			 $('body').addClass('fixLightBox');
		 }
		 else {
			 $('body').removeClass('fixLightBox');
		 }
		 
		 
		 if($(window).scrollTop()> 20)
		 {
			$('.btnPageUp').fadeIn(); 
		 }else
		 {
			$('.btnPageUp').fadeOut(); 
		 }
	 
	});
	
	
	checkSearchInputFont();
	function checkSearchInputFont()
	{
		if($('.searchFiled').val()!=""){
			$('.searchFiled').addClass('normalFont');
		}else
		{
			$('.searchFiled').removeClass('normalFont');
		}	
	}
	
	$('.searchFiled').change(function(){
		checkSearchInputFont();
	})
	
	
	
	
	


	
	$('.btnShowPasswd').toggle(
		function(){
			$(this).closest('.input-group').find('.form-control').get(0).type = 'text';
			$(this).addClass('active');
		},
		function(){
			$(this).closest('.input-group').find('.form-control').get(0).type ='password';
			$(this).removeClass('active');
		}
	)
	
	
	
	$('.officeShort').click(function(){
		$(this).slideUp();
		$('.officeAddress').slideDown();	
	});
	
	
	
	
	
	
	
	if($('.fancybox').length>0)
	{
		$('.fancybox').fancybox({
			padding : 0,
			//width:'460',
			//height:'602',
			autoResize:'true',
			autoWidth:'true',
			autoScale:'true',
			helpers : {
				title: {
					type: 'inside',
					position : 'top'
				}
			},
			beforeLoad : function() {                    
				this.width = parseInt(this.href.match(/width=[0-9]+/i)[0].replace('width=',''));  
				this.height = parseInt(this.href.match(/height=[0-9]+/i)[0].replace('height=',''));
				//$(this.element).attr('lightBoxId');
			},
			afterLoad: function() {
				this.title = $(this.element).attr('lightBoxId');;
			}
		});
		
	}
	
	
	
	
	
	
	
	
	
	$('#userCenterMobileMenu ul li .icon-2-arrowRight').click(function(){
		$('.navMobile').animate({'width':68});
		$(this).closest('li').addClass('active');
		
	})
	
	
	
	
	
	
	
	$('.favFolderControl .icon-50-trash').toggle(
	
		function(){
			$(this).addClass('active');
			$(this).closest('.navMobileSub').find('.favouriteFolderList').addClass('showBtnClose');
		},
		function(){
			
			$(this).removeClass('active');
			$(this).closest('.navMobileSub').find('.favouriteFolderList').removeClass('showBtnClose');
		}
	
	);
	
	
 
	var scrollbar2 = $(".scrollbar2").data("plugin_tinyscrollbar");
	if($(".scrollbar2").length > 0)
	{
		$(".scrollbar2").tinyscrollbar();
	}
	
	
	
	
	
	// -- 清除选择
	var selectRMCate = new SelectBox($('#selectRMCate'));
	clearAdFilter();
	
	
	
	
	
	function clearAdFilter()
	{
		// checkbox radiobox 重置
		$('.searchAdWrap input[type=checkbox], .searchAdWrap input[type=radio]').iCheck('uncheck');
		
		// 选择图片布局 重置
		$('.searchAdWrap .selectOne a').removeClass('active');
		
		// 下拉菜单重置 
		$('.searchAdWrap select').val(0);
		if(selectRMCate.data)
		{
			selectRMCate.refresh(); 
		}
		$('.searchAdWrap input[type=text]').val('');
	}
	
	
	$('#btnAdRefresh').click(clearAdFilter);
	
	
	
/*	$('#checkEditRM').on('ifChecked', function(event){
		$('.searchEditRMWrap .cover').hide();
		$('.searchEditRMWrap').removeClass('disable');
		$('.searchCollection input[type=checkbox]').iCheck('check');
		if( scrollbar2 === undefined)
		{
			scrollbar2 = $(".scrollbar2").data("plugin_tinyscrollbar");
			scrollbar2.update();
		}
	}).on('ifUnchecked', function(event){

		$('.searchEditRMWrap .cover').show();
		$('.searchEditRMWrap').addClass('disable');
	});	*/
	
	
	
	$('.searchCollection').on('click','.selectAll',function(){
		$(this).closest('.searchCollection').find('input[type=checkbox]').iCheck('check');			
	})
	
	$('.searchCollection').on('click','.unSelectAll',function(){
		$(this).closest('.searchCollection').find('input[type=checkbox]').iCheck('uncheck');	
	})
	
	
	$('.searchCollection input[type=checkbox]').on('ifChecked', function(event){
		
		var $wrap=$(this).closest('.searchCollection');
		$wrap.find('.selectedNum').html($wrap.find('div.checked').length+1);
	}).on('ifUnchecked', function(event){

		var $wrap=$(this).closest('.searchCollection');
		//$wrap.find('label.checked').addClass('test');
		$wrap.find('.selectedNum').html($wrap.find('div.checked').length-1);
	});	
	
	
	
	
	function showAlertTooltips(msg)
	{
		if($('#alertToolTips').length ==0 )
		{
			$('body').append('<div id="alertToolTips"></div>');
		}
		
		$('#alertToolTips').html(msg).show().stop(true,true).animate({
			opacity: 1,
			marginTop: "-=30"
			}, 300).delay(300).animate({
			opacity: 0,
			marginTop: "-=30"
			}, 300,function(){
					$('#alertToolTips').css({marginTop:0,display:'none'});
				})
	}
	
	
	//
	
	$('.searchAdWrap .icon-59-saveSearch').click(function(){
		showAlertTooltips('保存成功!');
	})
	
	
	
/*			
	var $container= $('.favouriteGallery');
	if( $('.favouriteGallery').length > 0)
	{
		$container.imagesLoaded( function() {
		 	$container.masonry({
				itemSelector : '.favouriteGallery  .galleryThumb'
			});
		});
	}
	*/
	
	var $containerDefault= $('.galleryWrapDefault');
	var interValClearDefault=true;
	
	if($containerDefault.length > 0)
	{
		$('.galleryWrapDefault .galleryThumbDefault img').attr('loading','true');
		$('.galleryWrapDefault .galleryThumbDefault img').one('load',function() {
			
			$(this).attr('loading','false');
			if(interValClearDefault==true)
			{
				interValClearDefault=false;
				window.setTimeout(function(){
					interValClearDefault=true;
					$containerDefault.masonry();
					$('.galleryWrapDefault .galleryThumbDefault img[loading="false"]').css('opacity',1);
				},300);
			}
		})
		
		
		$containerDefault.imagesLoaded( function() {
		 	$containerDefault.masonry();
		});
		
		
	}
	
	
	
	
	
	
	
	
	
	
	$('.applyWrap .toggleBtn').click(function(){
		
		if($(this).closest('.applyWrap').hasClass('expand'))
		{
			$(this).closest('.applyWrap').removeClass('expand');
			$('.applyContWrap').slideUp();
		}else
		{
			$(this).closest('.applyWrap').addClass('expand');
			$('.applyContWrap').slideDown();
		}
	})
	
	
	

	
	$('.applyWrap .step1 .btnJsNext').click(function(){
		
		var $form=$(this).closest('.formContributor');
		if($form.valid())
		{
			$('.applyWrap .stepCont').hide();
			$('.applyWrap .step2').show();
		}
	})
	
	$('.applyWrap .step2 .btnJsNext').click(function(){
		$('.applyWrap .stepCont').hide();
		$('.applyWrap .step3').show();
	})
	
	$('.applyWrap .step3 .btnJsNext').click(function(){
		$('.applyWrap .stepCont').hide();
		$('.applyWrap .step4').show();
	})
	
	$('.applyWrap .step4 .btnJsNext').click(function(){
		
		//here to sub submit . 
		var url="Contributor/submit.na";
		var uid=$.cookie("cookieId");
		if(!uid)
		{
			uid=  Guid.NewGuid().ToString("D");
			$.cookie("cookieId",uid);
		}
		var paras=$('.formContributor').serialize()+"&cookie_id="+uid;
		$.post(url,paras,function(data){
			$('.applyWrap .stepCont').hide();
			$('.applyWrap .step5').show();
		});
		/////////////////////////////////////////////
		
		
	})
	
	
	
	
	
	
var newInput='<div class="input-group focusWrap">'+
				'<div class="label">邮件地址</div>'+
				'<input name="formEmail" class="form-control" type="text"></input>'+
				'<div class="controlBox">'+
					'<span class="controlBtn icon-font add icon-plus"></span>'+
					'<span class="controlBtn icon-font remove  icon-cross"></span>'+
				'</div>'+
			'</div>';


$('.stepSuccess').on('click', '.icon-plus', function(){
	$('.moreEmail').append(newInput);
})


$('.stepSuccess').on('click', '.icon-cross', function(){
	$(this).closest('.input-group').remove();
})




var uid=$.cookie("cookieId");
if(!uid)
{
	uid=  Guid.NewGuid().ToString("D");
	$.cookie("cookieId",uid);
}

	
});
}( jQuery ));








//
