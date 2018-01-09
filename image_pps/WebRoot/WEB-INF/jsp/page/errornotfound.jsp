<%@page import="com.gaopin.utils.StrUtils"%>
<%@page import="com.gaopin.entity.User"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width,user-scalable=no">
		<title>404</title>
		<link rel="Shortcut Icon" href="flowsearch/images/favorite.ico" type="image/x-icon">		
		<link href="flowsearch/css/font.css" rel="stylesheet" type="text/css">
		<link href="flowsearch/css/bootstrap.css" rel="stylesheet" type="text/css">
		<link href="flowsearch/css/404.css" rel="stylesheet" type="text/css">
		
		<script src="flowsearch/js/jquery-1.8.3.min.js" ></script>
		<script type="text/javascript" src="flowsearch/js/404.js"></script>

    </head>
    <body class="page404">
	<div class="background_image">
	    <img class="pc_bg" src="images/404bg.jpg"/>
		<img class="mobile_mbg" src="images/404mbg.jpg">		
	    <div id="topBar">
	        
			    <div class="navWrap" class="">
			        <div id="logo">
				        <a href="index"><img src="images/logo_404.png"></a>
			        </div>
					<div id="navRight" class="">
				        <ul>					
						<%
							User user = (User) session.getAttribute(User.class.getName());
							if (user != null) {
						%>
							<li><a href="my/person" class="hoverShow icon-font icon-17-user btnUser" id="navUserCenter" targetShow="userCenterMobileMenu">
									<span class="logInName visible-md-inline-block visible-lg-inline-block"><%=user.getUserName()%></span></a></li>
						<%
							} else {
						%>
					        <li>
							    <a href="login" class="hoverShow icon-font icon-17-user btnUser" id="navUserCenter" targetshow="userCenterMobileMenu">
								</a>
							</li>
						<%
							}
						%>
						</ul>
			        </div>
					<div id="navLeft" class="">
					      
					    <ul>
					        <li><a href="photostock659" class="" id="">创意图片</a></li>
					        <li><a href="photostock661" class="" id="">编辑图片</a></li>
                            <li><a href="http://motion.gaopinimages.com/search#p=1" class="" id="">视频</a></li>							
				        </ul>
	                </div>
					
					<!-- <div id="userCenterMobileMenu" class="hoverShowTarget" targetparent="navUserCenter">
				        <ul class="navMobile">
					        <li><a href="#" class="iconUser">个人信息</a></li>
					        <li><a href="#" class="iconFolder">收藏</a></li>
					        <li><a href="#" class="iconHistory">下载记录</a></li>					
					        <li><a href="#" class="iconLogOut btnLogOut">退出登录</a></li>
				        </ul>
					</div> -->
				</div>
			
		</div><!--topBar-->
		
		<div class="font404">
		    
		        <div class="font404_image">
			       <img src="images/font404.png"/>
				</div>
			
		</div>
		
		<div id="sectionBtm">
	              
                <div class="section_row">                   
                        
                        <div class="greyBg">
                            <div class="boxMedia">
                                <div class="icon"><img src="images/iconWeChat.gif"></div>
                                <div class="label">官方微信</div>
                            </div>
                            <div class="boxMedia ">
                                <a href="http://weibo.com/p/1006061732512424" class="icon icon-font icon-16-sina"></a>
                                <div class="label hidden-xs hidden-sm">官方微博</div>
                            </div>
                           
                        </div> 
						
						<div class="boxContact">
                            <h6 class="hotline"><span class="hidden-sm hidden-xs">免费热线：</span></h6>
                            <span class="hidden-sm hidden-xs">400-820-0268</span>
                           <!--  <span class="visible-sm visible-xs">热线：400-820-0268</span> -->
                        </div>   
						
						<div class="boxContact" id="service">
                            <!-- <div class="mobileFooterTest1 visible-sm visible-xs">
                                <span>电话：+86 21 5407 5711</span><br>
                                <span>传真：+86 21 5407 5712</span><br>
                                <span>服务电邮:</span><br>
                                <span><a href="mailto:service@gaopinimages.com" target="_blank">service@gaopinimages.com</a></span>
                            </div> -->
                            <h6 class="email hidden-sm hidden-xs">服务电邮：</h6>
                            <a class="hidden-sm hidden-xs" href="mailto:service@gaopinimages.com" target="_blank">service@gaopinimages.com</a>
                        </div>
						
                    	
                </div> 
				
        </div><!--sectionBtm-->
		
		
        <div id="footer">
	        <div class="container">
		        <div class="row">
                    <div class="col-lg-12 col-md-12 copyright"><div>
                    All contents © copyright 2015 Gaopin Images. All rights reserved. 本网站所有影像均由高品(上海)图像服务有限公司授权发布。侵权必究。沪ICP备09095511号</div></div>
	
		        </div>
	        </div>
        </div><!--footer-->
        
		
	</div>	
	
    </body>

</html>
