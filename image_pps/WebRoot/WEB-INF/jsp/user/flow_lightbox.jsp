<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/template.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>收藏夹</title>
	<!-- bgn -->

<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%
	String path = request.getContextPath();
	String basePath = new StringBuilder(request.getScheme()).append("://").append(request.getServerName())
						.append(":").append(request.getServerPort()).append(path).append("/").toString();
%>    

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width" />
<meta name="description" content="高品图像 – 高品质的图库摄影及插画">
<meta name="Keywords" content="网上购物,网上商城,高品,图像,版权,高品质,图库,摄影,插画,设计,美术,创意">
<base href=<%=basePath %>>
<link REL="SHORTCUT ICON" HREF="flowsearch/images/favorite.ico">


<link rel="Shortcut Icon" href="flowsearch/images/favorite.ico" type="image/x-icon" />
<link rel="Bookmark" href="flowsearch/images/favorite.ico" type="image/x-icon" />
<link rel="icon" href="flowsearch/images/favorite.ico" type="image/x-icon" />
<link href="flowsearch/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/layout.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/font.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/jquery.selectBox.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/nav.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/cont.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/responsive.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="flowsearch/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="flowsearch/js/modernizr.custom.10564.js"></script>
<script type="text/javascript" src="flowsearch/js/bootstrap.min.js"></script>
<script type="text/javascript" src="flowsearch/js/banner.js"></script>
<script type="text/javascript" src="flowsearch/js/jquery.md5.js"></script>
<script type="text/javascript" src="flowsearch/js/youziku.js"></script>
<script type="text/javascript" src="flowsearch/js/imagesloaded.pkgd.min.js"></script>
<script type="text/javascript" src="flowsearch/js/masonry.pkgd.min.js"></script>
<script type="text/javascript" src="flowsearch/js/jquery.infinitescroll.jerry.js"></script>
<script type="text/javascript" src="flowsearch/js/jquery.jcarousel.js"></script>
<link href="flowsearch/css/jcarousel.responsive.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/jquery.selectBox.js"></script>
<script type="text/javascript" src="flowsearch/js/icheck.js"></script>
<link href="flowsearch/css/blue.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/tooltipster.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/jquery.tooltipster.jerry.js"></script>
<!--[if lte IE 9]>
<script type="text/javascript" src="flowsearch/js/respond.min.js"></script>
<![endif]-->
<!-- InstanceBeginEditable name="head" -->
<script type="text/javascript" src="flowsearch/js/default.js"></script>
<script type="text/javascript" src="flowsearch/js/lightbox.js"></script>
<script type="text/javascript" src="flowsearch/myjs/jquery.cookie.js"></script>
<!-- InstanceEndEditable -->

<script type="text/javascript" src="flowsearch/js/nav.js"></script>

	<!-- end -->

<script type="text/javascript" src="flowsearch/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="flowsearch/js/jquery.ui.datepicker-zh-CN.js"></script>
<link href="flowsearch/css/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/userFavourite.js"></script>
<script type="text/javascript" src="flowsearch/js/jquery.fancybox.js"></script>
<link href="flowsearch/css/jquery.fancybox.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/jquery.tinyscrollbar.js"></script>

<script type="text/javascript" src="js/jquery.jqprint.js"></script>

<script>
 
//qp小样图下载
function DownloadImage(elesid)
{
	location.href = "dl/getImg.do?type=0&corbisId="+elesid;
}
//特殊小样图下载, 对应订阅计划
//跟qp显示时二选一
//下在时需要计数. 
function DownloadImageSepc(elesid)
{
	//elesid=eles.id的 
	location.href = "dl/getImg.do?type=3&corbisId="+elesid;
}

</script>
<link href="flowsearch/css/modal_dialog.css" rel="stylesheet" type="text/css">
<jsp:include page="../inc/qqheader.jsp" />

</head> 

<!-- InstanceBeginEditable name="bodyClass" -->
<body class="pageFavourite">
 
<jsp:include page="../inc/pagetop_user.jsp"/>


<!-- InstanceBeginEditable name="cont" -->

<div id="userCenterMobileMenu">
	
	<ul class="navMobile">
		<li><a href="my/person" class="iconUser">个人信息</a></li>
		<li class="active"><a href="#" class="iconFolder">收藏夹</a> <span class="icon-font icon-2-arrowRight"></span></li>
		<li><a href="my/myqp" class="iconHistory">下载记录</a></li>
		<li><a href="#" class="iconInvoice">发票</a></li>
		<li><a href="#" class="iconSet">套餐</a></li>
		<li><a href="#" class="btnLogOut btnPurple">退出登录</a></li>
	</ul>
	
	<div class="navMobileSub">
		<div class="favFolderControl">
			<span class="icon-font icon-46-createNew btnCreateNewInFav"></span>
			<span class="icon-font icon-50-trash"></span>
		</div>

		<div class="favouriteFolderList">
		</div>
	</div>
</div><!--userCenterMobileMenu-->



<div class="userCenterWrap">
	<div class="leftNav hidden-xs hidden-sm">
		<ul>
			<li ><a href="my/person" class="iconUser">个人信息</a></li>
			<li class="active"><a href="my/lightbox" class="iconFolder">收藏夹</a></li>
			<li><a href="my/myqp" class="iconHistory">下载记录</a></li>
			<li><a href="#" class="iconInvoice">发票</a></li>
			<li><a href="#" class="iconSet">套餐</a></li>
		</ul>
	</div><!--leftNav-->
	<div class="rightList hidden-xs hidden-sm">
		<div class="header">收藏夹列表</div>
		<a href="#" class="btnCreateNewInFav"><span class="icon-font icon-46-createNew"></span>创建一个新收藏夹</a>
        <div id="scrollbar">
            <div class="scrollbar"><div class="track"><div class="thumb"></div></div></div><!--scrollbar-->
            <div class="viewport">
                <div class="overview favouriteFolderList">
			    </div>
            </div>
        </div>
	</div><!--rightList-->
	<div class="midCont">
		<div class="favTop">
			<div class="row">
			
				<form id="lightBoxInfoForm">
					<div class="col-lg-4 col-md-12 form-group">
						<div class="row">
							<div class="col-lg-12 col-md-6  col-xs-6">
								<input class="form-control lightBoxInfoName editLive visible-lg visible-md" cols="" rows="1" id="lightBoxInfoName" name="lightBoxInfoName" value="秋天图片收集"/>
								<div class="visible-sm visible-xs">
									<select id="phoneLightBox">
<!-- 										<option>秋天图片收集1</option> -->
<!-- 										<option>秋天图片收集2</option> -->
<!-- 										<option>秋天图片收集3</option> -->
<!-- 										<option>秋天图片收集4</option> -->
									</select>
								</div>
							</div>
							<div class="col-lg-12 col-md-6  col-xs-6">
								<div class="shareWrap">
									<span class="visible-lg-inline-block visible-md-inline-block">分享到：</span>
									<!--<a href="#" class="icon-font icon-42-users fancybox fancybox.iframe" data-toggle="modal" data-target="#myModal"></a>-->
									<a href="lbFormShareMember.na?width=750&height=320&lightboxid=${lightboxId }&sendEmailer=${sendEmailer}" class="icon-font icon-42-users fancybox fancybox.iframe" sendEmailer="${sendEmailer}"></a>
									<a href="lbFormShareEmail.na?width=750&height=660&lightboxid=${lightboxId }&sendEmailer=${sendEmailer}" class="icon-font icon-54-shareEmail fancybox fancybox.iframe" sendEmailer="${sendEmailer}"></a>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-8 col-md-12">
						<div class="row">
							<div class="form-group col-lg-6 col-md-12 col-sm-6">
								<div class="row">
									<label class="col-lg-4 col-md-2 control-label">客户：</label>
									<div class="col-lg-8 col-md-10">
										<input type="text" class="form-control editLive" id="lightBoxInfoClient" name="lightBoxInfoClient">
									</div>
								</div><!--row-->
							</div>
							<div class="form-group col-lg-6 col-md-12 col-sm-6">
								<div class="row">
									<label class="col-lg-4 col-md-2 control-label">项目：</label>
									<div class="col-lg-8 col-md-10">
										<input type="text" class="form-control editLive" id="lightBoxInfoProject" name="lightBoxInfoProject">
									</div>
								</div><!--row-->
							</div>
							<div class="form-group col-lg-12">
								<div class="row">
									<label class="col-md-2 control-label">笔记：</label>
									<div class="col-md-10">
										<textarea class="form-control editLive" cols="" rows="" id="lightBoxInfoNote" name="lightBoxInfoNote"></textarea>
									</div>
								</div><!--row-->
							</div>
						</div>
					</div><!--col-md-9-->
				</form>
			</div>
		</div><!--favTop-->
			<div class="favouriteBar">
			
				<div class="pull-left">
					<div class="label visible-lg visible-md">全部：</div>
					<div class="btnWrap iconWrap twoIcon">
<!-- 						<a href="#" class="icon-font icon-31-shoppingCart2" style=" display: none; "></a> -->
						<a href="#" class="icon-font icon-22-download"></a>
						<a href="#" class="icon-font icon-50-trash"></a>
					</div>
					<div class="pagination-sm visible-xs" style=" height: auto; ">
						<a href="#" class="icon-font icon-1-arrowLeft"></a>
						<input name="" type="text" value="1"/>
						<span class="total" style=" height: 34px; line-height: 34px; "> / 1</span>
						<a href="#" class="icon-font icon-2-arrowRight"></a>
					</div>
				</div>
				<div class="pull-right" style=" display: none; ">
					<select>
						<option>最近添加</option>
						<option>创意类</option>
						<option>编辑类</option>
					</select>
				</div>
			</div><!--favouriteBar-->	
		<div class="favouriteGalleryWrap">
		

			
			
			<div class="favouriteGallery layout3 globalDetail">
		
				 

			</div><!--favouriteGallery-->
	
	
	
	
			<div class="pageNumWrap">
				<a href="#" class="btnPrev icon-font icon-1-arrowLeft" ></a>
				<input name="" type="text" class="targetNum" value="1"/>
				<a href="#" class="btnNext">
					<span class="left">/ 1 </span>
					<span class="right SiYuan-ExtraLight">下一页</span>
				</a>
			</div>
		</div><!--favouriteGalleryWrap-->	
	</div><!--midCont-->
	
</div><!--userCenterWrap-->


<!-- Modal -->
<!--<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
-->


<!-- Modal -->
<!--<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>-->




<!-- InstanceEndEditable -->
<jsp:include page="../inc/bottomflow.jsp" />





			
</body>
<!-- InstanceEnd --></html>
