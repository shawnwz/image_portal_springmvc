<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>${title}</title>
<%
	String path = request.getContextPath();
	String basePath = new StringBuilder(request.getScheme()).append("://").append(request.getServerName())
						.append(":").append(request.getServerPort()).append(path).append("/").toString();
%>   

<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/mydialog.js"></script>
<link href="css/dialog.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/minimal/aero.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/style.js"></script>
<script type="text/javascript" src="js/s.page.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.icheck.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>

<script>
</script>

</head>
		<!--[if IE 6]>
			<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a.js"></script>
			<script type="text/javascript">
				DD_belatedPNG.fix('.png-img');
			</script>
		<![endif]-->
<body style=""><!-- width: 1024px;margin: auto; -->
	<jsp:include page="../inc/top.jsp"/>


		
