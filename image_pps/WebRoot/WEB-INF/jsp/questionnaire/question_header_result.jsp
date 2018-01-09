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
<link rel="Shortcut Icon" href="promoted/images/favorite.ico" type="image/x-icon" />
<link rel="Bookmark" href="promoted/images/favorite.ico" type="image/x-icon" />
<link rel="icon" href="promoted/images/favorite.ico" type="image/x-icon" />
<link href="flowsearch/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/layout.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/font.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/jquery.selectBox.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/nav.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/cont.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/responsive.css" rel="stylesheet" type="text/css" />
<link href="css/promotion.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="promoted/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="promoted/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="promoted/js/jquery.ui.datepicker-zh-CN.js"></script>
<link href="flowsearch/css/jcarousel.responsive.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="promoted/js/favourite.js"></script>
<script type="text/javascript" src="promoted/js/modernizr.custom.10564.js"></script>
<script type="text/javascript" src="promoted/js/bootstrap.min.js"></script>
<script type="text/javascript" src="promoted/js/banner.js"></script>
<script type="text/javascript" src="promoted/js/jquery.md5.js"></script>
<script type="text/javascript" src="promoted/js/youziku.js"></script>
<script type="text/javascript" src="promoted/js/imagesloaded.pkgd.min.js"></script>
<script type="text/javascript" src="promoted/js/masonry.pkgd.min.js"></script>
<script type="text/javascript" src="promoted/js/jquery.infinitescroll.js"></script>
<script type="text/javascript" src="promoted/js/jquery.jcarousel.js"></script>
<link href="flowsearch/css/jcarousel.responsive.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="promoted/js/jquery.selectBox.js"></script>
<script type="text/javascript" src="promoted/js/icheck.js"></script>
<link href="flowsearch/css/blue.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/tooltipster.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="promoted/js/jquery.tooltipster.js"></script>
<script type="text/javascript" src="promoted/js/jquery.validate.js"></script>
<script type="text/javascript" src="promoted/js/formjerry.js"></script>
<!--[if lte IE 9]>
<script type="text/javascript" src="promoted/js/respond.min.js"></script>
<![endif]-->
<!-- InstanceBeginEditable name="head" -->
<script type="text/javascript" src="promoted/js/default.js"></script>
    <script type="text/javascript" src="flowsearch/js/defaultjerry.js"></script>
<script type="text/javascript" src="promoted/js/search.js"></script>
    <script type="text/javascript" src="flowsearch/js/jquery.jqModal.js"></script>
    <script type="text/javascript" src="flowsearch/js/sub.js"></script>
<script type="text/javascript" src="flowsearch/js/jquery.tinyscrollbar.js"></script>
<script type="text/javascript" src="flowsearch/myjs/jquery.cookie.js"></script>
<!-- InstanceEndEditable -->
<link href="flowsearch/css/sub.css" rel="stylesheet" type="text/css" />

<link href="flowsearch/css/landingPages.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/nav.js"></script>
<script type="text/javascript" src="menu/menu.js"></script>
<script type="text/javascript" src="flowsearch/js/searchbar.js"></script>

</base></head>

<!-- InstanceBeginEditable name="bodyClass" -->
<body class="pagePromoted">


