<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>图库列表</title>
<jsp:include page="../inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<body class="pageCollectionLanding">
<link href="flowsearch/css/sub.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/myjs/flowpage.jerry.js"></script>
<jsp:include page="../inc/pagetop_user.jsp" /> 
<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">
	<div class="container">
		<!--pageCreativeRM-->
		<div class="topBanner760 clearBoth">
			<div class="row1 clearBoth">
				<div class="col-left box1"><img id="upImgB" src="images/collectionLanding/group1.jpg"/></div>
				<div class="col-right">
					<div class="box2">
						<h3 class="SiYuanBold">最新图库</h3>
						<a href="${upUrl }" class="collectionName titleArrow SiYuan-ExtraLight">${upName }</a>
						<div class="visible-sm visible-xs">RF/RM 通用图 </div>
					</div>
					<div class="box3">
						<img id="upImgS" src="images/collectionLanding/group2.jpg"/>
					</div>
				</div>
			</div>
			<div class="row2 clearBoth">
				<div class="col-left">
					<div class="col-box box4"><img id="downImg1" src="images/collectionLanding/group3.jpg"/></div>
					<div class="col-box box5"><img id="downImg2" src="images/collectionLanding/group5.jpg"/></div>
					<div class="col-box box6"><img id="downImg3" src="images/collectionLanding/group4.jpg"/></div>
				</div>
				<div class="col-right box7">
					<div class="header">${title }</div>
					<div class="intro">${info }</div>
					<a href="${url }" class="btnLong btnPurple btn-block icon-57-bag">查看所有图片</a>
				</div>
			</div><!--row2-->
		</div><!--topBanner760-->
		
		<a href="#" class="topBanner760Group visible-sm visible-xs">
			<div class="imgInner clearBoth">
				<div class="cube"><img id="img1" src="images/collectionLanding/group5.jpg"/></div>
				<div class="cube"><img id="img2" src="images/collectionLanding/group2.jpg"/></div>
				<div class="cube"><img id="img3" src="images/collectionLanding/group3.jpg"/></div>
				<div class="cube"><img id="img4" src="images/collectionLanding/group4.jpg"/></div>
			</div>
		</a><!--topBanner760Group-->
				
				
		<div class="row row3">
			<div class="col-md-6 col-md-offset-3">

				<div class="pageHeaderWrap">
					<div class="SiYuanBold header">所有的图片库</div>
					<div class="headerSub">介绍介绍介绍介绍介绍介绍介绍介绍介绍 介绍介绍介绍介绍介绍。们！</div>
				</div><!--pageHeaderWrap-->


				<div class="row">
					<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<select id="typeSearch" onchange="getImageCollection(1);">
						   <option value="">所有图库分类</option>
						   <option value="Premium">精品图库</option>
						   <option value="Standard">标准图库</option>
						   <option value="Value">超值图库</option>
						   <option value="Super Value">低价图库</option>
						</select>
					</div>
				</div>
			</div>
		</div><!--row3-->
		
		<div class="row row4">
            <div class="col-md-4">
                <a href="#" class="collectionGroup groupFour">
                    <div class="imgWrap">
                        <div class="imgInner clearBoth">
                            <div class="cube"><img src="images/creativeRF/group1.jpg"/></div>
                            <div class="cube"><img src="images/creativeRF/group2.jpg"/></div>
                            <div class="cube"><img src="images/creativeRF/group3.jpg"/></div>
                            <div class="cube"><img src="images/creativeRF/group4.jpg"/></div>
                        </div>
                    </div><!--groupWrap-->
                    <div class="titleWrap">
                        <div class="name">Aurora</div>
                        <div class="tag">RF 大自然</div>
                    </div><!--titleWrap-->
                </a><!--collectionGroup-->
            </div>
            		
		</div><!--row4-->
		<div class="row row5">
			<div class="col-md-12">
                <div class="fenyeGroup">
                    <div class="pagination-sm">
                        <a href="javascript:void(0)" class="icon-font icon-1-arrowLeft prev"></a>
                        <input name="pageNo_sm" type="text" value="1">
                        <span class="total"> / 127</span>
                        <a href="javascript:void(0)" class="icon-font icon-2-arrowRight next" ></a>
                    </div>
                    <div class="fenye">
                        <a class="changePage" href="javascript:;">上一页</a>
                        <a class="active" href="javascript:;">1</a>
                        <a href="javascript:;">2</a>
                        <a href="javascript:;">3</a>
                        <a href="javascript:;">...</a>
                        <a href="javascript:;">35</a>
                        <a class="changePage" href="javascript:;">下一页</a>
                    </div>
                </div>
            </div>
		</div>
		
		<div class="lineH hidden-sm hidden-xs"></div>
		<div class="row row5 hidden-sm hidden-xs">
			<div class="col-md-4 col-md-offset-4"><a href="Contributor/index.na" class="btnLong btnDGrey btn-block">图片股管理者：咱们聊聊吧！</a></div>
		</div>
		
		
		
		
	</div><!--container-->
</div><!--sectionCont-->

<jsp:include page="../inc/bottomflow.jsp" />
</body>
<!-- InstanceEnd --></html>
<script> 
$(document).ready(function(){
	var upImg = ${upImage};
	var downImg = ${downImage};
	$("#upImgB").attr("src","webres/upload/"+upImg[0].src);
	$("#upImgS").attr("src","webres/upload/"+upImg[1].src);
	$("#downImg1").attr("src","webres/upload/"+downImg[0].src);
	$("#downImg2").attr("src","webres/upload/"+downImg[1].src);
	$("#downImg3").attr("src","webres/upload/"+downImg[2].src);
	
	$("#img1").attr("src","webres/upload/"+upImg[1].src);
	$("#img2").attr("src","webres/upload/"+downImg[0].src);
	$("#img3").attr("src","webres/upload/"+downImg[1].src);
	$("#img4").attr("src","webres/upload/"+downImg[2].src);
	
	
	getImageCollection(1);
});


function getImageCollection(p){
	var ps = 9;
	$(".row.row4").empty();
	var type = $("#typeSearch").val();
// 	if(type == undefined)
// 	{
// 		type=0;
// 	}

//$.post(url,{},function(data){});
	$.ajax({
		 type: "post",
		 url: "getPhotocollectionList",
		 data: "p="+p+"&ps="+ps+"&type="+type,
		 success: function(msg){
// 			 $(".total").html(" / "+msg.pageCount);
// 			 $(".left").html(msg.pageCount);
		      
		     var countPage=msg.pageCount;
		     for (var i = 0; i < msg.data.length; i++) {
		     	
		     	var html ="";
		     	var n = null;
		     	if(msg.data[i].template != "")
		     	{
		    		n = eval('(' +msg.data[i].template+')');//msg.data[i];
		    	}
				var item = msg.data[i];
			    html+='<div class="col-md-4">';
	            html+='     <a href="photocollection'+item.name+'" class="collectionGroup groupFour">';
	            html+='         <div class="imgWrap">';
	            html+='             <div class="imgInner clearBoth">';
	            if(n != null)
	            {
		            html+='                 <div class="cube"><img src="webres/upload/'+n.thumb4[0].src+'"></div>';
		            html+='                 <div class="cube"><img src="webres/upload/'+n.thumb4[1].src+'"></div>';
		            html+='                 <div class="cube"><img src="webres/upload/'+n.thumb4[2].src+'"></div>';
		            html+='                 <div class="cube"><img src="webres/upload/'+n.thumb4[3].src+'"></div>';
	            }
	            html+='             </div>';
	            html+='         </div><!--groupWrap-->';
	            html+='         <div class="titleWrap">';
	            html+='             <div class="name">'+item.name+'</div>';
	            html+='             <div class="tag">'+item.intro+'</div>';
	            html+='         </div><!--titleWrap-->';
	            html+='     </a><!--collectionGroup-->';
	            html+=' </div>';
				
		     	$(".row.row4").append(html);
			}
			
			$("div.fenye").pageing(1,countPage,function(p){
				pageImageCollection(p);
		  	});
		  	
		  	$(".pagination-sm").mpageing(1,countPage,function(p){
				pageImageCollection(p);
		  	});
		 }
	});
}



function pageImageCollection(p){
	var ps = 9;
	$(".row.row4").empty();
	var type = $("#typeSearch").val();
	$.ajax({
		 type: "post",
		 url: "getPhotocollectionList",
		 data: "p="+p+"&ps="+ps+"&type="+type,
		 success: function(msg){
			 //$(".total").html(" / "+msg.pageCount);
			 //$(".left").html(msg.pageCount);
		     //$("input[name=pageNo_sm]").val(p);
		      
		     var countPage=msg.pageCount;
		     for (var i = 0; i < msg.data.length; i++) {
		     	
		     	var html ="";
		     	var n = null;
		     	if(msg.data[i].template != "")
		     	{
		    		n = eval('(' +msg.data[i].template+')');//msg.data[i];
		    	}
				var item = msg.data[i];
			    html+='<div class="col-md-4">';
	            html+='     <a href="photocollection'+item.name+'" class="collectionGroup groupFour">';
	            html+='         <div class="imgWrap">';
	            html+='             <div class="imgInner clearBoth">';
	            if(n != null)
	            {
		            html+='                 <div class="cube"><img src="webres/upload/'+n.thumb4[0].src+'"></div>';
		            html+='                 <div class="cube"><img src="webres/upload/'+n.thumb4[1].src+'"></div>';
		            html+='                 <div class="cube"><img src="webres/upload/'+n.thumb4[2].src+'"></div>';
		            html+='                 <div class="cube"><img src="webres/upload/'+n.thumb4[3].src+'"></div>';
	            }
	            html+='             </div>';
	            html+='         </div><!--groupWrap-->';
	            html+='         <div class="titleWrap">';
	            html+='             <div class="name">'+item.name+'</div>';
	            html+='             <div class="tag">'+item.intro+'</div>';
	            html+='         </div><!--titleWrap-->';
	            html+='     </a><!--collectionGroup-->';
	            html+=' </div>';
				
		     	$(".row.row4").append(html);
			}
			
		  	
		 }
	});
}
</script>