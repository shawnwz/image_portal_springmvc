<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/template.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>收藏夹</title>
    <%@include file="/headerflow.jsp" %>

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

</head> 

<!-- InstanceBeginEditable name="bodyClass" -->
<body class="pageFavourite">
 
<jsp:include page="../inc/pagetop_user.jsp"/>


		
</body>
<!-- InstanceEnd --></html>
