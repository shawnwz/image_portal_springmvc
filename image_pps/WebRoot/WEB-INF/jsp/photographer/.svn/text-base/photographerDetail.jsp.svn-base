<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<body class="pageCollectionDetail">
<jsp:include page="../inc/pagetop_user.jsp" /> 
 
<div id="sectionCont">
	<div class="container">
		<div class="subCont">
			<div class="row">
			
				<div class="col-md-5 leftIntro">
					<div class="row">
						<div class="col-md-3 photo"><img id="headFace" src="images/collection/photo.jpg"/></div>
						<div class="col-md-9">
							<h3 class="SiYuanBold">高品摄影师</h3>
							<div class="collectionName SiYuan-ExtraLight">${name}</div>
							<p>${curitem.intro}</p>
							<a href="#" onclick="seeAll('${name}')" class="btnLong btnDGrey btn-block">摄影师所有图片</a>
						</div>
					</div><!--row-->
				</div><!--col-md-4-->
				<div class="col-md-7 hidden-sm hidden-xs"><img id="big" src="images/collection/feature.jpg"/></div>
				
			</div><!--row1-->
			
			
			
			
			<div class="collectionGallery">
				<div class="galleryWrapDefault">
					<div class="galleryThumbDefault"><div class="imgWrap"><a href="#"><img src="images/collection/thumb1.jpg"/></a></div></div>
				</div>
				
				
				<div class="col-md-4 col-md-offset-4"><div class="col-md-10 col-md-offset-1"><a href="#" onclick="seeAll('${name}')" class="btnLong btnPurple btn-block icon-57-bag">查看所有图片</a></div></div>
			</div>
			
			<div class="row3 hidden-sm hidden-xs">

				<h2 class="SiYuanBold">高品摄影师</h2>
				<div class="row" id="phList">
					
					<div class="col-md-4">
						<a href="#" class="collectionThumb">
							<div class="leftImg"><img src="images/collection/collectionThunmb.jpg"/></div>
							<div class="rightInfo">
								<div class="photographerName">photographer name</div>
							</div>
						</a><!--collectionThumb-->
					</div>
					
				</div>
			</div><!--row3-->
			
			
		
		</div><!--subCont-->
	</div><!--container-->
</div><!--sectionCont-->
<!-- InstanceEndEditable -->
<jsp:include page="../inc/bottomflow.jsp" />
</body>
<!-- InstanceEnd --></html>
<script>
$(document).ready(function(){

	$(".collectionGallery .galleryWrapDefault").empty();
	$("#phList").empty();
	var temp = ${template};
	var name ="${name}";
	if(temp != null)
	{
		var urlHead = "webres/upload/"+temp.srcHead;
		var urlBig = "webres/upload/"+temp.srcBig;
	}
	
	$("#headFace").attr("src",urlHead);
	if(!urlHead || urlHead == "")
	{
		$(".photo").hide();
	}
	
	
	$("#big").attr("src",urlBig);
	
	loadPhotogerImages(name);
	getPhMap();
});


	function loadPhotogerImages(photographerName)
	{
		$(".collectionGallery .galleryWrapDefault").empty();
		var paras="?photographerName="+photographerName+"&p=1";
		var reqParas={n:25,key:"",sortType:4,ssid:""};
		var ajaxSearchUrl="search.do";
		$.ajax({
			type : "POST",
			url : ajaxSearchUrl + paras,// "search",
			data : reqParas,// {'key':$("#q").val(), 'n':n, 'ssid':searchSID},
			dataType : "json",
			success : function(data) {
				if (data.success) {
					var html ="";
					if(data.data != null)
					{

						var length = data.data.length;
						if(length > 12)
						{
							length = 12;
						}
						for(var i =0;i< length;i++)
						{
							html+='<div class="galleryThumbDefault">';
							html+='	<div class="imgWrap">';
							html+='	<a href="javascript:void(0)" onclick="goDetailByCidNoRela(\''+data.data[i].corbisId+'\',2)" ><img src="'+ data.data[i].imageHost+ 'THUMBNAIL/240/'+ data.data[i].path+ '" loading="true"></a>';
							html+='	</div>';
							html+='</div>';
							
						}

						//alert(html);
						$(".collectionGallery .galleryWrapDefault").html(html);
						  
					}

				} 
			},
			failed : function() {
				
			}
		});
	}
	
	function getPhMap()
	{
		var map = eval(${phMap});
		var count = eval(${count});
		var mapCount = eval(${listMap});
		var html ="";
		for(var i =0;i< count;i++)
		{
			var obj = map[mapCount[i]];
			html+='<div class="col-md-4">';
			html+='	<a href="photographer?pname='+obj.split("|")[0]+'"  class="collectionThumb">';//onclick="seeAll(\''+obj.split("|")[0]+'\')"
			html+='	<div class="leftImg"><img src="webres/upload/'+obj.split("|")[1]+'"></div>';
			html+='	<div class="rightInfo">';
			html+='		<div class="photographerName">'+obj.split("|")[0]+'</div>';
			html+='	</div>';
			html+='	</a><!--collectionThumb-->';
			html+='</div>';
						
		}
		$("#phList").html(html);
	}
	
	function seeAll(photographerName)
	{
	//		var url = "search#photographer="+encodeURI(photographerName)+"&p=1";
			var url = "search#photographer="+photographerName+"&p=1";
			window.open(url, "_blank");
	}
</script>

 