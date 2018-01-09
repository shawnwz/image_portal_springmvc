(function ( $ ) {
jQuery(document).ready(function() {

if($('.pageDetail').length>0){

    //  类似图片 切换
    function myTab(leftBtn,rightBtn){
        var oLi=$('.mySlideShowDiv li:first');
        var targetWidth=parseInt(oLi.css('width'));
        var count=0;
        $(leftBtn).click(function(){
            var aLi=$(this).parent().prev().find('li');
            count++;
            if(count>=aLi.length){
                count=0;
            }
            $(this).parent().prev().find('ul').animate({marginLeft:targetWidth*-count+'px'});
        });
        $(rightBtn).click(function(){

            var aLi=$(this).parent().prev().find('li');
            count--;
            if(count<0){
                count=aLi.length-1;
            }
            $(this).parent().prev().find('ul').animate({marginLeft:targetWidth*-count+'px'});
        });
    }

    myTab('#myTabLeft1',"#myTabRight1");
    myTab('#myTabLeft2',"#myTabRight2");


    $("input[type='radio'][name='cm']").on('ifChecked', function(event){
        var idx=$("input[type='radio'][name='cm']").index(this);
        $("input[type='radio'][name='px']").eq(idx).iCheck('check');
    });
    $("input[type='radio'][name='px']").on('ifChecked', function(event){
        var idx=$("input[type='radio'][name='px']").index(this);
        $("input[type='radio'][name='cm']").eq(idx).iCheck('check');
    });





    // 查看更多 展开、收缩
    $('.viewMore').toggle(function(){
        $(this).removeClass('viewMore').addClass('viewMoreUp').text('关闭');
        $(this).find('.viewDown').addClass('viewUp').removeClass('viewDown');
        $('.moreDesc').stop('true','true').slideDown();
    },function(){
        $(this).removeClass('viewMoreUp').addClass('viewMore').text('查看更多');
        $(this).find('.viewUp').addClass('viewDown').removeClass('viewUp');
        $('.moreDesc').stop('true','true').slideUp();
    });

    // 联系我们 popup
    $('.dialog').jqm();


	
	if( $('.galleryWrap').length > 0)
	{
		var $container = $('.galleryWrap').masonry({
			itemSelector : '.galleryWrap .galleryThumb'
		});
		
		$container.imagesLoaded( function() {
		  $container.masonry();
		});
	}


    $('a').tooltip();




}

	
});
}( jQuery ));