// JavaScript Document

//全局宽度限制1024px以上，只要小于1024则执行
function chickbodywidth(){
	document.body.style.width='100%';
	document.body.clientWidth<1026?document.body.style.width='1026px':document.body.style.width='100%';//如需重新定义全局宽度，请调整此行1024尺寸，单位为px
//	aotuheight()
}

//菜单栏下拉效果
function meunshow(boxid){
	document.getElementById(boxid).getElementsByTagName('div')[0].style.display="block";
}
function meunhidden(boxid){
	document.getElementById(boxid).getElementsByTagName('div')[0].style.display="none";
}
function boxshow(boxid){
//	document.getElementById(boxid).style.display="block";
//	document.getElementById(boxid).style.z-index="1001";

	$("#"+boxid).show();
}

function boxshowkeep(boxid)
{
	//选隐藏其他无关图层.
	$(".picture-searchbox-imfor").hide();
	
	$("#"+boxid).show();
	$("#"+boxid).css("z-index","20000");
	$("#"+boxid).parent().css("z-index","20000");
	$(".fullbackbox").css("z-index","19999");
	$(".fullbackbox").show();
	$(".fullbackbox").one("click",function(){
		ClearFullback(function(){
			boxhidden(boxid);
		});
		$("#"+boxid).parent().css("z-index",22);	
	});	
	//加取消事件及滚动条初始化. 
	if(boxid=="h-search")
		{
			$("#"+boxid+" .h-searchbox-inputbuttoncancel").one("click",function(){
				ClearFullback(function(){
					boxhidden(boxid);
				});
				$("#"+boxid).parent().css("z-index",20);	
			});	
			$('.imagecollselect .scroll-pane').jScrollPane(
			{
				showArrows: true,
				animateScroll: true
			}
			);
		}
	
}

function hiddensearchadv()
{
	var boxid="h-search";
	boxhidden(boxid);
	$("#"+boxid).parent().css("z-index","2");	
}

function boxhidden(boxid){
	if(document.getElementById(boxid))
		{
		document.getElementById(boxid).style.display="none";
		}
	ClearFullback();
}


function ClearFullback(e)
{
	$(".fullbackbox").hide();
	if(e!=null)
	{
		e();
	}
	
}

//图片处理
/**
 * 图片头数据加载就绪事件 - 更快获取图片尺寸
 * @version	2011.05.27
 * @author	TangBin
 * @see		http://www.planeart.cn/?p=1121
 * @param	{String}	图片路径
 * @param	{Function}	尺寸就绪
 * @param	{Function}	加载完毕 (可选)
 * @param	{Function}	加载错误 (可选)
 * @example imgReady('http://www.google.com.hk/intl/zh-CN/images/logo_cn.png', function () {
		alert('size ready: width=' + this.width + '; height=' + this.height);
	});
 */
var imgReady = (function () {
	var list = [], intervalId = null,

	// 用来执行队列
	tick = function () {
		var i = 0;
		for (; i < list.length; i++) {
			list[i].end ? list.splice(i--, 1) : list[i]();
		};
		!list.length && stop();
	},

	// 停止所有定时器队列
	stop = function () {
		clearInterval(intervalId);
		intervalId = null;
	};

	return function (url, ready, load, error) {
		var onready, width, height, newWidth, newHeight,
			img = new Image();
		
		img.src = url;

		// 如果图片被缓存，则直接返回缓存数据
		if (img.complete) {
			ready.call(img);
			load && load.call(img);
			return;
		};
		
		width = img.width;
		height = img.height;
		
		// 加载错误后的事件
		img.onerror = function () {
			error && error.call(img);
			onready.end = true;
			img = img.onload = img.onerror = null;
		};
		
		// 图片尺寸就绪
		onready = function () {
			newWidth = img.width;
			newHeight = img.height;
			if (newWidth !== width || newHeight !== height ||
				// 如果图片已经在其他地方加载可使用面积检测
				newWidth * newHeight > 1024
			) {
				ready.call(img);
				onready.end = true;
			};
		};
		onready();
		
		// 完全加载完毕的事件
		img.onload = function () {
			// onload在定时器时间差范围内可能比onready快
			// 这里进行检查并保证onready优先执行
			!onready.end && onready();
		
			load && load.call(img);
			
			// IE gif动画会循环执行onload，置空onload即可
			img = img.onload = img.onerror = null;
		};

		// 加入队列中定期执行
		if (!onready.end) {
			list.push(onready);
			// 无论何时只允许出现一个定时器，减少浏览器性能损耗
			if (intervalId === null) intervalId = setInterval(tick, 40);
		};
	};
})();

//标签切换
function tag_change(contant_id,tag_id,num_id,num){
	for(var i=0;i<=num;i++){
		if(num_id==i){
			if(document.getElementById(tag_id+i)){document.getElementById(tag_id+i).className="on"}
			if(document.getElementById(contant_id+i)){document.getElementById(contant_id+i).style.display="block"}
		}else{
			if(document.getElementById(tag_id+i)){document.getElementById(tag_id+i).className=""}
			if(document.getElementById(contant_id+i)){document.getElementById(contant_id+i).style.display="none"}
		}
	}
}

//显示或隐藏
function show_or_hidden(id_name){
	var idbar=document.getElementById(id_name);
	if(idbar){
		idbar.style.display=='none'?	idbar.style.display='':idbar.style.display='none';
	}
}

//文字切换
function change_text(id_n,n1,n2){
	if(id_n.innerHTML==n1){id_n.innerHTML=n2}else{id_n.innerHTML=n1}
}



//左栏类别收缩栏
function chickshow(box_id,title_id){
	if(document.getElementById(box_id)){
		document.getElementById(box_id).style.display==""?document.getElementById(box_id).style.display="none":document.getElementById(box_id).style.display=""
	}
	if(document.getElementById(title_id)){
		if(document.getElementById(title_id).innerHTML=='<img src="images/left-title-acc.gif">'){
			document.getElementById(title_id).innerHTML='<img src="images/left-title-acc.png">'
		}else{
			document.getElementById(title_id).innerHTML='<img src="images/left-title-acc.gif">'
		}
	}
}

function chickshowsmall(box_id,title_id){
	if(document.getElementById(box_id)){
		document.getElementById(box_id).style.display==""?document.getElementById(box_id).style.display="none":document.getElementById(box_id).style.display=""
	}
	if(document.getElementById(title_id)){
		if(document.getElementById(title_id).innerHTML=='<img src="images/S-Arrow-1.png">'){
			document.getElementById(title_id).innerHTML='<img src="images/S-Arrow-2.png">'
		}else{
			document.getElementById(title_id).innerHTML='<img src="images/S-Arrow-1.png">'
		}
	}
}
//图片控制
function imgsize2del(){
	var imgid=document.getElementById('picbox_center');
	var imgtag=imgid.getElementsByTagName('img');
	for(var i=0;i<imgtag.length;i++){
		if(imgtag[i].className==""){
			if(imgtag[i].width>170){imgtag[i].width=170;}
			if(imgtag[i].height>170){imgtag[i].height=170;}
			var imgtoph=170-imgtag[i].scrollHeight;
			if(imgtoph>0){
				var imgtop=imgtoph/2;
				imgtag[i].style.margin=imgtop+"px 0px 0px";
			}
		}
	}
}

//图片控制
function imgsize(){
	var imgid=document.getElementById('picbox_center');
	var limgid=document.getElementById('mylightbox');
	if(imgid){
		var imgtag=imgid.getElementsByTagName('img');
		for(var i=0;i<imgtag.length;i++){
			if(imgtag[i].className==""){
				if(imgtag[i].width>170){imgtag[i].width=170}
				if(imgtag[i].height>170){imgtag[i].height=170}
				var imgtoph=170-imgtag[i].scrollHeight
				if(imgtoph>0){
					var imgtop=imgtoph/2
					imgtag[i].style.margin=imgtop+"px 0px 0px"
				}
			}
		}
	}
	if(limgid){
		var limgtag=limgid.getElementsByTagName('img');
		for(var i=0;i<limgtag.length;i++){
			if(limgtag[i].className==""){
				if(limgtag[i].width>120){limgtag[i].width=120}
				if(limgtag[i].height>120){limgtag[i].height=120}
				var limgtoph=120-limgtag[i].scrollHeight
				if(limgtoph>0){
					var limgtop=limgtoph/2
//					limgtag[i].style.margin=limgtop+"px 0px 0px"
				}
			}
		}
	}
}


//大图显示
var curbigimg="";
function showbigimg(imgid){
	if(typeof isShowBigImage=="undefined"||!isShowBigImage)
		return;
	if(itemeventlist[imgid])
		clearTimeout(itemeventlist[imgid]);
	curbigimg=imgid;
	setTimeout("showbigimgprivate('"+imgid+"')",1);
}
function showbigimgprivate(imgid){
	if(curbigimg!=imgid){hidebigimg(imgid); return;}
	var itemp = $("#bigdiv"+imgid+" .bigdivimagediv");
	if(!itemp.html())
	{
		var eles=CurDataArray[imgid];
		itemp.append('<a href="image/'+eles.corbisId+'" target="_blank"><img class="picbox-bigpic" id="bigimage'+eles.id+'" src="'+eles.imageHost+'HOVER/'+eles.path+'" /></a>');
		$("#bigimage"+eles.id).one("load",function(){
			if(curbigimg!=imgid){hidebigimg(imgid); return;}
			showbigimgprivateloaded(imgid);
		});
		var tmpidstr="#bigimage"+eles.id;
		$(tmpidstr).error(function(){
			itemp.empty();
		});
	}else
	{
		showbigimgprivateloaded(imgid);
	}
}
function showbigimgprivateloaded(imgid){
	if(curbigimg!=imgid){hidebigimg(imgid); return;}
	var cw=document.body.clientWidth;
	var item = $("#bigdiv"+imgid);
	var itemimg = $("#big"+imgid);
	var itemmin = $("#min"+imgid);
	itemimg.parent().css("width",itemimg[0].naturalWidth);
	itemimg.parent().css("height",itemimg[0].naturalHeight);
	itemimg.parent().parent().css("width",itemimg[0].naturalWidth);
	itemimg.parent().parent().css("height",itemimg[0].naturalHeight);

	item.css("width",itemimg[0].naturalWidth);
	item.css("height",itemimg[0].naturalHeight+35);
	var cw=$(window).width()+document.body.scrollLeft;
	var ch=$(window).height()+document.body.scrollTop;
	var showbigimgw=itemimg[0].naturalWidth/2;
	var showbigimgh=itemimg[0].naturalHeight/2+40;
	if(itemmin.offset().left+item.width()>cw)
		showbigimgw+=(itemmin.offset().left+itemmin.width()/2+item.width()/2-cw)+10;
	if(itemmin.offset().top+item.height()>ch)
		showbigimgh+=(itemmin.offset().top+itemmin.height()/2+item.height()/2-ch)+25;
	else if(itemmin.offset().top+itemmin.height()/2-item.height()/2<document.body.scrollTop)
		showbigimgh=showbigimgh-(document.body.scrollTop-(itemmin.offset().top+itemmin.height()/2-item.height()/2))+18;
	item.css("margin",(-1*showbigimgh)+"px "+(-1*showbigimgw)+"px");
	if(curbigimg!=imgid){hidebigimg(imgid); return;}
		
	$(".bigimagediv").not(item).hide();
	item.fadeIn(200);//show();
}


function hidebigimg(imgid)
{
	itemeventlist[""+imgid+""]=setTimeout("$(\"#bigdiv"+imgid+"\").fadeOut(200);",200);
	curbigimg="";
}

var itemeventlist=new Array();

//单选控件样式切换
//单选控件样式切换
function checkbutton(id,tag,num,kg){
	if(document.getElementById(id)){
		for(var i=0;i<document.getElementById(id).getElementsByTagName(tag).length;i++){
			if(i==num){
				if(kg=="on"){
					document.getElementById(id).getElementsByTagName(tag)[i].className=document.getElementById(id).getElementsByTagName(tag)[i].className+' on';
				}else{
					document.getElementById(id).getElementsByTagName(tag)[i].className='on';
				}
			}else{
				if(kg=="on"){
					document.getElementById(id).getElementsByTagName(tag)[i].className=document.getElementById(id).getElementsByTagName(tag)[i].className.replace(/( on)/g,""); 
				}else{
					document.getElementById(id).getElementsByTagName(tag)[i].className='';
				}
			}
		}
	}
	return true;
}

//底色控制
function changecolor(){
	if(document.body.className=='w-body'){
		javascript:document.body.className='';
		document.getElementById('addstyle').getElementsByTagName('a')[0].className=''
	}else{
		document.body.className='w-body';
		document.getElementById('addstyle').getElementsByTagName('a')[0].className='on'
	}
}

//改变class
function changeclassname(idn,cln){
	if(document.getElementById(idn)){
		document.getElementById(idn).className=cln;
	}
}

//潮流趋势报告图片效果
function trendpic(num_id){
	if(document.getElementById('trends-img')){
		var trendimg = document.getElementById('trends-img').getElementsByTagName('img')
		for(var i=0;i<trendimg.length;i++){
			if(num_id==i){
				trendimg[i].className="";
			}else{
				trendimg[i].className="hiddenimg";
			}
		}
	}
}

function cleartrend(){
	if(document.getElementById('trends-img')){
		var trendimg = document.getElementById('trends-img').getElementsByTagName('img')
		for(var i=0;i<trendimg.length;i++){
			trendimg[i].className="";
		}
	}
}
	
//下拉菜单控件
//var divforselect='';
function selectwidget(tagbar){
	var tagbar=tagbar?tagbar:$(".select-widget");
	tagbar.each(function(){
		var item=$(this);
		item.find("a p").css("margin-top","0px");
		item.find("a p").css("margin-left","0px");
		item.find("img").unbind();
		item.find("img").click(function(){
			if(item.find("div").css("display")=="none")
			{
				item.after($(".divforselect"));
				item.css("z-index",2005);
				item.find("div").fadeIn(200);
				$(".divforselect").show();
				$(".divforselect").one("click",function(){
					item.find("div").fadeOut(200);
					$(".divforselect").hide();
					item.css("z-index",1);
				});
			}else
			{
				item.find("div").fadeOut(200);
				$(".divforselect").hide();
				item.css("z-index",1);
			}
		});
		item.find("a").unbind();
		item.find("a").click(function(){
			if($(this).attr("value")!=item.find("input").eq(0).val())
			{
				item.find("input").eq(0).val($(this).attr("value"));
				item.find("input").eq(1).val($(this).find("p").html());
				eval(item.attr("callback"));
			}
			item.find("div").fadeOut(200);
			$(".divforselect").hide();
			item.css("z-index",1);
		});
	});
}
function setSelectwidget(name,value)
{
	var widget=$("input[name='"+name+"']").closest(".select-widget");
	var selected=widget.find("a[value='"+value+"']");
	widget.find("input").eq(0).val(selected.attr("value"));
	widget.find("input").eq(1).val(selected.find("p").html());
}

function getDateStr(v) {
	var d, s = ""; // 声明变量。
	if(v)
		d=new Date(v);
	else
		d = new Date(); // 创建 Date 对象。
	s += d.getFullYear()+ "/";
	s += (d.getMonth() + 1) + "/"; // 获取月份。
	s += d.getDate() ; // 获取日。
	 // 获取年份。
	return (s); // 返回日期。
}
