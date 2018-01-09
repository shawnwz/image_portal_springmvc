<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 头部 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>${title}</title>
<%
	String path = request.getContextPath();
	String basePath = new StringBuilder(request.getScheme())
			.append("://").append(request.getServerName()).append(":")
			.append(request.getServerPort()).append(path).append("/")
			.toString();
%>
<base href=<%=basePath%>>
	<jsp:include page="/header.jsp" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link href="css/minimal/aero.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="js/s.page.js"></script>
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
<body>




	<!-- end头部 -->
	<script type="text/javascript" src="js/require.js"></script>
	<script type="text/javascript" src="js/photographer.js"></script>
	<!--[if IE 6]>
			<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a.js"></script>
			<script type="text/javascript">
				DD_belatedPNG.fix('.png-img');
			</script>
		<![endif]-->
	<!-- 内容区开始 -->
	<html xmlns:o="urn:schemas-microsoft-com:office:office"
		xmlns:w="urn:schemas-microsoft-com:office:word"
		xmlns="http://www.w3.org/TR/REC-html40">
<head>
<meta http-equiv=Content-Type content="text/html; charset=gb2312">
	<title>Cookie政策</title>
	<!--[if gte mso 9]><xml><w:WordDocument><w:BrowserLevel>MicrosoftInternetExplorer4</w:BrowserLevel><w:DisplayHorizontalDrawingGridEvery>0</w:DisplayHorizontalDrawingGridEvery><w:DisplayVerticalDrawingGridEvery>2</w:DisplayVerticalDrawingGridEvery><w:DocumentKind>DocumentNotSpecified</w:DocumentKind><w:DrawingGridVerticalSpacing>7.8</w:DrawingGridVerticalSpacing><w:View>Web</w:View><w:Compatibility><w:DontGrowAutofit/></w:Compatibility><w:Zoom>0</w:Zoom></w:WordDocument></xml><![endif]-->
	<!--[if gte mso 9]><xml><w:LatentStyles DefLockedState="false"  DefUnhideWhenUsed="true"  DefSemiHidden="true"  DefQFormat="false"  DefPriority="99"  LatentStyleCount="156" ><w:LsdException Locked="false"  Priority="0"  SemiHidden="false"  UnhideWhenUsed="false"  QFormat="true"  Name="Normal" ></w:LsdException><w:LsdException Locked="false"  Priority="9"  SemiHidden="false"  UnhideWhenUsed="false"  QFormat="true"  Name="heading 1" ></w:LsdException><w:LsdException Locked="false"  Priority="9"  QFormat="true"  Name="heading 2" ></w:LsdException><w:LsdException Locked="false"  Priority="9"  QFormat="true"  Name="heading 3" ></w:LsdException><w:LsdException Locked="false"  Priority="9"  QFormat="true"  Name="heading 4" ></w:LsdException><w:LsdException Locked="false"  Priority="9"  QFormat="true"  Name="heading 5" ></w:LsdException><w:LsdException Locked="false"  Priority="9"  QFormat="true"  Name="heading 6" ></w:LsdException><w:LsdException Locked="false"  Priority="9"  QFormat="true"  Name="heading 7" ></w:LsdException><w:LsdException Locked="false"  Priority="9"  QFormat="true"  Name="heading 8" ></w:LsdException><w:LsdException Locked="false"  Priority="9"  QFormat="true"  Name="heading 9" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="index 1" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="index 2" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="index 3" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="index 4" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="index 5" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="index 6" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="index 7" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="index 8" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="index 9" ></w:LsdException><w:LsdException Locked="false"  Priority="39"  Name="toc 1" ></w:LsdException><w:LsdException Locked="false"  Priority="39"  Name="toc 2" ></w:LsdException><w:LsdException Locked="false"  Priority="39"  Name="toc 3" ></w:LsdException><w:LsdException Locked="false"  Priority="39"  Name="toc 4" ></w:LsdException><w:LsdException Locked="false"  Priority="39"  Name="toc 5" ></w:LsdException><w:LsdException Locked="false"  Priority="39"  Name="toc 6" ></w:LsdException><w:LsdException Locked="false"  Priority="39"  Name="toc 7" ></w:LsdException><w:LsdException Locked="false"  Priority="39"  Name="toc 8" ></w:LsdException><w:LsdException Locked="false"  Priority="39"  Name="toc 9" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Normal Indent" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="footnote text" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="annotation text" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="header" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="footer" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="index heading" ></w:LsdException><w:LsdException Locked="false"  Priority="35"  QFormat="true"  Name="caption" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="table of figures" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="envelope address" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="envelope return" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="footnote reference" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="annotation reference" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="line number" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="page number" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="endnote reference" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="endnote text" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="table of authorities" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="macro" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="toa heading" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List Bullet" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List Number" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List 2" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List 3" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List 4" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List 5" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List Bullet 2" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List Bullet 3" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List Bullet 4" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List Bullet 5" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List Number 2" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List Number 3" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List Number 4" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List Number 5" ></w:LsdException><w:LsdException Locked="false"  Priority="10"  SemiHidden="false"  UnhideWhenUsed="false"  QFormat="true"  Name="Title" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Closing" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Signature" ></w:LsdException><w:LsdException Locked="false"  Priority="1"  Name="Default Paragraph Font" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Body Text" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Body Text Indent" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List Continue" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List Continue 2" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List Continue 3" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List Continue 4" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="List Continue 5" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Message Header" ></w:LsdException><w:LsdException Locked="false"  Priority="11"  SemiHidden="false"  UnhideWhenUsed="false"  QFormat="true"  Name="Subtitle" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Salutation" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Date" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Body Text First Indent" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Body Text First Indent 2" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Note Heading" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Body Text 2" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Body Text 3" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Body Text Indent 2" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Body Text Indent 3" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Block Text" ></w:LsdException><w:LsdException Locked="false"  Priority="99"  Name="Hyperlink" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="FollowedHyperlink" ></w:LsdException><w:LsdException Locked="false"  Priority="22"  SemiHidden="false"  UnhideWhenUsed="false"  QFormat="true"  Name="Strong" ></w:LsdException><w:LsdException Locked="false"  Priority="20"  SemiHidden="false"  UnhideWhenUsed="false"  QFormat="true"  Name="Emphasis" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Document Map" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Plain Text" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="E-mail Signature" ></w:LsdException><w:LsdException Locked="false"  Priority="99"  Name="Normal (Web)" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="HTML Acronym" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="HTML Address" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="HTML Cite" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="HTML Code" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="HTML Definition" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="HTML Keyboard" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="HTML Preformatted" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="HTML Sample" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="HTML Typewriter" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="HTML Variable" ></w:LsdException><w:LsdException Locked="false"  Priority="99"  Name="Normal Table" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="annotation subject" ></w:LsdException><w:LsdException Locked="false"  Priority="99"  Name="No List" ></w:LsdException><w:LsdException Locked="false"  Priority="0"  Name="Balloon Text" ></w:LsdException></w:LatentStyles></xml><![endif]-->
	<style>
@font-face {
	font-family: "Times New Roman";
}

@font-face {
	font-family: "宋体";
}

@font-face {
	font-family: "微软雅黑";
}

@font-face {
	font-family: "Tahoma";
}

@font-face {
	font-family: "Symbol";
}

@font-face {
	font-family: "Arial";
}

@font-face {
	font-family: "黑体";
}

@font-face {
	font-family: "Courier New";
}

@font-face {
	font-family: "Wingdings";
}

@font-face {
	font-family: "Calibri";
}

@font-face {
	font-family: "Cambria";
}

@
list l0:level1 {
	mso-level-number-format: decimal;
	mso-level-suffix: tab;
	mso-level-text: "%1.";
	mso-level-tab-stop: 39.0000pt;
	mso-level-number-position: left;
	margin-left: 39.0000pt;
	text-indent: -18.0000pt;
	margin-bottom: 0pt;
	margin-top: 0pt;
	font-family: 'Times New Roman';
}

@
list l1:level1 {
	mso-level-number-format: bullet;
	mso-level-suffix: tab;
	mso-level-text: \F06C;
	mso-level-tab-stop: 81.0000pt;
	mso-level-number-position: left;
	margin-left: 81.0000pt;
	text-indent: -18.0000pt;
	margin-bottom: 0pt;
	margin-top: 0pt;
	font-family: 'Wingdings';
}

@
list l2:level1 {
	mso-level-number-format: decimal;
	mso-level-suffix: tab;
	mso-level-text: "%1.";
	mso-level-tab-stop: 18.0000pt;
	mso-level-number-position: left;
	margin-left: 18.0000pt;
	text-indent: -18.0000pt;
	margin-bottom: 0pt;
	margin-top: 0pt;
	font-family: 'Times New Roman';
}

@
list l3:level1 {
	mso-level-number-format: bullet;
	mso-level-suffix: tab;
	mso-level-text: \F06C;
	mso-level-tab-stop: 18.0000pt;
	mso-level-number-position: left;
	margin-left: 18.0000pt;
	text-indent: -18.0000pt;
	margin-bottom: 0pt;
	margin-top: 0pt;
	font-family: 'Wingdings';
}

@
list l4:level1 {
	mso-level-number-format: bullet;
	mso-level-suffix: tab;
	mso-level-text: \F06C;
	mso-level-tab-stop: 60.0000pt;
	mso-level-number-position: left;
	margin-left: 60.0000pt;
	text-indent: -18.0000pt;
	margin-bottom: 0pt;
	margin-top: 0pt;
	font-family: 'Wingdings';
}

@
list l5:level1 {
	mso-level-number-format: decimal;
	mso-level-suffix: tab;
	mso-level-text: "%1.";
	mso-level-tab-stop: 60.0000pt;
	mso-level-number-position: left;
	margin-left: 60.0000pt;
	text-indent: -18.0000pt;
	margin-bottom: 0pt;
	margin-top: 0pt;
	font-family: 'Times New Roman';
}

@
list l6:level1 {
	mso-level-number-format: bullet;
	mso-level-suffix: tab;
	mso-level-text: \F06C;
	mso-level-tab-stop: 39.0000pt;
	mso-level-number-position: left;
	margin-left: 39.0000pt;
	text-indent: -18.0000pt;
	margin-bottom: 0pt;
	margin-top: 0pt;
	font-family: 'Wingdings';
}

@
list l7:level1 {
	mso-level-number-format: bullet;
	mso-level-suffix: tab;
	mso-level-text: \F06C;
	mso-level-tab-stop: 102.0000pt;
	mso-level-number-position: left;
	margin-left: 102.0000pt;
	text-indent: -18.0000pt;
	margin-bottom: 0pt;
	margin-top: 0pt;
	font-family: 'Wingdings';
}

@
list l8:level1 {
	mso-level-number-format: decimal;
	mso-level-suffix: tab;
	mso-level-text: "%1.";
	mso-level-tab-stop: 81.0000pt;
	mso-level-number-position: left;
	margin-left: 81.0000pt;
	text-indent: -18.0000pt;
	margin-bottom: 0pt;
	margin-top: 0pt;
	font-family: 'Times New Roman';
}

@
list l9:level1 {
	mso-level-number-format: decimal;
	mso-level-suffix: tab;
	mso-level-text: "%1.";
	mso-level-tab-stop: 102.0000pt;
	mso-level-number-position: left;
	margin-left: 102.0000pt;
	text-indent: -18.0000pt;
	margin-bottom: 0pt;
	margin-top: 0pt;
	font-family: 'Times New Roman';
}

.Section0 p {
	margin: 0pt;
	margin-bottom: 0.0001pt;
	margin-bottom: 0pt;
	margin-top: 0pt;
	text-align: justify;
	font-size: 10.5000pt;
	font-family: 'Calibri';
}

span.10 {
	font-family: 'Times New Roman';
}

span.15 {
	color: rgb(112, 112, 112);
	text-decoration: none;
	font-family: 'Times New Roman';
}

p.p16 {
	margin-bottom: 5.0000pt;
	margin-top: 5.0000pt;
	text-align: left;
	font-size: 12.0000pt;
	font-family: '宋体';
}

@page {
	mso-page-border-surround-header: no;
	mso-page-border-surround-footer: no;
}

@page Section0 {
	margin-top: 72.0000pt;
	margin-bottom: 72.0000pt;
	margin-left: 90.0000pt;
	margin-right: 90.0000pt;
	size: 595.3000pt 841.9000pt;
	layout-grid: 15.6000pt;
	
}

div.Section0 {
	page: Section0;
	margin: 25px;
}
div.Section0 a{
color:blue;
}
</style>
</head>
<body style="tab-interval:21pt; text-justify-trim:punctuation; ">
	<!--StartFragment-->
	<div class="Section0" style="layout-grid:15.6000pt;
">
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;text-align: justify;font-family: Calibri;white-space: normal;">
    <span style="font-size: 16px;font-family: 微软雅黑;font-weight: bold">客户服务</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 28px">
    <span style="font-size: 12px;font-family: 微软雅黑">高品图像</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;">
    <span style="font-size: 12px;font-family: 微软雅黑">版权管理及免版税图片</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">中国免费热线：400.820.0268</span>
</p>
<p style=";font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">电话： +86 21 5407</span><span style="font-size: 12px;font-family: 微软雅黑">&nbsp;</span><span style="font-size: 12px;font-family: 微软雅黑">5711&nbsp;</span><span style="font-size: 12px;font-family: 微软雅黑">&nbsp;&nbsp;</span><span style="font-size: 12px;font-family: 微软雅黑">传真：+86 21 5407</span><span style="font-size: 12px;font-family: 微软雅黑">&nbsp;</span><span style="font-size: 12px;font-family: 微软雅黑">5712</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">服务电邮：service@gaopinimages.com</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">北京</span>
</p>
<p style=";font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">电话： +86 10 6500 8152&nbsp;</span><span style="font-size: 12px;font-family: 微软雅黑">&nbsp;&nbsp;</span><span style="font-size: 12px;font-family: 微软雅黑">传真：+86 10 6500 8192</span>
</p>
<p style=";font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">地址：北京朝阳区工体北路4号院22号楼211 邮编：100027</span>
</p>
<p style=";font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">&nbsp;</span>
</p>
<p style=";font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">上海 &nbsp; &nbsp;(总部)</span>
</p>
<p style=";font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">电话： +86 21 5407</span><span style="font-size: 12px;font-family: 微软雅黑">&nbsp;</span><span style="font-size: 12px;font-family: 微软雅黑">5711&nbsp;</span><span style="font-size: 12px;font-family: 微软雅黑">&nbsp;&nbsp;</span><span style="font-size: 12px;font-family: 微软雅黑">传真：+86 21 5407</span><span style="font-size: 12px;font-family: 微软雅黑">&nbsp;</span><span style="font-size: 12px;font-family: 微软雅黑">5712</span>
</p>
<p style=";font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">地址：上海黄浦区四川中路外滩181大楼401  邮编：200002</span>
</p>
<p style=";font-size: 14px;margin-top: 0;margin-bottom: 0;text-align: justify;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">&nbsp;</span>
</p>
<p style=";font-size: 14px;margin-top: 0;margin-bottom: 0;text-align: justify;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">广州</span>
</p>
<p style=";font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">电话： +86 20 3847 3900</span><span style="font-size: 12px;font-family: 微软雅黑">&nbsp;&nbsp;</span><span style="font-size: 12px;font-family: 微软雅黑">传真：+86 20 3847 3901</span>
</p>
<p style=";font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">地址：广州天河区体育东横街3号设计大厦17楼17B02 邮编: 510620</span>
</p>
<p style=";font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 28px">
    <span style="font-size: 15px;font-family: 微软雅黑;font-weight: bold">常见问题</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 13px;font-family: 微软雅黑;font-weight: bold">购买图片</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">向 高品图像 购买图片需要些什么?</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">要购买图片，您必须成为 高品图像 注册用户。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">高品图像&nbsp;内容使用授权条款<br/>请详细查阅 高品图像 内容使用授权协议，这与您的订单有着密切关系。</span>
</p>
<h2 style="margin-left: 0;font-size: 16px;font-family: Simsun;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">如何购买图片?</span>
</h2>
<p style="margin-left: 0;font-size: medium;font-family: Simsun;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">如需购买图片，请点击图片下方的蓝色方型图标，并填妥联系表格与客户服务部门联系。</span>
</p>
<h2 style="margin-left: 0;font-size: 16px;font-family: Simsun;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">RM 及 RF 是什么意思?</span>
</h2>
<p style="margin-left: 0;font-size: medium;font-family: Simsun;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">高品图像 主要提供的图像产品包括版权管理图片和免版税图片。</span>
</p>
<p style="margin-left: 0;font-size: medium;font-family: Simsun;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">版权管理图片(RM)：根据每次使用形式收取费用，并由高品明确指定为“版权管理”或“RM” 的内容。</span>
</p>
<p style="margin-left: 0;font-size: medium;font-family: Simsun;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">免版税图片(RF)：收取一次性固定费用可以无限次使用，并由高品明确指定为“免版税”或“RF”的内容。</span>
</p>
<p style="margin-left: 0;font-size: medium;font-family: Simsun;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">请详细查阅 高品图像 内容使用授权协议</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">购买图片使用授权之后，如何下载图像?</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">当您购买了一张或多张图片的使用授权后，请按照下列步骤从我们的网站下载有关图片。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">注意：</span><span style="font-size: 12px;font-family: 微软雅黑">您必须登录，然后才可以下载授权图像。</span>
</p>
<p style="margin-left: 34px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">点击</span><a href="https://secure.corbisimages.com/OrderHistory/OrderHistory.aspx" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">我的订单</span></a><span style="font-size: 12px;font-family: 微软雅黑">找出相关的图片订单；</span>
</p>
<p style="margin-left: 34px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">找出您想下载的图片，然后用下拉式选框选择合适的图像精度；</span>
</p>
<p style="margin-left: 34px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">点击 下载 按钮 (要下载订单内的所有图片，请点击下载全部这个按钮)；</span>
</p>
<p style="margin-left: 34px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">当下载图片对话框出现时，点击您打算下载的图像文件；</span>
</p>
<p style="margin-left: 34px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">选择 &quot;另存为&quot; 及存放（下载）图片的位置。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">压缩文件工具</span><span style="font-size: 12px;font-family: 微软雅黑;color: rgb(112, 112, 112)"><br/></span><span style="font-size: 12px;font-family: 微软雅黑">为了方便用户下载， 图像文件是经过压缩的。您将会需要一个压缩文件工具，例如 WinZip 或 StuffIt，去开启 高品图像 图像文件夹。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">Stufflt:</span><a href="http://my.smithmicro.com/downloads/index.html" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">http://my.smithmicro.com/downloads/index.html</span></a><span style="font-size: 12px;font-family: 微软雅黑"><br/>WinZip:</span><a href="http://www.winzip.com/ddchomea.htm" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">http://www.winzip.com/ddchomea.htm</span></a>
</p>
<h2 style="margin-left: 0;font-size: 16px;font-family: Simsun;white-space: normal;;line-height: 24px">
    <span style="font-size: 15px;font-family: 微软雅黑">购买图片常见问题</span>
</h2>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 13px;font-family: 微软雅黑;font-weight: bold">灯箱</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">如何创建灯箱?</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">高品图像 注册用户可以使用灯箱在线保存及转移图片。如果您是 高品图像 的新用户，或者刚开始一个大型项目，以下是一些对您有帮助的资料。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">您可以用以下四种方法去创建新灯箱：</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">1.</span><span style="font-size: 12px;font-family: 微软雅黑">从搜索结果中创建灯箱： 点击您想保存到灯箱的缩略图下方的 灯泡图标 。 如果灯箱并不存在，一个弹出式窗口将会出现，您只要点击一下便可创建新灯箱。为灯箱命名，然后点击 添加到新灯箱。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">2.</span><span style="font-size: 12px;font-family: 微软雅黑">在优化搜索的窗格里： 点击 灯泡图标，然后创建新灯箱。一个弹出式窗口将会出现，您可以为灯箱命名，然后点击 保存。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">3.</span><span style="font-size: 12px;font-family: 微软雅黑">放大图片时创建灯箱： 点击 灯泡图标。一个弹出式窗口将会出现，您只要点击一下便可创建新灯箱。为灯箱命名，然后点击 添加到新灯箱。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">4.</span><span style="font-size: 12px;font-family: 微软雅黑">从 我的灯箱 里创建新灯箱：在任何页面的上方，点击&nbsp;</span><a href="http://www.corbisimages.com/Lightboxes/MyLightboxes.aspx" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">我的灯箱</span></a><span style="font-size: 12px;font-family: 微软雅黑">。在您的灯箱窗口的上方，点击创建新灯箱。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">您可以添加灯箱，并把灯箱按照分层次序组合起来（如有需要）。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">如何把灯箱按照分层次序组合起来?</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">如果您以注册用户登录，您会发现您已保存了几个灯箱。您最后使用过的灯箱将会是您的当前灯箱，您添加到灯箱的图片将会自动发送至这个灯箱。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">1.</span><span style="font-size: 12px;font-family: 微软雅黑">要进入您的灯箱，点击任何页面上方的&nbsp;</span><a href="http://www.corbisimages.com/Lightboxes/MyLightboxes.aspx" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">我的灯箱</span></a><span style="font-size: 12px;font-family: 微软雅黑">。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">2.</span><span style="font-size: 12px;font-family: 微软雅黑">要标示任何一个您的灯箱，请点击左面列表中的灯箱。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">3.</span><span style="font-size: 12px;font-family: 微软雅黑">点击 移动。然后选择一个灯箱 (“母”)去装载这个原本的灯箱 (“子”)。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">注意：</span><span style="font-size: 12px;font-family: 微软雅黑">“子”灯箱将会出现在 “母” 灯箱之下。在每个母灯箱之下，您最多可以创建四个子灯箱。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">如何更改我的“当前”灯箱?</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">要更改内含已保存图片的灯箱，请按照以下步骤：</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">在优化搜索的窗格里创建灯箱：</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">1.</span><span style="font-size: 12px;font-family: 微软雅黑">要进入您的灯箱，点击优化搜索窗格里的灯箱键。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">2.</span><span style="font-size: 12px;font-family: 微软雅黑">选择您打算用来保存图片的灯箱，然后点击缩略图下方的 灯泡图标 。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">在图片放大页面创建灯箱：</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">1.</span><span style="font-size: 12px;font-family: 微软雅黑">点击灯泡图标，一个弹出式窗口将会出现，您可以选择添加到灯箱或创建新灯箱。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">2.</span><span style="font-size: 12px;font-family: 微软雅黑">当选择 添加 或 添加到新灯箱 作为储存图片的灯箱后，被选择的灯箱便会成为您的当前灯箱。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">在我的灯箱里创建新灯箱：</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">1.</span><span style="font-size: 12px;font-family: 微软雅黑">进入您的灯箱，点击任何页面上方的 我的灯箱 便可。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">2.</span><span style="font-size: 12px;font-family: 微软雅黑">点击查看左方的任何灯箱，将会使灯箱成为当前灯箱。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">如何转移灯箱的操作权?</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">新灯箱的创建者将自动成为灯箱的操作者，直到灯箱被转移为止。您可以把灯箱操作权转移给别的 高品图像 用户，该用户便可以处理灯箱里的图片。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">1.</span><span style="font-size: 12px;font-family: 微软雅黑">点击 我的灯箱 ，然后选择您想转移操作权的灯箱。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">2.</span><span style="font-size: 12px;font-family: 微软雅黑">点击 转移 并且从 高品图像 用户名单选框中选择新灯箱拥有者的用户名。<br/>-或者-<br/>在 添加一个 高品图像 用户字段的位置输入新拥有者的用户名。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">3.</span><span style="font-size: 12px;font-family: 微软雅黑">如果您想从您的名单中移除这个灯箱，请勾选 “从我的灯箱中移除”。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">4.</span><span style="font-size: 12px;font-family: 微软雅黑">然后点击 转移。</span>
</p>
<h2 style="margin-left: 0;font-size: 16px;font-family: Simsun;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">图片使用限制包括些什么?</span>
</h2>
<p style="margin-left: 0;font-size: medium;font-family: Simsun;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">很多 高品图像 图片都有使用限制规定。图片的使用限制规定多种多样；有些可能“在授权之前必须获得授权许可”，有些“不允许作某些商业用途”。</span>
</p>
<p style="margin-left: 0;font-size: medium;font-family: Simsun;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">如果图片附带一个或多个限制， 有关的使用限制会在图片详情页面中显示出来。在购买图片使用授权之前，您必须仔细地再次阅读有关图片的使用限制。</span>
</p>
<p style="margin-left: 0;font-size: medium;font-family: Simsun;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">图片使用限制的内容繁多，不能在这里全部显示出来。希望了解详情，请与您的 高品图像 客户代表联系。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">购买图片使用授权之后，我可以取消交易吗?</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">根据某些特定的条款，购买图片使用授权后， 您可以要求取消（或终止）购买图像的使用授权。取消授权需缴付取消费 (或“终止费”），以及相关的手续费、制作费，及/或服务费。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 13px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">如果您在签订报价单起七（7）日之内取消许可使用权利，您须就每幅内容向 高品图像 支付三百五十（350）人民幣的取消费。 如果在签订报价单后超过七（7）日，但少于三十（30）日内取消许可使用权利，您须就每幅内容向 高品图像 支付报价单所示的许可费的百分之五十（50%）作为取消费。 签订报价单后超过三十（30）日，高品图像 不接受取消许可使用权利，您须支付报价单所示的许可费全额。 除支付上述规定的取消费外，您还必须支付全额服务费、制作费、处理操作费和递送费。 一旦取消授权，所有被取消的许可立即终止。所有的取消授权均不可改变。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 13px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">我们不接纳在三十天后才提出取消订单的要求，有关客户必须全数缴付发票上列明的金额。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">在任何情况下，取消订单必须缴付全额的服务费、制作费、手续费、及递送费用。取消订单后，您便失去图片的使用授权；所有取消的要求将被视作最终的决定。希望进一步了解取消购买图片使用授权的详情，或者关于取消订单的费用，请与您的 高品图像 客户代表联系。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑;color: rgb(112, 112, 112);font-weight: bold">&nbsp;</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 13px;font-family: 微软雅黑;font-weight: bold">我的账户</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">如何更改我的用户名或密码?</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 16px;margin-bottom: 0;font-family: Calibri;white-space: normal;">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">更改用户名</span><span style="font-size: 12px;font-family: 微软雅黑;color: rgb(112, 112, 112)"><br/></span><span style="font-size: 12px;font-family: 微软雅黑">登录时，您需要用户名及密码。我们建议您保留您注册 高品图像 时选用的用户名。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;">
    <span style="font-size: 12px;font-family: 微软雅黑">您也可以在登录后通过以下几个步骤，更改您的用户名：</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">1.</span><span style="font-size: 12px;font-family: 微软雅黑">点击&nbsp;</span><a href="http://www.corbisimages.com/my-account/profile" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">我的账户</span></a><span style="font-size: 12px;font-family: 微软雅黑">。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">2.</span><span style="font-size: 12px;font-family: 微软雅黑">默认显示设定为&nbsp;</span><a href="http://www.corbisimages.com/my-account/profile" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">档案资料及首选设置</span></a><span style="font-size: 12px;font-family: 微软雅黑">。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">3.</span><span style="font-size: 12px;font-family: 微软雅黑">在登录及个人资料里面，选择 修改。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">4.</span><span style="font-size: 12px;font-family: 微软雅黑">输入一个新用户名以取代原本的用户名。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">5.</span><span style="font-size: 12px;font-family: 微软雅黑">点击 保存。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">更改密码</span><span style="font-size: 12px;font-family: 微软雅黑;color: rgb(112, 112, 112)"><br/></span><span style="font-size: 12px;font-family: 微软雅黑">登录后通过以下几个步骤，您便可以随时更改您的密码：</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">1.</span><span style="font-size: 12px;font-family: 微软雅黑">点击&nbsp;</span><a href="http://www.corbisimages.com/my-account/profile" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">我的账户</span></a><span style="font-size: 12px;font-family: 微软雅黑">。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">2.</span><span style="font-size: 12px;font-family: 微软雅黑">默认显示设定为</span><a href="http://www.corbisimages.com/my-account/profile" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">档案资料及首选设置</span></a><span style="font-size: 12px;font-family: 微软雅黑">。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">3.</span><span style="font-size: 12px;font-family: 微软雅黑">在登录及个人资料里面，选择 我想更改我的密码。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">4.</span><span style="font-size: 12px;font-family: 微软雅黑">输入您的现有密码。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">5.</span><span style="font-size: 12px;font-family: 微软雅黑">输入您的新密码 (长度最少8个字符，必须包括英文字母及数字)。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">6.</span><span style="font-size: 12px;font-family: 微软雅黑">确认您的新密码及点击 保存。</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">如何更新我的账户资料?</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑">更改您的账户资料，请先使用您的用户名及密码登录。然后，您可以更改个人、公司、付款与递送资料，以及首选设置，步骤如下：</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">1.</span><span style="font-size: 12px;font-family: 微软雅黑">点击&nbsp;</span><a href="http://www.corbisimages.com/my-account/profile" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">我的账户</span></a><span style="font-size: 12px;font-family: 微软雅黑">。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">2.</span><span style="font-size: 12px;font-family: 微软雅黑">默认显示设定为</span><a href="http://www.corbisimages.com/my-account/profile" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">档案资料及首选设置</span></a><span style="font-size: 12px;font-family: 微软雅黑">。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">3.</span><span style="font-size: 12px;font-family: 微软雅黑">您可以选择下面各项：个人资料、公司资料或首选设置。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">4.</span><span style="font-size: 12px;font-family: 微软雅黑">选择您需要的类别以后，选择 修改。</span>
</p>
<p style="margin-left: 24px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;background-color: transparent">5.</span><span style="font-size: 12px;font-family: 微软雅黑">点击 保存。</span>
</p>
<h1 style="margin-left: 0;font-size: 16px;font-family: Simsun;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑;color: rgb(112, 112, 112)">&nbsp;</span>
</h1>
<h1 style="margin-left: 0;font-size: 16px;font-family: Simsun;white-space: normal;;line-height: 24px">
    <span style="font-size: 13px;font-family: 微软雅黑">网站要求</span>
</h1>
<h2 style="margin-left: 0;font-size: 16px;font-family: Simsun;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: normal">Gaopin&nbsp;</span><span style="font-size: 12px;font-family: 微软雅黑;font-weight: normal">Images&nbsp;</span><span style="font-size: 12px;font-family: 微软雅黑;font-weight: normal">高品图像 网站支持哪些浏览器？</span>
</h2>
<p style="margin-left: 0;font-size: medium;font-family: Simsun;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">微软Windows系统</span><span style="font-size: 12px;font-family: 微软雅黑"><br/></span><a href="http://www.mozilla.com/en-US/firefox/personal.html" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">火狐浏览器</span></a><span style="font-size: 12px;font-family: 微软雅黑">&nbsp;3.0或以上版本，&nbsp;</span><a href="http://www.apple.com/safari" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">苹果Safari</span></a><span style="font-size: 12px;font-family: 微软雅黑">&nbsp;3.1或以上版本，</span><a href="http://www.microsoft.com/windows/internet-explorer" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">&nbsp;微软IE</span></a><span style="font-size: 12px;font-family: 微软雅黑">&nbsp;7.0或以上版本</span>
</p>
<p style="margin-left: 0;font-size: medium;font-family: Simsun;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">苹果Mac OS系统</span><span style="font-size: 12px;font-family: 微软雅黑"><br/></span><a href="http://www.mozilla.com/en-US/firefox/personal.html" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">火狐浏览器</span></a><span style="font-size: 12px;font-family: 微软雅黑">&nbsp;3.0或以上版本，&nbsp;</span><a href="http://www.apple.com/safari" style="color: rgb(112, 112, 112)"><span style="font-size: 12px;font-family: 微软雅黑;color: white">苹果Safari</span></a><span style="font-size: 12px;font-family: 微软雅黑">&nbsp;3.1或以上版本</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;;line-height: 24px">
    <span style="font-size: 12px;font-family: 微软雅黑">浏览 Gaopin</span><span style="font-size: 12px;font-family: 微软雅黑">&nbsp;Images&nbsp;</span><span style="font-size: 12px;font-family: 微软雅黑">高品图像 网站的建议系统配置是：</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">微软Windows系统</span>
</p>
<p style="margin-left: 10px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 13px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">1.8GHz 或更快的处理器</span>
</p>
<p style="margin-left: 10px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 13px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">Microsoft? Windows? XP with Service Pack 2 或更新版本</span>
</p>
<p style="margin-left: 10px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 13px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">512MB或更大的RAM</span>
</p>
<p style="margin-left: 10px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 13px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">1,024x768或更大显像用16-bit的视频采集卡</span>
</p>
<p style="margin-left: 10px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 13px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">连接宽带互联网</span>
</p>
<p style="margin-left: 10px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 13px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">Adobe Flash Player 插件</span>
</p>
<p style="margin-left: 0;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 12px;font-family: 微软雅黑;font-weight: bold">苹果Mac OS系统</span>
</p>
<p style="margin-left: 10px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 13px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">PowerPC G5 处理器或 Intel 多芯处理器</span>
</p>
<p style="margin-left: 10px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 13px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">苹果 Mac OS X v10.4.11 或更新版本</span>
</p>
<p style="margin-left: 10px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 13px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">512MB或更大的RAM</span>
</p>
<p style="margin-left: 10px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 13px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">1,024x768或更大显像用16-bit的视频采集卡</span>
</p>
<p style="margin-left: 10px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 13px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">连接宽带互联网</span>
</p>
<p style="margin-left: 10px;font-size: 14px;margin-top: 0;margin-bottom: 0;font-family: Calibri;white-space: normal;line-height: 24px;">
    <span style="font-size: 13px;font-family: Symbol;background-color: transparent">·</span><span style="font-size: 12px;font-family: 微软雅黑">Adobe Flash Player 插件</span>
</p>
<p>
    <br/>
</p>
	</div>
	<!--EndFragment-->
</body>
	</html>

	<!-- 内容区结束-->