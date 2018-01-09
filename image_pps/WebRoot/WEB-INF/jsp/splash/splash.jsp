<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图片详细页</title>
<%@include file="/header.jsp" %>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/splashstyle.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/style.js"></script>
<script type="text/javascript" src="js/lightbox.js"></script>
<script type="text/javascript" src="js/jquery.icheck.js"></script>
<script src="js/jquery.jqprint.js"></script>

</head>
		<!--[if IE 6]>
			<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a.js"></script>
			<script type="text/javascript">
				DD_belatedPNG.fix('.png-img');
			</script>
		<![endif]-->
<body onresize="chickbodywidth()" onload="chickbodywidth()">
	<div class="fullbackbox" style="z-index:998;width: 100%;height: 100%;position: fixed;display:none;background:green;"></div>
	
	<jsp:include page="../inc/top.jsp"/>
    
    <script>
    var lis;
    var preBtn,aftBtn;
    	$(document).ready(function(){
    		preBtn=$("#pic_left").get(0).outerHTML;
    		aftBtn=$("#pic_right").get(0).outerHTML;
    		lis=$("#picture_ul li");
    		var currentUrl=location.href.split("/");
    		var currentImgUrl=currentUrl[currentUrl.length-2]+"/"+currentUrl[currentUrl.length-1];
    		initImg(currentImgUrl);
    	});
    	
    	function initImg(currentImgUrl){
    		var showHtml="";
    		var index=0;
    		var startIndex=0;
    		
   			lis.each(function(i,e){
    			if($(e).find(":first-child").attr("href")==currentImgUrl){
    				index=i;
    			}
    		});
    		
    		if((index-2)>0){
    			startIndex=index-2;
    		}
    		
    		if((index+4)>lis.length){
    			startIndex=lis.length-6;
    		}
    		
    		for (var i = startIndex; i < lis.length; i++) {
				if(i>(startIndex+6)){
					break;
				}
				if(i==startIndex){
					showHtml="<li class=\"pic_li\">"+lis[i].innerHTML+"</li>";
				}else{
					showHtml+=lis[i].outerHTML;
				}
			}
    		
    		$("#picture_ul").html(
    				preBtn+showHtml+aftBtn
    		);
    	}
    	
    	function pre(){
    		initImg($($("#picture_ul li")[3]).find(":first-child").attr("href"));
    	}
    	
    	function aft(){
    		initImg($($("#picture_ul li")[1]).find(":first-child").attr("href"));
    	}
    	
    </script>
    
<div class="content_left left">
<div class="content_tp print_show_image_detail" id="image_detail_preview" style="height: auto;">
	<img src="${webUrl }" class="image_detail_preview_to_adjust_641_462" />
	<ul id="picture_ul" class="mtp8">
            	<a id="pic_left" href="javascript:pre()"><img src="images/splashimages/left.png" /></a>
            	
            	
            	<c:forEach items="${rstList}" var="image" varStatus="stat">
            		<c:choose>
						<c:when test="${stat.index==0 }">
							<c:set var="cls" value="pic_li"></c:set>
						</c:when>
						<c:otherwise>
							<c:set var="cls" value="pic_li mlt8"></c:set>
						</c:otherwise>
					</c:choose>
					<li class="${cls }"><a class="pic_a" href="image/${image.corbisId }"><img class="pic_img" src="${image.imageHost }THUMBNAIL/${image.path}" alt="${image.corbisId }" /></a></li>
            	</c:forEach>
            	
            	
            	
            	<a id="pic_right"  href="javascript:aft()"><img src="images/splashimages/right.png" /></a>
      </ul>
</div>
<div class="content_fx clearfix">
<p class="warn left">图片仅供浏览 严禁下载</p>
<div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare" style="float:right; line-height:normal;display:none;">
<span class="bds_more">分享到：</span>
<a class="bds_qzone"></a>
<a class="bds_tsina"></a>
<a class="bds_tqq"></a>
<a class="bds_renren"></a>
<a class="bds_t163"></a>
<a class="shareCount"></a>
</div>
<script type="text/javascript" id="bdshare_js" data="type=tools&amp;uid=0" ></script>
<script type="text/javascript" id="bdshell_js"></script>
</div>
<div class="content_txt mtp10 print_show_image_detail">
<h1 style="color: #fff;">${imageInfo.title }</h1><!-- Peter update -->
<p></p>
</div>
<div class="content_xx print_show_image_detail">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="200">图片编号：</td>
    <td>${corbisId}</td>
  </tr>
  
   <c:if test="${!empty photoDate}">
  <tr>
    <td width="200">拍摄日期：</td>
    <td>${photoDate}</td>
  </tr>
  </c:if>
  <tr>
    <td width="200">肖像使用授权：</td>
    <td>
        ${modeRelease}
    </td>
  </tr>
  <tr>
    <td width="200">产权使用授权：</td>
    <td>${propertyRelease}  </td>
  </tr>
  	  <tr>
		<td width="200">摄影师：</td>
		<td>
		<a href="photographer/${photographer.id}"  class="c6699cc" target="_blank">${photographer.name}</a>
		</td>
	  </tr>
    <tr>
    <td width="200">出处：</td>
    <td>${imageInfo.creditLine}/Gaopin</td>
  </tr>
  <tr>
    <td width="200">授权类型：</td>
    <td>版权管理&nbsp;(${licenseType})</td>
  </tr>
  <c:if test="${!empty imageCategory}">
  <tr>
    <td width="200">类别：</td>
    <td><span class="c6699cc"><a href="photostock/${imageCategory.id}"  style="color:#ff01ff">${imageCategory.name}</a></span></td>
  </tr>
  </c:if>
  <c:if test="${!empty collection}"> 
  <tr>
    <td width="200">图片库：</td>
    <td><span class="c6699cc"><a href="photocollection/${collection.name}">${collection.name}</a></span></td>
  </tr>
  </c:if>
  <tr>
    <td width="200">最大文件尺寸：</td>
    <td>${maxSize}
    <!--62M - 3802px × 5700px • 32.19cm x 48.26cm @ 300ppi   -->
    <span class="mlt5 ts_span">
        <div class="ts_tc">
          <div class="ts_tc_tt">
            <h1 class="left">文件尺寸/角度</h1>
            <span class="close_tc right" onclick="$('.ts_span .ts_tc').hide(500)">X</span>
          </div>
          <div class="ts_nr_div">
            未压缩文件的大小和像素尺寸只是近似值。灰度图像的大小是 RGB 文件大小的 1/3 。从网站直接下载的文件是经过压缩的 JPEG 文件。您可以要求一个 TIFF 文件（如可提供），或更大的电子充图文件以配合作品输出的需求。
            请联系<a href="tellme" class="c6699cc">客户服务</a>查询相关的制作费用。
          </div>
        </div>
        <em class="ts_em">
        <a href="javascript:void(0);" onclick="$('.ts_span .ts_tc').show(500)" id="image_size_tip" dialog_title=" " dialog_type="message" dialog_width="450" dialog_height="190" dialog_message_alive="0"><img src="images/ts_ico.png" /></a>        </em>
      </span>
    </td>
  </tr>
   <c:if test="${restrictions!=null && fn:length(restrictions)>0}"> 
    <tr>
    <td width="200" valign="top"><p class="warn left" style="color:#ccc;">限制规定：</p></td>
    <td>
    	<ul style="padding-left:15px;">
    		<c:forEach items="${restrictions}" var="res" varStatus="stat">
    			<li style="list-style:disc outside none;color:#ccc;">${res}</li>
    		</c:forEach>
        </ul>
    </td>
  </tr>
  </c:if>
  </table>

</div>
<!--  
<div class="mtp10">
<p class="f16 c474747" style="color:#fff">图片关键词</p>

<form action="" accept-charset="utf-8" id="image_detail_keywords_search_form" method="post"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="keyword_table">
    <tr>
        <td>
            <ul class="kerword_ul">
<c:forEach items="${keysAll}" var="key" varStatus="stat">
<li><div class="icheckbox_minimal-aero"><input id="i1716335k0" name="single_keyword" type="checkbox" value="${key}" /><ins class="iCheck-helper" ></ins></div><label class="mlt5">${key}</label></li>
</c:forEach>
           </ul>
        </td>
    </tr>
</table>
</div>
-->
<script>
	function onSearch(){
		var q = "";
		
		$.each($("#image_detail_keywords_search_form").serializeArray(),function(i,n){
			if(n && n.name=='single_keyword'){
				if(q.length>0){
					q += " AND ";
				} 
				q += n.value;
			}
		});
		location.href = "search2#q="+q;
	}
	
	function GetFormResult(item)
	{
		var formresult=new Object();
		$.each(item.serializeArray(),function(i,n){
			if(formresult[n.name])
			{
				formresult[n.name]=formresult[n.name]+","+n.value;
			}else
			{
				formresult[n.name]=n.value;
			}
		});
		return formresult;
	}
	// alert('多选关键字搜索'+$('#image_detail_keywords_search_form').serialize());return false;
</script>
<div class="content_bottom mtp10">
    <!-- <a id="image_detail_keywords_search_btn" type="button" class="zh_btn1" value="搜索" 
    onclick="onSearch(); return false;" 
    style="-webkit-background-clip: border-box;  -webkit-background-origin: padding-box;  -webkit-background-size: auto;  -webkit-box-shadow: none;  background-attachment: scroll;  background-clip: border-box;  background-color: #69C;  background-origin: padding-box;  background-repeat: repeat;  background-size: auto;  border-bottom-color: rgba(0, 0, 0, 0.247059);    border-image-outset: 0px;  border-image-repeat: stretch;  border-image-slice: 100%;  border-image-source: none;  border-image-width: 1;  border-left-color: rgba(0, 0, 0, 0.0980392);  border-left-style: solid;  border-left-width: 1px;  border-right-color: rgba(0, 0, 0, 0.0980392);  border-right-style: solid;  border-right-width: 1px;  border-top-color: rgba(0, 0, 0, 0.0980392);    border-top-style: solid;  border-top-width: 1px;  box-shadow: none;          font-size: 12px;  height: 20px;  line-height: 20px;  margin-bottom: 0px;padding-bottom: 0px;  padding-left: 8px;  padding-right: 8px;  padding-top: 0px;  position: relative;  text-align: center;  text-decoration: none solid rgb(255, 255, 255);  text-shadow: rgba(0, 0, 0, 0.247059) 0px -1px 0px;  vertical-align: middle;  
    width: 44px;
">搜索</a> -->

<input type="button" style="
display:none;
width: 85px;
height: 33px;
line-height: 33px;
color: #a0a0a0;
border: none;
margin: 0px 2px;
background: #252424;
text-align: center;
font-size: 14px;
font-family: 微软雅黑;
margin-top: 0px;
background: #252424 url(images/menu_bg.png) bottom repeat-x;
" class="h-searchbox-inputbuttonb" value="搜 索" onclick="onSearch(); return false;">
    <span class="mlt10">图片出现错误？
        <a href="tellme" class="c6699cc">发送反馈意见</a>    </span>
</div>
</form>
</div>

<div class="content_right margin-left25 left">
<ul class="right_ul">
<li id="one">
    <a href="tellme">联系我们查询更多信息</a></li>
<li id="two" class="<c:if test="${inbox==1}">on</c:if>">
    <a href="javascript:void();" <c:if test="${inbox==0}"> onclick="addLightBoxItemdetailpage('${corbisId}')" </c:if> id="image_add_to_lightbox" dialog_title="添加到灯箱" dialog_type="plain" dialog_width="370" dialog_height="140">添加到灯箱</a>
    
</li>
  
<!--
<li id="four">
	<a href='account/login'>加入购物车</a>
</li>
-->
<li id="five"><a href="javascript:;" id="print-action">打印此页</a></li>

</ul>
<div class="mtp10" style="display:none;">
    <a href="search2#smid=${imageInfo.corbisId}&p=1" target="_blank"><img src="images/tp_btn.png" /></a></div>
<!-- 相似图片 START -->
<div class="right_tp clearfix mtp10 slide_images_wrapper" id="image_similiar_images_wrapper" style="height:auto;">
<div class="slides_container" style="width:295px; height:auto;" id="image_similiar_images">

</div>
<span class="right mrt14" style='display:none;' id='more_images'>
<a href="search#likeImage=1716335&p=1" target="_blank" onclick="alert('更多相似图片'); return false;"
>更多相似图片</a></span>
</div>
<!-- 相似图片 END -->

<!-- 图片组 START -->

<!-- 图片组 END -->

<!-- 虚拟cd START --> 

</div>

<!-- 虚拟cd END -->

</div>

</div>
<script type="text/javascript">

//打印
$(document).ready(function() { 
	
	  previewonload();
	  $("#image_detail_preview img").one("load",function(){
				previewonload();
	  });
			
	  
	  
	$("#print-action").click(function(){
		$(".print_show_image_detail").not(".ts_span").jqprint(); 
	});
	
	document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000);
  
	$('input').iCheck({
    checkboxClass: 'icheckbox_minimal-aero',
    radioClass: 'iradio_minimal-aero',
    increaseArea: '20%' ,
    fathertag:''// optional
  	});

});
function previewonload()
{
  var left=$("#image_detail_preview").width()/2-$("#image_detail_preview img").width()/2;
  $("#image_detail_preview .image_detail_preview_to_adjust_641_462").css("position","relative");
  $("#image_detail_preview .image_detail_preview_to_adjust_641_462").css("left",left+"px");
}
</script>
</body>
</html>


