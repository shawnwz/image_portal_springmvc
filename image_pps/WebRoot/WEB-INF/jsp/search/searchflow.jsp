<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/template.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>搜索结果</title>
    <link href="flowsearch/css/revise.css" rel="stylesheet" type="text/css">
    <%@include file="/headerflow.jsp" %>
    <script type="text/javascript" src="flowsearch/js/searchjerry.js"></script>
    <script type="text/javascript" src="flowsearch/js/groupicon.js"></script>
    <script>
	function showicon(group_id)
	{
		$("."+group_id).hide();
		$("#img-"+group_id).show();
	}

	function hideicon(group_id)
	{
		$("#img-"+group_id).hide();
		$("."+group_id).show();
	}
    </script>
	<script>
		var _hmt = _hmt || [];
		(function() {
  			var hm = document.createElement("script");
 			hm.src = "//hm.baidu.com/hm.js?06d046c45fc354feaec92ccb1e49f895";
  			var s = document.getElementsByTagName("script")[0]; 
  			s.parentNode.insertBefore(hm, s);
		})();
	</script>
<jsp:include page="../inc/qqheader.jsp" />  

<link href="flowsearch/css/winning.css" rel="stylesheet" type="text/css">  
<script type="text/javascript" src="flowsearch/js/winning.js"></script>

</head>
<!-- InstanceBeginEditable name="bodyClass" -->
<body class="pageSearch globalPreview"><!--globalPreview 默认显示预览-->
<!-- InstanceEndEditable -->

<!-- InstanceBeginEditable name="nav" -->
<jsp:include page="../inc/pagetop_user.jsp"/>


<!-- InstanceBeginEditable name="cont" -->

<div class="searchBar">
	<div class="container">
		<div class="searchBarInner col-lg-9 col-md-8 col-xs-12">
			<span class="SiYuan-ExtraLight hidden">搜索高品图像</span>
			<div class="mlt-image"><img src=""><span class="icon-font icon-8-delete"></span></div>
			<input class="searchFiled SiYuan-ExtraLight" name="q" id="q" type="text" placeholder="搜索高品图像"></input>
			<a href="javascript:void(0);" class="btnSearch icon-font icon-13-search"></a>
		</div>
		<div class="hidden-xs hidden-sm selectWrap"   style="display:none;">
			<div class="selectValue SiYuan-ExtraLight">所有图片</div>
			<ul class="selectList SiYuan-ExtraLight" role="menu">
				<li class="active">所有图片</li>
				<li name="cat_id" value="">创意类</li>
				<li name="cat_id" value="">编辑类</li>
			</ul>
		</div>
	    <div class="row searchHint" >
		    <div class="left quicklink">
		        <a href="searchAdv">高级搜索</a>
		    </div>
			<div class="right clearworddiv" style="display:none;">具体的意思可能是 <a class="searchLabel" href="javascript:void(0)">大自然</a><a class="searchLabel" href="javascript:void(0)">大自然</a></div>
	    </div>
	</div>
	
</div><!--searchBar-->


<!--btnWrap-->




<div class="searchWrap">

	<div class="filterPanel">
		<div class="filterInner">
			<a href="javascript:void(0);" class="btnExpand icon-font icon-1-arrowLeft"></a>
			<a href="javascript:void(0);" class="btnClearAll Source-Han-Normal">清除所有选项</a>
			
			
			
			<div class="filterSection">
				<div class="bgGrey">
					<div class="category">
						<!-- 
						<label><input name="rmrf" type="checkbox" value="660,661,666,680" id="checkRM"/>版权管理（RM）</label><br/>
						<label><input name="" type="checkbox" value="" id="checkRM2"/>编辑RM</label>-->
					</div>
					<div class="category">
						<div class="checkGroupWrap">
							<div class="checkTop"><label><input name="cate_idxx" type="checkbox"  value="-1" id="checkCreative"/>创意类</label></div>
							<div class="checkSub"><label><input name="cate_id" type="checkbox"  value="662" id="checkRF"/>免版税 (RF)</label></div>
							<div class="checkSub"><label><input name="cate_id" type="checkbox"  value="660" id="checkRM"/>版权管理 (RM)</label></div>
						</div>
						<!-- -->
						<div class="checkGroupWrap">
						<!-- 661,664,666,669,680,682,683 -->
							<div class="checkTop"><label><input name="cate_id" type="checkbox"  value="-1" id="checkEditor"/>编辑类</label></div>
							<div class="checkSub"><label><input name="cate_id" type="checkbox"  value="691" id="checkCategroy1"/>纪实</label></div>
							<div class="checkSub"><label><input name="cate_id" type="checkbox"  value="666" id="checkCategroy2"/>历史</label></div>
							<div class="checkSub"><label><input name="cate_id" type="checkbox"  value="680" id="checkCategroy3"/>艺术</label></div>
							<div class="checkSub"><label><input name="cate_id" type="checkbox"  value="682" id="checkCategroy4"/>影视档案</label></div>
						</div>
					</div>
					
				</div><!--bgGrey-->
			</div><!--filterSection-->
			
			
			
			<div class="filterSection">
				<div class="header Source-Han-Normal">人物</div>
				<div class="bgGrey">
					<div class="category"> 
						<select name="person_num" class="selectStyle" id="selectAmount">
							<option value="0">不限人数</option>
							<option value="1">无人</option>
							<option value="2">1人</option>
							<option value="3">2人</option>
							<option value="4">3人</option>
							<option value="5,6,7">人群：3人+</option>
						</select>
					</div><!--category-->
					<div class="category offHuman doubleCancle"> 
						<div class="box50">
							<label><input name="sex" type="radio" value="1"  id="checkSexFemale"/>仅男</label>
						</div>
						<div class="box50">
							<label><input name="sex" type="radio" value="2"  id="checkSexMale"/>仅女</label>
						</div>
						<div class="box100">
							<label><input name="sex" type="radio" value="3"  id="checkSexBoth"/>男性和女性</label>
						</div>
					</div><!--category-->
					<div class="category offHuman"> 
						<div class="box50">
							<label><input name="age" type="checkbox" value="1"  id="checkAge1"/>婴儿</label>
						</div>
						<div class="box50">
							<label><input name="age" type="checkbox" value="2"  id="checkAge2"/>孩童</label>
						</div>
						<div class="box50">
							<label><input name="age" type="checkbox" value="3,4"  id="checkAge3"/>少年</label>
						</div>
						<div class="box50">
							<label><input name="age" type="checkbox" value="5"  id="checkAge4"/>青年</label>
						</div>
						<div class="box50">
							<label><input name="age" type="checkbox" value="6"  id="checkAge5"/>中年</label>
						</div>
						<div class="box50">
							<label><input name="age" type="checkbox" value="7,8"  id="checkAge6"/>老人</label>
						</div>
					</div><!--category-->
					
					<div class="category offHuman"> 
						<select name="race" class="selectStyle" id="selectRace">
							<option value="0">多种族</option>
							<option value="5">亚洲人</option>
							<option value="1">白人</option>
							<option value="3">黑人</option>
						</select>
					</div><!--category-->
				</div><!--bgGrey-->
			</div><!--filterSection-->
			
			
			
			
			
			<div class="filterSection">
				<div class="header Source-Han-Normal">图像特点</div>
				<div class="bgGrey">
					
					<div class="category offHuman doubleCancle">
						<div class="category">
							<div class="box50">
								<label><input name="type" type="checkbox" value="2" id="checkPhoto"/>摄影</label>
							</div>
							<div class="box50">
								<label><input name="type" type="checkbox" value="1" id="checkIllustration"/>插画</label>
							</div>
							
						</div><!--category-->
					</div>
					<div class="category doubleCancle">
					
						<div class="subHeader">颜色</div>
						
						<div class="box50">
							<label><input name="color" type="radio" value="10" id="checkGrey"/>黑白</label>
						</div>
						<div class="box50">
							<label><input name="color" type="radio" value="9" id="checkMultiColour"/>彩色</label>
						</div>
						
						<div class="box100">
							<div class="colorPicker">
								<a href="javascript:void(0);" class="colorCurrent colorBox" color="" id="selectCcolor"></a>
								<div class="colorList">
									<a href="javascript:void(0);" class="colorBox color-red" color="red" value=1></a>
									<a href="javascript:void(0);" class="colorBox color-orange" color="orange" value=2></a>
									<a href="javascript:void(0);" class="colorBox color-yellow" color="yellow" value=3></a>
									<a href="javascript:void(0);" class="colorBox color-green" color="green" value=4></a>
									
									<a href="javascript:void(0);" class="colorBox color-cyan" color="cyan" value=5></a>
									<a href="javascript:void(0);" class="colorBox color-blue" color="blue" value=6></a>
									<a href="javascript:void(0);" class="colorBox color-violet" color="violet" value=7></a>
									<a href="javascript:void(0);" class="colorBox color-pink" color="pink" value=8></a>
								</div>
								 <a href="javascript:void(0);" class="colorAdd icon-font icon-23-plus"></a>
							</div>
						</div>
					</div><!--category-->
						
						
					<div class="category layoutWrap selectOne" id="layoutWrap" name="direction" >
						<a href="javascript:void(0);" class="icon-font icon-24-position1" value="3"></a>
						<a href="javascript:void(0);" class="icon-font icon-25-position2" value="1"></a>
						<a href="javascript:void(0);" class="icon-font icon-26-position3" value="2"></a>
						<a href="javascript:void(0);" class="icon-font icon-27-position4" value="4"></a>
						<a href="javascript:void(0);" class="icon-font icon-28-position5" value="5"></a>
					</div>
					
					<div class="category">	
						<label><input name="portrait" type="checkbox" value="1"  id="check20"/>有模特肖像权</label><br/>
						<label><input name="portrait" type="checkbox" value="2"  id="check21"/>有产权使用授权</label>
					</div>
					
				</div><!--bgGrey-->
			</div><!--filterSection-->	
					
			<div class="filterSection" style="display:none;">
				<div class="header Source-Han-Normal">构图</div>
				<div class="bgGrey">
				
				
					<div class="category">					
						<label><input name="style" type="checkbox" value="1"  id="check1"/>户外</label><br/>
						<label><input name="style" type="checkbox" value="2"  id="check2"/>室内</label><br/>
						<label><input name="style" type="checkbox" value="3"  id="check4"/>剪影</label><br/>
						<label><input name="style" type="checkbox" value="4"  id="check3"/>镜头模糊</label><br/>
						<label><input name="style" type="checkbox" value="5"  id="check5"/>影棚拍摄</label>
					</div><!--category-->
						
						
					<div class="category">
						<label><input name="layout" type="checkbox" value="5"  id="check10"/>留白</label><br/>
						<label><input name="layout" type="checkbox" value="6"  id="check11"/>全身</label><br/>
						<label><input name="layout" type="checkbox" value="7"  id="check12"/>头和肩</label><br/>
						<label><input name="layout" type="checkbox" value="1"  id="check6"/>白色背景</label><br/>
						<label><input name="layout" type="checkbox" value="3"  id="check8"/>单色背景</label><br/>
						<label><input name="layout" type="checkbox" value="2"  id="check7"/>部分取景</label><br/>
						<label><input name="layout" type="checkbox" value="4"  id="check9"/>抠图效果</label>
					</div><!--category-->
					
					
					<div class="category">
						<label><input name="angle" type="checkbox" value="6"  id="check18"/>特写</label><br/>
						<label><input name="angle" type="checkbox" value="4"  id="check16"/>航拍</label><br/>
						<label><input name="angle" type="checkbox" value="3"  id="check15"/>俯拍</label><br/>
						<label><input name="angle" type="checkbox" value="7"  id="check19"/>仰拍</label><br/>
						<label><input name="angle" type="checkbox" value="5"  id="check17"/>看镜头</label><br/>
						<label><input name="angle" type="checkbox" value="2"  id="check14"/>不看镜头</label><br/>
						<label><input name="angle" type="checkbox" value="1"  id="check13"/>背面拍摄</label>
					</div><!--category-->
						
				</div><!--bgGrey-->
			</div><!--filterSection-->
			
			<div class="filterSection">
				<div class="bgWhite">
					<div class="subHeader">排除关键词</div>
					<div class="excludeWrap">
						<input name="" type="text" id="exclude"/>
						<a href="javascript:void(0);" class="btnAdd icon-font icon-23-plus"></a>
					</div>

				</div><!--bgWhite-->
			</div><!--filterSection-->
			
		</div>
	</div><!--filterPanel-->
	
	
	<div class="resultPanel">
		<div class="right_hide">
			<span class="icon_group_id"></span><!--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收藏--> <br>
			<span class="icon_group_name"></span><br>
			<span class="icon_group_describe"></span>
		</div>
		<!--only show in mobile-->
		<div class="btnWrap mobileSetting  hidden-lg hidden-md">
			<span class="btnSpan btnMobileExpand">
				<span class="icon-font icon-23-plus"></span>过滤</span>
			</span>
			<span class="btnSpan btn-group"   style="display:none;">
				<button type="button" class="dropdown-toggle" data-toggle="dropdown">所有图片</button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="javascript:void(0);">所有图片</a></li>
					<li><a href="javascript:void(0);">创意类</a></li>
					<li><a href="javascript:void(0);">编辑类</a></li>
				</ul>
			</span>
			<span class="btnSpan">
				<div class="pagination-sm">
					<a href="javascript:void(0);" class="icon-font icon-1-arrowLeft"></a>
					<input name="" type="text" value="1"/>
			 		/ <span class="pageNo"></span>
					<a href="javascript:void(0);" class="icon-font icon-2-arrowRight"></a>
				</div>
			</span>
		</div>
		<div class="resultPanelInner">
		<!--	<div id="winning" >
			    <a href="#">
				    <img src="images/1000.450.jpg" class="double11_img" >
				</a>
				<button type="button" class="close" id="close_win" >&times;</button>
			</div>
		-->			
			<div id="winning" >
			    <div class="winning_content">
				    <img src="images/1000.450.jpg" class="double11_img" onclick="yourmethod()" >				
				    <button type="button" class="close  icon-font icon-cross" id="close_win" ></button>
				</div>
			</div>				
			<div class="searchKeyWord">
				<div class="label" id="label-checkRF"><span class="icon-font icon-8-delete"></span>免版税（RF）</div>
				<div class="label" id="label-checkRM"><span class="icon-font icon-8-delete"></span>版权管理（RM）</div>
				<div class="label" id="label-checkCategroy1"><span class="icon-font icon-8-delete"></span>纪实</div>
				<div class="label" id="label-checkCategroy2"><span class="icon-font icon-8-delete"></span>历史</div>
				<div class="label" id="label-checkCategroy3"><span class="icon-font icon-8-delete"></span>艺术</div>
				<div class="label" id="label-checkCategroy4"><span class="icon-font icon-8-delete"></span>影视档案</div>		
				<div class="label" id="label-checkChina"><span class="icon-font icon-8-delete"></span>仅中国</div>
				<div class="label" id="label-checkAsia"><span class="icon-font icon-8-delete"></span>仅亚洲</div>
				<div class="label" id="label-selectAmount"><span class="icon-font icon-8-delete"></span><span class="txt"></span></div>
				<div class="label" id="label-checkSexBoth"><span class="icon-font icon-8-delete"></span>男性和女性</div>
				<div class="label" id="label-checkSexFemale"><span class="icon-font icon-8-delete"></span>仅男性</div>
				<div class="label" id="label-checkSexMale"><span class="icon-font icon-8-delete"></span>仅女性</div>
				<div class="label" id="label-checkAge1"><span class="icon-font icon-8-delete"></span>婴儿</div>
				<div class="label" id="label-checkAge2"><span class="icon-font icon-8-delete"></span>孩童</div>
				<div class="label" id="label-checkAge3"><span class="icon-font icon-8-delete"></span>少年</div>
				<div class="label" id="label-checkAge4"><span class="icon-font icon-8-delete"></span>青年</div>
				<div class="label" id="label-checkAge5"><span class="icon-font icon-8-delete"></span>中年</div>
				<div class="label" id="label-checkAge6"><span class="icon-font icon-8-delete"></span>老人</div>
				<div class="label" id="label-selectRace"><span class="icon-font icon-8-delete"></span><span class="txt"></span></div>
				<div class="label" id="label-checkPhoto"><span class="icon-font icon-8-delete"></span>仅摄影</div>
				<div class="label" id="label-checkIllustration"><span class="icon-font icon-8-delete"></span>仅插画</div>
				<div class="label" id="label-checkGrey"><span class="icon-font icon-8-delete"></span>黑白</div>
				<div class="label" id="label-checkMultiColour"><span class="icon-font icon-8-delete"></span>彩色</div>
				<div class="label" id="label-selectCcolor"><span class="icon-font icon-8-delete"></span><span class="color"></span></div>
				<div class="label" id="label-layoutWrap"><span class="icon-font icon-8-delete"></span><span class="txt"></span></div>
				<div class="label" id="label-check20"><span class="icon-font icon-8-delete"></span>有模特肖像权</div>
				<div class="label" id="label-check21"><span class="icon-font icon-8-delete"></span>有产权使用授权</div>
				
				<div class="label" id="label-checkDay"><span class="icon-font icon-8-delete"></span>白天</div>
				<div class="label" id="label-checkNight"><span class="icon-font icon-8-delete"></span>晚上</div>
				

				
				
				<div class="label" id="label-check1"><span class="icon-font icon-8-delete"></span>户外</div>
				<div class="label" id="label-check2"><span class="icon-font icon-8-delete"></span>室内</div>
				<div class="label" id="label-check4"><span class="icon-font icon-8-delete"></span>剪影</div>
				<div class="label" id="label-check3"><span class="icon-font icon-8-delete"></span>镜头模糊</div>
				<div class="label" id="label-check5"><span class="icon-font icon-8-delete"></span>影棚拍摄</div>
				

				<div class="label" id="label-check6"><span class="icon-font icon-8-delete"></span>白色背景</div>
				<div class="label" id="label-check7"><span class="icon-font icon-8-delete"></span>部分取景</div>
				<div class="label" id="label-check8"><span class="icon-font icon-8-delete"></span>单色背景</div>
				<div class="label" id="label-check9"><span class="icon-font icon-8-delete"></span>抠图效果</div>
				<div class="label" id="label-check10"><span class="icon-font icon-8-delete"></span>留白</div>
				<div class="label" id="label-check11"><span class="icon-font icon-8-delete"></span>全身</div>
				<div class="label" id="label-check12"><span class="icon-font icon-8-delete"></span>头和肩</div>
				
				
				<div class="label" id="label-check13"><span class="icon-font icon-8-delete"></span>背面拍摄</div>
				<div class="label" id="label-check14"><span class="icon-font icon-8-delete"></span>不看镜头</div>
				<div class="label" id="label-check15"><span class="icon-font icon-8-delete"></span>俯拍</div>
				<div class="label" id="label-check16"><span class="icon-font icon-8-delete"></span>航拍</div>
				<div class="label" id="label-check17"><span class="icon-font icon-8-delete"></span>看镜头</div>
				<div class="label" id="label-check18"><span class="icon-font icon-8-delete"></span>特写</div>
				<div class="label" id="label-check19"><span class="icon-font icon-8-delete"></span>仰拍</div>


                <div class="label label-collection" id="label-collection669"><span class="icon-font icon-8-delete"></span>Amana</div>
				<div class="label label-collection" id="label-collection673"><span class="icon-font icon-8-delete"></span>GoldenPond</div>
				<div class="label label-collection" id="label-collection679"><span class="icon-font icon-8-delete"></span>Popcorn Original</div>
				<div class="label label-collection" id="label-collection692"><span class="icon-font icon-8-delete"></span>Blend</div>
				<div class="label label-collection" id="label-collection695"><span class="icon-font icon-8-delete"></span>Hero</div>
				<div class="label label-collection" id="label-collection698"><span class="icon-font icon-8-delete"></span>AWL</div>
				<div class="label label-collection" id="label-collection701"><span class="icon-font icon-8-delete"></span>Stockfood</div>
				<div class="label label-collection" id="label-collection704"><span class="icon-font icon-8-delete"></span>Aurora</div>
				<div class="label label-collection" id="label-collection708"><span class="icon-font icon-8-delete"></span>imagenavi</div>
				<div class="label label-collection" id="label-collection710"><span class="icon-font icon-8-delete"></span>Viewstock</div>
				<div class="label label-collection" id="label-collection712"><span class="icon-font icon-8-delete"></span>Bestview</div>
				<div class="label label-collection" id="label-collection714"><span class="icon-font icon-8-delete"></span>robertharding</div>
				<div class="label label-collection" id="label-collection718"><span class="icon-font icon-8-delete"></span>Westend61</div>
				<div class="label label-collection" id="label-collection721"><span class="icon-font icon-8-delete"></span>500PX</div>
				<div class="label label-collection" id="label-collection724"><span class="icon-font icon-8-delete"></span>Smart微图</div>
				<div class="label label-collection" id="label-collection728"><span class="icon-font icon-8-delete"></span>TongRo</div>
				<div class="label label-collection" id="label-collection731"><span class="icon-font icon-8-delete"></span>Kobal</div>
				<div class="label label-collection" id="label-collection733"><span class="icon-font icon-8-delete"></span>TheArtArchive</div>
				<div class="label label-collection" id="label-collection735"><span class="icon-font icon-8-delete"></span>SciencePhoto</div>
				<div class="label label-collection" id="label-collection740"><span class="icon-font icon-8-delete"></span>BetterLiving</div>
				<div class="label label-collection" id="label-collection743"><span class="icon-font icon-8-delete"></span>Foodcollection</div>
				<div class="label label-collection" id="label-collection744"><span class="icon-font icon-8-delete"></span>seasons</div>
				<div class="label label-collection" id="label-collection761"><span class="icon-font icon-8-delete"></span>Moofe</div>
				<div class="label label-collection" id="label-collection752"><span class="icon-font icon-8-delete"></span>Ikonimages</div>
				<div class="label label-collection" id="label-collection758"><span class="icon-font icon-8-delete"></span>Juice</div>
				<div class="label label-collection" id="label-collection764"><span class="icon-font icon-8-delete"></span>Tetra</div>
				<div class="label label-collection" id="label-collection767"><span class="icon-font icon-8-delete"></span>WBM</div>
				<div class="label label-collection" id="label-collection778"><span class="icon-font icon-8-delete"></span>Comealive</div>
				<div class="label label-collection" id="label-collection775"><span class="icon-font icon-8-delete"></span>Glasshouse</div>
				<div class="label label-collection" id="label-collection773"><span class="icon-font icon-8-delete"></span>JTVintage</div>
				<div class="label label-collection" id="label-collection782"><span class="icon-font icon-8-delete"></span>UIG</div>
				<div class="label label-collection" id="label-collection789"><span class="icon-font icon-8-delete"></span>Flowerphotos</div>
				<div class="label label-collection" id="label-collection787"><span class="icon-font icon-8-delete"></span>Eye Ubiquitous</div>
				<div class="label label-collection" id="label-collection791"><span class="icon-font icon-8-delete"></span>Trio</div>
				<div class="label label-collection" id="label-collection793"><span class="icon-font icon-8-delete"></span>Minden Pictures</div>
				<div class="label label-collection" id="label-collection797"><span class="icon-font icon-8-delete"></span>CAIA</div>
				<div class="label label-collection" id="label-collection749"><span class="icon-font icon-8-delete"></span>Folio</div>
				<div class="label label-collection" id="label-collection799"><span class="icon-font icon-8-delete"></span>Hemis</div>
				<div class="label label-collection" id="label-collection801"><span class="icon-font icon-8-delete"></span>Everett</div>
				<div class="label label-collection" id="label-collection803"><span class="icon-font icon-8-delete"></span>akgimages</div>
				<div class="label label-collection" id="label-collection805"><span class="icon-font icon-8-delete"></span>cavan</div>
				<div class="label label-collection" id="label-collection807"><span class="icon-font icon-8-delete"></span>Mint</div>
				<div class="label label-collection" id="label-collection810"><span class="icon-font icon-8-delete"></span>CGI</div>
				<div class="label label-collection" id="label-collection812"><span class="icon-font icon-8-delete"></span>Nature Picture Library</div>
				

			</div><!--searchKeyWord-->
			<div class="searchToolBar hidden-sm hidden-xs">
				
				<div class="col-lg-3 col-md-4 col-sm-3 msg">
					<span class="Source-Han-Light" style="display:none;">你搜索的</span>
					<span class="Source-Han-Normal" style="display:none;"></span>
					<span class="Source-Han-Light" style="display:none;">有</span>
					<span class="Source-Han-Normal">0</span>
					<span class="Source-Han-Light">结果</span>
				</div>
				<div class="col-lg-9 col-md-8 col-sm-9">
					<div class="right">
					
						
						<select name="sortType" class="selectStyle sortType">
							<option value="0">排序：按照相关度</option>
							<option value="1">排序：亚洲内容优先</option>
							<option value="2">排序：按拍摄日期</option>
							<option value="3">排序：按最新增加</option>
						</select>
						<div class="dropDownWrap">
							<div class="icon-font icon-14-setting dropDownBtn"></div>
							<div class="dropDownPanel">
								<div class="toggleWrap">
									<span class="Source-Han-Light">预览</span><a class="btnToggle togglePreview active"></a>
								</div>
								<div class="toggleWrap">
									<span class="Source-Han-Light">详细</span><a class="btnToggle toggleDetail"></a>
								</div>
								<div class="picLayoutWrap">
									<a href="javascript:void(0);" class="active icon-font icon-32-layout1"></a>
									<a href="javascript:void(0);" class="icon-font icon-33-layout2"></a>
									<a href="javascript:void(0);" class="icon-font icon-34-layout3"></a>
								</div>
								<div class="picNumberWrap">
									<a href="javascript:void(0);" class="active">25</a>
									<a href="javascript:void(0);">50</a>
									<a href="javascript:void(0);">100</a>
								</div>
							</div>
						</div>
						
						<div class="pagination-sm">
							<a href="javascript:void(0);" class="icon-font icon-1-arrowLeft"></a>
							<input name="" type="text" value="1"/>
							 / <span class="pageNo"></span>
							<a href="javascript:void(0);" class="icon-font icon-2-arrowRight"></a>
						</div>
					</div>
				</div><!--col-lg-10-->
			</div><!--searchToolBar-->
			<div class="galleryWrap">
			
				
			</div><!--galleryWrap-->
			<a href="gallery2.html" id="loadMore"></a>
			
			
			<div class="searchResultFooter" style="display: block;">
				
				<div class="pageNumWrap">
					<a href="javascript:void(0)" class="btnPrev icon-font icon-1-arrowLeft"></a>
					<input name="" type="text" class="targetNum" value="1">
					<a href="javascript:void(0)" class="btnNext">
						<span class="left">/  0 </span>
						<span class="right SiYuan-ExtraLight">下一页</span>
					</a>
				</div>
			</div>
			
			
			
			<!-- searchNoResult start -->
			<div class="searchNoResult" style="display:none;">
				
				<div class="noResultImg">
					<img src="images/searchNoResult.jpg">
					<br>
					<a href="http://www.gaopinimages.com/imagesflow/133100644259#rids=,133100644259)">133100644259</a> © KidStock/Blend/Gaopinimages
				</div>
				
				<div class="header Source-Han-Light">呃~~抱歉，未找到你搜索的图片，<br>你可以试试：其他关键词、减少关键词、减少筛选条件。</div>
				<div class="header Source-Han-Light">或者联系我们</div>
				<br>
				<p>
					中国客服热线: 400.820.0268<br>
					北京: +86.10.6500.8152<br>
					上海: +86.21.5407.5711<br>
					广州: +86.20.3847.3900<br><br>
				
					</p>
<!-- 					<div class="header">您也可以：</div> -->
<!-- 					试试其他关键词；<br> -->
<!-- 					减少关键词；<br> -->
<!-- 					减少筛选条件。 -->
			</div>
				
			<!-- searchNoResult end -->
				
		</div><!--resultPanelInner-->
	</div><!--resultPanel-->

</div><!--searchWrap-->





 <jsp:include page="../inc/bottomflow.jsp" />
</body>
</html>