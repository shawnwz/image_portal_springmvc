(function ($) {
    jQuery(document).ready(function () {

        jQuery.fn.extend({
            toggleText: function (a, b) {
                var that = this;
                if (that.text() != a && that.text() != b) {
                    that.text(a);
                }
                else if (that.text() == a) {
                    that.text(b);
                }
                else if (that.text() == b) {
                    that.text(a);
                }
                return this;
            }
        });

        $('.more').click(function () {
            $(this).toggleText('+', '-');
        });

        function wrapperHeightAuto(){
            if ($(window).width() < 992) {

                $('.wrapper').removeClass('big little').removeAttr('style');
                $('.big .little .middle .large .half').removeAttr('style');

                return false;
            } else if ($(window).width() < 1199) {

                $('.wrapper').removeClass('big little').removeAttr('style');
                $('.big .little .middle .large .half').removeAttr('style');

                var heightFix = 340;

                var wrapperHeight = $('.wrapper').height();
                var big = $('.big');

                $('.wrapper').each(function () {

                    if ($(this).height() > 410) {
                        $(this).height(wrapperHeight);
                        $(this).addClass('big');
                    } else {
                        $(this).height(wrapperHeight);
                        $(this).addClass('little');
                    }

                    var bigButton = $('.big').children('.small').children('.button').children('.more');
                    var littleButton = $('.little').children('.small').children('.button');

                    $(littleButton).css('display', 'none');

                    $(bigButton).click(function () {

                        if ($(this).parent().parent().parent().height() > heightFix) {

                            $(this).parent().parent().parent().height(heightFix);

                        } else {

                            $(this).parent().parent().parent().height(heightFix * 2);

                        }
                        ;

                    });

                    $('.big').height(heightFix);
                    $('.little').height(heightFix);
                    $('.middle').height(heightFix);
                    $('.large').height(heightFix);
                    $('.half').height(heightFix / parseInt(2));

                });
            } else if ($(window).width() > 1200) {

                $('.wrapper').removeClass('big little').removeAttr('style');
                $('.big .little .middle .large .half').removeAttr('style');

                var wrapperHeight = $('.wrapper').height();
                var big = $('.big');

                $('.wrapper').each(function () {

                    if ($(this).height() > 410) {
                        $(this).height(wrapperHeight);
                        $(this).addClass('big');
                    } else {
                        $(this).height(wrapperHeight);
                        $(this).addClass('little');
                    }

                    var bigButton = $('.big').children('.small').children('.button').children('.more');
                    var littleButton = $('.little').children('.small').children('.button');

                    $(littleButton).css('display', 'none');

                    $(bigButton).click(function () {

                        if ($(this).parent().parent().parent().height() > heightFix) {

                            $(this).parent().parent().parent().height(heightFix);

                        } else {

                            $(this).parent().parent().parent().height(heightFix * 2);

                        }
                        ;

                    });

                    var heightFix = 410;
                    $('.big').height(heightFix);
                    $('.little').height(heightFix);


                    $('.big').height(heightFix);
                    $('.little').height(heightFix);
                    $('.middle').height(heightFix);
                    $('.large').height(heightFix);
                    $('.half').height(heightFix / parseInt(2));

                });

            }
        }

        wrapperHeightAuto();

        $(window).resize(function () {

            $('.wrapper').removeClass('big little').removeAttr('style');
            $('.big .little .middle .large .half').removeAttr('style');
            wrapperHeightAuto();
        });


    });
}(jQuery));
