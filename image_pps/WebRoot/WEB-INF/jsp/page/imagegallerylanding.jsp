<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- InstanceEndEditable -->
<body class="">
<jsp:include page="../inc/pagetop_user.jsp" /> 

<link href="flowsearch/css/sub.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/sub2.js"></script>
<script type="text/javascript" src="flowsearch/myjs/flowpage.jerry.js"></script>  

<link href="flowsearch/css/image_gallary_base.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/image_gallery_landing.css" rel="stylesheet" type="text/css">

<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">
	<div class="container1920">
        <div class="bannerWrap autoRotate">
            <div class="bannerImgWrap">
                <div class="proDecsBox">
                    <p class="title_landing">${item1.title }</p>
                    ${item1.info}
                </div>
                <div class="bannerImg">
                    <img src="${item1.src}"/>
                </div>
            </div>
        </div><!--bannerWrap-->
		<hr class="mobile_show"></hr>
	</div>
	
	<div class="container">
	
		<c:forEach items="${list}" var="item" varStatus="stat">

	    <div class="border_top">
			<h1 class="">${item.galleryCap}</h1>
			${item.galleryDesc}	
		</div>

<!-- cms  todo: check wrapper little or big-->
            <div class="wrapper">
            <div class="small">
				<h2 class="SiYuan-ExtraLight">${item.name }</h2>
				<p class="mobile_h2 Source-Han-Light">${item.name}</p>
				<p class="Source-Han-Light">${item.info}</p>

				<div class="button">
					<button class="more">+</button>
				</div>
			</div>
				<c:forEach items="${map[item.id]}" var="subitem" varStatus="stat">
					<c:if test="${subitem.style  eq 'middle'}">
						<div class="${subitem.style }">
							<a href="imggallery${subitem.id}" class="boxCollection no_margin_links">					
								<img src="webres/upload/${subitem.src }" orgi="flowsearch/images/landing/wrap_2_midlle.png" alt="image_section"class="image_box"/>
								<img src="flowsearch/images/landing/button_collection.png" alt="button_collection" class="button_collection" />
								<h3 class="Source-Han-Light">${subitem.name }</h3>
								<small class="Source-Han-Light">${subitem.info }</small>
							</a>
							<div class="mobile_landing">
								<a href="imggallery${subitem.id}">
									<img src="webres/upload/${subitem.src }" orgi="flowsearch/images/landing/wrap_2_midlle.png" alt="image_section"class="image_box"/>
									<div class="content_mobile_landing">
										<img src="flowsearch/images/landing/button_collection.png" alt="" />
										<p>${subitem.name }</p>
									</div>
								</a>
							</div>
						</div>
					</c:if>
					<c:if test="${subitem.style  eq 'middle half'}">
						<div class="${subitem.style }">
							<a href="imggallery${subitem.id}" class="boxCollection no_margin_links half_links">					
								<img src="webres/upload/${subitem.src }" orgi="flowsearch/images/landing/wrap_2_midlle.png" alt="image_section"class="image_box"/>
								<img src="flowsearch/images/landing/button_collection.png" alt="button_collection" class="button_collection half_collection" />
								<h3 class="Source-Han-Light">${subitem.name }</h3>
								<small class="Source-Han-Light">${subitem.info }</small>
							</a>
							<div class="mobile_landing">
								<a href="imggallery${subitem.id}">
									<img src="webres/upload/${subitem.src }" orgi="flowsearch/images/landing/wrap_2_midlle.png" alt="image_section"class="image_box"/>
									<div class="content_mobile_landing">
										<img src="flowsearch/images/landing/button_collection.png" alt="" />
										<p>${subitem.name }</p>
									</div>
								</a>
							</div>
						</div>
					</c:if>
					<c:if test="${subitem.style  eq 'large'}">
						<div class="${subitem.style }">
							<a href="imggallery${subitem.id}" class="boxCollection no_margin_links">					
								<img src="webres/upload/${subitem.src }" orgi="flowsearch/images/landing/wrap_2_midlle.png" alt="image_section"class="image_box"/>
								<img src="flowsearch/images/landing/button_collection.png" alt="button_collection" class="button_collection" />
								<h3 class="Source-Han-Light">${subitem.name }</h3>
								<small class="Source-Han-Light">${subitem.info }</small>
							</a>
			<!-- todo: double check, if show big img in mobile or not -->
							<div class="mobile_landing">
								<a href="imggallery${subitem.id}">
									<img src="webres/upload/${subitem.src }" orgi="flowsearch/images/landing/wrap_2_midlle.png" alt="image_section"class="image_box"/>
									<div class="content_mobile_landing">
										<img src="flowsearch/images/landing/button_collection.png" alt="" />
										<p>${subitem.name }</p>
									</div>
								</a>
							</div>
						</div>
					</c:if>
					<c:if test="${subitem.style  eq 'middle borderLine'}">
						<div class="${subitem.style }">
							<a href="imggallery${subitem.id}" class="boxCollection no_margin_links">					
								<img src="webres/upload/${subitem.src }" orgi="flowsearch/images/landing/wrap_2_midlle.png" alt="image_section"class="image_box"/>
								<img src="flowsearch/images/landing/button_collection.png" alt="button_collection" class="button_collection" />
								<h3 class="Source-Han-Light">${subitem.name }</h3>
								<small class="Source-Han-Light">${subitem.info }</small>
							</a>
							<div class="mobile_landing">
								<a href="imggallery${subitem.id}">
									<img src="webres/upload/${subitem.src }" orgi="flowsearch/images/landing/wrap_2_midlle.png" alt="image_section"class="image_box"/>
									<div class="content_mobile_landing">
										<img src="flowsearch/images/landing/button_collection.png" alt="" />
										<p>${subitem.name }</p>
									</div>
								</a>
							</div>
						</div>
					</c:if>
					
				</c:forEach>
            </div>
	    </c:forEach>
	    
	    
		<c:if test="${tp ne 1 }">
	    <div class="fenyeGroup">
            <div class="pagination-sm">
            </div>
            <div class="fenye">
            </div>
        </div>
		</c:if>
	</div>
</div>
<!-- InstanceEndEditable -->



<!-- InstanceEndEditable -->
<jsp:include page="../inc/bottomflow.jsp" />

<c:if test="${tp ne 1 }">
<script type="text/javascript">
$(document).ready(function(){
	var targetele=$(".fenyeGroup");
	targetele.find(".pagination-sm").mpageing(${p},${tp},function(p){
		location.href="imggallery?p="+p;
	});
	targetele.find(".fenye").pageing(${p},${tp},function(p){
		location.href="imggallery?p="+p;
	});
	
});
</script>
</c:if>
			
</body>
<!-- InstanceEnd --></html>
