(function ($) {
    jQuery(document).ready(function () {

        $('#navLeft ul li').hover(function(){
            $(this).find('.secondaryMenu').slideDown();
        },function(){
            $(this).find('.secondaryMenu').hide();
        })


        if ($('#navLeft .officeBtn').length > 0) {
            $('#navLeft .officeBtn').click(function () {
                var $class = $(this).attr('rel');
                $(this).removeClass('icon-minus').addClass('icon-plus');
                $('#navLeft ul').animate({marginLeft:'-200%'});
                $('#navLeft .navMobileSub').css({display:'block'}).animate({marginLeft:0});
                $('#navLeft .navMobileSub dl').each(function(){
                    if($(this).hasClass($class)){
                        $(this).css('display','block');
                    }else{
                        $(this).css('display','none');
                    }
                });

            });

        }
        $('#navLeft .navMobileSub dt span').click(function(){
            $('#navLeft ul').animate({marginLeft:0});
            $('#navLeft .navMobileSub').animate({marginLeft:'100%'},function(){
                $('#navLeft .navMobileSub').css({display: 'none'})
            });
        })



        $(window).resize(function () {
            if($(window).width()>990){
                $('#navLeft ul').removeAttr('style');
                $('.navMobileSub').removeAttr('style').find('dl').removeAttr('style');
            }
        });

        $(document).scroll(function(){
            $('.secondaryMenu').css({top: 95-$(document).scrollTop()})
        })

    });
}(jQuery));
