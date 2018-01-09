<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript" src="js/require.js"></script>
<script type="text/javascript" src="js/photographer.js"></script>
<script type="text/javascript" src="js/search_left.js"></script>

		<!--[if IE 6]>
			<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a.js"></script>
			<script type="text/javascript">
				DD_belatedPNG.fix('.png-img');
			</script>
		<![endif]-->
		    <script type="text/javascript">
		var FT  = FT || {};
		FT.vars = FT.vars || {};
		FT.vars.BASE_URL    = '';
		FT.vars.FRONT_PATH  = FT.vars.BASE_URL + 'js/';
		FT.vars.JQUERY_PATH = FT.vars.FRONT_PATH + 'jquery-1.8.2.min.js';
		FT.vars.SHORT_ID    = '_collection_detail';
		FT.vars.CURR_UID    = "0";
		FT.vars.CURR_USER   = "";
		require([FT.vars.BASE_URL + 'js/front.js']);
	</script>
<!-- 内容区开始 -->

<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/myqp.css" rel="stylesheet" type="text/css" />
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
</style>

<script>
var p=1;
var ps=50;
var countPage=${pageCount};


function selectPageCode(num){
	$("#items50").addClass("items50");
	$("#items100").addClass("items100");
	$("#items200").addClass("items200");
	$("#items50").removeClass("items50Selected");
	$("#items100").removeClass("items100Selected");
	$("#items200").removeClass("items200Selected");
	$("#items"+num).removeClass("items"+num);
	$("#items"+num).addClass("items"+num+"Selected");
	ps=num;
	bindPage();
}


function key13(e,a){
	if(e&&e.keyCode==13){
		p=$(a).val();
		bindPage();
	}
}

function numberCheck(e){
	if(e.keyCode==8||e.keyCode==13||e.keyCode==116){
		return;
	}
	if(e.keyCode>57||e.keyCode<48){
		e.keyCode=event.keyCode=0;
		e.returnValue=event.returnValue=false;
	}
}
function nextPage(){
	if(p<countPage&&p>=1){
		p++;
		bindPage();
	}
}
function prevPage(){
	if(p>1){
		p--;
		bindPage();
	}
}

function bindPage(){
	$(".p_class").val(p);
	if(p<=countPage&&p>=1){
		sendPageInfo();
	}
}

function sendPageInfo(){
	$.ajax({
		 type: "get",
		 url: "my/myQPPage",
		 data: "p="+p+"&ps="+ps+"&type="+3,
		 success: function(msg){
			 $(".tp_class").html(msg.pageCount);
		     $("#entityCount").html(msg.orderItems.length+"&nbsp;项");
		     $("#ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_indexInfo").html(msg.orderItems.length+"&nbsp;项");
		     var content;
		     countPage=msg.pageCount;
		     for (var i = 0; i < msg.orderItems.length; i++) {
				content+="<tr>";
				//<a href="my/qpdetail/${bean.id}"> ${bean.id}</a>
				content+="<td><a href='my/qpdetail/"+msg.orderItems[i].id+"'>"+msg.orderItems[i].id+"</td>";
				content+="<td>"+getUserDate(msg.orderItems[i].createTime)+"</td>";
				content+="<td>"+msg.orderItems[i].itemCount+"</td>";
				content+="</tr>";
			}
		     $("tbody").html(content);
		 }
	});
}
function getUserDate(date){
	var dt= new Date(date);
	 var year=dt.getFullYear();//获取年
	 return Todate(dt)+"/"+year;
}

	function Todate(num) { //Fri Oct 31 18:00:00 UTC+0800 2008
		num = num + "";
		var date = "";
		var month = new Array();
		month["Jan"] = 1;
		month["Feb"] = 2;
		month["Mar"] = 3;
		month["Apr"] = 4;
		month["May"] = 5;
		month["Jun"] = 6;

		month["Jul"] = 7;
		month["Aug"] = 8;
		month["Sep"] = 9;
		month["Oct"] = 10;
		month["Nov"] = 11;
		month["Dec"] = 12;

		/* var week = new Array();

		week["Mon"] = "一";
		week["Tue"] = "二";
		week["Wed"] = "三";
		week["Thu"] = "四";
		week["Fri"] = "五";
		week["Sat"] = "六";
		week["Sun"] = "日"; */

		str = num.split(" ");

		//date = str[5] + "-";

		date = /* date + */ month[str[1]] + "/" + str[2];

		return date;

	}
</script>



<div id="MainContent">
			
    <div id="accountsMasterContent">
        
        <div id="AccountsRound" class="rc5px clear">
            <div class="Top">
                <div class="Left"><div class="Right"><div class="Center">&nbsp;</div></div></div>
            </div>
        </div>
        <div id="AccountsContent">
            <ul id="accnt-nav">
                <li class="acc_tab">我的帐户</li>
                
                        <li id="ctl00_ctl00_mainContent_navigation_ctl00_tab">
                            <a id="ctl00_ctl00_mainContent_navigation_ctl00_hyperLink" >档案资料</a>
                        </li>
                    
            </ul>

		    <div id="ctl00_ctl00_mainContent_printPageLink" class="Printer">
		        <a  class="PrintButtonRoundedCorners" href="javascript:window.print();">打印此页<span class="top-left"></span><span class="top-right"></span><span class="bottom-left"></span><span class="bottom-right"></span></a>
            </div>
            
            <br class="clr">
            
            
	<div id="orderHistory" style="margin-top:20px;">
		<div class="OrderHistoryContent rounded4"><div style="background-color: rgb(54, 54, 54);"><div style="margin: 0px 1px; height: 1px; overflow: hidden;"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(162, 162, 162);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(206, 206, 206);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div></div></div><div style="margin: 0px; height: 1px; overflow: hidden;"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(206, 206, 206);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div></div><div style="margin: 0px; height: 1px; overflow: hidden; background-color: rgb(162, 162, 162);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div><div style="margin: 0px; height: 1px; overflow: hidden; background-color: rgb(206, 206, 206);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div></div>
			<span id="ctl00_ctl00_mainContent_accountsContent_expirationText" class="ExpirationText"></span>

			

<div>
    
    <div id="headerHistory" style="margin:0px 0px 0px 10px;position:relative;">
        <span id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_indexInfo" class="floatLeft labelOrderHistoryhHeader">${entityCount } 项</span>
       <!-- top page controls --> <div class="menu-pagebox" style="top: auto;right:4px;"><a href="javascript:void(0);" class="page-arrow-left" onclick="javascript:prevPage();"></a><span><span class="tp_class">${pageCount}</span>页之&nbsp;<input class="p_class" type="text" value="1" onkeypress="key13(event,this)"  onkeydown="numberCheck(event)"></span><a href="javascript:void(0);" class="page-arrow-right" onclick="javascript:nextPage();" ></a></div>
        <div id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_headerlist">
            <span class="floatLeft seperaterInSearchHeader"></span>
            <span id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_itemsPerPageList" class="itemsPerPageListHistory floatLeft"><a id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_itemsPerPageList_items25" class="items25" href="javascript:__doPostBack('ctl00$ctl00$mainContent$accountsContent$orderHistoryHeader$itemsPerPageList$items25','')"></a><div style="width:10px;float:left;">
	<img src="images/spacer.gif">
</div><a id="items50" class="items50Selected" href="javascript:selectPageCode(50)"></a><div style="width:10px;float:left;">
	<img src="images/spacer.gif">
</div><a id="items100" class="items100" href="javascript:selectPageCode(100)"></a><div style="width:10px;float:left;">
	<img src="images/spacer.gif">
</div><a id="items200" class="items200" href="javascript:selectPageCode(200)"></a></span>
            <span class="floatLeft seperaterInSearchHeader"></span>

        <!--     <span class="floatLeft">
            


<div class="sortBlock" id="sortBlockId">

	<div class="GlassButton" id="sortOptionTrigger">
		<span class="Right"><span class="Center">
			<a href="javascript:void(0)">
				<span id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_sortBlock_sortOptionText" class="sortOptionText">按授权限期排序</span>
				<div class="arrowMeUp">&nbsp;</div>
			</a>

		</span></span>
	</div>
	
			[if lte IE 7]>
				<div class="IE7OrLess">   
			<![endif]
			<div class="mainShadowContainer" id="sortOptionsMenuDivContainer" style="display: none;">
				<ul class="LanguageMenuBottom mainShadow" onmouseover="ShowSortOptionsDiv();" onmouseout="HideSortOptionsDiv();" id="sortOptionsMenuDiv">
					
			<li class="MenuDiv">
				<a id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_sortBlock_sortOptionList_ctrl0_SelectButton" href="javascript:__doPostBack('ctl00$ctl00$mainContent$accountsContent$orderHistoryHeader$sortBlock$sortOptionList$ctrl0$SelectButton','')">
                    <div class="MenuItem">按订单状态排序</div>
				</a>
			</li>
		
			<li class="MenuDiv">
				<a id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_sortBlock_sortOptionList_ctrl1_SelectButton" href="javascript:__doPostBack('ctl00$ctl00$mainContent$accountsContent$orderHistoryHeader$sortBlock$sortOptionList$ctrl1$SelectButton','')">
                    <div class="MenuItem">按日期排序</div>
				</a>
			</li>
		
			<li class="MenuDiv">
				<div class="MenuItem Selected">按授权限期排序</div>
			</li>
		
			<li class="MenuDiv">
				<a id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_sortBlock_sortOptionList_ctrl3_SelectButton" href="javascript:__doPostBack('ctl00$ctl00$mainContent$accountsContent$orderHistoryHeader$sortBlock$sortOptionList$ctrl3$SelectButton','')">
                    <div class="MenuItem">按项目名称排序</div>
				</a>
			</li>
		
			<li class="MenuDiv">
				<a id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_sortBlock_sortOptionList_ctrl4_SelectButton" href="javascript:__doPostBack('ctl00$ctl00$mainContent$accountsContent$orderHistoryHeader$sortBlock$sortOptionList$ctrl4$SelectButton','')">
                    <div class="MenuItem">按总计排序</div>
				</a>
			</li>
		
				</ul>
				<div class="bottomLeftShadow">&nbsp;</div>
				<div class="topRightShadow">&nbsp;</div>
			</div>
			[if lte IE 7]>
				</div>
			<![endif]
		
</div>

<script language="javascript" type="text/javascript">
	InitOrderHistorySortBlock();
</script>

            </span> -->
            
            
            
        </div>
      
        <div class="clr"> </div>
    </div>
    
</div>


			<div id="orderHistoryContentMain" class="OrderHistoryContentMain">
				<div id="ctl00_ctl00_mainContent_accountsContent_orderHistoryRecords" class="OrderHistoryRecords">

					<table style="width:100%;">
						<thead style="background-color:gray;">
							<tr>
								<td style="padding-left:10px;">编号</td>
								<td style="padding-left:10px;">日期</td>
								<%--<td style="padding-left:10px;">Project name</td>
								--%><td style="padding-left:10px;">图片数量</td>	
							</tr>
						</thead>
						<tbody>
						
						<c:forEach var="bean" items="${orderitem}" >  
							<tr>
								<td><a href="my/qpdetail/${bean.id}"> ${bean.id}</a></td>
								<td><fmt:formatDate value="${bean.createTime}" pattern="M/dd/yyyy"/></td>
							<%--<td>Project <fmt:formatDate value="${bean.createTime}" pattern="M/dd/yyyy"/></td>--%>
								<td>${bean.itemCount}</td>
						  	</tr>
						</c:forEach>  
												
						</tbody>
					</table>
					
					
					
					 <c:if test="${empty orderitem}">
					 	 <div id="ctl00_ctl00_mainContent_accountsContent_orderRecordTitle" class="OrderRecordTitle">
							在现存的资料里找不到订单。
						</div>
					 </c:if>
					

					
				</div>
			</div>

			
<div class="Clr"></div>
<div id="OrderHistorySearchResultsFooter" style="position:relative;">
    <span id="entityCount" class="floatLeft labelInSearchHeader">${entityCount } 项</span>

    <div id="imagePagingFooter">
        
<div id="Pager">
   <!-- bottom page controls --><div class="menu-pagebox" style="top: auto;margin-top: -8px;"><a href="javascript:void(0);" class="page-arrow-left" onclick="javascript:prevPage();"></a>
   	<span><span class="tp_class">${pageCount}</span>页之&nbsp;<input class="p_class" type="text" value="1" onkeypress="key13(event,this)" onkeydown="numberCheck(event)"></span>
   <a href="javascript:void(0);" class="page-arrow-right" onclick="javascript:nextPage();"></a></div>
</div>

    </div>
 </div>


			<div id="ctl00_ctl00_mainContent_accountsContent_orderHistoryBlank" class="OrderHistoryRecords">
				
			</div>

		<div style="background-color: rgb(54, 54, 54);"><div style="margin: 0px; height: 1px; overflow: hidden; background-color: rgb(206, 206, 206);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div><div style="margin: 0px; height: 1px; overflow: hidden; background-color: rgb(162, 162, 162);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div><div style="margin: 0px; height: 1px; overflow: hidden;"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(206, 206, 206);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div></div><div style="margin: 0px 1px; height: 1px; overflow: hidden;"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(162, 162, 162);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(206, 206, 206);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div></div></div></div></div>
	</div>

	

        </div>
        <div id="AccountsRound" class="rc5px clear">
            <div class="Bottom">
                <div class="Left"><div class="Right"><div class="Center">&nbsp;</div></div></div>
            </div>
        </div>
        <div id="sessionTimeout" style="display: none;width: 300px;"><div class="ModalPopupPanelDialog" style="width: 300px;"><div class="ModalTitleBar"><span class="Title"><input src="/Images/iconClose.gif" name="ctl00$ctl00$mainContent$sessionTimeout$ctl04" type="image" class="Close" style="border-width: 0px;" onclick="javascript:HideModal('sessionTimeout');return false;">操作超时</span></div><div class="ModalPopupContent"><div></div><div class="FormButtons">
            您的操作已经超时。给您带来不便，我们谨此致歉。
		    <div id="ctl00_ctl00_mainContent_sessionTimeout_closeSessionTimeout" class="GlassButton btnOrangedbdbdb closeSuccess" onclick="passClickToChild('ctl00_ctl00_mainContent_sessionTimeout_closeSessionTimeout')">
	<span class="Right"><input type="submit" name="ctl00$ctl00$mainContent$sessionTimeout$closeSessionTimeout$GlassButton" value="关闭" id="ctl00_ctl00_mainContent_sessionTimeout_closeSessionTimeout_GlassButton" class="Center"></span>
</div>
	    </div></div></div></div> 
    </div>

		</div>
		
		
		<div class="clear"></div>

  
<!-- 内容区结束-->
<jsp:include page="../inc/pagebuttom.jsp" />
  