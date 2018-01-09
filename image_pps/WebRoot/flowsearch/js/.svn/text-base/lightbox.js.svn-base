
	var ajaxUrl_switchLightBox = 'my/getlightboxitems';
	var ajaxUrl_createNewFavouriteFolder = 'my/addlightbox';
	var ajaxUrl_addToLightBox = 'my/addlightboximages';
	var ajaxUrl_removeFromLightBox = 'my/dellightboximages';



$(document).ready(function() {

	 
	
//-- 切换灯箱
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
	var curLightBoxid = $(this).attr("lightboxid");
	// 发送ajax 请求
	
	$.post(ajaxUrl_switchLightBox, {key : curLightBoxid}, function(data) {
		
		if(data.error ==0)
		{
			var htmlData = '';
			
			$.each(data.data, function() {
				var eles = data.map[this.corbisId];
				if(eles != undefined)
				{
					//<li><a href="#"><img src="images/search/thumb305_1.jpg" width="80" imgId="1099"/></a><span class="icon-font icon-8-delete"></span></li> // html 格式
					htmlData += '<li><a href="image/'+this.corbisId+'" target="_blank""><img src="'+ eles.imageHost+ 'THUMBNAIL/180/'+ eles.path+ eles.ext + '" width="80" imgId="' + this.corbisId + '"></a><span class="icon-font icon-8-delete"></span></li>';
				}
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

//-------------- jcarousel lightBox

//-- 灯箱初始化
$('.jcarousel').jcarousel();

//-- 灯箱 点击左边按钮
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
//-- 灯箱 点击右边按钮
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
//-- 灯箱 页码
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




//-- 创造新的收藏板
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
		
		$.post(ajaxUrl_createNewFavouriteFolder, {name : $(".listName").val()}, function( data ) {
			if(data.error == 0)
			{
				// 灯箱名不为空 清除错误提示
				$('.listName').attr('placeholder','创造新的收藏板');
				$('.listName').removeClass('error');
				
				// 显示最新的收藏版的名字在顶部
				$('.selectList ul li').removeClass('active');
				$('.selectList ul').prepend('<li class="active" lightBoxId="'+data.data.id+'">'+$('.listName').val()+'<span class="num">0</span><span>图片</span></li>');	
				$('.lightBoxList .selectValue').html($('.selectList li.active').html());
				
				
				$('.jcarousel ul').html(''); // 新添加收藏版 内容为空
				$('.jcarousel').jcarousel('reload'); // 刷新灯箱
				//$('.jcarousel').removeClass('loading');
				
				$('.listName').val(''); // 清空添加收藏版的 input 数据
				
				curLightBoxid=data.id;
				
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

	
//-- 关闭灯箱
$('.closeJcarousel').click(function(){
	if($('.lightBoxWrap').is(':visible'))
	{	
		$('#navRight ul li a.icon-11-favourite').removeClass('active');	
		$('.lightBoxWrapOut').stop('true','true').slideUp();
		$('.lightBoxWrap').stop('true','true').slideUp();
		$('body').removeClass('showLightBox');

		globalFirstAddFav = true;
		$('.galleryWrap .galleryThumb .imgWrap ').parents('.galleryThumb').removeClass('lightBoxed');  
	}
})

//-- 导航收藏图标打开/关闭灯箱
//$('#navRight ul li a.icon-11-favourite')
$('#navRight ul li a.btnLightBox').click(function(){
	if($('.lightBoxWrapOut').is(':visible'))
	{
		$(this).removeClass('active');	
		$('.lightBoxWrapOut').stop('true','true').slideUp();
		$('body').removeClass('showLightBox');
		
		globalFirstAddFav = true;
		$('.galleryWrap .galleryThumb .imgWrap ').parents('.galleryThumb').removeClass('lightBoxed');  
	}else
	{
		$(this).addClass('active');	
		$('.lightBoxWrapOut').stop('true','true').slideDown(300,function(){$('.lightBoxWrapOut').css('overflow','');});
		$('.lightBoxWrap').stop('true','true').slideDown(300,function(){$('.lightBoxWrap').css('overflow','');});
		
		$('.jcarousel').jcarousel('reload');	
		$('body').addClass('showLightBox');
		
		$.post(
				"my/getlightboxeslist",
				{
					t : Math.random()
				},
				function(data) {
					if (data && data.error == 0 && data.data
							&& data.data.length > 0) 
					{
						  
						$(".selectList").find("ul").empty();
						for ( var i = 0; i < data.data.length; i++) {
							var n = data.data[data.data.length -1 - i];
//							var sons = privateGetSonItems(data.data,n.id);
//							myCurLightBoxs[n.id]=n;
							var html = '<li ';
							if(i==0)
							{
								html +=' class="active" ';
							}
							    html +=' lightboxid="'+n.id+'">'+n.name+'<span class="num">'+n.imageNum+'</span><span>图片</span></li>';
							
							$(".selectList").find("ul").append(html);
							if(i==0)
							{
								$('.lightBoxList .selectValue').html(n.name+'<span class="num">'+n.imageNum+'</span><span>图片</span>');
							}
						};
						if(data.data.length>0)
						{
							var lightboxid = data.data[data.data.length -1].id;//
							loadimg (lightboxid);
						}	
						 
					} else if (data && data.error == 401) {
						//alert("请先登录");
						window.open("login", "_self");
					} else {
						alert("请先登录");
					}
				});
	}
})


//-- 通过图片id 从灯箱删除图片
function removeFromLightBox(_imgId,where){
	var curLightBoxid = $(".lightBoxList").find("ul").find(".active").attr("lightboxid");
	if(curLightBoxid==undefined)
	{
		curLightBoxid = $($(".lightBoxList").find("li")[0]).attr("lightboxid");
	}
	$.post(ajaxUrl_removeFromLightBox, {"key":_imgId,"lightBoxId":curLightBoxid}, function( data ) {
		if(data.error == 0){	
			// 删除此id 的图片数据
				$('.jcarousel ul li a[href="image/'+_imgId+'"]').parents('li').remove();	
				$('.galleryWrap .galleryThumb.lightBoxed .imgWrap img[imgId='+_imgId+']').parents('.galleryThumb.lightBoxed').removeClass('lightBoxed');// 搜索结果的小图移除灰色背景
			
			$('.jcarousel').jcarousel('reload'); // 刷新灯箱
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


//-- 点击灯箱图片右上角的删除按钮 删除图片
$('.jcarousel').on('click','.icon-8-delete',function(){
	$(this).parents('li').remove();
	$('.jcarousel').jcarousel('reload');
	removeFromLightBox($(this).parents('li').find('img').attr('imgId'),"top");
})


//点击搜索结果的图片的收藏按钮 收藏/取消收藏
$('body').on('click', '.galleryWrap .galleryThumb .icon-11-favourite', function(event) {

	event.preventDefault();
	// 取得图片id
	var imgId=$(this).parents('.galleryThumb').find('img').attr('imgId');
	
	// 如果收藏了
	if($(this).parents('.galleryThumb').hasClass('lightBoxed'))
	{
		removeFromLightBox(imgId,"result"); // 取消收藏
	}else
	{
		addToLightBox(imgId);
	}
})


//通过点击预览框里的收藏按钮  收藏/取消收藏
$('body').on('click', '.tooltipster-base .icon-11-favourite', function(event) {

	event.preventDefault();
	var imgId=$(this).parents('.picDetailWrap').find('img').attr('imgId');
	if($(this).parents('.picDetailWrap').hasClass('lightBoxed'))
	{
		removeFromLightBox(imgId,"result");
	}
	else
	{
		addToLightBox(imgId);
	}
})

//通过点击图片详情页里的收藏按钮  收藏/取消收藏
$('body').on('click', '.detailPhotoDesc .funcBox .icon-11-favourite-click', function(event) {

	event.preventDefault();
	var imgId=$(".detailPhotoDesc .funcBox .icon-11-favourite-click").attr("imgid");//$(this).parents('.picDetailWrap').find('img').attr('imgId');
	
	if($(this).hasClass('lightBoxed'))
	{
		removeFromLightBox(imgId,"result");
		$(this).removeClass('lightBoxed');
	}
	else
	{
		addToLightBox(imgId);
		$(this).addClass('lightBoxed');
	}
})
//-------------- end jcarousel lightBox




});





//-- 通过图片id添加图片到灯箱
var globalFirstAddFav=true; // 是否第一次添加
function addToLightBox(_imgId){
	var curLightBoxid = $($(".lightBoxList").find("li.active ")).attr("lightboxid");
	if(curLightBoxid == undefined)
	{
		curLightBoxid = $($(".lightBoxList").find("li")[0]).attr("lightboxid");
	}
	$.post(ajaxUrl_addToLightBox, {key : curLightBoxid,corbisId:_imgId}, function( data ) {
		if(data.error == 0)
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
			$('.jcarousel ul').append('<li><a href="image/'+data.data.corbisId+'"><img src="'+ data.map.imageHost+ 'THUMBNAIL/180/'+ data.map.path+ data.map.ext+ '" width="80" imgId="'+data.data.corbisId+'"/></a><span class="icon-font icon-8-delete"></span></li>');
			$('.jcarousel').jcarousel('reload');// 刷新灯箱
			$('.jcarousel').jcarousel('scroll', $('.jcarousel li:last')); // 灯箱滚动到尾端
			
			$('.galleryWrap .galleryThumb .imgWrap img[imgId='+_imgId+']').parents('.galleryThumb').addClass('lightBoxed'); // 搜索结果的小图显示灰色背景 标志已收藏
			$('.picDetailWrap').addClass('lightBoxed');
			
			// 当前灯箱的 收藏数+1
			var currentNum=$('.jcarousel ul li').length;
			$('.selectValue span.num').html(currentNum);
			$('.selectWrap ul li.active span.num').html(currentNum);
			
			resetLightBoxed();
			
			loadimg(curLightBoxid);
		}
		else if(data.error == 401)
		{
			//popUp(123);
			//alert("请先登录");
			window.open("login", "_self");
		}
		else if(data.error == 600)
		{
			alert("该图片已添加");
		}
	},'json')
}


function popUp(message)
{
	alert(message);
}


function DownloadAllinBox()
{
	var curLightBoxid = $(".lightBoxList").find("ul").find(".active").attr("lightboxid");
	if(curLightBoxid==undefined)
	{
		curLightBoxid = $($(".lightBoxList").find("li")[0]).attr("lightboxid");
	}
	
	//
	$.post("my/addlightboximagesdownload",{key:curLightBoxid},
			function(data){
		if(data&&data.error==0)
		{
			location.href="/"+data.url;
		}
		else if(data&&data.error==401)
		{
			//alert("请先登录");
			window.open("login", "_self");
		}
		else 
		{
			alert("请先登录");
		}
	});
}

function goLightBox()
{
	var curLightBoxid = $(".lightBoxList").find("ul").find(".active").attr("lightboxid");
	if(curLightBoxid==undefined)
	{
		curLightBoxid = $($(".lightBoxList").find("li")[0]).attr("lightboxid");
	}
	
	 
	//alert("请先登录");
	window.open("my/lightbox?lightboxId="+curLightBoxid, "_self");
		 
}
function resetLightBoxed(){
	
	
	$('.galleryWrap .galleryThumb').removeClass('lightBoxed'); 
	//$('.jcarousel ul li img').img[imgId='+_imgId+']')
	var _imgId;
	$('.jcarousel ul li img').each(function(){
		_imgId=$(this).attr('imgId');
		$('.galleryWrap .galleryThumb .imgWrap img[imgId='+_imgId+']').parents('.galleryThumb').addClass('lightBoxed'); // 搜索结果的小图显示灰色背景 标志已收藏
	});
	//$('.jcarousel ul li')
}

function loadimg (curLightBoxid){
	$('.jcarousel').addClass('loading');// 显示loading 图片
	//$('.jcarousel ul').html("");
		
	$.post(ajaxUrl_switchLightBox, {key : curLightBoxid}, function(data) {
		
		if(data.error ==0)
		{
			var oldIds = "";
			$.each($('.jcarousel ul').find("img"),function(i,n){
				oldIds+=$(n).attr("imgid");
			});
			
			var htmlData = '';
			$.each(data.data, function() {
				var eles = data.map[this.corbisId];
				if(eles != undefined)
				{
					if(oldIds.indexOf(this.corbisId) < 0)
					{
						htmlData += '<li><a href="image/'+this.corbisId+'" target="_blank"><img src="'+ eles.imageHost+ 'THUMBNAIL/180/'+ eles.path+ eles.ext+ '" width="80" imgId="' + this.corbisId + '"></a><span class="icon-font icon-8-delete"></span></li>';
						//htmlData += '<li><a href="image/'+this.corbisId+'" target="_blank"><img src="'+ eles.imageHost+ 'THUMBNAIL/'+ eles.path+ '" width="80" imgId="' + this.id + '"></a><span class="icon-font icon-8-delete"></span></li>';
					}
				}
			})

			//$('.jcarousel ul').html(htmlData); // 更新灯箱数据
			$('.jcarousel ul').append(htmlData);
			$('.jcarousel').jcarousel('reload'); // 刷新灯箱
			$('.jcarousel').removeClass('loading'); // 隐藏 加载图片
			
			resetLightBoxed();
		}
		else
		{
			//popUp(data.errorMsg);
		}
	},"json")
}

function setLigtboxImg()
{
	if($('.lightBoxWrapOut').is(':visible'))
	{
		var curLightBoxid = $(".lightBoxList").find("ul").find(".active").attr("lightboxid");
		if(curLightBoxid==undefined)
		{
			curLightBoxid = $($(".lightBoxList").find("li")[0]).attr("lightboxid");
		}
		
		$.post(ajaxUrl_switchLightBox, {key : curLightBoxid}, function(data) {
			
			if(data.error ==0)
			{
				var htmlData = '';
				
				$.each(data.data, function() {
					var eles = data.map[this.corbisId];
					if(eles != undefined)
					{
						//htmlData += '<li><a href="image/'+this.corbisId+'" target="_blank"><img src="'+ eles.imageHost+ 'THUMBNAIL/'+ eles.path+ '" width="80" imgId="' + this.corbisId + '"></a><span class="icon-font icon-8-delete"></span></li>';
						
						//$('.galleryWrap .galleryThumb .imgWrap img[imgId='+this.corbisId+']').parents('.galleryThumb').addClass('lightBoxed'); // 搜索结果的小图显示灰色背景 标志已收藏
						
					}
				})

			}
			else
			{
				//popUp(data.errorMsg);
			}
		},"json")
	}
	else
	{
		$('.galleryWrap .galleryThumb .imgWrap ').parents('.galleryThumb').removeClass('lightBoxed');  
		
	}
}
