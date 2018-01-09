<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader_user.jsp" /> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="bodyClass" -->

<link href="flowsearch/css/image_gallary_base.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/sub2.js"></script>
<script type="text/javascript" src="flowsearch/js/jquery.simplyscroll.min.js"></script>
<script type="text/javascript" src="flowsearch/js/sub3.js"></script>
<script type="text/javascript" src="flowsearch/js/searchjerry.js"></script>

    <script type="text/javascript" src="flowsearch/js/search.js"></script>

<body class="pageImageSetDetail" oncontextmenu="return false" onselectstart="return false" ondragstart="return false;">
<!-- InstanceEndEditable -->
<%-- <jsp:include page="../inc/topflow.jsp" />  --%>



<jsp:include page="../inc/pagetop_user.jsp" /> 



<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">
	<div class="container details">
		<!-- SLIDER -->
		<div class="aside">
			<button class="asideLeft"><span class="left"></span></button>
			<button class="asideRight"><span class="right"></span></button>
			<p class="titleMobile">${item1.name }</p>
			<p class="countMobile"><span class="activeMobileLi">1</span> / <span class="countMobileLi">${imgcount }</span> 图片</p>
			<ul class="info_picture">
			<c:forEach items="${imglist}" var="img" varStatus="stat">
						 <c:choose>
							 <c:when test="${stat.index==0}">
                              	<li style="opacity:1">
                           	</c:when>
                           	<c:otherwise>
                           		<li>
                           	</c:otherwise>
                         </c:choose>
                         <span class="info_picture_span"></span>

					<p class="info_picture_p">${item1.name }</p>

					<h4>${img.caption}</h4>

					<ul class="info_liste">
							<%-- <c:if test="${img.priType==0}">
								<li class="small_info  info_top">
							 	<a href="javascript:void(0);" onclick="DownloadImage('${img.corbisId }');">
									<p><span class="download_info"></span> 下载</p>
								</a></li>
							</c:if>
							<c:if test="${img.priType==3}">
								<li class="small_info  info_top">
							 	<a href="javascript:void(0);" onclick="DownloadImageSepc('${img.corbisId }');">
									<p><span class="download_info"></span> 下载</p>
								</a>
								</li>
							</c:if>		
						

						<li class="small_info  info_top">
							<a href="javascript:void(0)"  onclick="addToLightBox('${img.corbisId}');" imgId="${img.corbisId}" >
								<p><span class="favorite_info"></span> 收藏</p>
							</a>
						</li> --%>

						<li class="big_info  info_top">
							<ul>
								<li>图片编号</li>
								<c:if test="${!empty img.photographerName && img.photographerName ne ''}">
								<li>摄影师</li>
								</c:if>
								<li>授权类型</li>
							</ul>

							<ul>
								<li>${img.corbisId}</li>
								<c:if test="${!empty img.photographerName && img.photographerName ne ''}">
            						<li>${img.photographerName}</li>
            					</c:if>
            					<c:choose>
										<c:when test="${img.licenseType eq 2 }">
											<li>Rights Managed (RM)</li>
										</c:when>
										<c:otherwise>
											<li>Royalty Free(RF)</li>
										</c:otherwise>
								</c:choose>
							</ul>
						</li>
						<li class="big_info button_big_info"><button class="info_picture_button"><span class="info_picture_plus">+</span>查看图片详细</button></li>

					</ul>
				</li>
	        </c:forEach>
			
			</ul>
		</div>

		<button class="mobileDetails activeButtonMobileCollection">图片详细</button>
		<button class="mobileCollection">更多影展</button>

		<div class="mobileInfo activeButtonMobileCollection">
			<c:forEach items="${imglist}" var="img" varStatus="stat">
				<div class="oneMobileInfo">
	                <div class="leftMobileInfo">
	                    <img src="${img.imageHost }THUMBNAIL/305/${img.path}${img.ext}" alt=""/>
	                </div>
	
	                <div class="rightMobileInfo">
	                    <div class="rightMobileInfoInner">
	                        <h1>${img.caption}</h1>
	                        <ul class="DetailsMobile FirstMobile">
	                            <li>图片编号</li>
								<c:if test="${!empty img.photographerName && img.photographerName ne ''}">
								<li>摄影师</li>
								</c:if>
	                            <li>授权类型</li>
	                        </ul>
	                        <ul class="DetailsMobile">
	                            <li>${img.corbisId}</li>
								<c:if test="${!empty img.photographerName && img.photographerName ne ''}">
            						<li>${img.photographerName}</li>
            					</c:if>
            					<c:choose>
										<c:when test="${img.licenseType eq 2 }">
											<li>Rights Managed (RM)</li>
										</c:when>
										<c:otherwise>
											<li>Royalty Free(RF)</li>
										</c:otherwise>
								</c:choose>
	                        </ul>
	                    </div>
	
	                </div>
<%-- 	                <ul class="buttonMobileInfo">
	                    <li>
	                        <a href="javascript:void(0);" onclick="DownloadImageSepc('${img.corbisId }');">
	                            <p><span class="download_info"></span> 下载</p>
	                        </a>
	                    </li>
	                    <li>
	                        <a href="javascript:void(0)"  onclick="addToLightBox('${img.corbisId}');" imgId="${img.corbisId}">
	                            <p><span class="favorite_info"></span> 收藏</p>
	                        </a>
	                    </li>
	                </ul> --%>
	            </div>
            </c:forEach>
		</div>

		<div class="image_slide">
			
			<div class="image_slide_content">
				
				<ul>
				<c:forEach items="${imglist}" var="img" varStatus="stat">
					<li><img src="imagegalleryview/${item1.id}/${img.corbisId}${img.ext}" alt=""></li>
				</c:forEach>
				</ul>
			</div>
		</div>

		<div class="carrouselDetails">

			<div class="carrouselDetailsThumb">
				

				<button class="carrouselLeft"><span class="carrouselLeftSpan"></span></button>
				<button class="carrouselRight"><span class="carrouselRightSpan"></span></button>
				
				<div class="align_carousel">
					
					<div class="content_thumb">
						
						<ul class="thumb">
						<c:forEach items="${imglist}" var="img" varStatus="stat">
							<c:choose>
							 <c:when test="${stat.index==0}">
                              	<li>
								<img src="${img.imageHost }THUMBNAIL/305/${img.path}${img.ext}" alt="" class="active_thumb">
								<p><span class"numberli"></span> / <span class="length"></span></p>
								</li>
                           	</c:when>
                           	<c:otherwise>
                           		<li>
								<img src="${img.imageHost }THUMBNAIL/305/${img.path}${img.ext}" alt="">
								<p><span class"numberli"></span> / <span class="length"></span></p>
							</li>
                           	</c:otherwise>
                         </c:choose>
						</c:forEach>
						</ul>
					</div>

				</div>
			</div>

		</div>

		<!-- END SLIDER -->

		<div class="collection">
			
			<div class="scroll_section">

				<span class="scroll_button"></span>
				<span class="scroll_button_up"></span>
				
				<ul id="scroller">
					
					<c:forEach items="${list}" var="item" varStatus="stat">
					
					<li>
						<h3>${item.name }</h3>
						<c:forEach items="${map[item.id]}" var="subitem" varStatus="stat">
						
								<div class="left_collection">
									<a href="imggallery${subitem.id}">
											<div class="left_left_collection">
												<span class="collection_scroll"></span>
												<h6>${subitem.name }</h6>
												<p>${subitem.info }</p>
											</div>
											<img src="webres/upload/${subitem.imageSetSrc}" alt="" />
									</a>
								</div>
							</c:forEach>
					</li>
				    </c:forEach>
					
				</ul>

			</div>


		</div>
		<button class="button_collection_details"><span class="buttonSpan"></span><span id="toggleButton_gallery">更多影展</span></button>
	</div>
</div>
<!-- InstanceEndEditable -->
			
<jsp:include page="../inc/bottomflow.jsp" />
</body>
<!-- InstanceEnd --></html>
