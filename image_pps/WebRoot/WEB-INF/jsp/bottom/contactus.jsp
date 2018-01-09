<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- InstanceEndEditable -->
<body class="contactUsPage">
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
                        <li><a class="Source-Han-Light active" href="contactus.html">联系我们</a></li>
                        <li><a class="Source-Han-Light" href="news.html">高品新闻</a></li>
                        <li><a class="Source-Han-Light" href="careers.html">加入我们</a></li>
                        <li><a class="Source-Han-Light " href="terms.html">条款和政策</a></li>
                    </ul>
                </div>
                <div class="sub-menuMobile">
                    <span class="curSubPage">联系我们 <span class="icon-font icon-19-arrowdown"></span></span>
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
                        <p class="title SiYuanBold">Efficient, Professional</p>
                        <p class="property">高效，专业</p>
                    </div>
                    <div class="bannerImg">
                        <img src="flowsearch/images/contactUs/photo01.jpg" width="1920" height="670"/>
                        <div class="label Source-Han-Light hidden-xs hidden-sm"><a href="imagesflow/133101930208" target="_black">133101930208 by Jasmin Awad</a></div>
                    </div>
                </div>

            </div><!--bannerWrap-->

            <div class="col-md-5">
                <h2 class="SiYuanBold">发送Email</h2>
                <form role="form" method="post" class="postForm3 form-lg form-txtLabel">
                    <div class="form-group">
                        <div class="input-group focusWrap">
                            <div class="label">姓名</div>
                            <input id="formName" name="name" class="form-control" type="text">
                            <label class="has-error" for="formName" generated="true"></label>
                        </div>
                        <div class="input-group focusWrap" id="emailAddr">
                            <div class="label">邮箱</div>
                            <input id="formEmail" name="email" class="form-control" type="email">
                            <label class="has-error" for="formEmail" generated="true"></label>
                        </div>

                        <div class="input-group focusWrap">
                            <div class="label">电话</div>
                            <input class="form-control ignore" id="formTel" name="tel" type="text">
                        </div>
                        <div class="input-group focusWrap ">
                            <div class="label">公司名称</div>
                            <input class="form-control ignore" name="com_name" type="text">
                        </div>

                        <textarea name="todo" cols="" rows="" class="textareaSearchByIndex" placeholder="我们可以帮你什么..."></textarea>

                        <div class="btnBtm">
                            <input class="btnSubmit3 btn-block btnPurple scrollTop" name="" type="submit" value="提交"/>
                        </div>
                    </div><!--form-group-->
                </form>
            </div>
            <div class="col-md-6 col-md-offset-1">
                <div class="contentText">
                    <h4 class="col-md-12 SiYuanBold">联系我们</h4>
                    <div class="col-md-6">
                        <div class="hotNumb"><span class="icon-font icon-7-contact"></span><span class="textSpanCon hidden-xs hidden-sm">免费热线 <br></span><span class="textSpanConMobile visible-xs visible-sm">免费热线</span>400-8191-800</div>
                        <div class="hotNumb"><span class="icon-font icon-10-email"></span><span class="textSpanCon hidden-xs hidden-sm">邮件服务 <br></span><span class="textSpanConMobile visible-xs visible-sm">邮件服务</span><a href="mailto:service@gaopinimages.com">service@gaopinimages.com</a></div>
                        <div class="hotNumb"><span class="icon-font icon-10-email"></span><span class="textSpanCon hidden-xs hidden-sm">市场/媒体 <br></span><span class="textSpanConMobile visible-xs visible-sm">市场/媒体</span><a href="mailto:media@gaopinimages.com">media@gaopinimages.com</a></div>
                        <div class="hotNumb"><span class="icon-font icon-10-email"></span><span class="textSpanCon hidden-xs hidden-sm">产品/供稿 <br></span><span class="textSpanConMobile visible-xs visible-sm">产品/供稿</span><a href="mailto:products@gaopinimages.com">products@gaopinimages.com</a></div>
                    </div>
                    <div class="col-md-6 contactIcon">
                        <div class="icon"><img src="flowsearch/images/iconWeChat.gif" style="    width: 120px;"></div>
                        <a class="icon-font icon-68-shareWeibo" href="javascript:;"></a>
                    </div>
                    <h4 class="col-md-12 SiYuanBold">中国</h4>
                    <dl class="col-md-6">
                        <dt>北京</dt>
                        <dd>电话：+86 10 6500 8152</dd>
                        <dd>传真：+86 10 6500 8192</dd>
                        <dd>地址：北京朝阳区工体北路4号院22.OFFICE 2层</dd>
                        <dd>邮编：100027</dd>
                    </dl>
                    <dl class="col-md-6">
                        <dt>上海</dt>
                        <dd>电话：+86 138 1725 9965</dd>
                        <dd>地址：上海静安区南京西路699号东方有线大厦18层1812</dd>
                        <dd>邮编：200041</dd>
                    </dl>
                    <dl class="col-md-6">
                        <dt>广州</dt>
                        <dd>电话：+86 20 3847 3900</dd>
                        <dd>传真：+86 20 3847 3901</dd>
                        <dd>地址：广州天河区体育东横街3号设计大厦
                            17楼17B02 </dd>
                        <dd>邮编: 510620</dd>
                    </dl>
                </div>
            </div>

        </div><!-- row -->


    </div>








</div><!--sectionCont-->
<!-- InstanceEndEditable -->
	 
<jsp:include page="../inc/bottomflow.jsp" />

</body>
<!-- InstanceEnd --></html>
