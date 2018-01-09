<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<jsp:include page="../inc/pageheader_user.jsp" />
<link href="flowsearch/css/automobile.css" rel="stylesheet"	type="text/css" />

<link href="flowsearch/css/automobile_responsive.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="flowsearch/js/automobile.js"></script>
<script type="text/javascript" src="flowsearch/js/slidetrans.js"></script>

 <script type="text/javascript">
	var title = "${item_section_one_countTilte}";
	title = title.split(",");
	title[0] = title[0].substr(1);
	var arrEnd = title.length - 1;
	var strEnd = title[arrEnd].length - 1;
	title[arrEnd] = title[arrEnd].substring(0, strEnd);
</script> 

</head>

<body class="pageCar">
	<jsp:include page="../inc/pagetop_user.jsp" />
	<!-- banner + search bar -->
	<div id="sectionCont" class="pageLanding">
		<div class="container1920">

			<div class="bannerWrap autoRotate">
				<div class="bannerImgWrap">

					<div class="proDecsBox">
						<p class="title SiYuanBold">${item_banner.title }</p>
						<p class="property">${item_banner.info}</p>
					</div>

					<div class="bannerImg" style="display: block; position: relative;">
						<img src="webres/upload/${item_banner.src}" width="1920"
						ss	height="670" />
					</div>
				</div>
				<div class="searchBar">
					<div class="container">
						<div class="searchBarInner col-md-9">
							<span class="SiYuan-ExtraLight hidden">${item_searchbar.title}</span>
							<input class="searchFiled SiYuan-ExtraLight" name="q" id="q"
								type="text" placeholder="${item_searchbar.title}"> <a
								href="${item_searchbar.url}"
								class="btnSearch icon-font icon-13-search"></a>
						</div>
					</div>
				</div>
			</div>
			<!--bannerWrap-->
		</div>
	</div>
	<div class="auto_container">


		<div class="center_content">
			<!-- section 1 -->

			<div class="center_content1">

				<a href="javascript:void(0)">
					<ul class="num" id="idNum2">
					</ul>
				</a>
			</div>
		</div>



		<div class="center_content">
			<div class="center_content2">
				<div class="img-scroll" id="idContainer2">
						<span class="prev" id="idPre"><a href="javascript:void(0)">
						    <img src="images/arrow_left.png"></a>
						</span> 
						<span class="next" id="idNext"><a href="javascript:void(0)">
						    <img src="images/arrow_right.png"></a>
						</span> 
					<input
						id="idStop" type="button" value="停止自动 " style="display:none;" />
					<input id="idStart" type="button" value="开始自动"
						style="display:none;" />

					<div class="img-list" id="idTransformView2">
						<ul class="slider slider2" id="idSlider2">

							<c:forEach items="${item_section_one}" var="itemArray"
								varStatus="i">

								<!-- Each and every one in the list of images -->


								<li><table class="photo_group${i.index}">
										<c:forEach items="${itemArray}" var="item" varStatus="status">
											<%-- 
											<c:set var="item_pure_num"
												value="${fn:substring(item, 0, item.lastIndexOf('.'))}" />
											--%>
											<c:set var="item_pure_num"
												value="${item}" />

											<c:if test="${status.index%3==0}">
												<tr>
											</c:if>

											<td><a
												href="http://www.gaopinimages.com/imagesflow/${item_pure_num}">
													<img src="webres/upload/${item}">
											</a></td>

											<c:if test="${status.index%3==2}">
												</tr>
											</c:if>
										</c:forEach>
									</table></li>
							</c:forEach>

							</tr>
					</div>
				</div>
			</div>
		</div>



		<!-- section2 -->
		<div class="center_content">
			<div class="center_content3">
				<div class="content3">
					<img class="photo_HDRI" src="webres/upload/${item_section_two.src}">
					<div class="font_HDRI">${item_section_two.title}</div>
				</div>
			</div>
		</div>
		<div class="center_content">
			<div class="center_content4">
				<div class="content3">${item_section_five.title }
					${item_section_five.info }</div>
			</div>
		</div>



		<!-- section 3 -->
		<div class="center_content">
			<div class="center_content5">
				<div class="content3">
					<div class="photo_father">
						<img src="webres/upload/${item_section_three_imgbig}">
					</div>
					<div class="photo_son">
						<table>
							<c:forEach items="${item_section_three_imgsmall}" var="item"
								varStatus="status">
								<c:if test="${status.index%3==0}">
									<tr>
								</c:if>
								<td><img src="webres/upload/${item}"></td>
								<c:if test="${status.index%3==2}">
									</tr>
								</c:if>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>

		</div>
		<!-- section 4 -->
		<div class="center_content">
			<div class="center_content6">
				<div class="content3">
					<span class="font_title">${item_section_four.title}</span>
						${item_section_four.info}
						<!--section file -->
			
				</div>
			</div>
		</div>


	</div>
	<jsp:include page="../inc/bottomflow.jsp" />
</body>
<!-- InstanceEnd -->
</html>
