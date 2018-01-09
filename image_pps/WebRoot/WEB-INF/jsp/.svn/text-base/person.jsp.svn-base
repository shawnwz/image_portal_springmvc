<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/template.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<%@include file="/headerflow.jsp" %>
<script type="text/javascript" src="js/require.js"></script>
<script type="text/javascript" src="js/photographer.js"></script>
 
<!-- 内容区开始 -->
<script type="text/javascript" src="js/person.js"></script>
<link href="flowsearch/css/jquery-ui.css" rel="stylesheet" type="text/css" />
<jsp:include page="./inc/qqheader.jsp" />
<body class="pageFavourite">
<jsp:include page="inc/pagetop_user.jsp"/>
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

	var sex = "${testUser.sex}";
	if(sex == "0")
	{ 
		$("#sexW").iCheck("check");
	}
	else
	{ 
		$("#sexM").iCheck("check");
	}
	
	var isByEmail ="${testUser.isByEmail}";
	if( isByEmail == "0")
	{ 
		$("#isByEmail").iCheck("check");
	} 
	var isTellNew ="${testUser.isTellNew}";
	if(isTellNew == "0")
	{ 
		$("#isTellNew").iCheck("check");
	} 
	var isTellNewProduct ="${testUser.isTellNewProduct}";
	if(isTellNewProduct == "0")
	{ 
		$("#isTellNewProduct").iCheck("check");
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
				e.state == 1 ? alert("修改成功",
				function() {
					location.reload(!0)
				}) : e.state == 0 && alert(e.message)
			});
}

function updatePwd()
{
	 $.post("my/updatemypwd.do", $("#mimaform").serialize(),
			function(e) {
				e.state == 1 ? alert("修改成功",
				function() {
					location.reload(!0)
				}) : alert(e.message)
			}) 
}
function updateFav()
{
	var isByEmail = 1;
	var isTellNew = 1;
	var isTellNewProduct = 1;
	
	if($("#isByEmail").is(":checked"))
	{
		isByEmail=0;
	}
	if($("#isTellNew").is(":checked"))
	{
		isTellNew=0;
	}
	if($("#isTellNewProduct").is(":checked"))
	{
		isTellNewProduct=0;
	}
	
	$.post("my/updateMyInfo.do", {"isByEmail": isByEmail,"isTellNew":isTellNew,"isTellNewProduct":isTellNewProduct},
			function(e) {
				e.state == 1 ? alert("修改成功",
				function() {
					location.reload(!0)
				}) : e.state == 0 && alert(e.message)
			});
}
</script>

<!-- InstanceBeginEditable name="cont" -->
<div class="userCenterWrap">
	<div class="leftNav hidden-xs hidden-sm">
		<ul>
			<li class="active"><a href="my/person" class="iconUser">个人信息</a></li>
			<li><a href="my/lightbox" class="iconFolder">收藏夹</a></li>
			<li><a href="my/myqp" class="iconHistory">下载记录</a></li>
			<li><a href="#" class="iconInvoice">发票</a></li>
			<li><a href="#" class="iconSet">套餐</a></li>
		</ul>
	</div><!--leftNav-->
	
	<div class="midCont midCont2">
		<div class="row">
			<div class="welcomeInfo">Dear ${testUser.userName},欢迎你！你是我们的高品会员，请完善你的基本信息，以便我们更周到地为你服务！</div>
			<div class="col-sm-6 formInfo">
				
				<div class="row">

					<div class="col-md-11">
						<form id ="comForm" role="form" method="post" class="postForm form-lg form-txtLabel">
 							<input type="hidden" name="contactsInfo" id="cominfo" />
							<div class="form-group">
								<div class="input-group focusWrap">
									<div class="label">用户名</div>
									<input id='acc_pInfo_UserName' name='userName' class="form-control" type="text" value="${testUser.userName}"></input>
									<label class="has-error" for="formName" generated="true"></label>
								</div>
								<div class="input-group focusWrap">
									<div class="label">姓名</div>
									<input id='acc_pInfo_lastName' name='lastName'  class="form-control ignore" type="text" value="${testUser.lastName}"></input>
									<label class="has-error" for="formName2" generated="true"></label>
								</div>
								<div class="input-group focusWrap" id="emailAddr">
									<div class="label">邮箱</div>
									<input id='acc_pInfo_Email'	name='email' name="formEmail" class="form-control"  readonly="readonly" type="email" value="${testUser.email}"></input>
									<label class="has-error" for="formEmail" generated="true"></label>
								</div>
								
								<div class="sexCheckbox">
									<div class="label">性别</div>
									<label><input id="sexW" name="sex" type="radio" value="0" class="ignore"/><span class="icon-font icon-44-female"></span></label>
									<label><input id="sexM" name="sex" type="radio" value="1" class="ignore"/><span class="icon-font icon-45-male"></span></label>
								</div>
								
								
								
								<div class="input-group focusWrap ">
									<div class="label">公司名称</div>
									<input class="form-control ignore" id="comName" name="CompanyName"  value='${conMap["comName"]}' type="text"></input>
								</div>
								<div class="input-group officeShort">
									<div class="label">公司地址</div>
									<input class="form-control" id="comAddress" readonly="readonly" type="text" value=""></input>
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
										 
											<input class="form-control ignore" id="comCity" name="City" type='text' value='${conMap["myCity"]}'></input>
										 
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
								
								
								<div class="btnBtm">
									<input class="btnSubmit btn-block btnPurple scrollTop" name="" type="button" value="确认修改" onclick="updateUser()"/>
								</div>
							</div><!--form-group-->
						</form>
					</div>
				</div>
			</div>
			<div class="col-sm-6 formPasswd">
			
				<div class="row">
					<div class="col-md-11 col-md-offset-1">
						<h4><span class="icon-font icon-12-password"></span> 修改密码</h4>
						

						<form role="form" id="mimaform" method="post" class="postForm2 form-lg form-passwd">
							<div class="form-group">
							
								<div class="input-group focusWrap">
									<input id="acc_CurrentPassword" name="CurrentPassword" class="form-control" type="password" placeholder="旧密码"></input>
									<label class="has-error" for="formPassword" generated="true"></label>
								</div>
								<div class="input-group focusWrap">
									<input id="acc_NewPassword" name="NewPassword" class="form-control" type="password" placeholder="新密码"></input>
									<label class="has-error" for="formPassword2" generated="true"></label>
									<div class="icon-font icon-52-eye btnShowPasswd"></div>
								</div>
								<div class="btnBtm">
									<input class="btnSubmit2 btn-block btnPurple SiYuan-ExtraLight" name="" type="submit" value="确认修改" onclick="updatePwd()"/>
								</div>
							</div><!--form-group-->
						</form>
						
						
						
						
						<div class="favSetting">
							<h4><span class="icon-font icon-53-update "></span> 请选择你的需求</h4>
							<label><input id="isByEmail" name="" type="checkbox" value="0"/> 近期网站热点推荐内容</label>
							<label><input id="isTellNew" name="" type="checkbox"value="0"/> 最新优惠活动信息</label>
							<label><input id="isTellNewProduct" name="" type="checkbox"value="0"/> 网站最新动向</label>
							<br/>
							<div class="btnBtm">
								<input class="  btn-block btnPurple" name="" type="submit" value="确认修改" onclick="updateFav()"/>
							</div>
						</div>
						
						
					</div>
				</div><!--row-->
			</div>
		</div>
	</div><!--midCont-->
	
</div><!--userCenterWrap-->
<!-- InstanceEndEditable -->
<!-- 内容区结束-->
<jsp:include page="inc/bottomflow.jsp" />
