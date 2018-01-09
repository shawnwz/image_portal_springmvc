<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader.jsp" /> 
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
                            <a id="ctl00_ctl00_mainContent_navigation_ctl00_hyperLink" href="https://secure.corbisimages.com/my-account/profile">档案资料</a>
                        </li>
                    
            </ul>

		    <div id="ctl00_ctl00_mainContent_printPageLink" class="Printer">
		        <a onclick="PrintWindow();" class="PrintButtonRoundedCorners">打印此页<span class="top-left"></span><span class="top-right"></span><span class="bottom-left"></span><span class="bottom-right"></span></a>
            </div>
            
            <br class="clr">
            
            
	<div id="orderHistory">
		<div class="OrderHistoryContent rounded4"><div style="background-color: rgb(54, 54, 54);"><div style="margin: 0px 1px; height: 1px; overflow: hidden;"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(162, 162, 162);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(206, 206, 206);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div></div></div><div style="margin: 0px; height: 1px; overflow: hidden;"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(206, 206, 206);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div></div><div style="margin: 0px; height: 1px; overflow: hidden; background-color: rgb(162, 162, 162);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div><div style="margin: 0px; height: 1px; overflow: hidden; background-color: rgb(206, 206, 206);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div></div>
			<span id="ctl00_ctl00_mainContent_accountsContent_expirationText" class="ExpirationText"></span>

			

<div>
    
    <div id="headerHistory" style="margin:0px 0px 0px 10px;">
        <span id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_indexInfo" class="floatLeft labelOrderHistoryhHeader">0 项</span>
        <div id="imagePaging" class="imagePaging">
            
<div id="Pager">
    <input type="button" name="ctl00$ctl00$mainContent$accountsContent$orderHistoryHeader$searchResultPager$previous" value="" id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_searchResultPager_previous" disabled="disabled" class="aspNetDisabled PrevButtonDisabled">
    <span id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_searchResultPager_prefixText" class="PagerLabelPreFix">1  页 之</span>
	<input name="ctl00$ctl00$mainContent$accountsContent$orderHistoryHeader$searchResultPager$pageNumber" type="text" value="1" maxlength="1" id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_searchResultPager_pageNumber" class="NavPageNumber" onkeypress="return CorbisUI.Pager.keyCheck(event, this);" onchange="CorbisUI.Pager.pageNumberChanged(this);">
    <span id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_searchResultPager_postfixText" class="PagerLabelPostFix"></span>
    <input type="button" name="ctl00$ctl00$mainContent$accountsContent$orderHistoryHeader$searchResultPager$next" value="" id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_searchResultPager_next" disabled="disabled" class="aspNetDisabled NextButtonDisabled">
    <input name="ctl00$ctl00$mainContent$accountsContent$orderHistoryHeader$searchResultPager$totalItems" type="hidden" id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_searchResultPager_totalItems" class="totalItems" value="0">
    <input name="ctl00$ctl00$mainContent$accountsContent$orderHistoryHeader$searchResultPager$pageSize" type="hidden" id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_searchResultPager_pageSize" class="pageSize" value="50">
    <input name="ctl00$ctl00$mainContent$accountsContent$orderHistoryHeader$searchResultPager$origPageNumber" type="hidden" id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_searchResultPager_origPageNumber" class="origPageNumber" value="1">
</div>

        </div>
        <div id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_headerlist">
            <span class="floatLeft seperaterInSearchHeader"></span>
            <span id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_itemsPerPageList" class="itemsPerPageListHistory floatLeft"><a id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_itemsPerPageList_items25" class="items25" href="javascript:__doPostBack('ctl00$ctl00$mainContent$accountsContent$orderHistoryHeader$itemsPerPageList$items25','')"></a><div style="width:10px;float:left;">
	<img src="../Images/spacer.gif">
</div><a id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_itemsPerPageList_items50" class="aspNetDisabled items50Selected"></a><div style="width:10px;float:left;">
	<img src="../Images/spacer.gif">
</div><a id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_itemsPerPageList_items100" class="items100" href="javascript:__doPostBack('ctl00$ctl00$mainContent$accountsContent$orderHistoryHeader$itemsPerPageList$items100','')"></a><div style="width:10px;float:left;">
	<img src="../Images/spacer.gif">
</div><a id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_itemsPerPageList_items200" class="items200" href="javascript:__doPostBack('ctl00$ctl00$mainContent$accountsContent$orderHistoryHeader$itemsPerPageList$items200','')"></a></span>
            <span class="floatLeft seperaterInSearchHeader"></span>

            <span class="floatLeft">
            


<div class="sortBlock" id="sortBlockId">

	<div class="GlassButton" id="sortOptionTrigger">
		<span class="Right"><span class="Center">
			<a href="javascript:void(0)">
				<span id="ctl00_ctl00_mainContent_accountsContent_orderHistoryHeader_sortBlock_sortOptionText" class="sortOptionText">按授权限期排序</span>
				<div class="arrowMeUp">&nbsp;</div>
			</a>

		</span></span>
	</div>
	
			<!--[if lte IE 7]>
				<div class="IE7OrLess">   
			<![endif]-->
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
			<!--[if lte IE 7]>
				</div>
			<![endif]-->
		
</div>

<script language="javascript" type="text/javascript">
	InitOrderHistorySortBlock();
</script>

            </span>
        </div>
      
        <div class="clr"> </div>
    </div>
    
</div>


			<div id="orderHistoryContentMain" class="OrderHistoryContentMain">
				<div id="ctl00_ctl00_mainContent_accountsContent_orderHistoryRecords" class="OrderHistoryRecords">
					<div id="ctl00_ctl00_mainContent_accountsContent_orderRecordTitle" class="OrderRecordTitle">
						在现存的资料里找不到订单。
					</div>

					
				</div>
			</div>

			
<div class="Clr"></div>
<div id="OrderHistorySearchResultsFooter">
    <span id="ctl00_ctl00_mainContent_accountsContent_orderHistoryFooter_indexInfo" class="floatLeft labelInSearchHeader">0 项</span>

    <div id="imagePagingFooter">
        
<div id="Pager">
    <input type="button" name="ctl00$ctl00$mainContent$accountsContent$orderHistoryFooter$searchResultPager$previous" value="" id="ctl00_ctl00_mainContent_accountsContent_orderHistoryFooter_searchResultPager_previous" disabled="disabled" class="aspNetDisabled PrevButtonDisabled">
    <span id="ctl00_ctl00_mainContent_accountsContent_orderHistoryFooter_searchResultPager_prefixText" class="PagerLabelPreFix">1  页 之</span>
	<input name="ctl00$ctl00$mainContent$accountsContent$orderHistoryFooter$searchResultPager$pageNumber" type="text" value="1" maxlength="1" id="ctl00_ctl00_mainContent_accountsContent_orderHistoryFooter_searchResultPager_pageNumber" class="NavPageNumber" onkeypress="return CorbisUI.Pager.keyCheck(event, this);" onchange="CorbisUI.Pager.pageNumberChanged(this);">
    <span id="ctl00_ctl00_mainContent_accountsContent_orderHistoryFooter_searchResultPager_postfixText" class="PagerLabelPostFix"></span>
    <input type="button" name="ctl00$ctl00$mainContent$accountsContent$orderHistoryFooter$searchResultPager$next" value="" id="ctl00_ctl00_mainContent_accountsContent_orderHistoryFooter_searchResultPager_next" disabled="disabled" class="aspNetDisabled NextButtonDisabled">
    <input name="ctl00$ctl00$mainContent$accountsContent$orderHistoryFooter$searchResultPager$totalItems" type="hidden" id="ctl00_ctl00_mainContent_accountsContent_orderHistoryFooter_searchResultPager_totalItems" class="totalItems" value="0">
    <input name="ctl00$ctl00$mainContent$accountsContent$orderHistoryFooter$searchResultPager$pageSize" type="hidden" id="ctl00_ctl00_mainContent_accountsContent_orderHistoryFooter_searchResultPager_pageSize" class="pageSize" value="50">
    <input name="ctl00$ctl00$mainContent$accountsContent$orderHistoryFooter$searchResultPager$origPageNumber" type="hidden" id="ctl00_ctl00_mainContent_accountsContent_orderHistoryFooter_searchResultPager_origPageNumber" class="origPageNumber" value="1">
</div>

    </div>
 </div>


			<div id="ctl00_ctl00_mainContent_accountsContent_orderHistoryBlank" class="OrderHistoryRecords">
				
			</div>

		<div style="background-color: rgb(54, 54, 54);"><div style="margin: 0px; height: 1px; overflow: hidden; background-color: rgb(206, 206, 206);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div><div style="margin: 0px; height: 1px; overflow: hidden; background-color: rgb(162, 162, 162);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div><div style="margin: 0px; height: 1px; overflow: hidden;"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(206, 206, 206);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div></div><div style="margin: 0px 1px; height: 1px; overflow: hidden;"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(162, 162, 162);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(206, 206, 206);"><div style="height: 1px; overflow: hidden; margin: 0px 1px; background-color: rgb(216, 216, 216);"></div></div></div></div></div></div>
	</div>

	<script type="text/javascript">
		//Setup some page events
		window.addEvent('load', function()
		{
			CorbisUI.Order.registerTooltips();
		});

		function printOrderHistory()
		{
			var pageIndex = 1;
			var pageSize = 50;
			var sortOrder = 'LicenseExpiration';
			window.open("PrintOrderHistory.aspx?pageIndex="+pageIndex+"&pageSize="+pageSize+"&sortOrder="+sortOrder,"Popup","width=790, menubar=no, resizable=yes,scrollbars=1");
		}

		loadScripts();
		function loadScripts()
		{
			if (!window.jQuery)
			{
				setTimeout(loadScripts, 100);
				return;
			}
			// load scripts
		}
	</script>

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
  