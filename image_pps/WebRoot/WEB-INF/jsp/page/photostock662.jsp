<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- InstanceEndEditable -->
<body class="pageCreativeRF">
<jsp:include page="../inc/pagetop_user.jsp" /> 
<link href="flowsearch/css/sub.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/sub2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/sub2.js"></script>
<script type="text/javascript" src="flowsearch/js/searchjerry.js"></script>
<script type="text/javascript" src="flowsearch/js/searchbar.js"></script>
    

<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">
	<div class="container">
		<!--pageCreativeRM-->
		<div class="topBanner720">
			<div class="bgImg"><img src="webres/upload/${item2.src }"/></div>
			<div class="pageHeaderWrap">
				<div class="SiYuanBold header">${item2.title }</div>
				<div class="Source-Han-Light headerSub">${item2.info }</div>
			</div><!--pageHeaderWrap-->
			
						
			
			<div class="searchBar">
				<div class="searchBarInner col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<span class="SiYuan-ExtraLight hidden">搜索高品图像</span>
					<input class="searchFiled SiYuan-ExtraLight" name="q" id="q" type="text" placeholder="搜索高品图像"></input>
					<a href="search#cate_id=662" class="btnSearch icon-font icon-13-search"></a>
				</div>
			</div>
			
			<div class="bannerBtm clearBoth">
				<div class="icon col-md-4 icon-61-sun">
					<h3 class="Source-Han-Light">${item31.title }</h3>
					<p>${item31.info }</p>
				</div>
				<div class="icon col-md-4 icon-62-rocket">
					<h3 class="Source-Han-Light">${item32.title }</h3>
					<p>${item32.info }</p>
				</div>
				<div class="icon col-md-4 icon-63-diamond">
					<h3 class="Source-Han-Light">${item33.title }</h3>
					<p>${item33.info }</p>
				</div>
			</div><!--bannerBtm-->
		</div><!--topBanner720-->
		
		<div class="row row2">
			<div class="col-md-6">
				<h2 class="SiYuanBold">最新RF图库</h2>
				<a href="${item4.url}" class="collectionGroup groupFour">
					<div class="imgWrap">
						<div class="imgInner clearBoth">
						<c:forEach items="${item4s}" var="item" varStatus="stat">
							<div class="cube"><img src="webres/upload/${item.src }"/></div>
	                	</c:forEach>
						</div>
					</div><!--groupWrap-->
					<div class="titleWrap">
						<div class="name">${item4.title }</div>
						<div class="tag">${item4.info }</div>
					</div><!--titleWrap-->
				</a><!--collectionGroup
				<a href="${item4l.url }" class="linkMore hidden-sm hidden-xs">${item4l.title }</a>-->
			</div>
			<div class="col-md-6">
				<h2 class="SiYuanBold">最新RF专辑</h2>
				<a href="${item5.url }" class="collectionGroup groupOne">
					<div class="imgWrap">
						<div class="imgInner clearBoth">
							<img src="webres/upload/${item5.src }"/>
						</div>
					</div><!--groupWrap-->
					<div class="titleWrap">
						<div class="name">${item5.title }</div>
					</div><!--titleWrap-->
				</a><!--collectionGroup
				<a href="${item5l.url }" class="linkMore hidden-sm hidden-xs">${item5l.title }</a>-->
			</div>
			<div class="col-md-12">
				<h2 class="SiYuanBold">高品RF分类</h2>
				<div class="collectionGroupMore clearBoth">
					<div class="col-lg-2 col-lg-offset-1">
						<c:forEach items="${item6s}" var="item" varStatus="stat">
						 <c:choose>
							 <c:when test="${stat.index%5==0}">
                              <a href="${item.url }">${item.title }</a>
                           	</c:when>
                         </c:choose>
	                	</c:forEach>
					</div>
					<div class="col-lg-2">
						<c:forEach items="${item6s}" var="item" varStatus="stat">
						 <c:choose>
							 <c:when test="${(stat.index-1)%5==0}">
                              <a href="${item.url }">${item.title }</a>
                           	</c:when>
                         </c:choose>
	                	</c:forEach>
					</div>
					<div class="col-lg-2">
						<c:forEach items="${item6s}" var="item" varStatus="stat">
						 <c:choose>
							 <c:when test="${(stat.index-2)%5==0}">
                              <a href="${item.url }">${item.title }</a>
                           	</c:when>
                         </c:choose>
	                	</c:forEach>
					</div>
					<div class="col-lg-2">
						<c:forEach items="${item6s}" var="item" varStatus="stat">
						 <c:choose>
							 <c:when test="${(stat.index-3)%5==0}">
                              <a href="${item.url }">${item.title }</a>
                           	</c:when>
                         </c:choose>
	                	</c:forEach>
					</div>
					<div class="col-lg-2">
						<c:forEach items="${item6s}" var="item" varStatus="stat">
						 <c:choose>
							 <c:when test="${(stat.index-4)%5==0}">
                              <a href="${item.url }">${item.title }</a>
                           	</c:when>
                         </c:choose>
	                	</c:forEach>
					</div>
				</div><!--collectionGroup-->
			</div>
		</div>
		
	</div><!--container-->
</div><!--sectionCont-->
<!-- InstanceEndEditable -->

<jsp:include page="../inc/bottomflow.jsp" />





			
</body>
<!-- InstanceEnd --></html>
