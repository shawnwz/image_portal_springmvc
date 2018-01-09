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
	String basePath = new StringBuilder(request.getScheme()).append("://").append(request.getServerName())
						.append(":").append(request.getServerPort()).append(path).append("/").toString();
%>   
<base href=<%=basePath %>>
<jsp:include page="/header.jsp"/>
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
<body style="overflow-x: hidden;width:800px;">
		



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



<script>
	$(document).ready(function(){
		$(".Question").each(function(e,a){
			
			$(a).find("a").click(function(){
				$(".Answer").eq(e).closest("div").closest("div").toggle(1000);
			}); 
		});
	});
	
	function sendLink(){//sendLinkForm
		$.ajax({
				url:"contactus",
				type:"post",
				data:$("#sendLinkForm").serialize(),
				success:function(data){
					if(data.msg!="发送失败"){
						myAlert("发送成功，工作人员会于15个工作日内联系您。");
					}else{
						myAlert("发送失败");
					} 
				}
			});
	}
</script>





<link id="ctl00_MasterBaseStyles" href="css/testadjunct/Styles.css"
	rel="stylesheet" type="text/css">
<link href="css/testadjunct/Master.css" type="text/css" rel="stylesheet">
<link href="css/callme.css" type="text/css" rel="stylesheet"/>




	<div id="CustomerServiceContent" style="width:800px;float:left;padding-left:15px;width: 926px">
<div class="CustomerServiceContentDisplay">
<div class="TitleBar">
<div class="Title">客户服务</div></div>
<div class="LeftAccordion">
<div id="ctl00_mainContent_OfficesPanel">
<p class=p0
			style="margin-bottom: 5.0000pt; margin-top: 5.0000pt; text-align: left;">
			<span
				style="mso-spacerun: 'yes'; color: rgb(112, 112, 112); font-size: 9.0000pt; font-family: '微软雅黑';">版权管理及免版税图片</span><span
				style="mso-spacerun: 'yes'; color: rgb(112, 112, 112); font-size: 9.0000pt; font-family: '微软雅黑';"><o:p></o:p></span>
		</p>
		<p class=p0
			style="margin-bottom: 5.0000pt; margin-top: 5.0000pt; text-align: left; line-height: 18.0000pt;">
			<span
				style="mso-spacerun: 'yes'; color: rgb(112, 112, 112); font-size: 9.0000pt; font-family: '微软雅黑';">中国免费热线：400.820.0268</span><span
				style="mso-spacerun: 'yes'; color: rgb(112, 112, 112); font-size: 9.0000pt; font-family: '微软雅黑';"><o:p></o:p></span>
		</p>
		<p class=p0
			style="margin-bottom: 5.0000pt; margin-top: 5.0000pt; text-align: left; line-height: 18.0000pt;">
			<span
				style="mso-spacerun: 'yes'; color: rgb(112, 112, 112); font-size: 9.0000pt; font-family: '微软雅黑';">服务电邮：service@gaopinimages.com</span><span
				style="mso-spacerun: 'yes'; color: rgb(112, 112, 112); font-size: 9.0000pt; font-family: '微软雅黑';"><o:p></o:p></span>
		</p>
		<p class=p0
			style="margin-bottom: 0pt; margin-top: 0pt; text-align: left; line-height: 18.0000pt;">
			<span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-weight: bold; font-size: 9.0000pt; font-family: '微软雅黑';">北京</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-weight: bold; font-size: 9.0000pt; font-family: '微软雅黑';"><o:p></o:p></span>
		</p>
		<p class=p0
			style="margin-left: -0.2500pt; margin-left: 0.2500pt; margin-bottom: 0pt; margin-top: 0pt; text-align: left; line-height: 18.0000pt;">
			<span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-weight: bold; font-size: 9.0000pt; font-family: '微软雅黑';">电话：</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">&nbsp;+86&nbsp;10&nbsp;6500&nbsp;8152&nbsp;</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">&nbsp;&nbsp;</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">传真：+86&nbsp;10&nbsp;6500&nbsp;8192</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';"><o:p></o:p></span>
		</p>
		<p class=p0
			style="margin-left: -0.2500pt; margin-left: 0.2500pt; margin-bottom: 0pt; margin-top: 0pt; text-align: left; line-height: 18.0000pt;">
			<span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-weight: bold; font-size: 9.0000pt; font-family: '微软雅黑';">地址：</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">北京朝阳区工体北路4号院22号楼211&nbsp;邮编：100027</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';"><o:p></o:p></span>
		</p>
		<p class=p0
			style="margin-left: -0.2500pt; margin-left: 0.2500pt; margin-bottom: 0pt; margin-top: 0pt; text-align: left; line-height: 18.0000pt;">
			<span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-weight: bold; font-size: 9.0000pt; font-family: '微软雅黑';"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=p0
			style="margin-left: -0.2500pt; margin-left: 0.2500pt; margin-bottom: 0pt; margin-top: 0pt; text-align: left; line-height: 18.0000pt;">
			<span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-weight: bold; font-size: 9.0000pt; font-family: '微软雅黑';">上海</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';"><o:p></o:p></span>
		</p>
		<p class=p0
			style="margin-left: -0.2500pt; margin-left: 0.2500pt; margin-bottom: 0pt; margin-top: 0pt; text-align: left; line-height: 18.0000pt;">
			<span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-weight: bold; font-size: 9.0000pt; font-family: '微软雅黑';">电话：</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">&nbsp;+86&nbsp;21&nbsp;5407</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">&nbsp;</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">5711&nbsp;</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">&nbsp;&nbsp;</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">传真：+86&nbsp;21&nbsp;5407</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">&nbsp;</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">5712</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';"><o:p></o:p></span>
		</p>
		<p class=p0
			style="margin-left: -0.2500pt; margin-left: 0.2500pt; margin-bottom: 0pt; margin-top: 0pt; text-align: left; line-height: 18.0000pt;">
			<span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-weight: bold; font-size: 9.0000pt; font-family: '微软雅黑';">地址：</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">上海黄浦区四川中路外滩181大楼401&nbsp;邮编：200002</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';"><o:p></o:p></span>
		</p>
		<p class=p0
			style="margin-left: -0.2500pt; margin-left: 0.2500pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 18.0000pt;">
			<span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-weight: bold; font-size: 9.0000pt; font-family: '微软雅黑';"><o:p>&nbsp;</o:p></span>
		</p>
		<p class=p0
			style="margin-left: -0.2500pt; margin-left: 0.2500pt; margin-bottom: 0pt; margin-top: 0pt; line-height: 18.0000pt;">
			<span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-weight: bold; font-size: 9.0000pt; font-family: '微软雅黑';">广州</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';"><o:p></o:p></span>
		</p>
		<p class=p0
			style="margin-left: -0.2500pt; margin-left: 0.2500pt; margin-bottom: 0pt; margin-top: 0pt; text-align: left; line-height: 18.0000pt;">
			<span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-weight: bold; font-size: 9.0000pt; font-family: '微软雅黑';">电话：</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">&nbsp;+86&nbsp;20&nbsp;3847&nbsp;3900</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">&nbsp;&nbsp;</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">&nbsp;传真：+86&nbsp;20&nbsp;3847&nbsp;3901</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';"><o:p></o:p></span>
		</p>
		<p class=p0
			style="margin-left: -0.2500pt; margin-left: 0.2500pt; margin-bottom: 0pt; margin-top: 0pt; text-align: left; line-height: 18.0000pt;">
			<span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-weight: bold; font-size: 9.0000pt; font-family: '微软雅黑';">地址：</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';">广州天河区体育东横街3号设计大厦17楼17B02&nbsp;邮编:&nbsp;510620</span><span
				style="mso-spacerun: 'yes'; color: rgb(102, 153, 204); font-size: 9.0000pt; font-family: '微软雅黑';"><o:p></o:p></span>
		</p>

</div>
<div class="PaneHeaderExpanded" style="margin-top: 27px;">
<div id="faqPaneHeader">
<div class="Right">
<div class="Center">常见问题 </div></div></div>
<div class="Faq">
<div class="PaneContent">
<div class="Content">
<div id="ctl00_mainContent_faqAccordion" class="FAQAccordian" style="height: auto; overflow: auto;"><input id="ctl00_mainContent_faqAccordion_AccordionExtender_ClientState" type="hidden" value="-1" name="ctl00$mainContent$faqAccordion_AccordionExtender_ClientState">
<div>
<div class="faqHeader">网站要求 </div></div>
<div ><div style="display: block; height: auto; overflow: hidden;"></div></div>
<div class="">
<div class="Question"><a >高品图像 网站支持哪些浏览器？</a> 
</div></div>
<div ><div style="display: block; height: auto; overflow: hidden;">
<div class="Answer">
<p><b>微软Windows系统</b><br><a href="http://www.mozilla.com/en-US/firefox/personal.html">火狐浏览器</a> 3.0或以上版本， <a href="http://www.apple.com/safari">苹果Safari</a> 3.1或以上版本，<a href="http://www.microsoft.com/windows/internet-explorer"> 微软IE</a> 7.0或以上版本 
</p><br>
<p><b>苹果Mac OS系统</b><br><a href="http://www.mozilla.com/en-US/firefox/personal.html">火狐浏览器</a> 3.0或以上版本， <a href="http://www.apple.com/safari">苹果Safari</a> 3.1或以上版本 </p></div></div></div>
<div class="">
<div class="Question"><a >浏览 高品图像 网站的建议系统配置是什么？</a> 
</div></div>
<div class="show" ><div style="display: block; height: auto; overflow: hidden;">
<div class="Answer">
<p><b>微软Windows系统</b><br>
</p><ul style="MARGIN-LEFT: 10px">
  <li>1.8GHz 或更快的处理器 
  </li><li>Microsoft® Windows® XP with Service Pack 2 或更新版本 
  </li><li>512MB或更大的RAM 
  </li><li>1,024x768或更大显像用16-bit的视频采集卡 
  </li><li>连接宽带互联网 
  </li><li>Adobe Flash Player 插件 </li></ul>
<p></p><br>
<p><b>苹果Mac OS系统</b><br>
</p><ul style="MARGIN-LEFT: 10px">
  <li>PowerPC G5 处理器或 Intel 多芯处理器 
  </li><li>苹果 Mac OS X v10.4.11 或更新版本 
  </li><li>512MB或更大的RAM 
  </li><li>1,024x768或更大显像用16-bit的视频采集卡 
  </li><li>连接宽带互联网 
  </li><li>Adobe Flash Player 插件 </li></ul>
<p></p></div></div></div>
<div>
<div class="faqHeader">我的帐户 </div></div>
<div ><div style="display: block; height: auto; overflow: hidden;"></div></div>
<div class="">
<div class="Question"><a >如何更改我的用户名或密码?</a> </div></div>
<div ><div style="display: block; height: auto; overflow: hidden;">
<div class="Answer">
<p><b>更改用户名</b><br>登录时，您需要用户名及密码。我们建议您保留您注册 高品图像 时选用的用户名。 
但您也可以在登录后通过以下几个步骤，更改您的用户名： </p><br>
<ol style="MARGIN-LEFT: 10px">
  <li>1. 点击 <b><a>我的帐户</a></b>。 
  </li><li>2. 默认显示设定为 <a>档案资料及首选设置</a>。 
  </li><li>3. 在登录及个人资料里面，选择 <b>修改</b>。 
  </li><li>4. 输入一个新用户名以取代原本的用户名。 
  </li><li>5. 点击 <b>保存</b>。 </li></ol><br>
<p><b>更改密码</b><br>登录后通过以下几个步骤，您便可以随时更改您的密码： </p><br>
<ol style="MARGIN-LEFT: 10px">
  <li>1. 点击 <b><a>我的帐户</a></b>。 
  </li><li>2. 默认显示设定为 <a>档案资料及首选设置</a>。 
  </li><li>3. 在登录及个人资料里面，选择 <b>我想更改我的密码</b>。 
  </li><li>4. 输入您的现有密码。 
  </li><li>5. 输入您的新密码 (长度最少8个字符，必须包括字母及数字)。 
  </li><li>6. 确认您的新密码及点击 <b>保存</b>。 </li></ol></div></div></div>
<div class="">
<div class="Question"><a >如何更新我的帐户资料?</a> </div></div>
<div ><div style="display: block; height: auto; overflow: hidden;">
<div class="Answer">
<p>更改您的帐户资料，请先使用您的用户名及密码登录。然后，您可以更改个人、公司、付款与递送资料，以及首选设置，步骤如下： </p><br>
<ol style="MARGIN-LEFT: 10px">
  <li>1. 点击 <b><a>我的帐户</a></b>。 
  </li><li>默认显示设定为<a>档案资料及首选设置</a>。 
  </li><li>2. 您可以选择下面各项：<b>个人资料、公司资料或首选设置。</b> 
  </li><li>3. 选择您需要的类别以后，选择 <b>修改</b> 
  </li><li>4. 点击 <b>保存。</b> </li></ol></div></div></div>
<div>
<div class="faqHeader">灯箱 </div></div>
<div ><div style="display: block; height: auto; overflow: hidden;"></div></div>
<div>
<div class="Question"><a >如何创建灯箱?</a> </div></div>
<div style=""><div style="display: block; height: auto; overflow: hidden;">
<div class="Answer">
<p>高品图像 注册会员可以使用灯箱在线保存及转移图片。如果您是 高品图像 的新会员，或者刚开始一个大型项目，以下是一些对您有用的资料。 
</p><br>
<p><b>您可以用以下四种方法去创建新灯箱：</b></p><br>
<ol style="MARGIN-LEFT: 10px">
  <li>1. <b>从搜索结果中创建灯箱：</b> 点击您想保存到灯箱的缩略图下方的 <b>灯泡图标 </b>。 
  如果灯箱并不存在，一个弹出式窗口将会出现，您只要点击一下便可<b> 创建新灯箱。</b>为灯箱命名，然后点击 <b>添加到新灯箱。</b> 
  </li><li>2. <b>在优化搜索的窗格里：</b> 点击 <b>灯泡图标</b>，然后创建新灯箱。一个弹出式窗口将会出现，您可以为灯箱命名，然后点击 
  <b>保存</b>。 
  </li><li>3. <b>放大图片时创建灯箱：</b> 点击 
  <b>灯泡图标。</b>一个弹出式窗口将会出现，您只要点击一下便可<b>创建新灯箱。</b>为灯箱命名，然后点击 <b>添加到新灯箱。</b> 
  </li><li>4. <b>从我的灯箱里创建新灯箱：</b>在任何页面的上方，点击 <a>我的灯箱</a>。 
  在您的灯箱窗口的上方，点击<b>创建新灯箱。</b> </li></ol><br>
<p>新灯箱的创建者将会自动成为灯箱的拥有者及控制者，直到灯箱被转移为止。您可以添加灯箱，并把灯箱按照分层次序组合起来（如有需要）。 
</p></div></div></div>
<div class="">
<div class="Question"><a >如何把灯箱按照分层次序组合起来?</a> 
</div></div>
<div ><div style="display: block; height: auto; overflow: hidden;">
<div class="Answer">
<p>如果您以注册会员登录，您会发现您已保存了几个灯箱。您最后使用过的灯箱将会是您的当前灯箱，您添加到灯箱的图片将会自动发送至这个灯箱。 </p><br>
<ol style="MARGIN-LEFT: 10px">
  <li>1. 要进入您的灯箱，点击任何页面上方的 <b><a>我的灯箱</a>。</b> 
  </li><li>2. 要标示任何一个您的灯箱，请点击左面列表中的灯箱。 
  </li><li>3. 点击 <b>移动</b>。然后选择一个灯箱 (“父”)去装载这个原本的灯箱 (“子”)。 </li></ol><br>
<p><i>注意：“子”灯箱将会出现在 “父” 灯箱之下。在每个父灯箱之下，您最多可以创建四个子灯箱。</i></p></div></div></div>
<div>
<div class="Question"><a >如何更改我的“当前”灯箱?</a> </div></div>
<div ><div style="display: block; height: auto; overflow: hidden;">
<div class="Answer">
<p>如果您以注册会员登录，您会发现您已保存了几个灯箱。您最后使用过的灯箱将会是您的当前灯箱，您<b>添加到灯箱</b>的图片将会自动发送至这个灯箱。 
</p><br>
<p>要更改内含已保存图片的灯箱，请按照以下步骤： </p><br>
<p><b>在优化搜索的窗格里创建灯箱：</b></p>
<ol style="MARGIN-LEFT: 10px">
  <li>1. 要进入您的灯箱，点击优化搜索窗格里的灯箱键。 
  </li><li>2. 选择您打算用来保存图片的灯箱，然后点击缩略图下方的 <b>灯泡图标</b> 。 </li></ol><br>
<p><b>在图片放大页面创建灯箱：</b></p>
<ol style="MARGIN-LEFT: 10px">
  <li>1. 点击灯泡图标，一个弹出式窗口将会出现，您可以选择<b>添加到灯箱</b>或<b>创建新灯箱。</b> 
  </li><li>2. 当选择 <b>添加</b> 或 <b>添加到新灯箱</b> 作为储存图片的灯箱后，被选择的灯箱便会成为您的当前灯箱。 </li></ol><br>
<p><b>在我的灯箱里创建新灯箱：</b></p>
<ol style="MARGIN-LEFT: 10px">
  <li>1. 进入您的灯箱，点击任何页面上方的 <b>我的灯箱</b> 便可。 
  </li><li>2. 点击查看左方的任何灯箱，将会使灯箱成为当前灯箱。 </li></ol></div></div></div>
<div>
<div class="Question"><a >如何转移灯箱的拥有权?</a> </div></div>
<div ><div style="display: block; height: auto; overflow: hidden;">
<div class="Answer">
<p>新灯箱的创建者将会自动成为灯箱的拥有者及控制者，直到灯箱被转移为止。您可以把灯箱拥有权转移给别的 高品图像 会员，这样，他们便可以处理灯箱里的图片。 
</p>
<ol style="MARGIN-LEFT: 10px">
  <li>1. 点击 <b>我的灯箱</b> ，然后选择您想转移拥有权的灯箱。 
  </li><li>2. 点击 <b>转移</b> 并且从 高品图像 会员名单选框中选择新灯箱拥有者的用户名。<br \="">-<i>或者</i>-<br>在 
  添加一个高品图像会员 字段的位置输入新拥有者的用户名。 
  </li><li>3. 如果您想从您的名单中移除这个灯箱，请勾选 “从我的灯箱中移除”。 
  </li><li>4. 然后点击 <b>转移</b>。 </li></ol></div></div></div>
<div>
<div class="faqHeader">购买图片 </div></div>
<div ><div style="display: block; height: auto; overflow: hidden;"></div></div>
<div>
<div class="Question"><a >向 高品图像 购买图片需要些什么?</a> 
</div></div>
<div ><div style="display: block; height: auto; overflow: hidden;">
<div class="Answer">
<p>要购买图片，您必须注册成为 高品图像 会员。此外，<a>我的帐户</a>必须记录了您的付款资料。 
</p><br>
<p><b>在线购买版权管理图片 (RM) ，您需要完成下列各项：</b></p><br>
<ul style="MARGIN-LEFT: 10px">
  <li>输入每张图片的使用授权详情，获取价格资料。 
  </li><li>把已定价的图片保存在灯箱或购物车里。 </li></ul><br>
<p><b>如果选择的图片未能进行定价：</b></p><br>
<p>一个<b>联系</b>链接将会出现，要求客户主任(A.E.) ： </p>
<ul style="MARGIN-LEFT: 10px">
  <li>查看有关图片。 
  </li><li>购买图片前，必须在线定价。 
  </li><li>处理各项限制规定或审批程序。 </li></ul><br>
<p><b>高品图像 新的内容使用授权条款</b><br>请再查阅新的 <a href="images/Certified_EULA_CN.pdf">高品图像 
内容使用授权协议</a>，这与您的订单有着密切关系。</p></div></div></div>
<div>
<div class="Question"><a >如何购买图片?</a> </div></div>
<div ><div style="display: block; height: auto; overflow: hidden;">
<div class="Answer">如需购买图片，请点击图片下方的蓝色方型图标，并填妥联系表格与客户服务部门联系。 </div></div></div>
<div>
<div class="Question"><a >图片使用限制包括些什么?</a> </div></div>
<div ><div style="display: block; height: auto; overflow: hidden;">
<div class="Answer">
<p>很多 高品图像 图片都有使用限制规定。图片的使用限制规定多种多样；有些可能“在授权之前必须获得授权许可”，有些“不允许作印刷用途”。 </p><br>
<p>如果图片附带一个或多个限制，有关的使用限制会在图片详情页面中显示出来。在购买图片使用授权之前，您必须仔细地再次阅读有关图片的使用限制。</p><br>
<p>图片使用限制的内容太多，不能在这里全部显示出来。希望了解详情，请与您的 高品图像 客户代表联系。 </p></div></div></div>
<div>
<div class="Question"><a >RM 及 RF 是什么意思?</a> 
</div></div>
<div ><div style="display: block; height: auto; overflow: hidden;">
<div class="Answer">
<p>高品图像 主要提供的图像产品包括<b>版权管理图片</b>或<b>免版税图片。</b></p>
<p><b>版权管理图片(RM)：</b>使用授权及费用根据每个计划的需要而有所不同。</p>
<p><b>免版税图片(RF)：</b>支付一次性划一费用，图片可以在多个计划里作无限次使用。</p><br>
<p>请查阅<a href="images/Certified_EULA_CN.pdf">高品图像 
内容使用授权协议</a> </p></div></div></div>
<div>
<div class="Question"><a >购买图片使用授权之后，如何下载图像?</a> 
</div></div>
<div ><div style="display: block; height: auto; overflow: hidden;">
<div class="Answer">
<p>当您购买了一张或多张图片的使用授权，请按照这些步骤从我们的网站下载有关图片。 </p>
<p><i>注意：您必须登录，然后才可以下载授权图像。</i></p><br>
<ul style="MARGIN-LEFT: 10px">
  <li>点击<b><a>我的订单</a></b>找出相关的图片订单。 

  </li><li>找出您想下载的图片，然后用下拉式选框选择合适的图像精度。 
  </li><li>点击 <b>下载</b> 按钮。(要下载订单内的所有图片，请点击<b>下载全部</b>这个按钮。) 
  </li><li>当下载图片对话框出现时，点击您打算下载的图像文件。 
  </li><li>选择 "另存为" 及存放（下载）图片的位置。 </li></ul><br>
<p><b>压缩文件工具</b><br>为了方便用户下载， 图像文件是经过压缩的。您将会需要一个压缩文件工具，例如 WinZip 或 StuffIt，去开启 
高品图像 图像文件夹。 </p><br>
<p>Stufflt:<a href="http://my.smithmicro.com/downloads/index.html" target="_blank">http://my.smithmicro.com/downloads/index.html</a><br>WinZip:<a href="http://www.winzip.com/ddchomea.htm" target="_blank">http://www.winzip.com/ddchomea.htm</a></p></div></div></div>
<div>
<div class="Question"><a >购买图片使用授权之后，我可以取消交易吗?</a> 
</div></div>
<div ><div style="display: block; height: auto; overflow: hidden;">
<div class="Answer">
<p>根据某些特定的条款，购买图片使用授权后， 您可以要求取消（或终止）购买图像的使用授权。取消授权需缴付取消费 
(或“终止费”），以及相关的手续费、制作费，及/或服务费。 </p><br>
<ul style="MARGIN-LEFT: 10px">
  <li>如果您在七 (7) 个工作天后，但三十 (30) 个工作天前提出取消购买订单所载的图片使用授权，您将要缴付发票总额的百分之五十 (50%) 
  作为取消订单的服务费。 
  </li><li>我们不接纳在三十天后才提出取消订单的要求，有关客户必须全数缴付发票上列明的金额。 </li></ul><br>
<p>在任何情况下，取消订单必须缴付全额的服务费、制作费、手续费、及递送费用。取消订单后，您便失去图片的使用授权；所有取消的要求将被视作最终的决定。希望进一步了解取消购买图片使用授权的详情，或者关于取消订单的费用，请与您的 
高品图像 客户代表联系。</p></div></div></div></div></div></div></div></div>
<div class="PaneContentRound rc5px clear MB_20">
<div class="Bottom">
<div class="Left">
<div class="Right">
<div class="Center"  style="height:0px;"></div></div></div></div></div></div>



<div class="RightAccordion">
<div class="PaneHeaderExpanded">
<div class="PaneHeaderExpanded">
<div onclick="" id="getInTouchPaneHeader">
<div class="Right">
<div class="Center">保持联系 </div></div></div>
<div id="liveHelpContent" class="MyRep" style="DISPLAY: none">
<div class="PaneContent">
<div class="liveHelpContentHeader">在线帮助</div>
<div class="liveHelpContentDetails">需要快速的答复？联系我们的客户代表以寻求即时协助。<br></div>
<div id="liveHelpContentChatPanel" title="点击这里与 高品图像 客户代表在线商谈。" style="DISPLAY: none"><a id="liveHelpContentChatLink" href="javscript:void(0);">在线商谈</a> 
<div id="liveHelpContentChatIcon"></div></div></div></div>
<div id="ctl00_mainContent_ripOther" class="MyRep" style="DISPLAY: none">
<div class="PaneContent">
<div class="MyRepTitle">我的客户主任</div>
<div class="ContactNameLabel"><span id="ctl00_mainContent_contactName"></span></div>
<div class="ContactDetails"><span id="ctl00_mainContent_officeName">高品图像 
Images</span><br>
<div><span id="ctl00_mainContent_address1">3601A, The Center</span> <span id="ctl00_mainContent_address2">989 Chang Le Road<br></span><span id="ctl00_mainContent_address3"></span></div>
<div><span id="ctl00_mainContent_city">Shanghai</span> <span id="ctl00_mainContent_regionCode"></span><span id="ctl00_mainContent_postalCode">200031</span> </div>
<div><span id="ctl00_mainContent_country">中国</span> </div></div>
<div class="ContactDetails"><b>电话</b> <span id="ctl00_mainContent_phoneNumber">+86.21.5407.5711/ 400.820.0268</span><br></div>
<div class="ContactDetails"><b>传真</b> <span id="ctl00_mainContent_faxNumber">+86.21.5407.5712</span><br></div>
<div id="ctl00_mainContent_emailDiv" class="ContactDetails"><b>电子邮件</b> <a id="ctl00_mainContent_emailAddress" href="mailto:service@gaopinimages.com">service@gaopinimages.com</a><br></div></div></div>
<div id="ctl00_mainContent_ripSpain" class="MyRep" style="DISPLAY: none">
<div class="PaneContent">
<div class="MyRepTitle">我的客户主任</div>
<div class="ContactDetails"><b>商业类用途</b> <br>Latinstock España </div>
<div class="ContactDetails">电话：34 915 644 095 <br>传真：34 915 644 353 <br>电邮：<a href="mailto:comercial@latinstock.es" target="_blank">comercial@latinstock.es</a> 
</div><br>
<div class="ContactDetails"><b>编辑类用途</b> <br>Cordon Press </div>
<div class="ContactDetails">电话：34 91 361 4552 <br>传真：34 91 276 2901 <br>电邮：<a href="mailto:高品图像@cordonpress.com" target="_blank">高品图像@cordonpress.com</a> 
</div></div></div>
<div id="ctl00_mainContent_feedbackTitle" class="MyRep">
<div id="feedbackTitlePane" class="PaneContent">
<div class="SendUsFeedbackTitle">向我们反馈意见</div></div></div>
<div id="GetInTouch" class="GetInTouch">
<div id="validationPane" class="PaneContent">
<div id="ctl00_mainContent_ErrorSummaryPanel" class="ValidationSummary displayNone">
<ul></ul></div>
<form id="sendLinkForm" action="">
<table id="formTable" cellspacing="0">
  <tbody>
  <tr class="FormRow">
    <td class="FormLeft">关于 </td>
    <td class="FormRight"><select id="about" name="about"> <option selected="selected" value="技术协助">技术协助</option> <option value="图片搜索服务">图片搜索服务</option> <option value="网站反馈">网站反馈</option> <option value="销售 / 定价">销售 / 定价</option> <option value="一般问题">一般问题</option></select> </td></tr>
  <tr id="ctl00_mainContent_asianLastName" class="FormRow">
    <td class="FormLeft">姓氏 </td>
    <td class="FormRight"><input id="lastName" maxlength="30" name="lastName"/> </td></tr>
  <tr id="ctl00_mainContent_asianFirstName" class="FormRow">
    <td class="FormLeft">名字 </td>
    <td class="FormRight"><input id="firstName" maxlength="30" name="firstName" /> </td></tr>
  <tr class="FormRow">
    <td class="FormLeft">电子邮件 </td>
    <td class="FormRight"><input id="email" maxlength="255" name="email"/> </td></tr>
  <tr class="FormRow">
    <td class="FormLeft">电话 </td>
    <td class="FormRight"><input id="telephone" name="telephone"/> </td></tr>
  <tr class="FormRow">
    <td class="FormLeft">州 / 省</td>
    <td class="FormRight">
    
    
    <select class='edit-frm-fld' id='myProvince'
												name='myProvince'>
													<option value='--------------' disabled="disabled">----------------请选择---------------</option>
													<option value='Anhui'>Anhui</option>
													<option value='Beijing'>Beijing</option>
													<option value='Chong Qing'>Chong Qing</option>
													<option value='Fujian'>Fujian</option>
													<option value='Gansu'>Gansu</option>
													<option value='Guangdong'>Guangdong</option>
													<option value='Guangxi'>Guangxi</option>
													<option value='Guizhou'>Guizhou</option>
													<option value='Hainan'>Hainan</option>
													<option value='Hebei'>Hebei</option>
													<option value='Heilongjiang'>Heilongjiang</option>
													<option value='Henan'>Henan</option>
													<option value='Hubei'>Hubei</option>
													<option value='Hunan'>Hunan</option>
													<option value='Jiangsu'>Jiangsu</option>
													<option value='Jiangxi'>Jiangxi</option>
													<option value='Jilin'>Jilin</option>
													<option value='Liaoning'>Liaoning</option>
													<option value='Nei Mongol'>Nei Mongol</option>
													<option value='Ningxia'>Ningxia</option>
													<option value='Qinghai'>Qinghai</option>
													<option value='Shaanxi'>Shaanxi</option>
													<option value='Shandong'>Shandong</option>
													<option value='Shanghai'>Shanghai</option>
													<option value='Shanxi'>Shanxi</option>
													<option value='Sichuan'>Sichuan</option>
													<option value='Tianjin'>Tianjin</option>
													<option value='Xinjiang'>Xinjiang</option>
													<option value='Xizang'>Xizang</option>
													<option value='Yunnan'>Yunnan</option>
													<option value='Zhejiang'>Zhejiang</option>
											</select>
    
    
    
    
    </td></tr>
  <tr class="FormRow">
    <td class="FormLeft clear commentsSpacing">意见 </td>
    <td class="FormRight"><textarea id="comments" style="HEIGHT: 96px;background-color: #1A1A1A;" name="comments"></textarea> 
    </td></tr></tbody></table></form></div></div></div>
<div class="alignRight buttonPadding"  style="height: 50px;"><!--<span onclick="_formValidation.validateAll()">validate!</span> --><input id="ctl00_mainContent_save" class="btn btn-primary" type="submit" value="发送"  onclick="sendLink()"/> 
<input onclick="javascript:$('form').get(0).reset()" id="ctl00_mainContent_cancel" class="btn btn-primary" type="submit" value="清除" name="ctl00$mainContent$cancel"/> 
</div></div></div>
<div id="special" class="PaneContentRound rc5px MB_10" style="display:none;">
<div class="Bottom">
<div class="Left">
<div class="Right">
<div class="Center"></div></div></div></div></div></div>

<div id="getThankYou" style="WIDTH: 300px; DISPLAY: none">
<div class="ModalPopupPanelDialog" style="WIDTH: 300px">

<div class="ModalPopupContent">
<div></div>
<div class="FormButtons"><span id="ctl00_mainContent_ModalPopup1_getMessage" class="getMessage">高品图像 的客户代表会尽快与您联系。 </span><br>
<div id="ctl00_mainContent_ModalPopup1_GlassButton1" class="GlassButton btnOrangedbdbdb "><span class="Right"><input onclick="HideModal('getThankYou');return false;" id="ctl00_mainContent_ModalPopup1_GlassButton1_GlassButton" class="Center" type="submit" value="关闭" name="ctl00$mainContent$ModalPopup1$GlassButton1$GlassButton"></span> 
</div></div></div></div></div>

</div>

