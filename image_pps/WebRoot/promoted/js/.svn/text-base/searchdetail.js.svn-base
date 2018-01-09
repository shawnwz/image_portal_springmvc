var relaCids="";
var searchSID;
var ajaxSearchUrl="search.do";
var similarIds = "";
var photoIds = "";
(function ( $ ) {
	$(document).ready(function() {
		
		
		
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
//							var sons = privateGetSonItems(data.data,n.id);
//							myCurLightBoxs[n.id]=n;
							var html = '<li class="" lightboxid="'+n.id+'">'+n.name+'<span class="num">'+n.imageNum+'</span><span>图片</span></li>';
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
						}	
						 
					} else if (data && data.error == 401) {
						//alert("请先登录");
						//
					} else {
						//alert("请先登录");
					}
				});



	//-------------- left filter panel
		
		
		
		//for prev next images. 
		var args=getUrlArgs();
		if(args&&args["rids"])
		{
			relaCids=args["rids"];
			$.cookie("dhash",location.hash);
		}
		//=========================================================================
		//loadSimilar
		$(".prevImage").click(goPrevImage);
		$(".nextImage").click(goNextImage);
		loadSimilarImages();
		loadPhotogerImages();
		
		 $("input[type='radio'][name='cm']").on('ifChecked', function(event){
		        var idx=$("input[type='radio'][name='cm']").index(this);
		        $("input[type='radio'][name='px']").eq(idx).iCheck('check');
		    });
		    $("input[type='radio'][name='px']").on('ifChecked', function(event){
		        var idx=$("input[type='radio'][name='px']").index(this);
		        $("input[type='radio'][name='cm']").eq(idx).iCheck('check');
		    });

		    // 查看更多 展开、收缩
		    $('.viewMore').toggle(function(){
		        $(this).removeClass('viewMore').addClass('viewMoreUp').text('关闭');
		        $(this).find('.viewDown').addClass('viewUp').removeClass('viewDown');
		        $('.moreDesc').stop('true','true').slideDown();
		    },function(){
		        $(this).removeClass('viewMoreUp').addClass('viewMore').text('查看更多');
		        $(this).find('.viewUp').addClass('viewDown').removeClass('viewUp');
		        $('.moreDesc').stop('true','true').slideUp();
		    });

			if( $('.galleryWrap').length > 0)
			{
				var $container = $('.galleryWrap').masonry({
					itemSelector : '.galleryWrap .galleryThumb'
				});
				
				$container.imagesLoaded( function() {
				  $container.masonry();
				});
			}


		    $('a').tooltip();
		    
		    
	});
	
	//相似图片
	function loadSimilarImages()
	{
		$(".partSimilar").find("ul").html("");
		var paras="?smid="+CurrentCorbisId+"&p=1";
		var reqParas={n:25,key:"",sortType:4,ssid:""};
		$.ajax({
			type : "POST",
			url : ajaxSearchUrl + paras,// "search",
			data : reqParas,// {'key':$("#q").val(), 'n':n, 'ssid':searchSID},
			dataType : "json",
			success : function(data) {
				if (data.success) {
					var html ="";
					var length = data.data.length;
					if(length > 24)
					{
						length = 24;
					}
					
					for(var i =0;i< length;i++)
					{
						if(i%8 == 0)
						{
							html+='<li>';
						}
						
						html+='<div class="mySlideLi">';
						html+='	<a href="javascript:void(0)" onclick="goDetailByCidNoRela(\''+data.data[i].corbisId+'\',1)" class="boxCollection" data-original-title="" title="">';
						html+='    <img src="'+ data.data[i].imageHost+ 'THUMBNAIL/240/'+ data.data[i].path+ '">';
						html+='	</a>';
						similarIds+=data.data[i].corbisId+",";
						i++;
                        if(data.data[i] != undefined)
                        {
							html+='    <a href="javascript:void(0)"  onclick="goDetailByCidNoRela(\''+data.data[i].corbisId+'\',1)"  class="boxCollection" data-original-title="" title="">';
							html+='    	<img src="'+ data.data[i].imageHost+ 'THUMBNAIL/240/'+ data.data[i].path+ '">';
							html+='		</a>';
							
							similarIds+=data.data[i].corbisId+",";
                        }
						html+='</div>';
						if(i%8 == 7 || i >= data.data.length-1)
						{
							html+='</li>';
						}

					}
					
					$(".partSimilar").find("ul").html(html);
					 //  类似图片 切换
				    myTab('#myTabLeft1',"#myTabRight1");
				}
			},
			failed : function() {
				
			}
		});
	}
	
	//摄影师作品
	function loadPhotogerImages()
	{
		var paras="?photographerName="+photographerName+"&p=1";
		var reqParas={n:25,key:"",sortType:4,ssid:""};
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
						if(length > 24)
						{
							length = 24;
						}
						for(var i =0;i< length;i++)
						{
							if(i%8 == 0)
							{
								html+='<li>';
							}
							
							html+='<div class="mySlideLi">';
							html+='	<a href="javascript:void(0)"  onclick="goDetailByCidNoRela(\''+data.data[i].corbisId+'\',2)"  class="boxCollection" data-original-title="" title="">';
							html+='    <img src="'+ data.data[i].imageHost+ 'THUMBNAIL/240/'+ data.data[i].path+ '">';
							html+='	</a>';

							photoIds+=data.data[i].corbisId+",";
							i++;
	                        if(data.data[i] != undefined)
	                        {
								html+='    <a href="javascript:void(0)"  onclick="goDetailByCidNoRela(\''+data.data[i].corbisId+'\',2)"  class="boxCollection" data-original-title="" title="">';
								html+='    	<img src="'+ data.data[i].imageHost+ 'THUMBNAIL/240/'+ data.data[i].path+ '">';
								html+='		</a>';

								photoIds+=data.data[i].corbisId+",";
	                        }
							html+='</div>';
							if(i%8 == 7 || i >= data.data.length-1)
							{
								html+='</li>';
							}
						}

						//alert(html);
						$(".photogerImages").find("ul").html(html);
						 //  类似图片 切换
					    myTab('#myTabLeft2',"#myTabRight2");
					}

				} 
			},
			failed : function() {
				
			}
		});
	}
	
	 function myTab(leftBtn,rightBtn){
	        var oLi=$('.mySlideShowDiv li:first');
	        var targetWidth=1068;//parseInt(oLi.css('width'));
	        var count=0;
	        $(leftBtn).click(function(){
	            var aLi=$(this).parent().prev().find('li');
	            count++;
	            if(count>=aLi.length){
	                count=0;
	            }
	            $(this).parent().prev().find('ul').animate({marginLeft:targetWidth*-count+'px'});
	        });
	        $(rightBtn).click(function(){

	            var aLi=$(this).parent().prev().find('li');
	            count--;
	            if(count<0){
	                count=aLi.length-1;
	            }
	            $(this).parent().prev().find('ul').animate({marginLeft:targetWidth*-count+'px'});
	        });
	    }
	   


	
}( jQuery ));



function goPrevImage()
{
	if(!CurrentCorbisId||CurrentCorbisId.length<=2)
		return;
	var rightcid=CurrentCorbisId;
	var rids=relaCids.split(",");
	for(var i=1;i<rids.length;i++)
	{
		if(rids[i]&&rids[i]==CurrentCorbisId)
			if(rids[i-1]&&rids[i-1].length>0)
				rightcid=rids[i-1];
	}
	
	goDetailByCid(rightcid,basePath);
}
function goNextImage()
{
	if(!CurrentCorbisId||CurrentCorbisId.length<=2)
		return;
	var rightcid=CurrentCorbisId;
	var rids=relaCids.split(",");
	for(var i=0;i<rids.length-1;i++)
	{
		if(rids[i]&&rids[i]==CurrentCorbisId)
			if(rids[i+1]&&rids[i+1].length>0)
				rightcid=rids[i+1];
	}
	goDetailByCid(rightcid,basePath);
}

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
function goDetail(item,base)
{
	var b="";
	if(base&&base.length>0)
	b=base;
	var cid=item.find("img").attr("imgid");
	var relaids=relaCids;
	var url=basePath+"imagesflow/"+cid+"#rids="+relaids;
	//window.open(url, "_blank");
	location.href=url;
}


function FindSameImage(imageid) {
	
	window.open("search#smid="+imageid+"&p=1", "_blank");
	
}
function genSearchSID() {
	searchSID = (new Date()).valueOf();
}

function seeAll(imageid)
{
	var type =$(".tagTitle").find("li[class=active]").attr("type");
	//alert(type);
	
	if(type == "si")
	{
		window.open("search#smid="+imageid+"&p=1", "_blank");
	}
	if(type == "ph")
	{
//		var url = "search#photographer="+encodeURI(photographerName)+"&p=1";
		var url = "search#photographer="+photographerName+"&p=1";
		window.open(url, "_blank");
	}
	
	
}



function goDetailByCid(cid,base)
{
	var b="";
	if(base&&base.length>0)
		b=base;
	
	
	var relaids=relaCids;
	var url=basePath+"imagesflow/"+cid+"#rids="+relaids;
	window.open(url, "_self");
	//location.href=url;
}



function goDetailByCidNoRela(cid,base)
{
	var url="";
	if(base=="1")
	{
		url=basePath+"imagesflow/"+cid+"#rids="+similarIds;
	}
	if(base=="2")
	{
		url=basePath+"imagesflow/"+cid+"#rids="+photoIds;
	}
	  
	window.open(url, "_blank");
	//location.href=url;
}