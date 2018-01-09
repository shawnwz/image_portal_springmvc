<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader.jsp" /> 
<script type="text/javascript" src="js/photographer.js"></script>
<script type="text/javascript" src="js/search_left.js"></script>
<script type="text/javascript" src="js/jquery.jqprint.js"></script>
		<!--[if IE 6]>
			<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a.js"></script>
			<script type="text/javascript">
				DD_belatedPNG.fix('.png-img');
			</script>
		<![endif]-->
	<script>
$(document).ready(function(){
	$("body").ajaxError(function(event,request, settings){
	     myAlert("有个请求出错了～");
	});
	$("body").ajaxSuccess(function(evt, request, settings){
	   
	 });
	 $("body").ajaxStart(function(){
	   startLoading();
	 });
	 $("body").ajaxStop(function(){
	   endLoading();
	 });
	myrefreshlightbox(true);
	 
	 $("#print-action").click(function(){
			var item =$("#picbox_center").clone();
			item.find(".picbox-page").remove();
			item.css("padding-left","0px").jqprint(); 
		});
	 });
	 
		
		
</script>

<!-- 内容区开始 -->
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />

    <div class="picbox" id="picbox">  
        <div class="MyLightboxes-title">
        	<p class="MyLightboxes-titletop">
            </p>
            <div class="MyLightboxes-name">
            	<p><b>${box.name}</b> </p>
            </div>
            <div class="MyLightboxes-center" id="MyLightboxes-center">
            	<p><span>客户</span><input type="text" class="de" value="名称" readonly="readonly" />${box.customer }</p>
            	<p><span>备注</span><textarea readonly="readonly" class="de">${box.memo }</textarea></p>
                <div class="MyLightboxes-right-box">
                	<p>
                    	修改: <span>${box.updateTime }</span><br />
						新建: <span>${box.createTime }</span>
                    </p>
                    <p class="topdotted">
                    	主人: <span>${user.userName} }</span>
                    </p>
                </div>
            </div>
        
        </div>  
           
        <div id="picbox_center" class="picbox-center" style="min-height:500px;">
            <c:forEach items="${list}" var="item" varStatus="stat">
            <%
				
			%>
            
<div class="picbox-picbox" id="divimage${map[item.corbisId].id}"><div id="bigdivimage${map[item.corbisId].id}" class="bigimagediv">
<div class="bigdivimagediv"></div><div id="addsearchimage${map[item.corbisId].id}" class="bigimageaddsearch">
<a class="mlt_link" href="javascript:void(0);">更多相似图片</a></div></div><div class="picbox-picbox-inner">
<a href="image/${map[item.corbisId].id}" target="_blank" class="imagelink170"><img id="minimage${map[item.corbisId].id}" 
src="${map[item.corbisId].imageHost}THUMBNAIL/${map[item.corbisId].path}"></a></div>
<p><b>${map[item.corbisId].licenseType==2?"RM":"RF"}</b><br>创意类<br>${map[item.corbisId].collectionName}<br>${map[item.corbisId].corbisId}<br></p>
<div class="picbox-pictext"><div>${map[item.corbisId].title}<br>${map[item.corbisId].caption}<br><b>图片库: </b>${map[item.corbisId].collectionName}<br>
<br><b>地点: </b>${map[item.corbisId].location}<br><br><b>肖像权同意书: </b>${map[item.corbisId].modelRealse}<br><b>产权同意书: </b>${map[item.corbisId].propertyRealse}<br><br></div></div></div>


			</c:forEach>

        </div>
        
    </div>

  
<!-- 内容区结束-->
<jsp:include page="../inc/pagebuttom.jsp" />
  