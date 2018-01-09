<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/template.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,user-scalable=no"/>
<!-- InstanceBeginEditable name="doctitle" -->
<title>下载记录</title>
<!-- InstanceEndEditable -->
<%@include file="/headerflow.jsp" %>

<script type="text/javascript" src="flowsearch/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="flowsearch/js/jquery.ui.datepicker-zh-CN.js"></script>
<link href="flowsearch/css/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/favourite.js"></script>

<script type="text/javascript" src="flowsearch/js/jquery.validate.js"></script>
<script type="text/javascript" src="flowsearch/js/form.js"></script>
<script type="text/javascript" src="flowsearch/js/jquery.fancybox.js"></script>
<link href="flowsearch/css/jquery.fancybox.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/jquery.tinyscrollbar.js"></script>

<script type="text/javascript" src="js/jquery.jqprint.js"></script>
<script>
$(document).ready(function(){
	bindPage();
});

var p=1;
var ps=10;
var countPage=${pageCount};

 
function searchPage(){
		p=1;
		$(".pagination-sm.pull-right").find("input").val(p);
	$(".targetNum").val(p);
		sendPageInfo();
	
}

function key13(e,a){
	if(e&&e.keyCode==13){
		p=$(a).val();
		bindPage();
	}
}

function numberCheck(e){
	if(e.keyCode==8||e.keyCode==13||e.keyCode==116){
		return;
	}
	if(e.keyCode>57||e.keyCode<48){
		e.keyCode=event.keyCode=0;
		e.returnValue=event.returnValue=false;
	}
}
function nextPage(){
	if(p<countPage&&p>=1){
		p++;
		bindPage();
	}
}
function prevPage(){
	if(p>1){
		p--;
		bindPage();
	}
}

function bindPage(){
	//$(".p_class").val(p);
	$(".pagination-sm.pull-right").find("input").val(p);
	$(".targetNum").val(p);
	if(p<=countPage&&p>=1){
		sendPageInfo();
	}
	$('body,html').animate({scrollTop:0},500); 
}

function sendPageInfo(){
	$(".favouriteGallery.layout3.globalDetail").empty();
	var sDate = $("#from").val();
	var eDate = $("#to").val();
	var type = $(".ignore.selectBox").val();
	if(type == undefined)
	{
		type=0;
	}
	$.ajax({
		 type: "get",
		 url: "my/myHistory",
		 data: "p="+p+"&ps="+ps+"&type="+type+"&sDate="+sDate+"&eDate="+eDate,
		 success: function(msg){
			 $(".total").html(" / "+msg.pageCount);
			 $(".left").html(msg.pageCount);
// 		     $("#entityCount").html(msg.orderItems.length+"&nbsp;项");
// 		     $("#ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_indexInfo").html(msg.orderItems.length+"&nbsp;项");
		      
		     countPage=msg.pageCount;
		     for (var i = 0; i < msg.data.length; i++) {
		     	var n = msg.data[i];
				var eles = msg.map[n.corbisId];
				if (!eles)
				{	
					var content ='<div href="#" class="galleryThumb" >'
						+'<div class="imgWrap">'
						+'</div>'
						+'<div class="thumbDetail">'
						+'	'+n.corbisId+'<br>'
						+'</div>'
					+'</div>';
				
		     		$(".favouriteGallery.layout3.globalDetail").append(content);
					continue;
				}	
				
				var rf =typeof(eles)!="undefined"&& eles.licenseType && eles.licenseType == 2 ? "RM" : "RF";
		     	
		     	var content ='<div href="#" class="galleryThumb" >'
					+'<div class="imgWrap">'
					+'	<a href="image/'+n.corbisId+'"><img src="'
					+ eles.imageHost
					+ 'THUMBNAIL/180/'
					+ eles.path
					+ eles.ext
					+ ' " imgid="'+n.corbisId+'" width="305" height="290" class="ui-draggable ui-draggable-handle"></a>'
					+'</div>'
					+'<div class="thumbDetail">'
					+	rf+'<br>'
					+'	'+n.corbisId+'<br><a href="javascript:void(0)">'+eles.scn+'</a>   /   <a href="javascript:void(0)">'+eles.collectionName+'</a><br>'
					+'	'+eles.title+'<br>'
					+'	'+ eles.location +'<br>'
					+'	'+ getUserDate(eles.photoDate) +'<br>'
					+'	'+getUserDate(n.createTime)+'<br>'
					+'</div>'
				+'</div>';
				
		     $(".favouriteGallery.layout3.globalDetail").append(content);
// 				content+="<tr>";
				//<a href="my/qpdetail/${bean.id}"> ${bean.id}</a>
// 				content+="<td><a href='my/qpdetail/"+msg.orderItems[i].id+"'>"+msg.orderItems[i].id+"</td>";
// 				content+="<td>"+getUserDate(msg.orderItems[i].createTime)+"</td>";
// 				content+="<td>"+msg.orderItems[i].itemCount+"</td>";
// 				content+="</tr>";
			}
		 }
	});
}
function getUserDate(date){
	var dt= new Date(date);
	 var year=dt.getFullYear();//获取年
	 return Todate(dt)+"/"+year;
}

	function Todate(num) { //Fri Oct 31 18:00:00 UTC+0800 2008
		num = num + "";
		var date = "";
		var month = new Array();
		month["Jan"] = 1;
		month["Feb"] = 2;
		month["Mar"] = 3;
		month["Apr"] = 4;
		month["May"] = 5;
		month["Jun"] = 6;

		month["Jul"] = 7;
		month["Aug"] = 8;
		month["Sep"] = 9;
		month["Oct"] = 10;
		month["Nov"] = 11;
		month["Dec"] = 12;

		/* var week = new Array();

		week["Mon"] = "一";
		week["Tue"] = "二";
		week["Wed"] = "三";
		week["Thu"] = "四";
		week["Fri"] = "五";
		week["Sat"] = "六";
		week["Sun"] = "日"; */

		str = num.split(" ");

		//date = str[5] + "-";

		date = /* date + */ month[str[1]] + "/" + str[2];

		return date;

	}
</script>

<jsp:include page="../inc/qqheader.jsp" />
</head>

<!-- InstanceBeginEditable name="bodyClass" -->
<body class="pageFavourite">
 
<jsp:include page="../inc/pagetop_user.jsp"/>
<!-- InstanceEndEditable -->

<!-- InstanceBeginEditable name="nav" -->


<!-- InstanceBeginEditable name="cont" -->

<div id="userCenterMobileMenu">
	
	<ul class="navMobile">
			<li><a href="my/person" class="iconUser">个人信息</a></li>
			<li><a href="my/lightbox" class="iconFolder">收藏夹</a></li>
			<li class="active"><a href="my/myqp" class="iconHistory">下载记录</a></li>
			<li><a href="#" class="iconInvoice">发票</a></li>
			<li><a href="#" class="iconSet">套餐</a></li>
	</ul>
	
	<div class="navMobileSub">
		<div class="favFolderControl">
			<span class="icon-font icon-46-createNew btnCreateNewInFav"></span>
			<span class="icon-font icon-50-trash"></span>
		</div>

		<div class="favouriteFolderList">
			<div class="favFolderBox" lightBoxId="1">
				<a href="userFavourite.html" class="folder">
					<div class="favFolderName">秋天图片收集1</div>
					<div class="favFolderAmount">共<span>10</span>张图片</div>
				</a>
				<span class="btnClose icon-font icon-cross"></span>
			</div><!--favListBox-->
			<div class="favFolderBox" lightBoxId="2">
				<a href="userFavourite2.html" class="folder">
					<div class="favFolderName">秋天图片收集2</div>
					<div class="favFolderAmount">共<span>10</span>张图片</div>
				</a>
				<span class="btnClose icon-font icon-cross"></span>
			</div><!--favListBox-->
			<div class="favFolderBox" lightBoxId="3">
				<a href="userFavourite.html" class="folder">
					<div class="favFolderName">秋天图片收集3</div>
					<div class="favFolderAmount">共<span>10</span>张图片</div>
				</a>
				<span class="btnClose icon-font icon-cross"></span>
			</div><!--favListBox-->
			<div class="favFolderBox" lightBoxId="4">
				<a href="userFavourite2.html" class="folder">
					<div class="favFolderName">秋天图片收集4</div>
					<div class="favFolderAmount">共<span>10</span>张图片</div>
				</a>
				<span class="btnClose icon-font icon-cross"></span>
			</div><!--favListBox-->
		</div>
	</div>
</div><!--userCenterMobileMenu-->



<div class="userCenterWrap">
	<div class="leftNav hidden-xs hidden-sm">
		<ul>
			<li><a href="my/person" class="iconUser">个人信息</a></li>
			<li><a href="my/lightbox" class="iconFolder">收藏夹</a></li>
			<li class="active"><a href="my/myqp" class="iconHistory">下载记录</a></li>
			<li><a href="#" class="iconInvoice">发票</a></li>
			<li><a href="#" class="iconSet">套餐</a></li>
		</ul>
	</div><!--leftNav-->
	
	<div class="midCont midCont3">
		
		
		
		<h2>下载记录</h2>
		
		<div class="settingBar">
			<div class="select260">
				<select class="ignore">
					<option value="0">全部</option>
					<option value="1">RF</option>
					<option value="2">RM</option>
				</select>
			</div>

			
			<div class="dateWrap">
				<input type="text" id="from" name="from" placeholder="开始时间">
				-
				<input type="text" id="to" name="to" placeholder="结束时间">
				
				<input name="" value="查 询" type="submit" class="btn-md btnPurple" onclick="searchPage()"/>
			</div>
			
			<div class="pagination-sm pull-right">
				<a class="icon-font icon-1-arrowLeft" href="javascript:void(0)" onclick="prevPage()"></a>
				<input type="text" value="1" name="">
				<span class="total"> / 1</span>
				<a class="icon-font icon-2-arrowRight" href="javascript:void(0)" onclick="nextPage()"></a>
			</div>
		
		</div>
		
		
		<div class="favouriteGalleryWrap">

			
			<div class="favouriteGallery layout3 globalDetail">
		
				 

			</div><!--favouriteGallery-->
	
	
	
	
<!-- 			<div class="pageNumWrap" style=" margin-top: 280px; "> -->
<!-- 				<a href="javascript:void(0)" class="btnPrev icon-font icon-1-arrowLeft" onclick="prevPage()></a> -->
<!-- 				<input name="" type="text" class="targetNum" value="1"/> -->
<!-- 				<a href="javascript:void(0)" class="btnNext" onclick="nextPage()"> -->
<!-- 					<span class="left">/  1 </span> -->
<!-- 					<span class="right SiYuan-ExtraLight">下一页</span> -->
<!-- 				</a> -->
<!-- 			</div> -->
			<div class="pageNumWrap"  style=" margin-top: 280px; ">
				<a href="javascript:void(0)" class="btnPrev icon-font icon-1-arrowLeft" onclick="prevPage()"></a>
				<input name="" type="text" class="targetNum" value="1"/>
				<a href="javascript:void(0)" class="btnNext" onclick="nextPage()">
					<span class="left">/  127 </span>
					<span class="right SiYuan-ExtraLight" >下一页</span>
				</a>
			</div>
		</div><!--favouriteGalleryWrap-->	
	</div><!--midCont-->
	
</div><!--userCenterWrap-->


<!-- Modal -->
<!--<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
-->


<!-- Modal -->
<!--<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>-->





<jsp:include page="../inc/bottomflow.jsp" />




			
</body>
<!-- InstanceEnd --></html>
