<%@page import="com.gaopin.utils.StrUtils"%>
<%@page import="com.gaopin.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div class="fullbackbox" style="z-index:998;width: 100%;height: 100%;position: fixed;display:none;opacity:0.5;background-color: black;"></div>
	<div class="fullbackboxfornote" style="z-index:998;width: 100%;height: 100%;position: fixed;display:none;opacity:0;background-color: black;"></div>
	<div class="divforselect" style="z-index: 2002; width: 100%; height: 100%; position: fixed; display: none; opacity: 0; background-color: black;top: 0px;left: 0px;"></div>
	<div class="divforerror" style="z-index: 2002; width: 700px; height: 700px; position: relative; display: none; top: 0px;left: 0px;">
	<img src="webres/upload/error.jpg" style="    margin-top: 25px;    margin-left: 35px;">
	
			<div style="margin-top: 25px;  margin-left: 35px;width: 800px;">
						<h1 style="font-size: 15.5pt;color: #A0A0A0;font-weight: bold;font-family: 微软雅黑,AdobeHeitiStd,STXihei;"> 呃~~抱歉，未找到你搜索的图片，你可以试试：其他关键词、减少关键词、减少筛选条件。</h1>
						<h1 style="font-size: 10.5pt;font-family: 微软雅黑,AdobeHeitiStd,STXihei;">或者联系我们</h1>
						<h1 style="font-size: 1.3em;display:none;" class="msg">result is empty!</h1>
					<br><p style="
			    font-size: 10.0pt;  font-family: &quot;微软雅黑&quot;,&quot;sans-serif&quot;;  color: #A0A0A0;
			">中国客服热线: 400.820.0268</p>
					<br><p style="
			    font-size: 10.0pt;  font-family: &quot;微软雅黑&quot;,&quot;sans-serif&quot;;  color: #A0A0A0;
			">北京: +86.10.6500.8152</p>
					<br><p style="
			    font-size: 10.0pt;  font-family: &quot;微软雅黑&quot;,&quot;sans-serif&quot;;  color: #A0A0A0;
			">上海: +86.21.5407.5711</p>
					<br><p style="
			    font-size: 10.0pt;  font-family: &quot;微软雅黑&quot;,&quot;sans-serif&quot;;  color: #A0A0A0;
			">广州: +86.20.3847.3900</p>
				</div>
	</div>
	<div class="top">
    	<a href="/"><img src="images/logo.png" class="logo" /></a>
        <div class="imformation">
        	<a href="javascript:void(0);" style="display: none;"><font size=3><b>Timer[<span id="pageSize">50</span>]:　<span id="timer">--</span></b></font> ms</a>
        	<a href="javascript:void(0);" style="cursor: default;"><img src="images/top_phone.png" style="cursor: default;"><span style="color:#9c9b9b">400-820-0268</span></a>
        	<%
				User user = (User)session.getAttribute(User.class.getName());
				if(user!=null){
			%>
            	<a href="javascript:void(0);"><img src="images/top_user.png" /><%=StrUtils.getNullStr(user.getFirstName(), "") %>&nbsp;<%=StrUtils.getNullStr(user.getLastName(), "") %></a> <img src="images/user_more.png" onclick="boxshow('userbox')" />
            <%}else{%>
            	<a href="login">登录</a>
            	<!--或者<a href="registpage">注册</a> -->
            <%} %>
        </div>
        <div class="user-control" id="userbox" onmouseover="boxshow('userbox')" onmouseout="boxhidden('userbox')">
        	<a href="my/person"><p>我的账户</p></a>
            <a href="my/lightbox"><p>灯箱</p></a>
<!--          <a href="my/myod"><p>小样图下载记录</p></a> -->   
            <a href="logout.do"><p>退出</p></a>
        </div>
    </div>
    <div class="menu">
    	<div id="menubox1" onmouseover="meunshow('menubox1')" onmouseout="meunhidden('menubox1')" class="menu-box">
        	<a href="javascript:void(0);" class="">创意图片</a>
        	<div class="menu-showbox">
            	<a href="photostock/7"><p><img src="images/showmenu-pic1-1.png" /><span>版权管理图片</span><br />高品质商业类摄影</p></a>
            	<a href="photostock/8"><p><img src="images/showmenu-pic1-2.png" /><span>免版税图片</span><br />无限制商业类及编辑类用途</p></a>
            	<a href="photostock/9"><p><img src="images/showmenu-pic1-3.png" /><span>插画</span><br />从手绘线条到优美的插画</p></a>
            	<a href="#" style="display:none;"><p><img src="images/showmenu-pic1-4.png" /><span>虚拟CD</span><br />内容多样化的免版税图库</p></a>
            </div>
        </div>
    	<div id="menubox2" onmouseover="meunshow('menubox2')" onmouseout="meunhidden('menubox2')" class="menu-box">
        	<a href="javascript:void(0);">编辑图片</a>
        	<div class="menu-showbox" style="width:300px;">
            	<a href="photostock/1"><p><img src="images/showmenu-pic2-1.png" /><span>纪实</span><br />人文、自然、科学，及摄影大师的作品</p></a>
            	<a href="photostock/2"><p><img src="images/showmenu-pic2-2.png" /><span>艺术作品</span><br />多个世纪的大师视像意念</p></a>
            	<a href="photostock/3"><p><img src="images/showmenu-pic2-3.png" /><span>档案</span><br />记录历史性时刻的图像</p></a>
            	<a href="photostock/4"><p><img src="images/showmenu-pic2-4.png" /><span>时事与体育</span><br />频密更新的时事及体育图像</p></a>
            	<a href="photostock/5"><p><img src="images/showmenu-pic2-5.png" /><span>娱乐</span><br />关于艺人及娱乐盛事的详尽报导</p></a>
            	<a href="photostock/6"><p><img src="images/showmenu-pic2-6.png" /><span>Outline</span><br />为名星名人所约拍的独家肖像</p></a>
            </div>
        </div>
    	<div class="menu-box"><a href="http://www.corbismotion.com/" target="_blank">影像素材</a></div>
    	<div class="menu-box" style="display:none;"><a href="search#cate_id=690&p=1"  target="_blank">娱乐</a></div>
    	
    </div>
<script>
	$(function() {
		$(window).scroll(
				function() { //只要窗口滚动,就触发下面代码 
					var scrollt = document.documentElement.scrollTop
							+ document.body.scrollTop; //获取滚动后的高度 
					if (scrollt > 200) { //判断滚动后高度超过200px,就显示  
						$(".backtop").fadeIn(400); //淡出     
					} else {
						$(".backtop").stop().fadeOut(400); //如果返回或者没有超过,就淡入.必须加上stop()停止之前动画,否则会出现闪动   
					}
				});

		$(".backtop").click(function() { //当点击标签的时候,使用animate在200毫秒的时间内,滚到顶部
			$("html,body").animate({
				scrollTop : "0px"
			}, 250);
		});
	});
	function backtopover(){
		$(".backtop").css("background","url(images/arrow_top_02.png) no-repeat");
	}
	function backtopout(){
		$(".backtop").css("background","url(images/arrow_top_01.png) no-repeat");
	}
</script>
		<a  >   
			 	<span class="backtop" style="background: url(images/arrow_top_01.png) no-repeat;background-position: 0% 100%;z-index: 9999;" onmouseout="backtopout()" title="回到顶部" onmouseover="backtopover()"></span> 
		</a>
		
		