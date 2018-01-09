<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- InstanceEndEditable -->
<body class="pageSearchAd">
<jsp:include page="../inc/pagetop_user.jsp" /> 
  <script type="text/javascript" src="flowsearch/js/searchjerry.js"></script>
  
 <script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-62125481-1', 'auto');
  ga('send', 'pageview');

</script> 
  
<form class="advform">
<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">
	<div class="container">
		<div class="subCont">
		
			<h3 class="SiYuanBold hidden-xs">高级搜索</h3>
			<div class="searchBar">
				<div class="searchBarInner col-lg-9 col-xs-12">
					<span class="SiYuan-ExtraLight hidden">搜索高品图像</span>
					<input class="searchFiled SiYuan-ExtraLight" name="q" id="q" type="text" placeholder="搜索高品图像"></input>
					<a href="#" class="btnsearchByAdv btnSearch icon-font icon-13-search"></a>
				</div>
			</div><!--searchBar-->
		
			<div class="row searchAdWrap">
			
				
				<div class="col-lg-3 col-md-3 col-sm-12 pull-right searchAdCol3">
					<a href="#" class="icon-4-clearAll btnGrey" id="btnAdRefresh">重新</a>		
					<a href="#" class="icon-59-saveSearch btnGrey" style="display:none;">保留<span class="hidden-xs">搜索</span></a>	
					<a href="searchCids" class="icon-60-imgIndex btnGrey"><span class="hidden-xs">图片</span>编号</a>	
				</div><!--col-lg-3-->
				
						
				<div class="col-lg-5 col-md-5 col-sm-6 col-xs-12 pull-right searchAdCol2">
					<div class="bgGreyInner">
						
						<div class="checkGroupWrap" style="height:66px">
							<div class="checkTop"><label><input name="cate_idxx" type="checkbox"  value=""/>创意类</label></div>
							<div class="checkSub box50"><label><input name="cate_id" type="checkbox"  value="662"/>免版税 (RF)</label></div>
							<div class="checkSub box50"><label><input name="cate_id" type="checkbox"  value="660"/>版权管理 (RM)</label></div>
						</div>
						<div class="checkGroupWrap" style="height:99px">
					        <div class="checkTop"><label><input name="cate_idxx" type="checkbox"  value=""/>编辑类</label></div> <!--id="checkEditRM"-->
							<div class="checkSub box50"><label><input name="cate_id" type="checkbox"  value="691" id="checkCategroy1"/>纪实</label></div>
							<div class="checkSub box50"><label><input name="cate_id" type="checkbox"  value="666" id="checkCategroy2"/>历史</label></div>
							<div class="checkSub box50"><label><input name="cate_id" type="checkbox"  value="680" id="checkCategroy3"/>艺术</label></div>
							<div class="checkSub box50"><label><input name="cate_id" type="checkbox"  value="682" id="checkCategroy4"/>影视档案</label></div> 
						</div>
						<div class="hLine"></div>
						
						<div class="searchEditRMWrap">
	 
							<div class="searchCollection">
								<div class="row">
									<div class="col-md-6 header">图片库(<span class="selectedNum">0</span>/${size})</div>
									<div class="col-md-6 btnsWrap">
										<span class="selectAll">选择全部</span>
										<span class="unSelectAll">取消全部选择</span>
									</div>
								</div>
								 <div class="scrollbar2">
									<div class="scrollbar"><div class="track"><div class="thumb"></div></div></div><!--scrollbar-->
									<div class="viewport">
										<div class="overview">
										<c:forEach items="${list}" var="collection" varStatus="stat">
	                						<label><input name="cid" type="checkbox" id="collection${collection.id }" value="${collection.id }"/>${collection.showName}</label>
	                					</c:forEach>
	                	
										</div><!--overview-->
									</div><!--viewport-->
								</div><!--scrollbar2-->
							</div><!--searchCollection-->
							
							
							
							
							
							
							<!--<div class="cover"></div>-->
						</div><!--searchEditRMWrap-->
						
					</div><!--bgGreyInner-->
				</div><!--col-lg-3-->
				
				
				
				
				
				<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 pull-right searchAdCol1">
					<div class="bgGreyInner">
						
						<div class="category layoutWrap selectOne" id="layoutWrap"  name="direction" >
							<div class="subHeader">图片方向</div>
								<a href="javascript:void(0);" class="icon-font icon-24-position1" value="3"></a>
								<a href="javascript:void(0);" class="icon-font icon-25-position2" value="1"></a>
								<a href="javascript:void(0);" class="icon-font icon-26-position3" value="2"></a>
								<a href="javascript:void(0);" class="icon-font icon-27-position4" value="4"></a>
								<a href="javascript:void(0);" class="icon-font icon-28-position5" value="5"></a>
						</div><!--category-->
						
						<div class="category">
							<div class="subHeader">图片风格</div>
							<div class="box50"><label><input name="type" type="checkbox" value="2"/>摄影</label></div>
							<div class="box50"><label><input name="color" type="checkbox" value="10"/>黑白</label></div>
							<div class="box50"><label><input name="type" type="checkbox" value="1"/>插图</label></div>
							<div class="box50"><label><input name="color" type="checkbox" value="9"/>彩色</label></div>
							
						</div><!--category-->
						
						<!-- 
						<div class="category">
							<div class="subHeader">拍摄日期</div>
							<input name="dateCreated" type="text" />
							<div class="font12">(例如：1935-1941，2009年2月28日)</div>
						</div>
						
						
						<div class="category">
							<div class="subHeader">上传日期</div>
							<label><input name="update-time" type="radio" value=""/><span class="letter3">最近的</span><input name="days" type="text" class="dateInput"/><span class="letter1">天</span></label><br/>
							<label><input name="update-time" type="radio" value=""/><span class="letter3">介于</span><input name="beginDate" type="text" class="dateInput date"/><span class="letter1">至</span><input name="endDate" type="text"  class="dateInput date"/></label>
						</div>
						-->
						 
						<div class="category">
							<div class="subHeader">地点</div>
							<input name="location" type="text" />
						</div><!--category-->
						
						<div class="category">
							<div class="subHeader">摄影师</div>
							<input name="photographer" type="text" />
						</div><!--category-->
						
						<div class="category">
							<div class="subHeader">供应者</div>
							<input name="provider" type="text" />
						</div><!--category-->
					
					</div><!--bgGreyInner-->
				</div><!--col-lg-3-->
				
				
	
				
					
				<div class="col-lg-offset-5 col-md-offset-6 col-md-3 col-sm-12"><a href="#" class="icon-13-search btn-lg btn-block btnPurple btnsearchByAdv">搜索</a></div>
					
				
			</div><!--row-->
		</div><!--subCont-->
		
	</div>
</div><!--sectionCont-->
<!-- InstanceEndEditable -->

</form>
<jsp:include page="../inc/bottomflow.jsp" />
</body>
<!-- InstanceEnd --></html>
