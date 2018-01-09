<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图片详细页</title>
<%@include file="/headerflow.jsp"%>
<!-- InstanceBeginEditable name="head" -->
<script type="text/javascript" src="flowsearch/js/searchdetail.js"></script>
<link href="flowsearch/css/jqModal.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/jquery.jqModal.js"></script>

<!-- InstanceEndEditable -->
<script>
	var _hmt = _hmt || [];
	(function() {
  		var hm = document.createElement("script");
  		hm.src = "//hm.baidu.com/hm.js?06d046c45fc354feaec92ccb1e49f895";
  		var s = document.getElementsByTagName("script")[0]; 
  		s.parentNode.insertBefore(hm, s);
	})();
</script>
<jsp:include page="../inc/qqheader.jsp" />
</head>

<body class="pageDetail">

	<jsp:include page="../inc/pagetop_user.jsp" />


	<!-- InstanceBeginEditable name="cont" -->
	<script type="text/javascript">
var CurrentCorbisId='${imageInfo.corbisId}';
var photographerName='${photographer.name}';
var groupId='${groupId}';
var basePath='<%=basePath%>';
</script>

	<div id="sectionCont">

		<div class="container">

			<div class="detailWrap">

				<div class="row">
					<div class="col-md-12 shareDiv">
						<a href="javascript:;"
							class="icon-font icon-2-arrowRight nextImage"></a> <a
							href="javascript:;"
							class="icon-font icon-1-arrowLeft funcLeft prevImage"></a> <a
							href="javascript:;" style="display: none"
							class="shareAlink hidden-sm hidden-xs icon-font icon-icon-37-plane funcLeft "></a>
					</div>
				</div>
				<!-- row -->

				<div class="row detailPhotoRow">
					<div class="col-md-7 detailPhoto">
						<img src="${webUrl}" alt="" />
					</div>
					<div class="col-md-4 detailPhotoDesc">
						<div class="detailTitle Source-Han-Light">${imageInfo.title }</div>
						<p class="descP">${imageInfo.caption}</p>
						<div class="detailTab hide">
							<!-- Nav tabs -->
							<ul class="nav nav-tabs" role="tablist">
								<li class="active"><a href="#detailTab1" role="tab"
									data-toggle="tab">CM</a></li>
								<li><a href="#detailTab2" role="tab" data-toggle="tab">PX</a></li>
							</ul>

							<!-- Tab panes -->
							<div class="tab-content">
								<div class="tab-pane active" id="detailTab1">
									<form action="">
										<div class="radioMargin">
											<label> <input type="radio" name="cm" /> <span
												class="model">XS</span> <span class="price">￥420</span>
											</label> <span class="detailSpan Source-Han-Light">30 MB -
												2668cm × 4000cm @ 72 ppi</span>
										</div>
										<div class="radioMargin">
											<label for="label2"> <input type="radio" name="cm"
												id="labelcm2" /> <span class="model">S</span> <span
												class="price">￥550</span>
											</label> <span class="detailSpan Source-Han-Light">30 MB -
												2668cm × 4000cm @ 300 ppi</span>
										</div>
										<div class="radioMargin">
											<label for="label3"> <input type="radio" name="cm"
												id="labelcm3" /> <span class="model">M</span> <span
												class="price">￥960</span>
											</label> <span class="detailSpan Source-Han-Light">30 MB -
												2668cm × 4000cm @ 300 ppi</span>
										</div>
										<div class="radioMargin">
											<label for="label4"> <input type="radio" name="cm"
												id="labelcm4" /> <span class="model">L</span> <span
												class="price">￥1,200</span>
											</label> <span class="detailSpan Source-Han-Light">30 MB -
												2668cm × 4000cm @ 300 ppi</span>
										</div>
										<div class="radioMargin">
											<label for="label5"> <input type="radio" name="cm"
												id="labelcm5" /> <span class="model">XL</span> <span
												class="price">￥10,550</span>
											</label> <span class="detailSpan Source-Han-Light">30 MB -
												2668cm × 4000cm @ 300 ppi</span>
										</div>
									</form>
								</div>
								<div class="tab-pane" id="detailTab2">
									<form action="">

										<div class="radioMargin">
											<label for="label1"> <input type="radio" name="px"
												id="label1" /> <span class="model">XS</span> <span
												class="price">￥420</span>
											</label> <span class="detailSpan Source-Han-Light">30 MB -
												2668px × 4000px @ 72 ppi</span>
										</div>
										<div class="radioMargin">
											<label for="label2"> <input type="radio" name="px"
												id="label2" /> <span class="model">S</span> <span
												class="price">￥550</span>
											</label> <span class="detailSpan Source-Han-Light">30 MB -
												2668px × 4000px @ 300 ppi</span>
										</div>
										<div class="radioMargin">
											<label for="label3"> <input type="radio" name="px"
												id="label3" /> <span class="model">M</span> <span
												class="price">￥960</span>
											</label> <span class="detailSpan Source-Han-Light">30 MB -
												2668px × 4000px @ 300 ppi</span>
										</div>
										<div class="radioMargin">
											<label for="label4"> <input type="radio" name="px"
												id="label4" /> <span class="model">L</span> <span
												class="price">￥1,200</span>
											</label> <span class="detailSpan Source-Han-Light">30 MB -
												2668px × 4000px @ 300 ppi</span>
										</div>
										<div class="radioMargin">
											<label for="label5"> <input type="radio" name="px"
												id="label5" /> <span class="model">XL</span> <span
												class="price">￥10,550</span>
											</label> <span class="detailSpan Source-Han-Light">30 MB -
												2668px × 4000px @ 300 ppi</span>
										</div>
									</form>
								</div>
							</div>
						</div>
						<!-- detailTab -->
						<div class="btnBox">
							<a href="contactus.html" class="btnCountacUs"><span
								class="icon-font icon-icon-38_calculate"></span>联系我们查询更多信息</a>
						</div>
						<div class="funcBox">
							<div class="btnWrap iconWrap funcIcon">
								<c:if test="${priType==0}">
									<a href="javascript:void(0)"
										onclick="DownloadImage('${imageInfo.corbisId}','<%=basePath %>');"><span
										class="icon-font icon-22-download"></span><span>下载</span></a>
									<a href="javascript:void(0)" class="icon-11-favourite-click"
										imgId="${imageInfo.corbisId}"><span
										class="icon-font icon-11-favourite"></span><span>收藏</span></a>
									<a href="javascript:void(0)"
										onclick="FindSameImage('${imageInfo.corbisId}');"><span
										class="icon-font icon-29-search2"></span><span>相似</span></a>
								</c:if>
								<c:if test="${priType==3}">
									<a href="javascript:void(0)"
										onclick="DownloadImageSepc('${imageInfo.corbisId}','<%=basePath %>');"><span
										class="icon-font icon-22-download"></span><span>下载</span></a>
									<a href="javascript:void(0)" class="icon-11-favourite-click"
										imgId="${imageInfo.corbisId}"><span
										class="icon-font icon-11-favourite"></span><span>收藏</span></a>
									<a href="javascript:void(0)"
										onclick="FindSameImage('${imageInfo.corbisId}');"><span
										class="icon-font icon-29-search2"></span><span>相似</span></a>
								</c:if>
								<c:if test="${priType!=3 and priType!=0}">
									<a href="javascript:void(0)"
										onclick="DownloadImageWithWaterMark('${imageInfo.corbisId}','<%=basePath %>');"><span class="icon-font icon-22-download"></span><span>下载</span></a>
									<a href="javascript:void(0)" 
										class="icon-11-favourite-click" imgId="${imageInfo.corbisId}"><span
										class="icon-font icon-11-favourite"></span><span>收藏</span></a>
									<a href="javascript:void(0)" 
										onclick="FindSameImage('${imageInfo.corbisId}');"><span
										class="icon-font icon-29-search2"></span><span>相似</span></a>
								</c:if>

							</div>
						</div>
						<div class="fullSescription">
							<div class="scriptionLine">
								<span class="scriptionLeftSpan">图片编号</span><span>${imageInfo.corbisId}</span>
							</div>
							<c:if test="${!empty photographer.name && photographer ne ''}">
								<div class="scriptionLine">
									<span class="scriptionLeftSpan">摄影师</span>
									<!--             photographer/${photographer.id} -->
									<span><a
										href="search#photographer=${photographer.name}&p=1"
										target="_blank">${photographer.name}</a></span>
								</div>
							</c:if>
							<div class="scriptionLine">
								<span class="scriptionLeftSpan">授权类型</span>
								<c:choose>
									<c:when test="${licenseType eq 'RM' }">
										<span>Rights Managed <a href="javascript:;"
											data-toggle="tooltip" data-placement="bottom" title=""
											data-original-title="Rights Managed">(RM)</a></span>
									</c:when>
									<c:otherwise>
										<span>Royalty Free <a href="javascript:;"
											data-toggle="tooltip" data-placement="bottom" title=""
											data-original-title="Royalty Free">(RF)</a></span>
									</c:otherwise>
								</c:choose>

							</div>
							<div class="scriptionLine">
								<span class="scriptionLeftSpan">肖像权状态</span> <span>${modeRelease}</span>
							</div>
							<div class="scriptionLine">
								<span class="scriptionLeftSpan">产权状态</span> <span>${propertyRelease}</span>
							</div>
<!-- 							<div class="scriptionLine">
								<span class="scriptionLeftSpan">限制说明</span><span><a
									href="javascript:;">打开详细</a></span>
							</div> -->
							<c:if test="${!empty restrictions}">
								<div class="scriptionLine"><span class="scriptionLeftSpan">限制/说明</span>
											<c:forEach items="${restrictions}" var="restriction" varStatus="stat">
											<div style="float:left;"><span>● </span><span style="width:280px;padding-left:3px;float:right;">${restriction}</span></div>
											</c:forEach>
											<div style="float:left;height: 35px;"></div>
								</div>
            				</c:if>
							<div class="viewMore hidden-xs hidden-sm">
								查看更多 <span class="viewDown"></span>
							</div>
							<div class="moreDesc">
								<c:if test="${!empty photoDate}">
									<div class="scriptionLine">
										<span class="scriptionLeftSpan">拍摄日期</span> <span>${photoDate}</span>
									</div>
								</c:if>
								<c:if test="${!empty imageInfo.location}">
									<div class="scriptionLine">
										<span class="scriptionLeftSpan">拍摄地点</span><span><a
											href="javascript:;">${ imageInfo.location }</a></span>
									</div>
								</c:if>

								<div class="scriptionLine">
									<span class="scriptionLeftSpan">出处</span><span>${imageInfo.creditLine}
								</div>
<%-- 								<div class="scriptionLine">
									<span class="scriptionLeftSpan">类别</span><span><a
										href="photostock/${imageCategory.id}">${imageCategory.name}</a></span>
								</div> --%>
								<div class="scriptionLine"><span class="scriptionLeftSpan">类别</span><span>${imageCategory_showname}</span></div>
								<div class="scriptionLine">
									<span class="scriptionLeftSpan">图片库</span><span><a
										href="search#cid=${collection.id}">${collection.name}</a></span>
								</div>
								<div class="scriptionLine">
									<span class="scriptionLeftSpan">最大的尺寸</span><span>${maxSize}</span>
								</div>
							</div>
							<div class="shareDiv visible-xs visible-sm">
								<a href="javascript:;"
									class="icon-font icon-2-arrowRight nextImage"></a> <a
									href="javascript:;"
									class="icon-font icon-1-arrowLeft prevImage"></a> <a
									href="javascript:;" style="display: none"
									class="shareAlink icon-font icon-icon-37-plane funcLeft"></a>
							</div>
						</div>
					</div>
				</div>

				<div class="row hidden-sm hidden-xs">

					<div class="col-md-12 groupShown">
						<div class="albumsTitle">
							<span class="sameAlbum Source-Han-Light"><span
								class="icon-font icon-6-collection"></span>同一专辑</span> <a
								href="javascript:;" onClick="seeAllinGroup(${groupId})" class="viweMoreDiv">查看所有</a>
						</div>
					</div>
					<div class="albumsBox col-md-12 groupShown">
						<div class="row">
							<div class="col-sm-11 col-md-11 mySlideTab">
								<div class="mySlideShowDiv groupImages">
									<ul>
										<li>
											<div class="mySlideLi">
												<a href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image001.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image006.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image005.jpg"></a>
											</div>
										</li>
										<li>
											<div class="mySlideLi">
												<a href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image001.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image005.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image004.jpg"></a>
											</div>
											<div class="mySlideLi">
												<a href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image003.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image006.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image005.jpg"></a>
											</div>
											<div class="mySlideLi">
												<a href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image005.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image006.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image002.jpg"></a>
											</div>
											<div class="mySlideLi">
												<a href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image003.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image008.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image007.jpg"></a>
											</div>
										</li>
										<li>
											<div class="mySlideLi">
												<a href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image001.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image006.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image008.jpg"></a>
											</div>
											<div class="mySlideLi">
												<a href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image007.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image004.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image006.jpg"></a>
											</div>
											<div class="mySlideLi">
												<a href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image006.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image004.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image002.jpg"></a>
											</div>
											<div class="mySlideLi">
												<a href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image007.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image002.jpg"></a> <a
													href="javascript:void(0)" class="boxCollection"> <img
													src="images/detail/detail-image006.jpg"></a>
											</div>
										</li>
									</ul>
								</div>
							</div>

							<div class="col-sm-1 col-md-1">
								<a href="javascript:;" id="myTabLeft4"
									class="nextLi icon-font icon-2-arrowRight"></a> <a
									href="javascript:;" id="myTabRight4"
									class="pervLi icon-font icon-1-arrowLeft"></a>
							</div>
						</div>
					</div>
					
					<div class="col-md-12">
						<!-- Nav tabs -->
						<ul class="nav nav-tabs Source-Han-Light tagTitle" role="tablist">
							<li class="active" type="si"><a href="#tab1" role="tab"
								data-toggle="tab">相似图片</a></li>


							<li type="ph"
								<c:if test="${empty photographer.name || photographer eq ''}"> style="display:none;" </c:if>>
								<a href="#tab2" role="tab" data-toggle="tab">摄影师作品</a>
							</li>
							<div class="viweMoreDiv">
								<a href="javascript:void(0);"
									onclick="seeAll(${imageInfo.corbisId})">查看所有</a>
							</div>
						</ul>
						<!-- Tab panes -->

						<div class="tab-content row">
							<div class="tab-pane active" id="tab1">
								<div class="col-sm-11 col-md-11 mySlideTab">
									<div class="mySlideShowDiv partSimilar">
										<ul>
										</ul>
									</div>
								</div>

								<div class="col-sm-1 col-md-1">
									<a href="javascript:;" id="myTabLeft1"
										class="nextLi icon-font icon-2-arrowRight"></a> <a
										href="javascript:;" id="myTabRight1"
										class="pervLi icon-font icon-1-arrowLeft"></a>
								</div>
							</div>
							<div class="tab-pane" id="tab2">

								<div class="col-sm-11 col-md-11 mySlideTab">
									<div class="mySlideShowDiv photogerImages">
										<ul>
											<li>
												<div class="mySlideLi marginNagLeft15">
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image001.jpg"></a>
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image002.jpg"></a>
												</div>
												<div class="mySlideLi">
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image003.jpg"></a>
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image004.jpg"></a>
												</div>
												<div class="mySlideLi">
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image005.jpg"></a>
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image006.jpg"></a>
												</div>
												<div class="mySlideLi">
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image007.jpg"></a>
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image008.jpg"></a>
												</div>
											</li>
											<li>
												<div class="mySlideLi marginNagLeft15">
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image001.jpg"></a>
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image002.jpg"></a>
												</div>
												<div class="mySlideLi">
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image003.jpg"></a>
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image004.jpg"></a>
												</div>
												<div class="mySlideLi">
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image005.jpg"></a>
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image006.jpg"></a>
												</div>
												<div class="mySlideLi">
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image007.jpg"></a>
													<a href="javascript:void(0)" class="boxCollection"> <img
														src="flowsearch/images/detail/detail-image008.jpg"></a>
												</div>
											</li>
										</ul>
									</div>
								</div>

								<div class="col-sm-1 col-md-1">
									<a href="javascript:;" id="myTabLeft2"
										class="nextLi icon-font icon-2-arrowRight"></a> <a
										href="javascript:;" id="myTabRight2"
										class="pervLi icon-font icon-1-arrowLeft"></a>
								</div>

							</div>
						</div>
					</div>
					<div class="col-md-12">
						<div class="keywordsRow">
							<span class="keywordSpan">关键字</span>
							<div class="keywordsBox">
								<c:forEach items="${keyslist}" var="key" varStatus="stat">
									<a href="/search#q=${key}"><span class="badge">${key}</span></a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<!-- row -->

			</div>
			<!-- detailWrap -->

		</div>
		<!-- container -->

	</div>
	<!--sectionCont-->

	<jsp:include page="../inc/bottomflow.jsp" />
</body>
</html>


