<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<body class="pageSearchAd">
<jsp:include page="../inc/pagetop_user.jsp" />

<!-- InstanceEndEditable -->

<script type="text/javascript" src="flowsearch/js/searchjerry.js"></script>
  
<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">
	<div class="container">
	
	
		<div class="subCont">
			<h3 class="SiYuanBold">图片编号搜索</h3>
	
		
			<div class="row searchAdWrap">
			
				
				<div class="col-md-6">
					<textarea name="" cols="" rows="" class="textareaSearchByIndex" placeholder="比如: 133100111674,133200152737"></textarea>
					
					<div class="row">
						<div class="col-md-6 col-sm-12"><a href="#" class="icon-13-search btn-lg btn-block btnPurple btnSearchByCids">搜索</a></div>
					</div>
				</div><!--col-lg-3-->
				 
				
				<div class="col-lg-3 col-md-4 hidden-sm hidden-xs rightIntro">
					<h4>这是怎么用的？</h4>
					
					<p>每个图片编号需另起一行，或者用逗号或空格分隔他们。 用图片编号进行搜索时，其它筛选功能将被忽略。</p>
					
					<a href="searchAdv" class="txtLink">回去高级搜索</a>
				</div><!--col-lg-3-->
				
					
				
					
				
			</div><!--row-->
			
		</div><!--subCont-->
	</div>
</div><!--sectionCont-->
<!-- InstanceEndEditable -->

 <jsp:include page="../inc/bottomflow.jsp" />




			
</body>
<!-- InstanceEnd --></html>
