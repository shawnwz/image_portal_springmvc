<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../inc/pageheader_user.jsp" /> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<body>
<jsp:include page="../inc/pagetop_user.jsp" /> 
<div id="sectionCont" class="pageLanding">
	<div class="container1920">
        <div class="bannerWrap autoRotate">
            <div class="bannerImgWrap">
                <div class="proDecsBox">
                    <p class="title SiYuanBold">${item_banner.title}</p>
                    <p class="property">${item_banner.info}</p>
                </div>
                <div class="bannerImg">
                    <img src="webres/upload/${item_banner.src}" width="1920" height="670"/>
                    <!--<div class="label Source-Han-Light hidden-xs hidden-sm"><a href="#">133201438387 by Charlie Harding</a></div>-->
                </div>
            </div>
            <div class="searchBar">
                <div class="container">
                    <div class="searchBarInner col-md-9">
                        <span class="SiYuan-ExtraLight hidden">${item_searchbar.title}</span>
                        <input class="searchFiled SiYuan-ExtraLight" name="q" id="q" type="text" placeholder="${item_searchbar.title}">
                        <a href="${item_searchbar.url}" class="btnSearch icon-font icon-13-search"></a>
                    </div>
                </div>
            </div>
        </div><!--bannerWrap-->
	</div>

    <div class="container editorialLanding landingPages">
        <div class="row">

            <div class="col-md-8">
                <div class="landingPagesTitle artPageTitle">
                    <div class="row">
                        <div class="col-md-5">
                            <h1 class="Source-Han-Light"><span class="gaopinIcon gaopinIcon-Art"></span>${item_overview.title}</h1>
                        </div>
                        <div class="col-md-7">
                        ${item_overview.info}
                        </div>
                    </div>
                </div>

                <div>
                    <a href="${item_img_1.url}" class="boxCollection no_margin_links">

                        <img src="webres/upload/${item_img_1.src}" alt="image_section" class="image_box">

                        <span class="button_collection icon-font icon-6-collection"></span>

                        <div class="topBorder"></div>

                        <div class="bottomBorder"></div>

                        <h3 class="Source-Han-Light">${item_img_1.title}</h3>

                        <h3 class="h3ForMobile Source-Han-Light">${item_img_1.info}</h3>

                    </a>
                </div>

                <div>
                    <a href="${item_img_2.url}" class="boxCollection no_margin_links height638">

                        <img src="webres/upload/${item_img_2.src}" alt="image_section" class="image_box">

                        <span class="button_collection icon-font icon-6-collection"></span>

                        <div class="topBorder"></div>

                        <div class="bottomBorder"></div>

                        <h3 class="Source-Han-Light">${item_img_2.title}</h3>

                        <h3 class="h3ForMobile Source-Han-Light">${item_img_2.info}</h3>

                    </a>
                </div>
            </div>
            <div class="col-md-4">
                <div>
                    <a href="${item_img_3.url}" class="boxCollection no_margin_links height418">

                        <img src="webres/upload/${item_img_3.src}" alt="image_section" class="image_box">

                        <span class="button_collection icon-font icon-6-collection"></span>

                        <div class="topBorder"></div>

                        <div class="bottomBorder"></div>

                        <h3 class="Source-Han-Light">${item_img_3.title}</h3>

                        <h3 class="h3ForMobile Source-Han-Light">${item_img_3.info}</h3>

                    </a>
                </div>

                <div>
                    <a href="${item_img_4.url}" class="boxCollection no_margin_links height418">

                        <img src="webres/upload/${item_img_4.src}" alt="image_section" class="image_box">

                        <span class="button_collection icon-font icon-6-collection"></span>

                        <div class="topBorder"></div>

                        <div class="bottomBorder"></div>

                        <h3 class="Source-Han-Light">${item_img_4.title}</h3>

                        <h3 class="h3ForMobile Source-Han-Light">${item_img_4.info}</h3>

                    </a>
                </div>

                <div>
                    <a href="${item_img_5.url}" class="boxCollection no_margin_links height418">

                        <img src="webres/upload/${item_img_5.src}" alt="image_section" class="image_box">

                        <span class="button_collection icon-font icon-6-collection"></span>

                        <div class="topBorder"></div>

                        <div class="bottomBorder"></div>

                        <h3 class="Source-Han-Light">${item_img_5.title}</h3>

                        <h3 class="h3ForMobile Source-Han-Light">${item_img_5.info}</h3>

                    </a>
                </div>
            </div>

        </div>
    </div>

</div>
<!-- InstanceEndEditable -->

<jsp:include page="../inc/bottomflow.jsp" />
</body>
<!-- InstanceEnd --></html>