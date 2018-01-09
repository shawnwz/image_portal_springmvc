<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>搜索结果</title>
<%@include file="/header.jsp" %>
<script type="text/javascript" src="js/s.js?r=1"></script>
<script type="text/javascript" src="js/jquery.icheck.js"></script><!-- jquery.icheck.js -->
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/search_left.js"></script>
<script type="text/javascript" src="js/lightbox.js"></script>
<script>
$(document).ready(function(){
	$("body").ajaxError(function(event,request, settings){
	     myAlert("有个请求出错了～");
	});
	$("body").ajaxSuccess(function(evt, request, settings){
	   
	 });
	 $("body").ajaxStart(function(){
	  // startLoading();
	 });
	 $("body").ajaxStop(function(){
	   //endLoading();
	 });});
</script>
</head>
		<!--[if IE 6]>
			<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a.js"></script>
			<script type="text/javascript">
				DD_belatedPNG.fix('.png-img');
			</script>
		<![endif]-->
<body onresize="chickbodywidth()" onload="chickbodywidth();selectwidget();">
	<jsp:include page="../inc/top.jsp"/>
    <div class="picture-searchbox">
    	<input id="q" type="text" class="input-text" value="" autocomplete="off"/>
        <a href="javascript:boxshowkeep('h-search')" class="hsearch-text">高级搜索</a>
        <span><b id="searchNum" style="font-weight: normal;"></b><br/>结果关于 
        <span id="searchResultKey" style="width:350px;left:70px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;"></span>
        <b id="simimage"></b> 
        <a href="javascript:boxshow('searchimformationboxlist');" id="clearLink" style="display:none;left: 50px;position: relative;">(澄清)</a></span>
        
        <jsp:include flush="true" page="/searchAdv" />
    </div>
    
    <div class="picture-searchbox-imfor" id="searchimformationbox" style="display:none">
    	<span>澄清词义</span><br /><br />
        	您搜索的字词有多种含义。点击词义(澄清)链接来澄清您的搜索。<br /><br />
        <a href="javascript:hiddenClearTips();">不要再显示此信息</a>
        <img class="searchimforbottom" src="images/searchbox_bottom.gif" />
        <img class="searchimforclose" onclick="boxhidden('searchimformationbox');hiddenClearTips();" src="images/close_button.png" />
    </div>
    
    <div class="picture-searchbox-imfor" id="searchimformationboxlist" style="display:none">
    	<span>请选择</span><br /><br />
    	<div class="searchimformationboxlistdiv">	
    		<input name="cla" value="1" type="checkbox"/><label>关键词1.</label><br/>
    		<input name="cla" value="2" type="checkbox"/><label>关键词1.</label><br/>
    		<input name="cla" value="3" type="checkbox"/><label>关键词1.</label><br/>
    	</div><br/>
		<div id="term_action-content"><a  onclick="boxhidden('searchimformationboxlist')" id="clearword_canel-button" class="button medium secondary" href="javascript:void(0);" style="float: right;margin-left: 10px;"><span></span>取消</a><a id="clearword_ok-button" class="button medium primary disabled" href="javascript:void(0);" onclick="submitclearword();"  style="float: right;margin-left: 10px;"><span></span>更新</a></div>
        <img class="searchimforbottom" src="images/searchbox_bottom.gif" />
        <img class="searchimforclose" onclick="boxhidden('searchimformationboxlist')" src="images/close_button.png" />
    </div>
    <!--  -->
    <div class="picture-searchbox-imfor" id="searchimformationboxkeynote" style="display:none">
    	<span><a href="http://www.corbisimages.com/content/searchtips/">搜索提示</a></span><br />
        	用大写的AND, OR或NOT以获得最佳搜索效果。<br />
        <a href="javascript:hiddenkeynote();">不要再显示此信息</a>
        <img class="searchimforbottom" src="images/searchbox_bottom.gif" />
        <img class="searchimforclose" onclick="boxhidden('searchimformationboxkeynote')" src="images/close_button.png" />
    </div>
    
    <div class="picture-searchbox-imfor" id="searchimformationboxinputhelper" style="display:none">
        <div id="inputkeywordslist">
        
        </div>
        <a href="javascript:hiddeninputhelper();setInputHelper(0);">关闭搜索自动提示</a>
        <img class="searchimforclose" onclick="boxhidden('searchimformationboxinputhelper');" src="images/close_button.png" />
    </div>
    
    
    <!--结果页页头元素  -->
    
        <div class="menu-addstyle" style="" title="显示选项">
        	<img src="images/pic_menu_add.png" onclick="boxshowkeep('addstyle')" />
            <div class="menu-show-addstyle" id="addstyle" style="display:none">
            	<p class="menushow-changecolor-button" style="display:none;"><a href="javascript:changecolor()"><img src="images/menu-style.gif" /></a></p>
            	<p class="menushow-layor" id="menulayor">
                	<a href="javascript:checkbutton('menulayor','a','0');setPullStyle(0);">瀑布流</a>
                	<a href="javascript:checkbutton('menulayor','a','1');setPullStyle(1);"  class="on">平铺</a>
                </p>
            	<p class="menushow-adds-button" id="menuadd">
                	<a href="javascript:void(0);" onclick="return setPageSize(25)&&checkbutton('menuadd','a','0');"><img src="images/sel-page25.gif" /></a>
                    <a href="javascript:void(0);" onclick="return setPageSize(50)&&checkbutton('menuadd','a','1');"><img src="images/sel-page50.gif" /></a>
                    <a href="javascript:void(0);" onclick="return setPageSize(100)&&checkbutton('menuadd','a','2');"><img src="images/sel-page100.gif" /></a>
                    <a href="javascript:void(0);" onclick="return setPageSize(200)&&checkbutton('menuadd','a','3');"><img src="images/sel-page200.gif" /></a>
                </p>
            	<p class="menushow-adds-button" id="menup">
                	<a href="javascript:checkbutton('menup','a','0');" onclick="return setPageType(0);" title="附拣选资料的缩略图 (悬停式显示)"><img src="images/p1.gif" /></a>
                	<a href="javascript:checkbutton('menup','a','1');" onclick="return setPageType(1);" title="附详细资料的缩略图"><img src="images/p2.gif" /></a>
                	<a href="javascript:checkbutton('menup','a','2');" onclick="return setPageType(2);" title="附详细资料及限制规定的缩略图"><img src="images/p3.gif" /></a>
                </p>
            	<div class="menushow-yulan">
                	<span style="position: relative;top: 10px;"><div class="icheckbox_minimal-aero"><input type="checkbox" name="canpreview" value=1 /><ins class="iCheck-helper" ></ins></div></span>
                	<label style="color: #A0A0A0;">预览</label>
                </div>
                <div class="menushow-yulan">
                	<span style="position: relative;top: 10px;"><div class="icheckbox_minimal-aero"><input type="checkbox" name="caninputhelper" value=1 /><ins class="iCheck-helper" ></ins></div></span>
                	<label style="color: #A0A0A0;">搜索自动提示</label>
                </div>
				<div class="menu-show-addstyletop"><img onclick="boxhidden('addstyle')" src="images/pic_menu_add.png" /></div>
            </div>
        </div>
        
        <div class="menu-adc" style="right: 470px;">
        	<div class="select-widget" callback="setSortType();" style="position: absolute;width: 200px;height: 26px;">
                    	<input type="hidden" name="sortType" value="0"/>
                        <input value="排序：按照相关度" readonly="readonly" class="checkany" name="nv_sorttype" style="width: 200px;height: 20px;"/>
                        <img src="images/pic_menu_more.png" style="position: relative;margin-top: -36px;float: right;"/>
                      	<div>
                            <a href="javascript:void(0);" value="0"><p>排序：按照相关度</p></a>
                            <a href="javascript:void(0);" value="1"><p>排序：亚洲内容优先</p></a>
                            <a href="javascript:void(0);" value="2"><p>排序：按拍摄日期</p></a>
                            <a href="javascript:void(0);" value="3"><p>排序：按最新增加</p></a>
                        </div>
            </div>  
        </div>
    <div class="menu-pagebox"><a href="javascript:void(0);" class="page-arrow-left" onclick="javascript:prevPage();"></a><span><span class="tp_class">0</span>页之&nbsp;<input id="p" class="p_class" type="text" value="1"></span><a href="javascript:void(0);" class="page-arrow-right" onclick="javascript:nextPage();"></a></div>
     
   <!--结果页页头元素 结束 -->
    <div class="picbox" id="picbox">
    	
        <%@include file="../inc/search_left.jsp" %>
        
        <div class="groupDetailsContainer">
			    <div class="leftBlock">
			        <div class="storySet"><span id="ctl05_storySetHeaderTitle">图片组</span>
			        <span class="setsid"></span> (<span class="setsCount">18</span> <span >张</span>)
<!-- 		        <a href="javascript:window.location='/Search#p=1&q=%E5%A4%A9%E7%A9%BA%20AND%20%E7%99%BD%E4%BA%91%20NOT%20%E5%A4%AB%E4%BA%BA';" id="ctl05_returnToSearch" class="returnToSearch">回到搜索结果</a> -->	
			        </div>
			        <div class="storySetTitle"><span class="setstitle"></span></div>
			        <div class="idNumber" style="display:none;"><span >ID#</span></div>
			        
			        <div class="date"><span calss="setsdate"></span><span class="setslocation"></span> </div>
			        <div  class="setsphotographorinfos">
			            <div class="creditLabel" style="float:left"><span>摄影师：</span>&nbsp;</div>
			            <div class="creditContent"><span class="setsphotographor"></span></div>
			        </div>
			    </div>
			    <div class="rightBlockOL">
			        <div  class="pullDownButtonStory">
			            <div  class="GlassButton btnOrange363636 mediaSetsButton">
					<span class="Right"><input type="submit" name="ctl05$addalltolightbox$GlassButton" value="全部添加到我的灯箱" onclick="AddGroupToLightbox($(this));return false;"  class="Center"></span>
				</div>
			        </div>
			    </div>
		</div>

        <div id="picbox_center" class="picbox-center">
        
        </div>
        <div class="picbox-page" style="height: 43px;right: 10px;">
        	<div class="menu-pagebox"><a href="javascript:void(0);" class="page-arrow-left" onclick="javascript:prevPage();"></a><span><span class="tp_class">0</span>页之&nbsp;<input id="p2" class="p_class" type="text" value="1"></span><a href="javascript:void(0);" class="page-arrow-right" onclick="javascript:nextPage();"></a></div>
        </div>
    </div>
    
    <jsp:include page="../inc/bottom.jsp" />
    
</body>
</html>
