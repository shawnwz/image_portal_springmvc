<%@page import="com.gaopin.utils.StrUtils"%>
<%@page import="com.gaopin.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- InstanceBeginEditable name="nav" -->
<div id="topBar">
	
	<div class="navWrap">
		<div id="logo"><a href="index"><img src="images/logo.png"/></a></div>
		<div id="navRight">
			<ul>
					<li><a href="javascript:void(0)" class="hoverShow icon-font icon-5-collapse visible-xs visible-sm" id="navMobileMenu" targetshow="navLeft"></a></li>
					<li><a href="mailto:service@gaopinimages.com" class="icon-font icon-3-chat  visible-md visible-lg"></a></li>
<!--                <li class="visible-md visible-lg"><a href="javascript:openPage('callme')" class="icon-font icon-15-shoppingCart"></a></li> -->
                    <%
					User user = (User)session.getAttribute(User.class.getName());
					if(user!=null){
					%>
                    <li><a href="javascript:void(0);" class="icon-font icon-11-favourite btnLightBox  visible-md visible-lg"></a></li>
					<li><a href="javascript:void(0);" class="hoverShow icon-font icon-17-user btnUser" id="navUserCenter" targetShow="userCenterMobileMenu"><span class="logInName visible-md-inline-block visible-lg-inline-block"><%=user.getUserName() %></span></a></li>
					<%}else{ %>
					<li><a href="login" class="icon-font icon-11-favourite btnLightBox1  visible-md visible-lg"></a></li>
					<li><a href="login" class="icon-font icon-17-user btnUser"></a></li>
					<%} %>
<!-- 					<li><a href="javascript:void(0)" class="hoverShow icon-font icon-5-collapse visible-xs visible-sm" id="navMobileMenu" target="navLeft"></a></li> -->
                </ul>
		</div>
		<div id="navLeft"  class="hoverShowTarget" targetParent="navMobileMenu">
<!-- 			<div class="collapse visible-xs visible-sm icon-font icon-5-collapse"></div> -->
			<ul class="Source-Han-Light">
					<li><a href="photostock659" target="_blank">创意图片</a>
						<ul>
							<li><a href="photostock660"  target="_blank">创意类RM</a></li>
							<li><a href="photostock662"  target="_blank">创意类RF</a></li>
						</ul>
					</li>
					<li><a href="photostock661"  target="_blank">编辑图片</a>
					</li>
					<li><a href="imgsets" target="_blank">高品专辑</a>
					</li>
				</ul>
		</div>
		
<div id="userCenterMobileMenu" class="hoverShowTarget" targetParent="navUserCenter">
	
	<ul class="navMobile" style="display:none">
		<li><a href="my/person" class="iconUser">个人信息</a></li>
		<li class="active"><a href="my/lightbox" class="iconFolder" >收藏夹</a> <span style=" display: none; " class="icon-font icon-2-arrowRight"></span></li>
		<li><a href="my/myqp" class="iconHistory" >下载记录</a></li>
		<li><a href="#" class="iconInvoice" style="display:none">发票</a></li>
		<li><a href="#" class="iconSet" style="display:none">套餐</a></li>
		<li><a href="logout.do" class="btnLogOut btnPurple">退出登录</a></li>
	</ul>
				<ul class="navMobile">
					<li><a href="my/person" class="iconUser">个人信息</a></li>
					<li><a href="my/lightbox" class="iconFolder">收藏夹</a> </li>
					<li><a href="my/myqp" class="iconHistory">下载记录</a></li>
	<!-- 				<li><a href="#" class="iconInvoice">发票</a></li> -->
	<!-- 				<li><a href="#" class="iconSet">套餐</a></li> -->
					<li><a href="logout.do" class="iconLogOut btnLogOut">退出登录</a></li>
				</ul>
	<div class="navMobileSub visible-xs visible-sm">
		<div class="favFolderControl">
			<span class="icon-font icon-46-createNew btnCreateNewInFav"></span>
			<span class="icon-font icon-50-trash"></span>
		</div>

		<div class="favouriteFolderList">
			<div class="favFolderBox" lightBoxId="1">
				<a href="userFavourite.html" class="folder">
					<div class="favFolderName">秋天图片收集1</div>
					<div class="favFolderAmount">共<span>10</span>张图片</div>
				</a>
				<span class="btnClose icon-font icon-cross"></span>
			</div><!--favListBox-->
			<div class="favFolderBox" lightBoxId="2">
				<a href="userFavourite2.html" class="folder">
					<div class="favFolderName">秋天图片收集2</div>
					<div class="favFolderAmount">共<span>10</span>张图片</div>
				</a>
				<span class="btnClose icon-font icon-cross"></span>
			</div><!--favListBox-->
			<div class="favFolderBox" lightBoxId="3">
				<a href="userFavourite.html" class="folder">
					<div class="favFolderName">秋天图片收集3</div>
					<div class="favFolderAmount">共<span>10</span>张图片</div>
				</a>
				<span class="btnClose icon-font icon-cross"></span>
			</div><!--favListBox-->
			<div class="favFolderBox" lightBoxId="4">
				<a href="userFavourite2.html" class="folder">
					<div class="favFolderName">秋天图片收集4</div>
					<div class="favFolderAmount">共<span>10</span>张图片</div>
				</a>
				<span class="btnClose icon-font icon-cross"></span>
			</div><!--favListBox-->
		</div>
	</div>
</div><!--userCenterMobileMenu-->
	</div><!--navWrap-->
	
	<div class="lightBoxWrapOut">
		<div class="lightBoxWrap hidden-sm hidden-xs">
			<div class="leftPanel">
				<div class="lightBoxList selectWrap">
					<div class="selectValue">我的收藏版一<span class="num">6</span><span>图片</span></div>
					<div class="selectList">
						<ul>
							<li class="active" lightBoxId="1">我的收藏版一<span class="num">6</span><span>图片</span></li>
							<li lightBoxId="2">我的收藏版二<span class="num">2</span><span>图片</span></li>
							<li lightBoxId="3">我的收藏版三<span class="num">2</span><span>图片</span></li>
							<li lightBoxId="4">我的收藏四<span class="num">2</span><span>图片</span></li>
							<li lightBoxId="5">我的收藏五<span class="num">2</span><span>图片</span></li>
							<li lightBoxId="6">我的收藏六<span class="num">2</span><span>图片</span></li>
						</ul>
						<div class="createNew"><input name="" type="text" class="listName" placeholder="创造新的收藏版"/><div class="btnAdd"></div></div>
					</div>
				</div><!--lightBoxList-->
				
				<div class="btnWrap iconWrap">
					<a href="#" class="icon-font icon-31-shoppingCart2"></a>
					<a href="javascript:void(0)" class="icon-font icon-22-download"  onclick="DownloadAllinBox()"></a>
					<a href="javascript:void(0)" class="icon-font icon-14-setting"  onclick="goLightBox()"></a>
				</div>
			</div><!--leftPanel-->
			<div class="rightPanel">
				<div class="jcarousel-wrapper">
					<div class="jcarousel">
						<ul>
						</ul>
					</div>
					<a href="my/lightbox" class="btnMore">查看所有</a>
					<div class="currentPage"></div>
					<div class="closeJcarousel"> &times; </div>
					<p class="jcarousel-pagination"></p>
					
					<a href="#" class="jcarousel-control-prev icon-font icon-1-arrowLeft"></a>
					<a href="#" class="jcarousel-control-next icon-font icon-2-arrowRight"></a>
				</div>
			</div><!--rightPanel-->
		</div><!--lightBoxWrap-->
	</div><!--lightBoxWrapOut-->
	
	

</div><!--topBar-->
<!-- InstanceEndEditable -->

