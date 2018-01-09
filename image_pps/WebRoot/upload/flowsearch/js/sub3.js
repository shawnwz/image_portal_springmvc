 (function ( $ ) {
jQuery(document).ready(function() {

	// CALCUL OF HEIGHT & WIDTH

	var heightWindow = $(window).height();
	var heightTopBar = 198;
	var heightTotal = (heightWindow - heightTopBar);

	$('.image_slide').height(heightTotal);
	$('.image_slide_content').height(heightTotal);
	$('.image_slide_content ul').height(heightTotal);
	$('.image_slide_content ul li').height(heightTotal);
	$('.image_slide_content ul li img').height(heightTotal);
	$('.aside').height(heightTotal);
	$('.collection').height(heightTotal);

	var width = 0;

	$('.image_slide ul li').each(function() {
	 width += $(this).outerWidth();
	});

	var liCarrousel = $('.thumb').outerWidth();
 	var thumbWidth = 0;

	$('.thumb li').each(function() {
	 thumbWidth += $(this).outerWidth();
	});

	var endWidth = $('.image_slide ul li:last-child').outerWidth();
	var totalWidth = width + endWidth;

	$('.image_slide ul').outerWidth(totalWidth);

	var endThumbWidth = $('.thumb li:last-child').outerWidth();
	var totalThumbWidth = thumbWidth * thumbWidth; 

	$('.thumb').width(totalThumbWidth);
	$('.image_slide_content ul').width(totalThumbWidth);

	jQuery.fn.extend({
	    toggleText: function (a, b){
	        var that = this;
	            if (that.text() != a && that.text() != b){
	                that.text(a);
	            }
	            else
	            if (that.text() == a){
	                that.text(b);
	            }
	            else
	            if (that.text() == b){
	                that.text(a);
	            }
	        return this;
	    }
	});

	$('.button_collection_details').click(function(){
		$('#toggleButton').toggleText('更多专题', '关闭专题');
	});

	 $('.button_collection_details').click(function(){
	 	$('.collection').toggleClass('top_none');
	 	$('.buttonSpan').toggleClass('active_span');
	 });

	 $('.info_picture_button').click(function(){
	 	$(this).children(['span']).toggleText('+', '-');
	 	$('.info_top').toggleClass('info_top_none');
	 	$('.info_top').css('opacity', '1');
	 });

	 // SLIDER

	var nthChild = 0;
	var count = 0;
	var prevPhotoWidth = 0;
	var liLength = $('.image_slide_content ul li').length;
	var numberClick = liLength - 1;
	var infoPicture = 1;
	var thumbActive = 0;
	var widthAlignCarrousel = $('.align_carousel').width();
	var previousWidthThumb = 0;
	var totalWidthThumb = 0;
	var itemPhoto = 0;
	var countThumb = 0;
	var widthLiValue = 0;

	var countCarrousel = nthChild;
	nthChild = countCarrousel;

	var wichLi = 0;
 	var wichLiLength = 0;

 	var countThumb = 0;
 	var wichThumb = 0;
 	var prevThumb = 0;


	$(".thumb li").click(function() {

		$('.info_top').css('opacity', '1');

		$('.collection').removeClass('top_none');
	 	$('.buttonSpan').removeClass('active_span');

		$('.thumb li img').removeClass('active_thumb');

		$('.image_slide_content ul li').removeAttr('id', 'active');
		$('.thumb li').removeAttr('id', 'active_thumb');

	    var wichLi = ($(this).prevAll().length+1);
	    var wichLiWidth = $('.thumb li:nth-child(' + wichLi +')').outerWidth();
	    $('.image_slide_content ul li:nth-child(' + wichLi + ')').attr('id', 'active'); 

	    $('.aside ul.info_picture li').css('opacity', '0');
	    $('.aside ul.info_picture li:nth-child(' + wichLi + ')').css('opacity', '1');

		var array = $('.image_slide_content ul li');
		var element = $('#active');
		var indexElement = array.index(element);
		var widthIndex = 0;

		var widthLiValue = 0;
		for(var i = 0; i < indexElement; i++){
			widthLiValue += $(array[i]).width() + 4;
		}

		$('.image_slide_content').css('right', widthLiValue  + 'px');

		$('.thumb li:nth-child(' + wichLi + ') img').addClass('active_thumb');

		$('.thumb li:nth-child(' + wichLi + ')').attr('id', 'active_thumb'); 

		var arrayThumb = $('.thumb li');
		var elementThumb = $('#active_thumb');
		var indexThumb = arrayThumb.index(elementThumb);
		var widthIndexThumb = 0;

		var widthLiValueThumb = 0;
		var wichLiOpacity = 0;
		for(var i = 0; i < indexThumb; i++){
			wichLiOpacity = $(arrayThumb[i]).length +2;
			widthLiValueThumb += $(arrayThumb[i]).outerWidth() -4;
		}


		$('.thumb').css('right', widthLiValueThumb +'px');

		countThumb = widthIndexThumb;

		console.log(wichLiOpacity);


		nthChild = wichLi - 1;
		infoPicture = wichLi;
		prevPhotoWidth = widthLiValue + itemPhoto;
		countThumb = wichLi;
		fullThumbCount = widthLiValueThumb + wichLiWidth;

		$('.image_slide_content li').css('opacity', '.5');
		$('#active').css('opacity', '1');

		if (wichLiOpacity !=0){
 				$('.asideLeft').removeClass('unactiveButton');
 			}else{
 				$('.asideLeft').addClass('unactiveButton');
 			};

 			if (wichLiOpacity != liLength - 1){
 				$('.asideRight').removeClass('unactiveButton');
 			}else{
 				$('.asideRight').addClass('unactiveButton');
 			};


	});

 	$('.image_slide_content li').css('opacity', '.5');
 	$('.image_slide_content li:first-child').css('opacity', '1');

 	var countMobile = 0;
 	var mobileLenghtLi = $('.image_slide_content li').length;


 	if($(window).width() < 991){

		 	var heightWindow = $(window).height();
			var heightTopBar = 198;
			var heightTotal = $('.image_slide_content ul li').outerHeight();

			$('.image_slide').height(heightTotal);
			$('.image_slide_content').height(heightTotal);
			$('.image_slide_content ul').height(heightTotal);
			$('.image_slide_content ul li').height(heightTotal);
			$('.image_slide_content ul li img').height(heightTotal);



			var windowWidth = $(window).width();
			$('.image_slide_content ul').css('width', windowWidth*mobileLenghtLi+'px');
			$('.image_slide_content li').css('width', windowWidth+'px');
			$('.image_slide_content li').css('height', '100%');
			$('.image_slide_content li img').css('height', '100%');
			
			var countMobile = 0;
			var widthMobileUl = 0;

			wichLiLength = 1;
			var countdown = $('.image_slide_content li').length;
			$('.countMobileLi').text(countdown);

			$('.image_slide_content li').css('opacity', '1');

				$('.asideRight').click(function(){

					if (countMobile < mobileLenghtLi - 1) {
						countMobile ++;
						widthMobileUl = windowWidth*countMobile;

						$('.image_slide_content').css('right', widthMobileUl +'px');

						if (countMobile !=0){
							$('.asideLeft').removeClass('unactiveButton');
						}else{
							$('.asideLeft').addClass('unactiveButton');
						};
						if (countMobile != mobileLenghtLi -1){
							$('.asideRight').removeClass('unactiveButton');
						}else{
							$('.asideRight').addClass('unactiveButton');
						};

						wichLiLength ++;
						$('.activeMobileLi').text(wichLiLength);


					 };
				});
 	}else{

	 	$('.asideRight').click(function(){

			if (nthChild < numberClick) {

				$('.info_top').css('opacity', '1');

				$('.collection').removeClass('top_none');
		 		$('.buttonSpan').removeClass('active_span');

				var opacityActive = 0;
				var nextLiThumb = 0;
				var countThumbMore = 0;
				var totalCountThumbMore = 0;

				nthChild ++;
				var itemPhoto = $('.image_slide_content ul li:nth-child(' + nthChild + ')').outerWidth();
				var count = itemPhoto + prevPhotoWidth;

				$('.image_slide_content').css('right', count  + 'px');
				prevPhotoWidth = count + 4; // '4' = Size of margin

				infoPicture ++; 
				var opacityUnactive = infoPicture - 1;

				$('.aside ul.info_picture li:nth-child(' + infoPicture + ')').css('opacity', '1');
				$('.aside ul.info_picture li:nth-child(' + opacityUnactive + ')').css('opacity', '0');

				var thumbActive = nthChild +1;

				$('.thumb li img').removeClass('active_thumb');

				$('.thumb li:nth-child(' + thumbActive + ') img').addClass('active_thumb');
				$('.thumb li:nth-child(' + nthChild + ') img').removeClass('active_thumb');

				$('.thumb li').removeAttr('id', 'active_thumb');

				var nthChildPlus = nthChild +1;

				$('.thumb li:nth-child(' + nthChildPlus + ')').attr('id', 'active_thumb'); 

				var arrayThumb = $('.thumb li');
				var elementThumb = $('#active_thumb');
				var indexThumb = arrayThumb.index(elementThumb);
				var widthIndexThumb = 0;

				var widthLiValueThumb = 0;
				for(var i = 0; i < indexThumb; i++){
					widthLiValueThumb += $(arrayThumb[i]).outerWidth() - 4;
				}


				$('.thumb').css('right', widthLiValueThumb +'px');

				countThumb = nthChild;
				fullThumbCount = widthLiValueThumb;


	 			if (nthChild !=0){
	 				$('.asideLeft').removeClass('unactiveButton');
	 			}else{
	 				$('.asideLeft').addClass('unactiveButton');
	 			};

	 			if (nthChild != liLength - 1){
	 				$('.asideRight').removeClass('unactiveButton');
	 			}else{
	 				$('.asideRight').addClass('unactiveButton');
	 			};

	 			var nthChildPlus = nthChild +1;

	 			$('.image_slide_content li').css('opacity', '.5');
				$('.image_slide_content li:nth-child(' + nthChildPlus + ')').css('opacity', '1');


			}


		});

 	};


	var widthPreviousSlide = 0;
	var previousNthChild = 0;
	var widthLessSlide = 0;
	var thumbUnactive = 0;

	if($(window).width() < 991){

		var mobileLenghtLi = $('.image_slide_content li').length;
		var windowWidth = $(window).width();
		$('.image_slide_content ul').css('width', windowWidth*mobileLenghtLi+'px');
		$('.image_slide_content li').css('width', windowWidth+'px');
		$('.image_slide_content li').css('height', '100%');
		$('.image_slide_content li img').css('height', '100%');

		console.log(windowWidth);
		
		var widthMobileUl = 0;

		$('.image_slide_content li').css('opacity', '1');

		$('.asideLeft').click(function(){

			if (countMobile !=0) {

				countMobile --;
				widthMobileUl = windowWidth*countMobile;

				$('.image_slide_content').css('right', widthMobileUl +'px');

				if (countMobile !=0){
					$('.asideLeft').removeClass('unactiveButton');
				}else{
					$('.asideLeft').addClass('unactiveButton');
				};

				if (countMobile != mobileLenghtLi -1){
					$('.asideRight').removeClass('unactiveButton');
				}else{
					$('.asideRight').addClass('unactiveButton');
				};

				wichLiLength --;

				$('.activeMobileLi').text(wichLiLength);


			};

		});


	}else{

		$('.asideLeft').click(function(left){

			if (nthChild != 0) {

				$('.info_top').css('opacity', '1');

				$('.collection').removeClass('top_none');
		 		$('.buttonSpan').removeClass('active_span');

				nthChild --;
				var previousNthChild = nthChild + 1;

				var widthPreviousSlide = $('.image_slide_content ul li:nth-child(' + previousNthChild + ')').outerWidth();

				var  widthLessSlide = prevPhotoWidth - widthPreviousSlide;

				$('.image_slide_content').css('right', widthLessSlide  + 'px');
				prevPhotoWidth = widthLessSlide - 4 ;

				infoPicture --; 
				var opacityUnactive = infoPicture + 1;

				$('.aside ul.info_picture li:nth-child(' + infoPicture + ')').css('opacity', '1');
				$('.aside ul.info_picture li:nth-child(' + opacityUnactive + ')').css('opacity', '0');

				var thumbActive = nthChild + 1;
				var thumbUnactive = thumbActive - 1;

				$('.thumb li img').removeClass('active_thumb');

				$('.thumb li:nth-child(' + thumbActive + ') img').addClass('active_thumb');
				$('.thumb li:nth-child(' + thumbUnactive + ') img').removeClass('active_thumb');

				var nthChildPlus = nthChild +1;

				$('.thumb li:nth-child(' + nthChildPlus + ')').attr('id', 'active_thumb'); 

				var arrayThumb = $('.thumb li');
				var elementThumb = $('#active_thumb');
				var indexThumb = arrayThumb.index(elementThumb);
				var widthIndexThumb = 0;

				var widthLiValueThumb = 0;
				for(var i = 0; i < indexThumb; i++){
					widthLiValueThumb += $(arrayThumb[i]).outerWidth()-4;
				}


				$('.thumb').css('right', widthLiValueThumb +'px');

				countThumb = nthChild;
				totalWidthThumb = widthLiValueThumb;

				fullThumbCount = widthLiValueThumb + prevWidthThumb;

				if (nthChild !=0){
	 				$('.asideLeft').removeClass('unactiveButton');
	 			}else{
	 				$('.asideLeft').addClass('unactiveButton');
	 			};

	 			if (nthChild != liLength -1){
	 				$('.asideRight').removeClass('unactiveButton');
	 			}else{
	 				$('.asideRight').addClass('unactiveButton');
	 			};

	 			$('.image_slide_content li').css('opacity', '.5');
				$('.image_slide_content li:nth-child(' + nthChildPlus + ')').css('opacity', '1');

			};

		});

	};

	jQuery(document).keyup(function (event) {

	  if (event.keyCode == 39) {

	  	if (nthChild < numberClick) {

	  		$('.info_top').css('opacity', '1');

	  		$('.collection').removeClass('top_none');
	 		$('.buttonSpan').removeClass('active_span');

			var opacityActive = 0;
			var nextLiThumb = 0;
			var countThumbMore = 0;
			var totalCountThumbMore = 0;

			nthChild ++;
			var itemPhoto = $('.image_slide_content ul li:nth-child(' + nthChild + ')').outerWidth();
			var count = itemPhoto + prevPhotoWidth;

			$('.image_slide_content').css('right', count  + 'px');
			prevPhotoWidth = count + 4; // '4' = Size of margin

			infoPicture ++; 
			var opacityUnactive = infoPicture - 1;

			$('.aside ul.info_picture li:nth-child(' + infoPicture + ')').css('opacity', '1');
			$('.aside ul.info_picture li:nth-child(' + opacityUnactive + ')').css('opacity', '0');

			var thumbActive = nthChild +1;

			$('.thumb li img').removeClass('active_thumb');

			$('.thumb li:nth-child(' + thumbActive + ') img').addClass('active_thumb');
			$('.thumb li:nth-child(' + nthChild + ') img').removeClass('active_thumb');

			$('.thumb li').removeAttr('id', 'active_thumb');

			var nthChildPlus = nthChild +1;

			$('.thumb li:nth-child(' + nthChildPlus + ')').attr('id', 'active_thumb'); 

			var arrayThumb = $('.thumb li');
			var elementThumb = $('#active_thumb');
			var indexThumb = arrayThumb.index(elementThumb);
			var widthIndexThumb = 0;

			var widthLiValueThumb = 0;
			for(var i = 0; i < indexThumb; i++){
				widthLiValueThumb += $(arrayThumb[i]).outerWidth() -4;
			}


			$('.thumb').css('right', widthLiValueThumb +'px');

			countThumb = nthChild;
			fullThumbCount = widthLiValueThumb;

			if (nthChild !=0){
 				$('.asideLeft').removeClass('unactiveButton');
 			}else{
 				$('.asideLeft').addClass('unactiveButton');
 			};

 			if (nthChild != liLength -1){
 				$('.asideRight').removeClass('unactiveButton');
 			}else{
 				$('.asideRight').addClass('unactiveButton');
 			};

 			$('.image_slide_content li').css('opacity', '.5');
			$('.image_slide_content li:nth-child(' + nthChildPlus + ')').css('opacity', '1');

			
		};

	     
	  } else if (event.keyCode == 37) {

	     if (nthChild != 0) {

	     	$('.info_top').css('opacity', '1');

	     	$('.collection').removeClass('top_none');
	 		$('.buttonSpan').removeClass('active_span');

			nthChild --;
			var previousNthChild = nthChild + 1;

			var widthPreviousSlide = $('.image_slide_content ul li:nth-child(' + previousNthChild + ')').outerWidth();

			var  widthLessSlide = prevPhotoWidth - widthPreviousSlide;

			$('.image_slide_content').css('right', widthLessSlide  + 'px');
			prevPhotoWidth = widthLessSlide - 4 ;

			infoPicture --; 
			var opacityUnactive = infoPicture + 1;

			$('.aside ul.info_picture li:nth-child(' + infoPicture + ')').css('opacity', '1');
			$('.aside ul.info_picture li:nth-child(' + opacityUnactive + ')').css('opacity', '0');

			var thumbActive = nthChild + 1;
			var thumbUnactive = thumbActive - 1;

			$('.thumb li img').removeClass('active_thumb');

			$('.thumb li:nth-child(' + thumbActive + ') img').addClass('active_thumb');
			$('.thumb li:nth-child(' + thumbUnactive + ') img').removeClass('active_thumb');

			var nthChildPlus = nthChild +1;

			$('.thumb li:nth-child(' + nthChildPlus + ')').attr('id', 'active_thumb'); 

			var arrayThumb = $('.thumb li');
			var elementThumb = $('#active_thumb');
			var indexThumb = arrayThumb.index(elementThumb);
			var widthIndexThumb = 0;

			var widthLiValueThumb = 0;
			for(var i = 0; i < indexThumb; i++){
				widthLiValueThumb += $(arrayThumb[i]).outerWidth() -4;
			}


			$('.thumb').css('right', widthLiValueThumb +'px');

			countThumb = nthChild;
			totalWidthThumb = widthLiValueThumb;

			fullThumbCount = widthLiValue + prevWidthThumb;

			if (nthChild !=0){
 				$('.asideLeft').removeClass('unactiveButton');
 			}else{
 				$('.asideLeft').addClass('unactiveButton');
 			};

 			if (nthChild != liLength -1){
 				$('.asideRight').removeClass('unactiveButton');
 			}else{
 				$('.asideRight').addClass('unactiveButton');
 			};


 			$('.image_slide_content li').css('opacity', '.5');
			$('.image_slide_content li:nth-child(' + nthChildPlus + ')').css('opacity', '1');

		};

	  }

	});



	var prevWidthThumb = 0;
	var fullThumbCount = 0;

 	$('.carrouselRight').click(function(){

 		if (countThumb < numberClick) {

 			countThumb ++;

	 		prevWidthThumb = $('.thumb li:nth-child('+ countThumb +')').outerWidth();
	 		totalWidthThumb = prevWidthThumb + fullThumbCount;

	 		$('.thumb').css('right', totalWidthThumb +'px');
	 		fullThumbCount = totalWidthThumb;

	 	};

 	});

 	countThumbPlus = 0;

 	$('.carrouselLeft').click(function(){

 		if (countThumb != 0) {

 			countThumb --;
	 		countThumbPlus = countThumb +1;

	 		prevWidthThumb = $('.thumb li:nth-child('+ countThumbPlus +')').outerWidth();
	 		totalWidthThumb = fullThumbCount - prevWidthThumb ;

	 		$('.thumb').css('right', totalWidthThumb +'px');
	 		fullThumbCount = totalWidthThumb;

 		};

 	});

	$('.thumb li').mouseover(function(){

		wichLiLength = $('.thumb li').length;
		var countdown = $('.thumb li').index( this ) +1;

		$(this).children().css('display', 'block');
		$('.thumb li p span').text(countdown);
		$('.thumb li p span.length').text(wichLiLength);

	});

	$('.thumb li').mouseout(function(){

		$('.thumb li p').css('display', 'none');
	});

	$('.mobileCollection').click(function(){

		$(this).toggleClass('activeButtonMobileCollection');
		$('.collection').toggleClass('activeButtonMobileCollection');
		$('.mobileDetails').removeClass('activeButtonMobileCollection');
		$('.mobileInfo').removeClass('activeButtonMobileCollection');

	});

	$('.mobileDetails').click(function(){

		$(this).toggleClass('activeButtonMobileCollection');
		$('.mobileInfo').toggleClass('activeButtonMobileCollection');
		$('.mobileCollection').removeClass('activeButtonMobileCollection');
		$('.collection').removeClass('activeButtonMobileCollection');

	});

	// END SLIDER 



	// SCROLL 

	$(function() {
		$("#scroller").simplyScroll({
			customClass: 'vert',
			orientation: 'vertical',
            auto: false,
            manualMode: 'end',
			frameRate:24,
			speed:10
		});
	});





});
}( jQuery ));
