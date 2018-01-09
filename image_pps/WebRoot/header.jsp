<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%
	String path = request.getContextPath();
	String basePath = new StringBuilder(request.getScheme()).append("://").append(request.getServerName())
						.append(":").append(request.getServerPort()).append(path).append("/").toString();
%>    
<meta name="description" content="高品图像 – 高品质的图库摄影及插画">
<meta name="Keywords" content="网上购物,网上商城,高品,图像,版权,高品质,图库,摄影,插画,设计,美术,创意">
<base href=<%=basePath %>>
<link REL="SHORTCUT ICON" HREF="images/favorite.ico">
<link href="css/myDialog/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="css/myDialog/NewDialog.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<link href="css/dialog.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
<link href="css/minimal/aero.css" rel="stylesheet" type="text/css">

<link type="text/css" href="css/jscrollpane.css" rel="stylesheet" media="all" /> 
<script type="text/javascript" src="js/jquery.mousewheel.js"></script> 
<script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>
<script type="text/javascript" src="js/style.js"></script>
<script type="text/javascript" src="js/mydialog.js"></script>
<link rel="prefetch" href="css/minimal/aero.png">
<link rel="prerender" href="css/minimal/aero.png">
<link rel="prefetch" href="images/friend1.png.png">
<link rel="prerender" href="images/friend1.png.png">

