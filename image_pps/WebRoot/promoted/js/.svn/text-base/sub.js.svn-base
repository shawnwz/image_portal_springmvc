(function ($) {
    jQuery(document).ready(function () {

        //  类似图片 切换
        function myTab(leftBtn, rightBtn) {

            $('.mySlideTab').each(function (index, element) {
                if ($(this).find('ul li').length <= 1) {
                    $(this).parent().find('.nextLi, .pervLi').hide();
                }
            })

            var oLi = $('.mySlideShowDiv li:first');
            var targetWidth = parseInt(oLi.css('width'));
            var count = 0;
            $(leftBtn).click(function () {
                var aLi = $(this).parent().prev().find('li');
                count++;
                if (count >= aLi.length) {
                    count = 0;
                }
                $(this).parent().prev().find('ul').animate({marginLeft: targetWidth * -count + 'px'});
            });
            $(rightBtn).click(function () {

                var aLi = $(this).parent().prev().find('li');
                count--;
                if (count < 0) {
                    count = aLi.length - 1;
                }
                $(this).parent().prev().find('ul').animate({marginLeft: targetWidth * -count + 'px'});
            });
        }

        if ($('.pageCollectionDetail').length > 0) {
            myTab('#myTabLeft1', "#myTabRight1");
            myTab('#myTabLeft2', "#myTabRight2");
            myTab('#myTabLeft3', "#myTabRight3");
        }

        if ($('.pageDetail').length > 0) {


            myTab('#myTabLeft1', "#myTabRight1");
            myTab('#myTabLeft2', "#myTabRight2");


            $("input[type='radio'][name='cm']").on('ifChecked', function (event) {
                var idx = $("input[type='radio'][name='cm']").index(this);
                $("input[type='radio'][name='px']").eq(idx).iCheck('check');
            });
            $("input[type='radio'][name='px']").on('ifChecked', function (event) {
                var idx = $("input[type='radio'][name='px']").index(this);
                $("input[type='radio'][name='cm']").eq(idx).iCheck('check');
            });


            // 查看更多 展开、收缩
            $('.viewMore').toggle(function () {
                $(this).removeClass('viewMore').addClass('viewMoreUp').text('关闭');
                $(this).find('.viewDown').addClass('viewUp').removeClass('viewDown');
                $('.moreDesc').slideDown(function () {
                    $(this).removeAttr('style').css({overflow: 'visible', display: 'block'});
                });
            }, function () {
                $(this).removeClass('viewMoreUp').addClass('viewMore').text('查看更多');
                $(this).find('.viewUp').addClass('viewDown').removeClass('viewUp');
                $('.moreDesc').slideUp();
            });

            // 联系我们 popup
            $('.dialog').jqm();


            if ($('.galleryWrap').length > 0) {
                var $container = $('.galleryWrap').masonry({
                    itemSelector: '.galleryWrap .galleryThumb'
                });

                $container.imagesLoaded(function () {
                    $container.masonry();
                });
            }


            $('a').tooltip();


        }
        //招聘select
        if ($('.officeBtn').length > 0) {
            $('.officeBtn').click(function () {
                if ($(this).hasClass('icon-minus')) {
                    $(this).parents('.oneOffice').find('.officeDesc').slideUp();
                    $(this).removeClass('icon-minus').addClass('icon-plus');
                } else {
                    $('.officeDesc').slideUp();
                    $('.officeBtn').removeClass('icon-minus').addClass('icon-plus');
                    $(this).removeClass('icon-plus').addClass('icon-minus');
                    $(this).parents('.oneOffice').find('.officeDesc').slideDown();
                }

            });

        }

        if ($('#horizontalTab').length > 0) {
            $('#horizontalTab').easyResponsiveTabs({
                type: 'default', //Types: default, vertical, accordion
                width: '991', //auto or any width like 600px
                fit: true,   // 100% fit in a container
                closed: 'accordion', // Start closed if in accordion view
                activate: function (event) { // Callback function if tab is switched
                    var $tab = $(this);
                    var $info = $('#tabInfo');
                    var $name = $('span', $info);
                    $name.text($tab.text());
                    $info.show();
                }
            });
        }
        if ($('.closeThisBox').length > 0) {



            //点击收起关闭内容
            $('.closeThisBox').click(function () {
                $("html,body").animate({scrollTop: 0}, 400);
                $(this).parent().slideUp();
                $(this).parent().prev().removeClass('resp-tab-active');
            });


            //判断滚动条滚动方向
            /*var lastScrollTop = 0;
             $(window).scroll(function(event){
             var st = $(this).scrollTop();
             if (st > lastScrollTop){
             // downscroll code
             //alert("下");
             $('.closeThisBox').css({display:'none'});
             } else {
             // upscroll code
             //alert("上");
             $('.closeThisBox').css({display:'block'});
             }
             lastScrollTop = st;
             });*/
        }


        if ($('.sub-menuMobile').length > 0) {

            $('.sub-menuMobile .curSubPage').click(function () {
                if ($(this).next('ul').hasClass('open')) {
                    $(this).next('ul').slideUp().removeClass('open');
                    $(this).find('span').removeClass('icon-35-arrowUp').addClass('icon-19-arrowdown');
                } else {
                    $(this).next('ul').slideDown().addClass('open');
                    $(this).find('span').removeClass('icon-19-arrowdown').addClass('icon-35-arrowUp');
                }
            });
        }

        if ($('.termPoliciesPage').length > 0) {


            function tabsPos() {

                $('.bannerWrap').imagesLoaded(function () {
                    $('.resp-tabs-list li a').click(function () {
                        $(window).scrollTop(0);
                    });

                    var oldNavTop = $(".resp-tabs-list").offset().top;
                    var oldNavWidth = $(".resp-tabs-list").css('width');
                    $(window).scroll(function () {
                        var numTabsTop = parseInt($('.resp-tabs-list').offset().top);
                        var numTabsHeight = parseInt($('.resp-tabs-list').css('height'));
                        var numContentTop = parseInt($('.resp-tabs-container').offset().top);
                        var numContentHeight = parseInt($('.resp-tabs-container').css('height'));
                        var numContent = numContentHeight + numContentTop;

                        if ($(window).scrollTop() >= numContent - numTabsHeight) {
                            $('.resp-tabs-list').css({
                                position: 'absolute',
                                top: numContent - numTabsHeight,
                                width: oldNavWidth
                            });
                        } else if ($(window).scrollTop() > oldNavTop - 30) {
                            $('.resp-tabs-list').css({
                                position: 'fixed',
                                top: '30px',
                                width: oldNavWidth
                            });
                        } else {
                            $('.resp-tabs-list').removeAttr('style');
                        }
                    });

                })
            }

            tabsPos();
            $(window).resize(function () {
                tabsPos();
            });
        }


    });
}(jQuery));