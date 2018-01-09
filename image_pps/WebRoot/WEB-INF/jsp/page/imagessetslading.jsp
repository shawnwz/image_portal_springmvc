<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- InstanceEndEditable -->
<body class="">
<jsp:include page="../inc/pagetop_user.jsp" /> 

<link href="flowsearch/css/sub.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/sub2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/sub2.js"></script>
<script type="text/javascript" src="flowsearch/myjs/flowpage.jerry.js"></script>  



<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">
	<div class="container border_top">
	
		<h1 class="SiYuanBold">${item1.title }</h1>
		<small>${item1.info}</small>
		<c:forEach items="${list}" var="item" varStatus="stat">
            <div class="wrapper">
            <div class="small">
				<h2 class="SiYuan-ExtraLight">${item.name }</h2>
				<p class="Source-Han-Light">${item.info}</p>
				<div class="button">
					<button class="more">+</button>
				</div>
			</div>
				<c:forEach items="${map[item.id]}" var="subitem" varStatus="stat">
					<c:if test="${subitem.style  eq 'middle'}">
						<div class="${subitem.style }">
							<a href="imgsets${subitem.id}" class="boxCollection no_margin_links">					
								<img src="webres/upload/${subitem.src }" orgi="flowsearch/images/landing/wrap_2_midlle.png" alt="image_section"class="image_box"/>
								<img src="flowsearch/images/landing/button_collection.png" alt="button_collection" class="button_collection" />
								<h3 class="Source-Han-Light">${subitem.name }</h3>
								<small class="Source-Han-Light">${subitem.info }</small>
							</a>
							<div class="mobile_landing">
								<a href="imgsets${subitem.id}">
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
							<a href="imgsets${subitem.id}" class="boxCollection no_margin_links">					
								<img src="webres/upload/${subitem.src }" orgi="flowsearch/images/landing/wrap_2_midlle.png" alt="image_section"class="image_box"/>
								<img src="flowsearch/images/landing/button_collection.png" alt="button_collection" class="button_collection" />
								<h3 class="Source-Han-Light">${subitem.name }</h3>
								<small class="Source-Han-Light">${subitem.info }</small>
							</a>
							<div class="mobile_landing">
								<a href="imgsets${subitem.id}">
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
							<a href="imgsets${subitem.id}" class="boxCollection no_margin_links half_links">					
								<img src="webres/upload/${subitem.src }" orgi="flowsearch/images/landing/wrap_2_midlle.png" alt="image_section"class="image_box"/>
								<img src="flowsearch/images/landing/button_collection.png" alt="button_collection" class="button_collection half_collection" />
								<h3 class="Source-Han-Light">${subitem.name }</h3>
								<small class="Source-Han-Light">${subitem.info }</small>
							</a>
							<div class="mobile_landing">
								<a href="imgsets${subitem.id}">
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
							<a href="imgsets${subitem.id}" class="boxCollection no_margin_links">					
								<img src="webres/upload/${subitem.src }" orgi="flowsearch/images/landing/wrap_2_midlle.png" alt="image_section"class="image_box"/>
								<img src="flowsearch/images/landing/button_collection.png" alt="button_collection" class="button_collection" />
								<h3 class="Source-Han-Light">${subitem.name }</h3>
								<small class="Source-Han-Light">${subitem.info }</small>
							</a>
							<div class="mobile_landing">
								<a href="imgsets${subitem.id}">
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
	    
	    
	    <div class="fenyeGroup">

			<div class="pageNumWrap">
			</div>

            <div class="fenye">
            </div>
        </div>
	</div>
</div>
<!-- InstanceEndEditable -->



<!-- InstanceEndEditable -->
<jsp:include page="../inc/bottomflow.jsp" />

<script type="text/javascript">
$(document).ready(function(){
	var targetele=$(".fenyeGroup");
	targetele.find(".pageNumWrap").mpageing(${p},${tp},function(p){
		location.href="imgsets?p="+p;
	});

	targetele.find(".fenye").pageing(${p},${tp},function(p){
		location.href="imgsets?p="+p;
	});
	
});
</script>
			
</body>
<!-- InstanceEnd --></html>
