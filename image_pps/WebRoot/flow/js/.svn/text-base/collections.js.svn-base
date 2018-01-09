// JavaScript Document

$(document).ready(function() {


$('ul.leftNav li').click(function(){

	if($(this).hasClass('active'))
	{
		$(this).removeClass('active');
		$(this).find('ul').slideUp();
	}else
	{
			$(this).addClass('active');
			$(this).find('ul').slideDown();
	}
	
});


$('.btnFlip').hover(function(){
	
	$(this).find('img').attr('src','');
	var randomNum=Math.random();
	$(this).find('img').attr('src','images/collections/btnRightHover.gif?'+randomNum);
	
},function(){

	$(this).find('img').attr('src','images/collections/btnRight.gif');
}


)


//test if support 3d
getPerspective();
 function getPerspective(){
  var element = document.createElement('p'),
      html = document.getElementsByTagName('HTML')[0],
      body = document.getElementsByTagName('BODY')[0],
      propertys = {
        'webkitTransformStyle':'-webkit-transform-style',
        'MozTransformStyle':'-moz-transform-style',
        'msTransformStyle':'-ms-transform-style',
        'transformStyle':'transform-style'
      };

    body.insertBefore(element, null);

    for (var i in propertys) {
        if (element.style[i] !== undefined) {
            element.style[i] = "preserve-3d";
        }
    }

		if(!window.getComputedStyle) {
			 html.className += 'no-preserve-3d';
 
		}else
		{
		
			var st = window.getComputedStyle(element, null),
					transform = st.getPropertyValue("-webkit-transform-style") ||
											st.getPropertyValue("-moz-transform-style") ||
											st.getPropertyValue("-ms-transform-style") ||
											st.getPropertyValue("transform-style");
	
			if(transform!=='preserve-3d'){
				html.className += 'no-preserve-3d';
			}else
			{
				html.className += 'preserve-3d';
			}
			
		}

    document.body.removeChild(element);

} 

 


$.fn.rotateAll = function(_index,_rotate,_offset) {

		var index=_index;
		var rotate=_rotate;
		var total=this.find('a').length;
 
		var $self=this;
 		 
		this.find('a').hide();
		this.find('a').eq((index+_offset-1)%total).show();
		this.find('a').eq((index+_offset)%total).show();

		
		
		if($('html').hasClass('preserve-3d'))
		{
			this.css('transform',' rotateX('+rotate+'deg)');
			
			
			$self.find('a').eq((index+_offset)%total).attr('class','');
			$self.find('a').eq((index+_offset-1)%total).addClass('page'+(index-1)%4);
			$self.find('a').eq((index+_offset)%total).addClass('page'+(index)%4);
 
		}else
		{
			 $self.find('a').eq((index+_offset-1)%total).css({'left':'0px','right':'auto','width':'100%'}).stop().animate({'width':'0px'});
			 $self.find('a').eq((index+_offset)%total).css({'right':'0px','left':'auto','width':'0px'}).stop().animate({'width':'100%'});
		}
};

$.fn.rotateInit = function(_index,_rotate,_offset) {
	this.find('a').hide();
	this.each(function(){
		
		$(this).find('a').eq(_index+_offset).show();
		if($('html').hasClass('preserve-3d'))
		{	
			$(this).find('a').attr('class','');
			$(this).css('transform',' rotateX('+_rotate+'deg)');
			//$(this).find('a').eq((_index)%5).addClass('page'+(_index)%4);
			
		}else
		{
			$(this).find('a').eq(_index+_offset).css({'left':0,'width':'100%'});
		}
	})
	
}

$('.collectionWrap .cubeInner').rotateInit(0,0,0);

$('.btnFlip').each(function(){
	$(this).attr({'indexMark':0,'rotateMark':0});
})

$(document).on('click','.btnFlip', function(){
		var $parentRoot=$(this).parents('.collectionWrap');
 
		var index =parseInt($(this).attr('indexMark'));
		
		var rotate =parseInt($(this).attr('rotateMark'));
 		index++;
		rotate+=90;
		$(this).attr({'indexMark':index,'rotateMark':rotate});
		$parentRoot.find('.cubeInner').each(function(i){
			
			var $self=$(this);
			setTimeout(function(){
				$self.rotateAll(index,rotate,0)	
			},i*50);
 
		});
});




//$('.reasonWrap').find('.cubeInner').rotateInit(0,0,0);



$('.stepWrap .step').click(function(){
	
	$(this).parents('.reasonWrap').find('.cubeOuter').stop().fadeIn();	
	
	var $parentRoot=$(this).parents('.reasonWrap');
	var offset = $(this).parents('.stepWrap').find('.step').index($(this));
//	var rotate = (90)*(index);
 
	$parentRoot.find('.cubeInner').rotateInit(0,0,offset);
	$parentRoot.attr({'indexMark':0,'rotateMark':0,'offsetMark':offset});

})

$('.reasonWrap .btnFlipNext').click(function(){
	
		var $parentRoot=$(this).parents('.reasonWrap');
		var index =parseInt($parentRoot.attr('indexMark'));
		var rotate =parseInt($parentRoot.attr('rotateMark'));
		var offset =parseInt($parentRoot.attr('offsetMark'));
		
		
		index++;
		
		//$parentRoot.css('transform',' rotateX('+rotate+'deg)');
		
		rotate+=90;
		
		$parentRoot.find('.cubeInner').rotateAll(index,rotate,offset);
		$parentRoot.attr({'indexMark':index,'rotateMark':rotate});
	
})






$('.reasonWrap .btnFlipClose').click(function(){
	$(this).parents('.cubeOuter').stop().fadeOut(300,function(){
		
		$('.reasonWrap .cubeInner').css('transform',' rotateX('+0+'deg)');	
	});
	
	
	
	
})





$('.registerWrap .inputWrap input').focusin(function() {
	$(this).parents('.inputWrap').addClass('active');
});


$('.registerWrap .inputWrap input').focusout(function() {
	$(this).parents('.inputWrap').removeClass('active');
});











});