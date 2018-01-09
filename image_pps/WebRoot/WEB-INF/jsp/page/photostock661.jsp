<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- InstanceEndEditable -->
<body class="">
<jsp:include page="../inc/pagetop_user.jsp" /> 
<link href="flowsearch/css/sub.css" rel="stylesheet" type="text/css" />
<link href="flowsearch/css/sub2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="flowsearch/js/sub2.js"></script>


<!-- InstanceBeginEditable name="cont" -->
<div id="sectionCont">
	<div class="container editorialLanding">

        <div class="row">

            <div class="bannerWrap autoRotate">
                <div class="bannerImgWrap">
                    <div class="proDecsBox">
                        <p class="title SiYuanBold">${item2.title }</p>
                        <p class="property">${item2.info }</p>
                    </div>
                    <div class="bannerImg">
                        <img src="webres/upload/${item2.src }" width="1920" height="670"/>
                        <div class="label Source-Han-Light hidden-xs hidden-sm">
                        	<a href="${item2.url}">${item2.name}</a>
                        </div>
                    </div>
                </div>

            </div><!--bannerWrap-->

        </div><!-- row -->

	
	</div>

    <div class="container editorialLanding">
        <div class="row">


            <div class="col-md-6">
                <div>
                    <a href="${item3.url }" class="boxCollection no_margin_links">

                        <img src="webres/upload/${item3.src }" alt="image_section" class="image_box">

                        <span class="button_collection icon-font icon-6-collection"></span>

                        <div class="topBorder"></div>

                        <div class="bottomBorder"></div>

                        <h3 class="Source-Han-Light">${item3.title }</h3>

                        <h3 class="h3ForMobile Source-Han-Light">${item3.title }</h3>

                        <small class="Source-Han-Light">${item3.info }</small>

                    </a>


                    <div class="galleryLink">
                        <span class="gallerySpanTitle Source-Han-Light">${item3t.title }</span><a href="${item3t.url }">${item3t.info }</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div>
                    <a href="${item4.url }" class="boxCollection no_margin_links">

                        <img src="webres/upload/${item4.src }" alt="image_section" class="image_box">

                        <span class="button_collection icon-font icon-6-collection"></span>

                        <div class="topBorder"></div>

                        <div class="bottomBorder"></div>

                        <h3 class="Source-Han-Light">${item4.title }</h3>

                        <h3 class="h3ForMobile Source-Han-Light">${item4.title }</h3>

                        <small class="Source-Han-Light">${item4.info }</small>


                    </a>
                    <div class="galleryLink">
<!--                     <span class="hidden-xs">,</span><a href="javascript:;">Robert Harding</a><span class="hidden-xs">,</span><a href="javascript:;">Another</a> -->
                        <span class="gallerySpanTitle Source-Han-Light">${item4t.title }</span><a href="${item4t.url }">${item4t.info }</a>
                    </div>
                </div>
            </div>

        </div>

        <div class="row">


            <div class="col-md-8">
                <div>
                    <a href="${item5.url }" class="boxCollection no_margin_links height280">

                        <img src="webres/upload/${item5.src }" alt="image_section" class="image_box">

                        <div class="topBorder"></div>
                        <div class="bottomBorder"></div>
                    </a>
                    <div class="galleryLink">
                        <span class="gallerySpanTitle Source-Han-Light">${item5t.title }</span><a href="${item5t.url }">${item5t.info }</a>
                    </div>
                </div>
            </div>
            
            
            <div class="col-md-4 hidden-xs hidden-sm">
                <div class="topCategories">
                    <img src="flowsearch/images/editorialLanding/icon-gray.png" alt=""/><br/>
                    <span class="Source-Han-Light">${item6.title }</span>
                    <span class="SiYuanBold">${item6.info }</span>
                </div>
                <div>
                    <div class="tieba">
                        <p class="Source-Han-Light">${item6t.info }</p>
                        <a class="btnMore learnHow Source-Han-Light" href="${item6t.url }">${item6t.title }</a>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>
<!-- InstanceEndEditable -->

<jsp:include page="../inc/bottomflow.jsp" />




			
</body>
<!-- InstanceEnd --></html>
