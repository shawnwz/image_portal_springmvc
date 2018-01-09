<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript" src="js/require.js"></script>
<script type="text/javascript" src="js/photographer.js"></script> 
<script type="text/javascript" src="js/s.page.js"></script>

<script>
 
</script>
<body class="pageSuccess">
<jsp:include page="../inc/pagetop_user.jsp" /> 

<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">
	<div class="container">
		
		<div class="row subPageWrap">
			 
				
			<div class="searchBar">
				
				<div class="searchBarInner col-xs-12">
					<span class="SiYuan-ExtraLight hidden">搜索高品图像</span>
					<input id="q" class="searchFiled SiYuan-ExtraLight" name="" type="text" placeholder="搜索高品图像"></input>
					<a href="#" class="btnSearch icon-font icon-13-search"></a>
				</div>
				<div class="hidden-xs hidden-sm selectWrap" style=" display: none; ">
					<div class="selectValue SiYuan-ExtraLight">所有图片</div>
					<ul class="selectList SiYuan-ExtraLight" role="menu">
						<li class="active">所有图片</li>
						<li>创意类</li>
						<li>编辑类</li>
					</ul>
				</div>
			
			</div><!--searchBar-->
			
			
			<div class="registerSuccessCont">
				
				<h2 class="Source-Han-Light"><span class="icon-font icon-40-success"></span>提交失败，请再试试</h2>
				<br/>
				<br/>
				
				
				<div class="row hidden-xs qrCodeWrap">
					<div class="col-sm-2 col-sm-offset-3 text-right"><img src="images/iconWeChat.gif"/></div>
					<div class="col-sm-5 text-left txt">
						关注高品的微信公众平台<br/>
						你将获得高品独家研讨会的邀请资格
					</div>
				</div>
			</div>
			
			
			
			
			
			
		</div><!--row-->
	</div><!--container-->
</div><!--sectionCont-->
<!-- InstanceEndEditable -->

<jsp:include page="../inc/bottomflow.jsp" />
