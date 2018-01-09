(function( $ ) {
$.fn.rotateBanner = function() {
/*	
	bannerWrap
	bannerTitleWrap
	bannerImgWrap bannerImg 
	bannerRight
	bannerThumb*/
	var isMobile;
	if( /Android|iPhone|iPad|iPod|webOS|IEMobile|Windows Phone|Opera Mini|BlackBerry/i.test(navigator.userAgent || navigator.vendor || window.opera) )
	{
		isMobile=true;
	}
	
	
	
	var homeBannerIndex=0;
	var bannerTotal=$(".bannerImg").length;
	var intervalTime=6000;
	var fadeTime=1500;

	showImg(homeBannerIndex);
	
	if(bannerTotal > 1 && !isMobile)
	{
		homeBannerInit();
	}
	
	function homeBannerInit()
	{
		 var bannerThumbStr="";
		 for(i=0; i<bannerTotal; i++)
		 {
			 bannerThumbStr+="<span class='bannerThumb'></span>"; 
		 }
		 $(".bannerThumbWrap").html(bannerThumbStr);
		 $(".bannerThumb").eq(0).addClass("active");
		 
		 if($(".bannerWrap").hasClass("autoRotate"))
		 { 
			 window.autoRotateInt = setInterval(autoRotate, intervalTime);
		 }
		 //$(".bannerWrap .bannerLeft, .bannerWrap .bannerRight, .bannerWrap .bannerExpand").show();
	}
	 
	function autoRotate()
	{
		hideImg(homeBannerIndex);
		homeBannerIndex++;
		homeBannerIndex = homeBannerIndex % bannerTotal;
		showImg(homeBannerIndex);
	}
	 
	function hideImg(preIndex)
	{
		$(".bannerImg").eq(preIndex).stop(true,true).fadeOut(fadeTime);
		$(".bannerImg").eq(preIndex).css({'position':'absolute'});
		$(".bannerThumb").eq(preIndex).removeClass("active");
	}
	
	function showImg(nextIndex)
	{
		$(".bannerImg").eq(nextIndex).stop(true,true).fadeIn(fadeTime);
		$(".bannerImg").eq(nextIndex).css({'position':'relative'});
		$(".bannerThumb").eq(nextIndex).addClass("active");
	}
	
	$(".bannerThumb").click(function()
	{	
		if($(this).hasClass('active'))
		{
			return false;
		}
		clearInterval(window.autoRotateInt);
		hideImg(homeBannerIndex);
		homeBannerIndex=$(".bannerThumb").index(this);
		showImg(homeBannerIndex);
		
		if($(".bannerWrap").hasClass("autoRotate"))
		{ 
			window.autoRotateInt = setInterval(autoRotate, intervalTime);
		}
	});
	

		
};
}( jQuery ));


