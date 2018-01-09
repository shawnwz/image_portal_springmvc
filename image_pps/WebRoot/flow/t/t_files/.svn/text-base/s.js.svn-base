/*******************************************************************************
 * 页面计时（临时）
 */

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
var searchSID; // sid
var reqParas = {};
var smid; // 相似图片id
var currentData;
var pageSizeArray = [ 25, 50, 100, 200 ];
var showType = 1; // 图片列表显示样式
var sortType = 0; // 图片列表排序方式
var isShowBigImage = true; // 是否显示悬停图
var isPullStyle = 1; // 瀑布流0， 平铺1 ,默认平铺.
var PullStylePages = 5; // 瀑布流每多少页显示下一页
var PullStylePagesIndex = 0;// 瀑布流起点。
var PullStyleCanLoadMore = true; // 瀑布流串行控制
var cla; // 澄清ID
var groupId; // 图片组ID
var vcdId; // 虚拟CD

$(document).ready(function() {
	if (documentReadyAdv) {
		documentReadyAdv();
	}
	leftDocumentReady();
	setPageDefault();
	search();
	InitScorllEvent();
});

$(window).keydown(function(event) {
	var keyCode = event.keyCode;
	if (keyCode == 13) {
		if ($("#q").is(":focus")) {
			resetPara();
			search();
		} else if ($("#p").is(":focus")) {
			go2Page($("#p"));
		}else if ($("#p2").is(":focus")) {
			go2Page($("#p2"));
		}
	} else if (keyCode == 37 || keyCode == 39) {
		if (!$("#q").is(":focus") && !$("#p").is(":focus")&& !$("#p2").is(":focus")) {
			if (keyCode == 37) {
				prevPage();
			} else {
				nextPage();
			}
		}
	}
});

function resetPara(){
	genSearchSID();
	smid = "";
	p = 1;
	hideClearword();
	groupId = 0;
	vcdId = 0;
}

function setPageDefault() {
	// 设置查询ID
	genSearchSID();
	var allVars = getUrlArgs();
	if (InitLeftCheckBox) {
		InitLeftCheckBox(allVars);
	}
	// 关键词
	try {
		$("#q").val(decodeURIComponent(allVars['q'] || ''));
	} catch (e) {
		$("#q").val($.cookie('q') || '');
	}
	// 设置相似图片ID
	if ($("#q").val() == '') {
		smid = allVars['smid'] || '';
	}
	// 设置澄清
	cla = allVars['cla'] || '';
	// 设置图片组、虚拟CD
	groupId = allVars['groupId'] || 0;
	vcdId = allVars['vcdId'] || 0;

	// 页码
	p = allVars['p'] || p;
	$("#p").val(p);$("#p2").val(p);
	// 设置每页显示数量
	n = $.cookie('pageSize') || n;
	for (i = 0; i < pageSizeArray.length; i++) {
		if (pageSizeArray[i] == n) {
			checkbutton('menuadd', 'a', '' + i);
		}
	}

	showType = $.cookie('showType') || showType;
	checkbutton('menup', 'a', '' + showType);
	if(setPageType)
		setPageType(showType);
	

	initShowPreview();
	initPullStyle();
	initSortType();
}

function setHash() {
	reqParas = {};
	reqParas['key'] = $("#q").val();
	reqParas['n'] = n;
	reqParas['ssid'] = searchSID;
	var hashStr = "#";
	var q = $("#q").val();
	if (q && q.length > 0) {
		hashStr += "q=" + encodeURIComponent(q) + "&";
	} else if (smid && smid!='') {
		hashStr += "smid=" + smid + "&";
	}

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
				}
			});
		}
	} catch (e) {
	}

	hashStr += "p=" + p;
	location.hash = hashStr;
	var num = 0;
	for(var each in reqParas){
        num++;
    }
	if(hashStr.indexOf('&')<0 && num<=3){
		reqParas['index'] = 1;
	}
	if(sortType && sortType>0){
		if(!smid || smid =='')
			reqParas['sortType'] = sortType;
	}
}

function search() {
	$(".fullbackbox").hide();
	$(".divforselect").hide();
	
	PullStylePagesIndex++;
	// //////////////////////////////////////////////////////////
	start();
	setHash();
	$.cookie('q', $("#q").val()); // 将查询内容放入cookie
	var url = location.pathname+".do";
	var paras = location.hash;
	if (paras) {
		paras = "?" + paras.substring(1);
	}
	PullStyleCanLoadMore = false;
	startLoading();
	$.ajax({
		type : "POST",
		url : url + paras,// "search",
		data : reqParas,// {'key':$("#q").val(), 'n':n, 'ssid':searchSID},
		dataType : "json",
		success : function(data) {
			endLoading();
			if (data.success) {
				currentData = data;
				setPageNum();
				if (data.total > 0) {
					showImageList();
					if (data.claList && data.claList.length > 0) {
						showClearTips();
						showClearword();
					} else {
						hideClearword();
					}
				} else {
					alert("result is empty!");
				}
				// 滚到页顶.
				if (CanEmptyListScrollTop()==0) {
					$('body,html').animate({
						scrollTop : 0
					}, 800);
				}
				
			} else {
				alert("search failed; data error");
			}
			setTimeout(function(){PullStyleCanLoadMore = true;},1000);
		},
		failed : function() {
			endLoading();
			alert("search failed;system exception");
			setTimeout(function(){PullStyleCanLoadMore = true;},1000);
		}
	});

	

	// /////////////////////////////////////////////////////////////////
}

function setPageNum() {
	if (currentData) {
		tp = currentData.totalPages;
		p = currentData.currentPage;
		$(".tp_class").html(tp);
		$(".p_class").val(p);
		var totalformated=parseFloat(currentData.total).toLocaleString();
		$("#searchNum").html('' + totalformated);
		$("#searchResultKey").html('' + $("#q").val());
	}
}

function prevPage() {
	if (p > 1) {
		p--;
		search();
	}
}

function nextPage() {
	if (p < tp) {
		p++;
		search();
	}
}

function go2Page(item) {
	var toPage = item.val();
	if (toPage < 1)
		toPage = 1;
	if (toPage > tp)
		toPage = tp;
	p = toPage;
	search();
}

function setPageSize(pageSize) {
	if (isPullStyle == 0)
		return false;
	n = pageSize;
	$.cookie('pageSize', pageSize);
	var boxid = "addstyle";
	boxhidden(boxid);
	$("#" + boxid).parent().css("z-index", "20");
	
	search();
	return true;
}

function setPageType(showTypeValue) {
	if (showTypeValue || showTypeValue == 0) {
		showType = showTypeValue;
		$.cookie('showType', showTypeValue);
		boxhidden('addstyle')
		checkbutton('menup','a',showTypeValue);
		if(showTypeValue==0)
			changeclassname('picbox_center','picbox-notext');
		else if(showTypeValue==1)
			changeclassname('picbox_center','picbox-center');
		else if(showTypeValue==2)
			changeclassname('picbox_center','picbox-list');
		
		return true;
	}
	return false;
}

function showImageList() {
	setShow();
}

var CurDataArray = new Array();
function setShow() {
	stop("ajax");
	// 显示相似搜索预览图
	var data = currentData.data;
	$("#simimage").empty();
	if(currentData.simUrl){
		$("#simimage").append('<img src="'+currentData.simUrl+'" style="max-width: 50px;max-height: 40px;"/>');
	}
	if (CanEmptyListEmpty()==0)
	{
		$("#picbox_center").empty();
		CurDataArray = new Array();
	}
	var str ="";
	for (i = 0; i < data.length; i++) {
		var eles = data[i];
		CurDataArray["image" + eles.id] = eles;
		var rf = eles.licenseType && eles.licenseType == 2 ? "RM" : "RF";
		// on event . 
//		str += '<div class="picbox-picbox" id="divimage'
//				+ eles.id
//				+ '" gpid="'+eles.corbisId+'" imageid="'+eles.id+'" onmouseleave="hidebigimg(\'image'+ eles.id+'\');">'
//				+ '<div id="bigdivimage'
//				+ eles.id
//				+ '" class="bigimagediv" onmouseenter="showbigimg(\'image' + eles.id+'\');"><div class="bigdivimagediv">'
//				+ '</div>'
//				+ '<div id="addsearchimage'
//				+ eles.id
//				+ '" class="bigimageaddsearch"><a class="mlt_link" href="javascript:void(0);" onclick="FindSameImage('+eles.id+');">更多相似图片</a></div></div>'
//				+ '<div class="picbox-picbox-inner" >' + '<a href="image/'
//				+ eles.corbisId + '" target="_blank" class="imagelink170"><img  id="minimage'
//				+ eles.id + '" onerror="this.src=\'images/default.png\'" src="' + eles.imageHost + 'THUMBNAIL/' + eles.path
//				+ '" onmouseenter="showbigimg(\'image' + eles.id+'\');"/></a>' + '</div>';
		
		str += '<div class="picbox-picbox" id="divimage'
			+ eles.id
			+ '" gpid="'+eles.corbisId+'" imageid="'+eles.id+'">'
			+ '<div id="bigdivimage'
			+ eles.id
			+ '" class="bigimagediv"><div class="bigdivimagediv">'
			+ '</div>'
			+ '<div id="addsearchimage'
			+ eles.id
			+ '" class="bigimageaddsearch"><a class="mlt_link" href="javascript:void(0);" onclick="FindSameImage(\''+eles.corbisId+'\');">更多相似图片</a></div></div>'
			+ '<div class="picbox-picbox-inner" >' + '<a href="image/'
			+ eles.corbisId + '" target="_blank" class="imagelink170"><img  id="minimage'
			+ eles.id + '" onerror="this.src=\'images/default.png\'" src="' + eles.imageHost + 'THUMBNAIL/' + eles.path
			+ '" /></a>' + '</div>';
		str+= '<p><b>' + rf + '</b>';
		//小图标~~~
		//str += '<i class="pic-button2"></i>'; // 计算价格
		//str += '<i class="pic-button3"></i>'; // 购物车
		if (eles.isInCd)
			str += '<i class="pic-button4"></i>'; // CD
		if (eles.isInImageSet)
			str += '<i class="pic-button7"></i>'; // 图集
		str += '<i class="pic-button8" onclick="LightBox($(this));"></i>'; // 灯箱
		str += '<i class="pic-button5 on" onclick="FindSameImage(\''+eles.corbisId+'\');"></i>'; // ~~
		//以下二个是二选一的。 
		if(eles.priType==0){
			str += '<i class="pic-button6 on" onclick="DownloadImage(\''+eles.corbisId+'\');"></i>'; // 下载
		}else if(eles.priType==3){
			str += '<i class="pic-button1 on" onclick="DownloadImageSepc(\''+eles.corbisId+'\');"></i>'; // 旗帜
		}
		//小图标结束~
		str += '<br />'+eles.scn+'<br />' + eles.collectionName + '<br />'; // 图库
		str += eles.corbisId + '<br/>';
		//if(eles.title&&eles.title.length>0)
		//	str += eles.title+'<br />';
		//加了标题布局大变，暂按psd . 
		str +='</p>';
		//append textbox . 
		str += '<div class="picbox-pictext"><div>';
		if(eles.title&&eles.title.length>0)
			str += eles.title+'<br>';
		if(eles.caption&&eles.caption.length>0)
			str += eles.caption+'<br>';
		str += 	'<b>图片库: </b>'+eles.collectionName+'<br><br>';
		if(eles.photoDate&&eles.photoDate.length>0)
			str += 	'<b>拍摄日期: </b>'+eles.photoDate+'<br><br>';
		if(eles.location&&eles.location.length>0)
			str += 	'<b>地点: </b>'+eles.location+'<br><br>';
		str += '<b>肖像权同意书: </b>'+eles.modelRelease+'<br><b>';
		str += '产权同意书: </b>'+eles.propertyRelease+'<br><br>';
		if(eles.restrictionList.length>0)
			{
				str += '<font style="background:url(\'images/warn_ico.png\') no-repeat 0 center;padding-left: 20px;">Restrictions</font><br>';
				$.each(eles.restrictionList,function(i,n){
					str += '•    '+n+'';	
				});
			}
		str += '</div></div>';
		//append textbox end . 
		str += '</div>';
		
		//append . 
		if((i+1)%25==0)
		{
			$("#picbox_center").append(str);
			str="";
		}

		//bind event . 
//		eval('$("#divimage' + eles.id
//				+ '").mouseleave(function(){hidebigimg("image' + eles.id
//				+ '");});');
//		//hidebigimg('image' + eles.id);
//		eval('$("#bigdivimage' + eles.id
//				+ '").mouseenter(function(){showbigimg("image' + eles.id
//				+ '");});');
//		//showbigimg('image' + eles.id);
//		eval('$("#minimage' + eles.id
//				+ '").mouseenter(function(){showbigimg("image' + eles.id
//				+ '");});');
//		//showbigimg('image' + eles.id);
//		eval('$("#divimage' + eles.id
//				+ ' .mlt_link").click(function(){FindSameImage(' + eles.id
//				+ ');});');
//		//FindSameImage("+eles.id+");
//		eval('$("#divimage' + eles.id
//				+ ' .pic-button5").click(function(){FindSameImage(' + eles.id
//				+ ');});');
//		//FindSameImage("+eles.id+");
//		eval('$("#divimage' + eles.id
//				+ ' .pic-button1").click(function(){DownloadImageSepc("' + eles.corbisId
//				+ '");});');
//		//DownloadImageSepc("+eles.corbisId+");
//		eval('$("#divimage' + eles.id
//				+ ' .pic-button6").click(function(){DownloadImage("' + eles.corbisId
//				+ '");});');
//		//DownloadImage("+eles.corbisId+");
//		eval('$("#divimage' + eles.id
//				+ ' .pic-button8").click(function(){LightBox($(this));});');
//		//LightBox($(this));
	}
	$("#picbox_center").append(str);
	str="";
	
	// next_page_170.gif
//	if (p < tp) {
//		var str = '<div class="picbox-picbox" id="divimagenext">'
//				+ '<div class="picbox-picbox-inner" >'
//				+ '<a href="javascript:void(0);" onclick="nextPage();" target="_blank" ><img  id="minimagenext" src="images/next_page_170.gif" /></a>'
//				+ '</div></div>';
//		if (CanEmptyListPaging()==0)
//			$("#picbox_center").append(str);
//	}
	stop("apend");
	
	$("#picbox_center .picbox-picbox ").unbind();
	$("#picbox_center .picbox-picbox ").mouseleave(function(){
		hidebigimg("image"+$(this).attr("imageid"));
//		console.log("mouseleave"+"image"+$(this).attr("imageid"));
	});
	$("#picbox_center .picbox-picbox .bigimagediv").unbind();
	$("#picbox_center .picbox-picbox .bigimagediv").mouseenter(function(){
		showbigimg("image"+$(this).closest(".picbox-picbox").attr("imageid"));
//		console.log("mouseenter"+"image"+$(this).closest(".picbox-picbox").attr("imageid"));
	});
	$("#picbox_center .picbox-picbox .imagelink170 img").unbind();
	$("#picbox_center .picbox-picbox .imagelink170 img").mouseenter(function(){
		showbigimg("image"+$(this).closest(".picbox-picbox").attr("imageid"));
//		console.log("mouseenter.imagelink170"+"image"+$(this).closest(".picbox-picbox").attr("imageid"));
	});
	//.bigimagediv
	//.imagelink170
	stop("event");
	if(typeof setDivLightOn!='undefined'||!setDivLightOn)
		setDivLightOn();
	stop("total");
}
function CanEmptyListScrollTop()
{
	if(isPullStyle==1)
		return 0;//top
	if(isPullStyle ==0&&(PullStylePagesIndex) % PullStylePages == 1)
		return 0;//可top
	return 1;
}
function CanEmptyListEmpty()
{
	if(isPullStyle==1)
		return 0;//top
	if(isPullStyle ==0&&(PullStylePagesIndex) % PullStylePages == 1)
		return 0;//可top
	return 1;
}function CanEmptyListPaging()
{
	if(isPullStyle==1)
		return 0;//
	if(isPullStyle ==0&&(PullStylePagesIndex) % PullStylePages == 0)
		return 0;//
	return 1;
}
function CanEmptyListNeedLoadMore()
{
	if(isPullStyle==1)
		return 1;
	if(isPullStyle ==0&&(PullStylePagesIndex) % PullStylePages == 0)
		return 1;
	return 0;//可load.
}

function CanEmptyList2del()
{
	if(isPullStyle==1)
		return 0;
	if(isPullStyle ==0&& (PullStylePagesIndex) % PullStylePages == 0)
		return -1;//最后一页，待清空. 
	if(isPullStyle ==0&&(PullStylePagesIndex) % PullStylePages == 1)
		return 0;//可清空
}

function FindSameImage(imageid) {
	//强制刷新一下。
	PullStylePagesIndex=PullStylePages;
	genSearchSID();
	if (imageid) {
		smid = imageid;
		$("#q").val('');
	}
	p = 1;
	search();
}
// 生成新的查询ID
function genSearchSID() {
	searchSID = (new Date()).valueOf();
}
// //////////////////////////tools//////////
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

// 点击澄清后初始化
function showClearword() {
	if (!currentData || !currentData.claList)
		return;
	$(".searchimformationboxlistdiv").empty();
	if (currentData.claList[0]) {
		$(".searchimformationboxlistdiv").append(
				'<label><b>' + currentData.claList[0].name
						+ '</b></label><br/>');
	}
	$(".searchimformationboxlistdiv")
			.append(
					'<input name="checkany" value="" type="checkbox"/><label>任何</label><br/>');
	var selectedCla = cla || "";
	for (i = 0; i < currentData.claList.length; i++) {
		// var checked =
		// selectedCla.indexOf(""+currentData.claList[i].id+",")>=0
		// ?"checked":"";
		$(".searchimformationboxlistdiv").append(
				'<input name="" value="' + currentData.claList[i].id
						+ '" type="checkbox"/><label>'
						+ currentData.claList[i].items + '</label><br/>');
	}
	$('#searchimformationboxlist input')
			.iCheck(
					{
						checkboxClass : 'icheckbox_minimal-aero',
						radioClass : 'iradio_minimal-aero',
						increaseArea : '20%' // optional
					},
					function(item) {
						// check，uncheck操作结束后回调.
						// 此外暂无逻辑
					},
					function(item) {
						// click事件触发.
						if (item[0].name == "checkany") {
							if (item.attr("checked"))
								$(".searchimformationboxlistdiv input").not(
										item).iCheck("uncheck", null);
						} else {
							$(
									".searchimformationboxlistdiv input[name='checkany']")
									.iCheck("uncheck", null);
							if ($(".searchimformationboxlistdiv input:checked")
									.not(
											$(".searchimformationboxlistdiv input[name='checkany']")).length == $(
									".searchimformationboxlistdiv input")
									.not(
											$(".searchimformationboxlistdiv input[name='checkany']")).length) {
								$(
										".searchimformationboxlistdiv input[name='checkany']")
										.iCheck("check", null);
								$(".searchimformationboxlistdiv input")
										.not(
												$(".searchimformationboxlistdiv input[name='checkany']"))
										.iCheck("uncheck", null);
							}
						}

					},
					function() {
						// 始初化结束后调用
						var values = selectedCla.split(",");
						$.each(values, function(i, n) {
							$(
									".searchimformationboxlistdiv input[value='"
											+ n + "']").iCheck("check", null);
						});

						$("#clearLink").show();

						// InitLeftCheckBox();
					});
}

function hideClearword() {
	cla = "";
	$("#clearLink").hide();
}
function submitclearword() {
	var ids = '';
	$('.searchimformationboxlistdiv input:checked').each(function(i, n) {
		ids += n.value + ',';
	});
	if (ids.length > 0) {
		ids = ids.substring(0, ids.length - 1);
	}
	cla = ids;
	boxhidden('searchimformationboxlist');
	genSearchSID();
	search();
}
// 对未使用过澄清的用户，并且关键词需要澄清时调用一次以下方法
function showClearTips() {
	// 判断cookies ,然后显示.
	var sf = $.cookie('sf');
	if (!sf) {
		boxshow('searchimformationbox');
	}
}

function hiddenClearTips() {
	$.cookie('sf', "1");
	boxhidden('searchimformationbox');
}

function initShowPreview() {
	// 判断cookies ,然后显示.
	var sf = $.cookie('sp');
	if (!sf) {
		$.cookie('sp', 1);
		sf = 1;
	}
	// 处理灵异的风格，
	$(".menushow-yulan input[name='canpreview']").iCheck("uncheck", null);
	$(".menushow-yulan input[name='canpreview']").iCheck("check", null);
	if (sf == 1)
		$(".menushow-yulan input[name='canpreview']").iCheck("check", null);
	else
		$(".menushow-yulan input[name='canpreview']").iCheck("uncheck", null);
	isShowBigImage = ($(".menushow-yulan input[name='canpreview']:checked").length == 1);
}
function setShowPreview() {
	$.cookie(
					'sp',
					$(".menushow-yulan input[name='canpreview']:checked").length);
	isShowBigImage = ($(".menushow-yulan input[name='canpreview']:checked").length == 1);

	var boxid = "addstyle";
	boxhidden(boxid);
	$("#" + boxid).parent().css("z-index", "20");
}


function initSortType() {
	// 判断cookies ,然后显示.
	var sf = $.cookie('st');
	if (!sf) {
		$.cookie('st', 0);
		sf = 0;
	}
	setSelectwidget("sortType",sf);
	sortType =sf;
}
function setSortType() {
	sortType=$("input[name='sortType']").val();
	$.cookie('st',sortType);
	PullStylePagesIndex=PullStylePages;
	genSearchSID();
	search();
	
	var boxid = "addstyle";
	boxhidden(boxid);
	$("#" + boxid).parent().css("z-index", "20");
}


// 是否平铺1瀑布流2
function initPullStyle() {
	// 判断cookies ,然后显示.
	var sf = $.cookie('ps');
	if (!sf) {
		$.cookie('ps', 1);
		sf = 1;
	}
	checkbutton('menulayor', 'a', sf);
	isPullStyle = sf; // 瀑布流0， 平铺1 ,默认平铺.
	if (isPullStyle == 0)
		n = 50;//200;
	else
	{// 设置每页显示数量
		n = $.cookie('pageSize') || n;
		for (i = 0; i < pageSizeArray.length; i++) {
			if (pageSizeArray[i] == n) {
				checkbutton('menuadd', 'a', '' + i);
			}
		}
	}
}

function setPullStyle(v) {
	var isChange = false;
	$.cookie('ps', v);
	isPullStyle = v; // 瀑布流0， 平铺1 ,默认平铺.
	var boxid = "addstyle";
	boxhidden(boxid);
	$("#" + boxid).parent().css("z-index", "20");
	PullStylePagesIndex = 0;
	if (isPullStyle == 0)
		n = 50;//200;
	else
	{// 设置每页显示数量
		n = $.cookie('pageSize') || n;
		for (i = 0; i < pageSizeArray.length; i++) {
			if (pageSizeArray[i] == n) {
				checkbutton('menuadd', 'a', '' + i);
			}
		}
	}
	search();
}

function InitScorllEvent() {
	// var bodyheight = $(document).height();
	var scrolltop = $(document).scrollTop();
	var windowsheight = $(window).height();
	$(window)
			.scroll(
					function() {
						// bodyheight = $(document).height();
						scrolltop = $(document).scrollTop();
						windowsheight = $(window).height();
						var offset = $("#picbox_center .picbox-picbox").last()
								.offset();
						var top=0;
						if(offset)
							top=offset.top+$("#picbox_center .picbox-picbox").height();
						else
							top=5000;
						
						if ((windowsheight + scrolltop >= top)) {
							AutoloadMore();
						}
					});
}
function AutoloadMore() {
	if (isPullStyle != 0)
		return;
	if (CanEmptyListNeedLoadMore()!=0)
		return;
	if (PullStyleCanLoadMore) {
		PullStyleCanLoadMore = false;
		nextPage();
	}
}


//qp小样图下载
function DownloadImage(elesid)
{
	location.href = "dl/getImg.do?type=0&corbisId="+elesid;
}
//特殊小样图下载, 对应订阅计划
//跟qp显示时二选一
//下在时需要计数. 
function DownloadImageSepc(elesid)
{
	//elesid=eles.id的 
	location.href = "dl/getImg.do?type=3&corbisId="+elesid;
}