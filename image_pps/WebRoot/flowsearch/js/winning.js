$(document).ready(function(){
	$("#close_win").click(function(){
		$("#winning").animate({width:"0"},1000);
		$("#winning").animate({paddingBottom:"0"});
		$("#winning").css("display","none");
	});
});

function yourmethod() {
	window.location.href="lottery"	
}


$(window).resize(function(){
	if (window.innerWidth <= 1200){
	    $("#winning").css("display","none");	
	}
});
