<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ page import="com.gaopin.entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/template.dwt" codeOutsideHTMLIsLocked="false" -->
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,user-scalable=no"/>
<title>${title}</title>
<%
	String path = request.getContextPath();
	String basePath = new StringBuilder(request.getScheme()).append("://").append(request.getServerName())
						.append(":").append(request.getServerPort()).append(path).append("/").toString();
%>   
<base href=<%=basePath %>>
<!-- InstanceBeginEditable name="doctitle" -->
<!-- InstanceEndEditable -->
<link rel="Shortcut Icon" href="flowsearch/images/favorite.ico" type="image/x-icon" />
<link rel="Bookmark" href="flowsearch/images/favorite.ico" type="image/x-icon" />
<link rel="icon" href="flowsearch/images/favorite.ico" type="image/x-icon" />
<link href="flowsearch/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/layout.css" rel="stylesheet" type="text/css" />
<link href="css-flow/font.css" rel="stylesheet" type="text/css" />
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
<script type="text/javascript" src="flowsearch/js/jquery.infinitescroll.js"></script>
<script type="text/javascript" src="flowsearch/js/jquery.jcarousel.js"></script>
<link href="flowsearch/css/jcarousel.responsive.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/jquery.selectBox.js"></script>
<script type="text/javascript" src="flowsearch/js/icheck.js"></script>
<link href="flowsearch/css/blue.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/tooltipster.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/jquery.tooltipster.js"></script>
<script type="text/javascript" src="flowsearch/js/jquery.validate.js"></script>
<script type="text/javascript" src="flowsearch/js/form.jerry.js"></script>
<!--[if lte IE 9]>
<script type="text/javascript" src="flowsearch/js/respond.min.js"></script>
<![endif]-->
<!-- InstanceBeginEditable name="head" -->
    <link href="flowsearch/css/jqModal.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="flowsearch/js/defaultjerry.js"></script>
    <script type="text/javascript" src="flowsearch/js/lightbox.js"></script>
    <script type="text/javascript" src="flowsearch/js/jquery.jqModal.js"></script>
    <script type="text/javascript" src="flowsearch/js/sub.js"></script>
<script type="text/javascript" src="flowsearch/js/jquery.tinyscrollbar.js"></script>
<script type="text/javascript" src="flowsearch/myjs/jquery.cookie.js"></script>
<link href="flowsearch/css/sub.css" rel="stylesheet" type="text/css" />
<!-- InstanceEndEditable -->

<!-- DHAE -->
<link href="flowsearch/css/landingPages.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/nav.js"></script>
<script type="text/javascript" src="flowsearch/js/searchbar.js"></script>
<!-- end of DHAE -->

<!--qq-->
<link href="flowsearch/css/qqstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/qqstyle.js"></script>
<style type="text/css">
.WPA3-SELECT-PANEL { z-index:2147483647; width:463px; height:292px; margin:0; padding:0; border:1px solid #d4d4d4; background-color:#fff; border-radius:5px; box-shadow:0 0 15px #d4d4d4;}
.WPA3-SELECT-PANEL * { position:static; z-index:auto; top:auto; left:auto; right:auto; bottom:auto; width:auto; height:auto; max-height:auto; max-width:auto; min-height:0; min-width:0; margin:0; padding:0; border:0; clear:none; clip:auto; background:transparent; color:#333; cursor:auto; direction:ltr; filter:; float:none; font:normal normal normal 12px "Helvetica Neue", Arial, sans-serif; line-height:16px; letter-spacing:normal; list-style:none; marks:none; overflow:visible; page:auto; quotes:none; -o-set-link-source:none; size:auto; text-align:left; text-decoration:none; text-indent:0; text-overflow:clip; text-shadow:none; text-transform:none; vertical-align:baseline; visibility:visible; white-space:normal; word-spacing:normal; word-wrap:normal; -webkit-box-shadow:none; -moz-box-shadow:none; -ms-box-shadow:none; -o-box-shadow:none; box-shadow:none; -webkit-border-radius:0; -moz-border-radius:0; -ms-border-radius:0; -o-border-radius:0; border-radius:0; -webkit-opacity:1; -moz-opacity:1; -ms-opacity:1; -o-opacity:1; opacity:1; -webkit-outline:0; -moz-outline:0; -ms-outline:0; -o-outline:0; outline:0; -webkit-text-size-adjust:none; font-family:Microsoft YaHei,Simsun;}
.WPA3-SELECT-PANEL a { cursor:auto;}
.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-TOP { height:25px;}
.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-CLOSE { float:right; display:block; width:47px; height:25px; background:url(http://combo.b.qq.com/crm/wpa/release/3.3/wpa/views/SelectPanel-sprites.png) no-repeat;}
.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-CLOSE:hover { background-position:0 -25px;}
.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-MAIN { padding:23px 20px 45px;}
.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-GUIDE { margin-bottom:42px; font-family:"Microsoft Yahei"; font-size:16px;}
.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-SELECTS { width:246px; height:111px; margin:0 auto;}
.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-CHAT { float:right; display:block; width:88px; height:111px; background:url(http://combo.b.qq.com/crm/wpa/release/3.3/wpa/views/SelectPanel-sprites.png) no-repeat 0 -80px;}
.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-CHAT:hover { background-position:-88px -80px;}
.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-AIO-CHAT { float:left;}
.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-QQ { display:block; width:76px; height:76px; margin:6px; background:url(http://combo.b.qq.com/crm/wpa/release/3.3/wpa/views/SelectPanel-sprites.png) no-repeat -50px 0;}
.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-QQ-ANONY { background-position:-130px 0;}
.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-LABEL { display:block; padding-top:10px; color:#00a2e6; text-align:center;}
.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-BOTTOM { padding:0 20px; text-align:right;}
.WPA3-SELECT-PANEL .WPA3-SELECT-PANEL-INSTALL { color:#8e8e8e;}
</style>

</head>
<!-- InstanceBeginEditable name="bodyClass" -->


