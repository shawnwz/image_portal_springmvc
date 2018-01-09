<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ page import="com.gaopin.entity.User"%>

<jsp:include page="question_header.jsp" /> 
<script type="text/javascript" src="js/require.js"></script>
<script type="text/javascript" src="js/photographer.js"></script>
<script type="text/javascript" src="js/person.js"></script>
<script>
$(document).ready(function(){
	comStreetAddress1='${conMap["comStreetAddress1"]}';
	comStreetAddress2='${conMap["comStreetAddress2"]}';
	comStreetAddress3='${conMap["comStreetAddress3"]}';
	comCity='${conMap["comCity"]}';
	comProvince='${conMap["comProvince"]}';
	comZipCode='${conMap["comZipCode"]}';
	
	$("#comCity").val(comCity);
	$("#comAddress").val(comProvince+" "+comCity);
	$("#comProvince").val(comProvince);
	
	myStreetAddress1='${conMap["myStreetAddress1"]}';
	myStreetAddress2='${conMap["myStreetAddress2"]}';
	myStreetAddress3='${conMap["myStreetAddress3"]}';
	//myCity
	myCity='${conMap["myCity"]}';
	myProvince='${conMap["myProvince"]}';
	myZipCode='${conMap["myZipCode"]}';

	if(${login} == 1)
	{
		$(".icon-40-success").hide();
	}
	
});
function checkStr(str){
	if(str&&str!=""){
		return true;
	}
	return false;
}
function updateUser()
{
	$("#cominfo").val('{"comName":"' + $("#comName").val() + '",' + '"comPhone":' + '"' + $("#comPhone").val() + '",' + '"comStreetAddress1":' + '"' + $("#comStreetAddress1").val() + '",' + '"comStreetAddress2":' + '"' + $("#comStreetAddress2").val() + '",' + '"comStreetAddress3":' + '"' + $("#comStreetAddress3").val() + '",' + '"comCity":' + '"' + $("#comCity").val() + '",' + '"comProvince":' + '"' + $("#comProvince").val() + '",' + '"comZipCode":' + '"' + $("#comZipCode").val() + '",' + '"comCountry":' + '"' + $("#comCountry").val() + '"}'),
			$.post("my/updateComInfo.do", $("#comForm").serialize(),
			function(e) {
				if(e.state == 1  )
				{
					var a16 = $("input[name=a16]").val();
					//回填fr_questionnaire表 userid
					$.post("Questionnaire/updateA16.do", {A16:a16}, function(data) {
						 
					});
					window.location.href = $("#baseUrl").val()+"Questionnaire/step4.do?A16="+a16;
				}
			});
}
 
</script>

<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">
	<div class="container">
 		<div class="row1"><img src="promoted/images/promoted/topBanner.jpg"/></div><!--row1-->

				
		<div class="row2 row">
			<div class="col-md-6 col-md-offset-3">
				<h2 class="SiYuanBold">为什么参与？</h2>
				<p>高品网站已经全新改版上线，你对新网站有什么建议？请完成下面几个小问题，	只要你的信息真实有效， 就会获得我们为你准备的精美好礼，价值RMB120，礼品有限，先到先得，快快点击参与！</p>
			</div>
		</div><!--row2-->
		
		
		

		
		<div class="applyWrap promotedApply" id="formApply">
				<div class="headerBar"><span class="SiYuan-ExtraLight">有奖调查</span></div>
				
				<div class="applyContWrap">
					<div class="stepCont">
						<div class="stepProcess">
							<div class="dot past">1</div>
							<div class="bar past"></div>
							<div class="dot active">2</div>
						</div><!--stepProcess-->
						<div class="contBox">
							

							<div class="intro">
								<h3 class="icon-40-success">注册成功！ </h3>
								<p>感谢你参与，请完善个人资料，我们将按你写的联系方式分配专员为你派送价值RMB120的精美好礼！你，是高品前进的动力！</p>
							</div>
									 
							<form id ="comForm" role="form" method="post" class="form-lg form-txtLabel">
							

								<div class="input-group focusWrap">
									<div class="label">姓名</div>
 
									<input id='acc_pInfo_lastName' name='lastName'  class="form-control ignore" type="text" value="${testUser.lastName}"></input>
									<label class="has-error" for="formName2" generated="true"></label>
								</div>

								
								
								<div class="input-group focusWrap ">
									<div class="label">公司名称</div>
									<input class="form-control ignore" type="text" id="comName" name="CompanyName" value='${conMap["comName"]}'></input>
								</div>

								
								<div class="officeAddress">
									<div class="title">公司地址</div>
									<div class="input-group">
										<div class="label">省</div>
										<div class="selectBlock">
											<select class="ignore" id="comProvince" name="RegionCode">
												<c:if
														test="${conMap.myProvince!=''||conMap.myProvince!=null}">
														<option value='${conMap.myProvince}'>
															${conMap.myProvince}</option>
													</c:if>
													<option value='--------------' disabled="disabled">----------------请选择---------------</option>
													<option value='安徽'>安徽</option>
													<option value='北京'>北京</option>
													<option value='天津'>天津</option>
													<option value='上海'>上海</option>
													<option value='重庆'>重庆</option>
													<option value='福建'>福建</option>
													<option value='甘肃'>甘肃</option>
													<option value='广东'>广东</option>
													<option value='广西'>广西</option>
													<option value='贵州'>贵州</option>
													<option value='海南'>海南</option>
													<option value='河北'>河北</option>
													<option value='黑龙江'>黑龙江</option>
													<option value='河南'>河南</option>
													<option value='湖北'>湖北北</option>
													<option value='湖南'>湖南</option>
													<option value='江苏'>江苏</option>
													<option value='江西'>江西</option>
													<option value='吉林'>吉林</option>
													<option value='辽宁'>辽宁</option>
													<option value='内蒙古'>内蒙古</option>
													<option value='宁夏'>宁夏</option>
													<option value='青海'>青海</option>
													<option value='山西'>山西</option>
													<option value='山东'>山东</option>
													<option value='陕西'>陕西</option>
													<option value='四川'>四川</option>
													<option value='新疆'>新疆</option>
													<option value='西藏'>西藏</option>
													<option value='云南'>云南</option>
													<option value='浙江'>浙江</option>
											</select>
										</div>
									</div>
									<div class="input-group">
										<div class="label">市</div>
										<div class="selectBlock">
											<input class="form-control ignore" id="comCity" name="City" type='text' value='${conMap["myCity"]}'></input>
										
										</div>
									</div>
									<div class="input-group" style="display:none">
										<div class="label">区</div>
										<div class="selectBlock">
											<select class="ignore">
												<option>北京</option>
												<option>北京1</option>
												<option>北京2管</option>
											</select>
										</div>
									</div>
									<div class="input-group focusWrap">
										<div class="label">街道地址</div>
										<input class="form-control ignore" type="text" id="comStreetAddress1" name="Address1" value='${conMap["comStreetAddress1"]}'></input>
									</div>
									<div class="input-group focusWrap">
										<div class="label">邮政编码</div>
										<input id="comZipCode" name="PostalCode" class="form-control ignore" value='${conMap["comZipCode"]}'></input>
										<label class="has-error" for="formZip" generated="true"></label>
									</div>
								</div><!--officeAddress-->
								
								
								
								<div class="input-group">
									<div class="label">职位</div>
									
									<div class="selectBlock">
										<select class="ignore" id="jobTitle" name="jobTitle">
											<c:if test="${testUser.jobTitle!=''||testUser.jobTitle!=null}">
													<option value='${testUser.jobTitle}'>	${testUser.jobTitle}</option>
											</c:if>
											<option value='--------------' disabled="disabled">----------------请选择---------------</option>
											<option value="客户主任">客户主任</option>
											<option value="会计">会计</option>
											<option value="美术买手">美术买手</option>
											<option value="美术总监">美术总监</option>
											<option value="作者/编辑/文案">作者/编辑/文案</option>
											<option value="内容提供者">内容提供者</option>
											<option value="创意总监">创意总监</option>
											<option value="教育工作者/教师">教育工作者/教师</option>
											<option value="平面设计师">平面设计师</option>
											<option value="市场传播">市场传播</option>
											<option value="搜图员">搜图员</option>
											<option value="摄影师">摄影师</option>
											<option value="制作人/导演">制作人/导演</option>
											<option value="制作管理">制作管理</option>
											<option value="公共关系">公共关系</option>
											<option value="高层管理">高层管理</option>
											<option value="网站开发员/程序员">网站开发员/程序员</option>
										</select>
									</div>
									
								</div>
								
								<div class="input-group focusWrap">
									<div class="label">电话号码</div>
									<input class="form-control ignore" id="comPhone" name="BusinessPhone" value='${conMap["comPhone"]}' type="text"></input>
								</div>
								
								<div class="input-group focusWrap">
									<div class="label">客户主任</div>
									<input class="form-control"  name="a16" type="text" placeholder="你熟悉的高品伙伴"></input>
								</div>
								<div class="btnBtm">
									<a href="#" class="btnNext" onclick="updateUser()">完成！</a>
								</div>
								<input type="hidden" name="contactsInfo" id="cominfo" />
								<input name="userName" type="hidden" value="${testUser.userName}"/>
						</form>
							
							
						</div><!--contBox-->
					</div><!--stepCont-->

				</div><!--applyContWrap-->
		</div><!--applyWrap-->
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	</div><!--container-->
</div><!--sectionCont-->
<!-- InstanceEndEditable -->
<div id="sectionBtm">
	<div class="container">

        <div class="row">
            <div class="col-lg-12"><a href="javascript:void(0)" class="logo"><img src="images/logoFooter.png"></a></div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <div class="boxContact">
                    <h6 class="hotline">热线：</h6>
                    400-820-0268
                    <br><br>
                    <h6 class="email">服务电邮：</h6>
                    <a href="mailto:service@gaopinimages.com" target="_blank">service@gaopinimages.com</a>
                </div>
                <div class="aboutTitleFooter">关注我们</div>
                <div class="greyBg">
                    <div class="boxMedia">
                        <div class="icon"><img src="images/iconWeChat.gif"></div>
                        <div class="label">官方微信</div>
                    </div>
                    <div class="boxMedia ">
                        <a href="javascript:void(0)" class="icon icon-font icon-16-sina"></a>
                        <div class="label hidden-xs hidden-sm">官方微博</div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="visible-xs visible-sm hidden-md hidden-lg footerMobileLink">
                    <a href="aboutus.html">ABOUT US</a><br>
                    <a href="javascript:;" style="display:none;">搜索技巧</a>
                </div>
            </div>
            <div class="col-md-2 col-md-offset-1">
                <dl>
                    <dt><a href="aboutus.html">ABOUT</a></dt>
                    <dd><a href="aboutus.html"> About Gaopin</a></dd>
                    <dd><a href="news.html"> 高品新闻</a></dd>
                    <dd><a href="careers.html"> 加入我们</a></dd>
                    <dd><a href="terms.html#horizontalTab1"> 网站使用协议</a></dd>
                    <dd><a href="terms.html#horizontalTab2"> 隐私保护政策</a></dd>
                    <dd><a href="terms.html#horizontalTab3"> Cookie政策</a></dd>
                    <dd><a href="terms.html#horizontalTab4"> 授权条款及条件</a></dd>
                </dl>
            </div>
            <div class="col-md-2">
                <dl>
                    <dt><a href="photostock659">创意图片</a></dt>
                    <dd><a href="photostock660">创意RM</a></dd>
                    <dd><a href="photostock662">创意RF</a></dd>
                </dl>
                <dl>
                    <dt><a href="photostock661">编辑图片</a></dt>
                    <dt><a href="imgsets">高品专题</a></dt>
                    <dt style="display:none"><a href="javascript:;">高品视频</a></dt>
                </dl>
            </div>
            <div class="col-md-2">
                <dl>
                    <dt><a href="Contributor/index.na">供稿通道</a></dt>
                    <dd><a href="Contributor/index.na">申请成为供稿人</a></dd>
                    <dd>&nbsp;</dd>
                </dl>
                <dl>
                    <dt style="display:none"><a href="javascript:;">我的账户</a></dt>
                    <dd style="display:none"><a href="javascript:;">个人历史</a></dd>
                    <dd style="display:none"><a href="javascript:;">订购历史</a></dd>
                    <dd><a href="my/lightbox">收藏夹</a></dd>
                </dl>
            </div>
            <div class="col-md-2">
                <dl>
                    <dt>客户服务</dt>
                    <dd><a href="contactus.html">联系我们</a></dd>
                    <dd style="display:none"><a href="javascript:;">搜索技巧</a></dd>
                </dl>
            </div>
        </div>

    </div>
</div><!--sectionBtm-->

<div id="footer">
	<div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 copyright"><div>© 2015 由高品(上海)图像服务有限公司提供。本网站所有影像均由高品(上海)图像服务有限公司授权发布。侵权必究。       沪ICP备09095511号</div></div>
        </div>
    </div>
</div>






			
</body>
<!-- InstanceEnd --></html>
