<%@ page contentType="text/html; charset=UTF-8" autoFlush="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<script type="text/javascript" src="js/search_adv.js"></script>
     
     
   <div class="h-searchbox" id="h-search">
   <script type="text/javascript">
   $(function() {
	    $( "#beginDate" ).datepicker({
	      showOtherMonths: true,
	      selectOtherMonths: true
	    });
	    $( "#endDate" ).datepicker({
		      showOtherMonths: true,
		      selectOtherMonths: true
		    });
	  });
   </script>
   <form id="advform" >
        	<img src="images/h_searchbox.png" class="h-searchbox-bar" />
            <p class="h-searchbox-title"><b>高级搜索</b> <a href="#">搜索提示</a></p>
            <div class="hsebo-listbox">
                <p>
                    <label>拍摄日期</label>
                    <input type="text" name="dateCreated" class="h-searchbox-inputtext" /><br />
                    <span class="note">(例如：1935-1941，2009年2月28日)</span><br />
                </p>
                <p><label>上传日期</label></p>
                <div class="h-searchbox-datebg">
                	<div style="position: relative;left: 0px;top: 5px;"><div class="icheckbox_minimal-aero"><input type="checkbox" name="update-time" value="1"/><ins class="iCheck-helper" ></ins></div></div>&nbsp;最近的<input type="text" name="days" class="h-searchbox-inputtext h-searchbox-inputtext-little" value="26" />天
                </div>
                <div class="h-searchbox-datebg">
                	<div style="position: relative;left: 0px;top: 5px;"><div class="icheckbox_minimal-aero"><input type="checkbox" name="update-time"  value="2"/><ins class="iCheck-helper" ></ins></div></div>&nbsp;介于<br />
                    <input type="text" name="beginDate" id="beginDate" class="h-searchbox-inputtext h-searchbox-inputtext-date" value="2012-10-01" style="margin-top: -8px;"/><span style="position: relative;left: 0px;top: -2px;margin: 0px 5px;">至</span><input type="text" class="h-searchbox-inputtext h-searchbox-inputtext-date" value="2014-01-15" name="endDate" id="endDate" style="margin-top: -8px;"/>
                </div>
                <p>
                    <label>地点</label>
                    <input type="text" name="location" class="h-searchbox-inputtext" /><br />
                </p>
                <p>
                    <label>摄影师</label>
                    <input type="text" name="photographer" class="h-searchbox-inputtext" /><br />
                </p>
                <p>
                    <label>供应者</label>
                    <input type="text" name="provider" class="h-searchbox-inputtext" /><br />
                </p>
            </div>
            <div class="hsebo-listboxb">
            	<p>
                	即时供应情况</p>
                   <div class="select-widget" callback="" style="margin-left: 16px;margin-bottom: -15px;width:252px;">
                    	<input type="hidden" name="immediateAvailablility" value="-1"/>
                        <input value="全部精度" readonly="readonly" class="checkany" name="nv_immediateAvailablility"/>
                        <img src="images/pic_menu_more.png"/>
                      	<div style="position: absolute;top: 25px;">
                            <a href="javascript:void(0);" value="-1"><p>全部精度</p></a>
                            <a href="javascript:void(0);" value="67,64,561,559"><p>网页</p></a>
                            <a href="javascript:void(0);" value="64,561,559"><p>小</p></a>
                            <a href="javascript:void(0);" value="561,559"><p>中</p></a>
                            <a href="javascript:void(0);" value="559"><p>最大</p></a>
                        </div>
                    </div>  
                    
               <!-- <select name="immediateAvailablility"><option value="-1">全部精度</option><option value="67">网页</option><option value="64">小</option><option value="561">中</option><option value="559">最大</option></select> -->    
                <p> <span class="note"> 仅限RM。所有免版税图片均可立即供应。    </span>
                </p>
                <p>
                	<label>图片编号</label><br />
                    <textarea name="in" placeholder="每个图片编号需另起一行，或者用逗号或空格分隔他们"></textarea><br />
                    <span class="note"> 用图片编号进行搜索时，其它筛选功能将被忽略。</span>
                </p>
            </div>
            <div class="hsebo-listboxb imagecollselect" style="max-height:410px;">
            	<p class="h-searchbox-sfqtitle">精品图片库<span style="float: right;position: inherit;top: 0px;left: 0px;margin-top: 3px;"><font>${fn:length(premiumList)}</font>/<font>${fn:length(premiumList)}</font></span></p>
                <div class="h-searchbox-sfqcontent h-searchbox-sfqcontentparent">
                	<div class="h-searchbox-sfqcontent scroll-pane" style="width: 252px;">
	                	<c:forEach items="${premiumList}" var="collection" varStatus="stat">
	                		<div class="scorllpanedata"><div class="icheckbox_minimal-aero"><input type="checkbox" name="imagecollection" value="${collection.id }" /><ins class="iCheck-helper" ></ins></div><label>${collection.showName}</label></div>
	                	</c:forEach>
                	</div>

                </div>
    			<div class="selectLinksWrap" style="margin-left: 21px;"><a class="selectAllLink" href="javascript:void(0)" style="color: #69C;">选择全部</a> · <a class="deselectAllLink" href="javascript:void(0)"  style="color: #69C;">取消全部选择</a></div>
                
                <p class="h-searchbox-sfqtitle">标准图片库<span style="float: right;position: inherit;top: 0px;left: 0px;margin-top: 3px;"><font>${fn:length(standardList)}</font>/<font>${fn:length(standardList)}</font></span></p>
            	<div  class="h-searchbox-sfqcontent h-searchbox-sfqcontentparent" style="display:none;">
	            	<div class="h-searchbox-sfqcontent  scroll-pane"  style="width: 252px;">
	                	<c:forEach items="${standardList}" var="collection" varStatus="stat">
	                		<div class="scorllpanedata"><div class="icheckbox_minimal-aero"><input type="checkbox" name="imagecollection" value="${collection.id }" /><ins class="iCheck-helper" ></ins></div><label>${collection.showName}</label></div>
	                	</c:forEach>
	                </div>
                </div>
                
            	<p class="h-searchbox-sfqtitle">超值图片库<span style="float: right;position: inherit;top: 0px;left: 0px;margin-top: 3px;"><font>${fn:length(valueList)}</font>/<font>${fn:length(valueList)}</font></span></p>
            	<div  class="h-searchbox-sfqcontent h-searchbox-sfqcontentparent" style="display:none;">
	            	<div class="h-searchbox-sfqcontent scroll-pane" style="width: 252px;">
	                	<c:forEach items="${valueList}" var="collection" varStatus="stat">
	                		<div class="scorllpanedata"><div class="icheckbox_minimal-aero"><input type="checkbox" name="imagecollection" value="${collection.id }" /><ins class="iCheck-helper" ></ins></div><label>${collection.showName}</label></div>
	                	</c:forEach>
	                </div>
                </div>
                
            	<p class="h-searchbox-sfqtitle">低价图片库<span style="float: right;position: inherit;top: 0px;left: 0px;margin-top: 3px;"><font>${fn:length(superValueList)}</font>/<font>${fn:length(superValueList)}</font></span></p>
            	<div  class="h-searchbox-sfqcontent h-searchbox-sfqcontentparent" style="display:none;">
	            	<div class="h-searchbox-sfqcontent scroll-pane" style="width: 252px;">
	                	<c:forEach items="${superValueList}" var="collection" varStatus="stat">
	                		<div class="scorllpanedata"><div class="icheckbox_minimal-aero"><input type="checkbox" name="imagecollection" value="${collection.id }" /><ins class="iCheck-helper" ></ins></div><label>${collection.showName}</label></div>
	                	</c:forEach>
	                </div>
                </div>
            </div>
            <p class="h-searchbox-inputbutton" style="margin-left: 495px;margin-bottom: 8px;"><input type="button" class="h-searchbox-inputbuttonb" value="搜 索" onclick="afteradvanceSearch()"/><input type="button" class="h-searchbox-inputbuttoncancel" value="取消" /></p>
	</form>
</div>
          

          
    
    
    
       