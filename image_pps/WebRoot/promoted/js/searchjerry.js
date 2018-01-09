var ajaxSearchUrl="search.do";
var searchUrl="search";
var issearchpage= (location.pathname.indexOf("/search")==(location.pathname.length-7));
var ajaxUrl_toolTip = 'post/toolTip.php';
/*******************************************************************************
 */


var isInitFinish=false;
/*******************************************************************************
 * 页面计时（临时）
 */
var isPageChange = 0;
var startTime = 0;
function getTime() {
	return (new Date()).valueOf();
}
function start() {
	startTime = getTime();
	$("#timer").html("");
}
function stop(name) {
	var ti = getTime() - startTime;
	var na=name?name:"";
	var str=na+":"+ti;
	if($("#timer").html()!="")
		str="|"+str;
	$("#timer").append(str);
	$("#pageSize").html(n);
}
/** ************************************ */
var n = 50;
var p = 1; // 页码
var tp = 0; // totalPage
var searchSID = (new Date()).valueOf();; // sid
var reqParas = {};
var smid; // 相似图片id
var currentData;
var pageSizeArray = [ 25, 50, 100 ];
var showType = 0; // 图片列表显示样式
var sortType = 0; // 图片列表排序方式
var isShowBigImage = true; // 是否显示悬停图
var isShowInputHelper=true;
var isPullStyle = 1; // 瀑布流0， 平铺1 ,默认平铺.
var PullStylePages = 3; // 瀑布流每多少页显示下一页
var PullStylePagesIndex = 0;// 瀑布流起点。
var PullStyleCanLoadMore = true; // 瀑布流串行控制
var cla; // 澄清ID
var groupId; // 图片组ID
var vcdId; // 虚拟CD

// JavaScript Document
var relaCids="";


var currentSize="180";//240//305
var CurDataArray=new Array();
var CurParas=new Array();


var $container;	
////////////////////////////
var leftArr = {}; // 左侧条件集合
var advArr={};//隐藏条件集合，原来的高级条件. 
var advArrKey=["cid","days","beginDate","endDate","corbisIds","photographer","location","dateCreated","provider"];
var leftfiltercount=0;
var _curLightBoxid="";

(function ( $ ) {
jQuery(document).ready(function() {

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
						var n = data.data[i];
//						var sons = privateGetSonItems(data.data,n.id);
//						myCurLightBoxs[n.id]=n;
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
						_curLightBoxid = data.data[0].id; 
						//var lightboxid = data.data[0].id;//
						//loadimg (_curLightBoxid); 
						$('.jcarousel ul').html("");
						
						$.post(ajaxUrl_switchLightBox, {key : _curLightBoxid}, function(data) {
							
							if(data.error ==0)
							{
								var htmlData = '';
								
								$.each(data.data, function() {
									var eles = data.map[this.corbisId];
									if(eles != undefined)
									{
										htmlData += '<li><a href="image/'+this.corbisId+'" target="_blank"><img src="'+ eles.imageHost+ 'THUMBNAIL/180/'+ eles.path+ '" width="80" imgId="' + this.corbisId + '"></a><span class="icon-font icon-8-delete"></span></li>';
										//htmlData += '<li><a href="image/'+this.corbisId+'" target="_blank"><img src="'+ eles.imageHost+ 'THUMBNAIL/'+ eles.path+ '" width="80" imgId="' + this.id + '"></a><span class="icon-font icon-8-delete"></span></li>';
									}
								})

								$('.jcarousel ul').html(htmlData); // 更新灯箱数据
								$('.jcarousel').jcarousel('reload'); // 刷新灯箱
								 
							}
							else
							{
								//popUp(data.errorMsg);
							}
						},"json")
					}	
					 
				} else if (data && data.error == 401) {
					//alert("请先登录");
					//
				} else {
					//alert("请先登录");
				}
			});



//-------------- left filter panel 


var selectCategory = new SelectBox($('#selectCategory'));
var selectRace = new SelectBox($('#selectRace'));
var selectAmount = new SelectBox($('#selectAmount'));
// -- 刷新页面清除选择
//if($('.pageSearch').length > 0)
//{
//	clearAllFilter();
//}


// -- 清除选择
function clearAllFilter()
{
	
	// checkbox radiobox 重置
	$('.filterPanel input[type=checkbox], .filterPanel input[type=radio]').iCheck('uncheck');
	$('.filterPanel input[type=checkbox], .filterPanel input[type=radio]').iCheck('enable');
	$('.colorCurrent').removeClass($('.colorCurrent').attr('color'));

	$('.colorCurrent').attr("color","");
	$('.colorCurrent').attr("colorvalue","");
	
	// 选择图片布局 重置
	$('.selectOne a').removeClass('active');
	
	// 下拉菜单重置 
	$('.filterPanel select').val(0);
	selectRace.enable();
	if(selectCategory.data)
	{
		selectCategory.refresh();
		selectRace.refresh();
		selectAmount.refresh(); 
		selectCategory.selectBox("value",0);
		selectRace.selectBox("value",0);
		selectAmount.selectBox("value",0);
	}
	
	$('#exclude').val('');
	$('.resultPanelInner .searchKeyWord .label').hide();
	
	
	leftArr = {}; // 左侧条件集合
	advArr={};
	leftfiltercount=0;
	PullStylePagesIndex=0;//PullStylePages;
	p=1;
	genSearchSID();
	doSearch();
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
	currentColorValue=$(this).attr("value");
	
	$('.colorCurrent').removeClass('color-'+currentColor);
	
	
	$('.colorCurrent').addClass('color-'+currentColor);
	$('.colorCurrent').attr('color',currentColor);
	$('.colorCurrent').attr('colorvalue',currentColorValue);
	
	
	$('.colorPicker .colorAdd').removeClass('icon-cross');
	$('.colorPicker .colorAdd').addClass('icon-23-plus');
	$('.colorList').removeClass('open');
	
	$('#label-selectCcolor').show();
	$('#label-selectCcolor .color').addClass('color-'+currentColor);
	
	calcCheckBox("color");
	PullStylePagesIndex=0;//PullStylePages;
	p=1;
	genSearchSID();
	doSearch();
})

// -- 删除颜色
$('.colorCurrent').click(function(){
	$('.colorCurrent').removeClass('color-'+$('.colorCurrent').attr('color'));
	$('.colorList .colorBox').removeClass('active');
	$('#label-selectCcolor .color').removeClass('color-'+$('.colorCurrent').attr('color'));
	$('#label-selectCcolor').hide();

	$('.colorCurrent').attr("color","");
	$('.colorCurrent').attr("colorvalue","");
	calcCheckBox("color");
	PullStylePagesIndex=0;//PullStylePages;
	p=1;
	genSearchSID();
	doSearch();
})


// 显示搜索选项 在搜索结果页最顶部
$('.filterPanel select').selectBox().change(function(){

	if($(this)[0].selectedIndex == 0)
	{
		$('#label-'+$(this).attr('id')).hide();
		delete leftArr[$(this).attr("name")];
	}else
	{
		$('#label-'+$(this).attr('id')).show();
		$('#label-'+$(this).attr('id')).find('.txt').html($(this).find("option:selected").html());
		
		leftArr[$(this).attr("name")]=$(this).val();
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
			
			delete leftArr["race"];
			delete leftArr["cate_id"];
			//delete leftArr["person_num"];
			
		}else
		{
			$('.offHuman input').iCheck('enable');
			selectRace.enable();
			selectRace.refresh();
		}
	}
	PullStylePagesIndex=0;//PullStylePages;
	p=1;
	genSearchSID();
	doSearch();
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
});

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
			
			leftArr[$(this).parent().attr("name")]=$(this).attr("value");
			PullStylePagesIndex=0;//PullStylePages;
			p=1;
			genSearchSID();
			doSearch();
			
		},
		function(){
			if($(this).parent().hasClass('disable'))
			{
				return;
			}
			$('#label-'+$(this).parent().attr('id')).hide();
			$(this).parent().find('a').removeClass('active');
			
			delete leftArr[$(this).parent().attr("name")];
			PullStylePagesIndex=0;//PullStylePages;
			p=1;
			genSearchSID();
			doSearch();
		}
	
	)
	

// 特别的单选按钮 再次点击时取消选择
//我觉得这里有错的。 
$('.doubleCancle').on('ifClicked',function(event){
	$(this).iCheck('uncheck')
})

// 把选择框的 结果显示在最顶端
$('.filterPanel input[type=checkbox], .filterPanel input[type=radio]')
.on('ifChecked', function(event){
	$('#label-'+$(this).attr('id')).show();
	calcCheckBox($(this).attr('name'));
}).on('ifUnchecked', function(event){
	$('#label-'+$(this).attr('id')).hide();
	calcCheckBox($(this).attr('name'));
});

$('.checkTop input[type=checkbox]')
.on('ifClicked', function(event){
	if($(this).parent().hasClass('checked'))
	{
		$(this).closest('.checkGroupWrap').find('.checkSub input[type=checkbox]').iCheck('uncheck');
	}else
	{
		$(this).closest('.checkGroupWrap').find('.checkSub input[type=checkbox]').iCheck('check');	
	}
})

$('.checkSub input[type=checkbox]')
.on('ifChecked', function(event){
	$(this).closest('.checkGroupWrap').find('.checkTop > label  input[type=checkbox]').iCheck('check');
}).on('ifUnchecked', function(event){
	if($(this).closest('.checkGroupWrap').find('.checkSub > label.checked').length <=1)
	{
		$(this).closest('.checkGroupWrap').find('.checkTop input[type=checkbox]').iCheck('uncheck');
	}
});	




$('.filterPanel .iCheck-helper')
.on("click",function(){
	PullStylePagesIndex=0;//PullStylePages;
	p=1;
	genSearchSID();
	doSearch();
});
function calcCheckBox(name)
{
//	if($("input[name="+name+"]:checked").length==$("input[name="+name+"]").length)
//	{
//		$("input[name="+name+"]").iCheck("uncheck");
//	}
	
	var values="";
	if($("input[name="+name+"]:checked").length==0)
	{
		values=",";	
	}else
	{
		$("input[name="+name+"]:checked").each(function(){
			if($(this).attr("value")&&$(this).attr("value")!="0"&&$(this).attr("value")!=-1)
				values+=","+$(this).attr("value");
		});
	}
	values=values.substr(1);
	if(values.length>0)
		leftArr[name]=values;
	else
		delete leftArr[name];
	if(name=='color')
	{
		if($('.colorCurrent').attr("colorvalue")&&$('.colorCurrent').attr("colorvalue")!='')
		{
			leftArr[name]=$('.colorCurrent').attr("colorvalue");
		}
	}
	

}
// -- 点击选择结关闭按钮 重置选择
$('.resultPanelInner .searchKeyWord').on('click','.icon-8-delete',function(){
			
	PullStylePagesIndex=0;//PullStylePages;
	p=1;

	genSearchSID();
	if($(this).parent().hasClass('label-exclude'))
	{
		$(this).parent().remove();
		var exclude="";
		$(".label-exclude").find(".txt").each(function(){exclude+=','+$(this).html();});
		leftArr["exclude"]=exclude.substr(1);
		doSearch();
	}else
	{
		var checkId=$(this).parent().attr('id').replace('label-','');
		if($('#'+checkId).is("input[type=checkbox]") || $('#'+checkId).is("input[type=radio]"))
		{
			$('#'+checkId).iCheck('uncheck');
			calcCheckBox($('#'+checkId).attr("name"));
			doSearch();
			
			
		}else if($('#'+checkId).is("select"))
		{
			$(this).parent().find('.txt').html('');
			$(this).parent().hide();
			$('#'+checkId)[0].selectedIndex = 0;
			$('#'+checkId).next('.selectBox').find('.selectBox-label').html($('#'+checkId+" option").eq(0).html());
			delete leftArr[$('#'+checkId).attr("name")];
			doSearch();
			if(checkId=='selectAmount')
				{
					$('.offHuman input').iCheck('enable');
					selectRace.enable();
					selectRace.refresh();
					$('#'+checkId).selectBox("value","");
				}
			
		}else if($('#'+checkId).hasClass('colorCurrent'))
		{
			$('.colorCurrent').removeClass('color-'+$('.colorCurrent').attr('color'));
			$('#label-selectCcolor .color').removeClass('color-'+$('.colorCurrent').attr('color'));
			$('#label-selectCcolor').hide();

			$('.colorCurrent').attr("color","");
			$('.colorCurrent').attr("colorvalue","");
			calcCheckBox("color");
			doSearch();
			
		}else if( $('#'+checkId).hasClass('selectOne') )
		{
			$('#'+checkId).find('a').removeClass('active');			
			$(this).parent().hide();
			calcCheckBox($('#'+checkId).attr("name"));
			doSearch();
		}
		
	}
	
})

// -- 排除关键字
$('.excludeWrap a.btnAdd').click(function(){

	if($('.excludeWrap input').val() != "")
	{
		setExclude($('.excludeWrap input').val());
		$('.excludeWrap input').val('');
		PullStylePagesIndex=0;//PullStylePages;
		p=1;
		genSearchSID();
		doSearch();
	}
})

function setExclude(word)
{
	var newLabel='<div class="label label-exclude"><span class="icon-font icon-8-delete"></span><span class="txt">'+word+'</span></div>';
	$('.searchKeyWord').append(newLabel);
	$('.label-exclude').show();
	var exclude="";
	$(".label-exclude").find(".txt").each(function(){exclude+=','+$(this).html();});
	leftArr["exclude"]=exclude.substr(1);
}
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
	
	setTimeout(function(){$container.masonry();},600);
})

//-------------- end left filter panel 


//-------------- search result

$("select[name='sortType']").bind("change",function(){
	
	setSortType();
});
// -- 是否打开详细布局
$('.toggleDetail').click(setPageType);

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
	setShowPreview();
})

// -- 切换三种浏览布局
$('.picLayoutWrap a').click(function(){
	setPullStyle($(this).index());
})



// 瀑布流

var interValClear=true;
function InitContainer(){
if( $('.galleryWrap').length > 0)
{
	if($container)
		{
		$container.masonry("destroy");
		$('.galleryWrap').css({"height":"0px"});
		}
	$('.searchResultFooter').hide();
	$container= $('.galleryWrap').masonry({
		itemSelector : '.galleryWrap .galleryThumb',
		isAnimated: false
	});
	
//	$container.imagesLoaded( function() {
//	  $container.masonry();
//	});
	$('.galleryWrap').infinitescroll("destroy");
	
	/*
	 主要逻辑：
	 先把图片隐藏css  等图片排好位置再显示 line 671. 同类逻辑的代码 再ajax新的图片时也要进行一次 line 703- 716
	 1. 图片加载过程中 每隔0.3s 排一下位置， 没有加载的图片不排位置
	 2. 图片加载成功 排好位置 显示出来
	 
	 interValClear 时间间隔是否到了
	 attr:loading 图片是否加载中
	*/
	$('.galleryWrap .galleryThumb img').attr('loading','true');
	$('.galleryWrap .galleryThumb img').one('load',function() {
		
		$(this).attr('loading','false');
		if(interValClear==true)
		{
			interValClear=false;
			window.setTimeout(function(){
				interValClear=true;
				//console.log('tes');
				$container.masonry();
				$('.galleryWrap .galleryThumb img[loading="false"]').css('opacity',1);
			},300);
		}
	})
	
	
	
	$('.galleryWrap').infinitescroll({

		navSelector  	: "#loadMore:last",
		nextSelector 	: "a#loadMore:last",
		itemSelector 	: ".galleryThumb",
		behavior: 'local',
 		msgText  :'',
		finishedMsg     : "" ,
		debug		 	: false,
		dataType	 	: 'jerry',
		maxPage         : PullStylePages,
		path: function(index) {
			return index;//gallery" + index + ".html";
		},
		errorCallback: function(){
			PullStylePagesIndex=0;
			$('.searchResultFooter').show();
		}
	},function(newElements, data, url,callback){
		//alert(url+":"+p);
		if((url-1)%PullStylePages==0)
		{
			if(callback)
				callback("error");
			return;
		}
		nextPage(callback);
	});
}
}


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
		offsetX:-0,
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
				
				var item=CurDataArray[origin.find("img").attr("imgid")];
				
				var htmlData='';
				if(item)
				{
						htmlData='<div class="picDetailWrap '+imgLightBoxedClass+'"><div class="imgWrap"><img src="'+item.imageHost+'HOVER/'+item.storageId+'/'+item.path+'" imgid="'+item.corbisId+'" /></div><div class="picCont"><div class="tag"><span>'+(item.licenseType == 2 ? "RM" : "RF")+'</span>';
						var scn ="";
						if(item.scn != null)
						{
							scn =item.scn;
						}
						htmlData+= scn+'</div>';
						if(item.title != null)
						{
							htmlData+= '<div class="header">'+item.title+'</div>';
						}
						htmlData+= '<div class="picInfo">图片编号: '+item.corbisId+'';
						if(item.photographerName != null)
						{
							htmlData+='<br/>摄影师  '+item.photographerName+'';
						}
						htmlData+='<br/>专辑名字  '+item.collectionName+' <br/></div>';
						
//						htmlData+='<a href="#" class="btnPurple btnShopCart btn-block" style="display:none">加购物车</a>';
						
//						if(item.priType==0){
//							htmlData+='<div class="btnWrap iconWrap"><a href="javascript:void(0)" onclick="DownloadImage(\''+item.corbisId+'\');" class="icon-font icon-22-download"></a>'; // 下载
//						}else if(item.priType==3){
//							htmlData+='<div class="btnWrap iconWrap"><a href="javascript:void(0)" onclick="DownloadImageSepc(\''+item.corbisId+'\');" class="icon-font icon-31-shoppingCart2"></a>';// 旗帜下载
//						}
//						else
//						{
//							htmlData+='<div class="btnWrap iconWrap"><a href="login"  class="icon-font icon-22-download"></a>'; // login
//						}
						htmlData+='<div class="btnWrap iconWrap btns2">';
						htmlData+='<a href="javascript:void(0)" class="icon-font icon-11-favourite"></a>';
						htmlData+='<a href="javascript:void(0)" onclick="FindSameImage(\''+item.corbisId+'\');" class="icon-font icon-29-search2"></a></div></div></div>';
				}
				origin.tooltipster('content', htmlData).data('ajax', 'cached');
				$('.tooltipster-default').css('background','none');
				
				if(origin.parent('.galleryThumb').attr("class").indexOf("lightBoxed")>-1)
				{
					$('.picDetailWrap').addClass('lightBoxed');
				}
//				else
//				{
//					
//				}
			}
		}
	});
	if(!$('body').hasClass('globalPreview'))
	{
		$('.galleryWrap .galleryThumb .imgWrap').tooltipster('disable');
	}
}

// -------------- search result
function doSearch(callback)
{
	isPageChange= 1; 
	trueSearch(callback);
}


function trueSearch(callback)
{
	if(!isInitFinish)
		return;
	// //////////////////////////////////////////////////////////
	isInitFinish=false;

	$(".galleryWrap").show();
	$(".searchNoResult").hide();
	
	
	start(); 
	setHash();
	$.cookie('q', $("#q").val()); // 将查询内容放入cookie

	var url = ajaxSearchUrl;//location.pathname+".do";
	var paras = location.hash;
	if (paras) {
		paras = "?" + paras.substring(1);
	}
	PullStyleCanLoadMore = false;
	$.ajax({
		type : "POST",
		url : url + paras,// "search",
		data : reqParas,// {'key':$("#q").val(), 'n':n, 'ssid':searchSID},
		dataType : "json",
		success : function(data) {
			//currentData={};
			if (data.success) {
				currentData = data;
				if (data.total > 0) {
					currentData = data;
					showImages();
					setPageNum();
					if (data.claList && data.claList.length > 0) {
						//showClearTips();
						showClearword();
					} else {
						hideClearword();
					}
					
				} else {
					//onSearchErrorEvent("result is empty!");
					setPageNum();
					
					if(canEmpty())
						{
					$(".galleryWrap").html("");
					$(".galleryWrap").hide();
					$(".searchNoResult").show();
					$(".searchResultFooter").hide();
						}
					
					
				}
				
				//guopeng 20141219 for simierPic
				if(data.simId != null)
				{
					//------------------这些代码是应该是控制偏移量的,无法获取图片宽度而无法使用---------------------------
//					var $img = $(this).closest('.galleryThumb').find('img');
//					var imgId= $img.attr('imgId');
//					var paddingLeft= ($img.width()*92/$img.height()) +30;
//					if(paddingLeft > 170)
//					{
//						paddingLeft= 170;
//					}
					//---------------------------------------------
					
					$('.mlt-image').stop().fadeIn();
					var url = data.simUrl;
					//.split("THUMBNAIL")[0]+"THUMBNAIL/180"+data.simUrl.split("THUMBNAIL")[1];
					$('.mlt-image img').attr('src',url);
					$('.mlt-image img').attr('max-width',"150px");
					$('.searchFiled').css('paddingLeft',150);
					$('.mlt-image').css('width',"auto");
					//$('.mlt-image').css('width',paddingLeft - 30);
					

					$('.mlt-image .icon-8-delete').click(function(){
						
						$('.mlt-image').stop().hide();
						$('.mlt-image img').attr('src','');
						$('.searchFiled').css('paddingLeft',40);
						$('.mlt-image').css('width',0);
						smid="";
						
					})

				}
				else //清除图片
				{
					$('.mlt-image').stop().hide();
						$('.mlt-image img').attr('src','');
						$('.searchFiled').css('paddingLeft',40);
						$('.mlt-image').css('width',0);
						smid="";
				}

			} else {
				//onSearchErrorEvent("search failed; data error");
				
				if(canEmpty())
				{
				
				$(".galleryWrap").html("");
				$(".galleryWrap").hide();
				$(".searchNoResult").show();
				
				}
				
			}
			setTimeout(function(){PullStyleCanLoadMore = true;},1000);
			if($.isFunction(callback)===true)
			{
				callback(data);
			}
			//增加灯箱图片阴影
			setLigtboxImg();
			isInitFinish=true;
		},
		failed : function() {
			endLoading();
			//onSearchErrorEvent("search failed;system exception");
			setTimeout(function(){PullStyleCanLoadMore = true;},1000);
			isInitFinish=true;
		}
	});
}

function onSearchErrorEvent(msg)
{
//	$(".groupDetailsContainer").hide();
//	$("#picbox_center").empty();
//	$("#picbox_center").append($(".divforerror").clone());
//	$("#picbox_center .divforerror .msg").html(msg);
//	$("#picbox_center .divforerror").show();
//	$(document).scrollTop();
	alert(msg);
	PullStylePagesIndex=0;
	resetPara();
	$('.galleryWrap').infinitescroll("destroy");
}



var canEmpty=function(){
//	if($(".picLayoutWrap a").eq(0).hasClass("active"))
//		
//	return true;
	return PullStylePagesIndex%PullStylePages==0;
}
function showImages()
{
	if(canEmpty())
    {
		$(".galleryWrap").empty();
		$('.galleryWrap').css({"height":"0px"});
		CurDataArray = new Array();
		relaCids="";
		$('body,html').animate({
			scrollTop : 0
		}, 1);
	}
	var htmls=new Array();
	
	
	for(var i=0;i<currentData.data.length;i++)
	{
		var item=currentData.data[i];
		CurDataArray[item.corbisId] = item;
		relaCids+=","+item.corbisId;
		var rf = item.licenseType && item.licenseType == 2 ? "RM" : "RF";
		var html='<div href="javascript:void(0);" class="galleryThumb" style="" imgid="'+item.corbisId+'">'
			+'<div class="imgWrap tooltipstered">'
			+'<a href="javascript:void(0);" onclick="goDetail($(this));" ><img src="'+item.imageHost+'THUMBNAIL/'+currentSize+'/'+item.path+'" imgid="'+item.corbisId+'" imgRealId="'+item.id+'"></a>'
			+'<div class="btnWrap"> '
			if(item.priType==0){
				html += '<a href="javascript:void(0)" onclick="DownloadImage(\''+item.corbisId+'\');" class="icon-font icon-22-download"></a>'; // 下载
			}else if(item.priType==3){
				html += '<a href="javascript:void(0)"  onclick="DownloadImageSepc(\''+item.corbisId+'\');" class="icon-font icon-31-shoppingCart2"></a>'; // 旗帜
			}
		//html+='<a href="javascript:void(0)" class="icon-font icon-22-download"></a> '
			//+'<a href="javascript:void(0)" class="icon-font icon-31-shoppingCart2"></a> '
			html+='<a href="javascript:void(0)"   class="icon-font icon-11-favourite"></a> '
			+'<a href="javascript:void(0)" onclick="FindSameImage(\''+item.corbisId+'\');"  class="icon-font icon-29-search2"></a> '
			+'</div>'
			+'</div>'
			+'<div class="thumbDetail">'
			+rf+' <br/>'+item.corbisId+'<br/><a href="javascript:void(0)">'+item.scn+'</a>   /   <a href="javascript:void(0)" target="_blank" cid="'+item.collectionId+'">'+item.collectionName+'</a><br/>';
			if(item.title&&item.title!="")
				html+=item.title+'<br/>'
			if(item.location&&item.location!="")
				html+=item.location+'<br/>'
			if(item.photo_date&&item.photo_date!="")
				html+=item.photo_date+'<br/>'
			else if(item.photo_date_des&&item.photo_date_des!="")
				html+=item.photo_date_des+'<br/>'
			html+='<div class="btnWrap"> ';
			//以下二个是二选一的。 
			if(item.priType==0){
				html += '<a href="javascript:void(0)" onclick="DownloadImage(\''+item.corbisId+'\');" class="icon-font icon-22-download"></a>'; // 下载
			}else if(item.priType==3){
				html += '<a href="javascript:void(0)"  onclick="DownloadImageSepc(\''+item.corbisId+'\');" class="icon-font icon-31-shoppingCart2"></a>'; // 旗帜
			}
			//+'<a href="javascript:void(0)" class="icon-font icon-22-download"></a> '
			//+'<a href="javascript:void(0)" class="icon-font icon-31-shoppingCart2"></a> '
			html+='<a href="javascript:void(0)"   class="icon-font icon-11-favourite"></a> '  //onclick="addToLightBox(\''+item.corbisId+'\');"
			+'<a href="javascript:void(0)" onclick="FindSameImage(\''+item.corbisId+'\');" class="icon-font icon-29-search2"></a> '
			+'</div>'
			+'</div>'
			+'</div>';
		htmls.push($(html)[0]);
	}

	
	
	if(canEmpty()===true)
    {
		$(".galleryWrap").append(htmls);
		InitContainer();
		
    }else
    {
    	var len=$(".galleryWrap .galleryThumb").length;
    	$(".galleryWrap").append(htmls);
    	var $neweles=$(".galleryWrap .galleryThumb").slice(len);
    	$neweles.show();
    	
    	$container.masonry( 'appended', $neweles );

    	$neweles.find('img').attr('loading','true');
    	$neweles.find('img').one('load',function() {
    		$(this).attr('loading','false');
    		if(interValClear==true)
    		{
    			interValClear=false;
    			window.setTimeout(function(){
    				interValClear=true;
    				$container.masonry();
    				$neweles.find('img[loading="false"]').css('opacity',1);
    			},300);
    		}
    	})
    }
	
	enableToolTips();
	if(resetLightBoxed)
	resetLightBoxed();
	
	PullStylePagesIndex++;
}

$("#q").keydown(function(event){
	var keyCode = event.keyCode;
	if(keyCode==13){
		if(true)
			{
			
			if(issearchpage===true)
				{
			resetPara();
			doSearch();
				}
			else
				{
				location.href=searchUrl+"#q="+encodeURIComponent($("#q").val());
				}
			}
	}
});
$("#q").next("a").click(function(){
	if(issearchpage===true)
	{
	p=1;
	PullStylePagesIndex=0;
	resetPara();
    doSearch();
    }
	else
	{
	location.href=searchUrl+"#q="+encodeURIComponent($("#q").val());
	}
 });

///////////////////////////////////////////////////////////////////////////////
$(".pagination-sm .icon-1-arrowLeft").bind("click",function(){
	PullStylePagesIndex=0;
	prevPage();
	});
$(".pagination-sm .icon-2-arrowRight").bind("click",function(){
	PullStylePagesIndex=0;
	nextPage();
	});
$(".pagination-sm").find("input").keydown(function(event){
	var keyCode = event.keyCode;
	if(keyCode==13){
		PullStylePagesIndex=0;
		go2Page($(this));
	}
});


$(".pageNumWrap .btnPrev").bind("click",function(){
	PullStylePagesIndex=0;
prevPage();});
$(".pageNumWrap .btnNext").bind("click",function(){
	PullStylePagesIndex=0;
	nextPage();
	});
$(".pageNumWrap").find("input").keydown(function(event){
	var keyCode = event.keyCode;
	if(keyCode==13){
		PullStylePagesIndex=0;
		go2Page($(this));
	}
});
////////////////////////////////////////////////////////////////////////////////



























function doHistory(){
	if(isPageChange == 0)
	{
		setPageDefault();
		trueSearch();
	}
	else
		{isPageChange = 0;}
}

function resetPara(){
	advArr={};
	genSearchSID();
	PullStylePagesIndex=0;//PullStylePages;
	//smid = ""; smid除外。 诡异. 141220 jz. 
	p = 1;
	hideClearword();
	groupId = 0;
	vcdId = 0;
}
function InitLeftCheckBox(allvs){
	leftArr = {};
	advArr={};
	if (allvs) {
		$.each(allvs, function(n, v) {
			if(!v||v==''||v=='0')
				return;
			if(n=='q'||n=='p')
				return;
			
			
			if(n=="photographer")
			{
				advArr[n]=v;
				return;
			}
			leftArr[n]=v;
			
			
			if(n=="color")
			{
				if(v=="10"||v=="9")
				{
					$("input[name="+n+"]").each(function(){
						if(v==$(this).attr("value"))
						{
							$(this).iCheck('check');
							if($(this).attr('id'))
							{
								$('#label-'+$(this).attr('id')).show();
								$('#label-'+$(this).attr('id')).find('.txt').html($(this).attr("value"));
							}
						}
					});
				}else if(v!="")
				{
					$('.colorList .colorBox').each(function(){
						if(v==$(this).attr("value"))
						{
							$(this).click();
						}
					});
				}
			}
			if(n=="exclude")
			{
				leftArr[n]='';
				var exclude=v.split(',');
				$.unique(exclude);
				$.each(exclude,function(i,n){
					setExclude(n);
				});
			}else if($("input[name="+n+"]").length>0)
			{
				$("input[name="+n+"]").each(function(){
					if(v.indexOf($(this).attr("value"))>=0)
					{
						$(this).iCheck('check');
						if($(this).attr('id'))
						{
							$('#label-'+$(this).attr('id')).show();
							$('#label-'+$(this).attr('id')).find('.txt').html($(this).attr("value"));
						}
					}
				});
			}else if($("select[name="+n+"]").length>0)
			{
				var item=$("select[name="+n+"]");
				item.selectBox("value",v);
				if(item.attr('id'))
				{
					$('#label-'+item.attr('id')).show();
					$('#label-'+item.attr('id')).find('.txt').html(item.find("option:selected").html());
				}
			}else if($(".selectOne[name="+n+"]").length>0)
			{
				var item=$(".selectOne[name="+n+"]");
				item.find('a').removeClass('active');
				item.find('a').each(function(){
					if($(this).attr("value")==v)
					{
						$(this).click();//.addClass('active');
						
					}	
				});
				
				$('#label-'+item.attr('id')).show();
				$('#label-'+item.attr('id')).find('.txt').removeClass('icon-24-position1 icon-25-position2 icon-26-position3 icon-27-position4 icon-28-position5');
				$('#label-'+item.attr('id')).find('.txt').addClass(item.find('a.active').attr('class'));
			}else
			{
				delete leftArr[n];
			}
		});
	}
	
	isInitFinish=true;
}
function setPageDefault() {
	// 设置查询ID
	genSearchSID();
	var allVars = getUrlArgs();
	if (InitLeftCheckBox) {
		InitLeftCheckBox(allVars);
	}
	advArr={};
	for(var i=0;i<advArrKey.length;i++)
	{
		if(allVars[advArrKey[i]])
			advArr[advArrKey[i]]=allVars[advArrKey[i]];
	}
	
	// 关键词
	try {
		$("#q").val(decodeURIComponent(allVars['q'] || ''));
	} catch (e) {
		$("#q").val($.cookie('q') || '');
	}
	// 设置相似图片ID
	smid = allVars['smid'] || '';
	if ($("#q").val() != '' && smid!='0') {
		//smid = '';
		//jz add. 
	}
	// 设置澄清
	cla = allVars['cla'] || '';
	// 设置图片组、虚拟CD
	groupId = allVars['groupId'] || 0;
	vcdId = allVars['vcdId'] || 0;

	// 页码
	p = allVars['p'] || p;
	$("#p").val(p);$("#p2").val(p);
	

	initPageSize();
	initPageType();
	initShowPreview();
	initPullStyle();
	initSortType();
	initInputHelper();
}

function setHash() {
	leftfiltercount=0;
	$(".searchKeyWord .label").each(function(){
		if($(this).css("display")!='none')
			leftfiltercount++;
	});
	
	reqParas = {};
	reqParas['key'] = $("#q").val();
	reqParas['n'] = n;
	reqParas['ssid'] = searchSID;
	var hashStr = "#";
	var q = $.trim($("#q").val());
	if (q && q.trim().length > 0) {
		hashStr += "q=" + encodeURIComponent(q) + "&";
		if(smid!='0'){
			//smid = '';
			//jz add. 
		}
	} 
	if(smid && smid!='' && smid!='0') {
		hashStr += "smid=" + smid + "&";
	}
//	if(smid && smid=='0'){
//		hashStr += "smid=" + smid + "&";
//	}

	if (cla && cla != '') {
		hashStr += "cla=" + cla + "&";
	}
	if(groupId){
		hashStr += "groupId=" + groupId + "&";
	}
	if(vcdId){
		hashStr += "vcdId=" + vcdId + "&";
	}
	try {
		if (leftArr) {
			$.each(leftArr, function(i, n) {
				if(n&&n!='')
					hashStr += i + "=" + n + "&";
			});
		}
	} catch (e) {
	}
	try {
		if (advArr) {
			$.each(advArr, function(i, n) {
				hashStr += i + "=" + n + "&";
				if (i == 'in') {
					reqParas['corbisIds'] = n;
				} else if (i == 'photographer') {
					reqParas['photographerName'] = n;
				} else if (i == 'location') {
					reqParas['locationName'] = n;
				}else if(i=='dateCreated'){
					reqParas['photoDate'] = n;
				}
				else if(i=='provider'){
					reqParas['providerName'] = n;
				}
			});
		}
	} catch (e) {
	}

	hashStr += "p=" + p;
	
	$.cookie("shash",hashStr);
	location.hash = hashStr;
	var num = 0;
	for(var each in reqParas){
        num++;
    }
	if(hashStr.indexOf('&')<0 && num<=3){
		reqParas['index'] = 1;
	}
	if(sortType && sortType>0){
		reqParas['sortType'] = sortType;
	}
	if(smid && smid!=''){
		reqParas['sortType'] = 4;
	}
}

function setPageNum() {
	if (currentData) {
		if(currentData.totalPages&&currentData.totalPages==0)
			currentData.totalPages=1;
			
		tp = currentData.totalPages;
		p = currentData.currentPage;
		
		var totalformated=parseFloat(currentData.total).toLocaleString();
		if(currentData.total>=1000000)
			totalformated="1,000,000+";
//		
//		$(".tp_class").html(tp);
//		$(".p_class").val(p);
//		$("#searchNum").html('' + totalformated);
//		$("#searchResultKey").html('' + $("#q").val());

		$(".pagination-sm").find("input").val(p);
		$(".pageNumWrap").find("input").val(p);
		
		$(".pageNumWrap .btnNext .left").html("/  "+tp+" ");
		$(".pageNo").html(tp);
		
		$(".searchToolBar span.Source-Han-Normal").eq(0).html('"' + $("#q").val()+'"');
		$(".searchToolBar span.Source-Han-Normal").eq(1).html(totalformated);
	}else
	{
		tp=0;
		p=1;
		$(".pagination-sm").find("input").val(p);
		$(".pageNumWrap").find("input").val(p);
		
		$(".pageNumWrap .btnNext .left").html("/  "+tp+" ");
		$(".pageNo").html(tp);
		
		$(".searchToolBar span.Source-Han-Normal").eq(0).html('"' + $("#q").val()+'"');
		$(".searchToolBar span.Source-Han-Normal").eq(1).html("0");
		
	}
}

function prevPage(cb) {
	isPageChange = 1;
	if (p > 1) {
		p--;
		doSearch(cb);
	}else{
		if(cb)
			cb("error");
	}
}

function nextPage(cb) {
	isPageChange = 1;
	if (p < tp) {
		p++;
		doSearch(cb);
	}else{
		if(cb)
			cb("error");
	}
}

function go2Page(item) {
	var toPage = item.val();
	if (toPage < 1)
		toPage = 1;
	if (toPage > tp)
		toPage = tp;
	p = toPage;
	doSearch();
}
function initPageSize()
{
	$(".picNumberWrap a").removeClass("active");
	// 设置每页显示数量
	n = $.cookie('pageSize') || n;
	for (i = 0; i < pageSizeArray.length; i++) {
		if (pageSizeArray[i] == n) {
			$(".picNumberWrap a").eq(i).addClass("active");
		}
	}
	$(".picNumberWrap a").click(function(){
		$(".picNumberWrap a").removeClass("active");
		setPageSize(pageSizeArray[$(this).index()]);
		$(this).addClass("active");
	});
}
function setPageSize(pageSize) {
	if(n==pageSize) return false;
	
	n = pageSize;
	$.cookie('pageSize', pageSize);
	PullStylePagesIndex=0;//PullStylePages;
	p=1;
	genSearchSID();
	doSearch();
	return true;
}
function checkbutton(className,tagName,value)
{
	$("."+className+" "+tagName+"").removeClass("active");
	$("."+className+" "+tagName+"").eq(value).addClass("active");
	
}

function initPageType()
{
	// 设置每页显示数量
	showType = $.cookie('showType') || showType;
	if(showType==0)
	{
		$(".toggleDetail").removeClass('active');
		$('body').removeClass('globalDetail');
		
	}else{
		
		$(".toggleDetail").addClass('active');
		$('body').addClass('globalDetail');
	}
	
}
function setPageType() {
	
		if($(".toggleDetail").hasClass('active'))
		{
			$(".toggleDetail").removeClass('active');
			$('body').removeClass('globalDetail');
			
		}else{
			
			$(".toggleDetail").addClass('active');
			$('body').addClass('globalDetail');
		}
		
		showTypeValue=$(".toggleDetail.active").length;
		showType = showTypeValue;
		$.cookie('showType', showTypeValue);
		if($container)
			$container.masonry();
		return true;
}




//生成新的查询ID
function genSearchSID() {
	PullStylePagesIndex=0;
	searchSID = (new Date()).valueOf();
}
////////////////////////////tools//////////
function getUrlArgs() {
	var args = {};
	var query = location.hash.substring(1);// 获取查询串
	var pairs = query.split("&");// 在逗号处断开
	for ( var i = 0; i < pairs.length; i++) {
		var pos = pairs[i].indexOf('=');// 查找name=value
		if (pos == -1)
			continue;// 如果没有找到就跳过
		var argname = pairs[i].substring(0, pos);// 提取name
		var value = pairs[i].substring(pos + 1);// 提取value
		args[argname] = value;// 存为属性
	}
	return args;// 返回对象
}

//点击澄清后初始化
function showClearword() {
	if (!currentData || !currentData.claList)
		return;
	
	$(".searchResultFooter .clearworddiv").empty();
	
	//具体的意思可能是 <a class="searchLabel" href="javascript:void(0)">大自然</a><a class="searchLabel" href="javascript:void(0)">大自然</a>
	$(".searchResultFooter .clearworddiv").show();
	if (currentData.claList[0]) {
		$(".searchResultFooter .clearworddiv").append("具体的意思可能是");
	}
	var selectedCla = cla || "";
	for (i = 0; i < currentData.claList.length; i++) {
		$(".searchResultFooter .clearworddiv").append('<a class="searchLabel" href="javascript:void(0)"  value="' 
				+ currentData.claList[i].id
				+ '" querykey="'+currentData.claList[i].queryKey+'">'
				+ currentData.claList[i].items + '</a>');
	}
	
	$(".searchResultFooter .clearworddiv a").click(function(){
		
		cla = $(this).attr("value");
		$("#q").val($(this).attr("querykey"));
		q=$(this).attr("querykey");
		genSearchSID();
		doSearch();
	});
	
}

function hideClearword() {
	cla = "";
	$(".searchResultFooter .clearworddiv").hide();
}
function submitclearword() {
//	var ids = '';
//	$('.searchimformationboxlistdiv input:checked').each(function(i, n) {
//		ids += n.value + ',';
//	});
//	if (ids.length > 0) {
//		ids = ids.substring(0, ids.length - 1);
//	}
//	cla = ids;
//	genSearchSID();
//	doSearch();
}
//对未使用过澄清的用户，并且关键词需要澄清时调用一次以下方法
function showClearTips() {
	// 判断cookies ,然后显示.
	var sf = $.cookie('sf');
	if (!sf) {
		boxshowkeepfornote('searchimformationbox');
	}
}

function hiddenClearTips() {
	$.cookie('sf', "1");
}

function showkeynote() {
	// 判断cookies ,然后显示.
	var sf = $.cookie('kn');
	if (!sf) {
		boxshowkeepfornote('searchimformationboxkeynote');
	}
}
function hiddenkeynote() {
	$.cookie('nk', "1");
}


function showinputhelper() {
	// 判断cookies ,然后显示.
	var sf = $.cookie('ih');
	if (!sf||sf==1) {
		boxshow('searchimformationboxinputhelper');
	}
}
function hiddeninputhelper() {
	//$.cookie('ih', "0");
}

function initInputHelper() {
	// 判断cookies ,然后显示.
	var sf = $.cookie('ih');
	if (!sf) {
		$.cookie('ih', 1);
		sf = 1;
	}
	// 处理灵异的风格，
	$(".menushow-yulan input[name='caninputhelper']").iCheck("uncheck", null);
	$(".menushow-yulan input[name='caninputhelper']").iCheck("check", null);
	if (sf == 1)
		$(".menushow-yulan input[name='caninputhelper']").iCheck("check", null);
	else
		$(".menushow-yulan input[name='caninputhelper']").iCheck("uncheck", null);
	isShowInputHelper = ($(".menushow-yulan input[name='caninputhelper']:checked").length == 1);
}
function setInputHelper(v) {
	if(v!=undefined)
	{
		if(v==1)
		{
			$.cookie('ih',1);
			$(".menushow-yulan input[name='caninputhelper']").iChceck("check");
		}else
		{
			$.cookie('ih',0);
			$(".menushow-yulan input[name='caninputhelper']").iChceck("uncheck");
		}
	}
	else
	{
	$.cookie('ih',
					$(".menushow-yulan input[name='caninputhelper']:checked").length);
	isShowInputHelper = ($(".menushow-yulan input[name='caninputhelper']:checked").length == 1);

	}
}

function initShowPreview() {
	// 判断cookies ,然后显示.
	var sf = $.cookie('sp');
	if (!sf) {
		$.cookie('sp', 0);
		sf = 0;
	}
	// 处理灵异的风格，
	if (sf == 1)
		{
		$(".togglePreview").addClass("active");
		$('body').addClass('globalPreview');
		$('.galleryWrap .galleryThumb .imgWrap').tooltipster('enable');
		}
	else
		{
		$(".togglePreview").removeClass("active");
		$('body').removeClass('globalPreview');
		$('.galleryWrap .galleryThumb .imgWrap').tooltipster('disable');
		}
	
	isShowBigImage =$(".togglePreview").hasClass("active");
}
function setShowPreview() {
	$.cookie(
					'sp',
					$(".togglePreview.active").length);
	isShowBigImage = ($(".togglePreview.active").length == 1);
}


function initSortType() {
	// 判断cookies ,然后显示.
	var sf = $.cookie('st');
	if (!sf) {
		$.cookie('st', 0);
		sf = 0;
	}
	$("select[name='sortType']").selectBox("value",sf);
	sortType =sf;
}
function setSortType() {
	sortType=$("select[name='sortType']").selectBox("value");
	$.cookie('st',sortType);

	PullStylePagesIndex=0;//PullStylePages;
	genSearchSID();
	p=1;
	doSearch();
}


// 是否平铺1瀑布流2
function initPullStyle() {
	// 判断cookies ,然后显示.
	var sf = $.cookie('ps');
	if (!sf) {
		$.cookie('ps', 1);
		sf = 1;
	}
	checkbutton('picLayoutWrap', 'a', sf);
	isPullStyle = sf; // 瀑布流0， 平铺1 ,2小图. 默认平铺.
	{// 设置每页显示数量
		n = $.cookie('pageSize') || n;
		for (i = 0; i < pageSizeArray.length; i++) {
			if (pageSizeArray[i] == n) {
				checkbutton('picNumberWrap', 'a', '' + i);
			}
		}
	}
	
	var v=isPullStyle;
	var index=parseInt(v)+1;
	
	$('body').removeClass('layout1 layout2 layout3');
	$('body').addClass('layout'+index);
	
	
	$('.picLayoutWrap a').removeClass('active');
	$('.picLayoutWrap a').eq(v).addClass('active');
	
	if(v==0)
		currentSize="305";
	else if(v==1)
		currentSize="240";
	else
		currentSize="180";
	
}

function setPullStyle(v) {
	var isChange = false;
	$.cookie('ps', v);
	isPullStyle = v; // 瀑布流0， 平铺1 ,默认平铺.
	PullStylePagesIndex = 0;
	{// 设置每页显示数量
		n = $.cookie('pageSize') || n;
		for (i = 0; i < pageSizeArray.length; i++) {
			if (pageSizeArray[i] == n) {
				checkbutton('picNumberWrap', 'a', '' + i);
			}
		}
	}
	
	var index=parseInt(v)+1;
	
	$('body').removeClass('layout1 layout2 layout3');
	$('body').addClass('layout'+index);
	
	
	$('.picLayoutWrap a').removeClass('active');
	$('.picLayoutWrap a').eq(v).addClass('active');
	
	if(v==0)
		currentSize="305";
	else if(v==1)
		currentSize="240";
	else
		currentSize="180";
	
	
	PullStylePagesIndex=0;//PullStylePages;
//	p=1;
//	genSearchSID();
	
	doSearch();
	
//	if($container)
//		setTimeout(function(){$container.masonry();},600);
}










$(document).ready(function() {
	setPageDefault();
	
//
//	if (documentReadyAdv) {
//		documentReadyAdv();
//	}
//	leftDocumentReady();
//	setPageDefault();
//	search();
//	InitScorllEvent();
	doSearch();
	window.onhashchange = doHistory;
});


$(".btnSearchByCids").click(function(){
	var paras="#corbisIds="+encodeURIComponent($("textarea.textareaSearchByIndex").val());
	//alert(paras);
	location.href=searchUrl+paras;
});
$(".btnsearchByAdv").click(function(){
	var formarr=$("form.advform").serializeArray()
	var arr={};
	$.each(formarr,function(k,v){
		if(!arr[v.name])
			arr[v.name]=v.value;
		else
			arr[v.name]=arr[v.name]+","+v.value;
		}
	);
	
	var paras="#";//+encodeURIComponent($("textarea.textareaSearchByIndex").val());
	var uncodekey="direction,type,color,cate_id,cid,photographer,";
	$.each(arr,function(k,v){
		if(uncodekey.indexOf(k+",")>=0)
			paras+=""+k+"="+v+"&";//encodeURIComponent(v)
		else
			paras+=""+k+"="+encodeURIComponent(v)+"&";//encodeURIComponent(v)
	});
	$(".selectOne a").each(function(){
		if($(this).hasClass("active"))
			paras+=""+$(this).parent().attr("name")+"="+encodeURIComponent($(this).attr("value"))+"&";
	});
	//alert(paras);
	//return;
	location.href=searchUrl+paras;
});

});
}( jQuery ));




//qp小样图下载
function DownloadImage(elesid,base)
{
	var b="";
	if(base&&base.length>0)
		b=base;
	location.href = b+"dl/getImg.do?type=0&corbisId="+elesid;
}
//特殊小样图下载, 对应订阅计划
//跟qp显示时二选一
//下在时需要计数. 
function DownloadImageSepc(elesid,base)
{
	var b="";
	if(base&&base.length>0)
		b=base;
	location.href = b+"dl/getImg.do?type=3&corbisId="+elesid;
}

function goDetailByCid(cid,base)
{
	var b="";
	if(base&&base.length>0)
		b=base;
	
	
	var relaids=relaCids;
	var url=b+"imagesflow/"+cid+"#rids="+relaids;
	window.open(url, "_blank");
	//location.href=url;
}
function goDetail(item,base)
{
	var b="";
	if(base&&base.length>0)
	b=base;
	var cid=item.find("img").attr("imgid");
	var relaids=relaCids;
	var url=b+"imagesflow/"+cid+"#rids="+relaids;
	window.open(url, "_blank");
	//location.href=url;
}


function FindSameImage(imageid) {
	
	window.open("search#smid="+imageid+"&p=1", "_blank");
	
}


function popUp(message)
{
	alert(message);
}

