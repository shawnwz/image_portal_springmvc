<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader.jsp" /> 
<script type="text/javascript" src="js/photographer.js"></script>
<script type="text/javascript" src="js/search_left.js"></script>
<script type="text/javascript" src="js/lightbox.js"></script>
<script type="text/javascript" src="js/jquery.jqprint.js"></script>
		<!--[if IE 6]>
			<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a.js"></script>
			<script type="text/javascript">
				DD_belatedPNG.fix('.png-img');
			</script>
		<![endif]-->
	<script>
$(document).ready(function(){
	$("body").ajaxError(function(event,request, settings){
	     myAlert("有个请求出错了～");
	});
	$("body").ajaxSuccess(function(evt, request, settings){
	   
	 });
	 $("body").ajaxStart(function(){
	   startLoading();
	 });
	 $("body").ajaxStop(function(){
	   endLoading();
	 });
	myrefreshlightbox(true);
	 $(".hidendiv").hide();
	 $("#print-action").click(function(){
			var item =$("#picbox_center").clone();
			item.find(".picbox-page").remove();
			item.css("padding-left","0px").jqprint(); 
		});
	 });
	 //qp小样图下载
function DownloadImage(elesid)
{
	location.href = "dl/getImg.do?type=0&corbisId="+elesid;
}
//特殊小样图下载, 对应订阅计划
//跟qp显示时二选一
//下在时需要计数. 
function DownloadImageSepc(elesid)
{
	//elesid=eles.id的 
	location.href = "dl/getImg.do?type=3&corbisId="+elesid;
}

</script>

<!-- 内容区开始 -->
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/corbisStyle.css" rel="stylesheet" type="text/css" />
<style>
#headerHistory .items50
{
	background-position: 0 0;
}

#headerHistory .items100
{
	background-position: -15px 0;
}

#headerHistory .items200
{
	background-position: -30px 0;
}

#headerHistory .items50Selected
{
	background-position: 0 -16px;
}

#headerHistory .items100Selected
{
	background-position: -15px -16px;
}

#headerHistory .items200Selected
{
	background-position: -30px -16px;
}
.items50,.items100,.items200,.items50Selected,.items100Selected,.items200Selected{
	background:url(images/imagesPerPage.gif);
	background-repeat:no-repeat;
	float:left;
	height:16px;
	width:15px
}
tbody td{
 padding-left: 10px;
}
.layout_detail_hover-pannel{
	float: left;
margin-left: 6px;
width: 20px;
height: 21px;
background: url("images/corbis-sprite.png") no-repeat scroll 0 0 transparent;
cursor: pointer;
}

.layout_detail_inline-pannel{
	float: left;
	margin-left: 6px;
	width: 20px;
	height: 21px;
	background: url("images/corbis-sprite.png") no-repeat scroll 0 0 transparent;
	cursor: pointer;
}

.layout_detail_full-pannel{
	float: left;
	margin-left: 6px;
	width: 20px;
	height: 21px;
	background: url("images/corbis-sprite.png") no-repeat scroll 0 0 transparent;
	cursor: pointer;
}


</style>

    <div class="picbox" id="picbox">  
        <div class="piclist" id="pic_left">
        	<div id="piclist0">
                <p class="piclist-listtop" onclick="mySelectRootBox();" style="cursor: pointer;">我的灯箱</p>
                <p class="piclist-bigtitle" style="display:none;">                	
                	<select class="select-box">
                    	<option value="0" selected="selected">按时间排序</option>
                    	<option value="1">按名字排序</option>
                    </select>
				</p>         
                <div class="MyLightboxes-left" id="picline0">
					
                </div>
			</div>
        </div>
        
        <div class="MyLightboxes-title">
        	<p class="MyLightboxes-titletop">
        		<a href="javascript:void(0);" onclick="myAddNewLightBox(curLightBoxid);">创建新灯箱</a><a href="javascript:void(0);" onclick="myMoveLightBox()">移动至</a>
                <span><a href="javascript:myCopyOrMove()">复制/移动图片</a><a href="javascript:void(0);" id="print-action">打印</a><a href="javascript:sendEmail()">电子邮件</a><a href="javascript:shiftImg()">转移</a></span>
            </p>
            <div class="MyLightboxes-name">
            	<p><b id="boxName">我的灯箱</b> <a id="btn_boxName" href="javascript:updateBoxNmae(this)">修改</a> <a id="btn_boxName" href="javascript:DownloadAllinBox()">下载全部</a></p>
                详细资料 <a id="change1" href="javascript:setBoxInfo();cancelInfo();show_or_hidden('MyLightboxes-center')" onclick="change_text(this,'显示','隐藏')">显示</a> • <a href="javascript:setBoxInfo()">修改</a>
                <select class="select-box" style="display:none;"><option>按照添加顺序排列</option><option>按照添加倒序排列</option></select>
            </div>
            <div class="MyLightboxes-center" id="MyLightboxes-center" style="display:none;">
            	<p><span>客户</span><input type="text" id="customer" class="de" value="名称" readonly="readonly" /></p>
            	<p style="height:130px;"><span>备注</span><textarea id="memo" readonly="readonly" class="de">内容</textarea>
            	<span class="buttonSpan" style="position:absolute;margin-top: 10px;left: 70px;display:none;">
	            	<input type="button"  value="保存" style="width:60px;" onclick="saveInfo()"></input>
	        		<input type="button"  value="取消" style="width:60px;" onclick="cancelInfo()"></input>
        		</span>
            	</p>
                <div class="MyLightboxes-right-box" style="height: 140px;">
                	<p>
                    	修改: <span id="updateTime">2014/1/13</span><br />
						新建: <span id="createTime">2014/1/11</span>
                    </p>
                    <p class="topdotted">
                    	主人: <span >${sendEmailer}</span>
                    </p>
                    
                </div>
            </div>
        </div>  
           <div class="picbox-page" style="    width: 81.5%;    left: 17.8%;">
            	
           <!-- start corbis header-->
          

<div id="header2" style="width: 79%;
margin-right: 40px;">
        <div id="ctl00_mainContent_searchResultHeader_header2Div">
            
            <div id="ctl00_mainContent_searchResultHeader_headerlist">
                <span class="floatLeft seperaterInSearchHeader r2"></span>
                <span id="ctl00_mainContent_searchResultHeader_itemsPerPageList" class="itemsPerPageList floatLeft">
      <a id="Pageitems25" class="aspNetDisabled items25Selected" href="javascript:selectPageCode(25)"></a><div style="width:10px;float:left;">
	<img src="images/spacer.gif">
</div><a id="Pageitems50" class="items50" href="javascript:selectPageCode(50)"></a><div style="width:10px;float:left;">
	<img src="images/spacer.gif">
</div><a id="Pageitems100" class="items100" href="javascript:selectPageCode(100)"></a><div style="width:10px;float:left;">
	<img src="images/spacer.gif">
</div><a id="Pageitems200" class="items200" href="javascript:selectPageCode(200)"></a></span>
                <span class="floatLeft seperaterInSearchHeader r1"></span>
				<div id="search_page_layout-panel" style="display:none;">
						<div id="layout_detail_hover-pannel" class="icon" title="附拣选资料的缩略图 (悬停式显示)"></div>
						<div id="layout_detail_inline-pannel" class="icon" title="附详细资料的缩略图">
						</div>
						<div id="layout_detail_full-pannel" class="icon" title="附详细资料及限制规定的缩略图">
						</div> 
				</div>
                <span class="floatLeft seperaterInSearchHeader r4"></span>
				
               </div>
                 <div class="floatLeft labelInSearchHeader" style="display:none;">
                    <div id="ctl00_mainContent_searchResultHeader_previewCheckbox" class="imageCheckbox">
	<div class="checkedImage" onclick=""></div><span class="ImageCheckbox">
	
</div>
                    <span id="ctl00_mainContent_searchResultHeader_previewLabel" class="previewLabel">图片预览功能</span>
                </div>
                
            </div>
        <div class="clr">
        </div>
    </div>



            <!-- end corbis header-->
           <div class="menu-pagebox" style="margin-right: 1px;"><a class="page-arrow-left"></a><span id="yezhi">1页之&nbsp;<input id="pageye" type="text" value="01" /></span><a  class="page-arrow-right"></a></div>
            </div>
            
            
            
        <div id="picbox_center" class="picbox-center" style="min-height:500px;">
            
            <div class="picbox-page">
            	<div class="menu-pagebox"><a  class="page-arrow-left"></a><span>1页之&nbsp;<input type="text" value="01" /></span><a  class="page-arrow-right"></a></div>
            </div>
        </div>
        
    </div>
 <div class="hidendiv">
<div class="sendEmail">
<div>
	<p style="word-break:break-word;width:450px;">
	您可以把您的灯箱发送致一个或多个电邮地址。请用分号(;)分隔邮箱地址。 收件人将会收到您的信息，以及一个点击后可在线链接灯箱的 URL。
	</p>
	<form id="sendform">
	<table>
	<tr>
		<td style=" padding-right: 6px;	">由
		</td>
		<td>
			${sendEmailer}
		</td>
	</tr>
	<tr>
		<td>致
		</td>
		<td>
			<input type="text" id="accepter" name="accepter"  style="width:200px;"/>
		</td>
	</tr>
	<tr>
		<td style=" padding-right: 6px;	">主题
		</td>
		<td>
			<input type="text" class="titleemail" name="title" style="width:200px;"/>
		</td>
	</tr>
	<tr>
		<td>链接
		</td>
		<td>
		<span  id="url" class="url" style="width:300px;border:0px;display:block;"></span> 
		</td>
	</tr>
	<tr>
		<td>附言
		</td>
		<td>
			<textarea id="msg" name="msg" style="width:200px;height:80px;overflow-y: auto;overflow-x: hidden;"></textarea>
		</td>
	</tr>
	</table>
	</form>
</div>
</div>
  </div>
  
  <div class="zhuanyi" style="display: none;">
  	<div >
  		<p style="padding:12px;padding:12px;width: 540px;">
  			把所有权移交给另一 Gaopin 会员其它会员将会收到复制灯箱。在不影响您的灯箱图片的情况下，他们可以随意改动有关图片。
  		</p>
  		<div style="height:43px;padding:10px;">添加一个 Gaopin 会员
  			<input type="text" class="addUser" style="width:182px;"/>
  			<input type="button" class="btn_add" style="margin-left:10px;" onclick="checkAddUser()" value="添加到"/>
  		</div>
  		<div style="float: left;height: 177px;width: 260px;">Gaopin 会员
	  		<select class="selectUser" style="margin-top: 2px;padding: 2px;width: 260px;overflow-y: hidden;"  size="8">
	  		</select>
  		</div>
  		
  		<div style="float: left;padding-top: 25px;padding-top: 35px;margin-left:10px;margin-right:10px;">
  			<span class="ui-icon ui-icon-arrow-1-e" onclick="toRight()"></span>
  			<span class="ui-icon ui-icon-arrow-1-w" onclick="toLeft()"></span>
  		</div>
  		<div style="float: left;height: 177px;width: 260px;position:relative;">转移至...
  			<select class="showselect" style="margin-top: 2px;padding: 2px;width: 260px;overflow-y: hidden;"  size="8">
	  		</select>
  			<p class="hint" style="width: 240px;position: absolute;left: 2px;top: 30px;x">要转移这个灯箱，您需要从您的 Gaopin 会员列表中选择一位会员，或者添加一位新的 Gaopin 会员。</p>
  		</div>
  	</div>
  </div>
<!-- 内容区结束-->
<jsp:include page="../inc/pagebuttom.jsp" />
  