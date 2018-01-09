<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	$(document).ready(function() {
		$("body").ajaxError(function(event, request, settings) {
			myAlert("有个请求出错了～");
		});
		$("body").ajaxSuccess(function(evt, request, settings) {

		});
		$("body").ajaxStart(function() {
			startLoading();
		});
		$("body").ajaxStop(function() {
			endLoading();
		});
		//myrefreshlightbox(true);

		$("#print-action").click(function() {
			var item = $("#picbox_center").clone();
			item.find(".picbox-page").remove();
			item.css("padding-left", "0px").jqprint();
		});
	});
</script>

<!-- 内容区开始 -->
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />

<div class="picbox" id="picbox">
	<div class="MyLightboxes-title">
		<p class="MyLightboxes-titletop"></p>
		<div class="MyLightboxes-name" style="    height: auto;background-color: #333;">
			<p style="border-bottom: 0px;">
				<b>${box.name}</b>
			</p>
		</div>
		<div class="MyLightboxes-center" id="MyLightboxes-center">
			<p>
				<span>客户</span>${box.customer }
			</p>
			<p style="height: 85px;">
				<span>备注</span>
				<span readonly="readonly" class="de">${box.memo }</span >
			</p>
			<div class="MyLightboxes-right-box"  style="height: 94px;">
				<p>
					修改: <span>${box.updateTime }</span><br /> 新建: <span>${box.createTime
						}</span>
				</p>
				<p class="topdotted" style="overflow: hidden;">
					主人: <span title="${user.userName}">${user.userName}</span>
				</p>
			</div>
		</div>

	</div>

	<div id="picbox_center" class="picbox-center" style="min-height:500px;">
		<c:forEach items="${data}" var="item" varStatus="stat">
			<div class="picbox-picbox" id="divimage${item.id}">
				<div id="bigdivimage${item.id}" class="bigimagediv">
					<div class="bigdivimagediv"></div>
					<div id="addsearchimage${item.id}" class="bigimageaddsearch">
						<a class="mlt_link" href="javascript:void(0);">更多相似图片</a>
					</div>
				</div>
				<div class="picbox-picbox-inner">
					<a href="image/${item.corbisId}" target="_blank"
						class="imagelink170"><img id="minimage${item.id}"
						src="${item.imageHost}THUMBNAIL/180/${item.path}"> </a>
				</div>
				<p>
					<b>${item.licenseType==2?"RM":"RF"}</b><br>${item.collectionName}<br>${item.corbisId}<br>
				</p>
				<div class="picbox-pictext">
					<div>
						${item.title}<br>${item.caption}<br> <b>图片库: </b>${item.collectionName}<br>
						<br> <b>地点: </b>${item.location}<br> <br> <b>肖像权同意书:
						</b>${(item.modeStatus!=null && item.modeStatus==2)?"有授权":"没有授权"}<br> <b>产权同意书: </b>${(propertyStatus!=null && propertyStatus==2)?"有授权":"没有授权"}<br>
						<br>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<!-- 内容区结束-->
<jsp:include page="../inc/pagebuttom.jsp" />
