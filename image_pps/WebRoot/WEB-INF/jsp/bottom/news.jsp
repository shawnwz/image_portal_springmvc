<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- InstanceEndEditable -->
<body class="newsPage">
<jsp:include page="../inc/pagetop_user.jsp" /> 
<link href="flowsearch/css/sub.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/sub2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/sub2.js"></script>
<script type="text/javascript" src="flowsearch/js/easyResponsiveTabs.jerry.js"></script>
<script type="text/javascript" src="flowsearch/myjs/flowpage.jerry.js"></script>  
<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">




    <div class="container">

        <div class="row">
            <div class="col-md-12">
                <div class="sub-menu">
                    <ul>
                        <li><a class="Source-Han-Light " href="aboutus.html">About Us</a></li>
                        <li><a class="Source-Han-Light " href="contactus.html">联系我们</a></li>
                        <li><a class="Source-Han-Light active" href="news.html">高品新闻</a></li>
                        <li><a class="Source-Han-Light " href="careers.html">加入我们</a></li>
                        <li><a class="Source-Han-Light " href="terms.html">条款和政策</a></li>
                    </ul>
                </div>
                <div class="sub-menuMobile">
                    <span class="curSubPage">高品新闻 <span class="icon-font icon-19-arrowdown"></span></span>
                    <ul>
                        <li><a class="Source-Han-Light" href="aboutus.html">About Us</a></li>
                        <li><a class="Source-Han-Light" href="contactus.html">联系我们</a></li>
                        <li><a class="Source-Han-Light" href="news.html">高品新闻</a></li>
                        <li><a class="Source-Han-Light" href="careers.html">加入我们</a></li>
                        <li><a class="Source-Han-Light" href="terms.html">条款和政策</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2">
                <ul class="nav nav-tabs" role="tablist">
                <li class="active"><a href="#tab1" role="tab" data-toggle="tab" data-original-title="" title="">所有</a></li>
                <c:forEach items="${tags}" var="item" varStatus="stat">
                	<li><a href="#tab${stat['index']+2}" role="tab" data-toggle="tab" data-original-title="" title="">${item.name}</a></li>
                </c:forEach>
                </ul>
            </div>

            <div class="tab-content col-md-10">
	             <div class="tab-pane active" id="tab1" tag="">
	                    <div class="row">
	                    </div>
	                    <div class="pagination-sm">
	                    </div>
	                    <div class="fenye">
	                    </div>
	             </div>
            	<c:forEach items="${tags}" var="item" varStatus="stat">
                	<div class="tab-pane" id="tab${stat['index']+2}" tag="${item.name}">
	                    <div class="row">
	                    </div>
	                    <div class="pagination-sm">
	                    </div>
	                    <div class="fenye">
	                    </div>
	             </div>
                </c:forEach>
            </div>
        </div><!-- row -->
    </div>




</div><!--sectionCont-->
<!-- InstanceEndEditable -->
	 
<jsp:include page="../inc/bottomflow.jsp" />


<script type="text/javascript">
$(document).ready(function(){
	
	var loading=0;
	var gotoPage=function(page,typename,targetele)
	{
		if(loading==1)
		 {
		 		setTimeout(function(){
		 			gotoPage(page,typename,targetele);
		 			},2000);
		 		loading=0;
		 }
		 
		loading=1;
		targetele.find(".row").empty();
		$.post("news.do",{p:page,type:typename},function(data){
			loading=0;
			if(data.success&&data.data)
			{
				targetele.find(".row").empty();
				var tag=targetele.attr("tag");
				for(var i=0;i<data.data.length;i++)
				{
					var item=data.data[i];	
					var html="";
					if(i==0)
					{
						html+='<div class="col-md-12 firstNews">';
            html+='                <a class="imgNewsLink" href="newsdetails/'+item.id+'.html?type='+encodeURIComponent(tag)+'" >';
            html+='                    <div class="imgNewsBox">';
            html+='                        <img src="webres/upload/'+item.thumbBig+'" alt=""/>';
            html+='                    </div>';
            html+='                    <div class="releaseDate">'+item.publishTimeStr10+'</div>';
            html+='                </a>';
            html+='                <div class="newsTest">';
            html+='                    <a href="newsdetails/'+item.id+'.html?type='+encodeURIComponent(tag)+'"  class="title SiYuanBold">'+item.title+'</a>';
            html+='                    <a href="newsdetails/'+item.id+'.html?type='+encodeURIComponent(tag)+'"   class="desc">'+item.intro+'</a>';
            html+='                    <a class="getMore"  href="newsdetails/'+item.id+'.html?type='+encodeURIComponent(tag)+'" >了解更多</a>';
            html+='                </div>';
            html+='</div>';
						
						
					}else
					{
							
           html+='             <div class="col-md-6 otherNews">';
           html+='                 <a class="imgNewsLink" href="newsdetails/'+item.id+'.html?type='+encodeURIComponent(tag)+'" >';
           html+='                     <div class="imgNewsBox">';
           html+='                         <img src="webres/upload/'+item.thumbMid+'"  alt=""/>';
           html+='                     </div>';
           html+='                     <div class="releaseDate">'+item.publishTimeStr10+'</div>';
           html+='                 </a>';
           html+='                 <div class="newsTest">';
           html+='                     <a  href="newsdetails/'+item.id+'.html?type='+encodeURIComponent(tag)+'"  class="title SiYuanBold">'+item.title+'</a>';
           html+='                     <a  href="newsdetails/'+item.id+'.html?type='+encodeURIComponent(tag)+'"   class="desc">'+item.intro+'</a>';
           html+='                 </div>';
           html+='             </div>';
							
					}
						
					targetele.find(".row").append(html);
				}
				
				targetele.find(".pagination-sm").mpageing(data.p,data.tp,function(p){
					return gotoPage(p,typename,targetele);
				});
				targetele.find(".fenye").pageing(data.p,data.tp,function(p){
					return gotoPage(p,typename,targetele);
				});
			}	
		});
		
		return true;
	}
	
	gotoPage(1,"",$(".tab-content .tab-pane.active"));
	var index=1;
	
	$(".tab-content .tab-pane").slice(1).each(
			
			function(){
				var that=$(this);
			setTimeout(function(){
			gotoPage(1,that.attr("tag"),that);
			},1000*index);
			index++;
			}
	);
	
	
	
});


</script>
</body>
<!-- InstanceEnd --></html>
