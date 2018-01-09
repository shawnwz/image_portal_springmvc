<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- InstanceEndEditable -->
<body class="newsDetailPage">
<jsp:include page="../inc/pagetop_user.jsp" /> 
<link href="flowsearch/css/sub.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/sub2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/sub2.js"></script>
<script type="text/javascript" src="flowsearch/js/easyResponsiveTabs.jerry.js"></script>
  
<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">




	<div class="container">

        <div class="row">
            <div class="col-md-12">
                <div class="sub-menu">
                    <ul>
                        <li><a class="Source-Han-Light " href="aboutus.html">About Us</a></li>
                        <li><a class="Source-Han-Light " href="contactus.html">联系我们</a></li>
                        <li><a class="Source-Han-Light active" href="news.html">高品新闻</a></li>
                        <li><a class="Source-Han-Light " href="careers.html">加入我们</a></li>
                        <li><a class="Source-Han-Light " href="terms.html">条款和政策</a></li>
                    </ul>
                </div>
                <div class="sub-menuMobile">
                    <span class="curSubPage">条款和政策 <span class="icon-font icon-19-arrowdown"></span></span>
                    <ul>
                        <li><a class="Source-Han-Light" href="aboutus.html">About Us</a></li>
                        <li><a class="Source-Han-Light" href="contactus.html">联系我们</a></li>
                        <li><a class="Source-Han-Light" href="news.html">高品新闻</a></li>
                        <li><a class="Source-Han-Light" href="careers.html">加入我们</a></li>
                        <li><a class="Source-Han-Light" href="terms.html">条款和政策</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="row">

            <div class="col-md-8 newsContentBox">
                <ul class="detailShareUl">
                    <li><a class="icon-font icon-icon-37-plane" href="javascript:void(0)"></a>
                        <ul>
                            <li><a class="detailShareWeixin" href="javascript:void(0)" >微信</a></li>
                            <li><a class="detailShareWeibo" href="javascript:void(0)" >新浪微博</a></li>
                            <li><a class="detailShareQQweibo" href="javascript:void(0)" >腾讯微博</a></li>
                            <li><a class="detailShareDouban" href="javascript:void(0)" >豆瓣</a></li>
                            <li><a class="detailShareRenren" href="javascript:void(0)" >人人</a></li>
                            <li><a class="detailShareMail" href="javascript:void(0)" >邮件</a></li>
                        </ul>
                    </li>
                </ul>

                <h1 class="SiYuanBold">${item.title}</h1>
                <div class="timer Source-Han-Light"><span>${item.label}</span><i>${item.publishTimeStr16}</i></div>
                <div class="newsBigImg">
                    <img src="webres/upload/${ item.thumbBig}" alt="${item.title}"/>
                </div>
                <div class="newsContent">
					${item.content}
                </div>
                <div class="pageFun">
                    <a class="prevPage gotopage" pageid="${prev}" pagelabel="${type }" href="javascript:;">上一篇</a>
                    <a class="nextPage gotopage" pageid="${next}" pagelabel="${type }" href="javascript:;">下一篇</a>
                </div>
            </div><!-- newsContentBox -->

            <div class="col-md-4 newsContentList hidden-sm hidden-xs">
                <h4 class="SiYuanBold">新闻列表</h4>
                <ol>
                <c:forEach items="${list}" var="item" varStatus="stat">
                	<li>
                        <a href="javascript:;"  class="gotopage"  pageid="${item.id}" pagelabel="${type }"><img src="webres/upload/${ item.thumbSmall}" alt="${item.title}"/></a>
                        <div class="title Source-Han-Light"><a href="javascript:;" class="gotopage"  pageid="${item.id}" pagelabel="${type }" >${item.title}</a></div>
                        <div class="listNewsTime">${item.publishTimeStr10}</div>
                    </li>
                </c:forEach>
                </ol>
            </div>

        </div><!-- row -->

	
	</div>






</div><!--sectionCont-->
<!-- InstanceEndEditable -->
	 
<jsp:include page="../inc/bottomflow.jsp" />
<script type="text/javascript">
$(document).ready(function(){
	$(".gotopage").click(function(){
		var id=$(this).attr("pageid");
		var label=$(this).attr("pagelabel");
		if(id&&id>0)
			location.href='newsdetails/'+id+'.html?type='+(label);
		
	});
	
});

</script>
</body>
<!-- InstanceEnd --></html>
