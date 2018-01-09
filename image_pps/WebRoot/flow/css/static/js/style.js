// JavaScript Document

//全局宽度限制1024px以上，只要小于1024则执行
function chickbodywidth(){
	document.body.style.width='100%';
	document.body.clientWidth<1026?document.body.style.width='1026px':document.body.style.width='100%';//如需重新定义全局宽度，请调整此行1024尺寸，单位为px
	//aotuheight()
}

//菜单栏下拉效果
function meunshow(boxid){
	document.getElementById(boxid).getElementsByTagName('div')[0].style.display="block";
}
function meunhidden(boxid){
	document.getElementById(boxid).getElementsByTagName('div')[0].style.display="none";
}
function boxshow(boxid){
	document.getElementById(boxid).style.display="block";
}
function boxhidden(boxid){
	document.getElementById(boxid).style.display="none";
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
	for(var i=0;i<num;i++){
		if(num_id==i){
			if(document.getElementById(tag_id+i)){document.getElementById(tag_id+i).className="on"}
			if(document.getElementById(contant_id+i)){document.getElementById(contant_id+i).style.display="block"}
		}else{
			if(document.getElementById(tag_id+i)){document.getElementById(tag_id+i).className=""}
			if(document.getElementById(contant_id+i)){document.getElementById(contant_id+i).style.display="none"}
		}
	}
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

//图片控制
function imgsize(){
	var imgid=document.getElementById('picbox_center');
	var imgtag=imgid.getElementsByTagName('img')
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

//大图显示
function showbigimg(imgbox){
	for(var i=0;i<imgbox.getElementsByTagName('img').length;i++){
		if(imgbox.getElementsByTagName('img')[i].className=="picbox-bigpic"){
			imgbox.getElementsByTagName('img')[i].style.display="block";
			var showbigimgw=imgbox.getElementsByTagName('img')[i].scrollWidth/2
			var showbigimgh=imgbox.getElementsByTagName('img')[i].scrollHeight/2
			imgbox.getElementsByTagName('img')[i].style.margin="-"+showbigimgh+"px -"+showbigimgw+"px";
		}
	}
}
function heightbigimg(imgbox){
	for(var i=0;i<imgbox.getElementsByTagName('img').length;i++){
		if(imgbox.getElementsByTagName('img')[i].className=="picbox-bigpic"){
			imgbox.getElementsByTagName('img')[i].style.display="none";
		}
	}
}

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