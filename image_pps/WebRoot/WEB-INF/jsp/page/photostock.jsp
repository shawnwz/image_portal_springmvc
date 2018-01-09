<%@page import="org.springframework.ui.ModelMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../inc/pageheader.jsp" %>
<script type="text/javascript" src="js/require.js"></script>
<script type="text/javascript" src="js/photographer.js"></script>
<script type="text/javascript" src="js/search_left.js"></script>
		<!--[if IE 6]>
			<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a.js"></script>
			<script type="text/javascript">
				DD_belatedPNG.fix('.png-img');
			</script>
		<![endif]-->
		    <script type="text/javascript">
		var FT  = FT || {};
		FT.vars = FT.vars || {};
		FT.vars.BASE_URL    = '';
		FT.vars.FRONT_PATH  = FT.vars.BASE_URL + 'js/';
		FT.vars.JQUERY_PATH = FT.vars.FRONT_PATH + 'jquery-1.8.2.min.js';
		FT.vars.SHORT_ID    = '_collection_detail';
		FT.vars.CURR_UID    = "0";
		FT.vars.CURR_USER   = "";
	</script>
<!-- 内容区开始 -->



<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/photographer.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<div class="main clearfix">

    <div class="left_div left">
    	        <h1 class="public_title"><span></span>
                             <a href="javascript:void(0);">创意类</a>
                     </h1>
        <ul class="left_ul">
        	            <li><a href="/photostock/7">版权正片</a></li>
                        <li><a href="/photostock/8" class="on">免版税图片</a></li>
                        <li><a href="/photostock/9">插画</a></li>
                        <li style="display:none;"><a href="#26">虚拟CD</a></li>
                    </ul>
                <h1 class="public_title"><span></span>
                             <a href="javascript:void(0);">编辑类</a>
                     </h1>
        <ul class="left_ul">
        	            <li><a href="/photostock/1">纪实</a></li>
                        <li><a href="/photostock/2">艺术作品</a></li>
                        <li><a href="/photostock/3">档案</a></li>
                        <li><a href="/photostock/4">时事与体育</a></li>
                        <li><a href="/photostock/5">娱乐</a></li>
                        <li><a href="/photostock/6">Outline</a></li>
                    </ul>
                    <c:if test="${cols[0]!=''&&cols[0]!=' ' }">
                    	<h1 class="public_title">
        	<span class="title_right right"></span> 
        	
        	 	<a href="javascript:void(0);">推荐图库 </a>
        		</h1>
        		</c:if>
        <ul class="left_ul">
        <c:forEach items="${cols}" var="item" varStatus="stat">
        	<c:if test="${item!=''&&item!=' '}">
				<li><a href="/photocollection/${item}" target="_blank">${item}</a></li>
			</c:if>
    	</c:forEach>
            </ul>
            	
            </div>

    <div class="right_div left">
    
    	<div class="public_title">
            <b>${menu.name}</b>
            <span class="right tt_ts">${menu.intro}</span>
            
        </div>
        <div class="tp_div">
           <c:forEach items="${temps}" var="item" varStatus="stat">
           
           <c:choose>
					<c:when test="${item.templateType==0 }">
							<div class="tp_div_list clearfix">
			                <div class="tp_list_left left">
			                <p><a href="search#groupId=${item.imageGroupId}" target="_blank"><img src="webres/upload/${item.indexImagePaths}" width="785"></a></p>
			                </div>
							<div class="Caption" style="float:right;"><a rel="" href="/image/${item.indexImages}" title="">${item.indexImages}</a>${item.imageCreditline }</div>
			                <div class="tp_list_right">
			                    <h1>${item.title}</h1>
			                    <p class="mtp5">${item.intro}</p>
			                    <p class="mtp5"><a href="search#groupId=${item.imageGroupId}" class="c6699cc" target="_blank">查看图像资源库</a></p>
			                </div>
			            </div>
					</c:when>
					<c:when test="${item.templateType==1 }">
						<div class="tp_div_list clearfix">
			                <div class="tp_list_left left">
			                <p><a href="search#groupId=${item.imageGroupId}" target="_blank"><img src="webres/upload/${item.indexImagePaths}" width="347"></a></p>
			                    					                </div>
			                <div class="tp_list_right right">
			                    <h1>${item.title}</h1>
			                    <p class="mtp5">${item.intro}</p>
			                    <p class="mtp5"><a href="search#groupId=${item.imageGroupId}" class="c6699cc" target="_blank">查看图像资源库</a></p>
			                </div>
			            </div>
			            <div class="Caption UnderCopy"><a rel="" href="/image/${item.indexImages}" title="">${item.indexImages}</a>${item.imageCreditline } </div>
					</c:when>
					<c:when test="${item.templateType==2 }">
						<div class="tp_div_list clearfix">
			                <div class="tp_list_right">
			                    <h1>${item.title}</h1>
			                    <p class="mtp5">${item.intro}</p>
			                    <p class="mtp5"><a href="search#groupId=${item.imageGroupId}" class="c6699cc" target="_blank">查看图像资源库</a></p>
			                </div>
			                <div class="tp_list_left left">
			                <p><a href="search#groupId=${item.imageGroupId}" target="_blank"><img src="webres/upload/${item.indexImagePaths}" width="785"></a></p>
			                </div>
							<div class="Caption" style="float:right;"><a rel="" href="/image/${item.indexImages}" title="">${item.indexImages}</a>${item.imageCreditline }</div>
			            </div>
					</c:when>
					<c:otherwise>
						<div class="tp_div_list clearfix">
			                <div class="tp_list_right">
			                    <h1>${item.title}</h1>
			                    <p class="mtp5">${item.intro}</p>
			                    <p class="mtp5"><a href="search#groupId=${item.imageGroupId}" class="c6699cc" target="_blank">查看图像资源库</a></p>
			                </div>
			                <ul class="ImageSet">
	<c:forEach items="${item.imageGroupslist}" var="ig" varStatus="stat">
				<li  class="first">
						<div  class="thumbWrap" onclick="window.location.href = 'search#groupId=${ig.id}'" style="display:table-cell;vertical-align:middle;">
				<span class="mbf-item" style="display:none;">#RSS image</span><img title="" src="webres/upload/${ig.coverImage}" alt="点击查看这个图片组">
			</div>
						<p>
							<strong>${ig.name }</strong><br>
							${ig.createTime}<br>
							图片组ID： ${ig.id}<br>
							<a title="点击查看这个图片组" href="search#groupId=${ig.id}">查看图片组</a>
						</p>
					</li>
	</c:forEach>
	
			</ul>
			                
			            </div>
			            </div>
					</c:otherwise>
			</c:choose>
				

    	   </c:forEach>
           
        	<div id="frcds" class="tp_div_list clearfix"></div>

    	</div>
        
        
    
    
    
    
    
    
    </div>
</div>
  
<!-- 内容区结束-->
<jsp:include page="../inc/pagebuttom.jsp" />
  
  
  
  