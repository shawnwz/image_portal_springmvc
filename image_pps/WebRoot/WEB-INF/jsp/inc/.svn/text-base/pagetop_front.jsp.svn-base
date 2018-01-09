<%@page import="com.gaopin.utils.StrUtils"%>
<%@page import="com.gaopin.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- InstanceBeginEditable name="nav" -->
<div id="topBar">
	<div class="container">
		<div class="navWrap">
			<div id="logo">
				<a href="index"><img src="images/logo.png" /></a>
			</div>
			<div id="navRight" class="">
				<ul>
					<li><a href="javascript:void(0)"
						class="hoverShow icon-font icon-5-collapse visible-xs visible-sm"
						id="navMobileMenu" targetshow="navLeft"></a></li>
					<li><a href="mailto:service@gaopinimages.com"
						class="icon-font icon-3-chat  visible-md visible-lg"></a></li>
					<!--                <li class="visible-md visible-lg"><a href="javascript:openPage('callme')" class="icon-font icon-15-shoppingCart"></a></li> -->
					<%
						User user = (User) session.getAttribute(User.class.getName());
						if (user != null) {
					%>
					<li><a href="javascript:void(0);"
						class="icon-font icon-11-favourite btnLightBox  visible-md visible-lg"></a></li>
					<li><a href="javascript:void(0);"
						class="hoverShow icon-font icon-17-user btnUser"
						id="navUserCenter" targetShow="userCenterMobileMenu"><span
							class="logInName visible-md-inline-block visible-lg-inline-block"><%=user.getUserName()%></span></a></li>
					<%
						} else {
					%>
					<li><a href="login"
						class="icon-font icon-11-favourite btnLightBox1  visible-md visible-lg"></a></li>
					<li><a href="login" class="icon-font icon-17-user btnUser"></a></li>
					<%
						}
					%>
					<!-- 					<li><a href="javascript:void(0)" class="hoverShow icon-font icon-5-collapse visible-xs visible-sm" id="navMobileMenu" target="navLeft"></a></li> -->
				</ul>
			</div>
			<div id="navLeft" class="hoverShowTarget"
				targetParent="navMobileMenu">
				<ul class="Source-Han-Light">
					<li><a href="photostock659" target="_blank" id="menu0">创意图片<span
							class="officeBtn icon-font icon-plus" rel="numb1"></span></a>
						<div class="secondaryMenu">
							<div class="container">
								<span class="classification col-md-2"> <a
									href="javascript:;" id="menu_t_00"> <img
										src="webres/upload/classification01.jpg" alt=""/"> <span>查看更多</span>
								</a> <a href="javascript:;" id="menu_b_00">力量，璀璨文明</a>
								</span> <span class="classification col-md-2"> <a
									href="javascript:;" id="menu_t_01"> <img
										src="webres/upload/classification02.jpg" alt="" /> <span>查看更多</span>
								</a> <a href="javascript:;" id="menu_b_01">力量，风雨无阻</a>
								</span> <span class="classification col-md-2"> <a
									href="javascript:;" id="menu_t_02"> <img
										src="webres/upload/classification03.jpg" alt="" /> <span>查看更多</span>
								</a> <a href="javascript:;" id="menu_b_02">童梦</a>
								</span> <span class="classification col-md-2"> <a
									href="javascript:;" id="menu_t_03"> <img
										src="webres/upload/classification04.jpg" alt="" /> <span>查看更多</span>
								</a> <a href="javascript:;" id="menu_b_03">动物总动员</a>
								</span> <span class="classification col-md-2"> <a
									href="javascript:;" id="menu_t_04"> <img
										src="webres/upload/classification05.jpg" alt="" /> <span>查看更多</span>
								</a> <a href="javascript:;" id="menu_b_04">分类五</a>
								</span> <span class="classification col-md-2"> <a
									href="javascript:;" id="menu_t_05"> <img
										src="webres/upload/classification06.jpg" alt="" /> <span>查看更多</span>
								</a> <a href="javascript:;" id="menu_b_05">分类六</a>
								</span> <span class="classification col-md-2"> <a
									href="javascript:;" id="menu_t_06"> <img
										src="webres/upload/classification07.jpg" alt="" /> <span>查看更多</span>
								</a> <a href="javascript:;" id="menu_b_06">分类七</a>
								</span>
							</div>
							<div class="hotAlbums">
								<div class="container">
									<div class="col-md-12">
										<span class="label">热门专辑：</span><a href="#"
											class="navBadge active" id="menu_k_00">纽约市</a><a href="#" class="navBadge" id="menu_k_01">都市风光</a><a
											href="#" class="navBadge" id="menu_k_02">摩天大楼</a><a href="#"
											class="navBadge" id="menu_k_03">天空</a><a href="#" class="navBadge" id="menu_k_04">都市风情</a><a
											href="#" class="navBadge" id="menu_k_05">空中</a><a href="#" class="navBadge" id="menu_k_06">建筑学</a><a
											href="#" class="navBadge" id="menu_k_07">云朵</a><a href="#" class="navBadge" id="menu_k_08">帝国大厦</a><a
											href="#" class="navBadge" id="menu_k_09">美国</a><a href="#" class="navBadge" id="menu_k_010">高楼建筑群</a><a
											href="#" class="navBadge" id="menu_k_011">建筑物</a>
									</div>
								</div>
							</div>
						</div></li>
					<li><a href="photostock661" target="_blank" id="menu1">编辑图片<span
							class="officeBtn icon-font icon-plus" rel="numb2"></span></a>
						<div class="secondaryMenu pictureMenu">
							<div class="container">
								<span class="classification col-md-2"> <a
									href="javascript:;" id="menu_t_10"> <img
										src="webres/upload/classification01.jpg" alt="" /> <span>进入详情</span>
								</a> <a href="javascript:;" id="menu_b_10">纪实</a>
									<p id="menu_b_10_p">一个世纪的名人及娱乐摄影，从经典图像、时尚人物肖像到红地毯图片。</p>
								</span> <span class="classification col-md-2"> <a
									href="javascript:;" id="menu_t_11"> <img
										src="webres/upload/classification02.jpg" alt="" /> <span>进入详情</span>
								</a> <a href="javascript:;" id="menu_b_11">历史</a>
									<p id="menu_b_11_p">一个世纪的名人及娱乐摄影，从经典图像、时尚人物肖像到红地毯图片。</p>
								</span> <span class="classification col-md-2"> <a
									href="javascript:;" id="menu_t_12"> <img
										src="webres/upload/classification03.jpg" alt="" /> <span>进入详情</span>
								</a> <a href="javascript:;" id="menu_b_12">艺术</a>
									<p id="menu_b_12_p">一个世纪的名人及娱乐摄影，从经典图像、时尚人物肖像到红地毯图片。</p>
								</span> <span class="classification col-md-2"> <a
									href="javascript:;" id="menu_t_13"> <img
										src="webres/upload/classification04.jpg" alt="" /> <span>进入详情</span>
								</a> <a href="javascript:;" id="menu_b_13">娱乐</a>
									<p id="menu_b_13_p">一个世纪的名人及娱乐摄影，从经典图像、时尚人物肖像到红地毯图片。</p>
								</span> <span class="classification col-md-2"> <a
									href="javascript:;" id="menu_t_14"> <img
										src="webres/upload/classification05.jpg" alt="" /> <span>进入详情</span>
								</a> <a href="javascript:;" id="menu_b_14">分类五</a>
									<p id="menu_b_14_p">一个世纪的名人及娱乐摄影，从经典图像、时尚人物肖像到红地毯图片。</p>
								</span> <span class="classification col-md-2"> <a
									href="javascript:;" id="menu_t_15"> <img
										src="webres/upload/classification06.jpg" alt="" /> <span>进入详情</span>
								</a> <a href="javascript:;" id="menu_b_15">分类六</a>
									<p id="menu_b_15_p">一个世纪的名人及娱乐摄影，从经典图像、时尚人物肖像到红地毯图片。</p>
								</span> <span class="classification col-md-2"> <a
									href="javascript:;" id="menu_t_16"> <img
										src="webres/upload/classification07.jpg" alt="" /> <span>进入详情</span>
								</a> <a href="javascript:;" id="menu_b_16">分类七</a>
									<p id="menu_b_16_p">一个世纪的名人及娱乐摄影，从经典图像、时尚人物肖像到红地毯图片。</p>
								</span>
							</div>
							<div class="hotAlbums">
								<div class="container">
									<div class="col-md-12">
										<span class="label">热门推荐：</span><a href="#"
											class="navBadge active" id="menu_k_10">纽约市</a><a href="#" class="navBadge" id="menu_k_11">都市风光</a><a
											href="#" class="navBadge" id="menu_k_12">摩天大楼</a><a href="#"
											class="navBadge" id="menu_k_13">天空</a><a href="#" class="navBadge" id="menu_k_14">都市风情</a><a
											href="#" class="navBadge" id="menu_k_15">空中</a><a href="#" class="navBadge" id="menu_k_16">建筑学</a><a
											href="#" class="navBadge" id="menu_k_17">云朵</a><a href="#" class="navBadge" id="menu_k_18">帝国大厦</a><a
											href="#" class="navBadge" id="menu_k_19">美国</a><a href="#" class="navBadge" id="menu_k_110">高楼建筑群</a><a
											href="#" class="navBadge" id="menu_k_111">建筑物</a>
									</div>
								</div>
							</div>
						</div></li>
					<li><a href="imgsets" target="_blank">高品专辑</a></li>
				</ul>


				<div class="navMobileSub visible-xs visible-sm">
					<dl class="numb1">
						<dt>
							<span class="icon-font icon-1-arrowLeft"></span>创意图片
						</dt>
						<dd>
							<a href="javascript:;">力量，璀璨文明</a>
						</dd>
						<dd>
							<a href="javascript:;">力量，风雨无阻</a>
						</dd>
						<dd>
							<a href="javascript:;">童梦</a>
						</dd>
						<dd>
							<a href="javascript:;">动物总动员</a>
						</dd>
						<dd>
							<a href="javascript:;">热门专辑</a>
						</dd>
						<dd>
							<a href="javascript:;">热门专辑</a>
						</dd>
						<dd>
							<a href="javascript:;">热门专辑</a>
						</dd>
					</dl>
					<dl class="numb2">
						<dt>
							<span class="icon-font icon-1-arrowLeft"></span>编辑图片
						</dt>
						<dd>
							<a href="javascript:;">纪实</a>
						</dd>
						<dd>
							<a href="javascript:;">历史</a>
						</dd>
						<dd>
							<a href="javascript:;">艺术</a>
						</dd>
						<dd>
							<a href="javascript:;">娱乐</a>
						</dd>
						<dd>
							<a href="javascript:;">分类五</a>
						</dd>
						<dd>
							<a href="javascript:;">分类六</a>
						</dd>
						<dd>
							<a href="javascript:;">分类七</a>
						</dd>
					</dl>
				</div>
			</div>
			<!--navLeft-->



			<div id="userCenterMobileMenu" class="hoverShowTarget"
				targetParent="navUserCenter">

				<ul class="navMobile" style="display: none">
					<li><a href="my/person" class="iconUser">个人信息</a></li>
					<li class="active"><a href="my/lightbox" class="iconFolder">收藏夹</a>
						<span style="display: none;" class="icon-font icon-2-arrowRight"></span></li>
					<li><a href="my/myqp" class="iconHistory">下载记录</a></li>
					<li><a href="#" class="iconInvoice" style="display: none">发票</a></li>
					<li><a href="#" class="iconSet" style="display: none">套餐</a></li>
					<li><a href="logout.do" class="btnLogOut btnPurple">退出登录</a></li>
				</ul>

				<ul class="navMobile">
					<li><a href="my/person" class="iconUser">个人信息</a></li>
					<li><a href="my/lightbox" class="iconFolder">收藏夹</a></li>
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
								<div class="favFolderAmount">
									共<span>10</span>张图片
								</div>
							</a> <span class="btnClose icon-font icon-cross"></span>
						</div>
						<!--favListBox-->
						<div class="favFolderBox" lightBoxId="2">
							<a href="userFavourite2.html" class="folder">
								<div class="favFolderName">秋天图片收集2</div>
								<div class="favFolderAmount">
									共<span>10</span>张图片
								</div>
							</a> <span class="btnClose icon-font icon-cross"></span>
						</div>
						<!--favListBox-->
						<div class="favFolderBox" lightBoxId="3">
							<a href="userFavourite.html" class="folder">
								<div class="favFolderName">秋天图片收集3</div>
								<div class="favFolderAmount">
									共<span>10</span>张图片
								</div>
							</a> <span class="btnClose icon-font icon-cross"></span>
						</div>
						<!--favListBox-->
						<div class="favFolderBox" lightBoxId="4">
							<a href="userFavourite2.html" class="folder">
								<div class="favFolderName">秋天图片收集4</div>
								<div class="favFolderAmount">
									共<span>10</span>张图片
								</div>
							</a> <span class="btnClose icon-font icon-cross"></span>
						</div>
						<!--favListBox-->
					</div>
				</div>
			</div>
			<!--userCenterMobileMenu-->
		</div>
		<!--navWrap-->
		<div class="lightBoxWrapOut">
			<div class="lightBoxWrap hidden-sm hidden-xs">
				<div class="leftPanel">
					<div class="lightBoxList selectWrap">
						<div class="selectValue">
							我的收藏版一<span class="num">6</span><span>图片</span>
						</div>
						<div class="selectList">
							<ul>
								<li class="active" lightBoxId="1">我的收藏版一<span class="num">6</span><span>图片</span></li>
								<li lightBoxId="2">我的收藏版二<span class="num">2</span><span>图片</span></li>
								<li lightBoxId="3">我的收藏版三<span class="num">2</span><span>图片</span></li>
								<li lightBoxId="4">我的收藏四<span class="num">2</span><span>图片</span></li>
								<li lightBoxId="5">我的收藏五<span class="num">2</span><span>图片</span></li>
								<li lightBoxId="6">我的收藏六<span class="num">2</span><span>图片</span></li>
							</ul>
							<div class="createNew">
								<input name="" type="text" class="listName"
									placeholder="创造新的收藏版" />
								<div class="btnAdd"></div>
							</div>
						</div>
					</div>
					<!--lightBoxList-->

					<div class="btnWrap iconWrap">
						<a href="#" class="icon-font icon-31-shoppingCart2"></a> <a
							href="javascript:void(0)" class="icon-font icon-22-download"
							onclick="DownloadAllinBox()"></a> <a href="javascript:void(0)"
							class="icon-font icon-14-setting" onclick="goLightBox()"></a>
					</div>
				</div>
				<!--leftPanel-->
				<div class="rightPanel">
					<div class="jcarousel-wrapper">
						<div class="jcarousel">
							<ul>

							</ul>
						</div>
						<a href="my/lightbox" class="btnMore">查看所有</a>
						<div class="currentPage"></div>
						<div class="closeJcarousel">&times;</div>
						<p class="jcarousel-pagination"></p>

						<a href="#"
							class="jcarousel-control-prev icon-font icon-1-arrowLeft"></a> <a
							href="#"
							class="jcarousel-control-next icon-font icon-2-arrowRight"></a>
					</div>
				</div>
				<!--rightPanel-->
			</div>
			<!--lightBoxWrap-->
		</div>
		<!--lightBoxWrapOut-->


	</div>
	<!--container-->
</div>
<!--topBar-->

