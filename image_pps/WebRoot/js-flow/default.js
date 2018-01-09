(function ( $ ) {
jQuery(document).ready(function() {

console.log();


	$("a").each(function(index) {
		if($(this).attr('href')=='#')
		{
			 $(this).attr('href','javascript:void(0)');
		}
	});

		
	
	if($(".bannerWrap").length)
	{
		$(".bannerWrap").rotateBanner();
	}


	
	$('.collapse').click(function(){
		if($('#navLeft').hasClass('expand'))
		{
			$('#navLeft').removeClass('expand');
		}else
		{
			$('#navLeft').addClass('expand');
		}
	})
	
	
	$('.searchBar').focusin(function() {
		$(this).addClass('focused');
	})
	.focusout(function() {
		$(this).removeClass('focused');
	});
	
	if( $('#carousel-homeNews .item').length == 1)
	{
		$('#carousel-homeNews .carousel-control').hide();
		
	}
	
	
	
	
	
	$('#homeBanner .btnPageDown').click(function(){
		
		$('body,html').animate({scrollTop:$('#homeBanner').innerHeight() + $('#topBar').innerHeight()},500); 
		
	})
	
	
	if( $('.galleryWrap').length > 0)
	{
		
		var $container = $('.galleryWrap').masonry({
			itemSelector : '.galleryWrap .galleryThumb'
		});
		
		$container.imagesLoaded( function() {
		  $container.masonry();
		});
	
		$('.galleryWrap').infinitescroll({
	
			navSelector  	: "#loadMore:last",
			nextSelector 	: "a#loadMore:last",
			itemSelector 	: ".galleryWrap .galleryThumb",
			behavior: 'local',
	 
			debug		 	: true,
			dataType	 	: 'html',
			maxPage         : 3,
			path: function(index) {
				return "gallery" + index + ".html";
			}
	
		}, function(newElements, data, url){
			
			var $newElems = $( newElements );
			$container.masonry( 'appended', $newElems )
		});

	
	}
	
	
	
	
	
	
	
});
}( jQuery ));








//