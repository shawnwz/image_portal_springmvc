<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>搜索结果</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script src="../js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	function search(){
		var t =  new Date().getTime();
		$.post("s.do",
	    {
	    	q:$("#q").val(),
	    	pageNo:$("#pageNo").val(),
	    	limit:$("#limit").val()
	    },
	    
	    function(data,status){
	    	if(status){
	    		$("#showData").empty();
	    		setPageNo(data['num']);
	    		for(i=0; i<data['data'].length; i++){
	    			$("#showData").append("id: "+data['data'][i] + "<br/>");
	    		}
	    		$("#showTimes").html("耗时: "+(new Date().getTime() - t)+"&nbsp;&nbsp;&nbsp;结果数量: "+data['num']);
	    	}
	    });
	}
	$(document).ready(function(){
	  $("#searchButton").click(search);
	  $("#prevButton").click(search);
	  $("#nextButton").click(search);
	});
	
	function setPageNo(num){
		$("#showPages").empty();
		var pageNo = $("#pageNo").val();
		var limit = $("#limit").val();
		if(pageNo>0){
			$("#showPages").append("<input type='button' id='prevButton' value='上一页' onclick='prevPage();'/>");
		}
		else{
			$("#showPages").append("<input type='button' id='prevButton' value='上一页' disabled/>");
		}
		
		if(pageNo*limit < num){
			$("#showPages").append("<input type='button' id='nextButton' value='下一页' onclick='nextPage();'/>");
		}
		else{
			$("#showPages").append("<input type='button' id='nextButton' value='下一页' disabled/>");
		}
	}
	
	function prevPage(){
		var page = parseInt($("#pageNo").val());
		$("#pageNo").val(page-1);
		search();
	}
	
	function nextPage(){
		var page = parseInt($("#pageNo").val());
		$("#pageNo").val(page+1);
		search();
	}
</script>
</head>

<body>
	   	关键字：<input id="q" type="text" name="q" value="" /><br/>
	   	　数量：<input id="limit" text="text" name="limit" value="10" size=10/><br/>
	   	　页码：<input type="text" id="pageNo" name="pageNo" value="0" /><br/>
	   	<input type="button" id="searchButton" value="搜索ajax"/><br/><br/>
	   	---------------------------------------<br/>
	   	<div id="showTimes"></div><br/>
	   	<div id="showPages"></div><br/>
	   	<div id="showData"></div>
</body>
</html>
