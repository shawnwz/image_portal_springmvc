<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/pub" prefix="pub"%>
<!-- InstanceEndEditable -->
<body class="careersPage">
<jsp:include page="../inc/pagetop_user.jsp" /> 
<link href="flowsearch/css/sub.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/sub2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/sub2.js"></script>
<script type="text/javascript" src="flowsearch/js/easyResponsiveTabs.jerry.js"></script>
<script type="text/javascript" src="flowsearch/js/bootstrap-filestyle.js"></script>
    <link href="flowsearch/css/jqModal.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="flowsearch/js/jquery.jqModal.js"></script>



  
<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">



    <div class="container">

        <div class="row">
            <div class="col-md-12">
                  <div class="sub-menu">
                    <ul>
                        <li><a class="Source-Han-Light " href="aboutus.html">About Us</a></li>
                        <li><a class="Source-Han-Light " href="contactus.html">联系我们</a></li>
                        <li><a class="Source-Han-Light" href="news.html">高品新闻</a></li>
                        <li><a class="Source-Han-Light active" href="careers.html">加入我们</a></li>
                        <li><a class="Source-Han-Light " href="terms.html">条款和政策</a></li>
                    </ul>
                </div>
                <div class="sub-menuMobile">
                    <span class="curSubPage">加入我们 <span class="icon-font icon-19-arrowdown"></span></span>
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

        <div class="row emailDesc">

            <div class="col-md-12 bannerWrap autoRotate">
                <div class="bannerImgWrap">
                    <div class="proDecsBox">
                        <p class="title SiYuanBold">成为高品的一员</p>
                        <p class="property">创新，用大脑工作</p>
                    </div>
                    <div class="bannerImg">
                        <img src="flowsearch/images/careers/careersPhoto.jpg" width="1920" height="670"/>
                        <div class="label Source-Han-Light hidden-xs hidden-sm"><a href="imagesflow/133101319392">133101319392 © Hero/Gaopinimages</a></div>
                    </div>
                </div>

            </div><!--bannerWrap-->

            <div class="col-md-12 middleText">
                <div class="SiYuanBold">直接联系</div>
                <p>你可以发送你的问题，或你的简历直接到<a href="javascript:;">careers@gaopinimages.com</a></p>
                <p>我们会尽快与你取得联系</p>
            </div>

            <div class="col-md-12">
                <div>
                <c:forEach items="${list}" var="item" varStatus="stat">
                    <div class="oneOffice">
                        <h2>${stat['index']+1}.${item.title} <span class="officeLocation">部门：${item.department} 地区：${item.area}</span><span class="officeBtn icon-font icon-plus"></span></h2>
                        <div class="officeDesc row"  itemid="${item.id}" itemname="${item.title}" itemarea="${item.area}">
                            <div class="col-md-6">
                                <dl>
                                    <dt>职责</dt>
                                    <c:forEach items="${pub:getLines(item.jobContent)}" var="line" varStatus="index">
                                    	<dd><span class="noDot">${index['index']+1}.</span><span class="conText">${line}</span></dd>
                                    </c:forEach>
                                </dl>
                            </div>
                            <div class="col-md-6">
                                <dl>
                                    <dt>资格</dt>
                                        <c:forEach items="${pub:getLines(item.requires)}" var="line" varStatus="index">
                                    	<dd><span class="noDot">${index['index']+1}.</span><span class="conText">${line}</span></dd>
                                    </c:forEach>
                                </dl>
                            </div>
                            <div class="col-md-12">
                                <a class="shenqing" href="javascript:;" data-toggle="modal" data-target="#myModal" data-original-title="" title="">申请职位</a>
                            </div>
                        </div>
                    </div>
	            </c:forEach>
                </div>
            </div>
            
            <div class="col-md-12 challengeAccepted SiYuanBold">欢迎加入我们</div>
            <div class="col-md-3 gaopinGoal">
                <dl>
                    <dt>这里是</dt>
                    <dd>一个年轻、有朝气的团队</dd>
                    <dd>一个人人平等，乐于分享</dd>
                    <dd>坦诚相待的团队</dd>
                </dl>
            </div>
            <div class="col-md-3 gaopinGoal">
                <dl>
                    <dt>你需要</dt>
                    <dd>做事有原则，无论对自己言行还是工作</dd>
                    <dd>我们相信只有一个言行有品、大气的人，才能做出高品质的产品</dd>
                </dl>
            </div>
            <div class="col-md-3 gaopinGoal">
                <dl>
                    <dt>希望你</dt>
                    <dd>要有理想、有冲劲、想奋斗</dd>
                    <dd>崇尚科技范儿、创意范儿、文艺范儿</dd>
                </dl>
            </div>
            <div class="col-md-3 gaopinGoal">
                <dl>
                    <dt>你可以</dt>
                    <dd>任性玩酷</dd>
                    <dd>有个性、有棱角</dd>
                </dl>
            </div>

        </div><!-- row -->


    </div>




</div><!--sectionCont-->
<!-- InstanceEndEditable -->
	 
<jsp:include page="../inc/bottomflow.jsp" />




<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <a class="close" data-dismiss="modal"></a>
            </div>
            <div class="modal-body">
                <div class="popupDiv dialog">
                    <div class="title SiYuanBold">申请职位</div>
                    <form role="form" method="post"  enctype="multipart/form-data"  class="postForm form-lg form-txtLabel" novalidate="novalidate">
                    	<input name="info" type="hidden">
                    	<input name="title" type="hidden">
                        <div class="input-group focusWrap">
                            <div class="label">姓名</div>

                            <input id="formName" name="name" class="form-control ignore" type="text">
                            <label class="has-error" for="formName" generated="true"></label>
                        </div>
                        <div class="input-group focusWrap">
                            <div class="label">联系方式</div>

                            <input id="formPhone" name="tel" class="form-control ignore" type="text">
                            <label class="has-error" for="formPhone" generated="true"></label>
                        </div>
                        <div class="fileUpdateBox">
                            <input type="file" name=file class="filestyle" data-input="false" data-buttonText="上传文件">
                        </div>
                        <input type="hidden" name="cookie_id"/>
                        <input class="submitResume Source-Han-Light" type="button" value="现在发送"/>
                    </form>
                    <div class="careersOtherWay">或者你可以直接给<a href="javascript:;">careers@gaopinimages.com</a>发送邮件附带简历</div>
                </div>
            </div>
        </div>
    </div>
</div>



</body>
<!-- InstanceEnd --></html>
