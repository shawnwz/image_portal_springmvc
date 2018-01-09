$(document).ready(function(){
	$(".qqicon2").hide();
	$(".btnPageqq").mouseover(function(){
		$(".qqicon1").hide();
		$(".qqicon2").show();
	});
	$(".btnPageqq").mouseout(function(){
		$(".qqicon2").hide();
		$(".qqicon1").show();
	});
});

